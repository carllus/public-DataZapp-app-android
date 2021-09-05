package com.google.ads;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0208g;
import com.google.ads.util.C0240b;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.google.ads.r */
public class C0232r implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        Uri uri;
        Uri parse;
        String host;
        String str = hashMap.get(AdActivity.URL_PARAM);
        if (str == null) {
            C0240b.m490e("Could not get URL from click gmsg.");
            return;
        }
        C0208g n = dVar.mo3224n();
        if (!(n == null || (host = parse.getHost()) == null || !host.toLowerCase(Locale.US).endsWith(".admob.com"))) {
            String str2 = null;
            String path = (parse = Uri.parse(str)).getPath();
            if (path != null) {
                String[] split = path.split("/");
                if (split.length >= 4) {
                    str2 = split[2] + "/" + split[3];
                }
            }
            n.mo3251a(str2);
        }
        C0228n i = dVar.mo3219i();
        Context a = i.f587f.mo3394a();
        Uri parse2 = Uri.parse(str);
        try {
            C0148al a2 = i.f600s.mo3395a();
            if (a2 != null && a2.mo3013a(parse2)) {
                uri = a2.mo3011a(parse2, a);
                new Thread(new C0126ae(uri.toString(), a)).start();
            }
        } catch (C0149am e) {
            C0240b.m490e("Unable to append parameter to URL: " + str);
        }
        uri = parse2;
        new Thread(new C0126ae(uri.toString(), a)).start();
    }
}
