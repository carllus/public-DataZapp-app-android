package com.google.ads;

import com.google.ads.internal.C0209h;
import com.google.ads.util.C0238a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.google.ads.c */
public class C0164c {

    /* renamed from: a */
    private static final Map<String, AdSize> f307a = Collections.unmodifiableMap(new HashMap<String, AdSize>() {
        {
            put("banner", AdSize.BANNER);
            put("mrec", AdSize.IAB_MRECT);
            put("fullbanner", AdSize.IAB_BANNER);
            put("leaderboard", AdSize.IAB_LEADERBOARD);
            put("skyscraper", AdSize.IAB_WIDE_SKYSCRAPER);
        }
    });

    /* renamed from: b */
    private final String f308b;

    /* renamed from: c */
    private final String f309c;

    /* renamed from: d */
    private final List<C0122a> f310d;

    /* renamed from: e */
    private final Integer f311e;

    /* renamed from: f */
    private final Integer f312f;

    /* renamed from: g */
    private final List<String> f313g;

    /* renamed from: h */
    private final List<String> f314h;

    /* renamed from: i */
    private final List<String> f315i;

    /* renamed from: a */
    public static C0164c m138a(String str) throws JSONException {
        List<String> list;
        List<String> list2;
        List<String> list3;
        Integer num;
        Integer num2;
        Integer num3 = null;
        JSONObject jSONObject = new JSONObject(str);
        String string = jSONObject.getString("qdata");
        String string2 = jSONObject.has("ad_type") ? jSONObject.getString("ad_type") : null;
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m137a(jSONArray.getJSONObject(i)));
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            if (optJSONObject.has("refresh")) {
                num2 = Integer.valueOf(optJSONObject.getInt("refresh"));
            } else {
                num2 = null;
            }
            if (optJSONObject.has("ad_network_timeout_millis")) {
                num3 = Integer.valueOf(optJSONObject.getInt("ad_network_timeout_millis"));
            }
            list2 = m139a(optJSONObject, "imp_urls");
            list3 = m139a(optJSONObject, "click_urls");
            list = m139a(optJSONObject, "nofill_urls");
            num = num3;
        } else {
            list = null;
            list2 = null;
            list3 = null;
            num = null;
            num2 = null;
        }
        return new C0164c(string, string2, arrayList, num2, num, list2, list3, list);
    }

    /* renamed from: a */
    public boolean mo3031a() {
        return this.f312f != null;
    }

    /* renamed from: b */
    public int mo3032b() {
        return this.f312f.intValue();
    }

    /* renamed from: c */
    public String mo3033c() {
        return this.f308b;
    }

    /* renamed from: d */
    public boolean mo3034d() {
        return this.f311e != null;
    }

    /* renamed from: e */
    public int mo3035e() {
        return this.f311e.intValue();
    }

    /* renamed from: f */
    public List<C0122a> mo3036f() {
        return this.f310d;
    }

    /* renamed from: g */
    public List<String> mo3037g() {
        return this.f313g;
    }

    /* renamed from: h */
    public List<String> mo3038h() {
        return this.f314h;
    }

    /* renamed from: i */
    public List<String> mo3039i() {
        return this.f315i;
    }

    /* renamed from: a */
    private static C0122a m137a(JSONObject jSONObject) throws JSONException {
        HashMap hashMap;
        String string = jSONObject.getString("id");
        String optString = jSONObject.optString("allocation_id", (String) null);
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        List<String> a = m139a(jSONObject, "imp_urls");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        HashMap hashMap2 = new HashMap(0);
        if (optJSONObject != null) {
            hashMap = new HashMap(optJSONObject.length());
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.getString(next));
            }
        } else {
            hashMap = hashMap2;
        }
        return new C0122a(optString, string, arrayList, a, hashMap);
    }

    /* renamed from: j */
    public C0209h mo3040j() {
        if (this.f309c == null) {
            return null;
        }
        if ("interstitial".equals(this.f309c)) {
            return C0209h.f512a;
        }
        AdSize adSize = f307a.get(this.f309c);
        if (adSize != null) {
            return C0209h.m392a(adSize);
        }
        return null;
    }

    /* renamed from: a */
    private static List<String> m139a(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return arrayList;
    }

    private C0164c(String str, String str2, List<C0122a> list, Integer num, Integer num2, List<String> list2, List<String> list3, List<String> list4) {
        C0238a.m471a(str);
        this.f308b = str;
        this.f309c = str2;
        this.f310d = list;
        this.f311e = num;
        this.f312f = num2;
        this.f313g = list2;
        this.f314h = list3;
        this.f315i = list4;
    }
}
