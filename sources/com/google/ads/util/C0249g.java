package com.google.ads.util;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.support.p000v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.AdActivity;
import com.google.ads.C0221m;
import com.google.ads.C0228n;
import com.google.ads.C0229o;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0194c;
import com.google.ads.internal.C0203d;
import com.google.ads.internal.C0210i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@TargetApi(11)
/* renamed from: com.google.ads.util.g */
public class C0249g {

    /* renamed from: com.google.ads.util.g$b */
    public static class C0258b extends C0210i {
        public C0258b(C0203d dVar, Map<String, C0229o> map, boolean z, boolean z2) {
            super(dVar, map, z, z2);
        }

        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            try {
                if ("mraid.js".equalsIgnoreCase(new File(url).getName())) {
                    C0194c k = this.f517a.mo3221k();
                    if (k != null) {
                        k.mo3173c(true);
                    } else {
                        this.f517a.mo3206a(true);
                    }
                    C0221m.C0222a a = this.f517a.mo3219i().f585d.mo3394a().f544b.mo3394a();
                    if (this.f517a.mo3219i().mo3353b()) {
                        String a2 = a.f552g.mo3395a();
                        C0240b.m480a("shouldInterceptRequest(" + a2 + ")");
                        return m509a(a2, view.getContext());
                    } else if (this.f518b) {
                        String a3 = a.f551f.mo3395a();
                        C0240b.m480a("shouldInterceptRequest(" + a3 + ")");
                        return m509a(a3, view.getContext());
                    } else {
                        String a4 = a.f550e.mo3395a();
                        C0240b.m480a("shouldInterceptRequest(" + a4 + ")");
                        return m509a(a4, view.getContext());
                    }
                }
            } catch (IOException e) {
                C0240b.m489d("IOException fetching MRAID JS.", e);
            } catch (Throwable th) {
                C0240b.m489d("An unknown error occurred fetching MRAID JS.", th);
            }
            return super.shouldInterceptRequest(view, url);
        }

        /* renamed from: a */
        private static WebResourceResponse m509a(String str, Context context) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                AdUtil.m447a(httpURLConnection, context.getApplicationContext());
                httpURLConnection.connect();
                return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(AdUtil.m442a((Readable) new InputStreamReader(httpURLConnection.getInputStream())).getBytes("UTF-8")));
            } finally {
                httpURLConnection.disconnect();
            }
        }
    }

    /* renamed from: com.google.ads.util.g$a */
    public static class C0251a extends WebChromeClient {

        /* renamed from: a */
        private final C0228n f659a;

        public C0251a(C0228n nVar) {
            this.f659a = nVar;
        }

        public void onCloseWindow(WebView webView) {
            if (webView instanceof AdWebView) {
                ((AdWebView) webView).mo3125f();
            }
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
            switch (C02501.f658a[consoleMessage.messageLevel().ordinal()]) {
                case 1:
                    C0240b.m484b(str);
                    break;
                case 2:
                    C0240b.m490e(str);
                    break;
                case 3:
                case 4:
                    C0240b.m486c(str);
                    break;
                case 5:
                    C0240b.m480a(str);
                    break;
            }
            return super.onConsoleMessage(consoleMessage);
        }

        public void onExceededDatabaseQuota(String url, String databaseIdentifier, long currentQuota, long estimatedSize, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            C0221m.C0222a a = this.f659a.f585d.mo3394a().f544b.mo3394a();
            long longValue = a.f557l.mo3395a().longValue() - totalUsedQuota;
            if (longValue <= 0) {
                quotaUpdater.updateQuota(currentQuota);
                return;
            }
            if (currentQuota == 0) {
                if (estimatedSize > longValue || estimatedSize > a.f558m.mo3395a().longValue()) {
                    estimatedSize = 0;
                }
            } else if (estimatedSize == 0) {
                estimatedSize = Math.min(Math.min(a.f559n.mo3395a().longValue(), longValue) + currentQuota, a.f558m.mo3395a().longValue());
            } else {
                if (estimatedSize <= Math.min(a.f558m.mo3395a().longValue() - currentQuota, longValue)) {
                    currentQuota += estimatedSize;
                }
                estimatedSize = currentQuota;
            }
            quotaUpdater.updateQuota(estimatedSize);
        }

        public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsBeforeUnload(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
            return m508a(view, url, message, (String) null, result, (JsPromptResult) null, false);
        }

        public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
            return m508a(view, url, message, defaultValue, (JsResult) null, result, true);
        }

        public void onReachedMaxAppCacheSize(long spaceNeeded, long totalUsedQuota, WebStorage.QuotaUpdater quotaUpdater) {
            C0221m.C0222a a = this.f659a.f585d.mo3394a().f544b.mo3394a();
            long longValue = a.f555j.mo3395a().longValue() + spaceNeeded;
            if (a.f556k.mo3395a().longValue() - totalUsedQuota < longValue) {
                quotaUpdater.updateQuota(0);
            } else {
                quotaUpdater.updateQuota(longValue);
            }
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }

        /* renamed from: a */
        private static boolean m508a(WebView webView, String str, String str2, String str3, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
            AdActivity i;
            if (!(webView instanceof AdWebView) || (i = ((AdWebView) webView).mo3128i()) == null) {
                return false;
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(i);
            builder.setTitle(str);
            if (z) {
                m506a(builder, i, str2, str3, jsPromptResult);
            } else {
                m507a(builder, str2, jsResult);
            }
            return true;
        }

        /* renamed from: a */
        private static void m507a(AlertDialog.Builder builder, String str, final JsResult jsResult) {
            builder.setMessage(str).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    jsResult.confirm();
                }
            }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    jsResult.cancel();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    jsResult.cancel();
                }
            }).create().show();
        }

        /* renamed from: a */
        private static void m506a(AlertDialog.Builder builder, Context context, String str, String str2, final JsPromptResult jsPromptResult) {
            LinearLayout linearLayout = new LinearLayout(context);
            linearLayout.setOrientation(1);
            TextView textView = new TextView(context);
            textView.setText(str);
            final EditText editText = new EditText(context);
            editText.setText(str2);
            linearLayout.addView(textView);
            linearLayout.addView(editText);
            builder.setView(linearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    jsPromptResult.confirm(editText.getText().toString());
                }
            }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    jsPromptResult.cancel();
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    jsPromptResult.cancel();
                }
            }).create().show();
        }
    }

    /* renamed from: com.google.ads.util.g$1 */
    static /* synthetic */ class C02501 {

        /* renamed from: a */
        static final /* synthetic */ int[] f658a = new int[ConsoleMessage.MessageLevel.values().length];

        static {
            try {
                f658a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f658a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f658a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f658a[ConsoleMessage.MessageLevel.TIP.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f658a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* renamed from: a */
    public static void m504a(WebSettings webSettings, C0228n nVar) {
        Context a = nVar.f587f.mo3394a();
        webSettings.setAppCacheEnabled(true);
        webSettings.setAppCacheMaxSize(nVar.f585d.mo3394a().f544b.mo3394a().f554i.mo3395a().longValue());
        webSettings.setAppCachePath(new File(a.getCacheDir(), "admob").getAbsolutePath());
        webSettings.setDatabaseEnabled(true);
        webSettings.setDatabasePath(a.getDatabasePath("admob").getAbsolutePath());
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
    }

    /* renamed from: a */
    public static void m502a(View view) {
        view.setLayerType(1, (Paint) null);
    }

    /* renamed from: b */
    public static void m505b(View view) {
        view.setLayerType(0, (Paint) null);
    }

    /* renamed from: a */
    public static void m503a(Window window) {
        window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
    }
}
