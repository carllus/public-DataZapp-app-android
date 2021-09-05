package com.google.ads.util;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.google.ads.util.i */
public abstract class C0260i {

    /* renamed from: a */
    private static final Object f667a = new Object();

    /* renamed from: b */
    private static int f668b = 0;

    /* renamed from: c */
    private static HashMap<Class<?>, Integer> f669c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C0262a<?>> f670d = new ArrayList<>();

    /* renamed from: u */
    public final int f671u;

    public C0260i() {
        synchronized (f667a) {
            int i = f668b;
            f668b = i + 1;
            this.f671u = i;
            Integer num = f669c.get(getClass());
            if (num == null) {
                f669c.put(getClass(), 1);
            } else {
                f669c.put(getClass(), Integer.valueOf(num.intValue() + 1));
            }
        }
        C0240b.m488d("State created: " + toString());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        synchronized (f667a) {
            f669c.put(getClass(), Integer.valueOf(f669c.get(getClass()).intValue() - 1));
        }
        super.finalize();
    }

    public String toString() {
        return getClass().getSimpleName() + "[" + this.f671u + "]";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m511a(C0262a<?> aVar) {
        this.f670d.add(aVar);
    }

    /* renamed from: com.google.ads.util.i$a */
    public abstract class C0262a<T> {

        /* renamed from: a */
        protected T f672a;

        /* renamed from: b */
        protected final String f673b;

        private C0262a(C0260i iVar, String str) {
            this(str, (Object) null);
        }

        private C0262a(String str, T t) {
            this.f673b = str;
            C0260i.this.m511a(this);
            this.f672a = t;
        }

        public String toString() {
            return C0260i.this.toString() + "." + this.f673b + " = " + this.f672a;
        }
    }

    /* renamed from: com.google.ads.util.i$c */
    public final class C0264c<T> extends C0262a<T> {

        /* renamed from: e */
        private boolean f677e;

        public C0264c(String str) {
            super(str);
            this.f677e = false;
            this.f677e = false;
        }

        public C0264c(String str, T t) {
            super(str, t);
            this.f677e = false;
            this.f677e = false;
        }

        /* renamed from: a */
        public synchronized T mo3395a() {
            return this.f672a;
        }

        /* renamed from: a */
        public synchronized void mo3396a(T t) {
            C0240b.m488d("State changed - " + C0260i.this.toString() + "." + this.f673b + ": '" + t + "' <-- '" + this.f672a + "'.");
            this.f672a = t;
            this.f677e = true;
        }

        public String toString() {
            return super.toString() + (this.f677e ? " (*)" : "");
        }
    }

    /* renamed from: com.google.ads.util.i$b */
    public final class C0263b<T> extends C0262a<T> {
        public C0263b(String str, T t) {
            super(str, t);
        }

        /* renamed from: a */
        public T mo3394a() {
            return this.f672a;
        }

        public String toString() {
            return super.toString() + " (!)";
        }
    }

    /* renamed from: com.google.ads.util.i$d */
    public final class C0265d<T> extends C0262a<WeakReference<T>> {
        public C0265d(String str, T t) {
            super(str, new WeakReference(t));
        }

        /* renamed from: a */
        public T mo3397a() {
            return ((WeakReference) this.f672a).get();
        }

        public String toString() {
            return C0260i.this.toString() + "." + this.f673b + " = " + mo3397a() + " (?)";
        }
    }
}
