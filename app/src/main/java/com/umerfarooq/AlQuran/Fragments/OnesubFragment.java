package com.umerfarooq.AlQuran.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.umerfarooq.AlQuran.ListView.ScreenSlideActivity;
import com.umerfarooq.AlQuran.ListView.Sura;
import com.umerfarooq.AlQuran.ListView.SuraAdapter;

import java.util.ArrayList;

import info.androidhive.introslider.R;


public class OnesubFragment extends Fragment {

    final static float STEP = 200;
    TextView mytv;
    float mRatio = 1.0f;
    int mBaseDist;
    float mBaseRatio;
    float fontsize = 13;
    public OnesubFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_onesub, container, false);
        String[] some_array = getResources().getStringArray(R.array.sura_names);
        String[] surah_english = getResources().getStringArray(R.array.sura_names_english);
        String[] english_translation = getResources().getStringArray(R.array.sura_names_translation);


//        Toast.makeText(getActivity(), surah_english[0]+ " " + english_translation[0], Toast.LENGTH_SHORT).show();
        final ArrayList<Sura> Suras = new ArrayList<Sura>();

               for(int i=0; i<some_array.length;i++){

                   Suras.add(new Sura(surah_english[i], some_array[i], english_translation[i], i+1+""));

}
        SuraAdapter adapter = new SuraAdapter(getActivity(), Suras);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.word_list);
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(Numbers.this, "List Item Clicked", Toast.LENGTH_SHORT).show();
//                Sura word = Suras.get(position);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
////                Toast.makeText(Phrases.this, "List Item Clicked", Toast.LENGTH_SHORT).show();
//                Intent i = new Intent(getContext(), Sura_popup_Activity.class);
//
//                startActivity(i);
//            }
//        });

listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Sura dataModel= Suras.get(position);
//            Toast.makeText(getActivity(), dataModel.getmSuraNumber()+"", Toast.LENGTH_SHORT).show();
//            Snackbar.make(view, dataModel.getmSuraNumber()+"\n"+dataModel.getType()+" API: "+dataModel.getVersion_number(), Snackbar.LENGTH_LONG)
//                    .setAction("No action", null).show();
String num=dataModel.getmSuraNumber();
int num1= Integer.parseInt(num);
            if(num1 <= 7) {
                Intent i = new Intent(getActivity(), ScreenSlideActivity.class);
               i.putExtra("number", dataModel.getmSuraNumber());
                startActivity(i);
//                Fragment fragment = new ScreenSlidePageFragment();
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            }
            else
            {
                Toast.makeText(getActivity(), "This will be Added Later", Toast.LENGTH_SHORT).show();

            }
        }
    });
//
//
//            }
//        });


        return rootView;
    }
}
