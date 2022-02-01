package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AkilliSinif extends AppCompatActivity {
    int soruno;
    EditText usertext;
    TextView machinetext;
    Button machinebtn;
    String usertxt;
    String username;
    LinearLayout akilliSinif;
    private getResult getResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akillisinif);

        Bundle bundle=getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno=Integer.parseInt(bundle.getString("oyunno"))+1;
        username=bundle.getString("username");
        TextView oyunadi=(TextView)findViewById(R.id.oyunAdi);
        oyunadi.setText("Akıllı Aletler");
        usertext=(EditText)findViewById(R.id.Makineedit);
        machinetext=(TextView)findViewById(R.id.Makinetxt);
        machinebtn=(Button)findViewById(R.id.Makinebtn);
        akilliSinif = findViewById(R.id.akilliSinifll);
        machinebtn.setOnClickListener(new View.OnClickListener() {
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
            String url = "http://"+host+":"+port+"/akillisinif/"+number;
            String result = flaskServer.getData(url);

            return result;
        }

        @Override
        protected void onPostExecute(String result) {

            String x = "[1]";
            String y = "[2]";
            String z = "[3]";
            String k = "[4]";
            if(result.equals(x)){
                akilliSinif.setBackgroundResource(R.drawable.fanacildi);
                result = "Fan Açıldı";
            }
            else if(result.equals(y)){
                akilliSinif.setBackgroundResource(R.drawable.fankapandi);
                result = "Fan Kapandı";}
            else if(result.equals(z)){
                akilliSinif.setBackgroundResource(R.drawable.isikac);
                result = "Işık Açıldı";}
            else if(result.equals(k)){
                akilliSinif.setBackgroundResource(R.drawable.isikkapat);
                result = "Işık Kapandı";}
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
                Intent intent=new Intent(AkilliSinif.this, GamesList.class);
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
