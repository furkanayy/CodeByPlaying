package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Random;

public class BuildCode extends AppCompatActivity {
    Random rant=new Random();
    String text=null;
    int dogrukod=rant.nextInt(10);
    final String  karsilastirma[][]=new String[10][2];

    CodeArray sorulars=new CodeArray();
    int oyunNo,i;
    int[] cevaplar = new int[10];
    int kacinci=0;
    TextView kodhavuzu;
    ScrollView kodhavuzuscrl;
    TextView kacincikodda;
    TextView tut;
    TextView sorutxt;
    TextView resimtxt;
    static ProgressDialog prog;
    String username;private Toolbar mtoolbar;
    Button sonrakisorubtn, secenek1, secenek2, secenek3, secenek4, secenek5, secenek6, secenek7, secenek8, secenek9, secenek10;
    String[][] kodhavuzuhint=new String[10][10];


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buildcode);
        mtoolbar= findViewById(R.id.mtoolbar);
        setSupportActionBar(mtoolbar);
        getSupportActionBar().setTitle("Makine Kodlama");
        kacincikodda=(TextView)findViewById(R.id.kacincikodtut);
        kacincikodda.setText(""+kacinci);
        kodhavuzu =(TextView)findViewById(R.id.kodhavuzu);
        kodhavuzuscrl=findViewById(R.id.kodhavuzulinear);
        tut =(TextView)findViewById(R.id.kacincisorutut);
        tut.setText("0");
        prog=new ProgressDialog(this);
        resimtxt=(TextView)findViewById(R.id.resimtxt);
        Bundle bundle=getIntent().getExtras();
        oyunNo = Integer.parseInt(bundle.getString("oyunno"))-1;
        username=bundle.getString("username");
        hintyaz();
        //buttonları(şıkları) tanımla-->
        {
            secenek1 = (Button) findViewById(R.id.secenek1);
            secenek2 = (Button) findViewById(R.id.secenek2);
            secenek3 = (Button) findViewById(R.id.secenek3);
            secenek4 = (Button) findViewById(R.id.secenek4);
            secenek5 = (Button) findViewById(R.id.secenek5);
            secenek6 = (Button) findViewById(R.id.secenek6);
            secenek7 = (Button) findViewById(R.id.secenek7);
            secenek8 = (Button) findViewById(R.id.secenek8);
            secenek9 = (Button) findViewById(R.id.secenek9);
            secenek10 = (Button) findViewById(R.id.secenek10);
            sonrakisorubtn = (Button) findViewById(R.id.Bitirbtn);
        }
        GameInfo.regprog.dismiss();
        sorulars.sorulardizi();
        //ilk kod bloğu tamamlandıktan sonra diğer koda geç
        sonrakisorubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //test bitince butona basılırsa uygulamadan çık
                if(oyunNo==0)
                    {Intent intent = new Intent(BuildCode.this, MutluEt.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==1)
                {Intent intent = new Intent(BuildCode.this, AkilliSinif.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==2)
                {Intent intent = new Intent(BuildCode.this, MansetTahmin.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==3)
                {Intent intent = new Intent(BuildCode.this, SapkaTahmin.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==4)
                {Intent intent = new Intent(BuildCode.this, TuristTahmin.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==5)
                {Intent intent = new Intent(BuildCode.this, HayvanTahmin.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==6)
                {Intent intent = new Intent(BuildCode.this, FilmTahmin.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==7)
                {Intent intent = new Intent(BuildCode.this, TasKagitMakas.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==8)
                {Intent intent = new Intent(BuildCode.this, UtangacPanda.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
                else if(oyunNo==9)
                {Intent intent = new Intent(BuildCode.this, Bukalemun.class);
                    intent.putExtra("oyunno",""+ oyunNo);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();}
            }
        });
        //1.sorulaı ve şıkları asıl dizilere aktar
        //karsilastirmaya atama kısmı
        eks(0,10, oyunNo);
        //butonlara değer ata -->
        butonyaz(oyunNo);
        //drag and drop komutları-->
           secenek1.setOnLongClickListener(longClickListener);
            secenek2.setOnLongClickListener(longClickListener);
            secenek3.setOnLongClickListener(longClickListener);
            secenek4.setOnLongClickListener(longClickListener);
            secenek5.setOnLongClickListener(longClickListener);
            secenek6.setOnLongClickListener(longClickListener);
            secenek7.setOnLongClickListener(longClickListener);
            secenek8.setOnLongClickListener(longClickListener);
            secenek9.setOnLongClickListener(longClickListener);
            secenek10.setOnLongClickListener(longClickListener);
            //bu kısım butonlarımızı getirmek istediğimiz kısım-->
            kodhavuzuscrl.setOnDragListener(dragListener);}
            //herhangi bir butonlara tutulma ve hareket ettirme
    View.OnLongClickListener longClickListener=new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData clipData=ClipData.newPlainText("","");
            View.DragShadowBuilder myshadowbuilder= new View.DragShadowBuilder(v);
            v.startDrag(clipData,myshadowbuilder,v,0);
            return true;
        }
    };//LongCLick olduğunda geçekleşecek komutlar
    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {kodhavuzuscrl.fullScroll(ScrollView.FOCUS_DOWN);
            int dragEvent=event.getAction();
            //kacinci soruda olduğumuzu tutan deger
            int kacincisoru=Integer.parseInt(tut.getText().toString());
            int sorusayisi=0;
            final View view=(View) event.getLocalState();
            Button bt=(Button)findViewById(view.getId());
            //mevcut dizimideki soru sayisi bulma
                    for(int i=0;i<10;i++){
                        if(sorulars.Sorular[i][oyunNo]==null||sorulars.Sorular[i][oyunNo].equalsIgnoreCase("TEBRİKLER KODU BAŞARIYLA TAMAMLADINIZ DEVAM ETMEK İÇİN DARWIN'E TIKLAYINIZ.")){
                        }
                        else sorusayisi++;
                    }
            if (kodhavuzu.getText().toString().equalsIgnoreCase("Kodları buraya sürükleyiniz..."))
            text="";
            //ÖNEMSİZ!-->int [ ] ids = {2131230793,2131230795,2131230796,2131230797,2131230798,2131230799,2131230800,2131230801,2131230802,2131230794};
            //dragevent olayları

            switch (dragEvent){
                //buton belirttiğimiz alana sürüklenince
                case DragEvent.ACTION_DRAG_ENTERED:
                    //if(tx2.getText().toString().equalsIgnoreCase("Kodları buraya sürükleyiniz..."))
                    kodhavuzu.setText("Kodu Bırakın");
                    break;
                    //sürükleme olayı bitince
                case DragEvent.ACTION_DRAG_ENDED:
                    if(kacincisoru==sorusayisi||sorutxt.getText().toString().equalsIgnoreCase("TEBRİKLER KODU BAŞARIYLA TAMAMLADINIZ DEVAM ETMEK İÇİN DARWIN'E TIKLAYINIZ.")){
                        resimtxt.setBackgroundResource(R.drawable.dartebrik);
                        secenek1.setVisibility(View.INVISIBLE);
                        secenek2.setVisibility(View.INVISIBLE);
                        secenek3.setVisibility(View.INVISIBLE);
                        secenek4.setVisibility(View.INVISIBLE);
                        secenek5.setVisibility(View.INVISIBLE);
                        secenek6.setVisibility(View.INVISIBLE);
                        secenek7.setVisibility(View.INVISIBLE);
                        secenek8.setVisibility(View.INVISIBLE);
                        secenek9.setVisibility(View.INVISIBLE);
                        secenek10.setVisibility(View.INVISIBLE);
                        sonrakisorubtn.setVisibility(View.VISIBLE);
                        //bu kısımdan sonrası soruları cevaplandrıma ve yazdırma için gerkli olan değerleri sıfırlama işlemi
                        text="";
                        tut.setText("0");
                    }
                    else if(kacincisoru==10)sonrakisorubtn.setVisibility(View.VISIBLE);

                    if(text.equalsIgnoreCase(""))
                        kodhavuzu.setText("Kodları buraya sürükleyiniz...");
                    else
                        kodhavuzu.setText(text);
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    if(text.equalsIgnoreCase(""))
                    kodhavuzu.setText("Kodları buraya sürükleyiniz...");
                    break;
                    //buton herhangi bir yere bırakılınca
                case DragEvent.ACTION_DROP:
                    //mevcut blokta sorular bitince diğer boğa geç
                    //sürüklenen buton doğru cevabı içeriyor mu ve istenilen alana getirildi mi sorgula

                    if(bt.getText().toString().equalsIgnoreCase(sorulars.Siklar[kacincisoru][oyunNo])&&v.getId()==kodhavuzuscrl.getId()&& kodhavuzu.getText().toString().equalsIgnoreCase("Kodu Bırakın"))
                    {
                        String buton=bt.getText().toString();
                        tut.setText(""+kacincisoru);
                        //burası olmadan da çalışır önlem olsun diye yazdım if ve else kaldırılıp direk komutlar da yazılabilir
                        if(kacincisoru==sorusayisi){
                            break;
                        }
                        else{
                            kodhavuzu.setText("");}bt.setVisibility(View.INVISIBLE);
                        text+=(kacincisoru+1)+"--> "+kodhavuzuhint[oyunNo][kacincisoru]+"\n";
                        kodhavuzu.setText(text);//text+" "+button1.getText().toString()
                            kacincisoru++;
                            if(kacincisoru!=10)
                            {sorutxt.setText(""+sorulars.Sorular[kacincisoru][oyunNo]);
                            tut.setText(""+kacincisoru);}
                            else
                                sorutxt.setText("TEBRİKLER KODU BAŞARIYLA TAMAMLADINIZ DEVAM ETMEK İÇİN DARWIN'E TIKLAYINIZ.");
                        break;
                    }
                    break;
            }
            return true;
        }
    };
    //yukarıda çağırılan fonksiyonlar
    public void eks(int cevap,int bound,int kacinci){
        int i,j;String temp=null;
        for(i=0;i<10;i++){
            karsilastirma[i][1]= sorulars.Siklar[rant.nextInt(bound)][kacinci];
            for(j=0;j<i;j++){
                if(karsilastirma[j][1].equalsIgnoreCase(""))
                    continue;
                else if(karsilastirma[j][1].equalsIgnoreCase(karsilastirma[i][1])){
                        karsilastirma[i][1]= sorulars.Siklar[rant.nextInt(bound)][kacinci];
                        j=0;
                        i--;
                }
            }
        }
        int tut = 0;
        for(i=0;i<10;i++){
            if (karsilastirma[i][1].equalsIgnoreCase(sorulars.Siklar[0][kacinci])){
                temp=karsilastirma[i][1];
                tut=i;
            }
        }
        karsilastirma[tut][1]=karsilastirma[dogrukod][1];
        karsilastirma[dogrukod][1]=temp;

        for(i=0;i<10;i++){
            for (j=0;j<10;j++){
                if(karsilastirma[j][1].equalsIgnoreCase(sorulars.Siklar[i][kacinci])){
                    cevaplar[i]=j;
                }
            }
        }
    }
    public void butonyaz(int soruno)
    {
        sorutxt =(TextView)findViewById(R.id.sorutxt);
        sorutxt.setText(""+sorulars.Sorular[0][soruno]);
        secenek1.setText(""+karsilastirma[0][1]);
        secenek2.setText(""+karsilastirma[1][1]);
        secenek3.setText(""+karsilastirma[2][1]);
        secenek4.setText(""+karsilastirma[3][1]);
        secenek5.setText(""+karsilastirma[4][1]);
        secenek6.setText(""+karsilastirma[5][1]);
        secenek7.setText(""+karsilastirma[6][1]);
        secenek8.setText(""+karsilastirma[7][1]);
        secenek9.setText(""+karsilastirma[8][1]);
        secenek10.setText(""+karsilastirma[9][1]);}
        //geri tuşuna basılırsa
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Menüye dönmek istediğinizden emin misiniz?");
        builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Evet'e basılınca yapılacak işlemler
                Intent intent=new Intent(BuildCode.this, GamesList.class);
                intent.putExtra("username",username);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
            @Override            public void onClick(DialogInterface dialog, int which) {
                // Hayır'a baslınca yapılacak işlemler
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.exit, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        if(id==R.id.exittoolbar) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(false);
            builder.setMessage("Menüye dönmek istediğinizden emin misiniz?");
            builder.setPositiveButton("EVET", new DialogInterface.OnClickListener() {
                @Override            public void onClick(DialogInterface dialog, int which) {
                    // Evet'e basılınca yapılacak işlemler
                    prog.setMessage("Oyundan Çıkış Yapılıyor...");
                    prog.setCanceledOnTouchOutside(false);
                    prog.show();
                    Intent intent=new Intent(BuildCode.this, GamesList.class);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();
                }
            });
            builder.setNegativeButton("HAYIR", new DialogInterface.OnClickListener() {
                @Override            public void onClick(DialogInterface dialog, int which) {
                    // Hayır'a baslınca yapılacak işlemler
                    dialog.cancel();
                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //burdaki boşluklar doldurulacak buttonlar sürüklenince burda yazanlar kodhavuzuna otomatik yazılacak
    public void hintyaz(){
        kodhavuzuhint[0][0]="import pandas as pd\n" +
                "import numpy as np\n" +
                "import pickle";
        kodhavuzuhint[0][1]="column = ['yorum']\n" +
                "df = pd.read_csv('mutluEt.csv', encoding ='iso-8859-9', sep='\"')\n" +
                "df.columns=column";
        kodhavuzuhint[0][2]="def remove_stopwords(df_fon):\n" +
                "    stopwords = open('turkce-stop-words', 'r').read().split()\n" +
                "    df_fon['stopwords_removed'] = list(map(lambda doc:\n" +
                "        [word for word in doc if word not in stopwords],df_fon['yorum']))\n" +
                "\n" +
                "remove_stopwords(df)";
        kodhavuzuhint[0][3]="df['Positivity'] = 1";
        kodhavuzuhint[0][4]="df.Positivity.iloc[10003:] = 0";
        kodhavuzuhint[0][5]="from sklearn.model_selection import train_test_split\n" +
                "X_train, X_test, y_train, y_test = train_test_split(df['yorum'], df['Positivity'], random_state = 0)\n" +
                "\n" +
                "from sklearn.feature_extraction.text import CountVectorizer\n" +
                "vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)\n" +
                "\n" +
                "X_train_vectorized = vect.transform(X_train) \n" +
                "\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "model = LogisticRegression()\n" +
                "model.fit(X_train_vectorized, y_train)\n" +
                "\n" +
                "#Daha sonra, X_test kullanarak tahminler yapacağız ve eğri puanının altındaki alanı hesaplayacağız.\n" +
                "predictions = model.predict(vect.transform(X_test))\n" +
                "\n" +
                "feature_names = np.array(vect.get_feature_names())\n" +
                "sorted_coef_index = model.coef_[0].argsort()\n" +
                "from sklearn.feature_extraction.text import TfidfVectorizer\n" +
                "vect = TfidfVectorizer(min_df = 5).fit(X_train)\n" +
                "\n" +
                "X_train_vectorized = vect.transform(X_train)\n" +
                "model = LogisticRegression()\n" +
                "model.fit(X_train_vectorized, y_train)\n" +
                "predictions = model.predict(vect.transform(X_test))\n" +
                "\n" +
                "feature_names = np.array(vect.get_feature_names())\n" +
                "sorted_tfidf_index = X_train_vectorized.max(0).toarray()[0].argsort()\n" +
                "\n"  +
                "vect = CountVectorizer(min_df = 5, ngram_range = (1,2)).fit(X_train)\n" +
                "X_train_vectorized = vect.transform(X_train)";
        kodhavuzuhint[0][6]="pickle.dump(vect, open('vect.pkl', 'wb'))\n" +
                "\n" +
                "\n" +
                "model = LogisticRegression()\n" +
                "model.fit(X_train_vectorized, y_train)\n" +
                "pickle.dump(model, open('model.pkl','wb'))";
        kodhavuzuhint[0][7]="";
        kodhavuzuhint[0][8]="";
        kodhavuzuhint[0][9]="";
        kodhavuzuhint[1][0]="import pandas as pd\n" +
                "import numpy as np\n" +
                "import pickle\n" +
                "import joblib";
        kodhavuzuhint[1][1]="column = ['Cümle']\n" +
                "df = pd.read_csv('akilliSinif.csv',encoding = 'utf-8',sep = '\"')";
        kodhavuzuhint[1][2]="def remove_stopwords(df_fon):\n" +
                "    stopwords = open('turkce-stop-words','r').read().split()\n" +
                "    df_fon['stopwords_removed'] = list(map(lambda doc:\n" +
                "        [word for word in doc if word not in stopwords],df_fon['Cümle']))\n" +
                "\n" +
                "remove_stopwords(df)";
        kodhavuzuhint[1][3]="df['Sinif'] = 1";
        kodhavuzuhint[1][4]="df.Sinif.iloc[21:56] = 2";
        kodhavuzuhint[1][5]="df.Sinif.iloc[56:91] = 3";
        kodhavuzuhint[1][6]="df.Sinif.iloc[91:118] = 4";
        kodhavuzuhint[1][7]="from sklearn.model_selection import train_test_split\n" +
                "X_train,X_test,Y_train,Y_test = train_test_split(df['Cümle'],df['Sinif'],test_size = 0.3,random_state = 0)\n" +
                "\n" +
                "from sklearn.feature_extraction.text import CountVectorizer\n" +
                "vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)\n" +
                "\n" +
                "#X_Train'deki belgeleri bir belge terim matrisine dönüştürüyoruz\n" +
                "X_train_vectorizer = vect.transform(X_train)\n" +
                "\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "regressor = LogisticRegression()\n" +
                "regressor.fit(X_train_vectorizer , Y_train)";
        kodhavuzuhint[1][8]="pickle.dump(regressor, open('model2.pkl', 'wb'))  \n" +
                "                \"joblib.dump(vect, 'kelime.pkl')\\n\" +";
        kodhavuzuhint[1][9]="";
        kodhavuzuhint[2][0]="import pandas as pd\n" +
                "import numpy as np\n" +
                "import pickle\n" +
                "import joblib";
        kodhavuzuhint[2][1]="column = ['cümle']\n" +
                "df = pd.read_csv('manset.csv',encoding = 'utf-8',sep = '\"')\n" +
                "df.columns = column\n" +
                "df.info()";
        kodhavuzuhint[2][2]="def remove_addwords(df_fon):\n" +
                "    addwords = open('turkce-stop-words','r').read().split()\n" +
                "    df_fon['addwords_removed'] = list(map(lambda doc:\n" +
                "        [word for word in doc if word not in addwords],df_fon['cümle']))\n" +
                "\n" +
                "remove_addwords(df)";
        kodhavuzuhint[2][3]="df['Manset'] = 1";
        kodhavuzuhint[2][4]="df.Manset.iloc[10:81] = 2";
        kodhavuzuhint[2][5]="df.Manset.iloc[81:157] = 3";
        kodhavuzuhint[2][6]="df.Manset.iloc[157:219] = 4";
        kodhavuzuhint[2][7]="from sklearn.model_selection import train_test_split\n" +
                "X_train,X_test,Y_train,Y_test = train_test_split(df['cümle'],df['Manset'],test_size = 0.3,random_state = 0)\n" +
                "\n" +
                "from sklearn.feature_extraction.text import CountVectorizer\n" +
                "vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)\n" +
                "\n" +
                "X_train_vectorizer = vect.transform(X_train)\n" +
                "\n" +
                "\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "regressor = LogisticRegression()\n" +
                "regressor.fit(X_train_vectorizer , Y_train)";
        kodhavuzuhint[2][8]="joblib.dump(vect, 'manset.pkl')\n" +"\n" +
                "pickle.dump(regressor, open('model3.pkl', 'wb'))";
        kodhavuzuhint[2][9]="";
        kodhavuzuhint[3][0]="import pandas as pd\n" +
                "import pickle\n" +
                "import joblib";
        kodhavuzuhint[3][1]="column = ['cümle']\n" +
                "df = pd.read_csv('sapka.csv',encoding = 'utf-8',sep = '\"')\n" +
                "df.columns = column\n" +
                "df.info()";
        kodhavuzuhint[3][2]="def remove_stopwords(df_fon):\n" +
                "    stopwords = open('turkce-stop-words','r').read().split()\n" +
                "    df_fon['stopwords_removed'] = list(map(lambda doc:\n" +
                "        [word for word in doc if word not in stopwords],df_fon['cümle']))\n" +
                "        \n" +
                "remove_stopwords(df)   ";
        kodhavuzuhint[3][3]="df['Sinif'] = 1";
        kodhavuzuhint[3][4]="df.Sinif.iloc[21:41] = 2";
        kodhavuzuhint[3][5]="df.Sinif.iloc[41:57] = 3";
        kodhavuzuhint[3][6]="df.Sinif.iloc[57:72] = 4";
        kodhavuzuhint[3][7]="from sklearn.model_selection import train_test_split\n" +
                "X_train,X_test,Y_train,Y_test = train_test_split(df['cümle'],df['Sinif'],test_size = 0.3,random_state = 0)\n" +
                "\n" +
                "from sklearn.feature_extraction.text import CountVectorizer\n" +
                "vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)\n"+
                "\n" +
                "#X_Train'deki belgeleri bir belge terim matrisine dönüştürüyoruz\n" +
                "X_train_vectorizer = vect.transform(X_train)\n" +
                "\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "regressor = LogisticRegression()\n" +
                "regressor.fit(X_train_vectorizer , Y_train)";
        kodhavuzuhint[3][8]="joblib.dump(vect, 'sapka.pkl')\npickle.dump(regressor, open('model4.pkl', 'wb')) " ;
        kodhavuzuhint[3][9]="";
        kodhavuzuhint[4][0]="import pandas as pd\n" +
                "import pickle\n" +
                "import joblib";
        kodhavuzuhint[4][1]="column = ['cümle']\n" +
                "df = pd.read_csv('turist.csv',encoding = 'utf-8',sep = '\"')\n" +
                "df.columns = column\n" +
                "df.info()";
        kodhavuzuhint[4][2]="def remove_stopwords(df_fon):\n" +
                "    stopwords = open('turkce-stop-words','r').read().split()\n" +
                "    df_fon['stopwords_removed'] = list(map(lambda doc:\n" +
                "        [word for word in doc if word not in stopwords],df_fon['cümle']))\n" +
                "\n" +
                "remove_stopwords(df)";
        kodhavuzuhint[4][3]="df['Sinif'] = 1";
        kodhavuzuhint[4][4]="df.Sinif.iloc[18:29] = 2";
        kodhavuzuhint[4][5]="df.Sinif.iloc[29:39] = 3";
        kodhavuzuhint[4][6]="df.Sinif.iloc[39:50] = 4";
        kodhavuzuhint[4][7]="df.Sinif.iloc[50:61] = 5";
        kodhavuzuhint[4][8]="from sklearn.model_selection import train_test_split\n" +
                "X_train,X_test,Y_train,Y_test = train_test_split(df['cümle'],df['Sinif'],test_size = 0.3,random_state = 0)\n" +
                "\n" +
                "from sklearn.feature_extraction.text import CountVectorizer\n" +
                "vect = CountVectorizer(encoding ='iso-8859-9').fit(X_train)\n" +
                "\n" +
                "#X_Train'deki belgeleri bir belge terim matrisine dönüştürüyoruz\n" +
                "X_train_vectorizer = vect.transform(X_train)\n" +
                "\n" +
                "\n" +
                "from sklearn.linear_model import LogisticRegression\n" +
                "regressor = LogisticRegression()\n" +
                "regressor.fit(X_train_vectorizer , Y_train)";
        kodhavuzuhint[4][9]="joblib.dump(vect, 'turist.pkl')\npickle.dump(regressor, open('model5.pkl', 'wb'))";
        kodhavuzuhint[5][0]="import cv2\n" +
                "import numpy as np\n" +
                "import os\n" +
                "from random import shuffle\n" +
                "from tqdm import tqdm\n" +
                "import tensorflow as tf\n" +
                "import matplotlib.pyplot as plt\n" +
                "import tflearn\n" +
                "from tflearn.layers.conv import conv_2d, max_pool_2d\n" +
                "from tflearn.layers.core import input_data, dropout, fully_connected\n" +
                "from tflearn.layers.estimator import regression\n";
        kodhavuzuhint[5][1]="EGITIM_KLASORU = 'train'\n" +
                "TEST_KLASORU = 'test'\n" +
                "RESIM_BOYUTU = 50\n" +
                "OGRENME_ORANI = 1e-3m.\n" +
                "MODEL_ADI = 'hayvanlari-ogret'";
        kodhavuzuhint[5][2]="def etiket_olustur(resim_adi):\n" +
                "    obje_turu = resim_adi.split('.')[-3]   \n" +
                "    if obje_turu == 'geyik':\n" +
                "        return np.array([1])\n" +
                "    elif obje_turu == 'sincap':\n" +
                "        return np.array([2])\n" +
                "    elif obje_turu == 'kirpi':\n" +
                "        return np.array([3])\n" +
                "    elif obje_turu == 'tilki':\n" +
                "        return np.array([4])\n" +
                "    elif obje_turu == 'kartal':\n" +
                "        return np.array([5])";
        kodhavuzuhint[5][3]="def egitim_verisi_olustur():\n" +
                "    olusturulan_egitim_verisi = []\n" +
                "    for img in tqdm(os.listdir(EGITIM_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(EGITIM_KLASORU, img)\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_egitim_verisi.append([np.array(resim_verisi), etiket_olustur(img)])\n" +
                "    shuffle(olusturulan_egitim_verisi)\n" +
                "    np.save('egitim_verisi.npy', olusturulan_egitim_verisi)\n" +
                "    return olusturulan_egitim_verisi\n";
        kodhavuzuhint[5][4]="def test_verisi_olustur():\n" +
                "    olusturulan_test_verisi = []\n" +
                "    for img in tqdm(os.listdir(TEST_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(TEST_KLASORU, img)\n" +
                "        resim_no = img.split('.')[0]\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_test_verisi.append([np.array(resim_verisi), resim_no])\n" +
                "    shuffle(olusturulan_test_verisi)\n" +
                "    np.save('test_verisi.npy', olusturulan_test_verisi)\n" +
                "    return olusturulan_test_verisi";
        kodhavuzuhint[5][5]="egitim_verisi = np.load('egitim_verisi.npy')\n" +
                "test_verisi = np.load('test_verisi.npy')";
        kodhavuzuhint[5][6]="s";
        kodhavuzuhint[5][7]="";
        kodhavuzuhint[5][8]="";
        kodhavuzuhint[5][9]="";
        kodhavuzuhint[6][0]="import cv2\n" +
                "import numpy as np\n" +
                "import os\n" +
                "from random import shuffle\n" +
                "from tqdm import tqdm\n" +
                "import tensorflow as tf\n" +
                "import matplotlib.pyplot as plt\n" +
                "import tflearn\n" +
                "from tflearn.layers.conv import conv_2d, max_pool_2d\n" +
                "from tflearn.layers.core import input_data, dropout, fully_connected\n" +
                "from tflearn.layers.estimator import regression\n";
        kodhavuzuhint[6][1]="EGITIM_KLASORU = 'train'\n" +
                "TEST_KLASORU = 'test'\n" +
                "RESIM_BOYUTU = 50\n" +
                "OGRENME_ORANI = 1e-3m.\n" +
                "MODEL_ADI = 'film-tur-tahmin'";
        kodhavuzuhint[6][2]="def etiket_olustur(resim_adi):\n" +
                "    obje_turu = resim_adi.split('.')[-3]   \n" +
                "    if obje_turu == 'animasyon':\n" +
                "        return np.array([1])\n" +
                "    elif obje_turu == 'gerilim':\n" +
                "        return np.array([2])\n" +
                "    elif obje_turu == 'korku':\n" +
                "        return np.array([3])\n" +
                "    elif obje_turu == 'romantik':\n" +
                "        return np.array([4])\n" +
                "    elif obje_turu == 'bilimKurgu':\n" +
                "        return np.array([5])";
        kodhavuzuhint[6][3]="def egitim_verisi_olustur():\n" +
                "    olusturulan_egitim_verisi = []\n" +
                "    for img in tqdm(os.listdir(EGITIM_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(EGITIM_KLASORU, img)\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_egitim_verisi.append([np.array(resim_verisi), etiket_olustur(img)])\n" +
                "    shuffle(olusturulan_egitim_verisi)\n" +
                "    np.save('egitim_verisi.npy', olusturulan_egitim_verisi)\n" +
                "    return olusturulan_egitim_verisi";
        kodhavuzuhint[6][4]="def test_verisi_olustur():\n" +
                "    olusturulan_test_verisi = []\n" +
                "    for img in tqdm(os.listdir(TEST_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(TEST_KLASORU, img)\n" +
                "        resim_no = img.split('.')[0]\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_test_verisi.append([np.array(resim_verisi), resim_no])\n" +
                "    shuffle(olusturulan_test_verisi)\n" +
                "    np.save('test_verisi.npy', olusturulan_test_verisi)\n" +
                "    return olusturulan_test_verisi\n";
        kodhavuzuhint[6][5]="egitim_verisi = np.load('egitim_verisi.npy')\n" +
                "test_verisi = np.load('test_verisi.npy')";
        kodhavuzuhint[6][6]="";
        kodhavuzuhint[6][7]="";
        kodhavuzuhint[6][8]="";
        kodhavuzuhint[6][9]="";
        kodhavuzuhint[7][0]="import cv2\n" +
                "import numpy as np\n" +
                "import os\n" +
                "from random import shuffle\n" +
                "from tqdm import tqdm\n" +
                "import tensorflow as tf\n" +
                "import matplotlib.pyplot as plt\n" +
                "import tflearn\n" +
                "from tflearn.layers.conv import conv_2d, max_pool_2d\n" +
                "from tflearn.layers.core import input_data, dropout, fully_connected\n" +
                "from tflearn.layers.estimator import regression\n";
        kodhavuzuhint[7][1]="\"EGITIM_KLASORU = 'train'\\n\" +\n" +
                "                \"TEST_KLASORU = 'test'\\n\" +\n" +
                "                \"RESIM_BOYUTU = 50\\n\" +\n" +
                "                \"OGRENME_ORANI = 1e-3m.\\n\" +\n" +
                "                \"MODEL_ADI = 'tas-kagit-makas'\";";
        kodhavuzuhint[7][2]="def etiket_olustur(resim_adi):\n" +
                "    obje_turu = resim_adi.split('.')[-3]   \n" +
                "    if obje_turu == 'tas':\n" +
                "        return np.array([1])\n" +
                "    elif obje_turu == 'kagit':\n" +
                "        return np.array([2])\n" +
                "    elif obje_turu == 'makas':";
        kodhavuzuhint[7][3]="def egitim_verisi_olustur():\n" +
                "    olusturulan_egitim_verisi = []\n" +
                "    for img in tqdm(os.listdir(EGITIM_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(EGITIM_KLASORU, img)\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_egitim_verisi.append([np.array(resim_verisi), etiket_olustur(img)])\n" +
                "    shuffle(olusturulan_egitim_verisi)\n" +
                "    np.save('egitim_verisi.npy', olusturulan_egitim_verisi)\n" +
                "    return olusturulan_egitim_verisi";
        kodhavuzuhint[7][4]="def test_verisi_olustur():\n" +
                "    olusturulan_test_verisi = []\n" +
                "    for img in tqdm(os.listdir(TEST_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(TEST_KLASORU, img)\n" +
                "        resim_no = img.split('.')[0]\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_test_verisi.append([np.array(resim_verisi), resim_no])\n" +
                "    shuffle(olusturulan_test_verisi)\n" +
                "    np.save('test_verisi.npy', olusturulan_test_verisi)\n" +
                "    return olusturulan_test_verisi\n";
        kodhavuzuhint[7][5]="egitim_verisi = np.load('egitim_verisi.npy')\n" +
                "test_verisi = np.load('test_verisi.npy')";
        kodhavuzuhint[7][6]="";
        kodhavuzuhint[7][7]="";
        kodhavuzuhint[7][8]="";
        kodhavuzuhint[7][9]="";
        kodhavuzuhint[8][0]="import cv2\n" +
                "import numpy as np\n" +
                "import os\n" +
                "from random import shuffle\n" +
                "from tqdm import tqdm\n" +
                "import tensorflow as tf\n" +
                "import matplotlib.pyplot as plt\n" +
                "import tflearn\n" +
                "from tflearn.layers.conv import conv_2d, max_pool_2d\n" +
                "from tflearn.layers.core import input_data, dropout, fully_connected\n" +
                "from tflearn.layers.estimator import regression\n";
        kodhavuzuhint[8][1]="\"EGITIM_KLASORU = 'train'\\n\" +\n" +
                "                \"TEST_KLASORU = 'test'\\n\" +\n" +
                "                \"RESIM_BOYUTU = 50\\n\" +\n" +
                "                \"OGRENME_ORANI = 1e-3m.\\n\" +\n" +
                "                \"MODEL_ADI = 'acik-kapali-algilama'\";";
        kodhavuzuhint[8][2]="def etiket_olustur(resim_adi):\n" +
                "    obje_turu = resim_adi.split('.')[-3]   \n" +
                "    if obje_turu == 'acik':\n" +
                "        return np.array([1])\n" +
                "    elif obje_turu == 'kapali':";
        kodhavuzuhint[8][3]="def egitim_verisi_olustur():\n" +
                "    olusturulan_egitim_verisi = []\n" +
                "    for img in tqdm(os.listdir(EGITIM_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(EGITIM_KLASORU, img)\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_egitim_verisi.append([np.array(resim_verisi), etiket_olustur(img)])\n" +
                "    shuffle(olusturulan_egitim_verisi)\n" +
                "    np.save('egitim_verisi.npy', olusturulan_egitim_verisi)\n" +
                "    return olusturulan_egitim_verisi";
        kodhavuzuhint[8][4]="def test_verisi_olustur():\n" +
                "    olusturulan_test_verisi = []\n" +
                "    for img in tqdm(os.listdir(TEST_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(TEST_KLASORU, img)\n" +
                "        resim_no = img.split('.')[0]\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_test_verisi.append([np.array(resim_verisi), resim_no])\n" +
                "    shuffle(olusturulan_test_verisi)\n" +
                "    np.save('test_verisi.npy', olusturulan_test_verisi)\n" +
                "    return olusturulan_test_verisi\n";
        kodhavuzuhint[8][5]="egitim_verisi = np.load('egitim_verisi.npy')\n" +
                "test_verisi = np.load('test_verisi.npy')";
        kodhavuzuhint[8][6]="";
        kodhavuzuhint[8][7]="";
        kodhavuzuhint[8][8]="";
        kodhavuzuhint[8][9]="";
        kodhavuzuhint[9][0]="import cv2\n" +
                "import numpy as np\n" +
                "import os\n" +
                "from random import shuffle\n" +
                "from tqdm import tqdm\n" +
                "import tensorflow as tf\n" +
                "import matplotlib.pyplot as plt\n" +
                "import tflearn\n" +
                "from tflearn.layers.conv import conv_2d, max_pool_2d\n" +
                "from tflearn.layers.core import input_data, dropout, fully_connected\n" +
                "from tflearn.layers.estimator import regression\n";
        kodhavuzuhint[9][1]="\"EGITIM_KLASORU = 'train'\\n\" +\n" +
                "                \"TEST_KLASORU = 'test'\\n\" +\n" +
                "                \"RESIM_BOYUTU = 50\\n\" +\n" +
                "                \"OGRENME_ORANI = 1e-3m.\\n\" +\n" +
                "                \"MODEL_ADI = 'renk-ogrenme'\";";
        kodhavuzuhint[9][2]="def etiket_olustur(resim_adi):\n" +
                "    obje_turu = resim_adi.split('.')[-3]   \n" +
                "    if obje_turu == 'mavi':\n" +
                "        return np.array([1])\n" +
                "    elif obje_turu == 'kirmizi':\n" +
                "        return np.array([2])\n" +
                "    elif obje_turu == 'yesil':\n" +
                "        return np.array([3])\n" +
                "    elif obje_turu == 'pembe':";
        kodhavuzuhint[9][3]="def egitim_verisi_olustur():\n" +
                "    olusturulan_egitim_verisi = []\n" +
                "    for img in tqdm(os.listdir(EGITIM_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(EGITIM_KLASORU, img)\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_egitim_verisi.append([np.array(resim_verisi), etiket_olustur(img)])\n" +
                "    shuffle(olusturulan_egitim_verisi)\n" +
                "    np.save('egitim_verisi.npy', olusturulan_egitim_verisi)\n" +
                "    return olusturulan_egitim_verisi";
        kodhavuzuhint[9][4]="def test_verisi_olustur():\n" +
                "    olusturulan_test_verisi = []\n" +
                "    for img in tqdm(os.listdir(TEST_KLASORU)):\n" +
                "        dosya_yolu = os.path.join(TEST_KLASORU, img)\n" +
                "        resim_no = img.split('.')[0]\n" +
                "        resim_verisi = cv2.imread(dosya_yolu, cv2.IMREAD_GRAYSCALE)\n" +
                "        resim_verisi = cv2.resize(resim_verisi, (RESIM_BOYUTU, RESIM_BOYUTU))\n" +
                "        olusturulan_test_verisi.append([np.array(resim_verisi), resim_no])\n" +
                "    shuffle(olusturulan_test_verisi)\n" +
                "    np.save('test_verisi.npy', olusturulan_test_verisi)\n" +
                "    return olusturulan_test_verisi\n";
        kodhavuzuhint[9][5]="egitim_verisi = np.load('egitim_verisi.npy')\n" +
                "test_verisi = np.load('test_verisi.npy')";
        kodhavuzuhint[9][6]="";
        kodhavuzuhint[9][7]="";
        kodhavuzuhint[9][8]="";
        kodhavuzuhint[9][9]="";
    }
}

