package com.google.ads;

import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.internal.C0194c;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.v */
public class C0266v implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        C0240b.m490e("Invalid " + hashMap.get("type") + " request error: " + hashMap.get("errors"));
        C0194c k = dVar.mo3221k();
        if (k != null) {
            k.mo3160a(AdRequest.ErrorCode.INVALID_REQUEST);
        }
    }
}
