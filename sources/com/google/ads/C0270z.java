package com.google.ads;

import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0204e;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.z */
public class C0270z implements C0229o {

    /* renamed from: a */
    private AdActivity.StaticMethodWrapper f679a;

    public C0270z() {
        this(new AdActivity.StaticMethodWrapper());
    }

    public C0270z(AdActivity.StaticMethodWrapper staticMethodWrapper) {
        this.f679a = staticMethodWrapper;
    }

    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("a");
        if (str == null) {
            C0240b.m480a("Could not get the action parameter for open GMSG.");
        } else if (str.equals("webapp")) {
            this.f679a.launchAdActivity(dVar, new C0204e("webapp", hashMap));
        } else if (str.equals("expand")) {
            this.f679a.launchAdActivity(dVar, new C0204e("expand", hashMap));
        } else {
            this.f679a.launchAdActivity(dVar, new C0204e("intent", hashMap));
        }
    }
}
