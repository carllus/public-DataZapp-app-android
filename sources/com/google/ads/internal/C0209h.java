package com.google.ads.internal;

import android.content.Context;
import com.google.ads.AdSize;

/* renamed from: com.google.ads.internal.h */
public class C0209h {

    /* renamed from: a */
    public static final C0209h f512a = new C0209h((AdSize) null, true);

    /* renamed from: b */
    private AdSize f513b;

    /* renamed from: c */
    private boolean f514c;

    /* renamed from: d */
    private final boolean f515d;

    private C0209h(AdSize adSize, boolean z) {
        this.f513b = adSize;
        this.f515d = z;
    }

    /* renamed from: a */
    public static C0209h m393a(AdSize adSize, Context context) {
        return new C0209h(AdSize.createAdSize(adSize, context), false);
    }

    /* renamed from: a */
    public static C0209h m392a(AdSize adSize) {
        return m393a(adSize, (Context) null);
    }

    /* renamed from: a */
    public boolean mo3278a() {
        return this.f515d;
    }

    /* renamed from: b */
    public boolean mo3280b() {
        return this.f514c;
    }

    /* renamed from: c */
    public AdSize mo3281c() {
        return this.f513b;
    }

    /* renamed from: b */
    public void mo3279b(AdSize adSize) {
        if (!this.f515d) {
            this.f513b = adSize;
        }
    }

    /* renamed from: a */
    public void mo3277a(boolean z) {
        this.f514c = z;
    }
}
