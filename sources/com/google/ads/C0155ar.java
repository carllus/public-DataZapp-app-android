package com.google.ads;

import android.support.p000v4.view.MotionEventCompat;

/* renamed from: com.google.ads.ar */
public class C0155ar {

    /* renamed from: a */
    private final byte[] f286a = new byte[256];

    /* renamed from: b */
    private int f287b;

    /* renamed from: c */
    private int f288c;

    public C0155ar(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.f286a[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            b = (b + this.f286a[i2] + bArr[i2 % bArr.length]) & 255;
            byte b2 = this.f286a[i2];
            this.f286a[i2] = this.f286a[b];
            this.f286a[b] = b2;
        }
        this.f287b = 0;
        this.f288c = 0;
    }

    /* renamed from: a */
    public void mo3014a(byte[] bArr) {
        int i = this.f287b;
        int i2 = this.f288c;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & MotionEventCompat.ACTION_MASK;
            i2 = (i2 + this.f286a[i]) & MotionEventCompat.ACTION_MASK;
            byte b = this.f286a[i];
            this.f286a[i] = this.f286a[i2];
            this.f286a[i2] = b;
            bArr[i3] = (byte) (bArr[i3] ^ this.f286a[(this.f286a[i] + this.f286a[i2]) & MotionEventCompat.ACTION_MASK]);
        }
        this.f287b = i;
        this.f288c = i2;
    }
}
