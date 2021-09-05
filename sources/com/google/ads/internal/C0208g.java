package com.google.ads.internal;

import android.os.SystemClock;
import com.google.ads.C0177g;
import com.google.ads.util.C0240b;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.ads.internal.g */
public class C0208g {

    /* renamed from: f */
    private static long f496f = 0;

    /* renamed from: g */
    private static long f497g = 0;

    /* renamed from: h */
    private static long f498h = 0;

    /* renamed from: i */
    private static long f499i = 0;

    /* renamed from: j */
    private static long f500j = -1;

    /* renamed from: a */
    private final LinkedList<Long> f501a = new LinkedList<>();

    /* renamed from: b */
    private long f502b;

    /* renamed from: c */
    private long f503c;

    /* renamed from: d */
    private long f504d;

    /* renamed from: e */
    private final LinkedList<Long> f505e = new LinkedList<>();

    /* renamed from: k */
    private boolean f506k = false;

    /* renamed from: l */
    private boolean f507l = false;

    /* renamed from: m */
    private String f508m;

    /* renamed from: n */
    private long f509n;

    /* renamed from: o */
    private final LinkedList<Long> f510o = new LinkedList<>();

    /* renamed from: p */
    private final LinkedList<C0177g.C0178a> f511p = new LinkedList<>();

    public C0208g() {
        mo3249a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo3249a() {
        this.f501a.clear();
        this.f502b = 0;
        this.f503c = 0;
        this.f504d = 0;
        this.f505e.clear();
        this.f509n = -1;
        this.f510o.clear();
        this.f511p.clear();
        this.f506k = false;
        this.f507l = false;
    }

    /* renamed from: b */
    public synchronized void mo3252b() {
        this.f510o.clear();
        this.f511p.clear();
    }

    /* renamed from: c */
    public synchronized void mo3253c() {
        this.f509n = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public synchronized void mo3250a(C0177g.C0178a aVar) {
        this.f510o.add(Long.valueOf(SystemClock.elapsedRealtime() - this.f509n));
        this.f511p.add(aVar);
    }

    /* renamed from: d */
    public synchronized String mo3254d() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.f510o.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(longValue);
        }
        return sb.toString();
    }

    /* renamed from: e */
    public synchronized String mo3255e() {
        StringBuilder sb;
        sb = new StringBuilder();
        Iterator it = this.f511p.iterator();
        while (it.hasNext()) {
            C0177g.C0178a aVar = (C0177g.C0178a) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(aVar.ordinal());
        }
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public void mo3256f() {
        C0240b.m488d("Ad clicked.");
        this.f501a.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void mo3257g() {
        C0240b.m488d("Ad request loaded.");
        this.f502b = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public synchronized void mo3258h() {
        C0240b.m488d("Ad request before rendering.");
        this.f503c = SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public void mo3259i() {
        C0240b.m488d("Ad request started.");
        this.f504d = SystemClock.elapsedRealtime();
        f496f++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public long mo3260j() {
        if (this.f501a.size() != this.f505e.size()) {
            return -1;
        }
        return (long) this.f501a.size();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public String mo3261k() {
        if (this.f501a.isEmpty() || this.f501a.size() != this.f505e.size()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f501a.size()) {
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.f505e.get(i2).longValue() - this.f501a.get(i2).longValue()));
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public String mo3262l() {
        if (this.f501a.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f501a.size()) {
                return sb.toString();
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(this.f501a.get(i2).longValue() - this.f502b));
            i = i2 + 1;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public long mo3263m() {
        return this.f502b - this.f504d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public synchronized long mo3264n() {
        return this.f503c - this.f504d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public long mo3265o() {
        return f496f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public synchronized long mo3266p() {
        return f497g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: q */
    public synchronized void mo3267q() {
        C0240b.m488d("Ad request network error");
        f497g++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public synchronized void mo3268r() {
        f497g = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public synchronized long mo3269s() {
        return f498h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public synchronized void mo3270t() {
        f498h++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public synchronized void mo3271u() {
        f498h = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public synchronized long mo3272v() {
        return f499i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public synchronized void mo3273w() {
        f499i++;
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public synchronized void mo3274x() {
        f499i = 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: y */
    public boolean mo3275y() {
        return this.f506k;
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public void mo3276z() {
        C0240b.m488d("Interstitial network error.");
        this.f506k = true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: A */
    public boolean mo3245A() {
        return this.f507l;
    }

    /* access modifiers changed from: protected */
    /* renamed from: B */
    public void mo3246B() {
        C0240b.m488d("Interstitial no fill.");
        this.f507l = true;
    }

    /* renamed from: C */
    public void mo3247C() {
        C0240b.m488d("Landing page dismissed.");
        this.f505e.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    /* access modifiers changed from: protected */
    /* renamed from: D */
    public String mo3248D() {
        return this.f508m;
    }

    /* renamed from: a */
    public void mo3251a(String str) {
        C0240b.m488d("Prior impression ticket = " + str);
        this.f508m = str;
    }

    /* renamed from: E */
    public static long m359E() {
        if (f500j != -1) {
            return SystemClock.elapsedRealtime() - f500j;
        }
        f500j = SystemClock.elapsedRealtime();
        return 0;
    }
}
