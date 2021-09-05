package com.google.ads;

import com.google.ads.internal.C0194c;
import com.google.ads.util.C0260i;

/* renamed from: com.google.ads.l */
public final class C0220l extends C0260i {

    /* renamed from: a */
    public final C0260i.C0263b<C0228n> f539a;

    /* renamed from: b */
    public final C0260i.C0264c<C0194c> f540b;

    /* renamed from: c */
    public final C0260i.C0264c<Boolean> f541c = new C0260i.C0264c<>("disableNativeScroll", false);

    public C0220l(C0228n nVar) {
        this.f539a = new C0260i.C0263b<>("slotState", nVar);
        this.f540b = new C0260i.C0264c<>("adLoader", new C0194c(this));
    }
}
