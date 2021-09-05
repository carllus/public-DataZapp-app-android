package com.google.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.support.p000v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0188a;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0204e;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import com.google.ads.util.C0247e;
import com.google.ads.util.C0249g;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AdActivity extends Activity implements View.OnClickListener {
    public static final String BASE_URL_PARAM = "baseurl";
    public static final String COMPONENT_NAME_PARAM = "c";
    public static final String CUSTOM_CLOSE_PARAM = "custom_close";
    public static final String HTML_PARAM = "html";
    public static final String INTENT_ACTION_PARAM = "i";
    public static final String INTENT_EXTRAS_PARAM = "e";
    public static final String INTENT_FLAGS_PARAM = "f";
    public static final String ORIENTATION_PARAM = "o";
    public static final String PACKAGE_NAME_PARAM = "p";
    public static final String TYPE_PARAM = "m";
    public static final String URL_PARAM = "u";

    /* renamed from: a */
    private static final C0188a f3a = C0188a.f402a.mo3153b();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final Object f4b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static AdActivity f5c = null;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static C0203d f6d = null;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static AdActivity f7e = null;

    /* renamed from: f */
    private static AdActivity f8f = null;

    /* renamed from: g */
    private static final StaticMethodWrapper f9g = new StaticMethodWrapper();

    /* renamed from: h */
    private AdWebView f10h;

    /* renamed from: i */
    private FrameLayout f11i;

    /* renamed from: j */
    private int f12j;

    /* renamed from: k */
    private ViewGroup f13k = null;

    /* renamed from: l */
    private boolean f14l;

    /* renamed from: m */
    private long f15m;

    /* renamed from: n */
    private RelativeLayout f16n;

    /* renamed from: o */
    private AdActivity f17o = null;

    /* renamed from: p */
    private boolean f18p;

    /* renamed from: q */
    private boolean f19q;

    /* renamed from: r */
    private boolean f20r;

    /* renamed from: s */
    private boolean f21s;

    /* renamed from: t */
    private AdVideoView f22t;

    public static class StaticMethodWrapper {
        public boolean isShowing() {
            boolean z;
            synchronized (AdActivity.f4b) {
                z = AdActivity.f7e != null;
            }
            return z;
        }

        public boolean leftApplication() {
            boolean z;
            synchronized (AdActivity.f4b) {
                z = AdActivity.f5c != null;
            }
            return z;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0033, code lost:
            r1 = new android.content.Intent(r0.getApplicationContext(), com.google.ads.AdActivity.class);
            r1.putExtra("com.google.ads.AdOpener", r6.mo3237a());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            com.google.ads.util.C0240b.m480a("Launching AdActivity.");
            r0.startActivity(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0050, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
            com.google.ads.util.C0240b.m485b("Activity not found.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x000f, code lost:
            r0 = r5.mo3219i().f584c.mo3397a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
            if (r0 != null) goto L_0x0033;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
            com.google.ads.util.C0240b.m490e("activity was null while launching an AdActivity.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void launchAdActivity(com.google.ads.internal.C0203d r5, com.google.ads.internal.C0204e r6) {
            /*
                r4 = this;
                java.lang.Object r1 = com.google.ads.AdActivity.f4b
                monitor-enter(r1)
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.f6d     // Catch:{ all -> 0x0030 }
                if (r0 != 0) goto L_0x0023
                com.google.ads.internal.C0203d unused = com.google.ads.AdActivity.f6d = r5     // Catch:{ all -> 0x0030 }
            L_0x000e:
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                com.google.ads.n r0 = r5.mo3219i()
                com.google.ads.util.i$d<android.app.Activity> r0 = r0.f584c
                java.lang.Object r0 = r0.mo3397a()
                android.app.Activity r0 = (android.app.Activity) r0
                if (r0 != 0) goto L_0x0033
                java.lang.String r0 = "activity was null while launching an AdActivity."
                com.google.ads.util.C0240b.m490e(r0)
            L_0x0022:
                return
            L_0x0023:
                com.google.ads.internal.d r0 = com.google.ads.AdActivity.f6d     // Catch:{ all -> 0x0030 }
                if (r0 == r5) goto L_0x000e
                java.lang.String r0 = "Tried to launch a new AdActivity with a different AdManager."
                com.google.ads.util.C0240b.m484b(r0)     // Catch:{ all -> 0x0030 }
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                goto L_0x0022
            L_0x0030:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0030 }
                throw r0
            L_0x0033:
                android.content.Intent r1 = new android.content.Intent
                android.content.Context r2 = r0.getApplicationContext()
                java.lang.Class<com.google.ads.AdActivity> r3 = com.google.ads.AdActivity.class
                r1.<init>(r2, r3)
                java.lang.String r2 = "com.google.ads.AdOpener"
                android.os.Bundle r3 = r6.mo3237a()
                r1.putExtra(r2, r3)
                java.lang.String r2 = "Launching AdActivity."
                com.google.ads.util.C0240b.m480a((java.lang.String) r2)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                r0.startActivity(r1)     // Catch:{ ActivityNotFoundException -> 0x0050 }
                goto L_0x0022
            L_0x0050:
                r0 = move-exception
                java.lang.String r1 = "Activity not found."
                com.google.ads.util.C0240b.m485b(r1, r0)
                goto L_0x0022
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.StaticMethodWrapper.launchAdActivity(com.google.ads.internal.d, com.google.ads.internal.e):void");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public View mo2912a(int i, boolean z) {
        this.f12j = (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        this.f11i = new FrameLayout(getApplicationContext());
        this.f11i.setMinimumWidth(this.f12j);
        this.f11i.setMinimumHeight(this.f12j);
        this.f11i.setOnClickListener(this);
        setCustomClose(z);
        return this.f11i;
    }

    /* renamed from: a */
    private void m4a(String str) {
        C0240b.m484b(str);
        finish();
    }

    /* renamed from: a */
    private void m5a(String str, Throwable th) {
        C0240b.m485b(str, th);
        finish();
    }

    public AdVideoView getAdVideoView() {
        return this.f22t;
    }

    public AdWebView getOpeningAdWebView() {
        if (this.f17o != null) {
            return this.f17o.f10h;
        }
        synchronized (f4b) {
            if (f6d == null) {
                C0240b.m490e("currentAdManager was null while trying to get the opening AdWebView.");
                return null;
            }
            AdWebView l = f6d.mo3222l();
            if (l != this.f10h) {
                return l;
            }
            return null;
        }
    }

    public static boolean isShowing() {
        return f9g.isShowing();
    }

    public static boolean leftApplication() {
        return f9g.leftApplication();
    }

    public static void launchAdActivity(C0203d adManager, C0204e adOpener) {
        f9g.launchAdActivity(adManager, adOpener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2916a(HashMap<String, String> hashMap, C0203d dVar) {
        boolean z;
        int i;
        if (hashMap == null) {
            m4a("Could not get the paramMap in launchIntent()");
            return;
        }
        Intent intent = new Intent();
        String str = hashMap.get(URL_PARAM);
        String str2 = hashMap.get(TYPE_PARAM);
        String str3 = hashMap.get(INTENT_ACTION_PARAM);
        String str4 = hashMap.get(PACKAGE_NAME_PARAM);
        String str5 = hashMap.get(COMPONENT_NAME_PARAM);
        String str6 = hashMap.get(INTENT_FLAGS_PARAM);
        String str7 = hashMap.get(INTENT_EXTRAS_PARAM);
        boolean z2 = !TextUtils.isEmpty(str);
        if (!TextUtils.isEmpty(str2)) {
            z = true;
        } else {
            z = false;
        }
        if (z2 && z) {
            intent.setDataAndType(Uri.parse(str), str2);
        } else if (z2) {
            intent.setData(Uri.parse(str));
        } else if (z) {
            intent.setType(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.setAction(str3);
        } else if (z2) {
            intent.setAction("android.intent.action.VIEW");
        }
        if (!TextUtils.isEmpty(str4) && AdUtil.f618a >= 4) {
            C0247e.m499a(intent, str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            String[] split = str5.split("/");
            if (split.length < 2) {
                C0240b.m490e("Warning: Could not parse component name from open GMSG: " + str5);
            }
            intent.setClassName(split[0], split[1]);
        }
        if (!TextUtils.isEmpty(str6)) {
            try {
                i = Integer.parseInt(str6);
            } catch (NumberFormatException e) {
                C0240b.m490e("Warning: Could not parse flags from open GMSG: " + str6);
                i = 0;
            }
            intent.addFlags(i);
        }
        if (!TextUtils.isEmpty(str7)) {
            try {
                JSONObject jSONObject = new JSONObject(str7);
                JSONArray names = jSONObject.names();
                for (int i2 = 0; i2 < names.length(); i2++) {
                    String string = names.getString(i2);
                    JSONObject jSONObject2 = jSONObject.getJSONObject(string);
                    int i3 = jSONObject2.getInt("t");
                    switch (i3) {
                        case 1:
                            intent.putExtra(string, jSONObject2.getBoolean("v"));
                            break;
                        case 2:
                            intent.putExtra(string, jSONObject2.getDouble("v"));
                            break;
                        case 3:
                            intent.putExtra(string, jSONObject2.getInt("v"));
                            break;
                        case 4:
                            intent.putExtra(string, jSONObject2.getLong("v"));
                            break;
                        case 5:
                            intent.putExtra(string, jSONObject2.getString("v"));
                            break;
                        default:
                            C0240b.m490e("Warning: Unknown type in extras from open GMSG: " + string + " (type: " + i3 + ")");
                            break;
                    }
                }
            } catch (JSONException e2) {
                C0240b.m490e("Warning: Could not parse extras from open GMSG: " + str7);
            }
        }
        if (intent.filterEquals(new Intent())) {
            m4a("Tried to launch empty intent.");
            return;
        }
        try {
            C0240b.m480a("Launching an intent from AdActivity: " + intent);
            startActivity(intent);
            mo2915a(dVar);
        } catch (ActivityNotFoundException e3) {
            m5a(e3.getMessage(), (Throwable) e3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2915a(C0203d dVar) {
        this.f10h = null;
        this.f15m = SystemClock.elapsedRealtime();
        this.f18p = true;
        synchronized (f4b) {
            if (f5c == null) {
                f5c = this;
                dVar.mo3233w();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public AdVideoView mo2913a(Activity activity) {
        return new AdVideoView(activity, this.f10h);
    }

    public void moveAdVideoView(int x, int y, int width, int height) {
        if (this.f22t != null) {
            this.f22t.setLayoutParams(m2a(x, y, width, height));
            this.f22t.requestLayout();
        }
    }

    public void newAdVideoView(int x, int y, int width, int height) {
        if (this.f22t == null) {
            this.f22t = mo2913a((Activity) this);
            this.f16n.addView(this.f22t, 0, m2a(x, y, width, height));
            synchronized (f4b) {
                if (f6d == null) {
                    C0240b.m490e("currentAdManager was null while trying to get the opening AdWebView.");
                } else {
                    f6d.mo3223m().mo3284b(false);
                }
            }
        }
    }

    /* renamed from: a */
    private RelativeLayout.LayoutParams m2a(int i, int i2, int i3, int i4) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public void onClick(View v) {
        finish();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0088, code lost:
        r11.f16n = null;
        r11.f18p = false;
        r11.f19q = true;
        r11.f22t = null;
        r0 = getIntent().getBundleExtra("com.google.ads.AdOpener");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        if (r0 != null) goto L_0x00b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009c, code lost:
        m4a("Could not get the Bundle used to create AdActivity.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00b0, code lost:
        r1 = new com.google.ads.internal.C0204e(r0);
        r0 = r1.mo3238b();
        r10 = r1.mo3239c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c3, code lost:
        if (r0.equals("intent") == false) goto L_0x00c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c5, code lost:
        mo2916a(r10, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c9, code lost:
        r11.f16n = new android.widget.RelativeLayout(getApplicationContext());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00da, code lost:
        if (r0.equals("webapp") == false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00dc, code lost:
        r11.f10h = new com.google.ads.internal.AdWebView(r8.mo3219i(), (com.google.ads.AdSize) null);
        r1 = com.google.ads.internal.C0188a.f405d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e9, code lost:
        if (r9 != false) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00eb, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ec, code lost:
        r0 = com.google.ads.internal.C0210i.m399a(r8, r1, true, r0);
        r0.mo3286d(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f3, code lost:
        if (r9 == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f5, code lost:
        r0.mo3282a(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00f8, code lost:
        r11.f10h.setWebViewClient(r0);
        r0 = r10.get(URL_PARAM);
        r1 = r10.get(BASE_URL_PARAM);
        r2 = r10.get(HTML_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0115, code lost:
        if (r0 == null) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0117, code lost:
        r11.f10h.loadUrl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x011c, code lost:
        r0 = r10.get(ORIENTATION_PARAM);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x012a, code lost:
        if (PACKAGE_NAME_PARAM.equals(r0) == false) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x012c, code lost:
        r3 = com.google.ads.util.AdUtil.m454b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0130, code lost:
        r1 = r11.f10h;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0132, code lost:
        if (r10 == null) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0140, code lost:
        if ("1".equals(r10.get(CUSTOM_CLOSE_PARAM)) == false) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
        r5 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0143, code lost:
        mo2914a(r1, false, r3, r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x014b, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014d, code lost:
        if (r2 == null) goto L_0x0159;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x014f, code lost:
        r11.f10h.loadDataWithBaseURL(r1, r2, "text/html", "utf-8", (java.lang.String) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        m4a("Could not get the URL or HTML parameter to show a web app.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0166, code lost:
        if ("l".equals(r0) == false) goto L_0x016d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0168, code lost:
        r3 = com.google.ads.util.AdUtil.m436a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x016f, code lost:
        if (r11 != f7e) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0171, code lost:
        r3 = r8.mo3225o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0176, code lost:
        r3 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0178, code lost:
        r5 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0180, code lost:
        if (r0.equals("interstitial") != false) goto L_0x018a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0188, code lost:
        if (r0.equals("expand") == false) goto L_0x01d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x018a, code lost:
        r11.f10h = r8.mo3222l();
        r3 = r8.mo3225o();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x019a, code lost:
        if (r0.equals("expand") == false) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x019c, code lost:
        r11.f10h.setIsExpandedMraid(true);
        r11.f19q = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01a3, code lost:
        if (r10 == null) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01b1, code lost:
        if ("1".equals(r10.get(CUSTOM_CLOSE_PARAM)) == false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01b3, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01b6, code lost:
        if (r11.f20r == false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01ba, code lost:
        if (r11.f21s != false) goto L_0x01f7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01bc, code lost:
        com.google.ads.util.C0240b.m480a("Re-enabling hardware acceleration on expanding MRAID WebView.");
        r11.f10h.mo3127h();
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01c7, code lost:
        mo2914a(r11.f10h, true, r3, r9, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01d1, code lost:
        r5 = r11.f10h.mo3129j();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01d9, code lost:
        m4a("Unknown AdOpener, <action: " + r0 + ">");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f7, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r12) {
        /*
            r11 = this;
            r5 = 0
            r7 = 0
            r6 = 1
            super.onCreate(r12)
            r11.f14l = r7
            java.lang.Object r2 = f4b
            monitor-enter(r2)
            com.google.ads.internal.d r0 = f6d     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x00a2
            com.google.ads.internal.d r8 = f6d     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r0 = f7e     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x001a
            f7e = r11     // Catch:{ all -> 0x00a9 }
            r8.mo3232v()     // Catch:{ all -> 0x00a9 }
        L_0x001a:
            com.google.ads.AdActivity r0 = r11.f17o     // Catch:{ all -> 0x00a9 }
            if (r0 != 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f8f     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0026
            com.google.ads.AdActivity r0 = f8f     // Catch:{ all -> 0x00a9 }
            r11.f17o = r0     // Catch:{ all -> 0x00a9 }
        L_0x0026:
            f8f = r11     // Catch:{ all -> 0x00a9 }
            com.google.ads.n r0 = r8.mo3219i()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.mo3352a()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0036
            com.google.ads.AdActivity r0 = f7e     // Catch:{ all -> 0x00a9 }
            if (r0 == r11) goto L_0x0046
        L_0x0036:
            com.google.ads.n r0 = r8.mo3219i()     // Catch:{ all -> 0x00a9 }
            boolean r0 = r0.mo3353b()     // Catch:{ all -> 0x00a9 }
            if (r0 == 0) goto L_0x0049
            com.google.ads.AdActivity r0 = r11.f17o     // Catch:{ all -> 0x00a9 }
            com.google.ads.AdActivity r1 = f7e     // Catch:{ all -> 0x00a9 }
            if (r0 != r1) goto L_0x0049
        L_0x0046:
            r8.mo3234x()     // Catch:{ all -> 0x00a9 }
        L_0x0049:
            boolean r9 = r8.mo3228r()     // Catch:{ all -> 0x00a9 }
            com.google.ads.n r0 = r8.mo3219i()     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.m> r0 = r0.f585d     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.m r0 = (com.google.ads.C0221m) r0     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$b<com.google.ads.m$a> r0 = r0.f544b     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo3394a()     // Catch:{ all -> 0x00a9 }
            com.google.ads.m$a r0 = (com.google.ads.C0221m.C0222a) r0     // Catch:{ all -> 0x00a9 }
            int r3 = com.google.ads.util.AdUtil.f618a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r1 = r0.f547b     // Catch:{ all -> 0x00a9 }
            java.lang.Object r1 = r1.mo3395a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x00a9 }
            int r1 = r1.intValue()     // Catch:{ all -> 0x00a9 }
            if (r3 < r1) goto L_0x00ac
            r1 = r6
        L_0x0072:
            r11.f21s = r1     // Catch:{ all -> 0x00a9 }
            int r1 = com.google.ads.util.AdUtil.f618a     // Catch:{ all -> 0x00a9 }
            com.google.ads.util.i$c<java.lang.Integer> r0 = r0.f549d     // Catch:{ all -> 0x00a9 }
            java.lang.Object r0 = r0.mo3395a()     // Catch:{ all -> 0x00a9 }
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch:{ all -> 0x00a9 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x00a9 }
            if (r1 < r0) goto L_0x00ae
            r0 = r6
        L_0x0085:
            r11.f20r = r0     // Catch:{ all -> 0x00a9 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            r11.f16n = r5
            r11.f18p = r7
            r11.f19q = r6
            r11.f22t = r5
            android.content.Intent r0 = r11.getIntent()
            java.lang.String r1 = "com.google.ads.AdOpener"
            android.os.Bundle r0 = r0.getBundleExtra(r1)
            if (r0 != 0) goto L_0x00b0
            java.lang.String r0 = "Could not get the Bundle used to create AdActivity."
            r11.m4a((java.lang.String) r0)
        L_0x00a1:
            return
        L_0x00a2:
            java.lang.String r0 = "Could not get currentAdManager."
            r11.m4a((java.lang.String) r0)     // Catch:{ all -> 0x00a9 }
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            goto L_0x00a1
        L_0x00a9:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00a9 }
            throw r0
        L_0x00ac:
            r1 = r7
            goto L_0x0072
        L_0x00ae:
            r0 = r7
            goto L_0x0085
        L_0x00b0:
            com.google.ads.internal.e r1 = new com.google.ads.internal.e
            r1.<init>((android.os.Bundle) r0)
            java.lang.String r0 = r1.mo3238b()
            java.util.HashMap r10 = r1.mo3239c()
            java.lang.String r1 = "intent"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x00c9
            r11.mo2916a((java.util.HashMap<java.lang.String, java.lang.String>) r10, (com.google.ads.internal.C0203d) r8)
            goto L_0x00a1
        L_0x00c9:
            android.widget.RelativeLayout r1 = new android.widget.RelativeLayout
            android.content.Context r2 = r11.getApplicationContext()
            r1.<init>(r2)
            r11.f16n = r1
            java.lang.String r1 = "webapp"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x017a
            com.google.ads.internal.AdWebView r0 = new com.google.ads.internal.AdWebView
            com.google.ads.n r1 = r8.mo3219i()
            r0.<init>(r1, r5)
            r11.f10h = r0
            java.util.Map<java.lang.String, com.google.ads.o> r1 = com.google.ads.internal.C0188a.f405d
            if (r9 != 0) goto L_0x014b
            r0 = r6
        L_0x00ec:
            com.google.ads.internal.i r0 = com.google.ads.internal.C0210i.m399a(r8, r1, r6, r0)
            r0.mo3286d(r6)
            if (r9 == 0) goto L_0x00f8
            r0.mo3282a(r6)
        L_0x00f8:
            com.google.ads.internal.AdWebView r1 = r11.f10h
            r1.setWebViewClient(r0)
            java.lang.String r0 = "u"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "baseurl"
            java.lang.Object r1 = r10.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "html"
            java.lang.Object r2 = r10.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            if (r0 == 0) goto L_0x014d
            com.google.ads.internal.AdWebView r1 = r11.f10h
            r1.loadUrl(r0)
        L_0x011c:
            java.lang.String r0 = "o"
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "p"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L_0x0160
            int r3 = com.google.ads.util.AdUtil.m454b()
        L_0x0130:
            com.google.ads.internal.AdWebView r1 = r11.f10h
            if (r10 == 0) goto L_0x0178
            java.lang.String r0 = "1"
            java.lang.String r2 = "custom_close"
            java.lang.Object r2 = r10.get(r2)
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0178
            r5 = r6
        L_0x0143:
            r0 = r11
            r2 = r7
            r4 = r9
            r0.mo2914a(r1, r2, r3, r4, r5)
            goto L_0x00a1
        L_0x014b:
            r0 = r7
            goto L_0x00ec
        L_0x014d:
            if (r2 == 0) goto L_0x0159
            com.google.ads.internal.AdWebView r0 = r11.f10h
            java.lang.String r3 = "text/html"
            java.lang.String r4 = "utf-8"
            r0.loadDataWithBaseURL(r1, r2, r3, r4, r5)
            goto L_0x011c
        L_0x0159:
            java.lang.String r0 = "Could not get the URL or HTML parameter to show a web app."
            r11.m4a((java.lang.String) r0)
            goto L_0x00a1
        L_0x0160:
            java.lang.String r1 = "l"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L_0x016d
            int r3 = com.google.ads.util.AdUtil.m436a()
            goto L_0x0130
        L_0x016d:
            com.google.ads.AdActivity r0 = f7e
            if (r11 != r0) goto L_0x0176
            int r3 = r8.mo3225o()
            goto L_0x0130
        L_0x0176:
            r3 = -1
            goto L_0x0130
        L_0x0178:
            r5 = r7
            goto L_0x0143
        L_0x017a:
            java.lang.String r1 = "interstitial"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x018a
            java.lang.String r1 = "expand"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x01d9
        L_0x018a:
            com.google.ads.internal.AdWebView r1 = r8.mo3222l()
            r11.f10h = r1
            int r3 = r8.mo3225o()
            java.lang.String r1 = "expand"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01d1
            com.google.ads.internal.AdWebView r0 = r11.f10h
            r0.setIsExpandedMraid(r6)
            r11.f19q = r7
            if (r10 == 0) goto L_0x01b4
            java.lang.String r0 = "1"
            java.lang.String r1 = "custom_close"
            java.lang.Object r1 = r10.get(r1)
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x01b4
            r7 = r6
        L_0x01b4:
            boolean r0 = r11.f20r
            if (r0 == 0) goto L_0x01f7
            boolean r0 = r11.f21s
            if (r0 != 0) goto L_0x01f7
            java.lang.String r0 = "Re-enabling hardware acceleration on expanding MRAID WebView."
            com.google.ads.util.C0240b.m480a((java.lang.String) r0)
            com.google.ads.internal.AdWebView r0 = r11.f10h
            r0.mo3127h()
            r5 = r7
        L_0x01c7:
            com.google.ads.internal.AdWebView r1 = r11.f10h
            r0 = r11
            r2 = r6
            r4 = r9
            r0.mo2914a(r1, r2, r3, r4, r5)
            goto L_0x00a1
        L_0x01d1:
            com.google.ads.internal.AdWebView r0 = r11.f10h
            boolean r7 = r0.mo3129j()
            r5 = r7
            goto L_0x01c7
        L_0x01d9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown AdOpener, <action: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r1 = ">"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r11.m4a((java.lang.String) r0)
            goto L_0x00a1
        L_0x01f7:
            r5 = r7
            goto L_0x01c7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.AdActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo2914a(AdWebView adWebView, boolean z, int i, boolean z2, boolean z3) {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(1024, 1024);
        if (AdUtil.f618a >= 11) {
            if (this.f20r) {
                C0240b.m480a("Enabling hardware acceleration on the AdActivity window.");
                C0249g.m503a(window);
            } else {
                C0240b.m480a("Disabling hardware acceleration on the AdActivity WebView.");
                adWebView.mo3126g();
            }
        }
        ViewParent parent = adWebView.getParent();
        if (parent != null) {
            if (!z2) {
                m4a("Interstitial created with an AdWebView that has a parent.");
                return;
            } else if (parent instanceof ViewGroup) {
                this.f13k = (ViewGroup) parent;
                this.f13k.removeView(adWebView);
            } else {
                m4a("MRAID banner was not a child of a ViewGroup.");
                return;
            }
        }
        if (adWebView.mo3128i() != null) {
            m4a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
            return;
        }
        setRequestedOrientation(i);
        adWebView.setAdActivity(this);
        View a = mo2912a(z2 ? 50 : 32, z3);
        this.f16n.addView(adWebView, -1, -1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (z2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        this.f16n.addView(a, layoutParams);
        this.f16n.setKeepScreenOn(true);
        setContentView(this.f16n);
        this.f16n.getRootView().setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        if (z) {
            f3a.mo3143a((WebView) adWebView);
        }
    }

    public void onDestroy() {
        if (this.f16n != null) {
            this.f16n.removeAllViews();
        }
        if (isFinishing()) {
            m10e();
            if (this.f19q && this.f10h != null) {
                this.f10h.stopLoading();
                this.f10h.destroy();
                this.f10h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        if (isFinishing()) {
            m10e();
        }
        super.onPause();
    }

    /* renamed from: e */
    private void m10e() {
        if (!this.f14l) {
            if (this.f10h != null) {
                f3a.mo3149b((WebView) this.f10h);
                this.f10h.setAdActivity((AdActivity) null);
                this.f10h.setIsExpandedMraid(false);
                if (!(this.f19q || this.f16n == null || this.f13k == null)) {
                    if (this.f20r && !this.f21s) {
                        C0240b.m480a("Disabling hardware acceleration on collapsing MRAID WebView.");
                        this.f10h.mo3126g();
                    } else if (!this.f20r && this.f21s) {
                        C0240b.m480a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
                        this.f10h.mo3127h();
                    }
                    this.f16n.removeView(this.f10h);
                    this.f13k.addView(this.f10h);
                }
            }
            if (this.f22t != null) {
                this.f22t.mo3114e();
                this.f22t = null;
            }
            if (this == f5c) {
                f5c = null;
            }
            f8f = this.f17o;
            synchronized (f4b) {
                if (!(f6d == null || !this.f19q || this.f10h == null)) {
                    if (this.f10h == f6d.mo3222l()) {
                        f6d.mo3191a();
                    }
                    this.f10h.stopLoading();
                }
                if (this == f7e) {
                    f7e = null;
                    if (f6d != null) {
                        f6d.mo3231u();
                        f6d = null;
                    } else {
                        C0240b.m490e("currentAdManager is null while trying to destroy AdActivity.");
                    }
                }
            }
            this.f14l = true;
            C0240b.m480a("AdActivity is closing.");
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (this.f18p && hasFocus && SystemClock.elapsedRealtime() - this.f15m > 250) {
            C0240b.m488d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    public void setCustomClose(boolean useCustomClose) {
        if (this.f11i != null) {
            this.f11i.removeAllViews();
            if (!useCustomClose) {
                ImageButton imageButton = new ImageButton(this);
                imageButton.setImageResource(17301527);
                imageButton.setBackgroundColor(0);
                imageButton.setOnClickListener(this);
                imageButton.setPadding(0, 0, 0, 0);
                this.f11i.addView(imageButton, new FrameLayout.LayoutParams(this.f12j, this.f12j, 17));
            }
        }
    }
}
