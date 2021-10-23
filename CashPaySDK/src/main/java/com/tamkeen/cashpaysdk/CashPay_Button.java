package com.tamkeen.cashpaysdk;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.Nullable;


@SuppressLint("AppCompatCustomView")
public class CashPay_Button extends ImageButton {
    public CashPay_Button(final Context context) {
        super(context);

       // setImageDrawable(R.drawable.shap_cash);

    }

    public CashPay_Button(Context context, AttributeSet attrs) {
        super(context, attrs);
        Drawable image=(Drawable)getResources().getDrawable(R.drawable.shap_cash);
        setImageDrawable(image);
        setBackgroundColor(Color.parseColor("#006666"));
    }

    public  void  Runner(Activity activity){

    }



}
