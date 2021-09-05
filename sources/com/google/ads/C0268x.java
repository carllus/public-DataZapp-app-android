package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.C0221m;
import com.google.ads.internal.ActivationOverlay;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0203d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import com.google.ads.util.C0249g;
import com.google.ads.util.C0260i;
import java.util.HashMap;

/* renamed from: com.google.ads.x */
public class C0268x implements C0229o {
    /* renamed from: a */
    public void mo2994a(C0203d dVar, HashMap<String, String> hashMap, WebView webView) {
        boolean z;
        C0228n i = dVar.mo3219i();
        C0221m.C0222a a = i.f585d.mo3394a().f544b.mo3394a();
        m521c(hashMap, "as_domains", a.f546a);
        m521c(hashMap, "bad_ad_report_path", a.f553h);
        m519a(hashMap, "min_hwa_banner", a.f547b);
        m519a(hashMap, "min_hwa_activation_overlay", a.f548c);
        m519a(hashMap, "min_hwa_overlay", a.f549d);
        m521c(hashMap, "mraid_banner_path", a.f550e);
        m521c(hashMap, "mraid_expanded_banner_path", a.f551f);
        m521c(hashMap, "mraid_interstitial_path", a.f552g);
        m520b(hashMap, "ac_max_size", a.f554i);
        m520b(hashMap, "ac_padding", a.f555j);
        m520b(hashMap, "ac_total_quota", a.f556k);
        m520b(hashMap, "db_total_quota", a.f557l);
        m520b(hashMap, "db_quota_per_origin", a.f558m);
        m520b(hashMap, "db_quota_step_size", a.f559n);
        AdWebView l = dVar.mo3222l();
        if (AdUtil.f618a >= 11) {
            C0249g.m504a(l.getSettings(), i);
            C0249g.m504a(webView.getSettings(), i);
        }
        if (!i.f588g.mo3394a().mo3278a()) {
            boolean k = l.mo3130k();
            boolean z2 = AdUtil.f618a < a.f547b.mo3395a().intValue();
            if (!z2 && k) {
                C0240b.m480a("Re-enabling hardware acceleration for a banner after reading constants.");
                l.mo3127h();
            } else if (z2 && !k) {
                C0240b.m480a("Disabling hardware acceleration for a banner after reading constants.");
                l.mo3126g();
            }
        }
        ActivationOverlay a2 = i.f586e.mo3394a();
        if (!i.f588g.mo3394a().mo3280b() && a2 != null) {
            boolean k2 = a2.mo3130k();
            if (AdUtil.f618a < a.f548c.mo3395a().intValue()) {
                z = true;
            } else {
                z = false;
            }
            if (!z && k2) {
                C0240b.m480a("Re-enabling hardware acceleration for an activation overlay after reading constants.");
                a2.mo3127h();
            } else if (z && !k2) {
                C0240b.m480a("Disabling hardware acceleration for an activation overlay after reading constants.");
                a2.mo3126g();
            }
        }
        String a3 = a.f546a.mo3395a();
        C0148al a4 = i.f600s.mo3395a();
        if (a4 != null && !TextUtils.isEmpty(a3)) {
            a4.mo3012a(a3);
        }
        a.f560o.mo3396a(true);
    }

    /* renamed from: a */
    private void m519a(HashMap<String, String> hashMap, String str, C0260i.C0264c<Integer> cVar) {
        try {
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                cVar.mo3396a(Integer.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0240b.m480a("Could not parse \"" + str + "\" constant.");
        }
    }

    /* renamed from: b */
    private void m520b(HashMap<String, String> hashMap, String str, C0260i.C0264c<Long> cVar) {
        try {
            String str2 = hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                cVar.mo3396a(Long.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0240b.m480a("Could not parse \"" + str + "\" constant.");
        }
    }

    /* renamed from: c */
    private void m521c(HashMap<String, String> hashMap, String str, C0260i.C0264c<String> cVar) {
        String str2 = hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            cVar.mo3396a(str2);
        }
    }
}
