package com.google.tagmanager;

public interface Logger {

    public enum LogLevel {
        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        NONE
    }

    /* renamed from: d */
    void mo3768d(String str);

    /* renamed from: d */
    void mo3769d(String str, Throwable th);

    /* renamed from: e */
    void mo3770e(String str);

    /* renamed from: e */
    void mo3771e(String str, Throwable th);

    LogLevel getLogLevel();

    /* renamed from: i */
    void mo3773i(String str);

    /* renamed from: i */
    void mo3774i(String str, Throwable th);

    void setLogLevel(LogLevel logLevel);

    /* renamed from: v */
    void mo3776v(String str);

    /* renamed from: v */
    void mo3777v(String str, Throwable th);

    /* renamed from: w */
    void mo3778w(String str);

    /* renamed from: w */
    void mo3779w(String str, Throwable th);
}
