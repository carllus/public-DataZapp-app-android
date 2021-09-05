package com.google.tagmanager;

import com.google.tagmanager.Logger;

class NoOpLogger implements Logger {
    NoOpLogger() {
    }

    /* renamed from: e */
    public void mo3770e(String message) {
    }

    /* renamed from: e */
    public void mo3771e(String message, Throwable t) {
    }

    /* renamed from: w */
    public void mo3778w(String message) {
    }

    /* renamed from: w */
    public void mo3779w(String message, Throwable t) {
    }

    /* renamed from: i */
    public void mo3773i(String message) {
    }

    /* renamed from: i */
    public void mo3774i(String message, Throwable t) {
    }

    /* renamed from: d */
    public void mo3768d(String message) {
    }

    /* renamed from: d */
    public void mo3769d(String message, Throwable t) {
    }

    /* renamed from: v */
    public void mo3776v(String message) {
    }

    /* renamed from: v */
    public void mo3777v(String message, Throwable t) {
    }

    public Logger.LogLevel getLogLevel() {
        return Logger.LogLevel.NONE;
    }

    public void setLogLevel(Logger.LogLevel logLevel) {
    }
}
