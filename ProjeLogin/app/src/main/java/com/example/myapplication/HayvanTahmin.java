package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class HayvanTahmin extends AppCompatActivity {
    int soruno;
    TextView machinetext;
    ImageButton button;
    String username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hayvanlar);
        Bundle bundle=getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno=Integer.parseInt(bundle.getString("oyunno"))+1;
        TextView oyunadi=(TextView)findViewById(R.id.oyunAdi);
        oyunadi.setText("Hayvan Tahmin");
        machinetext=(TextView)findViewById(R.id.Makinetxt);

        button=(ImageButton)findViewById(R.id.geyikbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin hayvan Geyik!!");
            }
        });
        button=(ImageButton)findViewById(R.id.sincapbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin hayvan Sincap!!");
            }
        });
        button=(ImageButton)findViewById(R.id.kirpibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin hayvan Kirpi!!");
            }
        });
        button=(ImageButton)findViewById(R.id.kartalbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin hayvan Kartal!!");
            }
        });
        button=(ImageButton)findViewById(R.id.tilkibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                machinetext.setText("Seçtiğin hayvan Tilki!!");
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
                Intent intent=new Intent(HayvanTahmin.this, GamesList.class);
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
