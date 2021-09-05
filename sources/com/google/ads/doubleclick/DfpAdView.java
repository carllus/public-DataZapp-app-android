package com.google.ads.doubleclick;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;

public class DfpAdView extends AdView {
    public DfpAdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity, adSize, adUnitId);
    }

    public DfpAdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        super(activity, adSizes, adUnitId);
    }

    public DfpAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DfpAdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        super.setAppEventListener(appEventListener);
    }

    public void setSupportedAdSizes(AdSize... adSizes) {
        super.setSupportedAdSizes(adSizes);
    }

    public void enableManualImpressions(boolean useManualImpressions) {
        this.f45a.mo3219i().f601t.mo3396a(Boolean.valueOf(useManualImpressions));
    }

    public void recordImpression() {
        this.f45a.mo3236z();
    }

    public void resize(AdSize adSize) {
        this.f45a.mo3222l().setAdSize(adSize);
        this.f45a.mo3219i().f588g.mo3394a().mo3279b(adSize);
    }
}
