package com.google.ads;

import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.lang.ref.WeakReference;

/* renamed from: com.google.ads.af */
public class C0127af implements Runnable {

    /* renamed from: a */
    private WeakReference<C0203d> f55a;

    public C0127af(C0203d dVar) {
        this.f55a = new WeakReference<>(dVar);
    }

    public void run() {
        C0203d dVar = (C0203d) this.f55a.get();
        if (dVar == null) {
            C0240b.m480a("The ad must be gone, so cancelling the refresh timer.");
        } else {
            dVar.mo3185A();
        }
    }
}
