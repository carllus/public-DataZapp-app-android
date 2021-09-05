package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.C0121Ad;
import com.google.ads.C0126ae;
import com.google.ads.C0127af;
import com.google.ads.C0157at;
import com.google.ads.C0163b;
import com.google.ads.C0164c;
import com.google.ads.C0166d;
import com.google.ads.C0167e;
import com.google.ads.C0176f;
import com.google.ads.C0177g;
import com.google.ads.C0179h;
import com.google.ads.C0220l;
import com.google.ads.C0221m;
import com.google.ads.C0228n;
import com.google.ads.InterstitialAd;
import com.google.ads.doubleclick.SwipeableDfpAdView;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;
import com.google.ads.util.IcsUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/* renamed from: com.google.ads.internal.d */
public class C0203d {

    /* renamed from: a */
    private static final Object f460a = new Object();

    /* renamed from: A */
    private String f461A = null;

    /* renamed from: B */
    private String f462B = null;

    /* renamed from: b */
    private final C0228n f463b;

    /* renamed from: c */
    private C0194c f464c;

    /* renamed from: d */
    private AdRequest f465d;

    /* renamed from: e */
    private C0208g f466e;

    /* renamed from: f */
    private AdWebView f467f;

    /* renamed from: g */
    private C0210i f468g;

    /* renamed from: h */
    private boolean f469h = false;

    /* renamed from: i */
    private long f470i;

    /* renamed from: j */
    private boolean f471j;

    /* renamed from: k */
    private boolean f472k;

    /* renamed from: l */
    private boolean f473l;

    /* renamed from: m */
    private boolean f474m;

    /* renamed from: n */
    private boolean f475n;

    /* renamed from: o */
    private SharedPreferences f476o;

    /* renamed from: p */
    private long f477p;

    /* renamed from: q */
    private C0127af f478q;

    /* renamed from: r */
    private boolean f479r;

    /* renamed from: s */
    private LinkedList<String> f480s;

    /* renamed from: t */
    private LinkedList<String> f481t;

    /* renamed from: u */
    private LinkedList<String> f482u;

    /* renamed from: v */
    private int f483v = -1;

    /* renamed from: w */
    private Boolean f484w;

    /* renamed from: x */
    private C0166d f485x;

    /* renamed from: y */
    private C0167e f486y;

    /* renamed from: z */
    private C0176f f487z;

    public C0203d(C0121Ad ad, Activity activity, AdSize adSize, String str, ViewGroup viewGroup, boolean z) {
        AdView adView;
        InterstitialAd interstitialAd;
        AdView adView2;
        InterstitialAd interstitialAd2;
        this.f479r = z;
        this.f466e = new C0208g();
        this.f464c = null;
        this.f465d = null;
        this.f472k = false;
        this.f477p = 60000;
        this.f473l = false;
        this.f475n = false;
        this.f474m = true;
        C0209h a = adSize == null ? C0209h.f512a : C0209h.m393a(adSize, activity.getApplicationContext());
        if (ad instanceof SwipeableDfpAdView) {
            a.mo3277a(true);
        }
        if (activity == null) {
            C0221m a2 = C0221m.m411a();
            if (ad instanceof AdView) {
                adView2 = (AdView) ad;
            } else {
                adView2 = null;
            }
            if (ad instanceof InterstitialAd) {
                interstitialAd2 = (InterstitialAd) ad;
            } else {
                interstitialAd2 = null;
            }
            this.f463b = new C0228n(a2, ad, adView2, interstitialAd2, str, (Activity) null, (Context) null, viewGroup, a, this);
            return;
        }
        synchronized (f460a) {
            this.f476o = activity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
            if (z) {
                long j = this.f476o.getLong("Timeout" + str, -1);
                if (j < 0) {
                    this.f470i = 5000;
                } else {
                    this.f470i = j;
                }
            } else {
                this.f470i = 60000;
            }
        }
        C0221m a3 = C0221m.m411a();
        if (ad instanceof AdView) {
            adView = (AdView) ad;
        } else {
            adView = null;
        }
        if (ad instanceof InterstitialAd) {
            interstitialAd = (InterstitialAd) ad;
        } else {
            interstitialAd = null;
        }
        this.f463b = new C0228n(a3, ad, adView, interstitialAd, str, activity, activity.getApplicationContext(), viewGroup, a, this);
        this.f478q = new C0127af(this);
        this.f480s = new LinkedList<>();
        this.f481t = new LinkedList<>();
        this.f482u = new LinkedList<>();
        mo3191a();
        AdUtil.m467h(this.f463b.f587f.mo3394a());
        this.f485x = new C0166d();
        this.f486y = new C0167e(this);
        this.f484w = null;
        this.f487z = null;
    }

    /* renamed from: a */
    public synchronized void mo3191a() {
        AdSize c = this.f463b.f588g.mo3394a().mo3281c();
        this.f467f = AdUtil.f618a >= 14 ? new IcsUtil.IcsAdWebView(this.f463b, c) : new AdWebView(this.f463b, c);
        this.f467f.setVisibility(8);
        this.f468g = C0210i.m399a(this, C0188a.f405d, true, this.f463b.mo3353b());
        this.f467f.setWebViewClient(this.f468g);
        if (AdUtil.f618a < this.f463b.f585d.mo3394a().f544b.mo3394a().f547b.mo3395a().intValue() && !this.f463b.f588g.mo3394a().mo3278a()) {
            C0240b.m480a("Disabling hardware acceleration for a banner.");
            this.f467f.mo3126g();
        }
    }

    /* renamed from: b */
    public synchronized void mo3207b() {
        if (this.f486y != null) {
            this.f486y.mo3059b();
        }
        this.f463b.f596o.mo3396a(null);
        this.f463b.f597p.mo3396a(null);
        mo3187C();
        mo3216f();
        if (this.f467f != null) {
            this.f467f.destroy();
        }
        this.f469h = true;
    }

    /* renamed from: a */
    public void mo3203a(String str) {
        this.f462B = str;
        Uri build = new Uri.Builder().encodedQuery(str).build();
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> b = AdUtil.m457b(build);
        for (String next : b.keySet()) {
            sb.append(next).append(" = ").append(b.get(next)).append("\n");
        }
        this.f461A = sb.toString().trim();
        if (TextUtils.isEmpty(this.f461A)) {
            this.f461A = null;
        }
    }

    /* renamed from: c */
    public String mo3212c() {
        return this.f461A;
    }

    /* renamed from: d */
    public String mo3214d() {
        return this.f462B;
    }

    /* renamed from: e */
    public synchronized void mo3215e() {
        this.f474m = false;
        C0240b.m480a("Refreshing is no longer allowed on this AdView.");
    }

    /* renamed from: f */
    public synchronized void mo3216f() {
        if (this.f473l) {
            C0240b.m480a("Disabling refreshing.");
            C0221m.m411a().f545c.mo3394a().removeCallbacks(this.f478q);
            this.f473l = false;
        } else {
            C0240b.m480a("Refreshing is already disabled.");
        }
    }

    /* renamed from: g */
    public synchronized void mo3217g() {
        this.f475n = false;
        if (!this.f463b.mo3352a()) {
            C0240b.m480a("Tried to enable refreshing on something other than an AdView.");
        } else if (!this.f474m) {
            C0240b.m480a("Refreshing disabled on this AdView");
        } else if (!this.f473l) {
            C0240b.m480a("Enabling refreshing every " + this.f477p + " milliseconds.");
            C0221m.m411a().f545c.mo3394a().postDelayed(this.f478q, this.f477p);
            this.f473l = true;
        } else {
            C0240b.m480a("Refreshing is already enabled.");
        }
    }

    /* renamed from: h */
    public void mo3218h() {
        mo3217g();
        this.f475n = true;
    }

    /* renamed from: i */
    public C0228n mo3219i() {
        return this.f463b;
    }

    /* renamed from: j */
    public synchronized C0166d mo3220j() {
        return this.f485x;
    }

    /* renamed from: k */
    public synchronized C0194c mo3221k() {
        return this.f464c;
    }

    /* renamed from: l */
    public synchronized AdWebView mo3222l() {
        return this.f467f;
    }

    /* renamed from: m */
    public synchronized C0210i mo3223m() {
        return this.f468g;
    }

    /* renamed from: n */
    public C0208g mo3224n() {
        return this.f466e;
    }

    /* renamed from: a */
    public synchronized void mo3193a(int i) {
        this.f483v = i;
    }

    /* renamed from: o */
    public synchronized int mo3225o() {
        return this.f483v;
    }

    /* renamed from: p */
    public long mo3226p() {
        return this.f470i;
    }

    /* renamed from: q */
    public synchronized boolean mo3227q() {
        return this.f464c != null;
    }

    /* renamed from: r */
    public synchronized boolean mo3228r() {
        return this.f471j;
    }

    /* renamed from: s */
    public synchronized boolean mo3229s() {
        return this.f472k;
    }

    /* renamed from: t */
    public synchronized boolean mo3230t() {
        return this.f473l;
    }

    /* renamed from: a */
    public synchronized void mo3199a(AdRequest adRequest) {
        C0240b.m488d("v6.4.1 RC00");
        if (this.f469h) {
            C0240b.m490e("loadAd called after ad was destroyed.");
        } else if (mo3227q()) {
            C0240b.m490e("loadAd called while the ad is already loading, so aborting.");
        } else if (AdActivity.isShowing()) {
            C0240b.m490e("loadAd called while an interstitial or landing page is displayed, so aborting");
        } else if (AdUtil.m461c(this.f463b.f587f.mo3394a()) && AdUtil.m459b(this.f463b.f587f.mo3394a())) {
            if (C0157at.m113a(this.f463b.f587f.mo3394a(), this.f476o.getLong("GoogleAdMobDoritosLife", 60000))) {
                C0157at.m112a(this.f463b.f584c.mo3397a());
            }
            this.f472k = false;
            this.f480s.clear();
            this.f481t.clear();
            this.f465d = adRequest;
            if (this.f485x.mo3042a()) {
                this.f486y.mo3054a(this.f485x.mo3043b(), adRequest);
            } else {
                C0220l lVar = new C0220l(this.f463b);
                this.f463b.f594m.mo3396a(lVar);
                this.f464c = lVar.f540b.mo3395a();
                this.f464c.mo3162a(adRequest);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3198a(AdRequest.ErrorCode errorCode) {
        this.f464c = null;
        if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
            mo3192a(60.0f);
            if (!mo3230t()) {
                mo3218h();
            }
        }
        if (this.f463b.mo3353b()) {
            if (errorCode == AdRequest.ErrorCode.NO_FILL) {
                this.f466e.mo3246B();
            } else if (errorCode == AdRequest.ErrorCode.NETWORK_ERROR) {
                this.f466e.mo3276z();
            }
        }
        C0240b.m486c("onFailedToReceiveAd(" + errorCode + ")");
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onFailedToReceiveAd(this.f463b.f582a.mo3394a(), errorCode);
        }
    }

    /* renamed from: a */
    public synchronized void mo3200a(C0164c cVar) {
        this.f464c = null;
        this.f486y.mo3054a(cVar, this.f465d);
    }

    /* renamed from: a */
    public synchronized void mo3197a(View view, C0179h hVar, C0176f fVar, boolean z) {
        C0240b.m480a("AdManager.onReceiveGWhirlAd() called.");
        this.f472k = true;
        this.f487z = fVar;
        if (this.f463b.mo3352a()) {
            mo3196a(view);
            m277a(fVar, Boolean.valueOf(z));
        }
        this.f486y.mo3063d(hVar);
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onReceiveAd(this.f463b.f582a.mo3394a());
        }
    }

    /* renamed from: a */
    public synchronized void mo3201a(C0176f fVar, boolean z) {
        C0240b.m480a(String.format(Locale.US, "AdManager.onGWhirlAdClicked(%b) called.", new Object[]{Boolean.valueOf(z)}));
        m280b(fVar, Boolean.valueOf(z));
    }

    /* renamed from: b */
    public synchronized void mo3209b(C0164c cVar) {
        C0240b.m480a("AdManager.onGWhirlNoFill() called.");
        m278a(cVar.mo3039i(), cVar.mo3033c());
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onFailedToReceiveAd(this.f463b.f582a.mo3394a(), AdRequest.ErrorCode.NO_FILL);
        }
    }

    /* renamed from: u */
    public synchronized void mo3231u() {
        this.f466e.mo3247C();
        C0240b.m486c("onDismissScreen()");
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onDismissScreen(this.f463b.f582a.mo3394a());
        }
    }

    /* renamed from: v */
    public synchronized void mo3232v() {
        C0240b.m486c("onPresentScreen()");
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onPresentScreen(this.f463b.f582a.mo3394a());
        }
    }

    /* renamed from: w */
    public synchronized void mo3233w() {
        C0240b.m486c("onLeaveApplication()");
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onLeaveApplication(this.f463b.f582a.mo3394a());
        }
    }

    /* renamed from: a */
    public synchronized void mo3204a(String str, String str2) {
        AppEventListener a = this.f463b.f597p.mo3395a();
        if (a != null) {
            a.onAppEvent(this.f463b.f582a.mo3394a(), str, str2);
        }
    }

    /* renamed from: x */
    public void mo3234x() {
        this.f466e.mo3256f();
        mo3188D();
    }

    /* renamed from: a */
    private void m277a(C0176f fVar, Boolean bool) {
        List d = fVar.mo3075d();
        if (d == null) {
            d = new ArrayList();
            d.add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
        }
        String b = fVar.mo3073b();
        m279a(d, fVar.mo3072a(), b, fVar.mo3074c(), bool, this.f466e.mo3254d(), this.f466e.mo3255e());
    }

    /* renamed from: b */
    private void m280b(C0176f fVar, Boolean bool) {
        List e = fVar.mo3076e();
        if (e == null) {
            e = new ArrayList();
            e.add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
        }
        m279a(e, fVar.mo3072a(), fVar.mo3073b(), fVar.mo3074c(), bool, (String) null, (String) null);
    }

    /* renamed from: a */
    private void m278a(List<String> list, String str) {
        List<String> list2;
        if (list == null) {
            list2 = new ArrayList<>();
            list2.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        } else {
            list2 = list;
        }
        m279a(list2, (String) null, (String) null, str, (Boolean) null, this.f466e.mo3254d(), this.f466e.mo3255e());
    }

    /* renamed from: a */
    private void m279a(List<String> list, String str, String str2, String str3, Boolean bool, String str4, String str5) {
        String a = AdUtil.m441a(this.f463b.f587f.mo3394a());
        C0163b a2 = C0163b.m132a();
        String bigInteger = a2.mo3029b().toString();
        String bigInteger2 = a2.mo3030c().toString();
        for (String a3 : list) {
            new Thread(new C0126ae(C0177g.m182a(a3, this.f463b.f589h.mo3394a(), bool, a, str, str2, str3, bigInteger, bigInteger2, str4, str5), this.f463b.f587f.mo3394a())).start();
        }
        this.f466e.mo3252b();
    }

    /* renamed from: y */
    public synchronized void mo3235y() {
        Activity a = this.f463b.f584c.mo3397a();
        if (a == null) {
            C0240b.m490e("activity was null while trying to ping tracking URLs.");
        } else {
            Iterator it = this.f480s.iterator();
            while (it.hasNext()) {
                new Thread(new C0126ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* renamed from: z */
    public synchronized void mo3236z() {
        Activity a = this.f463b.f584c.mo3397a();
        if (a == null) {
            C0240b.m490e("activity was null while trying to ping manual tracking URLs.");
        } else {
            Iterator it = this.f481t.iterator();
            while (it.hasNext()) {
                new Thread(new C0126ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* renamed from: A */
    public synchronized void mo3185A() {
        if (!this.f469h) {
            if (this.f465d == null) {
                C0240b.m480a("Tried to refresh before calling loadAd().");
            } else if (this.f463b.mo3352a()) {
                if (!this.f463b.f591j.mo3394a().isShown() || !AdUtil.m463d()) {
                    C0240b.m480a("Not refreshing because the ad is not visible.");
                } else {
                    C0240b.m486c("Refreshing ad.");
                    mo3199a(this.f465d);
                }
                if (this.f475n) {
                    mo3216f();
                } else {
                    C0221m.m411a().f545c.mo3394a().postDelayed(this.f478q, this.f477p);
                }
            } else {
                C0240b.m480a("Tried to refresh an ad that wasn't an AdView.");
            }
        }
    }

    /* renamed from: a */
    public void mo3195a(long j) {
        synchronized (f460a) {
            SharedPreferences.Editor edit = this.f476o.edit();
            edit.putLong("Timeout" + this.f463b.f589h, j);
            edit.commit();
            if (this.f479r) {
                this.f470i = j;
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3206a(boolean z) {
        this.f471j = z;
    }

    /* renamed from: a */
    public void mo3196a(View view) {
        this.f463b.f590i.mo3394a().setVisibility(0);
        this.f463b.f590i.mo3394a().removeAllViews();
        this.f463b.f590i.mo3394a().addView(view);
        if (this.f463b.f588g.mo3394a().mo3280b()) {
            this.f463b.f583b.mo3394a().mo3202a(this.f463b.f593l.mo3395a(), false, -1, -1, -1, -1);
            if (this.f463b.f586e.mo3394a().mo3096a()) {
                this.f463b.f590i.mo3394a().addView(this.f463b.f586e.mo3394a(), AdUtil.m437a(this.f463b.f587f.mo3394a(), this.f463b.f588g.mo3394a().mo3281c().getWidth()), AdUtil.m437a(this.f463b.f587f.mo3394a(), this.f463b.f588g.mo3394a().mo3281c().getHeight()));
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo3192a(float f) {
        long j = this.f477p;
        this.f477p = (long) (1000.0f * f);
        if (mo3230t() && this.f477p != j) {
            mo3216f();
            mo3217g();
        }
    }

    /* renamed from: b */
    public synchronized void mo3208b(long j) {
        if (j > 0) {
            this.f476o.edit().putLong("GoogleAdMobDoritosLife", j).commit();
        }
    }

    /* renamed from: B */
    public synchronized void mo3186B() {
        C0238a.m472a(this.f463b.mo3353b());
        if (this.f472k) {
            this.f472k = false;
            if (this.f484w == null) {
                C0240b.m484b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
            } else if (!this.f484w.booleanValue()) {
                AdActivity.launchAdActivity(this, new C0204e("interstitial"));
                mo3235y();
            } else if (this.f486y.mo3062c()) {
                m277a(this.f487z, (Boolean) false);
            }
        } else {
            C0240b.m486c("Cannot show interstitial because it is not loaded and ready.");
        }
    }

    /* renamed from: C */
    public synchronized void mo3187C() {
        if (this.f464c != null) {
            this.f464c.mo3158a();
            this.f464c = null;
        }
        if (this.f467f != null) {
            this.f467f.stopLoading();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public synchronized void mo3188D() {
        Activity a = this.f463b.f584c.mo3397a();
        if (a == null) {
            C0240b.m490e("activity was null while trying to ping click tracking URLs.");
        } else {
            Iterator it = this.f482u.iterator();
            while (it.hasNext()) {
                new Thread(new C0126ae((String) it.next(), a.getApplicationContext())).start();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: E */
    public synchronized void mo3189E() {
        this.f464c = null;
        this.f472k = true;
        this.f467f.setVisibility(0);
        if (this.f463b.mo3352a()) {
            mo3196a((View) this.f467f);
        }
        this.f466e.mo3257g();
        if (this.f463b.mo3352a()) {
            mo3235y();
        }
        C0240b.m486c("onReceiveAd()");
        AdListener a = this.f463b.f596o.mo3395a();
        if (a != null) {
            a.onReceiveAd(this.f463b.f582a.mo3394a());
        }
        this.f463b.f593l.mo3396a(this.f463b.f594m.mo3395a());
        this.f463b.f594m.mo3396a(null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo3210b(String str) {
        C0240b.m480a("Adding a tracking URL: " + str);
        this.f480s.add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public synchronized void mo3213c(String str) {
        C0240b.m480a("Adding a manual tracking URL: " + str);
        mo3190F().add(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3205a(LinkedList<String> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C0240b.m480a("Adding a click tracking URL: " + ((String) it.next()));
        }
        this.f482u = linkedList;
    }

    /* renamed from: b */
    public void mo3211b(boolean z) {
        this.f484w = Boolean.valueOf(z);
    }

    /* renamed from: a */
    public void mo3202a(C0220l lVar, boolean z, int i, int i2, int i3, int i4) {
        this.f463b.f586e.mo3394a().setOverlayActivated(!z);
        mo3194a(i, i2, i3, i4);
        if (this.f463b.f598q.mo3395a() == null) {
            return;
        }
        if (z) {
            this.f463b.f598q.mo3395a().onAdActivated(this.f463b.f582a.mo3394a());
        } else {
            this.f463b.f598q.mo3395a().onAdDeactivated(this.f463b.f582a.mo3394a());
        }
    }

    /* renamed from: a */
    public void mo3194a(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        ActivationOverlay a = this.f463b.f586e.mo3394a();
        int a2 = AdUtil.m437a(this.f463b.f587f.mo3394a(), i3 < 0 ? this.f463b.f588g.mo3394a().mo3281c().getWidth() : i3);
        Context a3 = this.f463b.f587f.mo3394a();
        if (i4 < 0) {
            i4 = this.f463b.f588g.mo3394a().mo3281c().getHeight();
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, AdUtil.m437a(a3, i4));
        if (i3 < 0) {
            i5 = 0;
            i6 = 0;
        } else {
            i5 = i2;
            i6 = i;
        }
        if (i6 < 0) {
            i7 = this.f463b.f586e.mo3394a().mo3101d();
        } else {
            i7 = i6;
        }
        if (i5 < 0) {
            i5 = this.f463b.f586e.mo3394a().mo3098c();
        }
        this.f463b.f586e.mo3394a().setXPosition(i7);
        this.f463b.f586e.mo3394a().setYPosition(i5);
        layoutParams.setMargins(AdUtil.m437a(this.f463b.f587f.mo3394a(), i7), AdUtil.m437a(this.f463b.f587f.mo3394a(), i5), 0, 0);
        a.setLayoutParams(layoutParams);
    }

    /* renamed from: F */
    public LinkedList<String> mo3190F() {
        return this.f481t;
    }
}
