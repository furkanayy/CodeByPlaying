package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import libs.mjn.scaletouchlistener.ScaleTouchListener;

public class GameInfo extends AppCompatActivity {

    String usernm;
    int oyunno=0;
    TextView oyunbilgisi;
    static ProgressDialog regprog;
    String[] oyunbilgileri;
    Button oynabtn;private androidx.appcompat.widget.Toolbar mtoolbar;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameinfo);
        oynabtn=(Button)findViewById(R.id.Oynabtn);
        regprog=new ProgressDialog(this);
        Bundle bundle = getIntent().getExtras();
        String gamename=bundle.getString("message");
        usernm=bundle.getString("username");
        mtoolbar=findViewById(R.id.mtoolbar);
        oyunbilgisi=findViewById(R.id.oyunbilgisitxt);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle(usernm);
        oyunbilgileri=new String[10];oyunbilgisigir();
        TextView gamenametxt=findViewById(R.id.gamenametxt);
        gamenametxt.setText(gamename);
        if(gamename.equalsIgnoreCase("Beni Mutlu Et")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.mutluetkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.mutluetkapak2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.mutluetkapak3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.mutluetkapak4);
            oyunbilgisi.setText(oyunbilgileri[0]);
            oyunno=1;
        }
        if(gamename.equalsIgnoreCase("Akıllı Aletler")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.akillisinifkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.akillisinifkapak2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.akillisinifkapak3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.akillisinifkapak4);
            oyunbilgisi.setText(oyunbilgileri[1]);
            oyunno=2;
        }
        if(gamename.equalsIgnoreCase("Gazete Manşetlerini Sen Belirle")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.mansetkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.mansetkapak2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.mansetkapak3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.mansetkapak4);
            oyunbilgisi.setText(oyunbilgileri[2]);
            oyunno=3;
        }
        if(gamename.equalsIgnoreCase("Seçmen Şapka Güven")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.sapkakapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.sapkakapak2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.sapkakapak3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.sapkakapak4);
            oyunbilgisi.setText(oyunbilgileri[3]);
            oyunno=4;
        }
        if(gamename.equalsIgnoreCase("Nereye Gitsek?")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.turistkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.turistkapak2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.turistkapak3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.turistkapak4);
            oyunbilgisi.setText(oyunbilgileri[4]);
            oyunno=5;
        }
        if(gamename.equalsIgnoreCase("Ben Hangi Hayvanım?")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.hayvankapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.hayvanlar2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.hayvanlar3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.hayvanlar4);
            oyunbilgisi.setText(oyunbilgileri[5]);
            oyunno=6;
        }
        if(gamename.equalsIgnoreCase("Film Türünü Tahmin Et")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.filmkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.film);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.film3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.film4);
            oyunbilgisi.setText(oyunbilgileri[6]);
            oyunno=7;
        }
        if(gamename.equalsIgnoreCase("Taş Kağıt Makas")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.tkmkapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.tkmm);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.taskagitmakas3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.taskagitmakas4);
            oyunbilgisi.setText(oyunbilgileri[7]);
            oyunno=8;
        }
        if(gamename.equalsIgnoreCase("Utangaç Panda")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.pandakapak);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.panda3);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.panda2);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.panda1);
            oyunbilgisi.setText(oyunbilgileri[8]);
            oyunno=9;
        }
        if(gamename.equalsIgnoreCase("Bukalemun")) {
            ImageView i = (ImageView) findViewById(R.id.oyunresmi1);
            i.setImageResource(R.drawable.bukalemun1);
            ImageView i2 = (ImageView) findViewById(R.id.oyunresmi2);
            i2.setImageResource(R.drawable.bukalemun2);
            ImageView i3 = (ImageView) findViewById(R.id.oyunresmi3);
            i3.setImageResource(R.drawable.bukalemun3);
            ImageView i4 = (ImageView) findViewById(R.id.oyunresmi4);
            i4.setImageResource(R.drawable.bukemun4);
            oyunbilgisi.setText(oyunbilgileri[9]);
            oyunno=10;
        }
        ScaleTouchListener.Config config = new ScaleTouchListener.Config(
                100,    // Duration
                0.9f,  // ScaleDown
                0.8f); // Alpha
        oynabtn.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                regprog.setMessage("Oyununuz Açılıyor...");
                regprog.setCanceledOnTouchOutside(false);
                regprog.show();
                Intent intent=new Intent(GameInfo.this, BuildCode.class);
                intent.putExtra("oyunno",""+oyunno);
                intent.putExtra("username",usernm);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exit, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exittoolbar) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Hesabınızdan Çıkmak Üzeresiniz!");
            builder.setPositiveButton("Çıkış Yap", new DialogInterface.OnClickListener() {
                @Override            public void onClick(DialogInterface dialog, int which) {
                    // Evet'e basılınca yapılacak işlemleri yazınız
                    regprog.setMessage("Hesabınızdan Çıkış Yapılıyor...");
                    regprog.setCanceledOnTouchOutside(false);
                    regprog.show();
                    Intent intent=new Intent(GameInfo.this,LoginPage.class);
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("İptal Et", new DialogInterface.OnClickListener() {
                @Override            public void onClick(DialogInterface dialog, int which) {
                    // Hayır'a baslınca yapılacak işmeleri yazınız
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);

                // Evet'e basılınca yapılacak işlemler
                Intent intent=new Intent(GameInfo.this, GamesList.class);
                intent.putExtra("username",usernm);
                startActivity(intent);
                finish();
    }
    public void oyunbilgisigir(){
        oyunbilgileri[0]="asdasdasd";
        oyunbilgileri[1]="asdasd";
        oyunbilgileri[2]="asdasd";
        oyunbilgileri[3]="asdasd";
        oyunbilgileri[4]="aasdqweqw";
        oyunbilgileri[5]="qweqwe";
        oyunbilgileri[6]="qweqwe";
        oyunbilgileri[7]="qweqwe";
        oyunbilgileri[8]="qweqw";
        oyunbilgileri[9]="qweqwe";
    }
}
