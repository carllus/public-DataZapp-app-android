package com.google.ads;

import android.app.Activity;
import android.view.ViewGroup;
import com.google.ads.internal.C0203d;

public class InterstitialAd implements C0121Ad {

    /* renamed from: a */
    private C0203d f46a;

    public InterstitialAd(Activity activity, String adUnitId) {
        this(activity, adUnitId, false);
    }

    public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout) {
        this.f46a = new C0203d(this, activity, (AdSize) null, adUnitId, (ViewGroup) null, shortTimeout);
    }

    public boolean isReady() {
        return this.f46a.mo3229s();
    }

    public void loadAd(AdRequest adRequest) {
        this.f46a.mo3199a(adRequest);
    }

    public void show() {
        this.f46a.mo3186B();
    }

    public void setAdListener(AdListener adListener) {
        this.f46a.mo3219i().f596o.mo3396a(adListener);
    }

    /* access modifiers changed from: protected */
    public void setAppEventListener(AppEventListener appEventListener) {
        this.f46a.mo3219i().f597p.mo3396a(appEventListener);
    }

    public void stopLoading() {
        this.f46a.mo3187C();
    }
}
