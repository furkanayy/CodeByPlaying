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

public class TuristTahmin extends AppCompatActivity {
    int soruno;
    EditText usertext;
    TextView machinetext;
    Button machinebtn;
    String usertxt;
    String username;
    LinearLayout turist;
    private getResult getResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turist);
        Bundle bundle=getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno=Integer.parseInt(bundle.getString("oyunno"))+1;
        TextView oyunadi=(TextView)findViewById(R.id.oyunAdi);
        oyunadi.setText("Nereye Gidelim?");
        username=bundle.getString("username");

        usertext=(EditText)findViewById(R.id.Makineedit);
        machinetext=(TextView)findViewById(R.id.Makinetxt);
        turist = findViewById(R.id.turistll);

        machinebtn=(Button)findViewById(R.id.Makinebtn);
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
            String url = "http://"+host+":"+port+"/turist/"+number;
            String result = flaskServer.getData(url);

            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            String x = "[1]";
            String y = "[2]";
            String z = "[3]";
            String k = "[4]";
            String l = "[5]";
            if(result.equals(x)){
                result = "Tiyatro sana en uygun yer";
                turist.setBackgroundResource(R.drawable.tiyatro);}
            else if(result.equals(y)){
                result = "Bence hava tam müze gezmelik";
                turist.setBackgroundResource(R.drawable.muze);}
            else if(result.equals(z)){
                result = "İçimizde ki çocuğu eğlendirelim mi?";
                turist.setBackgroundResource(R.drawable.lunapark);}
            else if(result.equals(k)){
                result = "Sende biraz entel tipi var";
                turist.setBackgroundResource(R.drawable.sanatgalerisi);}
            else if(result.equals(l)){
                result = "Hadi biraz para harcayalım";
                turist.setBackgroundResource(R.drawable.avm);}
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
                Intent intent=new Intent(TuristTahmin.this, GamesList.class);
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
