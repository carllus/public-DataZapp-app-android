package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0121Ad;
import com.google.ads.InterstitialAd;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.AdUtil;

public class AdMobAdapter implements MediationBannerAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters>, MediationInterstitialAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public MediationBannerListener f564a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public MediationInterstitialListener f565b;

    /* renamed from: c */
    private AdView f566c;

    /* renamed from: d */
    private InterstitialAd f567d;

    /* renamed from: a */
    private void m415a() {
        if (m417b()) {
            throw new IllegalStateException("Adapter has already been destroyed");
        }
    }

    /* renamed from: b */
    private boolean m417b() {
        return this.f566c == null && this.f567d == null;
    }

    /* renamed from: a */
    private AdRequest m413a(Activity activity, AdMobAdapterServerParameters adMobAdapterServerParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras adMobAdapterExtras) {
        AdMobAdapterExtras adMobAdapterExtras2 = new AdMobAdapterExtras(adMobAdapterExtras);
        adMobAdapterExtras2.addExtra("_norefresh", "t");
        adMobAdapterExtras2.addExtra("gw", 1);
        if (adMobAdapterServerParameters.allowHouseAds != null) {
            adMobAdapterExtras2.addExtra("mad_hac", adMobAdapterServerParameters.allowHouseAds);
        }
        AdRequest networkExtras = new AdRequest().setBirthday(mediationAdRequest.getBirthday()).setGender(mediationAdRequest.getGender()).setKeywords(mediationAdRequest.getKeywords()).setLocation(mediationAdRequest.getLocation()).setNetworkExtras(adMobAdapterExtras2);
        if (mediationAdRequest.isTesting()) {
            networkExtras.addTestDevice(AdUtil.m441a((Context) activity));
        }
        return networkExtras;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdView mo3327a(Activity activity, AdSize adSize, String str) {
        return new AdView(activity, adSize, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public InterstitialAd mo3328a(Activity activity, String str) {
        return new InterstitialAd(activity, str);
    }

    public Class<AdMobAdapterExtras> getAdditionalParametersType() {
        return AdMobAdapterExtras.class;
    }

    public Class<AdMobAdapterServerParameters> getServerParametersType() {
        return AdMobAdapterServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f564a = listener;
        if (adSize.isAutoHeight() || adSize.isFullWidth() || ((extras != null && extras.getUseExactAdSize()) || (adSize = adSize.findBestSize(AdSize.BANNER, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_MRECT, AdSize.IAB_WIDE_SKYSCRAPER)) != null)) {
            this.f566c = mo3327a(activity, adSize, serverParameters.adUnitId);
            this.f566c.setAdListener(new C0224a());
            this.f566c.loadAd(m413a(activity, serverParameters, mediationAdRequest, extras));
            return;
        }
        listener.onFailedToReceiveAd(this, AdRequest.ErrorCode.NO_FILL);
    }

    public View getBannerView() {
        return this.f566c;
    }

    public void destroy() {
        m415a();
        if (this.f566c != null) {
            this.f566c.stopLoading();
            this.f566c.destroy();
            this.f566c = null;
        }
        if (this.f567d != null) {
            this.f567d.stopLoading();
            this.f567d = null;
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f565b = listener;
        this.f567d = mo3328a(activity, serverParameters.adUnitId);
        this.f567d.setAdListener(new C0225b());
        this.f567d.loadAd(m413a(activity, serverParameters, mediationAdRequest, extras));
    }

    public void showInterstitial() {
        this.f567d.show();
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$a */
    private class C0224a implements AdListener {
        private C0224a() {
        }

        public void onReceiveAd(C0121Ad ad) {
            AdMobAdapter.this.f564a.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0121Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f564a.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0121Ad ad) {
            AdMobAdapter.this.f564a.onClick(AdMobAdapter.this);
            AdMobAdapter.this.f564a.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0121Ad ad) {
            AdMobAdapter.this.f564a.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0121Ad ad) {
            AdMobAdapter.this.f564a.onLeaveApplication(AdMobAdapter.this);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter$b */
    private class C0225b implements AdListener {
        private C0225b() {
        }

        public void onReceiveAd(C0121Ad ad) {
            AdMobAdapter.this.f565b.onReceivedAd(AdMobAdapter.this);
        }

        public void onFailedToReceiveAd(C0121Ad ad, AdRequest.ErrorCode error) {
            AdMobAdapter.this.f565b.onFailedToReceiveAd(AdMobAdapter.this, error);
        }

        public void onPresentScreen(C0121Ad ad) {
            AdMobAdapter.this.f565b.onPresentScreen(AdMobAdapter.this);
        }

        public void onDismissScreen(C0121Ad ad) {
            AdMobAdapter.this.f565b.onDismissScreen(AdMobAdapter.this);
        }

        public void onLeaveApplication(C0121Ad ad) {
            AdMobAdapter.this.f565b.onLeaveApplication(AdMobAdapter.this);
        }
    }
}
