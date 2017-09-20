package com.umerfarooq.AlQuran.ListView;

/**
 * Created by Umerfarooq on 8/8/2017.
 */

public class Sura {

    public String mSuraEnglish;
    public String mSuraArabic;
    public String mSuraMeaning;
    public String mSuraNumber;



    public Sura(String  SuraEnglish, String SuraArabic , String SuraMeaning, String SuraNumber) {


        mSuraEnglish = SuraEnglish;
        mSuraArabic=SuraArabic;
        mSuraMeaning=SuraMeaning;
        mSuraNumber=SuraNumber;

    }


    public  String getSuraEnglish() {

        return mSuraEnglish;


    }

    public String getSuraArabic() {
//

        return mSuraArabic;
    }

    public String getmSuraMeaning() {

        return mSuraMeaning;
    }

    public String getmSuraNumber() {

        return mSuraNumber;
    }
}








