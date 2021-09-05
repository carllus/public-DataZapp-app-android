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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0121Ad;
import com.google.ads.InterstitialAd;
import com.google.analytics.tracking.android.EasyTracker;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"NewApi"})
@TargetApi(11)
public class MainActivity extends Activity implements AdapterView.OnItemClickListener, AdListener {

    /* renamed from: ANÚNCIO_ID  reason: contains not printable characters */
    private static final String f734ANNCIO_ID = "ca-app-pub-3491610413834288/4900950854";
    private static final String INTERCALAR_ID = "ca-app-pub-3491610413834288/6377684059";
    private static AdView adView1;
    static boolean fecha = false;
    static ArrayList<ItemListView> itens;
    static List<ObjectItens> itensdia;
    static List<ObjectItens> itensdia_amanha;
    static List<ObjectItens> itensdia_d_amanha;
    AdapterListView adapterListView;
    private InterstitialAd interstitial;
    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0345R.layout.activity_main);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#15A8AB")));
        this.listView = (ListView) findViewById(C0345R.C0347id.list);
        this.listView.setOnItemClickListener(this);
        itens = new ArrayList<>();
        for (ObjectItens unidade : itensdia) {
            itens.add(new ItemListView(unidade.getNome(), unidade.getData(), unidade.getDescricao(), unidade.getImagem(), unidade.getUrl()));
        }
        for (ObjectItens unidade2 : itensdia_amanha) {
            itens.add(new ItemListView(unidade2.getNome(), unidade2.getData(), unidade2.getDescricao(), unidade2.getImagem(), unidade2.getUrl()));
        }
        for (ObjectItens unidade3 : itensdia_d_amanha) {
            itens.add(new ItemListView(unidade3.getNome(), unidade3.getData(), unidade3.getDescricao(), unidade3.getImagem(), unidade3.getUrl()));
        }
        this.adapterListView = new AdapterListView(this, itens);
        this.listView.setAdapter(this.adapterListView);
        this.listView.setCacheColorHint(0);
        adView1 = new AdView((Activity) this, AdSize.BANNER, f734ANNCIO_ID);
        ((LinearLayout) findViewById(C0345R.C0347id.banner)).addView(adView1);
        adView1.loadAd(new AdRequest());
        this.interstitial = new InterstitialAd(this, INTERCALAR_ID);
        AdRequest adRequest2 = new AdRequest();
        this.interstitial.setAdListener(this);
        this.interstitial.loadAd(adRequest2);
        Intent i = new Intent(this, service.class);
        i.putExtra("ServiceDataZapp", "DataZapp");
        startService(i);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        redirect_detalhes(this.adapterListView.getItem(position));
    }

    public void redirect_detalhes(ItemListView item) {
        DetalhesActivity.item = item;
        startActivity(new Intent(this, DetalhesActivity.class));
        finish();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(C0345R.C0348menu.main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == C0345R.C0347id.compartilhar) {
            shareIt();
            return true;
        } else if (id != C0345R.C0347id.sobrenos) {
            return super.onOptionsItemSelected(item);
        } else {
            Dialog dialog = new Dialog(this);
            dialog.setContentView(C0345R.layout.dialog_quemsomos);
            dialog.setTitle("Sobre nós...");
            dialog.show();
            return true;
        }
    }

    private void shareIt() {
        Intent sharingIntent = new Intent("android.intent.action.SEND");
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra("android.intent.extra.SUBJECT", "Aplicativo 'DataZapp - que dia é hoje?'");
        sharingIntent.putExtra("android.intent.extra.TEXT", "Uso e recomendo o aplicativo DataZapp Android. Baixe na google play! - via aplicativo 'DataZapp - que dia é hoje?'");
        startActivity(Intent.createChooser(sharingIntent, "'Via Aplicativo DataZapp - que dia é hoje?'"));
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
                    if (MainActivity.fecha) {
                        MainActivity.this.finish();
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
        EasyTracker.getInstance(this).activityStart(this);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        EasyTracker.getInstance(this).activityStart(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.interstitial.stopLoading();
        finish();
        super.onDestroy();
    }
}
