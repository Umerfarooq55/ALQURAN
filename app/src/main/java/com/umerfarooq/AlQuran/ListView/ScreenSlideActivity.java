/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.umerfarooq.AlQuran.ListView;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import info.androidhive.introslider.R;


public class ScreenSlideActivity extends AppCompatActivity {
    Toolbar toolbar;
    TranslateAnimation animation;
    FrameLayout f1;
    int deviceWidth, deviceHeight, widthPixels, heightPixels;
    float scaleFactor, widthDp, heightDp, smallestWidth;
    int loop=0;
    int x1, x2, y1, y2;
    Button b1;
    TextView t1;
    MediaPlayer mp;
    String audio;
    String audio_one;
    int s;
    SuraTranslationEnglish suralist;
    ImageView play, stop, fastback, fastforword, repeat, pause, music;
    private static final int NUM_PAGES = 114;

    /**
     * The pager widget, which handles animation and allows swiping horizontally to access previous
     * and next wizard steps.
     */
    private ViewPager mPager;

    /**
     * The pager adapter, which provides the pages to the view pager widget.
     */
    private PagerAdapter mPagerAdapter;
    String[] some_array;
    FrameLayout fl;
    String number;
    int a = 0;
    String[] testArray;
    ArrayList verse = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suna_translation_english);
        toolbar = (Toolbar) findViewById(R.id.toolbarr);

//        number  = getIntent().getStringExtra("number");
        setSupportActionBar(toolbar);

        suralist = new SuraTranslationEnglish();
//        suralist.listView = (ListView) findViewById(R.id.list);
//        suralist. listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                    Toast.makeText(suralist, "OnitemListview", Toast.LENGTH_SHORT).show();
////             }   s=position;
//                }
//
//        });


        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));

//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        final FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.fab);

//        FAB.(R.color.red);
//        FAB.setColorPressedResId(R.color.black_semi_transparent);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FAB.isPressed()) {
                    FAB.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_less_black_24dp));
                } else {
                    FAB.setImageDrawable(getResources().getDrawable(R.drawable.ic_expand_more_black_24dp));
                }


                f1 = (FrameLayout) findViewById(R.id.frame_layout);
                if (smallestWidth == 360) {
                    final int screenHeight = getScreenHeight();
                    ObjectAnimator animator = ObjectAnimator.ofFloat(f1, "y", deviceHeight, (deviceHeight * 0.8F) + 83);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.setDuration(700);
//                animator.setupStartValues();
                    animator.start();
                    //Device is a 10" tablet
                } else if (smallestWidth > 360) {
                    final int screenHeight = getScreenHeight();
                    ObjectAnimator animator = ObjectAnimator.ofFloat(f1, "y", deviceHeight, (deviceHeight * 0.8F) + 260);
                    animator.setInterpolator(new DecelerateInterpolator());
                    animator.setDuration(700);
//                animator.setupStartValues();
                    animator.start();

                    //Device is a 7" tablet
                }
            }
        });

        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        deviceWidth = displayMetrics.widthPixels;
        deviceHeight = displayMetrics.heightPixels;

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        int heightPixels = metrics.heightPixels;
        scaleFactor = metrics.density;
        widthDp = widthPixels / scaleFactor;
        heightDp = heightPixels / scaleFactor;
        smallestWidth = Math.min(widthDp, heightDp);

//      f1 = (FrameLayout) findViewById(R.id.frame_layout);
//        x1=deviceWidth;
//        x2=deviceWidth;
//        y1=deviceHeight;
//        y2=deviceHeight ;
//        animation = new TranslateAnimation(0,0,-0,-75); // new TranslateAnimation(xFrom,xTo, yFrom,yTo)
//        animation.setDuration(1000); // animation duration
//       animation.setRepeatCount(0); // animation repeat count
//       animation.setRepeatMode(Animation.ABSOLUTE);
////        animation.setStartOffset(300);


//        f1.startAnimation(animation);

//        b1 = (Button) findViewById(R.id.start);
////        b1.setText(R.string.text);
//        TextView t = (TextView) findViewById(R.id.text);
//
////        t.setText(R.string.text);
//        b1.setOnClickListener(new View.OnClickListener() {
//
//
//            @Override
//            public void onClick(View view) {
////                f1.startAnimation(animation);
////                animateOnScreen(f1);
//


//            }
//        });

//        String audio = String.valueOf(R.raw.audio);
//        String audio_one = String.valueOf(R.raw.audio_two);
//        verse.add(audio);
//        verse.add(R.raw.audio_two);

        t1 = (TextView) findViewById(R.id.audio);
        play = (ImageView) findViewById(R.id.music);

        play = (ImageView) findViewById(R.id.play_one);
        stop = (ImageView) findViewById(R.id.stop);
        fastback = (ImageView) findViewById(R.id.fast_back);
        fastforword = (ImageView) findViewById(R.id.fast_forword);
        pause = (ImageView) findViewById(R.id.pause);
        repeat = (ImageView) findViewById(R.id.repeat);
        verse.add(0, R.raw.a1);
        verse.add(1, R.raw.a2);
        verse.add(2, R.raw.a3);
        verse.add(3, R.raw.a4);
        verse.add(4, R.raw.a5);

//     final String[] testArray = getResources().getStringArray(R.array.verse);
        mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));

        play();
//        stop();
        pause();
        fastFaroword();
        fastback();
        stop();



        some_array = getResources().getStringArray(R.array.sura_names);
        // Instantiate a ViewPager and a PagerAdapter.
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

//        ZoomLayout myZoomView = new ZoomLayout(getApplication());
//
//        fl = (FrameLayout) findViewById(R.id.zoom);
//        fl.addView(myZoomView);
    }

    int getScreenHeight() {

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics.heightPixels;

    }


    void animateOnScreen(View view) {

        final int screenHeight = getScreenHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "y", screenHeight, (screenHeight * 0.8F));
        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        super.onCreateOptionsMenu(menu);
//        getMenuInflater().inflate(R.menu.activity_screen_slide, menu);
//
//        menu.findItem(R.id.action_previous).setEnabled(mPager.getCurrentItem() > 0);
//
//        // Add either a "next" or "finish" button to the action bar, depending on which page
//        // is currently selected.
//        MenuItem item = menu.add(Menu.NONE, R.id.action_next, Menu.NONE,
//                (mPager.getCurrentItem() == mPagerAdapter.getCount() - 1)
//                        ? R.string.action_finish
//                        : R.string.action_next);
//        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                // Navigate "up" the demo structure to the launchpad activity.
//                // See http://developer.android.com/design/patterns/navigation.html for more.
//                NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
//                return true;
//
//            case R.id.action_previous:
//                // Go to the previous step in the wizard. If there is no previous step,
//                // setCurrentItem will do nothing.
//                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
//                return true;
//
//            case R.id.action_next:
//                // Advance to the next step in the wizard. If there is no next step, setCurrentItem
//                // will do nothing.
//                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
//                return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    /**
     * A simple pager adapter that represents 5 {@link ScreenSlidePageFragment} objects, in
     * sequence.
     */
    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            String pos = String.valueOf(position);
//            int num= Integer.valueOf(number);
//if(position>num)
//{ toolbar.setTitle(position+" _"+some_array[position]);
//
//}else
//{
//    toolbar.setTitle((num)+" _"+some_array[num-1]);
//}


            //   Toast.makeText(ScreenSlideActivity.this, position+" no page", Toast.LENGTH_SHORT).show();
            return ScreenSlidePageFragment.create(position);
        }

        @Override
        public int getCount() {

            return NUM_PAGES;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sura_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(ScreenSlideActivity.this, "Search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(ScreenSlideActivity.this, "Setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.viewas_page:
                Toast.makeText(ScreenSlideActivity.this, "View as page", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.viewas_hizb:
                Toast.makeText(ScreenSlideActivity.this, "View as hizb", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.viewas_juz:
                Toast.makeText(ScreenSlideActivity.this, "View as juz", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.viewas_tajweed:
                Toast.makeText(ScreenSlideActivity.this, "View as tajweed", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



    public void play() {

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScreenSlideActivity.this, "Click", Toast.LENGTH_SHORT).show();
                stop.setVisibility(View.VISIBLE);
                fastback.setVisibility(View.VISIBLE);
                fastforword.setVisibility(View.VISIBLE);
                pause.setVisibility(View.VISIBLE);
                repeat.setVisibility(View.VISIBLE);
                play.setVisibility(View.GONE);
                t1.setVisibility(View.GONE);
//                s=0;
//                mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
//                mp.start();
                if (mp.isPlaying()) {

                    Toast.makeText(ScreenSlideActivity.this, "Audio is playing", Toast.LENGTH_SHORT).show();
//                    Toast.makeText(ScreenSlideActivity.this, mp.getDuration()+"playing", Toast.LENGTH_SHORT).show();
                } else {
               mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
//                    Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
//                    mp.setLooping(true);
//                    mp.seekTo(0);
                    play.setClickable(false);
                    mp.start();
                }
                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                      int maxCount = 2;

                        if(loop < maxCount) {

                            loop++;

                            mp.seekTo(0);
                            mp.start();

                        }else {
                            if (mp.isPlaying()) {

                                isPlaying();
                            } else {

                                isNotPlating();
                            }

//                        }

                        }
                    }});
//                mp.setLooping(false);
//                loop++;


            }
        });
    }

    public void pause(){

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ScreenSlideActivity.this, "Click", Toast.LENGTH_SHORT).show();

                if (mp.isPlaying()) {

                    mp.pause();
                } else {
                    Toast.makeText(ScreenSlideActivity.this, "No Audio", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
  public void fastFaroword(){
        fastforword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Toast.makeText(ScreenSlideActivity.this, "Click", Toast.LENGTH_SHORT).show();
//                for(int a=0;a<verse.size();a++) {
                if (mp.isPlaying()) {

                    isPlaying();
                } else {

                    isNotPlating();
                }
//                if (mp.isPlaying()) {
//
//                        Toast.makeText(ScreenSlideActivity.this, "playing", Toast.LENGTH_SHORT).show();
//                    mp.stop();
//                    s++;
//                  if(s<=verse.size()) {
////                    s++;
//                      mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
//                      Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
//                      mp.start();
//                  } else{
//                    Toast.makeText(ScreenSlideActivity.this, "Audio Finish Press Back Button", Toast.LENGTH_SHORT).show();
//             }
            }
        });
    }
public void stop (){
    stop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Toast.makeText(ScreenSlideActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            stop.setVisibility(View.GONE);
            fastback.setVisibility(View.GONE);
            fastforword.setVisibility(View.GONE);
            pause.setVisibility(View.GONE);
            repeat.setVisibility(View.GONE);
            play.setVisibility(View.VISIBLE);
            t1.setVisibility(View.VISIBLE);


            if (mp.isPlaying()) {

                mp.stop();
            } else {
                Toast.makeText(ScreenSlideActivity.this, "No Audio is Currently Playing", Toast.LENGTH_SHORT).show();
            }


        }
    });
}
    public void isPlaying() {
        if (mp.isPlaying()) {
            mp.stop();
            Toast.makeText(ScreenSlideActivity.this, "Audio is playing", Toast.LENGTH_SHORT).show();
            mp.stop();
            s++;
            if (s < verse.size()) {
//                    s++;
                mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
                Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
                mp.start();
            } else {
                Toast.makeText(ScreenSlideActivity.this, "Audio is Finish Press Back Button", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void isNotPlating() {

        s++;

        if (s < verse.size()) {
//                        s++;
            mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
            Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
            mp.start();
        } else {
            Toast.makeText(ScreenSlideActivity.this, "Audio Finish Press Back Button", Toast.LENGTH_SHORT).show();
        }
    }
    public void fastback(){
        fastback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (mp.isPlaying()) {

                    Toast.makeText(ScreenSlideActivity.this, "Audio is playing", Toast.LENGTH_SHORT).show();
                    mp.stop();
                    s--;

                    if (s >= 0 && s <= verse.size()) {
//
                        if (s == 0) {
                            s = 4;
                        }
                        mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
                        Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
                        mp.start();
                    } else {

                        Toast.makeText(ScreenSlideActivity.this, "Audio Finish Press Back Button", Toast.LENGTH_SHORT).show();
                    }


                } else {
                    s--;
                    if (s > 0) {


                        mp = MediaPlayer.create(ScreenSlideActivity.this, (Integer) verse.get(s));
                        Toast.makeText(ScreenSlideActivity.this, "Next Audio", Toast.LENGTH_SHORT).show();
                        mp.start();


                    } else {
                        Toast.makeText(ScreenSlideActivity.this, "Press Forword Button ", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
}





