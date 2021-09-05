package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.C0123aa;
import com.google.ads.C0124ab;
import com.google.ads.C0125ac;
import com.google.ads.C0229o;
import com.google.ads.C0230p;
import com.google.ads.C0231q;
import com.google.ads.C0232r;
import com.google.ads.C0233s;
import com.google.ads.C0234t;
import com.google.ads.C0235u;
import com.google.ads.C0266v;
import com.google.ads.C0267w;
import com.google.ads.C0268x;
import com.google.ads.C0269y;
import com.google.ads.C0270z;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import com.google.ads.util.C0248f;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.ads.internal.a */
public class C0188a {

    /* renamed from: a */
    public static final C0248f<C0188a> f402a = new C0248f<C0188a>() {
        /* renamed from: a */
        public C0188a mo3153b() {
            return C0188a.f406e;
        }
    };

    /* renamed from: b */
    public static final Map<String, C0229o> f403b = Collections.unmodifiableMap(new HashMap<String, C0229o>() {
        {
            put("/invalidRequest", new C0266v());
            put("/loadAdURL", new C0267w());
            put("/loadSdkConstants", new C0268x());
            put("/log", new C0269y());
        }
    });

    /* renamed from: c */
    public static final Map<String, C0229o> f404c = Collections.unmodifiableMap(new HashMap<String, C0229o>() {
        {
            put("/log", new C0269y());
            put("/setNativeActivationOverlay", new C0123aa());
        }
    });

    /* renamed from: d */
    public static final Map<String, C0229o> f405d = Collections.unmodifiableMap(new HashMap<String, C0229o>() {
        {
            put("/open", new C0270z());
            put("/canOpenURLs", new C0231q());
            put("/close", new C0233s());
            put("/customClose", new C0234t());
            put("/appEvent", new C0230p());
            put("/log", new C0269y());
            put("/click", new C0232r());
            put("/httpTrack", new C0235u());
            put("/touch", new C0124ab());
            put("/video", new C0125ac());
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static final C0188a f406e = new C0188a();

    /* renamed from: a */
    public String mo3142a(Uri uri, HashMap<String, String> hashMap) {
        if (mo3151c(uri)) {
            String host = uri.getHost();
            if (host == null) {
                C0240b.m490e("An error occurred while parsing the AMSG parameters.");
                return null;
            } else if (host.equals("launch")) {
                hashMap.put("a", "intent");
                hashMap.put(AdActivity.URL_PARAM, hashMap.get("url"));
                hashMap.remove("url");
                return "/open";
            } else if (host.equals("closecanvas")) {
                return "/close";
            } else {
                if (host.equals("log")) {
                    return "/log";
                }
                C0240b.m490e("An error occurred while parsing the AMSG: " + uri.toString());
                return null;
            }
        } else if (mo3150b(uri)) {
            return uri.getPath();
        } else {
            C0240b.m490e("Message was neither a GMSG nor an AMSG.");
            return null;
        }
    }

    /* renamed from: a */
    public void mo3147a(C0203d dVar, Map<String, C0229o> map, Uri uri, WebView webView) {
        HashMap<String, String> b = AdUtil.m457b(uri);
        if (b == null) {
            C0240b.m490e("An error occurred while parsing the message parameters.");
            return;
        }
        String a = mo3142a(uri, b);
        if (a == null) {
            C0240b.m490e("An error occurred while parsing the message.");
            return;
        }
        C0229o oVar = map.get(a);
        if (oVar == null) {
            C0240b.m490e("No AdResponse found, <message: " + a + ">");
        } else {
            oVar.mo2994a(dVar, b, webView);
        }
    }

    /* renamed from: a */
    public boolean mo3148a(Uri uri) {
        if (uri == null || !uri.isHierarchical()) {
            return false;
        }
        if (mo3150b(uri) || mo3151c(uri)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public boolean mo3150b(Uri uri) {
        String authority;
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("gmsg") || (authority = uri.getAuthority()) == null || !authority.equals("mobileads.google.com")) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    public boolean mo3151c(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("admob")) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    public void mo3145a(WebView webView, String str, String str2) {
        if (str2 != null) {
            mo3144a(webView, "AFMA_ReceiveMessage" + "('" + str + "', " + str2 + ");");
        } else {
            mo3144a(webView, "AFMA_ReceiveMessage" + "('" + str + "');");
        }
    }

    /* renamed from: a */
    public void mo3144a(WebView webView, String str) {
        C0240b.m480a("Sending JS to a WebView: " + str);
        webView.loadUrl("javascript:" + str);
    }

    /* renamed from: a */
    public void mo3146a(WebView webView, Map<String, Boolean> map) {
        mo3145a(webView, "openableURLs", new JSONObject(map).toString());
    }

    /* renamed from: a */
    public void mo3143a(WebView webView) {
        mo3145a(webView, "onshow", "{'version': 'afma-sdk-a-v6.4.1'}");
    }

    /* renamed from: b */
    public void mo3149b(WebView webView) {
        mo3145a(webView, "onhide", (String) null);
    }
}
