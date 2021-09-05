package com.google.ads.internal;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;

/* renamed from: com.google.ads.internal.e */
public class C0204e {

    /* renamed from: a */
    private final String f488a;

    /* renamed from: b */
    private HashMap<String, String> f489b;

    public C0204e(Bundle bundle) {
        this.f488a = bundle.getString("action");
        this.f489b = m333a(bundle.getSerializable("params"));
    }

    public C0204e(String str) {
        this.f488a = str;
    }

    public C0204e(String str, HashMap<String, String> hashMap) {
        this(str);
        this.f489b = hashMap;
    }

    /* renamed from: a */
    private HashMap<String, String> m333a(Serializable serializable) {
        if (serializable instanceof HashMap) {
            return (HashMap) serializable;
        }
        return null;
    }

    /* renamed from: a */
    public Bundle mo3237a() {
        Bundle bundle = new Bundle();
        bundle.putString("action", this.f488a);
        bundle.putSerializable("params", this.f489b);
        return bundle;
    }

    /* renamed from: b */
    public String mo3238b() {
        return this.f488a;
    }

    /* renamed from: c */
    public HashMap<String, String> mo3239c() {
        return this.f489b;
    }
}
