package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* renamed from: com.google.ads.b */
public class C0163b {

    /* renamed from: c */
    private static C0163b f304c = null;

    /* renamed from: a */
    private final BigInteger f305a = m134d();

    /* renamed from: b */
    private BigInteger f306b = BigInteger.ONE;

    /* renamed from: a */
    public static synchronized C0163b m132a() {
        C0163b bVar;
        synchronized (C0163b.class) {
            if (f304c == null) {
                f304c = new C0163b();
            }
            bVar = f304c;
        }
        return bVar;
    }

    /* renamed from: b */
    public synchronized BigInteger mo3029b() {
        return this.f305a;
    }

    /* renamed from: c */
    public synchronized BigInteger mo3030c() {
        BigInteger bigInteger;
        bigInteger = this.f306b;
        this.f306b = this.f306b.add(BigInteger.ONE);
        return bigInteger;
    }

    private C0163b() {
    }

    /* renamed from: d */
    private static BigInteger m134d() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            UUID randomUUID = UUID.randomUUID();
            instance.update(m133a(randomUUID.getLeastSignificantBits()));
            instance.update(m133a(randomUUID.getMostSignificantBits()));
            byte[] bArr = new byte[9];
            bArr[0] = 0;
            System.arraycopy(instance.digest(), 0, bArr, 1, 8);
            return new BigInteger(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
    }

    /* renamed from: a */
    private static byte[] m133a(long j) {
        return BigInteger.valueOf(j).toByteArray();
    }
}
