package csilva.analisedeti.quediaehoje;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.IBinder;

public class service extends Service {
    String ano;

    /* renamed from: db */
    SQLiteDatabase f727db;
    String dia;
    String mes;

    public void onCreate() {
        super.onCreate();
        iniciar();
        tread();
    }

    /* access modifiers changed from: package-private */
    public void iniciar() {
        this.f727db = openOrCreateDatabase("db_datazapp", 0, (SQLiteDatabase.CursorFactory) null);
        this.f727db.execSQL("CREATE TABLE IF NOT EXISTS data(dia VARCHAR, mes VARCHAR, ano VARCHAR);");
        this.f727db.execSQL("DELETE FROM data");
        ClassJSoup data = new ClassJSoup();
        this.f727db.execSQL("INSERT INTO data VALUES('" + data.dia() + "','" + data.mes() + "','" + data.ano() + "');");
    }

    /* access modifiers changed from: package-private */
    public void verifica_data() {
        this.f727db = openOrCreateDatabase("db_datazapp", 0, (SQLiteDatabase.CursorFactory) null);
        this.f727db.execSQL("CREATE TABLE IF NOT EXISTS data(dia VARCHAR, mes VARCHAR, ano VARCHAR);");
        Cursor c = this.f727db.rawQuery("SELECT * FROM data", (String[]) null);
        if (c.moveToFirst()) {
            this.dia = c.getString(0);
            this.mes = c.getString(1);
            this.ano = c.getString(2);
            return;
        }
        this.dia = "";
        this.mes = "";
        this.ano = "";
    }

    /* access modifiers changed from: package-private */
    public void notification() {
        NotificationManager mgr = (NotificationManager) getSystemService("notification");
        try {
            mgr.cancel(1337);
        } catch (Exception e) {
        }
        Notification note = new Notification(C0345R.C0346drawable.ic_launcher, String.valueOf(MainActivity.itensdia.get(0).getData()) + " - " + MainActivity.itensdia.get(0).getNome(), System.currentTimeMillis());
        note.setLatestEventInfo(getBaseContext(), String.valueOf(MainActivity.itensdia.get(0).getData()) + " - " + MainActivity.itensdia.get(0).getNome(), "DataZapp - Conheça outras datas históricas de hoje...", PendingIntent.getActivity(getBaseContext(), 0, new Intent(getBaseContext(), SplashActivity.class), 0));
        mgr.notify(1337, note);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return 1;
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public void tread() {
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        service.this.verifica_data();
                        ClassJSoup data = new ClassJSoup();
                        if (Integer.parseInt(service.this.ano) < Integer.parseInt(data.ano())) {
                            service.this.pega_novas_datas();
                            service.this.iniciar();
                            Thread.sleep(5000);
                            service.this.notification();
                        } else if (Integer.parseInt(service.this.mes) < Integer.parseInt(data.mes())) {
                            service.this.pega_novas_datas();
                            service.this.iniciar();
                            Thread.sleep(5000);
                            service.this.notification();
                        } else if (Integer.parseInt(service.this.dia) < Integer.parseInt(data.dia())) {
                            service.this.pega_novas_datas();
                            service.this.iniciar();
                            Thread.sleep(5000);
                            service.this.notification();
                        }
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void pega_novas_datas() {
        new Thread() {
            public void run() {
                ClassJSoup jsoup = new ClassJSoup();
                MainActivity.itensdia = jsoup.hoje();
                MainActivity.itensdia_amanha = jsoup.amanha();
                MainActivity.itensdia_d_amanha = jsoup.depois_amanha();
            }
        }.start();
    }
}
