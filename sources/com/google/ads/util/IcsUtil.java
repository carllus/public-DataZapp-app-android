package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient;
import com.google.ads.AdSize;
import com.google.ads.C0228n;
import com.google.ads.internal.AdWebView;
import com.google.ads.util.C0249g;

@TargetApi(14)
public class IcsUtil {

    /* renamed from: com.google.ads.util.IcsUtil$a */
    public static class C0237a extends C0249g.C0251a {
        public C0237a(C0228n nVar) {
            super(nVar);
        }

        public void onShowCustomView(View view, int requestedOrientation, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }
    }

    public static class IcsAdWebView extends AdWebView {
        public IcsAdWebView(C0228n slotState, AdSize adSize) {
            super(slotState, adSize);
        }

        public boolean canScrollHorizontally(int direction) {
            if (this.f394a.f586e.mo3394a() != null) {
                return !this.f394a.f586e.mo3394a().mo3097b();
            }
            return super.canScrollHorizontally(direction);
        }

        public boolean canScrollVertically(int direction) {
            if (this.f394a.f586e.mo3394a() != null) {
                return !this.f394a.f586e.mo3394a().mo3097b();
            }
            return super.canScrollVertically(direction);
        }
    }
}
