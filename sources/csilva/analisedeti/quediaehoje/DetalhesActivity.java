package csilva.analisedeti.quediaehoje;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0121Ad;
import com.google.ads.InterstitialAd;
import com.google.analytics.tracking.android.EasyTracker;
import com.squareup.picasso.Picasso;

@SuppressLint({"NewApi"})
@TargetApi(11)
public class DetalhesActivity extends Activity implements AdListener {

    /* renamed from: ANÚNCIO_ID  reason: contains not printable characters */
    private static final String f733ANNCIO_ID = "ca-app-pub-3491610413834288/4900950854";
    private static final String INTERCALAR_ID = "ca-app-pub-3491610413834288/6377684059";
    private static AdView adView1;
    static boolean fecha = false;
    static ItemListView item;
    private InterstitialAd interstitial;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0345R.layout.activity_detalhes);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#15A8AB")));
        Picasso.with(this).load(item.getImagem()).into((ImageView) findViewById(C0345R.C0347id.imgDetalhe));
        ((TextView) findViewById(C0345R.C0347id.txvData)).setText(item.getData());
        ((TextView) findViewById(C0345R.C0347id.txvTitulo)).setText(item.getNome());
        ((TextView) findViewById(C0345R.C0347id.txvDescricao)).setText(item.getDescricao());
        ((ImageButton) findViewById(C0345R.C0347id.btnGmail)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetalhesActivity.this.shareIt();
            }
        });
        ((ImageButton) findViewById(C0345R.C0347id.btnMessenger)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetalhesActivity.this.shareIt();
            }
        });
        ((ImageButton) findViewById(C0345R.C0347id.btnHangout)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetalhesActivity.this.shareIt();
            }
        });
        ((ImageButton) findViewById(C0345R.C0347id.btnWhats)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DetalhesActivity.this.shareIt();
            }
        });
        adView1 = new AdView((Activity) this, AdSize.BANNER, f733ANNCIO_ID);
        ((LinearLayout) findViewById(C0345R.C0347id.banner)).addView(adView1);
        adView1.loadAd(new AdRequest());
        this.interstitial = new InterstitialAd(this, INTERCALAR_ID);
        AdRequest adRequest2 = new AdRequest();
        this.interstitial.setAdListener(this);
        this.interstitial.loadAd(adRequest2);
    }

    /* access modifiers changed from: private */
    public void shareIt() {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.SUBJECT", String.valueOf(item.getNome()) + " - 'DataZapp - que dia é hoje?'");
        sharingIntent.putExtra("android.intent.extra.TEXT", String.valueOf(item.getNome()) + " [" + item.getData() + "]" + " - " + item.getDescricao() + " - via aplicativo 'DataZapp - que dia é hoje?'");
        startActivity(Intent.createChooser(sharingIntent, "'Via Aplicativo DataZapp - que dia é hoje?'"));
    }

    public void onBackPressed() {
        finish();
        startActivity(new Intent(this, SplashActivity.class));
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode != 4) {
            return super.onKeyDown(keyCode, event);
        }
        finish();
        startActivity(new Intent(this, SplashActivity.class));
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0345R.C0348menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item2) {
        int id = item2.getItemId();
        if (id == C0345R.C0347id.compartilhar) {
            shareIt();
            return true;
        } else if (id != C0345R.C0347id.sobrenos) {
            return super.onOptionsItemSelected(item2);
        } else {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(C0345R.layout.dialog_quemsomos);
            dialog.setTitle("Sobre nós...");
            dialog.show();
            return true;
        }
    }

    public void onDismissScreen(C0121Ad arg0) {
    }

    public void onFailedToReceiveAd(C0121Ad arg0, AdRequest.ErrorCode arg1) {
    }

    public void onLeaveApplication(C0121Ad arg0) {
    }

    public void onPresentScreen(C0121Ad arg0) {
    }

    public void onReceiveAd(C0121Ad ad) {
        if (ad == this.interstitial) {
            this.interstitial.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        fecha = true;
        super.onStop();
        EasyTracker.getInstance(this).activityStop(this);
        new Thread() {
            public void run() {
                try {
                    Log.e("service", "log");
                    Thread.sleep(30000);
                    if (DetalhesActivity.fecha) {
                        DetalhesActivity.this.finish();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        fecha = false;
        super.onRestart();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.interstitial.stopLoading();
        finish();
        super.onDestroy();
    }
}
