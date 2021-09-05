package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.p */
public class C0230p implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("name");
        if (str == null) {
            C0240b.m484b("Error: App event with no name parameter.");
        } else {
            dVar.mo3204a(str, hashMap.get("info"));
        }
    }
}
