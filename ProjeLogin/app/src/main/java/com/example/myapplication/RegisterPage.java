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
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterPage extends AppCompatActivity {

    private Toolbar mtoolbar;
    Button kayitol;
    EditText username;
    TextView kyttxt;
    EditText email;
    EditText password1;
    static ProgressDialog prog;
    EditText password2;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        LoginPage.prog.dismiss();
        mtoolbar= findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Kayıt Ol");
        prog=new ProgressDialog(this);
        final Database db=new Database(RegisterPage.this);

        final EditText user=(EditText)findViewById(R.id.kullaniciadiedittxt);
        final EditText passw=(EditText)findViewById(R.id.sifreedittxt);
        final EditText e_mail=(EditText)findViewById(R.id.emailedittxt);
        kyttxt=findViewById(R.id.kayioltxt);
        ScaleTouchListener.Config config = new ScaleTouchListener.Config(
                100,    // Duration
                0.9f,  // ScaleDown
                0.8f); // Alpha

        kyttxt.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                prog.setMessage("Giriş Sayfası Açılıyor...");
                prog.setCanceledOnTouchOutside(false);
                prog.show();
                Intent intent=new Intent(RegisterPage.this,LoginPage.class);
                startActivity(intent);
                finish();
            }
        });

        username=(EditText)findViewById(R.id.kullaniciadiedittxt);
        email=(EditText)findViewById(R.id.emailedittxt);
        password1=(EditText)findViewById(R.id.sifreedittxt);
        password2=(EditText)findViewById(R.id.sifretekraredittxt);

        final Users User=new Users();

        kayitol=(Button)findViewById(R.id.kytolbtn);



        kayitol.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                String usernm=user.getText().toString();
                String userpassw=passw.getText().toString();
                String useremail=e_mail.getText().toString();

                if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("true")){
                    User.setUsername(db.VeriEkle(usernm,userpassw,useremail));
                    if(username.getText().toString().equalsIgnoreCase(""))
                    {
                        username.setError("Lütfen Alanı Doldurunuz!");
                        if(password1.getText().toString().equalsIgnoreCase(""))
                        {
                            password1.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(password1.getText().toString().equalsIgnoreCase("")&&password2.getText().toString().equalsIgnoreCase("")&&username.getText().toString().equalsIgnoreCase("")&&email.getText().toString().equalsIgnoreCase("")){
                        password1.setError("Lütfen Alanı Doldurunuz!");
                        email.setError("Lütfen Alanı DOldurunuz!");
                        password2.setError("Lütfen Alanı Doldurunuz!");
                        username.setError("Lütfen Alanı Doldurunuz!");
                    }
                    else if(password1.getText().toString().equalsIgnoreCase(""))
                    {
                        password1.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(email.getText().toString().equalsIgnoreCase(""))
                    {
                        email.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password2.getText().toString().equalsIgnoreCase("")){
                                password2.setError("Lütfen Alanı Doldurunuz!");
                                if(password1.getText().toString().equalsIgnoreCase("")){
                                    password1.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else if(password2.getText().toString().equalsIgnoreCase(""))
                    {
                        password2.setError("Lütfen Alanı Doldurunuz!");
                        if(username.getText().toString().equalsIgnoreCase(""))
                        {
                            username.setError("Lütfen Alanı Doldurunuz!");
                            if(password1.getText().toString().equalsIgnoreCase("")){
                                password1.setError("Lütfen Alanı Doldurunuz!");
                                if(email.getText().toString().equalsIgnoreCase("")){
                                    email.setError("Lütfen Alanı DOldurunuz!");
                                }
                            }
                        }
                    }
                    else{
                        if(password1.getText().toString().equalsIgnoreCase(password2.getText().toString()))
                        {
                            prog.setMessage("Giriş Sayfasına Yönlendiriliyorsunuz...");
                            prog.setCanceledOnTouchOutside(false);
                            String username=user.getText().toString();
                            String password=passw.getText().toString();
                            String email=e_mail.getText().toString();

                            Intent login=new Intent(RegisterPage.this, LoginPage.class);
                            login.putExtra("usernamekayit",username);
                            login.putExtra("passwordkyt",password);

                            db.VeriEkle(user.getText().toString(),passw.getText().toString(),e_mail.getText().toString());
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this);
                            builder.setMessage("Başarıyla Kayıt Oldunuz!");
                            builder.setNegativeButton("Giriş Yap", null);
                            builder.show();
                            prog.show();
                            startActivity(login);
                            finish();
                        }
                        else
                        {
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterPage.this);
                            builder.setMessage("Şifreler Uyuşmuyor!");
                            builder.setNegativeButton("Tamam", null);
                            builder.show();                        }
                }

                }
                else if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("false")){
                    user.setError("Kullanıcı Adı Alınmış!");
                    e_mail.setError("E-Mail Alınmış!");
                }
                else if(db.UserRegisterCheck(usernm,useremail).equalsIgnoreCase("usernamealinmis")){
                    user.setError("Kullanıcı Adı Alınmış!");
                }
                else {
                    e_mail.setError("E-Mail Alınmış!");
                }
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
        {final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Uygulamadan Çıkmak Üzeresiniz!");
            builder.setPositiveButton("Çıkış Yap", new DialogInterface.OnClickListener() {
                @Override            public void onClick(DialogInterface dialog, int which) {
                    // Evet'e basılınca yapılacak işlemleri yazınız
                    prog.setMessage("Uygulamadan Çıkış Yapılıyor...");
                    prog.setCanceledOnTouchOutside(false);
                    prog.show();
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
        prog.setMessage("Giriş Sayfasına Dönüyorsunuz...");
        prog.setCanceledOnTouchOutside(false);
        prog.show();
        Intent intent=new Intent(RegisterPage.this,LoginPage.class);
        startActivity(intent);
        finish();
    }
}
