package com.google.ads.internal;

import android.app.Activity;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.MediaController;
import android.widget.VideoView;
import com.google.ads.C0221m;
import com.google.ads.util.C0240b;
import java.lang.ref.WeakReference;

public class AdVideoView extends FrameLayout implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {

    /* renamed from: b */
    private static final C0188a f386b = C0188a.f402a.mo3153b();

    /* renamed from: a */
    public MediaController f387a = null;

    /* renamed from: c */
    private final WeakReference<Activity> f388c;

    /* renamed from: d */
    private final AdWebView f389d;

    /* renamed from: e */
    private long f390e = 0;

    /* renamed from: f */
    private final VideoView f391f;

    /* renamed from: g */
    private String f392g = null;

    /* renamed from: com.google.ads.internal.AdVideoView$a */
    private static class C0185a implements Runnable {

        /* renamed from: a */
        private final WeakReference<AdVideoView> f393a;

        public C0185a(AdVideoView adVideoView) {
            this.f393a = new WeakReference<>(adVideoView);
        }

        public void run() {
            AdVideoView adVideoView = (AdVideoView) this.f393a.get();
            if (adVideoView == null) {
                C0240b.m488d("The video must be gone, so cancelling the timeupdate task.");
                return;
            }
            adVideoView.mo3115f();
            C0221m.m411a().f545c.mo3394a().postDelayed(this, 250);
        }

        /* renamed from: a */
        public void mo3121a() {
            C0221m.m411a().f545c.mo3394a().postDelayed(this, 250);
        }
    }

    public AdVideoView(Activity adActivity, AdWebView adWebView) {
        super(adActivity);
        this.f388c = new WeakReference<>(adActivity);
        this.f389d = adWebView;
        this.f391f = new VideoView(adActivity);
        addView(this.f391f, new FrameLayout.LayoutParams(-1, -1, 17));
        mo3108a();
        this.f391f.setOnCompletionListener(this);
        this.f391f.setOnPreparedListener(this);
        this.f391f.setOnErrorListener(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3108a() {
        new C0185a(this).mo3121a();
    }

    /* renamed from: b */
    public void mo3111b() {
        if (!TextUtils.isEmpty(this.f392g)) {
            this.f391f.setVideoPath(this.f392g);
        } else {
            f386b.mo3145a(this.f389d, "onVideoEvent", "{'event': 'error', 'what': 'no_src'}");
        }
    }

    public void setMediaControllerEnabled(boolean enabled) {
        Activity activity = (Activity) this.f388c.get();
        if (activity == null) {
            C0240b.m490e("adActivity was null while trying to enable controls on a video.");
        } else if (enabled) {
            if (this.f387a == null) {
                this.f387a = new MediaController(activity);
            }
            this.f391f.setMediaController(this.f387a);
        } else {
            if (this.f387a != null) {
                this.f387a.hide();
            }
            this.f391f.setMediaController((MediaController) null);
        }
    }

    public void setSrc(String src) {
        this.f392g = src;
    }

    public void onCompletion(MediaPlayer mp) {
        f386b.mo3145a(this.f389d, "onVideoEvent", "{'event': 'ended'}");
    }

    public boolean onError(MediaPlayer mp, int what, int extra) {
        C0240b.m490e("Video threw error! <what:" + what + ", extra:" + extra + ">");
        f386b.mo3145a(this.f389d, "onVideoEvent", "{'event': 'error', 'what': '" + what + "', 'extra': '" + extra + "'}");
        return true;
    }

    public void onPrepared(MediaPlayer mp) {
        f386b.mo3145a(this.f389d, "onVideoEvent", "{'event': 'canplaythrough', 'duration': '" + (((float) this.f391f.getDuration()) / 1000.0f) + "'}");
    }

    /* renamed from: c */
    public void mo3112c() {
        this.f391f.pause();
    }

    /* renamed from: d */
    public void mo3113d() {
        this.f391f.start();
    }

    /* renamed from: a */
    public void mo3109a(int i) {
        this.f391f.seekTo(i);
    }

    /* renamed from: a */
    public void mo3110a(MotionEvent motionEvent) {
        this.f391f.onTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public void mo3114e() {
        this.f391f.stopPlayback();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo3115f() {
        long currentPosition = (long) this.f391f.getCurrentPosition();
        if (this.f390e != currentPosition) {
            f386b.mo3145a(this.f389d, "onVideoEvent", "{'event': 'timeupdate', 'time': " + (((float) currentPosition) / 1000.0f) + "}");
            this.f390e = currentPosition;
        }
    }
}
