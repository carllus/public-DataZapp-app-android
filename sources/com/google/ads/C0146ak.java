package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.ads.C0150an;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* renamed from: com.google.ads.ak */
public class C0146ak extends C0145aj {

    /* renamed from: c */
    static boolean f269c = false;

    /* renamed from: d */
    private static Method f270d = null;

    /* renamed from: e */
    private static Method f271e = null;

    /* renamed from: f */
    private static Method f272f = null;

    /* renamed from: g */
    private static Method f273g = null;

    /* renamed from: h */
    private static Method f274h = null;

    /* renamed from: i */
    private static String f275i = null;

    /* renamed from: j */
    private static long f276j = 0;

    /* renamed from: com.google.ads.ak$a */
    static class C0147a extends Exception {
        public C0147a() {
        }

        public C0147a(Throwable th) {
            super(th);
        }
    }

    /* renamed from: a */
    public static C0146ak m71a(String str, Context context) {
        m76b(str, context);
        return new C0146ak(context);
    }

    /* renamed from: b */
    protected static synchronized void m76b(String str, Context context) {
        synchronized (C0146ak.class) {
            if (!f269c) {
                try {
                    f275i = str;
                    m80f(context);
                    f276j = m74b().longValue();
                    f269c = true;
                } catch (C0147a | UnsupportedOperationException e) {
                }
            }
        }
    }

    protected C0146ak(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027 A[ExcHandler: IOException (e java.io.IOException), Splitter:B:1:0x0001] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3009b(android.content.Context r4) {
        /*
            r3 = this;
            r0 = 1
            java.lang.String r1 = m77c()     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
            r3.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x002f, IOException -> 0x0027 }
        L_0x0008:
            r0 = 2
            java.lang.String r1 = m72a()     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
            r3.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x002d, IOException -> 0x0027 }
        L_0x0010:
            r0 = 25
            java.lang.Long r1 = m74b()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            long r1 = r1.longValue()     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
            r3.mo3005a((int) r0, (long) r1)     // Catch:{ a -> 0x002b, IOException -> 0x0027 }
        L_0x001d:
            r0 = 24
            java.lang.String r1 = m78d(r4)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
            r3.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0029, IOException -> 0x0027 }
        L_0x0026:
            return
        L_0x0027:
            r0 = move-exception
            goto L_0x0026
        L_0x0029:
            r0 = move-exception
            goto L_0x0026
        L_0x002b:
            r0 = move-exception
            goto L_0x001d
        L_0x002d:
            r0 = move-exception
            goto L_0x0010
        L_0x002f:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0146ak.mo3009b(android.content.Context):void");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x007d A[ExcHandler: IOException (e java.io.IOException), Splitter:B:6:0x0010] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3010c(android.content.Context r7) {
        /*
            r6 = this;
            r0 = 2
            java.lang.String r1 = m72a()     // Catch:{ a -> 0x0087, IOException -> 0x007d }
            r6.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0087, IOException -> 0x007d }
        L_0x0008:
            r0 = 1
            java.lang.String r1 = m77c()     // Catch:{ a -> 0x0085, IOException -> 0x007d }
            r6.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x0085, IOException -> 0x007d }
        L_0x0010:
            java.lang.Long r0 = m74b()     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            r2 = 25
            r6.mo3005a((int) r2, (long) r0)     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            long r2 = f276j     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0034
            r2 = 17
            long r3 = f276j     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            long r0 = r0 - r3
            r6.mo3005a((int) r2, (long) r0)     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            r0 = 23
            long r1 = f276j     // Catch:{ a -> 0x0083, IOException -> 0x007d }
            r6.mo3005a((int) r0, (long) r1)     // Catch:{ a -> 0x0083, IOException -> 0x007d }
        L_0x0034:
            android.view.MotionEvent r0 = r6.f265a     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            android.util.DisplayMetrics r1 = r6.f266b     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            java.util.ArrayList r1 = m73a((android.view.MotionEvent) r0, (android.util.DisplayMetrics) r1)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r2 = 14
            r0 = 0
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r6.mo3005a((int) r2, (long) r3)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r2 = 15
            r0 = 1
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            long r3 = r0.longValue()     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r6.mo3005a((int) r2, (long) r3)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            int r0 = r1.size()     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r2 = 3
            if (r0 < r2) goto L_0x0073
            r2 = 16
            r0 = 2
            java.lang.Object r0 = r1.get(r0)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            long r0 = r0.longValue()     // Catch:{ a -> 0x0081, IOException -> 0x007d }
            r6.mo3005a((int) r2, (long) r0)     // Catch:{ a -> 0x0081, IOException -> 0x007d }
        L_0x0073:
            r0 = 27
            java.lang.String r1 = m79e(r7)     // Catch:{ a -> 0x007f, IOException -> 0x007d }
            r6.mo3006a((int) r0, (java.lang.String) r1)     // Catch:{ a -> 0x007f, IOException -> 0x007d }
        L_0x007c:
            return
        L_0x007d:
            r0 = move-exception
            goto L_0x007c
        L_0x007f:
            r0 = move-exception
            goto L_0x007c
        L_0x0081:
            r0 = move-exception
            goto L_0x0073
        L_0x0083:
            r0 = move-exception
            goto L_0x0034
        L_0x0085:
            r0 = move-exception
            goto L_0x0010
        L_0x0087:
            r0 = move-exception
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.C0146ak.mo3010c(android.content.Context):void");
    }

    /* renamed from: a */
    static String m72a() throws C0147a {
        if (f275i != null) {
            return f275i;
        }
        throw new C0147a();
    }

    /* renamed from: b */
    static Long m74b() throws C0147a {
        if (f270d == null) {
            throw new C0147a();
        }
        try {
            return (Long) f270d.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C0147a(e);
        } catch (InvocationTargetException e2) {
            throw new C0147a(e2);
        }
    }

    /* renamed from: d */
    static String m78d(Context context) throws C0147a {
        if (f274h == null) {
            throw new C0147a();
        }
        try {
            String str = (String) f274h.invoke((Object) null, new Object[]{context});
            if (str != null) {
                return str;
            }
            throw new C0147a();
        } catch (IllegalAccessException e) {
            throw new C0147a(e);
        } catch (InvocationTargetException e2) {
            throw new C0147a(e2);
        }
    }

    /* renamed from: c */
    static String m77c() throws C0147a {
        if (f271e == null) {
            throw new C0147a();
        }
        try {
            return (String) f271e.invoke((Object) null, new Object[0]);
        } catch (IllegalAccessException e) {
            throw new C0147a(e);
        } catch (InvocationTargetException e2) {
            throw new C0147a(e2);
        }
    }

    /* renamed from: a */
    static ArrayList<Long> m73a(MotionEvent motionEvent, DisplayMetrics displayMetrics) throws C0147a {
        if (f273g == null || motionEvent == null) {
            throw new C0147a();
        }
        try {
            return (ArrayList) f273g.invoke((Object) null, new Object[]{motionEvent, displayMetrics});
        } catch (IllegalAccessException e) {
            throw new C0147a(e);
        } catch (InvocationTargetException e2) {
            throw new C0147a(e2);
        }
    }

    /* renamed from: e */
    static String m79e(Context context) throws C0147a {
        if (f272f == null) {
            throw new C0147a();
        }
        try {
            ByteBuffer byteBuffer = (ByteBuffer) f272f.invoke((Object) null, new Object[]{context});
            if (byteBuffer != null) {
                return C0154aq.m105a(byteBuffer.array(), false);
            }
            throw new C0147a();
        } catch (IllegalAccessException e) {
            throw new C0147a(e);
        } catch (InvocationTargetException e2) {
            throw new C0147a(e2);
        }
    }

    /* renamed from: b */
    private static String m75b(byte[] bArr, String str) throws C0147a {
        try {
            return new String(C0150an.m90a(bArr, str), "UTF-8");
        } catch (C0150an.C0151a e) {
            throw new C0147a(e);
        } catch (C0153ap e2) {
            throw new C0147a(e2);
        } catch (UnsupportedEncodingException e3) {
            throw new C0147a(e3);
        }
    }

    /* renamed from: f */
    private static void m80f(Context context) throws C0147a {
        try {
            byte[] a = C0150an.m89a(C0152ao.m91a());
            byte[] a2 = C0150an.m90a(a, C0152ao.m92b());
            File cacheDir = context.getCacheDir();
            if (cacheDir == null && (cacheDir = context.getDir("dex", 0)) == null) {
                throw new C0147a();
            }
            File createTempFile = File.createTempFile("ads", ".jar", cacheDir);
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(a2, 0, a2.length);
            fileOutputStream.close();
            DexClassLoader dexClassLoader = new DexClassLoader(createTempFile.getAbsolutePath(), cacheDir.getAbsolutePath(), (String) null, context.getClassLoader());
            Class loadClass = dexClassLoader.loadClass(m75b(a, C0152ao.m93c()));
            Class loadClass2 = dexClassLoader.loadClass(m75b(a, C0152ao.m99i()));
            Class loadClass3 = dexClassLoader.loadClass(m75b(a, C0152ao.m97g()));
            Class loadClass4 = dexClassLoader.loadClass(m75b(a, C0152ao.m101k()));
            Class loadClass5 = dexClassLoader.loadClass(m75b(a, C0152ao.m95e()));
            f270d = loadClass.getMethod(m75b(a, C0152ao.m94d()), new Class[0]);
            f271e = loadClass2.getMethod(m75b(a, C0152ao.m100j()), new Class[0]);
            f272f = loadClass3.getMethod(m75b(a, C0152ao.m98h()), new Class[]{Context.class});
            f273g = loadClass4.getMethod(m75b(a, C0152ao.m102l()), new Class[]{MotionEvent.class, DisplayMetrics.class});
            f274h = loadClass5.getMethod(m75b(a, C0152ao.m96f()), new Class[]{Context.class});
            String name = createTempFile.getName();
            createTempFile.delete();
            new File(cacheDir, name.replace(".jar", ".dex")).delete();
        } catch (C0153ap e) {
            throw new C0147a(e);
        } catch (FileNotFoundException e2) {
            throw new C0147a(e2);
        } catch (IOException e3) {
            throw new C0147a(e3);
        } catch (ClassNotFoundException e4) {
            throw new C0147a(e4);
        } catch (C0150an.C0151a e5) {
            throw new C0147a(e5);
        } catch (NoSuchMethodException e6) {
            throw new C0147a(e6);
        } catch (NullPointerException e7) {
            throw new C0147a(e7);
        }
    }
}
