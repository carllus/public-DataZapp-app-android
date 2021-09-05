package com.google.ads;

import android.content.Context;
import android.support.p000v4.internal.view.SupportMenu;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "mb");
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER = new AdSize(468, 60, "as");
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90, "as");
    public static final AdSize IAB_MRECT = new AdSize(300, 250, "as");
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "mb");

    /* renamed from: a */
    private final int f38a;

    /* renamed from: b */
    private final int f39b;

    /* renamed from: c */
    private boolean f40c;

    /* renamed from: d */
    private boolean f41d;

    /* renamed from: e */
    private boolean f42e;

    /* renamed from: f */
    private String f43f;

    public AdSize(int width, int height) {
        this(width, height, (String) null);
        if (m18a()) {
            this.f42e = false;
            this.f43f = "mb";
            return;
        }
        this.f42e = true;
    }

    private AdSize(int width, int height, String type) {
        boolean z;
        boolean z2 = true;
        this.f38a = width;
        this.f39b = height;
        this.f43f = type;
        if (width == -1) {
            z = true;
        } else {
            z = false;
        }
        this.f40c = z;
        this.f41d = height != -2 ? false : z2;
        this.f42e = false;
    }

    public static AdSize createAdSize(AdSize adSize, Context context) {
        if (context == null || !adSize.m18a()) {
            return adSize.m18a() ? BANNER : adSize;
        }
        AdSize adSize2 = new AdSize(adSize.f40c ? m17a(context) : adSize.getWidth(), adSize.f41d ? m19b(context) : adSize.getHeight(), adSize.f43f);
        adSize2.f41d = adSize.f41d;
        adSize2.f40c = adSize.f40c;
        adSize2.f42e = adSize.f42e;
        return adSize2;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        if (this.f38a == adSize.f38a && this.f39b == adSize.f39b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f38a).hashCode() << 16) | (Integer.valueOf(this.f39b).hashCode() & SupportMenu.USER_MASK);
    }

    public int getWidth() {
        if (this.f38a >= 0) {
            return this.f38a;
        }
        throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }

    public int getHeight() {
        if (this.f39b >= 0) {
            return this.f39b;
        }
        throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }

    /* renamed from: a */
    private boolean m18a() {
        return this.f38a < 0 || this.f39b < 0;
    }

    public boolean isFullWidth() {
        return this.f40c;
    }

    public boolean isAutoHeight() {
        return this.f41d;
    }

    public boolean isCustomAdSize() {
        return this.f42e;
    }

    public String toString() {
        return getWidth() + "x" + getHeight() + (this.f43f == null ? "" : "_" + this.f43f);
    }

    public int getWidthInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f38a, context.getResources().getDisplayMetrics());
    }

    public int getHeightInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f39b, context.getResources().getDisplayMetrics());
    }

    public boolean isSizeAppropriate(int width, int height) {
        return ((double) width) <= ((double) this.f38a) * 1.25d && ((double) width) >= ((double) this.f38a) * 0.8d && ((double) height) <= ((double) this.f39b) * 1.25d && ((double) height) >= ((double) this.f39b) * 0.8d;
    }

    public AdSize findBestSize(AdSize... options) {
        double d;
        AdSize adSize;
        AdSize adSize2 = null;
        double d2 = 0.0d;
        if (options != null) {
            int length = options.length;
            int i = 0;
            while (i < length) {
                AdSize adSize3 = options[i];
                if (isSizeAppropriate(adSize3.f38a, adSize3.f39b)) {
                    d = (((double) adSize3.f38a) * ((double) adSize3.f39b)) / (((double) this.f38a) * ((double) this.f39b));
                    if (d > 1.0d) {
                        d = 1.0d / d;
                    }
                    if (d > d2) {
                        adSize = adSize3;
                        i++;
                        adSize2 = adSize;
                        d2 = d;
                    }
                }
                d = d2;
                adSize = adSize2;
                i++;
                adSize2 = adSize;
                d2 = d;
            }
        }
        return adSize2;
    }

    /* renamed from: a */
    private static int m17a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    /* renamed from: b */
    private static int m19b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        if (i <= 720) {
            return 50;
        }
        return 90;
    }
}
