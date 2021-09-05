package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.p003v7.internal.widget.ActivityChooserView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.C0146ak;
import com.google.ads.C0228n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;
import com.google.ads.util.C0249g;
import com.google.ads.util.C0259h;
import com.google.ads.util.IcsUtil;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {

    /* renamed from: a */
    protected final C0228n f394a;

    /* renamed from: b */
    private WeakReference<AdActivity> f395b = null;

    /* renamed from: c */
    private AdSize f396c;

    /* renamed from: d */
    private boolean f397d = false;

    /* renamed from: e */
    private boolean f398e = false;

    /* renamed from: f */
    private boolean f399f = false;

    public AdWebView(C0228n slotState, AdSize adSize) {
        super(slotState.f587f.mo3394a());
        this.f394a = slotState;
        this.f396c = adSize;
        setBackgroundColor(0);
        AdUtil.m446a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new DownloadListener() {
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(url), mimeType);
                    AdActivity i = AdWebView.this.mo3128i();
                    if (i != null && AdUtil.m451a(intent, (Context) i)) {
                        i.startActivity(intent);
                    }
                } catch (ActivityNotFoundException e) {
                    C0240b.m480a("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
                } catch (Throwable th) {
                    C0240b.m485b("Unknown error trying to start activity to view URL: " + url, th);
                }
            }
        });
        if (AdUtil.f618a >= 17) {
            C0259h.m510a(settings, slotState);
        } else if (AdUtil.f618a >= 11) {
            C0249g.m504a(settings, slotState);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.f618a >= 14) {
            setWebChromeClient(new IcsUtil.C0237a(slotState));
        } else if (AdUtil.f618a >= 11) {
            setWebChromeClient(new C0249g.C0251a(slotState));
        }
    }

    /* renamed from: f */
    public void mo3125f() {
        AdActivity i = mo3128i();
        if (i != null) {
            i.finish();
        }
    }

    /* renamed from: g */
    public void mo3126g() {
        if (AdUtil.f618a >= 11) {
            C0249g.m502a((View) this);
        }
        this.f398e = true;
    }

    /* renamed from: h */
    public void mo3127h() {
        if (this.f398e && AdUtil.f618a >= 11) {
            C0249g.m505b(this);
        }
        this.f398e = false;
    }

    /* renamed from: i */
    public AdActivity mo3128i() {
        if (this.f395b != null) {
            return (AdActivity) this.f395b.get();
        }
        return null;
    }

    /* renamed from: j */
    public boolean mo3129j() {
        return this.f399f;
    }

    /* renamed from: k */
    public boolean mo3130k() {
        return this.f398e;
    }

    public void setAdActivity(AdActivity adActivity) {
        this.f395b = new WeakReference<>(adActivity);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Throwable th) {
            C0240b.m489d("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String url) {
        try {
            super.loadUrl(url);
        } catch (Throwable th) {
            C0240b.m489d("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            C0240b.m489d("An error occurred while stopping loading in AdWebView:", th);
        }
    }

    public void destroy() {
        try {
            super.destroy();
        } catch (Throwable th) {
            C0240b.m489d("An error occurred while destroying an AdWebView:", th);
        }
        try {
            setWebViewClient(new WebViewClient());
        } catch (Throwable th2) {
        }
    }

    public synchronized void setAdSize(AdSize adSize) {
        this.f396c = adSize;
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i;
        int i2 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else if (this.f396c == null || this.f397d) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int mode = View.MeasureSpec.getMode(widthMeasureSpec);
                int size = View.MeasureSpec.getSize(widthMeasureSpec);
                int mode2 = View.MeasureSpec.getMode(heightMeasureSpec);
                int size2 = View.MeasureSpec.getSize(heightMeasureSpec);
                float f = getContext().getResources().getDisplayMetrics().density;
                int width = (int) (((float) this.f396c.getWidth()) * f);
                int height = (int) (((float) this.f396c.getHeight()) * f);
                if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                    i = size;
                } else {
                    i = Integer.MAX_VALUE;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                    i2 = size2;
                }
                if (((float) width) - (f * 6.0f) > ((float) i) || height > i2) {
                    C0240b.m484b("Not enough space to show ad! Wants: <" + width + ", " + height + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(width, height);
                }
            }
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        C0146ak a = this.f394a.f599r.mo3395a();
        if (a != null) {
            a.mo3007a(event);
        }
        return super.onTouchEvent(event);
    }

    public void setCustomClose(boolean useCustomClose) {
        AdActivity adActivity;
        this.f399f = useCustomClose;
        if (this.f395b != null && (adActivity = (AdActivity) this.f395b.get()) != null) {
            adActivity.setCustomClose(useCustomClose);
        }
    }

    public void setIsExpandedMraid(boolean isCurrentlyExpandedMraid) {
        this.f397d = isCurrentlyExpandedMraid;
    }

    /* renamed from: a */
    public void mo3123a(boolean z) {
        if (z) {
            setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    return event.getAction() == 2;
                }
            });
        } else {
            setOnTouchListener((View.OnTouchListener) null);
        }
    }
}
