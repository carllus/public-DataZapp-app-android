package com.google.ads;

import android.app.Activity;
import com.google.ads.C0177g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.C0240b;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.i */
class C0182i implements Runnable {

    /* renamed from: a */
    private final C0179h f373a;

    /* renamed from: b */
    private final String f374b;

    /* renamed from: c */
    private final AdRequest f375c;

    /* renamed from: d */
    private final HashMap<String, String> f376d;

    /* renamed from: e */
    private final boolean f377e = m202a((Map<String, String>) this.f376d);

    /* renamed from: f */
    private final WeakReference<Activity> f378f;

    /* renamed from: com.google.ads.i$a */
    private static class C0183a extends Exception {
        public C0183a(String str) {
            super(str);
        }
    }

    /* renamed from: a */
    private static boolean m202a(Map<String, String> map) {
        String remove = map.remove("gwhirl_share_location");
        if ("1".equals(remove)) {
            return true;
        }
        if (remove != null && !"0".equals(remove)) {
            C0240b.m484b("Received an illegal value, '" + remove + "', for the special share location parameter from mediation server" + " (expected '0' or '1'). Will not share the location.");
        }
        return false;
    }

    public C0182i(C0179h hVar, Activity activity, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        this.f373a = hVar;
        this.f374b = str;
        this.f378f = new WeakReference<>(activity);
        this.f375c = adRequest;
        this.f376d = new HashMap<>(hashMap);
    }

    public void run() {
        try {
            C0240b.m480a("Trying to instantiate: " + this.f374b);
            m200a((MediationAdapter) C0177g.m181a(this.f374b, MediationAdapter.class));
        } catch (ClassNotFoundException e) {
            m201a("Cannot find adapter class '" + this.f374b + "'. Did you link the ad network's mediation adapter? Skipping ad network.", e, C0177g.C0178a.NOT_FOUND);
        } catch (Throwable th) {
            m201a("Error while creating adapter and loading ad from ad network. Skipping ad network.", th, C0177g.C0178a.EXCEPTION);
        }
    }

    /* renamed from: a */
    private void m201a(String str, Throwable th, C0177g.C0178a aVar) {
        C0240b.m485b(str, th);
        this.f373a.mo3081a(false, aVar);
    }

    /* renamed from: a */
    private <T extends NetworkExtras, U extends MediationServerParameters> void m200a(MediationAdapter<T, U> mediationAdapter) throws MediationServerParameters.MappingException, C0183a, IllegalAccessException, InstantiationException {
        MediationServerParameters mediationServerParameters;
        NetworkExtras networkExtras;
        Activity activity = (Activity) this.f378f.get();
        if (activity == null) {
            throw new C0183a("Activity became null while trying to instantiate adapter.");
        }
        this.f373a.mo3080a((MediationAdapter<?, ?>) mediationAdapter);
        Class<U> serverParametersType = mediationAdapter.getServerParametersType();
        if (serverParametersType != null) {
            MediationServerParameters mediationServerParameters2 = (MediationServerParameters) serverParametersType.newInstance();
            mediationServerParameters2.load(this.f376d);
            mediationServerParameters = mediationServerParameters2;
        } else {
            mediationServerParameters = null;
        }
        Class<T> additionalParametersType = mediationAdapter.getAdditionalParametersType();
        if (additionalParametersType != null) {
            networkExtras = (NetworkExtras) this.f375c.getNetworkExtras(additionalParametersType);
        } else {
            networkExtras = null;
        }
        MediationAdRequest mediationAdRequest = new MediationAdRequest(this.f375c, activity, this.f377e);
        if (this.f373a.f357a.mo3278a()) {
            if (!(mediationAdapter instanceof MediationInterstitialAdapter)) {
                throw new C0183a("Adapter " + this.f374b + " doesn't support the MediationInterstitialAdapter" + " interface.");
            }
            ((MediationInterstitialAdapter) mediationAdapter).requestInterstitialAd(new C0219k(this.f373a), activity, mediationServerParameters, mediationAdRequest, networkExtras);
        } else if (!(mediationAdapter instanceof MediationBannerAdapter)) {
            throw new C0183a("Adapter " + this.f374b + " doesn't support the MediationBannerAdapter interface");
        } else {
            ((MediationBannerAdapter) mediationAdapter).requestBannerAd(new C0218j(this.f373a), activity, mediationServerParameters, this.f373a.f357a.mo3281c(), mediationAdRequest, networkExtras);
        }
        this.f373a.mo3091k();
    }
}
