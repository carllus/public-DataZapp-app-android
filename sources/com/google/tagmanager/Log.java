package com.google.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.tagmanager.Logger;

final class Log {
    @VisibleForTesting
    static Logger sLogger = new DefaultLogger();

    Log() {
    }

    public static void setLogger(Logger logger) {
        if (logger == null) {
            sLogger = new NoOpLogger();
        } else {
            sLogger = logger;
        }
    }

    public static Logger getLogger() {
        if (sLogger.getClass() == NoOpLogger.class) {
            return null;
        }
        return sLogger;
    }

    /* renamed from: e */
    public static void m542e(String message) {
        sLogger.mo3770e(message);
    }

    /* renamed from: e */
    public static void m543e(String message, Throwable t) {
        sLogger.mo3771e(message, t);
    }

    /* renamed from: w */
    public static void m548w(String message) {
        sLogger.mo3778w(message);
    }

    /* renamed from: w */
    public static void m549w(String message, Throwable t) {
        sLogger.mo3779w(message, t);
    }

    /* renamed from: i */
    public static void m544i(String message) {
        sLogger.mo3773i(message);
    }

    /* renamed from: i */
    public static void m545i(String message, Throwable t) {
        sLogger.mo3774i(message, t);
    }

    /* renamed from: d */
    public static void m540d(String message) {
        sLogger.mo3768d(message);
    }

    /* renamed from: d */
    public static void m541d(String message, Throwable t) {
        sLogger.mo3769d(message, t);
    }

    /* renamed from: v */
    public static void m546v(String message) {
        sLogger.mo3776v(message);
    }

    /* renamed from: v */
    public static void m547v(String message, Throwable t) {
        sLogger.mo3777v(message, t);
    }

    public static Logger.LogLevel getLogLevel() {
        return sLogger.getLogLevel();
    }
}
