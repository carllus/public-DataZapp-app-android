package com.google.ads.util;

import android.os.Build;
import android.support.p000v4.p002os.EnvironmentCompat;

/* renamed from: com.google.ads.util.d */
class C0246d {

    /* renamed from: d */
    static final C0246d f652d = new C0246d();

    /* renamed from: e */
    static final C0246d f653e = new C0246d(EnvironmentCompat.MEDIA_UNKNOWN, "generic", "generic");

    /* renamed from: f */
    static final C0246d f654f = new C0246d(EnvironmentCompat.MEDIA_UNKNOWN, "generic_x86", "Android");

    /* renamed from: a */
    public final String f655a;

    /* renamed from: b */
    public final String f656b;

    /* renamed from: c */
    public final String f657c;

    C0246d() {
        this.f655a = Build.BOARD;
        this.f656b = Build.DEVICE;
        this.f657c = Build.BRAND;
    }

    C0246d(String str, String str2, String str3) {
        this.f655a = str;
        this.f656b = str2;
        this.f657c = str3;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C0246d)) {
            return false;
        }
        C0246d dVar = (C0246d) o;
        if (!m496a(this.f655a, dVar.f655a) || !m496a(this.f656b, dVar.f656b) || !m496a(this.f657c, dVar.f657c)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m496a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str == str2;
    }

    public int hashCode() {
        int i = 0;
        if (this.f655a != null) {
            i = 0 + this.f655a.hashCode();
        }
        if (this.f656b != null) {
            i += this.f656b.hashCode();
        }
        if (this.f657c != null) {
            return i + this.f657c.hashCode();
        }
        return i;
    }
}
