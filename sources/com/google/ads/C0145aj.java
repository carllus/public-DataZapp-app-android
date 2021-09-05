package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/* renamed from: com.google.ads.aj */
public abstract class C0145aj implements C0144ai {

    /* renamed from: a */
    protected MotionEvent f265a = null;

    /* renamed from: b */
    protected DisplayMetrics f266b = null;

    /* renamed from: c */
    private C0160au f267c = null;

    /* renamed from: d */
    private ByteArrayOutputStream f268d = null;

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo3009b(Context context);

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public abstract void mo3010c(Context context);

    protected C0145aj(Context context) {
        try {
            this.f266b = context.getResources().getDisplayMetrics();
        } catch (UnsupportedOperationException e) {
            this.f266b = new DisplayMetrics();
            this.f266b.density = 1.0f;
        }
    }

    /* renamed from: a */
    public String mo3001a(Context context) {
        return m58a(context, (String) null, false);
    }

    /* renamed from: a */
    public String mo3002a(Context context, String str) {
        return m58a(context, str, true);
    }

    /* renamed from: a */
    public void mo3007a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            if (this.f265a != null) {
                this.f265a.recycle();
            }
            this.f265a = MotionEvent.obtain(motionEvent);
        }
    }

    /* renamed from: a */
    public void mo3004a(int i, int i2, int i3) {
        if (this.f265a != null) {
            this.f265a.recycle();
        }
        this.f265a = MotionEvent.obtain(0, (long) i3, 1, ((float) i) * this.f266b.density, ((float) i2) * this.f266b.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
    }

    /* renamed from: a */
    private String m58a(Context context, String str, boolean z) {
        try {
            m59a();
            if (z) {
                mo3010c(context);
            } else {
                mo3009b(context);
            }
            byte[] b = m60b();
            if (b.length == 0) {
                return Integer.toString(5);
            }
            return mo3003a(b, str);
        } catch (NoSuchAlgorithmException e) {
            return Integer.toString(7);
        } catch (UnsupportedEncodingException e2) {
            return Integer.toString(7);
        } catch (IOException e3) {
            return Integer.toString(3);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3005a(int i, long j) throws IOException {
        this.f267c.mo3021a(i, j);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3006a(int i, String str) throws IOException {
        this.f267c.mo3022a(i, str);
    }

    /* renamed from: a */
    private void m59a() {
        this.f268d = new ByteArrayOutputStream();
        this.f267c = C0160au.m116a((OutputStream) this.f268d);
    }

    /* renamed from: b */
    private byte[] m60b() throws IOException {
        this.f267c.mo3017a();
        return this.f268d.toByteArray();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo3003a(byte[] bArr, String str) throws NoSuchAlgorithmException, UnsupportedEncodingException, IOException {
        byte[] array;
        if (bArr.length > 239) {
            m59a();
            mo3005a(20, 1);
            bArr = m60b();
        }
        if (bArr.length < 239) {
            byte[] bArr2 = new byte[(239 - bArr.length)];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(240).put((byte) bArr.length).put(bArr).array();
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(array);
        byte[] array2 = ByteBuffer.allocate(256).put(instance.digest()).put(array).array();
        byte[] bArr3 = new byte[256];
        new C0128ag().mo2999a(array2, bArr3);
        if (str != null && str.length() > 0) {
            mo3008a(str, bArr3);
        }
        return C0154aq.m105a(bArr3, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo3008a(String str, byte[] bArr) throws UnsupportedEncodingException {
        if (str.length() > 32) {
            str = str.substring(0, 32);
        }
        new C0155ar(str.getBytes("UTF-8")).mo3014a(bArr);
    }
}
