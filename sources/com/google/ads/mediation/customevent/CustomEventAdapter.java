package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0177g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0238a;
import com.google.ads.util.C0240b;

public class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f572a;

    /* renamed from: b */
    private CustomEventBanner f573b = null;

    /* renamed from: c */
    private C0226a f574c = null;

    /* renamed from: d */
    private CustomEventInterstitial f575d = null;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$a */
    private class C0226a implements CustomEventBannerListener {

        /* renamed from: b */
        private View f577b;

        /* renamed from: c */
        private final MediationBannerListener f578c;

        public C0226a(MediationBannerListener mediationBannerListener) {
            this.f578c = mediationBannerListener;
        }

        public synchronized void onReceivedAd(View view) {
            C0240b.m480a(m423b() + " called onReceivedAd.");
            this.f577b = view;
            this.f578c.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0240b.m480a(m423b() + " called onFailedToReceiveAd().");
            this.f578c.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onClick() {
            C0240b.m480a(m423b() + " called onClick().");
            this.f578c.onClick(CustomEventAdapter.this);
        }

        public void onPresentScreen() {
            C0240b.m480a(m423b() + " called onPresentScreen().");
            this.f578c.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0240b.m480a(m423b() + " called onDismissScreen().");
            this.f578c.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0240b.m480a(m423b() + " called onLeaveApplication().");
            this.f578c.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        public synchronized View mo3337a() {
            return this.f577b;
        }

        /* renamed from: b */
        private String m423b() {
            return "Banner custom event labeled '" + CustomEventAdapter.this.f572a + "'";
        }
    }

    public void requestBannerAd(MediationBannerListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0238a.m469a((Object) this.f572a);
        this.f572a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f573b = (CustomEventBanner) m420a(str, CustomEventBanner.class, this.f572a);
        if (this.f573b == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        C0238a.m469a((Object) this.f574c);
        this.f574c = new C0226a(mediationListener);
        try {
            this.f573b.requestBannerAd(this.f574c, activity, this.f572a, str2, adSize, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f572a));
        } catch (Throwable th) {
            m422a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public View getBannerView() {
        C0238a.m474b((Object) this.f574c);
        return this.f574c.mo3337a();
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter$b */
    private class C0227b implements CustomEventInterstitialListener {

        /* renamed from: b */
        private final MediationInterstitialListener f580b;

        public C0227b(MediationInterstitialListener mediationInterstitialListener) {
            this.f580b = mediationInterstitialListener;
        }

        public void onReceivedAd() {
            C0240b.m480a(m425a() + " called onReceivedAd.");
            this.f580b.onReceivedAd(CustomEventAdapter.this);
        }

        public void onFailedToReceiveAd() {
            C0240b.m480a(m425a() + " called onFailedToReceiveAd().");
            this.f580b.onFailedToReceiveAd(CustomEventAdapter.this, AdRequest.ErrorCode.NO_FILL);
        }

        public void onPresentScreen() {
            C0240b.m480a(m425a() + " called onPresentScreen().");
            this.f580b.onPresentScreen(CustomEventAdapter.this);
        }

        public void onDismissScreen() {
            C0240b.m480a(m425a() + " called onDismissScreen().");
            this.f580b.onDismissScreen(CustomEventAdapter.this);
        }

        public synchronized void onLeaveApplication() {
            C0240b.m480a(m425a() + " called onLeaveApplication().");
            this.f580b.onLeaveApplication(CustomEventAdapter.this);
        }

        /* renamed from: a */
        private String m425a() {
            return "Interstitial custom event labeled '" + CustomEventAdapter.this.f572a + "'";
        }
    }

    public void showInterstitial() {
        C0238a.m474b((Object) this.f575d);
        try {
            this.f575d.showInterstitial();
        } catch (Throwable th) {
            C0240b.m485b("Exception when showing custom event labeled '" + this.f572a + "'.", th);
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0238a.m469a((Object) this.f572a);
        this.f572a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f575d = (CustomEventInterstitial) m420a(str, CustomEventInterstitial.class, this.f572a);
        if (this.f575d == null) {
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
            return;
        }
        try {
            this.f575d.requestInterstitialAd(new C0227b(mediationListener), activity, this.f572a, str2, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f572a));
        } catch (Throwable th) {
            m422a("", th);
            mediationListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void destroy() {
        if (this.f573b != null) {
            this.f573b.destroy();
        }
        if (this.f575d != null) {
            this.f575d.destroy();
        }
    }

    /* renamed from: a */
    private void m422a(String str, Throwable th) {
        C0240b.m485b("Error during processing of custom event with label: '" + this.f572a + "'. Skipping custom event. " + str, th);
    }

    /* renamed from: a */
    private <T> T m420a(String str, Class<T> cls, String str2) {
        try {
            return C0177g.m181a(str, cls);
        } catch (ClassNotFoundException e) {
            m422a("Make sure you created a visible class named: " + str + ". ", e);
        } catch (ClassCastException e2) {
            m422a("Make sure your custom event implements the " + cls.getName() + " interface.", e2);
        } catch (IllegalAccessException e3) {
            m422a("Make sure the default constructor for class " + str + " is visible. ", e3);
        } catch (InstantiationException e4) {
            m422a("Make sure the name " + str + " does not denote an abstract class or an interface.", e4);
        } catch (Throwable th) {
            m422a("", th);
        }
        return null;
    }
}
