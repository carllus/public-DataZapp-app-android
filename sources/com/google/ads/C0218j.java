package com.google.ads;

import com.google.ads.AdRequest;
import com.google.ads.C0177g;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;

/* renamed from: com.google.ads.j */
class C0218j implements MediationBannerListener {

    /* renamed from: a */
    private final C0179h f536a;

    /* renamed from: b */
    private boolean f537b;

    public C0218j(C0179h hVar) {
        this.f536a = hVar;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceivedAd(com.google.ads.mediation.MediationBannerAdapter<?, ?> r5) {
        /*
            r4 = this;
            com.google.ads.h r1 = r4.f536a
            monitor-enter(r1)
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            com.google.ads.mediation.MediationAdapter r0 = r0.mo3089i()     // Catch:{ all -> 0x005f }
            com.google.ads.util.C0238a.m470a((java.lang.Object) r5, (java.lang.Object) r0)     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f536a     // Catch:{ Throwable -> 0x002a }
            android.view.View r2 = r5.getBannerView()     // Catch:{ Throwable -> 0x002a }
            r0.mo3079a((android.view.View) r2)     // Catch:{ Throwable -> 0x002a }
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo3083c()     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x0062
            r0 = 0
            r4.f537b = r0     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            r2 = 1
            com.google.ads.g$a r3 = com.google.ads.C0177g.C0178a.AD     // Catch:{ all -> 0x005f }
            r0.mo3081a(r2, r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
        L_0x0029:
            return
        L_0x002a:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x005f }
            r2.<init>()     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "Error while getting banner View from adapter ("
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            com.google.ads.h r3 = r4.f536a     // Catch:{ all -> 0x005f }
            java.lang.String r3 = r3.mo3088h()     // Catch:{ all -> 0x005f }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r3 = "): "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x005f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x005f }
            com.google.ads.util.C0240b.m485b(r2, r0)     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            boolean r0 = r0.mo3083c()     // Catch:{ all -> 0x005f }
            if (r0 != 0) goto L_0x005d
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            r2 = 0
            com.google.ads.g$a r3 = com.google.ads.C0177g.C0178a.EXCEPTION     // Catch:{ all -> 0x005f }
            r0.mo3081a(r2, r3)     // Catch:{ all -> 0x005f }
        L_0x005d:
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            goto L_0x0029
        L_0x005f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            throw r0
        L_0x0062:
            r0 = 1
            r4.f537b = r0     // Catch:{ all -> 0x005f }
            com.google.ads.h r0 = r4.f536a     // Catch:{ all -> 0x005f }
            com.google.ads.e r0 = r0.mo3090j()     // Catch:{ all -> 0x005f }
            com.google.ads.h r2 = r4.f536a     // Catch:{ all -> 0x005f }
            com.google.ads.h r3 = r4.f536a     // Catch:{ all -> 0x005f }
            android.view.View r3 = r3.mo3086f()     // Catch:{ all -> 0x005f }
            r0.mo3056a((com.google.ads.C0179h) r2, (android.view.View) r3)     // Catch:{ all -> 0x005f }
            monitor-exit(r1)     // Catch:{ all -> 0x005f }
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0218j.onReceivedAd(com.google.ads.mediation.MediationBannerAdapter):void");
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> adapter, AdRequest.ErrorCode error) {
        synchronized (this.f536a) {
            C0238a.m470a((Object) adapter, (Object) this.f536a.mo3089i());
            C0240b.m480a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (!this.f536a.mo3083c()) {
                this.f536a.mo3081a(false, error == AdRequest.ErrorCode.NO_FILL ? C0177g.C0178a.NO_FILL : C0177g.C0178a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f536a) {
            this.f536a.mo3090j().mo3055a(this.f536a);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f536a) {
            this.f536a.mo3090j().mo3060b(this.f536a);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f536a) {
            this.f536a.mo3090j().mo3061c(this.f536a);
        }
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f536a) {
            C0238a.m472a(this.f536a.mo3083c());
            this.f536a.mo3090j().mo3057a(this.f536a, this.f537b);
        }
    }
}
