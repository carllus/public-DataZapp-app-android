package com.google.ads.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdRequest;
import com.google.ads.C0229o;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import com.google.ads.util.C0249g;
import java.util.Map;

/* renamed from: com.google.ads.internal.i */
public class C0210i extends WebViewClient {

    /* renamed from: c */
    private static final C0188a f516c = C0188a.f402a.mo3153b();

    /* renamed from: a */
    protected C0203d f517a;

    /* renamed from: b */
    protected boolean f518b = false;

    /* renamed from: d */
    private final Map<String, C0229o> f519d;

    /* renamed from: e */
    private final boolean f520e;

    /* renamed from: f */
    private boolean f521f;

    /* renamed from: g */
    private boolean f522g;

    /* renamed from: h */
    private boolean f523h = false;

    /* renamed from: i */
    private boolean f524i = false;

    public C0210i(C0203d dVar, Map<String, C0229o> map, boolean z, boolean z2) {
        this.f517a = dVar;
        this.f519d = map;
        this.f520e = z;
        this.f522g = z2;
    }

    /* renamed from: a */
    public static C0210i m399a(C0203d dVar, Map<String, C0229o> map, boolean z, boolean z2) {
        if (AdUtil.f618a >= 11) {
            return new C0249g.C0258b(dVar, map, z, z2);
        }
        return new C0210i(dVar, map, z, z2);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r6, java.lang.String r7) {
        /*
            r5 = this;
            r3 = 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "shouldOverrideUrlLoading(\""
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "\")"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x00cf }
            android.net.Uri r2 = android.net.Uri.parse(r7)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.a r0 = f516c     // Catch:{ Throwable -> 0x00cf }
            boolean r0 = r0.mo3148a((android.net.Uri) r2)     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x0034
            com.google.ads.internal.a r0 = f516c     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r1 = r5.f517a     // Catch:{ Throwable -> 0x00cf }
            java.util.Map<java.lang.String, com.google.ads.o> r4 = r5.f519d     // Catch:{ Throwable -> 0x00cf }
            r0.mo3147a(r1, r4, r2, r6)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
        L_0x0033:
            return r0
        L_0x0034:
            boolean r0 = r5.f522g     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x005b
            boolean r0 = com.google.ads.util.AdUtil.m452a((android.net.Uri) r2)     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x0043
            boolean r0 = super.shouldOverrideUrlLoading(r6, r7)     // Catch:{ Throwable -> 0x00cf }
            goto L_0x0033
        L_0x0043:
            java.util.HashMap r0 = new java.util.HashMap     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "u"
            r0.put(r1, r7)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r1 = r5.f517a     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.e r2 = new com.google.ads.internal.e     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r4 = "intent"
            r2.<init>(r4, r0)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.AdActivity.launchAdActivity(r1, r2)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
            goto L_0x0033
        L_0x005b:
            boolean r0 = r5.f520e     // Catch:{ Throwable -> 0x00cf }
            if (r0 == 0) goto L_0x00b6
            com.google.ads.internal.d r0 = r5.f517a     // Catch:{ am -> 0x009d }
            com.google.ads.n r1 = r0.mo3219i()     // Catch:{ am -> 0x009d }
            com.google.ads.util.i$b<android.content.Context> r0 = r1.f587f     // Catch:{ am -> 0x009d }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ am -> 0x009d }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ am -> 0x009d }
            com.google.ads.util.i$c<com.google.ads.al> r1 = r1.f600s     // Catch:{ am -> 0x009d }
            java.lang.Object r1 = r1.mo3395a()     // Catch:{ am -> 0x009d }
            com.google.ads.al r1 = (com.google.ads.C0148al) r1     // Catch:{ am -> 0x009d }
            if (r1 == 0) goto L_0x00b4
            boolean r4 = r1.mo3013a((android.net.Uri) r2)     // Catch:{ am -> 0x009d }
            if (r4 == 0) goto L_0x00b4
            android.net.Uri r0 = r1.mo3011a(r2, r0)     // Catch:{ am -> 0x009d }
        L_0x0081:
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Throwable -> 0x00cf }
            r1.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r2 = "u"
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            r1.put(r2, r0)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.d r0 = r5.f517a     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.internal.e r2 = new com.google.ads.internal.e     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r4 = "intent"
            r2.<init>(r4, r1)     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.AdActivity.launchAdActivity(r0, r2)     // Catch:{ Throwable -> 0x00cf }
            r0 = r3
            goto L_0x0033
        L_0x009d:
            r0 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0240b.m490e(r0)     // Catch:{ Throwable -> 0x00cf }
        L_0x00b4:
            r0 = r2
            goto L_0x0081
        L_0x00b6:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x00cf }
            r0.<init>()     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r1 = "URL is not a GMSG and can't handle URL: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x00cf }
            java.lang.StringBuilder r0 = r0.append(r7)     // Catch:{ Throwable -> 0x00cf }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x00cf }
            com.google.ads.util.C0240b.m490e(r0)     // Catch:{ Throwable -> 0x00cf }
        L_0x00cc:
            r0 = r3
            goto L_0x0033
        L_0x00cf:
            r0 = move-exception
            java.lang.String r1 = "An unknown error occurred in shouldOverrideUrlLoading."
            com.google.ads.util.C0240b.m489d(r1, r0)
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.C0210i.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public void onPageStarted(WebView webView, String url, Bitmap favicon) {
        this.f521f = true;
    }

    public void onPageFinished(WebView view, String url) {
        this.f521f = false;
        if (this.f523h) {
            C0194c k = this.f517a.mo3221k();
            if (k != null) {
                k.mo3171c();
            } else {
                C0240b.m480a("adLoader was null while trying to setFinishedLoadingHtml().");
            }
            this.f523h = false;
        }
        if (this.f524i) {
            f516c.mo3143a(view);
            this.f524i = false;
        }
    }

    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        this.f521f = false;
        C0194c k = this.f517a.mo3221k();
        if (k != null) {
            k.mo3160a(AdRequest.ErrorCode.NETWORK_ERROR);
        }
    }

    /* renamed from: a */
    public void mo3282a(boolean z) {
        this.f518b = z;
    }

    /* renamed from: b */
    public void mo3284b(boolean z) {
        this.f522g = z;
    }

    /* renamed from: c */
    public void mo3285c(boolean z) {
        this.f523h = z;
    }

    /* renamed from: d */
    public void mo3286d(boolean z) {
        this.f524i = z;
    }

    /* renamed from: a */
    public boolean mo3283a() {
        return this.f521f;
    }
}
