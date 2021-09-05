package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0146ak;
import com.google.ads.C0148al;
import com.google.ads.C0163b;
import com.google.ads.C0164c;
import com.google.ads.C0166d;
import com.google.ads.C0220l;
import com.google.ads.C0221m;
import com.google.ads.C0228n;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;

/* renamed from: com.google.ads.internal.c */
public class C0194c implements Runnable {

    /* renamed from: a */
    boolean f408a;

    /* renamed from: b */
    private String f409b;

    /* renamed from: c */
    private String f410c;

    /* renamed from: d */
    private String f411d;

    /* renamed from: e */
    private String f412e;

    /* renamed from: f */
    private boolean f413f;

    /* renamed from: g */
    private C0205f f414g;

    /* renamed from: h */
    private AdRequest f415h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WebView f416i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public C0220l f417j;

    /* renamed from: k */
    private String f418k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f419l;

    /* renamed from: m */
    private LinkedList<String> f420m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public String f421n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public AdSize f422o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f423p = false;

    /* renamed from: q */
    private volatile boolean f424q;

    /* renamed from: r */
    private boolean f425r;

    /* renamed from: s */
    private AdRequest.ErrorCode f426s;

    /* renamed from: t */
    private boolean f427t;

    /* renamed from: u */
    private int f428u;

    /* renamed from: v */
    private Thread f429v;

    /* renamed from: w */
    private boolean f430w;

    /* renamed from: x */
    private C0201d f431x = C0201d.ONLINE_SERVER_REQUEST;

    /* renamed from: com.google.ads.internal.c$b */
    private class C0199b extends Exception {
        public C0199b(String str) {
            super(str);
        }
    }

    /* renamed from: com.google.ads.internal.c$a */
    private static class C0198a implements Runnable {

        /* renamed from: a */
        private final C0203d f436a;

        /* renamed from: b */
        private final WebView f437b;

        /* renamed from: c */
        private final C0205f f438c;

        /* renamed from: d */
        private final AdRequest.ErrorCode f439d;

        /* renamed from: e */
        private final boolean f440e;

        public C0198a(C0203d dVar, WebView webView, C0205f fVar, AdRequest.ErrorCode errorCode, boolean z) {
            this.f436a = dVar;
            this.f437b = webView;
            this.f438c = fVar;
            this.f439d = errorCode;
            this.f440e = z;
        }

        public void run() {
            if (this.f437b != null) {
                this.f437b.stopLoading();
                this.f437b.destroy();
            }
            if (this.f438c != null) {
                this.f438c.mo3240a();
            }
            if (this.f440e) {
                this.f436a.mo3222l().stopLoading();
                if (this.f436a.mo3219i().f590i.mo3394a() != null) {
                    this.f436a.mo3219i().f590i.mo3394a().setVisibility(8);
                }
            }
            this.f436a.mo3198a(this.f439d);
        }
    }

    /* renamed from: com.google.ads.internal.c$c */
    private class C0200c implements Runnable {

        /* renamed from: b */
        private final String f443b;

        /* renamed from: c */
        private final String f444c;

        /* renamed from: d */
        private final WebView f445d;

        public C0200c(WebView webView, String str, String str2) {
            this.f445d = webView;
            this.f443b = str;
            this.f444c = str2;
        }

        public void run() {
            C0194c.this.f417j.f541c.mo3396a(Boolean.valueOf(C0194c.this.f423p));
            C0194c.this.f417j.f539a.mo3394a().f583b.mo3394a().mo3222l().mo3123a(C0194c.this.f423p);
            if (C0194c.this.f417j.f539a.mo3394a().f586e.mo3394a() != null) {
                C0194c.this.f417j.f539a.mo3394a().f586e.mo3394a().setOverlayEnabled(!C0194c.this.f423p);
            }
            if (this.f444c != null) {
                this.f445d.loadDataWithBaseURL(this.f443b, this.f444c, "text/html", "utf-8", (String) null);
            } else {
                this.f445d.loadUrl(this.f443b);
            }
        }
    }

    /* renamed from: com.google.ads.internal.c$e */
    private class C0202e implements Runnable {

        /* renamed from: b */
        private final C0203d f453b;

        /* renamed from: c */
        private final WebView f454c;

        /* renamed from: d */
        private final LinkedList<String> f455d;

        /* renamed from: e */
        private final int f456e;

        /* renamed from: f */
        private final boolean f457f;

        /* renamed from: g */
        private final String f458g;

        /* renamed from: h */
        private final AdSize f459h;

        public C0202e(C0203d dVar, WebView webView, LinkedList<String> linkedList, int i, boolean z, String str, AdSize adSize) {
            this.f453b = dVar;
            this.f454c = webView;
            this.f455d = linkedList;
            this.f456e = i;
            this.f457f = z;
            this.f458g = str;
            this.f459h = adSize;
        }

        public void run() {
            if (this.f454c != null) {
                this.f454c.stopLoading();
                this.f454c.destroy();
            }
            this.f453b.mo3205a(this.f455d);
            this.f453b.mo3193a(this.f456e);
            this.f453b.mo3206a(this.f457f);
            this.f453b.mo3203a(this.f458g);
            if (this.f459h != null) {
                C0194c.this.f417j.f539a.mo3394a().f588g.mo3394a().mo3279b(this.f459h);
                this.f453b.mo3222l().setAdSize(this.f459h);
            }
            this.f453b.mo3189E();
        }
    }

    /* renamed from: com.google.ads.internal.c$d */
    public enum C0201d {
        ONLINE_USING_BUFFERED_ADS("online_buffered"),
        ONLINE_SERVER_REQUEST("online_request"),
        OFFLINE_USING_BUFFERED_ADS("offline_buffered"),
        OFFLINE_EMPTY("offline_empty");
        

        /* renamed from: e */
        public String f451e;

        private C0201d(String str) {
            this.f451e = str;
        }
    }

    /* renamed from: a */
    public synchronized void mo3167a(boolean z) {
        this.f423p = z;
    }

    protected C0194c() {
    }

    public C0194c(C0220l lVar) {
        this.f417j = lVar;
        this.f418k = null;
        this.f409b = null;
        this.f410c = null;
        this.f411d = null;
        this.f420m = new LinkedList<>();
        this.f426s = null;
        this.f427t = false;
        this.f428u = -1;
        this.f413f = false;
        this.f425r = false;
        this.f421n = null;
        this.f422o = null;
        if (lVar.f539a.mo3394a().f584c.mo3397a() != null) {
            this.f416i = new AdWebView(lVar.f539a.mo3394a(), (AdSize) null);
            this.f416i.setWebViewClient(C0210i.m399a(lVar.f539a.mo3394a().f583b.mo3394a(), C0188a.f403b, false, false));
            this.f416i.setVisibility(8);
            this.f416i.setWillNotDraw(true);
            this.f414g = new C0205f(lVar);
            return;
        }
        this.f416i = null;
        this.f414g = null;
        C0240b.m490e("activity was null while trying to create an AdLoader.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3165a(String str) {
        this.f420m.add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3158a() {
        C0240b.m480a("AdLoader cancelled.");
        if (this.f416i != null) {
            this.f416i.stopLoading();
            this.f416i.destroy();
        }
        if (this.f429v != null) {
            this.f429v.interrupt();
            this.f429v = null;
        }
        if (this.f414g != null) {
            this.f414g.mo3240a();
        }
        this.f424q = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3162a(AdRequest adRequest) {
        this.f415h = adRequest;
        this.f424q = false;
        this.f429v = new Thread(this);
        this.f429v.start();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x01e9 A[Catch:{ Throwable -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02f2 A[SYNTHETIC, Splitter:B:147:0x02f2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r12 = this;
            r3 = 0
            r10 = 0
            monitor-enter(r12)
            android.webkit.WebView r0 = r12.f416i     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x000c
            com.google.ads.internal.f r0 = r12.f414g     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0019
        L_0x000c:
            java.lang.String r0 = "adRequestWebView was null while trying to load an ad."
            com.google.ads.util.C0240b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
        L_0x0018:
            return
        L_0x0019:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$d<android.app.Activity> r0 = r0.f584c     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3397a()     // Catch:{ Throwable -> 0x0115 }
            android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x003d
            java.lang.String r0 = "activity was null while forming an ad request."
            com.google.ads.util.C0240b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x003a:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            com.google.ads.l r1 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0228n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r1 = r1.f583b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r1 = (com.google.ads.internal.C0203d) r1     // Catch:{ Throwable -> 0x0115 }
            long r4 = r1.mo3226p()     // Catch:{ Throwable -> 0x0115 }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest r2 = r12.f415h     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.l r1 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0228n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<android.content.Context> r1 = r1.f587f     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            android.content.Context r1 = (android.content.Context) r1     // Catch:{ Throwable -> 0x0115 }
            java.util.Map r8 = r2.getRequestMap(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "extras"
            java.lang.Object r1 = r8.get(r1)     // Catch:{ Throwable -> 0x0115 }
            boolean r2 = r1 instanceof java.util.Map     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00e1
            java.util.Map r1 = (java.util.Map) r1     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "_adUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0089
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f409b = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x0089:
            java.lang.String r2 = "_requestUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0097
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f418k = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x0097:
            java.lang.String r2 = "_activationOverlayUrl"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x00a5
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Throwable -> 0x0115 }
            r12.f419l = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x00a5:
            java.lang.String r2 = "_orientation"
            java.lang.Object r2 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r9 = r2 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x00ba
            java.lang.String r9 = "p"
            boolean r9 = r2.equals(r9)     // Catch:{ Throwable -> 0x0115 }
            if (r9 == 0) goto L_0x0109
            r2 = 1
            r12.f428u = r2     // Catch:{ Throwable -> 0x0115 }
        L_0x00ba:
            java.lang.String r2 = "_norefresh"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ Throwable -> 0x0115 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00e1
            java.lang.String r2 = "t"
            boolean r1 = r1.equals(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x00e1
            com.google.ads.l r1 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r1 = r1.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r1 = (com.google.ads.C0228n) r1     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r1 = r1.f583b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r1 = r1.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r1 = (com.google.ads.internal.C0203d) r1     // Catch:{ Throwable -> 0x0115 }
            r1.mo3215e()     // Catch:{ Throwable -> 0x0115 }
        L_0x00e1:
            java.lang.String r1 = r12.f409b     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x030e
            java.lang.String r1 = r12.f418k     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x01c2
            java.lang.String r0 = r12.mo3157a((java.util.Map<java.lang.String, java.lang.Object>) r8, (android.app.Activity) r0)     // Catch:{ b -> 0x0124 }
            java.lang.String r1 = r12.m250f()     // Catch:{ Throwable -> 0x0115 }
            r12.m243b(r0, r1)     // Catch:{ Throwable -> 0x0115 }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Throwable -> 0x0115 }
            long r0 = r0 - r6
            long r0 = r4 - r0
            int r2 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r2 <= 0) goto L_0x0102
            r12.wait(r0)     // Catch:{ InterruptedException -> 0x0144 }
        L_0x0102:
            boolean r0 = r12.f424q     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x015e
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0109:
            java.lang.String r9 = "l"
            boolean r2 = r2.equals(r9)     // Catch:{ Throwable -> 0x0115 }
            if (r2 == 0) goto L_0x00ba
            r2 = 0
            r12.f428u = r2     // Catch:{ Throwable -> 0x0115 }
            goto L_0x00ba
        L_0x0115:
            r0 = move-exception
            java.lang.String r1 = "An unknown error occurred in AdLoader."
            com.google.ads.util.C0240b.m485b(r1, r0)     // Catch:{ all -> 0x003a }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ all -> 0x003a }
            r1 = 1
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ all -> 0x003a }
        L_0x0121:
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0124:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "Caught internal exception: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0144:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while getting the URL: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x015e:
            com.google.ads.AdRequest$ErrorCode r0 = r12.f426s     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x016b
            com.google.ads.AdRequest$ErrorCode r0 = r12.f426s     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x016b:
            java.lang.String r0 = r12.f418k     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0194
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while getting the URL."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0194:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f588g     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0209h) r0     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.mo3280b()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = r12.f419l     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = "AdLoader doesn't have a URL for the activation overlay"
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x01c2:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f583b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0203d) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.g r0 = r0.mo3224n()     // Catch:{ Throwable -> 0x0115 }
            int[] r1 = com.google.ads.internal.C0194c.C01973.f435a     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.c$d r2 = r12.f431x     // Catch:{ Throwable -> 0x0115 }
            int r2 = r2.ordinal()     // Catch:{ Throwable -> 0x0115 }
            r1 = r1[r2]     // Catch:{ Throwable -> 0x0115 }
            switch(r1) {
                case 1: goto L_0x0278;
                case 2: goto L_0x0288;
                case 3: goto L_0x0292;
                case 4: goto L_0x029f;
                default: goto L_0x01e5;
            }     // Catch:{ Throwable -> 0x0115 }
        L_0x01e5:
            boolean r0 = r12.f408a     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x02f2
            java.lang.String r0 = "Not using loadUrl()."
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.f r0 = r12.f414g     // Catch:{ Throwable -> 0x0115 }
            boolean r1 = r12.f430w     // Catch:{ Throwable -> 0x0115 }
            r0.mo3242a((boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f588g     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0209h) r0     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.mo3280b()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0479
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.ActivationOverlay> r0 = r0.f586e     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.ActivationOverlay r0 = (com.google.ads.internal.ActivationOverlay) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.i r3 = r0.mo3102e()     // Catch:{ Throwable -> 0x0115 }
            r0 = 1
            r3.mo3285c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.m r0 = com.google.ads.C0221m.m411a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<android.os.Handler> r0 = r0.f545c     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            android.os.Handler r0 = (android.os.Handler) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.c$1 r1 = new com.google.ads.internal.c$1     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            r0.post(r1)     // Catch:{ Throwable -> 0x0115 }
            r0 = r3
        L_0x023c:
            com.google.ads.internal.f r1 = r12.f414g     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = r12.f418k     // Catch:{ Throwable -> 0x0115 }
            r1.mo3241a((java.lang.String) r2)     // Catch:{ Throwable -> 0x0115 }
        L_0x0243:
            boolean r1 = r12.f424q     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            com.google.ads.AdRequest$ErrorCode r1 = r12.f426s     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            java.lang.String r1 = r12.f410c     // Catch:{ InterruptedException -> 0x025e }
            if (r1 != 0) goto L_0x02b5
            long r1 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x025e }
            long r1 = r1 - r6
            long r1 = r4 - r1
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x02b5
            r12.wait(r1)     // Catch:{ InterruptedException -> 0x025e }
            goto L_0x0243
        L_0x025e:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while getting the ad server's response: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0278:
            r0.mo3268r()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3271u()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3274x()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Online server request."
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x0288:
            r0.mo3270t()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Online using buffered ads."
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x0292:
            r0.mo3273w()     // Catch:{ Throwable -> 0x0115 }
            r0.mo3267q()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Offline using buffered ads."
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x01e5
        L_0x029f:
            r0.mo3267q()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Request scenario: Offline with no buffered ads."
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = "Network is unavailable.  Aborting ad request."
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02b5:
            boolean r1 = r12.f424q     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x02bc
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02bc:
            com.google.ads.AdRequest$ErrorCode r1 = r12.f426s     // Catch:{ Throwable -> 0x0115 }
            if (r1 == 0) goto L_0x02c9
            com.google.ads.AdRequest$ErrorCode r0 = r12.f426s     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02c9:
            java.lang.String r1 = r12.f410c     // Catch:{ Throwable -> 0x0115 }
            if (r1 != 0) goto L_0x0476
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while waiting for the ad server's response."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x02f2:
            java.lang.String r0 = r12.f418k     // Catch:{ Throwable -> 0x0115 }
            r12.f409b = r0     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "Using loadUrl.  adBaseUrl: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = r12.f409b     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
        L_0x030e:
            r1 = r3
        L_0x030f:
            boolean r0 = r12.f408a     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x03e1
            boolean r0 = r12.f413f     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0333
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f583b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0203d) r0     // Catch:{ Throwable -> 0x0115 }
            r1 = 1
            r0.mo3211b((boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            r12.mo3168b()     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0333:
            java.lang.String r0 = r12.f412e     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0372
            java.lang.String r0 = r12.f412e     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "application/json"
            boolean r0 = r0.startsWith(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x034b
            java.lang.String r0 = r12.f412e     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "text/javascript"
            boolean r0 = r0.startsWith(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0372
        L_0x034b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "Expected HTML but received "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = r12.f412e     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0372:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$c<com.google.ads.AdSize[]> r0 = r0.f595n     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3395a()     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x03d5
            com.google.ads.AdSize r0 = r12.f422o     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x0396
            java.lang.String r0 = "Multiple supported ad sizes were specified, but the server did not respond with a size."
            com.google.ads.util.C0240b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0396:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$c<com.google.ads.AdSize[]> r0 = r0.f595n     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3395a()     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object[] r0 = (java.lang.Object[]) r0     // Catch:{ Throwable -> 0x0115 }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdSize r2 = r12.f422o     // Catch:{ Throwable -> 0x0115 }
            boolean r0 = r0.contains(r2)     // Catch:{ Throwable -> 0x0115 }
            if (r0 != 0) goto L_0x03e1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "The ad server did not respond with a supported AdSize: "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdSize r1 = r12.f422o     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m484b(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 0
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x03d5:
            com.google.ads.AdSize r0 = r12.f422o     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x03e1
            java.lang.String r0 = "adSize was expected to be null in AdLoader."
            com.google.ads.util.C0240b.m490e(r0)     // Catch:{ Throwable -> 0x0115 }
            r0 = 0
            r12.f422o = r0     // Catch:{ Throwable -> 0x0115 }
        L_0x03e1:
            com.google.ads.l r0 = r12.f417j     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.i$b<com.google.ads.internal.d> r0 = r0.f583b     // Catch:{ Throwable -> 0x0115 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.internal.d r0 = (com.google.ads.internal.C0203d) r0     // Catch:{ Throwable -> 0x0115 }
            r2 = 0
            r0.mo3211b((boolean) r2)     // Catch:{ Throwable -> 0x0115 }
            r12.m253i()     // Catch:{ Throwable -> 0x0115 }
        L_0x03fa:
            boolean r0 = r12.f424q     // Catch:{ InterruptedException -> 0x042f }
            if (r0 != 0) goto L_0x0449
            boolean r0 = r12.f427t     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0420
            com.google.ads.l r0 = r12.f417j     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.util.i$b<com.google.ads.n> r0 = r0.f539a     // Catch:{ InterruptedException -> 0x042f }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.n r0 = (com.google.ads.C0228n) r0     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.util.i$b<com.google.ads.internal.h> r0 = r0.f588g     // Catch:{ InterruptedException -> 0x042f }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ InterruptedException -> 0x042f }
            com.google.ads.internal.h r0 = (com.google.ads.internal.C0209h) r0     // Catch:{ InterruptedException -> 0x042f }
            boolean r0 = r0.mo3280b()     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0449
            boolean r0 = r1.mo3283a()     // Catch:{ InterruptedException -> 0x042f }
            if (r0 == 0) goto L_0x0449
        L_0x0420:
            long r2 = android.os.SystemClock.elapsedRealtime()     // Catch:{ InterruptedException -> 0x042f }
            long r2 = r2 - r6
            long r2 = r4 - r2
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 <= 0) goto L_0x0449
            r12.wait(r2)     // Catch:{ InterruptedException -> 0x042f }
            goto L_0x03fa
        L_0x042f:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r1.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r2 = "AdLoader InterruptedException while loading the HTML: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)     // Catch:{ Throwable -> 0x0115 }
            monitor-exit(r12)     // Catch:{ all -> 0x003a }
            goto L_0x0018
        L_0x0449:
            boolean r0 = r12.f427t     // Catch:{ Throwable -> 0x0115 }
            if (r0 == 0) goto L_0x0452
            r12.m254j()     // Catch:{ Throwable -> 0x0115 }
            goto L_0x0121
        L_0x0452:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0115 }
            r0.<init>()     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "AdLoader timed out after "
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r1 = "ms while loading the HTML."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Throwable -> 0x0115 }
            java.lang.String r0 = r0.toString()     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.util.C0240b.m486c(r0)     // Catch:{ Throwable -> 0x0115 }
            com.google.ads.AdRequest$ErrorCode r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR     // Catch:{ Throwable -> 0x0115 }
            r1 = 1
            r12.mo3161a((com.google.ads.AdRequest.ErrorCode) r0, (boolean) r1)     // Catch:{ Throwable -> 0x0115 }
            goto L_0x0121
        L_0x0476:
            r1 = r0
            goto L_0x030f
        L_0x0479:
            r0 = r3
            goto L_0x023c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.C0194c.run():void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo3168b() {
        try {
            if (TextUtils.isEmpty(this.f412e)) {
                C0240b.m484b("Got a mediation response with no content type. Aborting mediation.");
                mo3161a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else if (!this.f412e.startsWith("application/json")) {
                C0240b.m484b("Got a mediation response with a content type: '" + this.f412e + "'. Expected something starting with 'application/json'. Aborting mediation.");
                mo3161a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
            } else {
                final C0164c a = C0164c.m138a(this.f410c);
                m240a(this.f411d, a, this.f417j.f539a.mo3394a().f583b.mo3394a().mo3220j());
                C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                    public void run() {
                        if (C0194c.this.f416i != null) {
                            C0194c.this.f416i.stopLoading();
                            C0194c.this.f416i.destroy();
                        }
                        C0194c.this.f417j.f539a.mo3394a().f583b.mo3394a().mo3203a(C0194c.this.f421n);
                        if (C0194c.this.f422o != null) {
                            C0194c.this.f417j.f539a.mo3394a().f588g.mo3394a().mo3279b(C0194c.this.f422o);
                        }
                        C0194c.this.f417j.f539a.mo3394a().f583b.mo3394a().mo3200a(a);
                    }
                });
            }
        } catch (JSONException e) {
            C0240b.m485b("AdLoader can't parse gWhirl server configuration.", e);
            mo3161a(AdRequest.ErrorCode.INTERNAL_ERROR, false);
        }
    }

    /* renamed from: a */
    static void m240a(String str, C0164c cVar, C0166d dVar) {
        if (str != null && !str.contains("no-store") && !str.contains("no-cache")) {
            Matcher matcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(str);
            if (matcher.find()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    dVar.mo3041a(cVar, parseInt);
                    C0240b.m486c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[]{Integer.valueOf(parseInt)}));
                } catch (NumberFormatException e) {
                    C0240b.m485b("Caught exception trying to parse cache control directive. Overflow?", e);
                }
            } else {
                C0240b.m486c("Unrecognized cacheControlDirective: '" + str + "'. Not caching configuration.");
            }
        }
    }

    /* renamed from: a */
    public String mo3157a(Map<String, Object> map, Activity activity) throws C0199b {
        int i;
        Context applicationContext = activity.getApplicationContext();
        C0208g n = this.f417j.f539a.mo3394a().f583b.mo3394a().mo3224n();
        long m = n.mo3263m();
        if (m > 0) {
            map.put("prl", Long.valueOf(m));
        }
        long n2 = n.mo3264n();
        if (n2 > 0) {
            map.put("prnl", Long.valueOf(n2));
        }
        String l = n.mo3262l();
        if (l != null) {
            map.put("ppcl", l);
        }
        String k = n.mo3261k();
        if (k != null) {
            map.put("pcl", k);
        }
        long j = n.mo3260j();
        if (j > 0) {
            map.put("pcc", Long.valueOf(j));
        }
        map.put("preqs", Long.valueOf(n.mo3265o()));
        map.put("oar", Long.valueOf(n.mo3266p()));
        map.put("bas_on", Long.valueOf(n.mo3269s()));
        map.put("bas_off", Long.valueOf(n.mo3272v()));
        if (n.mo3275y()) {
            map.put("aoi_timeout", "true");
        }
        if (n.mo3245A()) {
            map.put("aoi_nofill", "true");
        }
        String D = n.mo3248D();
        if (D != null) {
            map.put("pit", D);
        }
        map.put("ptime", Long.valueOf(C0208g.m359E()));
        n.mo3249a();
        n.mo3259i();
        if (this.f417j.f539a.mo3394a().mo3353b()) {
            map.put("format", "interstitial_mb");
        } else {
            AdSize c = this.f417j.f539a.mo3394a().f588g.mo3394a().mo3281c();
            if (c.isFullWidth()) {
                map.put("smart_w", "full");
            }
            if (c.isAutoHeight()) {
                map.put("smart_h", "auto");
            }
            if (!c.isCustomAdSize()) {
                map.put("format", c.toString());
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("w", Integer.valueOf(c.getWidth()));
                hashMap.put("h", Integer.valueOf(c.getHeight()));
                map.put("ad_frame", hashMap);
            }
        }
        map.put("slotname", this.f417j.f539a.mo3394a().f589h.mo3394a());
        map.put("js", "afma-sdk-a-v6.4.1");
        try {
            int i2 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            String f = AdUtil.m465f(applicationContext);
            if (!TextUtils.isEmpty(f)) {
                map.put("mv", f);
            }
            String a = C0221m.m411a().f543a.mo3395a();
            if (!TextUtils.isEmpty(a)) {
                map.put("imbf", a);
            }
            map.put("msid", applicationContext.getPackageName());
            map.put("app_name", i2 + ".android." + applicationContext.getPackageName());
            map.put("isu", AdUtil.m441a(applicationContext));
            String d = AdUtil.m462d(applicationContext);
            if (d == null) {
                d = "null";
            }
            map.put("net", d);
            String e = AdUtil.m464e(applicationContext);
            if (!(e == null || e.length() == 0)) {
                map.put("cap", e);
            }
            map.put("u_audio", Integer.valueOf(AdUtil.m466g(applicationContext).ordinal()));
            DisplayMetrics a2 = AdUtil.m440a(activity);
            map.put("u_sd", Float.valueOf(a2.density));
            map.put("u_h", Integer.valueOf(AdUtil.m438a(applicationContext, a2)));
            map.put("u_w", Integer.valueOf(AdUtil.m455b(applicationContext, a2)));
            map.put("hl", Locale.getDefault().getLanguage());
            C0228n a3 = this.f417j.f539a.mo3394a();
            C0146ak a4 = a3.f599r.mo3395a();
            if (a4 == null) {
                a4 = C0146ak.m71a("afma-sdk-a-v6.4.1", (Context) activity);
                a3.f599r.mo3396a(a4);
                a3.f600s.mo3396a(new C0148al(a4));
            }
            map.put("ms", a4.mo3001a(applicationContext));
            if (!(this.f417j.f539a.mo3394a().f591j == null || this.f417j.f539a.mo3394a().f591j.mo3394a() == null)) {
                AdView a5 = this.f417j.f539a.mo3394a().f591j.mo3394a();
                if (a5.getParent() != null) {
                    int[] iArr = new int[2];
                    a5.getLocationOnScreen(iArr);
                    int i3 = iArr[0];
                    int i4 = iArr[1];
                    DisplayMetrics displayMetrics = this.f417j.f539a.mo3394a().f587f.mo3394a().getResources().getDisplayMetrics();
                    int i5 = displayMetrics.widthPixels;
                    int i6 = displayMetrics.heightPixels;
                    if (!a5.isShown() || a5.getWidth() + i3 <= 0 || a5.getHeight() + i4 <= 0 || i3 > i5 || i4 > i6) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("x", Integer.valueOf(i3));
                    hashMap2.put("y", Integer.valueOf(i4));
                    hashMap2.put("width", Integer.valueOf(a5.getWidth()));
                    hashMap2.put("height", Integer.valueOf(a5.getHeight()));
                    hashMap2.put("visible", Integer.valueOf(i));
                    map.put("ad_pos", hashMap2);
                }
            }
            StringBuilder sb = new StringBuilder();
            AdSize[] a6 = this.f417j.f539a.mo3394a().f595n.mo3395a();
            if (a6 != null) {
                for (AdSize adSize : a6) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSize.getWidth() + "x" + adSize.getHeight());
                }
                map.put("sz", sb.toString());
            }
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                map.put("carrier", networkOperator);
            }
            map.put("pt", Integer.valueOf(telephonyManager.getPhoneType()));
            map.put("gnt", Integer.valueOf(telephonyManager.getNetworkType()));
            if (AdUtil.m460c()) {
                map.put("simulator", 1);
            }
            map.put("session_id", C0163b.m132a().mo3029b().toString());
            map.put("seq_num", C0163b.m132a().mo3030c().toString());
            if (this.f417j.f539a.mo3394a().f588g.mo3394a().mo3280b()) {
                map.put("swipeable", 1);
            }
            if (this.f417j.f539a.mo3394a().f601t.mo3395a().booleanValue()) {
                map.put("d_imp_hdr", 1);
            }
            String a7 = AdUtil.m443a(map);
            String str = this.f417j.f539a.mo3394a().f585d.mo3394a().f544b.mo3394a().f560o.mo3395a().booleanValue() ? m251g() + m246d() + "(" + a7 + ");" + m252h() : m251g() + m247e() + m246d() + "(" + a7 + ");" + m252h();
            C0240b.m486c("adRequestUrlHtml: " + str);
            return str;
        } catch (PackageManager.NameNotFoundException e2) {
            throw new C0199b("NameNotFoundException");
        }
    }

    /* renamed from: d */
    private String m246d() {
        if (this.f415h instanceof SearchAdRequest) {
            return "AFMA_buildAdURL";
        }
        return "AFMA_buildAdURL";
    }

    /* renamed from: e */
    private String m247e() {
        if (this.f415h instanceof SearchAdRequest) {
            return "AFMA_getSdkConstants();";
        }
        return "AFMA_getSdkConstants();";
    }

    /* renamed from: f */
    private String m250f() {
        if (this.f415h instanceof SearchAdRequest) {
            return "http://www.gstatic.com/safa/";
        }
        return "http://media.admob.com/";
    }

    /* renamed from: g */
    private String m251g() {
        if (this.f415h instanceof SearchAdRequest) {
            return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
        }
        return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    }

    /* renamed from: h */
    private String m252h() {
        if (this.f415h instanceof SearchAdRequest) {
            return "</script></head><body></body></html>";
        }
        return "</script></head><body></body></html>";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3161a(AdRequest.ErrorCode errorCode, boolean z) {
        C0221m.m411a().f545c.mo3394a().post(new C0198a(this.f417j.f539a.mo3394a().f583b.mo3394a(), this.f416i, this.f414g, errorCode, z));
    }

    /* renamed from: b */
    private void m243b(String str, String str2) {
        C0221m.m411a().f545c.mo3394a().post(new C0200c(this.f416i, str2, str));
    }

    /* renamed from: i */
    private void m253i() {
        AdWebView l = this.f417j.f539a.mo3394a().f583b.mo3394a().mo3222l();
        this.f417j.f539a.mo3394a().f583b.mo3394a().mo3223m().mo3285c(true);
        this.f417j.f539a.mo3394a().f583b.mo3394a().mo3224n().mo3258h();
        C0221m.m411a().f545c.mo3394a().post(new C0200c(l, this.f409b, this.f410c));
    }

    /* renamed from: j */
    private void m254j() {
        C0221m.m411a().f545c.mo3394a().post(new C0202e(this.f417j.f539a.mo3394a().f583b.mo3394a(), this.f416i, this.f420m, this.f428u, this.f425r, this.f421n, this.f422o));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3170b(boolean z) {
        this.f413f = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3169b(String str) {
        this.f412e = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3166a(String str, String str2) {
        this.f409b = str2;
        this.f410c = str;
        notify();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3172c(String str) {
        this.f411d = str;
    }

    /* renamed from: d */
    public synchronized void mo3174d(String str) {
        this.f418k = str;
        notify();
    }

    /* renamed from: e */
    public synchronized void mo3176e(String str) {
        this.f419l = str;
    }

    /* renamed from: f */
    public synchronized void mo3178f(String str) {
        this.f421n = str;
    }

    /* renamed from: a */
    public synchronized void mo3163a(AdSize adSize) {
        this.f422o = adSize;
    }

    /* renamed from: a */
    public synchronized void mo3160a(AdRequest.ErrorCode errorCode) {
        this.f426s = errorCode;
        notify();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3171c() {
        this.f427t = true;
        notify();
    }

    /* renamed from: c */
    public synchronized void mo3173c(boolean z) {
        this.f425r = z;
    }

    /* renamed from: a */
    public synchronized void mo3159a(int i) {
        this.f428u = i;
    }

    /* renamed from: d */
    public synchronized void mo3175d(boolean z) {
        this.f430w = z;
    }

    /* renamed from: a */
    public synchronized void mo3164a(C0201d dVar) {
        this.f431x = dVar;
    }

    /* renamed from: e */
    public synchronized void mo3177e(boolean z) {
        this.f408a = z;
    }
}
