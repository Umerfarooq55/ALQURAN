package com.umerfarooq.AlQuran.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import info.androidhive.introslider.R;

public class Sura_popup_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_popup_);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.x=-20;
        params.width=550;
        params.height=500;
        params.y = -20;
    }
}
