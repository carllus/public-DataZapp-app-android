package com.google.ads;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.C0177g;
import com.google.ads.internal.C0209h;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.h */
public class C0179h {

    /* renamed from: a */
    final C0209h f357a;

    /* renamed from: b */
    private final C0176f f358b;

    /* renamed from: c */
    private boolean f359c = false;

    /* renamed from: d */
    private boolean f360d = false;

    /* renamed from: e */
    private C0177g.C0178a f361e = null;

    /* renamed from: f */
    private final C0167e f362f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public MediationAdapter<?, ?> f363g = null;

    /* renamed from: h */
    private boolean f364h = false;

    /* renamed from: i */
    private boolean f365i = false;

    /* renamed from: j */
    private View f366j = null;

    /* renamed from: k */
    private final String f367k;

    /* renamed from: l */
    private final AdRequest f368l;

    /* renamed from: m */
    private final HashMap<String, String> f369m;

    public C0179h(C0167e eVar, C0209h hVar, C0176f fVar, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        C0238a.m475b(TextUtils.isEmpty(str));
        this.f362f = eVar;
        this.f357a = hVar;
        this.f358b = fVar;
        this.f367k = str;
        this.f368l = adRequest;
        this.f369m = hashMap;
    }

    /* renamed from: a */
    public C0176f mo3077a() {
        return this.f358b;
    }

    /* renamed from: a */
    public synchronized void mo3078a(Activity activity) {
        C0238a.m476b(this.f364h, "startLoadAdTask has already been called.");
        this.f364h = true;
        C0221m.m411a().f545c.mo3394a().post(new C0182i(this, activity, this.f367k, this.f368l, this.f369m));
    }

    /* renamed from: b */
    public synchronized void mo3082b() {
        C0238a.m473a(this.f364h, "destroy() called but startLoadAdTask has not been called.");
        C0221m.m411a().f545c.mo3394a().post(new Runnable() {
            public void run() {
                if (C0179h.this.mo3092l()) {
                    C0238a.m474b((Object) C0179h.this.f363g);
                    try {
                        C0179h.this.f363g.destroy();
                        C0240b.m480a("Called destroy() for adapter with class: " + C0179h.this.f363g.getClass().getName());
                    } catch (Throwable th) {
                        C0240b.m485b("Error while destroying adapter (" + C0179h.this.mo3088h() + "):", th);
                    }
                }
            }
        });
    }

    /* renamed from: c */
    public synchronized boolean mo3083c() {
        return this.f359c;
    }

    /* renamed from: d */
    public synchronized boolean mo3084d() {
        C0238a.m473a(this.f359c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
        return this.f360d;
    }

    /* renamed from: e */
    public synchronized C0177g.C0178a mo3085e() {
        C0177g.C0178a aVar;
        if (this.f361e == null) {
            aVar = C0177g.C0178a.TIMEOUT;
        } else {
            aVar = this.f361e;
        }
        return aVar;
    }

    /* renamed from: f */
    public synchronized View mo3086f() {
        C0238a.m473a(this.f359c, "getAdView() called when isLoadAdTaskDone() is false.");
        return this.f366j;
    }

    /* renamed from: g */
    public synchronized void mo3087g() {
        C0238a.m472a(this.f357a.mo3278a());
        try {
            final MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.f363g;
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    try {
                        mediationInterstitialAdapter.showInterstitial();
                    } catch (Throwable th) {
                        C0240b.m485b("Error while telling adapter (" + C0179h.this.mo3088h() + ") ad to show interstitial: ", th);
                    }
                }
            });
        } catch (ClassCastException e) {
            C0240b.m485b("In Ambassador.show(): ambassador.adapter does not implement the MediationInterstitialAdapter interface.", e);
        }
        return;
    }

    /* renamed from: h */
    public synchronized String mo3088h() {
        return this.f363g != null ? this.f363g.getClass().getName() : "\"adapter was not created.\"";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3081a(boolean z, C0177g.C0178a aVar) {
        this.f360d = z;
        this.f359c = true;
        this.f361e = aVar;
        notify();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3080a(MediationAdapter<?, ?> mediationAdapter) {
        this.f363g = mediationAdapter;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public synchronized MediationAdapter<?, ?> mo3089i() {
        return this.f363g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public C0167e mo3090j() {
        return this.f362f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3079a(View view) {
        this.f366j = view;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public synchronized void mo3091k() {
        this.f365i = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public synchronized boolean mo3092l() {
        return this.f365i;
    }
}
