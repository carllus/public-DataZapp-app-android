package com.google.ads.internal;

import com.google.ads.AdSize;
import com.google.ads.C0221m;
import com.google.ads.C0228n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0240b;

public class ActivationOverlay extends AdWebView {

    /* renamed from: b */
    private volatile boolean f379b = true;

    /* renamed from: c */
    private boolean f380c = true;

    /* renamed from: d */
    private int f381d = 0;

    /* renamed from: e */
    private int f382e = 0;

    /* renamed from: f */
    private final C0210i f383f;

    public ActivationOverlay(C0228n slotState) {
        super(slotState, (AdSize) null);
        if (AdUtil.f618a < slotState.f585d.mo3394a().f544b.mo3394a().f548c.mo3395a().intValue()) {
            C0240b.m480a("Disabling hardware acceleration for an activation overlay.");
            mo3126g();
        }
        this.f383f = C0210i.m399a(slotState.f583b.mo3394a(), C0188a.f404c, true, true);
        setWebViewClient(this.f383f);
    }

    public void setOverlayEnabled(boolean overlayEnabled) {
        if (!overlayEnabled) {
            C0221m.m411a().f545c.mo3394a().post(new Runnable() {
                public void run() {
                    ActivationOverlay.this.f394a.f591j.mo3394a().removeView(this);
                }
            });
        }
        this.f379b = overlayEnabled;
    }

    public void setOverlayActivated(boolean overlayActivated) {
        this.f380c = overlayActivated;
    }

    /* renamed from: a */
    public boolean mo3096a() {
        return this.f379b;
    }

    /* renamed from: b */
    public boolean mo3097b() {
        return this.f380c;
    }

    /* renamed from: c */
    public int mo3098c() {
        return this.f382e;
    }

    public void setYPosition(int yPosition) {
        this.f382e = yPosition;
    }

    /* renamed from: d */
    public int mo3101d() {
        return this.f381d;
    }

    public void setXPosition(int xPosition) {
        this.f381d = xPosition;
    }

    /* renamed from: e */
    public C0210i mo3102e() {
        return this.f383f;
    }

    public boolean canScrollHorizontally(int direction) {
        return false;
    }

    public boolean canScrollVertically(int direction) {
        return false;
    }
}
