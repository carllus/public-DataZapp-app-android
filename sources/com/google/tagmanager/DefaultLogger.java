package com.google.tagmanager;

import android.util.Log;
import com.google.tagmanager.Logger;

class DefaultLogger implements Logger {
    private static final String LOG_TAG = "GoogleTagManager";
    private Logger.LogLevel mLogLevel = Logger.LogLevel.WARNING;

    DefaultLogger() {
    }

    /* renamed from: e */
    public void mo3770e(String message) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            Log.e(LOG_TAG, message);
        }
    }

    /* renamed from: e */
    public void mo3771e(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.ERROR.ordinal()) {
            Log.e(LOG_TAG, message, t);
        }
    }

    /* renamed from: w */
    public void mo3778w(String message) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            Log.w(LOG_TAG, message);
        }
    }

    /* renamed from: w */
    public void mo3779w(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.WARNING.ordinal()) {
            Log.w(LOG_TAG, message, t);
        }
    }

    /* renamed from: i */
    public void mo3773i(String message) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            Log.i(LOG_TAG, message);
        }
    }

    /* renamed from: i */
    public void mo3774i(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.INFO.ordinal()) {
            Log.i(LOG_TAG, message, t);
        }
    }

    /* renamed from: d */
    public void mo3768d(String message) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.DEBUG.ordinal()) {
            Log.d(LOG_TAG, message);
        }
    }

    /* renamed from: d */
    public void mo3769d(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.DEBUG.ordinal()) {
            Log.d(LOG_TAG, message, t);
        }
    }

    /* renamed from: v */
    public void mo3776v(String message) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            Log.v(LOG_TAG, message);
        }
    }

    /* renamed from: v */
    public void mo3777v(String message, Throwable t) {
        if (this.mLogLevel.ordinal() <= Logger.LogLevel.VERBOSE.ordinal()) {
            Log.v(LOG_TAG, message, t);
        }
    }

    public Logger.LogLevel getLogLevel() {
        return this.mLogLevel;
    }

    public void setLogLevel(Logger.LogLevel logLevel) {
        this.mLogLevel = logLevel;
    }
}
