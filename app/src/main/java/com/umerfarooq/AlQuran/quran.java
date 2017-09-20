package com.umerfarooq.AlQuran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import info.androidhive.introslider.R;

public class quran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new quranFragment())
                .commit();
    }
}
