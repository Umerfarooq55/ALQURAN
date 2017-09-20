package com.umerfarooq.AlQuran.Downloadmp3;

import android.os.Environment;

/**
 * Created by Umerfarooq on 7/31/2017.
 */

public class CheckForSDCard {
    public boolean isSDCardPresent() {
        if (Environment.getExternalStorageState().equals(

                Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }



}

