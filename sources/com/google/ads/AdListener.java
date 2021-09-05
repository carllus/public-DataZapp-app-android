package com.google.ads;

import com.google.ads.AdRequest;

public interface AdListener {
    void onDismissScreen(C0121Ad ad);

    void onFailedToReceiveAd(C0121Ad ad, AdRequest.ErrorCode errorCode);

    void onLeaveApplication(C0121Ad ad);

    void onPresentScreen(C0121Ad ad);

    void onReceiveAd(C0121Ad ad);
}
