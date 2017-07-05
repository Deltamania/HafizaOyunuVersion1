package com.example.murathanacpayam.hafizaoyunu;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.AppCompatDrawableManager;
import android.widget.Button;

/**
 * Created by Murathan Acıpayam on 30.06.2017.
 */

public class kart extends android.support.v7.widget.AppCompatButton {
    boolean acikMi = false;
    boolean cevrilebilir = true;
    int arkaPlanID;
    int onPlanID=0;
    Drawable arkaresim,on;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public kart(Context context,int id) {
        super(context);
        setId(id);
        arkaPlanID = R.drawable.arka;

        if(id%8==1)
            onPlanID = R.drawable.c1;
        if(id%8==2)
            onPlanID = R.drawable.c2;
        if(id%8==3)
            onPlanID = R.drawable.c3;
        if(id%8==4)
            onPlanID = R.drawable.c4;
        if(id%8==5)
            onPlanID = R.drawable.c5;
        if(id%8==6)
            onPlanID = R.drawable.c6;
        if(id%8==7)
            onPlanID = R.drawable.c7;
        if(id%8==0)
            onPlanID = R.drawable.c8;
        arkaresim = AppCompatDrawableManager.get().getDrawable(context,arkaPlanID);
        on = AppCompatDrawableManager.get().getDrawable(context,onPlanID);
        setBackground(arkaresim);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void cevir(){
        if(cevrilebilir) {
            if (!acikMi) {
                setBackground(on);
                acikMi = true;
            } else {
                setBackground(arkaresim);
                acikMi = false;
            }
        }
    }
}
