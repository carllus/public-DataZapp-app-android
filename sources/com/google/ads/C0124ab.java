package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.ab */
public class C0124ab implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        if (dVar.mo3219i().f584c.mo3397a() == null) {
            C0240b.m490e("Activity was null while responding to touch gmsg.");
            return;
        }
        String str = hashMap.get("tx");
        String str2 = hashMap.get("ty");
        String str3 = hashMap.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            C0146ak a = dVar.mo3219i().f599r.mo3395a();
            if (a != null) {
                a.mo3004a(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException e) {
            C0240b.m490e("Could not parse touch parameters from gmsg.");
        }
    }
}
