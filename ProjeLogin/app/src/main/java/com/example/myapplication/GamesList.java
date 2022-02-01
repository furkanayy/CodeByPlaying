package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GamesList extends AppCompatActivity {

    Toolbar mtoolbar;
    static ProgressDialog regprog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameslist);

        Bundle bundle=getIntent().getExtras();
        String username=bundle.getString("username");
        TextView textViewusername=(TextView)findViewById(R.id.kullaniciaditut);
        textViewusername.setText(username);
        regprog=new ProgressDialog(this);
        try {
            if(BuildCode.prog.isShowing())BuildCode.prog.dismiss();
        }catch (Exception e){
        }
        mtoolbar= findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle(username);

        View.OnClickListener clickListener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId()==R.id.mutluetbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun1adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.akillisinifbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun2adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.mansetbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun3adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.sapkabtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun4adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.turistbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun5adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.hayvanbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun6adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.filmbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun7adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.tkmbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun8adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.pandabtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun9adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
                if(v.getId()==R.id.bukalemunbtn){
                    final TextView editText=(TextView) findViewById(R.id.oyun10adi);
                    final TextView usern=(TextView) findViewById(R.id.kullaniciaditut);
                    String gamename=editText.getText().toString();
                    String usernm=usern.getText().toString();
                    Intent gameinfo=new Intent(GamesList.this,GameInfo.class);
                    gameinfo.putExtra("message",gamename);
                    gameinfo.putExtra("username",usernm);
                    startActivity(gameinfo);finish();
                }
            }
        };
        Button mutluet=findViewById(R.id.mutluetbtn);Button akillisnf=findViewById(R.id.akillisinifbtn);Button manset=findViewById(R.id.mansetbtn);Button sapka=findViewById(R.id.sapkabtn);Button turist=findViewById(R.id.turistbtn);Button hayvan=findViewById(R.id.hayvanbtn);Button film=findViewById(R.id.filmbtn);Button tkm=findViewById(R.id.tkmbtn);Button panda=findViewById(R.id.pandabtn);Button bukalemun=findViewById(R.id.bukalemunbtn);
        mutluet.setOnClickListener(clickListener);akillisnf.setOnClickListener(clickListener);manset.setOnClickListener(clickListener);sapka.setOnClickListener(clickListener);turist.setOnClickListener(clickListener);hayvan.setOnClickListener(clickListener);film.setOnClickListener(clickListener);tkm.setOnClickListener(clickListener);panda.setOnClickListener(clickListener);bukalemun.setOnClickListener(clickListener);
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
                    Intent intent=new Intent(GamesList.this,LoginPage.class);
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Hesabınızdan çıkış yapmak istiyor musunuz?");
        builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                Intent intent=new Intent(GamesList.this, LoginPage.class);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("Hayır", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca yapılacak işmeleri yazınız
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
