package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.u */
public class C0235u implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get(AdActivity.URL_PARAM);
        if (TextUtils.isEmpty(str)) {
            C0240b.m490e("Could not get URL from track gmsg.");
        } else {
            new Thread(new C0126ae(str, dVar.mo3219i().f587f.mo3394a())).start();
        }
    }
}
