package com.google.ads.internal;

import com.google.ads.util.C0240b;

/* renamed from: com.google.ads.internal.b */
public final class C0193b extends Exception {

    /* renamed from: a */
    public final boolean f407a;

    public C0193b(String str, boolean z) {
        super(str);
        this.f407a = z;
    }

    public C0193b(String str, boolean z, Throwable th) {
        super(str, th);
        this.f407a = z;
    }

    /* renamed from: a */
    public void mo3154a(String str) {
        C0240b.m484b(mo3156c(str));
        C0240b.m481a((String) null, (Throwable) this);
    }

    /* renamed from: b */
    public void mo3155b(String str) {
        String c = mo3156c(str);
        if (!this.f407a) {
            this = null;
        }
        throw new RuntimeException(c, this);
    }

    /* renamed from: c */
    public String mo3156c(String str) {
        if (this.f407a) {
            return str + ": " + getMessage();
        }
        return str;
    }
}
