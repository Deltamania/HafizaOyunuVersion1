package com.example.murathanacpayam.hafizaoyunu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView tv = (TextView)findViewById(R.id.textView3);
        Intent i = getIntent();
        int skor = i.getIntExtra("puan",0);
        tv.setText("Tebrikler "+ skor +" hata ile kazandınız!");
    }
}
