package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Bukalemun extends AppCompatActivity {
    int soruno;
    String username;
    Button button;
    Timer t;
    ImageView bukalemun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bukalemun);
        Bundle bundle = getIntent().getExtras();
        //hangi soru olduğunu ve ya hangi oyun olduğunu bu sorunodan anlayacak.
        soruno = Integer.parseInt(bundle.getString("oyunno")) + 1;
        TextView oyunadi = (TextView) findViewById(R.id.oyunAdi);
        oyunadi.setText("Bukalemun");
        username = bundle.getString("username");
        bukalemun = findViewById(R.id.bukalemunimg);
        button=(Button)findViewById(R.id.kirmizibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalemun.setBackgroundColor(Color.parseColor("#651010"));
             //   timer();
                final Handler handler = new Handler();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                bukalemun.setImageResource(R.drawable.kirmizi);
                                t.cancel();
                            }
                        });
                    }
                };
                t =new Timer();
                t.schedule(timerTask,1000,500);

            }
        });
        button=(Button)findViewById(R.id.mavibtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalemun.setBackgroundColor(Color.parseColor("#2E3F9F"));
              //  timer();
                final Handler handler = new Handler();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                bukalemun.setImageResource(R.drawable.mavi);
                                t.cancel();
                            }
                        });
                    }
                };
                t =new Timer();
                t.schedule(timerTask,1000,500);

            }

        });
        button=(Button)findViewById(R.id.pembebtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalemun.setBackgroundColor(Color.parseColor("#901FA3"));
              //  timer();
                final Handler handler = new Handler();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                bukalemun.setImageResource((R.drawable.pembe));
                                t.cancel();
                            }
                        });
                    }
                };
                t =new Timer();
                t.schedule(timerTask,1000,500);

            }
        });
        button=(Button)findViewById(R.id.yesilbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalemun.setBackgroundColor(Color.parseColor("#4CAF50"));
             //   timer();
                final Handler handler = new Handler();
                TimerTask timerTask = new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                bukalemun.setImageResource((R.drawable.yesil));
                                t.cancel();
                            }
                        });
                    }
                };
                t =new Timer();
                t.schedule(timerTask,1000,500);

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
                Intent intent=new Intent(Bukalemun.this, GamesList.class);
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
    public void timer()
    {
        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
