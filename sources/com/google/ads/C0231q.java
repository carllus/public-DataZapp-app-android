package com.google.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.C0188a;
import com.google.ads.internal.C0203d;
import com.google.ads.util.C0240b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.q */
public class C0231q implements C0229o {

    /* renamed from: a */
    private static final C0188a f602a = C0188a.f402a.mo3153b();

    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        boolean z;
        String str = hashMap.get("urls");
        if (str == null) {
            C0240b.m490e("Could not get the urls param from canOpenURLs gmsg.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap2 = new HashMap();
        PackageManager packageManager = webView.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            if (packageManager.resolveActivity(new Intent(split2.length >= 2 ? split2[1] : "android.intent.action.VIEW", Uri.parse(split2[0])), 65536) != null) {
                z = true;
            } else {
                z = false;
            }
            hashMap2.put(str2, Boolean.valueOf(z));
        }
        f602a.mo3146a(webView, (Map<String, Boolean>) hashMap2);
    }
}
