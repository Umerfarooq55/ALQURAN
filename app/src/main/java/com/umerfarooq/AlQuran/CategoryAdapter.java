package com.umerfarooq.AlQuran;

/**
 * Created by Umerfarooq on 5/10/2017.
 */

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import info.androidhive.introslider.R;


public class CategoryAdapter extends FragmentPagerAdapter {


    private Context mContext;

    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new quranFragment();
        } else if (position == 1) {
            return new ayatFragment();
        } else if (position == 2) {
            return new hadeesFragment();
        } else {
            return new tafseerFragment();
        }
    }


    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_quran);
        } else if (position == 1) {
            return mContext.getString(R.string.category_ayat);
        } else if (position == 2) {
            return mContext.getString(R.string.category_hadees);
        } else {
            return mContext.getString(R.string.category_tafseer);
        }
    }
}