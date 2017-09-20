package com.umerfarooq.AlQuran.ListView;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.nightonke.boommenu.BoomMenuButton;
import com.umerfarooq.AlQuran.WelcomeActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import info.androidhive.introslider.R;

//import com.umerfarooq.AlQuran.ListView.databinding.ActivityMainBinding;

public class SuraTranslationEnglish extends FragmentActivity {
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    static final int[] ITEM_DRAWABLES = {R.drawable.facebook,
            R.drawable.facebook, R.drawable.facebook, R.drawable.facebook,
            R.drawable.facebook};
    //Button btn;
//    RayMenu rayMenu;
    ////
    final static float STEP = 200;
    TextView mytv;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;
    private BoomMenuButton bmb;
    private ArrayList<Pair> piecesAndButtons = new ArrayList<>();
//           private ActivityMainBinding binding;
    private Animation fabOpenAnimation;
    private Animation fabCloseAnimation;
    private boolean isFabMenuOpen = false;
//    private PagerAdapter mPagerAdapter;
private static final int NUM_PAGES = 5;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suna_translation_english);
        String i = getIntent().getStringExtra("number");


        mPager = (ViewPager) findViewById(R.id.viewpagerr);
        mPagerAdapter = new ScreenSlidePagerAdapter(getFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // When changing pages, reset the action bar actions since they are dependent
                // on which page is currently active. An alternative approach is to have each
                // fragment expose actions itself (rather than the activity exposing actions),
                // but for simplicity, the activity provides the actions in this sample.
                invalidateOptionsMenu();
            }
        });

        listView = (ListView) findViewById(R.id.list);
        dataModels = new ArrayList<>();

//
        int id = this.getResources().getIdentifier("file" + i, "raw", this.getPackageName());
        InputStream inputStream = getResources().openRawResource(id);

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            int currentLine = 0;

            StringBuilder text = new StringBuilder();
            while ((line = br.readLine()) != null) {

                //  if (currentLine++ == 50) {
                //     currentLine++;

                text.append(line);
                text.append('\n');

                dataModels.add(new DataModel(line.toString(), "", "", ", "));


                //  }


            }
            br.close();
        } catch (IOException e) {
            //You'll need to add proper error handling here
        }


        adapter = new CustomAdapter(dataModels, getApplicationContext());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
            }
        });


    }
//
// @Override
public boolean onCreateOptionsMenu(Menu menu) {
    super.onCreateOptionsMenu(menu);
    getMenuInflater().inflate(R.menu.activity_screen_slide, menu);

    menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);

    // Add either a "next" or "finish" button to the action bar, depending on which page
    // is currently selected.
    MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
            (mPager.getCurrentItem() == mPagerAdapter.getCount() - 1)
                    ? R.string.action_finish
                    : R.string.action_next);
    item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
    return true;
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, WelcomeActivity.class));
                return true;

            case R.id.action_previous:
                // Go to the previous step in the wizard. If there is no previous step,
                // setCurrentItem will do nothing.
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
                return true;

            case R.id.action_next:
                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
                // will do nothing.
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class ScreenSlidePagerAdapter extends android.support.v13.app.FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}





