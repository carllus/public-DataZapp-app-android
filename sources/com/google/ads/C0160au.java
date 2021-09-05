package com.google.ads;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.ads.au */
public final class C0160au {

    /* renamed from: a */
    private final byte[] f295a;

    /* renamed from: b */
    private final int f296b;

    /* renamed from: c */
    private int f297c;

    /* renamed from: d */
    private int f298d = 0;

    /* renamed from: e */
    private final OutputStream f299e;

    private C0160au(OutputStream outputStream, byte[] bArr) {
        this.f299e = outputStream;
        this.f295a = bArr;
        this.f297c = 0;
        this.f296b = bArr.length;
    }

    /* renamed from: a */
    public static C0160au m116a(OutputStream outputStream) {
        return m117a(outputStream, 4096);
    }

    /* renamed from: a */
    public static C0160au m117a(OutputStream outputStream, int i) {
        return new C0160au(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public void mo3021a(int i, long j) throws IOException {
        mo3020a(i, 0);
        mo3023a(j);
    }

    /* renamed from: a */
    public void mo3022a(int i, String str) throws IOException {
        mo3020a(i, 2);
        mo3024a(str);
    }

    /* renamed from: a */
    public void mo3023a(long j) throws IOException {
        mo3028b(j);
    }

    /* renamed from: a */
    public void mo3024a(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        mo3027b(bytes.length);
        mo3025a(bytes);
    }

    /* renamed from: b */
    private void m118b() throws IOException {
        if (this.f299e == null) {
            throw new C0161a();
        }
        this.f299e.write(this.f295a, 0, this.f297c);
        this.f297c = 0;
    }

    /* renamed from: a */
    public void mo3017a() throws IOException {
        if (this.f299e != null) {
            m118b();
        }
    }

    /* renamed from: com.google.ads.au$a */
    public static class C0161a extends IOException {
        C0161a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    /* renamed from: a */
    public void mo3018a(byte b) throws IOException {
        if (this.f297c == this.f296b) {
            m118b();
        }
        byte[] bArr = this.f295a;
        int i = this.f297c;
        this.f297c = i + 1;
        bArr[i] = b;
        this.f298d++;
    }

    /* renamed from: a */
    public void mo3019a(int i) throws IOException {
        mo3018a((byte) i);
    }

    /* renamed from: a */
    public void mo3025a(byte[] bArr) throws IOException {
        mo3026a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public void mo3026a(byte[] bArr, int i, int i2) throws IOException {
        if (this.f296b - this.f297c >= i2) {
            System.arraycopy(bArr, i, this.f295a, this.f297c, i2);
            this.f297c += i2;
            this.f298d += i2;
            return;
        }
        int i3 = this.f296b - this.f297c;
        System.arraycopy(bArr, i, this.f295a, this.f297c, i3);
        int i4 = i + i3;
        int i5 = i2 - i3;
        this.f297c = this.f296b;
        this.f298d = i3 + this.f298d;
        m118b();
        if (i5 <= this.f296b) {
            System.arraycopy(bArr, i4, this.f295a, 0, i5);
            this.f297c = i5;
        } else {
            this.f299e.write(bArr, i4, i5);
        }
        this.f298d += i5;
    }

    /* renamed from: a */
    public void mo3020a(int i, int i2) throws IOException {
        mo3027b(C0162av.m131a(i, i2));
    }

    /* renamed from: b */
    public void mo3027b(int i) throws IOException {
        while ((i & -128) != 0) {
            mo3019a((i & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        mo3019a(i);
    }

    /* renamed from: b */
    public void mo3028b(long j) throws IOException {
        while ((-128 & j) != 0) {
            mo3019a((((int) j) & TransportMediator.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        mo3019a((int) j);
    }
}
