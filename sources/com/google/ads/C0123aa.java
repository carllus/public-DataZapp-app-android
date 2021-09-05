package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.aa */
public class C0123aa implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        int i;
        int i2;
        int i3;
        int i4 = -1;
        if (webView instanceof ActivationOverlay) {
            try {
                if (!TextUtils.isEmpty(hashMap.get("w"))) {
                    i = Integer.parseInt(hashMap.get("w"));
                } else {
                    i = -1;
                }
                if (!TextUtils.isEmpty(hashMap.get("h"))) {
                    i2 = Integer.parseInt(hashMap.get("h"));
                } else {
                    i2 = -1;
                }
                if (!TextUtils.isEmpty(hashMap.get("x"))) {
                    i3 = Integer.parseInt(hashMap.get("x"));
                } else {
                    i3 = -1;
                }
                if (!TextUtils.isEmpty(hashMap.get("y"))) {
                    i4 = Integer.parseInt(hashMap.get("y"));
                }
                if (hashMap.get("a") != null && hashMap.get("a").equals("1")) {
                    dVar.mo3202a((C0220l) null, true, i3, i4, i, i2);
                } else if (hashMap.get("a") == null || !hashMap.get("a").equals("0")) {
                    dVar.mo3194a(i3, i4, i, i2);
                } else {
                    dVar.mo3202a((C0220l) null, false, i3, i4, i, i2);
                }
            } catch (NumberFormatException e) {
                C0240b.m489d("Invalid number format in activation overlay response.", e);
            }
        } else {
            C0240b.m484b("Trying to activate an overlay when this is not an overlay.");
        }
    }
}
