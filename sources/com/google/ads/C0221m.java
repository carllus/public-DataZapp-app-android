package com.google.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.ads.util.C0260i;

/* renamed from: com.google.ads.m */
public class C0221m extends C0260i {

    /* renamed from: d */
    private static final C0221m f542d = new C0221m();

    /* renamed from: a */
    public final C0260i.C0264c<String> f543a = new C0260i.C0264c<>("marketPackages", null);

    /* renamed from: b */
    public final C0260i.C0263b<C0222a> f544b = new C0260i.C0263b<>("constants", new C0222a());

    /* renamed from: c */
    public final C0260i.C0263b<Handler> f545c = new C0260i.C0263b<>("uiHandler", new Handler(Looper.getMainLooper()));

    /* renamed from: com.google.ads.m$a */
    public static final class C0222a extends C0260i {

        /* renamed from: a */
        public final C0260i.C0264c<String> f546a = new C0260i.C0264c<>("ASDomains", null);

        /* renamed from: b */
        public final C0260i.C0264c<Integer> f547b = new C0260i.C0264c<>("minHwAccelerationVersionBanner", 18);

        /* renamed from: c */
        public final C0260i.C0264c<Integer> f548c = new C0260i.C0264c<>("minHwAccelerationVersionOverlay", 18);

        /* renamed from: d */
        public final C0260i.C0264c<Integer> f549d = new C0260i.C0264c<>("minHwAccelerationVersionOverlay", 14);

        /* renamed from: e */
        public final C0260i.C0264c<String> f550e = new C0260i.C0264c<>("mraidBannerPath", "http://media.admob.com/mraid/v1/mraid_app_banner.js");

        /* renamed from: f */
        public final C0260i.C0264c<String> f551f = new C0260i.C0264c<>("mraidExpandedBannerPath", "http://media.admob.com/mraid/v1/mraid_app_expanded_banner.js");

        /* renamed from: g */
        public final C0260i.C0264c<String> f552g = new C0260i.C0264c<>("mraidInterstitialPath", "http://media.admob.com/mraid/v1/mraid_app_interstitial.js");

        /* renamed from: h */
        public final C0260i.C0264c<String> f553h = new C0260i.C0264c<>("badAdReportPath", "https://badad.googleplex.com/s/reportAd");

        /* renamed from: i */
        public final C0260i.C0264c<Long> f554i = new C0260i.C0264c<>("appCacheMaxSize", 0L);

        /* renamed from: j */
        public final C0260i.C0264c<Long> f555j = new C0260i.C0264c<>("appCacheMaxSizePaddingInBytes", 131072L);

        /* renamed from: k */
        public final C0260i.C0264c<Long> f556k = new C0260i.C0264c<>("maxTotalAppCacheQuotaInBytes", 5242880L);

        /* renamed from: l */
        public final C0260i.C0264c<Long> f557l = new C0260i.C0264c<>("maxTotalDatabaseQuotaInBytes", 5242880L);

        /* renamed from: m */
        public final C0260i.C0264c<Long> f558m = new C0260i.C0264c<>("maxDatabaseQuotaPerOriginInBytes", 1048576L);

        /* renamed from: n */
        public final C0260i.C0264c<Long> f559n = new C0260i.C0264c<>("databaseQuotaIncreaseStepInBytes", 131072L);

        /* renamed from: o */
        public final C0260i.C0264c<Boolean> f560o = new C0260i.C0264c<>("isInitialized", false);
    }

    /* renamed from: a */
    public static C0221m m411a() {
        return f542d;
    }

    private C0221m() {
    }
}
