package com.umerfarooq.AlQuran;

import android.widget.Button;

/**
 * Created by Umerfarooq on 7/27/2017.
 */

public class Reciteayat {


    public String mEnglish;

    public Button mDownload;


    public Reciteayat(String English, Button Download) {

        mEnglish = English;
        mDownload = Download;


//        maudio = audio;
    }


    public String getEnglish() {

        return mEnglish;
    }


    public  Button getdownloadMp3() {
//

        return mDownload;
    }
}








