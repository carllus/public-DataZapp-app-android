package com.google.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.C0194c;
import com.google.ads.internal.C0203d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.google.ads.w */
public class C0267w implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        C0194c.C0201d dVar2;
        String str = hashMap.get("url");
        String str2 = hashMap.get("type");
        String str3 = hashMap.get("afma_notify_dt");
        String str4 = hashMap.get("activation_overlay_url");
        String str5 = hashMap.get("check_packages");
        boolean equals = "1".equals(hashMap.get("drt_include"));
        String str6 = hashMap.get("request_scenario");
        boolean equals2 = "1".equals(hashMap.get("use_webview_loadurl"));
        if (C0194c.C0201d.OFFLINE_EMPTY.f451e.equals(str6)) {
            dVar2 = C0194c.C0201d.OFFLINE_EMPTY;
        } else if (C0194c.C0201d.OFFLINE_USING_BUFFERED_ADS.f451e.equals(str6)) {
            dVar2 = C0194c.C0201d.OFFLINE_USING_BUFFERED_ADS;
        } else if (C0194c.C0201d.ONLINE_USING_BUFFERED_ADS.f451e.equals(str6)) {
            dVar2 = C0194c.C0201d.ONLINE_USING_BUFFERED_ADS;
        } else {
            dVar2 = C0194c.C0201d.ONLINE_SERVER_REQUEST;
        }
        C0240b.m486c("Received ad url: <url: \"" + str + "\" type: \"" + str2 + "\" afmaNotifyDt: \"" + str3 + "\" activationOverlayUrl: \"" + str4 + "\" useWebViewLoadUrl: \"" + equals2 + "\">");
        if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str)) {
            BigInteger bigInteger = new BigInteger(new byte[1]);
            String[] split = str5.split(",");
            BigInteger bigInteger2 = bigInteger;
            for (int i = 0; i < split.length; i++) {
                if (AdUtil.m450a((Context) dVar.mo3219i().f584c.mo3397a(), split[i])) {
                    bigInteger2 = bigInteger2.setBit(i);
                }
            }
            String format = String.format(Locale.US, "%X", new Object[]{bigInteger2});
            str = str.replaceAll("%40installed_markets%40", format);
            C0221m.m411a().f543a.mo3396a(format);
            C0240b.m486c("Ad url modified to " + str);
        }
        C0194c k = dVar.mo3221k();
        if (k != null) {
            k.mo3175d(equals);
            k.mo3164a(dVar2);
            k.mo3177e(equals2);
            k.mo3176e(str4);
            k.mo3174d(str);
        }
    }
}
