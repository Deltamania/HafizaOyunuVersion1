package com.example.murathanacpayam.hafizaoyunu;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    int sonKart = 0;
    int skor = 0;
    int hata = 0;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String s = i.getStringExtra("mesaj");
        TextView tv = (TextView) findViewById(R.id.textView2);
        tv.setText("Hosgeldiniz "+ s);
        GridLayout gl = (GridLayout) findViewById(R.id.kartlar);
        kart kartlar[] = new kart[16];
        for(int j=1;j<=16;j++){
            kartlar[j-1] = new kart(this,j);
            kartlar[j-1].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final kart k = (kart)v;
                    k.cevir();
                    if(sonKart>0){
                        final kart k2 = (kart)findViewById(sonKart);

                        if(k2.onPlanID == k.onPlanID&&k2.getId()!=k.getId()){
                            //Eslestiler
                            k2.cevrilebilir=false;
                            k.cevrilebilir=false;
                            skor++;
                            TextView tvSkor = (TextView)findViewById(R.id.tvSkor);
                            tvSkor.setText("Skorunuz : "+ skor);

                            if(skor==8){
                                Intent i = new Intent(Main2Activity.this,Main3Activity.class);
                                i.putExtra("puan",hata);
                                startActivity(i);
                                //oyun bitti
                            }
                        }
                        else{
                            //Eslesmediler 2 karti geri cevir
                            Handler h = new Handler();
                            h.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    hata ++;
                                    k.cevir();
                                    k2.cevir();
                                    sonKart=0;
                                    TextView tvHata = (TextView)findViewById(R.id.tvHata);
                                    tvHata.setText("Hatanız : "+ hata);
                                }
                            },500);

                        }
                    }
                    else{
                        sonKart = k.getId();
                    }
                }
            });
        }
        for(int j=0;j<16;j++){
            int rg = (int) (Math.random()*16);
            kart k = kartlar[rg];
            kartlar[rg]=kartlar[j];
            kartlar[j]=k;
        }
        for(int j=0;j<16;j++)
            gl.addView(kartlar[j]);

    }
}
