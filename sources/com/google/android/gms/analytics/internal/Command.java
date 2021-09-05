package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;

public class Command implements Parcelable {
    public static final String APPEND_CACHE_BUSTER = "appendCacheBuster";
    public static final String APPEND_QUEUE_TIME = "appendQueueTime";
    public static final String APPEND_VERSION = "appendVersion";
    public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator<Command>() {
        public Command createFromParcel(Parcel in) {
            return new Command(in);
        }

        public Command[] newArray(int size) {
            return new Command[size];
        }
    };

    /* renamed from: id */
    private String f683id;
    private String urlParam;
    private String value;

    public Command(String id, String urlParam2, String value2) {
        this.f683id = id;
        this.urlParam = urlParam2;
        this.value = value2;
    }

    public String getId() {
        return this.f683id;
    }

    public String getUrlParam() {
        return this.urlParam;
    }

    public String getValue() {
        return this.value;
    }

    public Command() {
    }

    Command(Parcel in) {
        readFromParcel(in);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.f683id);
        out.writeString(this.urlParam);
        out.writeString(this.value);
    }

    private void readFromParcel(Parcel in) {
        this.f683id = in.readString();
        this.urlParam = in.readString();
        this.value = in.readString();
    }
}
