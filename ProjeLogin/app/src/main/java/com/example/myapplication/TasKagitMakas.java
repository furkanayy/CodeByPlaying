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
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class TasKagitMakas extends AppCompatActivity {
    int soruno;
    int randomSayi;
    int bilgisayarDurum;
    int oyuncuDurum;

    EditText usertext;
    TextView machinetext;
    String username;
    ImageButton button;
    ImageView bilgisayar, oyuncu;
    Random random = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taskagitmakas);
        Bundle bundle=getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno=Integer.parseInt(bundle.getString("oyunno"))+1;
        TextView oyunadi=(TextView)findViewById(R.id.oyunAdi);
        oyunadi.setText("Taş Kağıt Makas");
        username=bundle.getString("username");
        usertext=(EditText)findViewById(R.id.Makineedit);
        machinetext=(TextView)findViewById(R.id.Makinetxt);
        bilgisayar = findViewById(R.id.bilgisayarimg);
        oyuncu = findViewById(R.id.oyuncuimg);




        button=(ImageButton)findViewById(R.id.tasbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyuncu.setImageResource(R.drawable.tas);
                oyuncuDurum=1;
                randomTKM();
                kazanmaDurumu();
            }
        });
        button=(ImageButton)findViewById(R.id.kagitbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyuncu.setImageResource(R.drawable.kagit);
                oyuncuDurum=2;
                randomTKM();
                kazanmaDurumu();
            }
        });
        button=(ImageButton)findViewById(R.id.makasbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oyuncu.setImageResource(R.drawable.makas);
                oyuncuDurum=3;
                randomTKM();
                kazanmaDurumu();
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
                Intent intent=new Intent(TasKagitMakas.this, GamesList.class);
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

    public void randomTKM()
    {
        randomSayi = random.nextInt(3);
        if(randomSayi == 1) {
            bilgisayar.setImageResource(R.drawable.tas);
            bilgisayarDurum = 1;        }
        else if(randomSayi == 2) {
            bilgisayar.setImageResource(R.drawable.kagit);
            bilgisayarDurum = 2;        }
        else{
            bilgisayar.setImageResource(R.drawable.makas);
            bilgisayarDurum = 3;}
    }
    public void kazanmaDurumu()
    {
        if(oyuncuDurum==1 && bilgisayarDurum==3)
            machinetext.setText("Sen Kazandın");
        else if(oyuncuDurum==3 && bilgisayarDurum==2)
            machinetext.setText("Sen Kazandın");
        else if(oyuncuDurum==2 && bilgisayarDurum==1)
            machinetext.setText("Sen Kazandın");
        else if(oyuncuDurum==3 && bilgisayarDurum==1)
            machinetext.setText("Bilgisayar Kazandı");
        else if(oyuncuDurum==2 && bilgisayarDurum==3)
            machinetext.setText("Bilgisayar Kazandı");
        else if(oyuncuDurum==1 && bilgisayarDurum==2)
            machinetext.setText("Bilgisayar Kazandı");
        else
            machinetext.setText("Berabere");
      /*  if(oyuncu.equals(R.drawable.tas) && bilgisayar.equals(R.drawable.kagit))
            machinetext.setText("Sen Kazandın");
        else if(oyuncu.equals(R.drawable.kagit) && bilgisayar.equals(R.drawable.tas))
            machinetext.setText("Sen Kazandın");
        else if(oyuncu.equals(R.drawable.tas) && bilgisayar.equals(R.drawable.makas))
            machinetext.setText("Sen Kazandın");
        else if(bilgisayar.equals(R.drawable.tas) && oyuncu.equals(R.drawable.kagit))
            machinetext.setText("Bilgisayar Kazandı");
        else if(bilgisayar.equals(R.drawable.kagit) && oyuncu.equals(R.drawable.tas))
            machinetext.setText("Bilgisayar Kazandı");
        else if(bilgisayar.equals(R.drawable.tas) && oyuncu.equals(R.drawable.makas))
            machinetext.setText("Bilgisayar Kazandı");
        else
            machinetext.setText("Berabere");
       */

    }
}

