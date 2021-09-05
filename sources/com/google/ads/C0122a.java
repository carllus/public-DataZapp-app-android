package com.google.ads;

import com.google.ads.util.C0238a;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.google.ads.a */
public class C0122a {

    /* renamed from: a */
    private final String f47a;

    /* renamed from: b */
    private final String f48b;

    /* renamed from: c */
    private final List<String> f49c;

    /* renamed from: d */
    private final List<String> f50d;

    /* renamed from: e */
    private final HashMap<String, String> f51e;

    public C0122a(String str, String str2, List<String> list, List<String> list2, HashMap<String, String> hashMap) {
        C0238a.m471a(str2);
        if (str != null) {
            C0238a.m471a(str);
        }
        this.f47a = str;
        this.f48b = str2;
        this.f49c = list;
        this.f51e = hashMap;
        this.f50d = list2;
    }

    /* renamed from: a */
    public String mo2989a() {
        return this.f47a;
    }

    /* renamed from: b */
    public String mo2990b() {
        return this.f48b;
    }

    /* renamed from: c */
    public List<String> mo2991c() {
        return this.f49c;
    }

    /* renamed from: d */
    public List<String> mo2992d() {
        return this.f50d;
    }

    /* renamed from: e */
    public HashMap<String, String> mo2993e() {
        return this.f51e;
    }
}
