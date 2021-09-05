package com.google.ads.mediation.admob;

import com.google.ads.mediation.NetworkExtras;
import java.util.HashMap;
import java.util.Map;

public class AdMobAdapterExtras implements NetworkExtras {

    /* renamed from: a */
    private boolean f570a;

    /* renamed from: b */
    private Map<String, Object> f571b;

    public AdMobAdapterExtras() {
        this.f570a = false;
        clearExtras();
    }

    public AdMobAdapterExtras(AdMobAdapterExtras original) {
        this();
        if (original != null) {
            this.f570a = original.f570a;
            this.f571b.putAll(original.f571b);
        }
    }

    @Deprecated
    public AdMobAdapterExtras setPlusOneOptOut(boolean plusOneOptOut) {
        return this;
    }

    @Deprecated
    public boolean getPlusOneOptOut() {
        return false;
    }

    public AdMobAdapterExtras setUseExactAdSize(boolean useExactAdSize) {
        this.f570a = useExactAdSize;
        return this;
    }

    public boolean getUseExactAdSize() {
        return this.f570a;
    }

    public Map<String, Object> getExtras() {
        return this.f571b;
    }

    public AdMobAdapterExtras setExtras(Map<String, Object> extras) {
        if (extras == null) {
            throw new IllegalArgumentException("Argument 'extras' may not be null");
        }
        this.f571b = extras;
        return this;
    }

    public AdMobAdapterExtras clearExtras() {
        this.f571b = new HashMap();
        return this;
    }

    public AdMobAdapterExtras addExtra(String key, Object value) {
        this.f571b.put(key, value);
        return this;
    }
}
