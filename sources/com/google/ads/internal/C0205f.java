package com.google.ads.internal;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.C0220l;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.google.ads.internal.f */
public final class C0205f implements Runnable {

    /* renamed from: a */
    private final C0220l f490a;

    /* renamed from: b */
    private final C0207a f491b;

    /* renamed from: c */
    private volatile boolean f492c;

    /* renamed from: d */
    private boolean f493d;

    /* renamed from: e */
    private String f494e;

    /* renamed from: f */
    private Thread f495f;

    /* renamed from: com.google.ads.internal.f$a */
    public interface C0207a {
        /* renamed from: a */
        HttpURLConnection mo3244a(URL url) throws IOException;
    }

    C0205f(C0220l lVar) {
        this(lVar, new C0207a() {
            /* renamed from: a */
            public HttpURLConnection mo3244a(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }
        });
    }

    C0205f(C0220l lVar, C0207a aVar) {
        this.f495f = null;
        this.f490a = lVar;
        this.f491b = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3240a() {
        this.f492c = true;
    }

    /* renamed from: a */
    private void m338a(HttpURLConnection httpURLConnection) {
        m341b(httpURLConnection);
        m345f(httpURLConnection);
        m346g(httpURLConnection);
        m347h(httpURLConnection);
        m348i(httpURLConnection);
        m344e(httpURLConnection);
        m349j(httpURLConnection);
        m350k(httpURLConnection);
        m351l(httpURLConnection);
        m343d(httpURLConnection);
        m342c(httpURLConnection);
        m352m(httpURLConnection);
        m353n(httpURLConnection);
    }

    /* renamed from: b */
    private void m341b(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Debug-Dialog");
        if (!TextUtils.isEmpty(headerField)) {
            this.f490a.f540b.mo3395a().mo3178f(headerField);
        }
    }

    /* renamed from: c */
    private void m342c(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Content-Type");
        if (!TextUtils.isEmpty(headerField)) {
            this.f490a.f540b.mo3395a().mo3169b(headerField);
        }
    }

    /* renamed from: d */
    private void m343d(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Mediation");
        if (!TextUtils.isEmpty(headerField)) {
            this.f490a.f540b.mo3395a().mo3170b(Boolean.valueOf(headerField).booleanValue());
        }
    }

    /* renamed from: e */
    private void m344e(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Interstitial-Timeout");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                this.f490a.f539a.mo3394a().f583b.mo3394a().mo3195a((long) (Float.parseFloat(headerField) * 1000.0f));
            } catch (NumberFormatException e) {
                C0240b.m489d("Could not get timeout value: " + headerField, e);
            }
        }
    }

    /* renamed from: f */
    private void m345f(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String b : headerField.trim().split("\\s+")) {
                this.f490a.f539a.mo3394a().f583b.mo3394a().mo3210b(b);
            }
        }
    }

    /* renamed from: g */
    private void m346g(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Manual-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String c : headerField.trim().split("\\s+")) {
                this.f490a.f539a.mo3394a().f583b.mo3394a().mo3213c(c);
            }
        }
    }

    /* renamed from: h */
    private void m347h(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Click-Tracking-Urls");
        if (!TextUtils.isEmpty(headerField)) {
            for (String a : headerField.trim().split("\\s+")) {
                this.f490a.f540b.mo3395a().mo3165a(a);
            }
        }
    }

    /* renamed from: i */
    private void m348i(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Refresh-Rate");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                float parseFloat = Float.parseFloat(headerField);
                C0203d a = this.f490a.f539a.mo3394a().f583b.mo3394a();
                if (parseFloat > 0.0f) {
                    a.mo3192a(parseFloat);
                    if (!a.mo3230t()) {
                        a.mo3217g();
                    }
                } else if (a.mo3230t()) {
                    a.mo3216f();
                }
            } catch (NumberFormatException e) {
                C0240b.m489d("Could not get refresh value: " + headerField, e);
            }
        }
    }

    /* renamed from: j */
    private void m349j(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Orientation");
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        if (headerField.equals("portrait")) {
            this.f490a.f540b.mo3395a().mo3159a(AdUtil.m454b());
        } else if (headerField.equals("landscape")) {
            this.f490a.f540b.mo3395a().mo3159a(AdUtil.m436a());
        }
    }

    /* renamed from: k */
    private void m350k(HttpURLConnection httpURLConnection) {
        if (!TextUtils.isEmpty(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life"))) {
            try {
                this.f490a.f539a.mo3394a().f583b.mo3394a().mo3208b(Long.parseLong(httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life")));
            } catch (NumberFormatException e) {
                C0240b.m490e("Got bad value of Doritos cookie cache life from header: " + httpURLConnection.getHeaderField("X-Afma-Doritos-Cache-Life") + ". Using default value instead.");
            }
        }
    }

    /* renamed from: a */
    public void mo3242a(boolean z) {
        this.f493d = z;
    }

    /* renamed from: l */
    private void m351l(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("Cache-Control");
        if (!TextUtils.isEmpty(headerField)) {
            this.f490a.f540b.mo3395a().mo3172c(headerField);
        }
    }

    /* renamed from: m */
    private void m352m(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Ad-Size");
        if (!TextUtils.isEmpty(headerField)) {
            try {
                String[] split = headerField.split("x", 2);
                if (split.length != 2) {
                    C0240b.m490e("Could not parse size header: " + headerField);
                    return;
                }
                this.f490a.f540b.mo3395a().mo3163a(new AdSize(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
            } catch (NumberFormatException e) {
                C0240b.m490e("Could not parse size header: " + headerField);
            }
        }
    }

    /* renamed from: n */
    private void m353n(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField("X-Afma-Disable-Activation-And-Scroll");
        if (!TextUtils.isEmpty(headerField)) {
            this.f490a.f540b.mo3395a().mo3167a(headerField.equals("1"));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo3241a(String str) {
        if (this.f495f == null) {
            this.f494e = str;
            this.f492c = false;
            this.f495f = new Thread(this);
            this.f495f.start();
        }
    }

    /* renamed from: a */
    private void m339a(HttpURLConnection httpURLConnection, int i) throws IOException {
        if (300 <= i && i < 400) {
            String headerField = httpURLConnection.getHeaderField("Location");
            if (headerField == null) {
                C0240b.m486c("Could not get redirect location from a " + i + " redirect.");
                this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.INTERNAL_ERROR);
                mo3240a();
                return;
            }
            m338a(httpURLConnection);
            this.f494e = headerField;
        } else if (i == 200) {
            m338a(httpURLConnection);
            String trim = AdUtil.m442a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).trim();
            C0240b.m480a("Response content is: " + trim);
            if (TextUtils.isEmpty(trim)) {
                C0240b.m480a("Response message is null or zero length: " + trim);
                this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.NO_FILL);
                mo3240a();
                return;
            }
            this.f490a.f540b.mo3395a().mo3166a(trim, this.f494e);
            mo3240a();
        } else if (i == 400) {
            C0240b.m486c("Bad request");
            this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.INVALID_REQUEST);
            mo3240a();
        } else {
            C0240b.m486c("Invalid response code: " + i);
            this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.INTERNAL_ERROR);
            mo3240a();
        }
    }

    public void run() {
        try {
            m340b();
        } catch (MalformedURLException e) {
            C0240b.m485b("Received malformed ad url from javascript.", e);
            this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.INTERNAL_ERROR);
        } catch (IOException e2) {
            C0240b.m485b("IOException connecting to ad url.", e2);
            this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.NETWORK_ERROR);
        } catch (Throwable th) {
            C0240b.m485b("An unknown error occurred in AdResponseLoader.", th);
            this.f490a.f540b.mo3395a().mo3160a(AdRequest.ErrorCode.INTERNAL_ERROR);
        }
    }

    /* renamed from: b */
    private void m340b() throws MalformedURLException, IOException {
        while (!this.f492c) {
            HttpURLConnection a = this.f491b.mo3244a(new URL(this.f494e));
            try {
                m337a(this.f490a.f539a.mo3394a().f587f.mo3394a(), a);
                AdUtil.m447a(a, this.f490a.f539a.mo3394a().f587f.mo3394a());
                a.setInstanceFollowRedirects(false);
                a.connect();
                m339a(a, a.getResponseCode());
            } finally {
                a.disconnect();
            }
        }
    }

    /* renamed from: a */
    private void m337a(Context context, HttpURLConnection httpURLConnection) {
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString("drt", "");
        if (this.f493d && !TextUtils.isEmpty(string)) {
            if (AdUtil.f618a == 8) {
                httpURLConnection.addRequestProperty("X-Afma-drt-Cookie", string);
            } else {
                httpURLConnection.addRequestProperty("Cookie", string);
            }
        }
    }
}
