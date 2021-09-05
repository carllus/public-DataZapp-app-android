package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

public class MediationAdRequest {

    /* renamed from: a */
    private AdRequest f561a;

    /* renamed from: b */
    private boolean f562b;

    /* renamed from: c */
    private boolean f563c;

    public MediationAdRequest(AdRequest request, Context context, boolean shareLocation) {
        this.f561a = request;
        this.f563c = shareLocation;
        if (context == null) {
            this.f562b = true;
        } else {
            this.f562b = request.isTestDevice(context);
        }
    }

    public AdRequest.Gender getGender() {
        return this.f561a.getGender();
    }

    public Date getBirthday() {
        return this.f561a.getBirthday();
    }

    public Integer getAgeInYears() {
        if (this.f561a.getBirthday() == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.f561a.getBirthday());
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        if (instance2.get(6) < instance.get(6)) {
            return Integer.valueOf(valueOf.intValue() - 1);
        }
        return valueOf;
    }

    public Set<String> getKeywords() {
        if (this.f561a.getKeywords() == null) {
            return null;
        }
        return Collections.unmodifiableSet(this.f561a.getKeywords());
    }

    public Location getLocation() {
        if (this.f561a.getLocation() == null || !this.f563c) {
            return null;
        }
        return new Location(this.f561a.getLocation());
    }

    public boolean isTesting() {
        return this.f562b;
    }
}
