package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0188a;
import com.google.ads.internal.C0193b;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0213k;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import java.util.HashSet;
import java.util.Set;

public class AdView extends RelativeLayout implements C0121Ad {

    /* renamed from: b */
    private static final C0188a f44b = C0188a.f402a.mo3153b();

    /* renamed from: a */
    protected C0203d f45a;

    public AdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity.getApplicationContext());
        try {
            m24a((Context) activity, adSize, (AttributeSet) null);
            m28b(activity, adSize, (AttributeSet) null);
            m20a(activity, adSize, adUnitId);
        } catch (C0193b e) {
            m22a((Context) activity, e.mo3156c("Could not initialize AdView"), adSize, (AttributeSet) null);
            e.mo3154a("Could not initialize AdView");
        }
    }

    protected AdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        this(activity, new AdSize(0, 0), adUnitId);
        m23a(adSizes);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m21a(context, attrs);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2975a(Context context, String str, int i, AdSize adSize, AttributeSet attributeSet) {
        if (adSize == null) {
            adSize = AdSize.BANNER;
        }
        AdSize createAdSize = AdSize.createAdSize(adSize, context.getApplicationContext());
        if (getChildCount() == 0) {
            TextView textView = attributeSet == null ? new TextView(context) : new TextView(context, attributeSet);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            LinearLayout linearLayout = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout.setGravity(17);
            LinearLayout linearLayout2 = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(i);
            int a = AdUtil.m437a(context, createAdSize.getWidth());
            int a2 = AdUtil.m437a(context, createAdSize.getHeight());
            linearLayout.addView(textView, a - 2, a2 - 2);
            linearLayout2.addView(linearLayout);
            addView(linearLayout2, a, a2);
        }
    }

    /* renamed from: a */
    private boolean m24a(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m461c(context)) {
            return true;
        }
        m22a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", adSize, attributeSet);
        return false;
    }

    /* renamed from: b */
    private boolean m28b(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m459b(context)) {
            return true;
        }
        m22a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", adSize, attributeSet);
        return false;
    }

    public void destroy() {
        this.f45a.mo3207b();
    }

    /* renamed from: a */
    private void m22a(Context context, String str, AdSize adSize, AttributeSet attributeSet) {
        C0240b.m484b(str);
        mo2975a(context, str, SupportMenu.CATEGORY_MASK, adSize, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AdSize[] mo2976a(String str) {
        AdSize adSize;
        String[] split = str.split(",");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    adSize = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    return null;
                }
            } else {
                adSize = "BANNER".equals(trim) ? AdSize.BANNER : "SMART_BANNER".equals(trim) ? AdSize.SMART_BANNER : "IAB_MRECT".equals(trim) ? AdSize.IAB_MRECT : "IAB_BANNER".equals(trim) ? AdSize.IAB_BANNER : "IAB_LEADERBOARD".equals(trim) ? AdSize.IAB_LEADERBOARD : "IAB_WIDE_SKYSCRAPER".equals(trim) ? AdSize.IAB_WIDE_SKYSCRAPER : null;
            }
            if (adSize == null) {
                return null;
            }
            adSizeArr[i] = adSize;
        }
        return adSizeArr;
    }

    /* renamed from: a */
    private void m21a(Context context, AttributeSet attributeSet) {
        AdSize[] adSizeArr;
        C0193b bVar;
        if (attributeSet != null) {
            try {
                String b = m27b("adSize", context, attributeSet, true);
                AdSize[] a = mo2976a(b);
                if (a != null) {
                    try {
                        if (a.length != 0) {
                            if (!m26a("adUnitId", attributeSet)) {
                                throw new C0193b("Required XML attribute \"adUnitId\" missing", true);
                            } else if (isInEditMode()) {
                                mo2975a(context, "Ads by Google", -1, a[0], attributeSet);
                                return;
                            } else {
                                String b2 = m27b("adUnitId", context, attributeSet, true);
                                boolean a2 = m25a("loadAdOnCreate", context, attributeSet, false);
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    m24a((Context) activity, a[0], attributeSet);
                                    m28b(activity, a[0], attributeSet);
                                    if (a.length == 1) {
                                        m20a(activity, a[0], b2);
                                    } else {
                                        m20a(activity, new AdSize(0, 0), b2);
                                        m23a(a);
                                    }
                                    if (a2) {
                                        Set<String> c = m29c("testDevices", context, attributeSet, false);
                                        if (c.contains("TEST_EMULATOR")) {
                                            c.remove("TEST_EMULATOR");
                                            c.add(AdRequest.TEST_EMULATOR);
                                        }
                                        loadAd(new AdRequest().setTestDevices(c).setKeywords(m29c("keywords", context, attributeSet, false)));
                                        return;
                                    }
                                    return;
                                }
                                throw new C0193b("AdView was initialized with a Context that wasn't an Activity.", true);
                            }
                        }
                    } catch (C0193b e) {
                        bVar = e;
                        adSizeArr = a;
                        m22a(context, bVar.mo3156c("Could not initialize AdView"), (adSizeArr == null || adSizeArr.length <= 0) ? AdSize.BANNER : adSizeArr[0], attributeSet);
                        bVar.mo3154a("Could not initialize AdView");
                        if (!isInEditMode()) {
                            bVar.mo3155b("Could not initialize AdView");
                            return;
                        }
                        return;
                    }
                }
                throw new C0193b("Attribute \"adSize\" invalid: " + b, true);
            } catch (C0193b e2) {
                C0193b bVar2 = e2;
                adSizeArr = null;
                bVar = bVar2;
            }
        }
    }

    /* renamed from: a */
    private boolean m25a(String str, Context context, AttributeSet attributeSet, boolean z) throws C0193b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", str, z);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@bool/")) {
                String substring = attributeValue.substring("@bool/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":bool/" + substring, typedValue, true);
                    if (typedValue.type == 18) {
                        return typedValue.data != 0;
                    }
                    throw new C0193b("Resource " + str + " was not a boolean: " + typedValue, true);
                } catch (Resources.NotFoundException e) {
                    throw new C0193b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        return attributeBooleanValue;
    }

    /* renamed from: b */
    private String m27b(String str, Context context, AttributeSet attributeSet, boolean z) throws C0193b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@string/")) {
                String substring = attributeValue.substring("@string/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":string/" + substring, typedValue, true);
                    if (typedValue.string != null) {
                        attributeValue = typedValue.string.toString();
                    } else {
                        throw new C0193b("Resource " + str + " was not a string: " + typedValue, true);
                    }
                } catch (Resources.NotFoundException e) {
                    throw new C0193b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        if (!z || attributeValue != null) {
            return attributeValue;
        }
        throw new C0193b("Required XML attribute \"" + str + "\" missing", true);
    }

    /* renamed from: c */
    private Set<String> m29c(String str, Context context, AttributeSet attributeSet, boolean z) throws C0193b {
        String b = m27b(str, context, attributeSet, z);
        HashSet hashSet = new HashSet();
        if (b != null) {
            for (String trim : b.split(",")) {
                String trim2 = trim.trim();
                if (trim2.length() != 0) {
                    hashSet.add(trim2);
                }
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    private boolean m26a(String str, AttributeSet attributeSet) {
        return attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str) != null;
    }

    /* renamed from: a */
    private void m20a(Activity activity, AdSize adSize, String str) throws C0193b {
        FrameLayout frameLayout = new FrameLayout(activity);
        frameLayout.setFocusable(false);
        this.f45a = new C0203d(this, activity, adSize, str, frameLayout, false);
        setGravity(17);
        try {
            ViewGroup a = C0213k.m408a(activity, this.f45a);
            if (a != null) {
                a.addView(frameLayout, -2, -2);
                addView(a, -2, -2);
                return;
            }
            addView(frameLayout, -2, -2);
        } catch (VerifyError e) {
            C0240b.m481a("Gestures disabled: Not supported on this version of Android.", (Throwable) e);
            addView(frameLayout, -2, -2);
        }
    }

    public boolean isReady() {
        if (this.f45a == null) {
            return false;
        }
        return this.f45a.mo3229s();
    }

    public boolean isRefreshing() {
        if (this.f45a == null) {
            return false;
        }
        return this.f45a.mo3230t();
    }

    public void loadAd(AdRequest adRequest) {
        if (this.f45a != null) {
            if (isRefreshing()) {
                this.f45a.mo3216f();
            }
            this.f45a.mo3199a(adRequest);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f45a.mo3219i().f596o.mo3396a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.f45a.mo3219i().f597p.mo3396a(appEventListener);
    }

    /* access modifiers changed from: protected */
    public void setSwipeableEventListener(SwipeableAdListener swipeableEventListener) {
        this.f45a.mo3219i().f598q.mo3396a(swipeableEventListener);
    }

    /* access modifiers changed from: protected */
    public void setSupportedAdSizes(AdSize... adSizes) {
        if (this.f45a.mo3219i().f595n.mo3395a() == null) {
            C0240b.m490e("Warning: Tried to set supported ad sizes on a single-size AdView. AdSizes ignored. To create a multi-sized AdView, use an AdView constructor that takes in an AdSize[] array.");
        } else {
            m23a(adSizes);
        }
    }

    /* renamed from: a */
    private void m23a(AdSize... adSizeArr) {
        AdSize[] adSizeArr2 = new AdSize[adSizeArr.length];
        for (int i = 0; i < adSizeArr.length; i++) {
            adSizeArr2[i] = AdSize.createAdSize(adSizeArr[i], getContext());
        }
        this.f45a.mo3219i().f595n.mo3396a(adSizeArr2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        AdWebView l;
        if (!isInEditMode() && (l = this.f45a.mo3222l()) != null) {
            l.setVisibility(0);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void stopLoading() {
        if (this.f45a != null) {
            this.f45a.mo3187C();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (!isInEditMode() && this.f45a.mo3219i().f588g.mo3394a().mo3280b() && visibility != 0 && this.f45a.mo3219i().f593l.mo3395a() != null && this.f45a.mo3219i().f586e.mo3394a() != null) {
            if (!AdActivity.isShowing() || AdActivity.leftApplication()) {
                f44b.mo3145a(this.f45a.mo3219i().f586e.mo3394a(), "onleaveapp", (String) null);
            } else {
                f44b.mo3145a(this.f45a.mo3219i().f586e.mo3394a(), "onopeninapp", (String) null);
            }
        }
    }
}
