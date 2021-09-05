package com.google.ads;

import com.google.ads.AdRequest;
import com.google.ads.C0177g;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;

/* renamed from: com.google.ads.k */
class C0219k implements MediationInterstitialListener {

    /* renamed from: a */
    private final C0179h f538a;

    C0219k(C0179h hVar) {
        this.f538a = hVar;
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> adapter) {
        synchronized (this.f538a) {
            C0238a.m470a((Object) adapter, (Object) this.f538a.mo3089i());
            if (this.f538a.mo3083c()) {
                C0240b.m490e("Got an onReceivedAd() callback after loadAdTask is done from an interstitial adapter. Ignoring callback.");
            } else {
                this.f538a.mo3081a(true, C0177g.C0178a.AD);
            }
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> adapter, AdRequest.ErrorCode error) {
        synchronized (this.f538a) {
            C0238a.m470a((Object) adapter, (Object) this.f538a.mo3089i());
            C0240b.m480a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (this.f538a.mo3083c()) {
                C0240b.m484b("Got an onFailedToReceiveAd() callback after loadAdTask is done from an interstitial adapter.  Ignoring callback.");
            } else {
                this.f538a.mo3081a(false, error == AdRequest.ErrorCode.NO_FILL ? C0177g.C0178a.NO_FILL : C0177g.C0178a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f538a) {
            this.f538a.mo3090j().mo3055a(this.f538a);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f538a) {
            this.f538a.mo3090j().mo3060b(this.f538a);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f538a) {
            this.f538a.mo3090j().mo3061c(this.f538a);
        }
    }
}
