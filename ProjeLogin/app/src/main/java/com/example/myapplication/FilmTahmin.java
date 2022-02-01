package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class FilmTahmin extends AppCompatActivity {
    int soruno;
    EditText usertext;
    TextView machinetext;
    ImageButton button;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);
        Bundle bundle=getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno=Integer.parseInt(bundle.getString("oyunno"))+1;
        TextView oyunadi=(TextView)findViewById(R.id.oyunAdi);
        oyunadi.setText("Film Türü Tahmin");
        username=bundle.getString("username");
        usertext=(EditText)findViewById(R.id.Makineedit);
        machinetext=(TextView)findViewById(R.id.Makinetxt);
        button=(ImageButton)findViewById(R.id.animasyonbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Animasyon!!");
            }
        });
        button=(ImageButton)findViewById(R.id.bilimkurgubtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Bilim Kurgu!!");
            }
        });
        button=(ImageButton)findViewById(R.id.gerilimbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Gerilim!!");
            }
        });
        button=(ImageButton)findViewById(R.id.romantikbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Romantik!!");
            }
        });
        button=(ImageButton)findViewById(R.id.gerilim2btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Gerilim!!");
            }
        });
        button=(ImageButton)findViewById(R.id.korkubtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin filmin türü Korku!!");
            }
        });
    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Menüye dönmek istediğinizden emin misiniz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                Intent intent=new Intent(FilmTahmin.this, GamesList.class);
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
