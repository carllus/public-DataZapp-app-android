package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.t */
public class C0234t implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).setCustomClose("1".equals(hashMap.get(AdActivity.CUSTOM_CLOSE_PARAM)));
        } else {
            C0240b.m484b("Trying to set a custom close icon on a WebView that isn't an AdWebView");
        }
    }
}
