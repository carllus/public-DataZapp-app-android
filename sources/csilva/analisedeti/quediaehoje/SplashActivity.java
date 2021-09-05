package csilva.analisedeti.quediaehoje;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.widget.TextView;

public class SplashActivity extends Activity {
    TextView txvaviso;

    @SuppressLint({"NewApi"})
    @TargetApi(11)
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(C0345R.layout.activity_splash);
        ConnectivityManager manager = (ConnectivityManager) getSystemService("connectivity");
        boolean isConnectedOrConnecting = manager.getNetworkInfo(0).isConnectedOrConnecting();
        boolean isConnectedOrConnecting2 = manager.getNetworkInfo(1).isConnectedOrConnecting();
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#15A8AB")));
        if (MainActivity.itensdia == null || MainActivity.itensdia_amanha == null || MainActivity.itensdia_d_amanha == null) {
            espera();
        } else {
            redirect();
        }
    }

    public void espera() {
        new Thread() {
            public void run() {
                ClassJSoup jsoup = new ClassJSoup();
                MainActivity.itensdia = jsoup.hoje();
                MainActivity.itensdia_amanha = jsoup.amanha();
                MainActivity.itensdia_d_amanha = jsoup.depois_amanha();
                SplashActivity.this.redirect();
            }
        }.start();
    }

    public void redirect() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
