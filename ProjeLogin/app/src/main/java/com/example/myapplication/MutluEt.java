package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MutluEt extends AppCompatActivity {
    int soruno;
    EditText usertext;
    TextView machinetext;
    Button machinebtn1;
    String usertxt;
    TextView oyunadi;
    String username;
    ConstraintLayout mutluet;
    private getResult getResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutluet);
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        Bundle bundle = getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno = Integer.parseInt(bundle.getString("oyunno")) + 1;
        oyunadi = (TextView) findViewById(R.id.oyunAdi);
        oyunadi.setText("Beni Mutlu Et");
        mutluet = findViewById(R.id.mutluetcl);
        username=bundle.getString("username");

        usertext = (EditText) findViewById(R.id.Makineedit);
        machinetext = (TextView) findViewById(R.id.Makinetxt);


        machinebtn1 = (Button) findViewById(R.id.Makinebtn);
        machinebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("");
                getResult = new getResult();
                getResult.execute();
            }
        });
    }
        private class getResult extends AsyncTask<Void, Void, String> {
            String host=getResources().getString(R.string.ipv4);
            String port="5000";
            String number;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                number = usertext.getText().toString();
            }

            @Override
            protected String doInBackground(Void... params) {
                FlaskServer flaskServer = new FlaskServer();
                String url = "http://"+host+":"+port+"/mutluet/"+number;
                String result = flaskServer.getData(url);

                return result;
            }

            @Override
            protected void onPostExecute(String result) {

                String x = "[0]";
                String y = "[1]";
                if(result.equals(x)){
                    result = "Beni Çok Kırdın";
                mutluet.setBackgroundResource(R.drawable.mutsuz);}
                else if(result.equals(y)){
                    result = "İltifatın İçin Teşekkürler";
                mutluet.setBackgroundResource(R.drawable.mutlu);}
                else {result="Servis Kullanım Dışı";}
                machinetext.setText(result);
            }
        }

    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Menüye dönmek istediğinizden emin misiniz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                Intent intent=new Intent(MutluEt.this, GamesList.class);
                intent.putExtra("username",username);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca yapılacak işmeleri yazınız
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
