package com.google.ads;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.ads.d */
public class C0166d {

    /* renamed from: a */
    private C0164c f316a = null;

    /* renamed from: b */
    private long f317b = -1;

    /* renamed from: a */
    public boolean mo3042a() {
        return this.f316a != null && SystemClock.elapsedRealtime() < this.f317b;
    }

    /* renamed from: a */
    public void mo3041a(C0164c cVar, int i) {
        this.f316a = cVar;
        this.f317b = TimeUnit.MILLISECONDS.convert((long) i, TimeUnit.SECONDS) + SystemClock.elapsedRealtime();
    }

    /* renamed from: b */
    public C0164c mo3043b() {
        return this.f316a;
    }
}
