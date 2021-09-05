package com.google.ads.util;

import android.annotation.TargetApi;
import android.webkit.WebSettings;
import com.google.ads.C0228n;

@TargetApi(17)
/* renamed from: com.google.ads.util.h */
public final class C0259h {
    /* renamed from: a */
    public static void m510a(WebSettings webSettings, C0228n nVar) {
        C0249g.m504a(webSettings, nVar);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
    }
}
