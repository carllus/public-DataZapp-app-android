package com.google.ads;

import android.app.Activity;
import android.view.View;
import com.google.ads.C0177g;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.ads.e */
public class C0167e {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0203d f319a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0179h f320b;

    /* renamed from: c */
    private final Object f321c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public Thread f322d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Object f323e;

    /* renamed from: f */
    private boolean f324f;

    /* renamed from: g */
    private final Object f325g;

    public C0167e(C0203d dVar) {
        this.f320b = null;
        this.f321c = new Object();
        this.f322d = null;
        this.f323e = new Object();
        this.f324f = false;
        this.f325g = new Object();
        C0238a.m474b((Object) dVar);
        this.f319a = dVar;
    }

    /* renamed from: a */
    public boolean mo3058a() {
        boolean z;
        synchronized (this.f323e) {
            z = this.f322d != null;
        }
        return z;
    }

    /* renamed from: b */
    public void mo3059b() {
        synchronized (this.f325g) {
            this.f324f = true;
            mo3063d((C0179h) null);
            synchronized (this.f323e) {
                if (this.f322d != null) {
                    this.f322d.interrupt();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3054a(final C0164c cVar, final AdRequest adRequest) {
        synchronized (this.f323e) {
            if (mo3058a()) {
                C0240b.m486c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
                return;
            }
            if (cVar.mo3034d()) {
                this.f319a.mo3192a((float) cVar.mo3035e());
                if (!this.f319a.mo3230t()) {
                    this.f319a.mo3217g();
                }
            } else if (this.f319a.mo3230t()) {
                this.f319a.mo3216f();
            }
            m156a(cVar, this.f319a);
            this.f322d = new Thread(new Runnable() {
                public void run() {
                    C0167e.this.m161b(cVar, adRequest);
                    synchronized (C0167e.this.f323e) {
                        Thread unused = C0167e.this.f322d = null;
                    }
                }
            });
            this.f322d.start();
        }
    }

    /* renamed from: a */
    public static boolean m156a(C0164c cVar, C0203d dVar) {
        if (cVar.mo3040j() == null) {
            return true;
        }
        if (!dVar.mo3219i().mo3353b()) {
            AdSize c = dVar.mo3219i().f588g.mo3394a().mo3281c();
            if (cVar.mo3040j().mo3278a()) {
                C0240b.m490e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + c + ") in the ad-type field in the mediation UI.");
                return false;
            }
            AdSize c2 = cVar.mo3040j().mo3281c();
            if (c2 == c) {
                return true;
            }
            C0240b.m490e("Mediation server returned ad size: '" + c2 + "', while the AdView was created with ad size: '" + c + "'. Using the ad-size passed to the AdView on creation.");
            return false;
        } else if (cVar.mo3040j().mo3278a()) {
            return true;
        } else {
            C0240b.m490e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
            return false;
        }
    }

    /* renamed from: a */
    private boolean m158a(C0179h hVar, String str) {
        if (m164e() == hVar) {
            return true;
        }
        C0240b.m486c("GWController: ignoring callback to " + str + " from non showing ambassador with adapter class: '" + hVar.mo3088h() + "'.");
        return false;
    }

    /* renamed from: a */
    public void mo3057a(C0179h hVar, final boolean z) {
        if (m158a(hVar, "onAdClicked()")) {
            final C0176f a = hVar.mo3077a();
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    C0167e.this.f319a.mo3201a(a, z);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo3056a(C0179h hVar, final View view) {
        if (m164e() != hVar) {
            C0240b.m486c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + hVar.mo3088h() + "').");
            return;
        }
        this.f319a.mo3224n().mo3250a(C0177g.C0178a.AD);
        final C0176f a = this.f320b.mo3077a();
        C0221m.m411a().f545c.mo3394a().post(new Runnable() {
            public void run() {
                C0167e.this.f319a.mo3197a(view, C0167e.this.f320b, a, true);
            }
        });
    }

    /* renamed from: a */
    public void mo3055a(C0179h hVar) {
        if (m158a(hVar, "onPresentScreen")) {
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    C0167e.this.f319a.mo3232v();
                }
            });
        }
    }

    /* renamed from: b */
    public void mo3060b(C0179h hVar) {
        if (m158a(hVar, "onDismissScreen")) {
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    C0167e.this.f319a.mo3231u();
                }
            });
        }
    }

    /* renamed from: c */
    public void mo3061c(C0179h hVar) {
        if (m158a(hVar, "onLeaveApplication")) {
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    C0167e.this.f319a.mo3233w();
                }
            });
        }
    }

    /* renamed from: c */
    public boolean mo3062c() {
        C0238a.m472a(this.f319a.mo3219i().mo3353b());
        C0179h e = m164e();
        if (e != null) {
            e.mo3087g();
            return true;
        }
        C0240b.m484b("There is no ad ready to show.");
        return false;
    }

    protected C0167e() {
        this.f320b = null;
        this.f321c = new Object();
        this.f322d = null;
        this.f323e = new Object();
        this.f324f = false;
        this.f325g = new Object();
        this.f319a = null;
    }

    /* renamed from: d */
    private boolean m163d() {
        boolean z;
        synchronized (this.f325g) {
            z = this.f324f;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m161b(final C0164c cVar, AdRequest adRequest) {
        synchronized (this.f323e) {
            C0238a.m470a((Object) Thread.currentThread(), (Object) this.f322d);
        }
        List<C0122a> f = cVar.mo3036f();
        long b = cVar.mo3031a() ? (long) cVar.mo3032b() : 10000;
        for (C0122a next : f) {
            C0240b.m480a("Looking to fetch ads from network: " + next.mo2990b());
            List<String> c = next.mo2991c();
            HashMap<String, String> e = next.mo2993e();
            List<String> d = next.mo2992d();
            String a = next.mo2989a();
            String b2 = next.mo2990b();
            String c2 = cVar.mo3033c();
            if (d == null) {
                d = cVar.mo3037g();
            }
            C0176f fVar = new C0176f(a, b2, c2, d, cVar.mo3038h(), cVar.mo3039i());
            Iterator<String> it = c.iterator();
            while (true) {
                if (it.hasNext()) {
                    String next2 = it.next();
                    Activity a2 = this.f319a.mo3219i().f584c.mo3397a();
                    if (a2 == null) {
                        C0240b.m480a("Activity is null while mediating.  Terminating mediation thread.");
                        return;
                    }
                    this.f319a.mo3224n().mo3253c();
                    if (m159a(next2, a2, adRequest, fVar, e, b)) {
                        return;
                    }
                    if (m163d()) {
                        C0240b.m480a("GWController.destroy() called. Terminating mediation thread.");
                        return;
                    }
                }
            }
        }
        C0221m.m411a().f545c.mo3394a().post(new Runnable() {
            public void run() {
                C0167e.this.f319a.mo3209b(cVar);
            }
        });
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m159a(java.lang.String r8, android.app.Activity r9, com.google.ads.AdRequest r10, final com.google.ads.C0176f r11, java.util.HashMap<java.lang.String, java.lang.String> r12, long r13) {
        /*
            r7 = this;
            com.google.ads.h r0 = new com.google.ads.h
            com.google.ads.internal.d r1 = r7.f319a
            com.google.ads.n r1 = r1.mo3219i()
            com.google.ads.util.i$b<com.google.ads.internal.h> r1 = r1.f588g
            java.lang.Object r2 = r1.mo3394a()
            com.google.ads.internal.h r2 = (com.google.ads.internal.C0209h) r2
            r1 = r7
            r3 = r11
            r4 = r8
            r5 = r10
            r6 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6)
            monitor-enter(r0)
            r0.mo3078a((android.app.Activity) r9)     // Catch:{ all -> 0x00ba }
        L_0x001c:
            boolean r1 = r0.mo3083c()     // Catch:{ InterruptedException -> 0x0037 }
            if (r1 != 0) goto L_0x004e
            r1 = 0
            int r1 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x004e
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x0037 }
            r0.wait(r13)     // Catch:{ InterruptedException -> 0x0037 }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x0037 }
            long r1 = r3 - r1
            long r13 = r13 - r1
            goto L_0x001c
        L_0x0037:
            r1 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r1.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Interrupted while waiting for ad network to load ad using adapter class: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = r1.append(r8)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.C0240b.m480a((java.lang.String) r1)     // Catch:{ all -> 0x00ba }
        L_0x004e:
            com.google.ads.internal.d r1 = r7.f319a     // Catch:{ all -> 0x00ba }
            com.google.ads.internal.g r1 = r1.mo3224n()     // Catch:{ all -> 0x00ba }
            com.google.ads.g$a r2 = r0.mo3085e()     // Catch:{ all -> 0x00ba }
            r1.mo3250a((com.google.ads.C0177g.C0178a) r2)     // Catch:{ all -> 0x00ba }
            boolean r1 = r0.mo3083c()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0093
            boolean r1 = r0.mo3084d()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x0093
            com.google.ads.internal.d r1 = r7.f319a     // Catch:{ all -> 0x00ba }
            com.google.ads.n r1 = r1.mo3219i()     // Catch:{ all -> 0x00ba }
            boolean r1 = r1.mo3353b()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x008d
            r1 = 0
            r2 = r1
        L_0x0075:
            com.google.ads.m r1 = com.google.ads.C0221m.m411a()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.i$b<android.os.Handler> r1 = r1.f545c     // Catch:{ all -> 0x00ba }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ all -> 0x00ba }
            android.os.Handler r1 = (android.os.Handler) r1     // Catch:{ all -> 0x00ba }
            com.google.ads.e$8 r3 = new com.google.ads.e$8     // Catch:{ all -> 0x00ba }
            r3.<init>(r0, r2, r11)     // Catch:{ all -> 0x00ba }
            r1.post(r3)     // Catch:{ all -> 0x00ba }
            r1 = 1
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            r0 = r1
        L_0x008c:
            return r0
        L_0x008d:
            android.view.View r1 = r0.mo3086f()     // Catch:{ all -> 0x00ba }
            r2 = r1
            goto L_0x0075
        L_0x0093:
            boolean r1 = r0.mo3083c()     // Catch:{ all -> 0x00ba }
            if (r1 != 0) goto L_0x00b3
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ba }
            r1.<init>()     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = "Timeout occurred in adapter class: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.String r2 = r0.mo3088h()     // Catch:{ all -> 0x00ba }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00ba }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ba }
            com.google.ads.util.C0240b.m480a((java.lang.String) r1)     // Catch:{ all -> 0x00ba }
        L_0x00b3:
            r0.mo3082b()     // Catch:{ all -> 0x00ba }
            r1 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            r0 = r1
            goto L_0x008c
        L_0x00ba:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ba }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0167e.m159a(java.lang.String, android.app.Activity, com.google.ads.AdRequest, com.google.ads.f, java.util.HashMap, long):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public boolean m165e(C0179h hVar) {
        boolean z;
        synchronized (this.f325g) {
            if (m163d()) {
                hVar.mo3082b();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    /* renamed from: e */
    private C0179h m164e() {
        C0179h hVar;
        synchronized (this.f321c) {
            hVar = this.f320b;
        }
        return hVar;
    }

    /* renamed from: d */
    public void mo3063d(C0179h hVar) {
        synchronized (this.f321c) {
            if (this.f320b != hVar) {
                if (this.f320b != null) {
                    this.f320b.mo3082b();
                }
                this.f320b = hVar;
            }
        }
    }
}
