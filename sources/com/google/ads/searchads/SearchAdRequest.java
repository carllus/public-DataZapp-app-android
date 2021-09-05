package com.google.ads.searchads;

import android.content.Context;
import android.graphics.Color;
import com.google.ads.AdRequest;
import com.google.ads.mediation.admob.AdMobAdapterExtras;
import java.util.Locale;
import java.util.Map;

public class SearchAdRequest extends AdRequest {

    /* renamed from: a */
    private String f603a;

    /* renamed from: b */
    private int f604b;

    /* renamed from: c */
    private int f605c;

    /* renamed from: d */
    private int f606d;

    /* renamed from: e */
    private int f607e;

    /* renamed from: f */
    private int f608f;

    /* renamed from: g */
    private int f609g;

    /* renamed from: h */
    private String f610h;

    /* renamed from: i */
    private int f611i;

    /* renamed from: j */
    private int f612j;

    /* renamed from: k */
    private BorderType f613k;

    /* renamed from: l */
    private int f614l;

    /* renamed from: m */
    private String f615m;

    public enum BorderType {
        NONE("none"),
        DASHED("dashed"),
        DOTTED("dotted"),
        SOLID("solid");
        

        /* renamed from: a */
        private String f617a;

        private BorderType(String param) {
            this.f617a = param;
        }

        public String toString() {
            return this.f617a;
        }
    }

    public void setQuery(String query) {
        this.f603a = query;
    }

    public void setBackgroundColor(int backgroundColor) {
        if (Color.alpha(backgroundColor) == 255) {
            this.f604b = backgroundColor;
            this.f605c = 0;
            this.f606d = 0;
        }
    }

    public void setBackgroundGradient(int from, int to) {
        if (Color.alpha(from) == 255 && Color.alpha(to) == 255) {
            this.f604b = Color.argb(0, 0, 0, 0);
            this.f605c = from;
            this.f606d = to;
        }
    }

    public void setHeaderTextColor(int headerTextColor) {
        this.f607e = headerTextColor;
    }

    public void setDescriptionTextColor(int descriptionTextColor) {
        this.f608f = descriptionTextColor;
    }

    public void setAnchorTextColor(int anchorTextColor) {
        this.f609g = anchorTextColor;
    }

    public void setFontFace(String fontFace) {
        this.f610h = fontFace;
    }

    public void setHeaderTextSize(int headerTextSize) {
        this.f611i = headerTextSize;
    }

    public void setBorderColor(int borderColor) {
        this.f612j = borderColor;
    }

    public void setBorderType(BorderType borderType) {
        this.f613k = borderType;
    }

    public void setBorderThickness(int borderThickness) {
        this.f614l = borderThickness;
    }

    public void setCustomChannels(String channelIds) {
        this.f615m = channelIds;
    }

    public Map<String, Object> getRequestMap(Context context) {
        AdMobAdapterExtras adMobAdapterExtras = (AdMobAdapterExtras) getNetworkExtras(AdMobAdapterExtras.class);
        if (adMobAdapterExtras == null) {
            adMobAdapterExtras = new AdMobAdapterExtras();
            setNetworkExtras(adMobAdapterExtras);
        }
        if (this.f603a != null) {
            adMobAdapterExtras.getExtras().put("q", this.f603a);
        }
        if (Color.alpha(this.f604b) != 0) {
            adMobAdapterExtras.getExtras().put("bgcolor", m433a(this.f604b));
        }
        if (Color.alpha(this.f605c) == 255 && Color.alpha(this.f606d) == 255) {
            adMobAdapterExtras.getExtras().put("gradientfrom", m433a(this.f605c));
            adMobAdapterExtras.getExtras().put("gradientto", m433a(this.f606d));
        }
        if (Color.alpha(this.f607e) != 0) {
            adMobAdapterExtras.getExtras().put("hcolor", m433a(this.f607e));
        }
        if (Color.alpha(this.f608f) != 0) {
            adMobAdapterExtras.getExtras().put("dcolor", m433a(this.f608f));
        }
        if (Color.alpha(this.f609g) != 0) {
            adMobAdapterExtras.getExtras().put("acolor", m433a(this.f609g));
        }
        if (this.f610h != null) {
            adMobAdapterExtras.getExtras().put("font", this.f610h);
        }
        adMobAdapterExtras.getExtras().put("headersize", Integer.toString(this.f611i));
        if (Color.alpha(this.f612j) != 0) {
            adMobAdapterExtras.getExtras().put("bcolor", m433a(this.f612j));
        }
        if (this.f613k != null) {
            adMobAdapterExtras.getExtras().put("btype", this.f613k.toString());
        }
        adMobAdapterExtras.getExtras().put("bthick", Integer.toString(this.f614l));
        if (this.f615m != null) {
            adMobAdapterExtras.getExtras().put("channel", this.f615m);
        }
        return super.getRequestMap(context);
    }

    /* renamed from: a */
    private String m433a(int i) {
        return String.format(Locale.US, "#%06x", new Object[]{Integer.valueOf(16777215 & i)});
    }
}
