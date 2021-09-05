package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0209h;
import com.google.ads.util.C0260i;

/* renamed from: com.google.ads.n */
public class C0228n extends C0260i {

    /* renamed from: a */
    public final C0260i.C0263b<C0121Ad> f582a;

    /* renamed from: b */
    public final C0260i.C0263b<C0203d> f583b;

    /* renamed from: c */
    public final C0260i.C0265d<Activity> f584c;

    /* renamed from: d */
    public final C0260i.C0263b<C0221m> f585d;

    /* renamed from: e */
    public final C0260i.C0263b<ActivationOverlay> f586e;

    /* renamed from: f */
    public final C0260i.C0263b<Context> f587f;

    /* renamed from: g */
    public final C0260i.C0263b<C0209h> f588g;

    /* renamed from: h */
    public final C0260i.C0263b<String> f589h;

    /* renamed from: i */
    public final C0260i.C0263b<ViewGroup> f590i;

    /* renamed from: j */
    public final C0260i.C0263b<AdView> f591j;

    /* renamed from: k */
    public final C0260i.C0263b<InterstitialAd> f592k;

    /* renamed from: l */
    public final C0260i.C0264c<C0220l> f593l = new C0260i.C0264c<>("currentAd", null);

    /* renamed from: m */
    public final C0260i.C0264c<C0220l> f594m = new C0260i.C0264c<>("nextAd", null);

    /* renamed from: n */
    public final C0260i.C0264c<AdSize[]> f595n;

    /* renamed from: o */
    public final C0260i.C0264c<AdListener> f596o = new C0260i.C0264c<>("adListener");

    /* renamed from: p */
    public final C0260i.C0264c<AppEventListener> f597p = new C0260i.C0264c<>("appEventListener");

    /* renamed from: q */
    public final C0260i.C0264c<SwipeableAdListener> f598q = new C0260i.C0264c<>("swipeableEventListener");

    /* renamed from: r */
    public final C0260i.C0264c<C0146ak> f599r = new C0260i.C0264c<>("spamSignals", null);

    /* renamed from: s */
    public final C0260i.C0264c<C0148al> f600s = new C0260i.C0264c<>("spamSignalsUtil", null);

    /* renamed from: t */
    public final C0260i.C0264c<Boolean> f601t = new C0260i.C0264c<>("usesManualImpressions", false);

    /* renamed from: a */
    public boolean mo3352a() {
        return !mo3353b();
    }

    /* renamed from: b */
    public boolean mo3353b() {
        return this.f588g.mo3394a().mo3278a();
    }

    public C0228n(C0221m mVar, C0121Ad ad, AdView adView, InterstitialAd interstitialAd, String str, Activity activity, Context context, ViewGroup viewGroup, C0209h hVar, C0203d dVar) {
        ActivationOverlay activationOverlay = null;
        this.f585d = new C0260i.C0263b<>("appState", mVar);
        this.f582a = new C0260i.C0263b<>("ad", ad);
        this.f591j = new C0260i.C0263b<>("adView", adView);
        this.f588g = new C0260i.C0263b<>("adType", hVar);
        this.f589h = new C0260i.C0263b<>("adUnitId", str);
        this.f584c = new C0260i.C0265d<>("activity", activity);
        this.f592k = new C0260i.C0263b<>("interstitialAd", interstitialAd);
        this.f590i = new C0260i.C0263b<>("bannerContainer", viewGroup);
        this.f587f = new C0260i.C0263b<>("applicationContext", context);
        this.f595n = new C0260i.C0264c<>("adSizes", null);
        this.f583b = new C0260i.C0263b<>("adManager", dVar);
        if (hVar != null && hVar.mo3280b()) {
            activationOverlay = new ActivationOverlay(this);
        }
        this.f586e = new C0260i.C0263b<>("activationOverlay", activationOverlay);
    }
}
