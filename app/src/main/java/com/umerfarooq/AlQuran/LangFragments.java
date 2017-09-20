package com.umerfarooq.AlQuran;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import info.androidhive.introslider.R;

/**
 * Created by Umerfarooq on 7/27/2017.
 */

public class LangFragments extends  AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Set the content of the activity to use the activity_main.xml layout file0
            setContentView(R.layout.view_page);

            // Find the view pager that will allow the user to swipe between fragments
            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

            // Create an adapter that knows which fragment should be shown on each page
            CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());

            // Set the adapter onto the view pager
            viewPager.setAdapter(adapter);

            // Find the tab layout that shows the tabs
            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);


            tabLayout.setupWithViewPager(viewPager);

        }

    }

