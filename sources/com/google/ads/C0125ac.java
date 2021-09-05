package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0188a;
import com.google.ads.internal.C0203d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import java.util.HashMap;

/* renamed from: com.google.ads.ac */
public class C0125ac implements C0229o {

    /* renamed from: a */
    private static final C0188a f52a = C0188a.f402a.mo3153b();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo2995a(HashMap<String, String> hashMap, String str, int i, DisplayMetrics displayMetrics) {
        String str2 = hashMap.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) Integer.parseInt(str2), displayMetrics);
        } catch (NumberFormatException e) {
            C0240b.m480a("Could not parse \"" + str + "\" in a video gmsg: " + str2);
            return i;
        }
    }

    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        String str = hashMap.get("action");
        if (str == null) {
            C0240b.m480a("No \"action\" parameter in a video gmsg.");
        } else if (webView instanceof AdWebView) {
            AdWebView adWebView = (AdWebView) webView;
            AdActivity i = adWebView.mo3128i();
            if (i == null) {
                C0240b.m480a("Could not get adActivity for a video gmsg.");
                return;
            }
            boolean equals = str.equals("new");
            boolean equals2 = str.equals("position");
            if (equals || equals2) {
                DisplayMetrics a = AdUtil.m440a((Activity) i);
                int a2 = mo2995a(hashMap, "x", 0, a);
                int a3 = mo2995a(hashMap, "y", 0, a);
                int a4 = mo2995a(hashMap, "w", -1, a);
                int a5 = mo2995a(hashMap, "h", -1, a);
                if (!equals || i.getAdVideoView() != null) {
                    i.moveAdVideoView(a2, a3, a4, a5);
                } else {
                    i.newAdVideoView(a2, a3, a4, a5);
                }
            } else {
                AdVideoView adVideoView = i.getAdVideoView();
                if (adVideoView == null) {
                    f52a.mo3145a(adWebView, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
                } else if (str.equals("click")) {
                    DisplayMetrics a6 = AdUtil.m440a((Activity) i);
                    int a7 = mo2995a(hashMap, "x", 0, a6);
                    int a8 = mo2995a(hashMap, "y", 0, a6);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    adVideoView.mo3110a(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a7, (float) a8, 0));
                } else if (str.equals("controls")) {
                    String str2 = hashMap.get("enabled");
                    if (str2 == null) {
                        C0240b.m480a("No \"enabled\" parameter in a controls video gmsg.");
                    } else if (str2.equals("true")) {
                        adVideoView.setMediaControllerEnabled(true);
                    } else {
                        adVideoView.setMediaControllerEnabled(false);
                    }
                } else if (str.equals("currentTime")) {
                    String str3 = hashMap.get("time");
                    if (str3 == null) {
                        C0240b.m480a("No \"time\" parameter in a currentTime video gmsg.");
                        return;
                    }
                    try {
                        adVideoView.mo3109a((int) (Float.parseFloat(str3) * 1000.0f));
                    } catch (NumberFormatException e) {
                        C0240b.m480a("Could not parse \"time\" parameter: " + str3);
                    }
                } else if (str.equals("hide")) {
                    adVideoView.setVisibility(4);
                } else if (str.equals("load")) {
                    adVideoView.mo3111b();
                } else if (str.equals("pause")) {
                    adVideoView.mo3112c();
                } else if (str.equals("play")) {
                    adVideoView.mo3113d();
                } else if (str.equals("show")) {
                    adVideoView.setVisibility(0);
                } else if (str.equals("src")) {
                    adVideoView.setSrc(hashMap.get("src"));
                } else {
                    C0240b.m480a("Unknown video action: " + str);
                }
            }
        } else {
            C0240b.m480a("Could not get adWebView for a video gmsg.");
        }
    }
}
