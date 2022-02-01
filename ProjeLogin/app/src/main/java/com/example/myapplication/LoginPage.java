package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import libs.mjn.scaletouchlistener.ScaleTouchListener;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity
{
    private Toolbar mtoolbar;
    EditText username;
    EditText password;
    Button grsBtn;
    static ProgressDialog prog;
    TextView kytBtn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        mtoolbar= findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Giriş");
        try{
//Hata oluşması beklenen kod bloğu
            if(GamesList.regprog.isShowing())
                GamesList.regprog.dismiss();
            if(GameInfo.regprog.isShowing())
                GameInfo.regprog.dismiss();
            if(RegisterPage.prog.isShowing())
                RegisterPage.prog.dismiss();
        }
        catch(Exception e){
// Bu hatanın yönetilmesi için gerekli kod bloğu
        }


        final Users user=new Users();

        final Database db=new Database(LoginPage.this);
        user.setUsername(db.VeriEkle("Admin","admin","admin@gmail.com"));

        final EditText editusername=(EditText)findViewById(R.id.lgnkullanicitxt);
        final EditText editpassword=(EditText)findViewById(R.id.lgnsifretxt);

        username=(EditText)findViewById(R.id.lgnkullanicitxt);
        password=(EditText)findViewById(R.id.lgnsifretxt);
        grsBtn =(Button)findViewById(R.id.grsbtn);
        kytBtn=findViewById(R.id.kytactivitybtn);
        prog=new ProgressDialog(LoginPage.this);

        ScaleTouchListener.Config config = new ScaleTouchListener.Config(
                100,    // Duration
                0.9f,  // ScaleDown
                0.8f); // Alpha

        grsBtn.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {

                String usernametxt=editusername.getText().toString();
                String passwordtxt=editpassword.getText().toString();

                int verikontrol=0;

                if(db.UsersCheck(usernametxt,passwordtxt).equalsIgnoreCase("null")){
                    verikontrol=0;
                }
                else
                    verikontrol=1;

                if(verikontrol==1) {
                    prog.setMessage("Hesabınız Açılıyor...");
                    prog.setCanceledOnTouchOutside(false);
                    prog.show();
                    String usernm=editusername.getText().toString();
                    String pass=editpassword.getText().toString();
                    editusername.setText("");
                    editpassword.setText("");
                    Intent degisken=new Intent(LoginPage.this, GamesList.class);
                    degisken.putExtra("username",usernm);
                    degisken.putExtra("password",pass);

                    startActivity(degisken);
                    finish();
                }
                else if(username.getText().toString().equalsIgnoreCase(""))
                {
                    username.setError("Lütfen Alanı Doldurunuz!");
                    if(password.getText().toString().equalsIgnoreCase(""))
                    {
                        password.setError("Lütfen Alanı Doldurunuz!");
                    }
                }
                else if(password.getText().toString().equalsIgnoreCase(""))
                {
                    password.setError("Lütfen Alanı Doldurunuz!");
                    if(username.getText().toString().equalsIgnoreCase("")) {
                        username.setError("Lütfen Alanı Doldurunuz!");
                    }
                }
                else
                {
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginPage.this);
                    builder.setMessage("Yanlış Kullanıcı Adı veya Şifre!");
                    builder.setNegativeButton("Tamam", null);
                    builder.show();
                }
            }
        });
        kytBtn.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {prog.setMessage("Kayıt Sayfası Açılıyor...");
                prog.setCanceledOnTouchOutside(false);
                prog.show();
                Intent kayit=new Intent(LoginPage.this, RegisterPage.class);
                startActivity(kayit);
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
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.exittoolbar)
        {prog.setMessage("Uygulamadan Çıkılıyor...");
        prog.setCanceledOnTouchOutside(false);
        prog.show();
            finish();System.exit(0);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Çıkmak istediğinize emin misiniz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemleri yazınız
                prog.setMessage("Uygulamadan Çıkılıyor...");
                prog.setCanceledOnTouchOutside(false);
                prog.show();
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
