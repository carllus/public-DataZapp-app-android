package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.proto.Serving;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.CustomFunctionCall;
import com.google.tagmanager.LoadCallback;
import com.google.tagmanager.PreviewManager;
import com.google.tagmanager.ResourceUtil;
import com.google.tagmanager.TagManager;
import com.google.tagmanager.proto.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Container {
    static final boolean ENABLE_CONTAINER_DEBUG_MODE = false;
    @VisibleForTesting
    static final int MAX_NUMBER_OF_TOKENS = 30;
    static final int MINIMUM_REFRESH_PERIOD_BURST_MODE_MS = 5000;
    static final long MINIMUM_REFRESH_PERIOD_MS = 900000;
    static final long REFRESH_PERIOD_ON_FAILURE_MS = 3600000;
    static final long REFRESH_PERIOD_ON_SUCCESS_MS = 43200000;
    private Clock mClock;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private volatile String mCtfeServerAddress;
    private volatile String mCtfeUrlPathAndQuery;
    @VisibleForTesting
    LoadCallback<Resource.ResourceWithMetadata> mDiskLoadCallback;
    private Map<String, FunctionCallMacroHandler> mFunctionCallMacroHandlers;
    private Map<String, FunctionCallTagHandler> mFunctionCallTagHandlers;
    /* access modifiers changed from: private */
    public Serving.SupplementedResource mLastLoadedSupplementedResource;
    private volatile long mLastRefreshMethodCalledTime;
    /* access modifiers changed from: private */
    public volatile long mLastRefreshTime;
    @VisibleForTesting
    LoadCallback<Serving.SupplementedResource> mNetworkLoadCallback;
    private ResourceLoaderScheduler mNetworkLoadScheduler;
    private volatile int mNumTokens;
    private volatile int mResourceFormatVersion;
    private ResourceStorage mResourceStorage;
    private volatile String mResourceVersion;
    private Runtime mRuntime;
    private final TagManager mTagManager;
    private Callback mUserCallback;

    public interface Callback {
        void containerRefreshBegin(Container container, RefreshType refreshType);

        void containerRefreshFailure(Container container, RefreshType refreshType, RefreshFailure refreshFailure);

        void containerRefreshSuccess(Container container, RefreshType refreshType);
    }

    public interface FunctionCallMacroHandler {
        Object getValue(String str, Map<String, Object> map);
    }

    public interface FunctionCallTagHandler {
        void execute(String str, Map<String, Object> map);
    }

    public enum RefreshFailure {
        NO_SAVED_CONTAINER,
        IO_ERROR,
        NO_NETWORK,
        NETWORK_ERROR,
        SERVER_ERROR,
        UNKNOWN_ERROR
    }

    public enum RefreshType {
        SAVED,
        NETWORK
    }

    interface ResourceLoaderScheduler {
        void close();

        void loadAfterDelay(long j, String str);

        void setCtfeURLPathAndQuery(String str);

        void setLoadCallback(LoadCallback<Serving.SupplementedResource> loadCallback);
    }

    interface ResourceStorage {
        void close();

        ResourceUtil.ExpandedResource loadExpandedResourceFromJsonAsset(String str);

        Serving.Resource loadResourceFromContainerAsset(String str);

        void loadResourceFromDiskInBackground();

        void saveResourceToDiskInBackground(Resource.ResourceWithMetadata resourceWithMetadata);

        void setLoadCallback(LoadCallback<Resource.ResourceWithMetadata> loadCallback);
    }

    private class FunctionCallMacroHandlerAdapter implements CustomFunctionCall.CustomEvaluator {
        private FunctionCallMacroHandlerAdapter() {
        }

        public Object evaluate(String key, Map<String, Object> parameters) {
            FunctionCallMacroHandler handler = Container.this.getFunctionCallMacroHandler(key);
            if (handler == null) {
                return null;
            }
            return handler.getValue(key, parameters);
        }
    }

    private class FunctionCallTagHandlerAdapter implements CustomFunctionCall.CustomEvaluator {
        private FunctionCallTagHandlerAdapter() {
        }

        public Object evaluate(String key, Map<String, Object> parameters) {
            Container.this.getFunctionCallTagHandler(key).execute(key, parameters);
            return Types.getDefaultString();
        }
    }

    Container(Context context, String containerId, TagManager tagManager) {
        this(context, containerId, tagManager, new ResourceStorageImpl(context, containerId));
    }

    @VisibleForTesting
    Container(Context context, String containerId, TagManager tagManager, ResourceStorage resourceStorage) {
        this.mResourceVersion = "";
        this.mResourceFormatVersion = 0;
        this.mCtfeHost = new CtfeHost();
        this.mContext = context;
        this.mContainerId = containerId;
        this.mTagManager = tagManager;
        this.mLastLoadedSupplementedResource = new Serving.SupplementedResource();
        this.mResourceStorage = resourceStorage;
        this.mNumTokens = MAX_NUMBER_OF_TOKENS;
        this.mFunctionCallMacroHandlers = new HashMap();
        this.mFunctionCallTagHandlers = new HashMap();
        createInitialContainer();
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    public boolean getBoolean(String key) {
        Runtime runtime = getRuntime();
        if (runtime == null) {
            Log.m542e("getBoolean called for closed container.");
            return Types.getDefaultBoolean().booleanValue();
        }
        try {
            return Types.valueToBoolean(runtime.evaluateMacroReference(key).getObject()).booleanValue();
        } catch (Exception e) {
            Log.m542e("Calling getBoolean() threw an exception: " + e.getMessage() + " Returning default value.");
            return Types.getDefaultBoolean().booleanValue();
        }
    }

    public double getDouble(String key) {
        Runtime runtime = getRuntime();
        if (runtime == null) {
            Log.m542e("getDouble called for closed container.");
            return Types.getDefaultDouble().doubleValue();
        }
        try {
            return Types.valueToDouble(runtime.evaluateMacroReference(key).getObject()).doubleValue();
        } catch (Exception e) {
            Log.m542e("Calling getDouble() threw an exception: " + e.getMessage() + " Returning default value.");
            return Types.getDefaultDouble().doubleValue();
        }
    }

    public long getLong(String key) {
        Runtime runtime = getRuntime();
        if (runtime == null) {
            Log.m542e("getLong called for closed container.");
            return Types.getDefaultInt64().longValue();
        }
        try {
            return Types.valueToInt64(runtime.evaluateMacroReference(key).getObject()).longValue();
        } catch (Exception e) {
            Log.m542e("Calling getLong() threw an exception: " + e.getMessage() + " Returning default value.");
            return Types.getDefaultInt64().longValue();
        }
    }

    public String getString(String key) {
        Runtime runtime = getRuntime();
        if (runtime == null) {
            Log.m542e("getString called for closed container.");
            return Types.getDefaultString();
        }
        try {
            return Types.valueToString(runtime.evaluateMacroReference(key).getObject());
        } catch (Exception e) {
            Log.m542e("Calling getString() threw an exception: " + e.getMessage() + " Returning default value.");
            return Types.getDefaultString();
        }
    }

    public long getLastRefreshTime() {
        return this.mLastRefreshTime;
    }

    public synchronized void refresh() {
        if (getRuntime() == null) {
            Log.m548w("refresh called for closed container");
        } else {
            try {
                if (isDefaultContainerRefreshMode()) {
                    Log.m548w("Container is in DEFAULT_CONTAINER mode. Refresh request is ignored.");
                } else {
                    long currentTime = this.mClock.currentTimeMillis();
                    if (useAvailableToken(currentTime)) {
                        Log.m546v("Container refresh requested");
                        loadAfterDelay(0);
                        this.mLastRefreshMethodCalledTime = currentTime;
                    } else {
                        Log.m546v("Container refresh was called too often. Ignored.");
                    }
                }
            } catch (Exception e) {
                Log.m542e("Calling refresh() throws an exception: " + e.getMessage());
            }
        }
        return;
    }

    public synchronized void close() {
        try {
            if (this.mNetworkLoadScheduler != null) {
                this.mNetworkLoadScheduler.close();
            }
            this.mNetworkLoadScheduler = null;
            if (this.mResourceStorage != null) {
                this.mResourceStorage.close();
            }
            this.mResourceStorage = null;
            this.mUserCallback = null;
            this.mTagManager.removeContainer(this.mContainerId);
        } catch (Exception e) {
            Log.m542e("Calling close() threw an exception: " + e.getMessage());
        }
        this.mRuntime = null;
        return;
    }

    public boolean isDefault() {
        if (getLastRefreshTime() == 0) {
            return true;
        }
        return ENABLE_CONTAINER_DEBUG_MODE;
    }

    /* access modifiers changed from: package-private */
    public void load(Callback callback) {
        load(callback, new ResourceLoaderSchedulerImpl(this.mContext, this.mContainerId, this.mCtfeHost), new Clock() {
            public long currentTimeMillis() {
                return System.currentTimeMillis();
            }
        });
    }

    public synchronized void registerFunctionCallMacroHandler(String customMacroName, FunctionCallMacroHandler customMacroHandler) {
        this.mFunctionCallMacroHandlers.put(customMacroName, customMacroHandler);
    }

    public synchronized FunctionCallMacroHandler getFunctionCallMacroHandler(String customMacroName) {
        return this.mFunctionCallMacroHandlers.get(customMacroName);
    }

    public synchronized void registerFunctionCallTagHandler(String customTagName, FunctionCallTagHandler customTagHandler) {
        this.mFunctionCallTagHandlers.put(customTagName, customTagHandler);
    }

    public synchronized FunctionCallTagHandler getFunctionCallTagHandler(String customTagName) {
        return this.mFunctionCallTagHandlers.get(customTagName);
    }

    /* access modifiers changed from: private */
    public synchronized void callRefreshSuccess(RefreshType refreshType) {
        Log.m546v("calling containerRefreshSuccess(" + refreshType + "): mUserCallback = " + this.mUserCallback);
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshSuccess(this, refreshType);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void callRefreshFailure(RefreshType refreshType, RefreshFailure refreshFailure) {
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshFailure(this, refreshType, refreshFailure);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void callRefreshBegin(RefreshType refreshType) {
        if (this.mUserCallback != null) {
            this.mUserCallback.containerRefreshBegin(this, refreshType);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void evaluateTags(String currentEventName) {
        getRuntime().evaluateTags(currentEventName);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void load(Callback callback, ResourceLoaderScheduler scheduler, final Clock clock) {
        if (this.mDiskLoadCallback != null) {
            throw new RuntimeException("Container already loaded: container ID: " + this.mContainerId);
        }
        this.mClock = clock;
        this.mUserCallback = callback;
        this.mDiskLoadCallback = new LoadCallback<Resource.ResourceWithMetadata>() {
            public void startLoad() {
                Container.this.callRefreshBegin(RefreshType.SAVED);
            }

            public void onSuccess(Resource.ResourceWithMetadata proto) {
                Serving.Resource resource;
                if (Container.this.isDefault()) {
                    if (proto.supplementedResource != null) {
                        resource = proto.supplementedResource.resource;
                        Serving.SupplementedResource unused = Container.this.mLastLoadedSupplementedResource = proto.supplementedResource;
                    } else {
                        resource = proto.resource;
                        Container.this.mLastLoadedSupplementedResource.resource = resource;
                        Container.this.mLastLoadedSupplementedResource.supplemental = null;
                        Container.this.mLastLoadedSupplementedResource.fingerprint = resource.version;
                    }
                    Container.this.initEvaluators(resource);
                    if (Container.this.mLastLoadedSupplementedResource.supplemental != null) {
                        Container.this.setSupplementals(Container.this.mLastLoadedSupplementedResource.supplemental);
                    }
                    Log.m546v("setting refresh time to saved time: " + proto.timeStamp);
                    long unused2 = Container.this.mLastRefreshTime = proto.timeStamp;
                    Container.this.loadAfterDelay(Math.max(0, Math.min(Container.REFRESH_PERIOD_ON_SUCCESS_MS, (Container.this.mLastRefreshTime + Container.REFRESH_PERIOD_ON_SUCCESS_MS) - clock.currentTimeMillis())));
                }
                Container.this.callRefreshSuccess(RefreshType.SAVED);
            }

            public void onFailure(LoadCallback.Failure failure) {
                Container.this.callRefreshFailure(RefreshType.SAVED, failureToRefreshFailure(failure));
                if (Container.this.isDefault()) {
                    Container.this.loadAfterDelay(0);
                }
            }

            private RefreshFailure failureToRefreshFailure(LoadCallback.Failure failure) {
                switch (C02914.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[failure.ordinal()]) {
                    case 1:
                        return RefreshFailure.NO_SAVED_CONTAINER;
                    case 2:
                        return RefreshFailure.IO_ERROR;
                    case 3:
                        return RefreshFailure.SERVER_ERROR;
                    default:
                        return RefreshFailure.UNKNOWN_ERROR;
                }
            }
        };
        if (isDefaultContainerRefreshMode()) {
            Log.m544i("Container is in DEFAULT_CONTAINER mode. Use default container.");
        } else {
            this.mResourceStorage.setLoadCallback(this.mDiskLoadCallback);
            this.mNetworkLoadCallback = new LoadCallback<Serving.SupplementedResource>() {
                public void startLoad() {
                    Container.this.callRefreshBegin(RefreshType.NETWORK);
                }

                public void onSuccess(Serving.SupplementedResource supplementedResource) {
                    synchronized (Container.this) {
                        Serving.Resource resource = supplementedResource.resource;
                        if (resource != null) {
                            Container.this.initEvaluators(resource);
                            Container.this.mLastLoadedSupplementedResource.resource = resource;
                        } else if (Container.this.mLastLoadedSupplementedResource.resource == null) {
                            onFailure(LoadCallback.Failure.SERVER_ERROR);
                            return;
                        }
                        if (supplementedResource.supplemental.length > 0) {
                            Container.this.setSupplementals(supplementedResource.supplemental);
                            Container.this.mLastLoadedSupplementedResource.supplemental = supplementedResource.supplemental;
                        }
                        long unused = Container.this.mLastRefreshTime = clock.currentTimeMillis();
                        Container.this.mLastLoadedSupplementedResource.fingerprint = supplementedResource.fingerprint;
                        if (Container.this.mLastLoadedSupplementedResource.fingerprint.length() == 0) {
                            Container.this.mLastLoadedSupplementedResource.fingerprint = Container.this.mLastLoadedSupplementedResource.resource.version;
                        }
                        Log.m546v("setting refresh time to current time: " + Container.this.mLastRefreshTime);
                        if (!Container.this.isContainerPreview()) {
                            Container.this.saveResourceToDisk(Container.this.mLastLoadedSupplementedResource);
                        }
                        Container.this.loadAfterDelay(Container.REFRESH_PERIOD_ON_SUCCESS_MS);
                        Container.this.callRefreshSuccess(RefreshType.NETWORK);
                    }
                }

                public void onFailure(LoadCallback.Failure failure) {
                    Container.this.loadAfterDelay(Container.REFRESH_PERIOD_ON_FAILURE_MS);
                    Container.this.callRefreshFailure(RefreshType.NETWORK, failureToRefreshFailure(failure));
                }

                private RefreshFailure failureToRefreshFailure(LoadCallback.Failure failure) {
                    switch (C02914.$SwitchMap$com$google$tagmanager$LoadCallback$Failure[failure.ordinal()]) {
                        case 1:
                            return RefreshFailure.NO_NETWORK;
                        case 2:
                            return RefreshFailure.NETWORK_ERROR;
                        case 3:
                            return RefreshFailure.SERVER_ERROR;
                        default:
                            return RefreshFailure.UNKNOWN_ERROR;
                    }
                }
            };
            scheduler.setLoadCallback(this.mNetworkLoadCallback);
            if (isContainerPreview()) {
                this.mCtfeUrlPathAndQuery = PreviewManager.getInstance().getCTFEUrlPath();
                scheduler.setCtfeURLPathAndQuery(this.mCtfeUrlPathAndQuery);
            }
            if (this.mCtfeServerAddress != null) {
                this.mCtfeHost.setCtfeServerAddress(this.mCtfeServerAddress);
            }
            this.mNetworkLoadScheduler = scheduler;
            this.mResourceStorage.loadResourceFromDiskInBackground();
        }
    }

    /* renamed from: com.google.tagmanager.Container$4 */
    static /* synthetic */ class C02914 {
        static final /* synthetic */ int[] $SwitchMap$com$google$tagmanager$LoadCallback$Failure = new int[LoadCallback.Failure.values().length];

        static {
            try {
                $SwitchMap$com$google$tagmanager$LoadCallback$Failure[LoadCallback.Failure.NOT_AVAILABLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$tagmanager$LoadCallback$Failure[LoadCallback.Failure.IO_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$google$tagmanager$LoadCallback$Failure[LoadCallback.Failure.SERVER_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public String getResourceVersion() {
        return this.mResourceVersion;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void loadAfterDelay(long delay) {
        if (this.mNetworkLoadScheduler != null && !isDefaultContainerRefreshMode()) {
            this.mNetworkLoadScheduler.loadAfterDelay(delay, this.mLastLoadedSupplementedResource.fingerprint);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void saveResourceToDisk(Serving.SupplementedResource supplementedResource) {
        if (this.mResourceStorage != null) {
            Resource.ResourceWithMetadata resourceWithMetadata = new Resource.ResourceWithMetadata();
            resourceWithMetadata.timeStamp = getLastRefreshTime();
            resourceWithMetadata.resource = new Serving.Resource();
            resourceWithMetadata.supplementedResource = supplementedResource;
            this.mResourceStorage.saveResourceToDiskInBackground(resourceWithMetadata);
        }
    }

    /* access modifiers changed from: private */
    public void initEvaluators(Serving.Resource resource) {
        try {
            initEvaluatorsWithExpandedResource(ResourceUtil.getExpandedResource(resource));
        } catch (ResourceUtil.InvalidResourceException err) {
            Log.m542e("Not loading resource: " + resource + " because it is invalid: " + err.toString());
        }
    }

    /* access modifiers changed from: private */
    public void setSupplementals(Serving.Supplemental[] supplementals) {
        List<Serving.Supplemental> supplementalList = new ArrayList<>();
        for (Serving.Supplemental supplemental : supplementals) {
            supplementalList.add(supplemental);
        }
        getRuntime().setSupplementals(supplementalList);
    }

    private void initEvaluatorsWithExpandedResource(ResourceUtil.ExpandedResource expandedResource) {
        this.mResourceVersion = expandedResource.getVersion();
        this.mResourceFormatVersion = expandedResource.getResourceFormatVersion();
        ResourceUtil.ExpandedResource expandedResource2 = expandedResource;
        setRuntime(new Runtime(this.mContext, expandedResource2, this.mTagManager.getDataLayer(), new FunctionCallMacroHandlerAdapter(), new FunctionCallTagHandlerAdapter(), createEventInfoDistributor(this.mResourceVersion)));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public EventInfoDistributor createEventInfoDistributor(String resourceVersion) {
        if (PreviewManager.getInstance().getPreviewMode().equals(PreviewManager.PreviewMode.CONTAINER_DEBUG)) {
        }
        return new NoopEventInfoDistributor();
    }

    private synchronized void setRuntime(Runtime runtime) {
        this.mRuntime = runtime;
    }

    private synchronized Runtime getRuntime() {
        return this.mRuntime;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void setCtfeServerAddress(String addr) {
        this.mCtfeServerAddress = addr;
        if (addr != null) {
            this.mCtfeHost.setCtfeServerAddress(addr);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void setCtfeUrlPathAndQuery(String ctfeUrlPathAndQuery) {
        this.mCtfeUrlPathAndQuery = ctfeUrlPathAndQuery;
        if (this.mNetworkLoadScheduler != null) {
            this.mNetworkLoadScheduler.setCtfeURLPathAndQuery(ctfeUrlPathAndQuery);
        }
    }

    /* access modifiers changed from: package-private */
    public String getCtfeUrlPathAndQuery() {
        return this.mCtfeUrlPathAndQuery;
    }

    /* access modifiers changed from: private */
    public boolean isContainerPreview() {
        PreviewManager previewManager = PreviewManager.getInstance();
        if ((previewManager.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER || previewManager.getPreviewMode() == PreviewManager.PreviewMode.CONTAINER_DEBUG) && this.mContainerId.equals(previewManager.getContainerId())) {
            return true;
        }
        return ENABLE_CONTAINER_DEBUG_MODE;
    }

    private void createInitialContainer() {
        String containerFile = "tagmanager/" + this.mContainerId;
        Serving.Resource resource = this.mResourceStorage.loadResourceFromContainerAsset(containerFile);
        if (resource != null) {
            initEvaluators(resource);
            return;
        }
        ResourceUtil.ExpandedResource expandedResource = this.mResourceStorage.loadExpandedResourceFromJsonAsset(containerFile + ".json");
        if (expandedResource == null) {
            Log.m548w("No default container found; creating an empty container.");
            expandedResource = ResourceUtil.ExpandedResource.newBuilder().build();
        }
        initEvaluatorsWithExpandedResource(expandedResource);
    }

    private boolean isDefaultContainerRefreshMode() {
        if (this.mTagManager.getRefreshMode() == TagManager.RefreshMode.DEFAULT_CONTAINER) {
            return true;
        }
        return ENABLE_CONTAINER_DEBUG_MODE;
    }

    private boolean useAvailableToken(long currentTime) {
        if (this.mLastRefreshMethodCalledTime == 0) {
            this.mNumTokens--;
            return true;
        }
        long timeElapsed = currentTime - this.mLastRefreshMethodCalledTime;
        if (timeElapsed < 5000) {
            return ENABLE_CONTAINER_DEBUG_MODE;
        }
        if (this.mNumTokens < MAX_NUMBER_OF_TOKENS) {
            this.mNumTokens = Math.min(MAX_NUMBER_OF_TOKENS, this.mNumTokens + ((int) Math.floor((double) (timeElapsed / MINIMUM_REFRESH_PERIOD_MS))));
        }
        if (this.mNumTokens <= 0) {
            return ENABLE_CONTAINER_DEBUG_MODE;
        }
        this.mNumTokens--;
        return true;
    }
}
