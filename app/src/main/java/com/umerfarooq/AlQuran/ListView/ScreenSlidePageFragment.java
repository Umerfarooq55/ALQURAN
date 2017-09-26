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

import android.app.Fragment;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import info.androidhive.introslider.R;


public class ScreenSlidePageFragment extends Fragment {
    ArrayList<DataModel> dataModels;
    ListView listView;
    TextView textpageno;
    FrameLayout fl;
    ArrayList<String> arabic;
    List<File> fileList = new ArrayList<>();
    private static CustomAdapter adapter;
    public static final String ARG_PAGE = "page";
    String [] surah1;
    File[] files = new File[4];
    BufferedReader[] jsonReader=new BufferedReader[4];
    StringBuilder[] jsonBuilder = new StringBuilder[4];
    int ind=0;
    JSONTokener[] tokener = new JSONTokener[4];
    JSONArray[] jsonArray=new JSONArray[4];
    int start;
    int end;
    int newpage;
    String[] ab;
    File eng,ur,gr;

    ArrayList<String> lan1= new ArrayList<String>();
    ArrayList<String> lan2= new ArrayList<String>();
    ArrayList<String> lan3= new ArrayList<String>();

    private int mPageNumber;


    public static ScreenSlidePageFragment create(int pageNumber) {
        ScreenSlidePageFragment fragment = new ScreenSlidePageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);

        return fragment;
    }

    public ScreenSlidePageFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);

//String verse="َلِكَ الْكِتَابُ لاَ رَيْبَ فِيهِ هُدًى لِّلْمُتَّقِين";
//String[] splitted= verse.split(" ");
//        String a="كَ";
//        String b="كِت";
//        String c="دً";
//        Spannable text = new SpannableString(verse);
//        int  i =verse.indexOf(a);
//        String q = String.valueOf(i);
////        q.replace("دً","كَ");
//
//        text.setSpan(new ForegroundColorSpan(Color.RED),0,10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textpageno = (TextView) rootView.findViewById(R.id.textpageno);
        String pageno = String.valueOf(mPageNumber + 1);
        textpageno.setText(pageno);

         newpage=mPageNumber+1;

        listView = (ListView) rootView.findViewById(R.id.list);
        dataModels = new ArrayList<>();
       int id = this.getResources().getIdentifier("a" + pageno, "array", getActivity().getPackageName());


        surah1 = getResources().getStringArray(id);
//



        dataModels.add(new DataModel("", surah1[0],"", ""));
        if((mPageNumber + 1)<30){
            try {
                File sdcard = Environment.getExternalStorageDirectory();
                ind = 1;

                jsonReader[0] = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.english)));
                jsonReader[1] =new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.urdu)));
                jsonReader[2] = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.german)));


//
                jsonBuilder[0] = new StringBuilder();
                jsonBuilder[1] = new StringBuilder();
////
                jsonBuilder[2] = new StringBuilder();
//

                for (String line = null; (line = jsonReader[0].readLine()) != null; ) {
                    jsonBuilder[0].append(line).append("\n");

                }
                for (String line1 = null; (line1 = jsonReader[1].readLine()) != null; ) {
                    jsonBuilder[1].append(line1).append("\n");

                }
                for (String line2 = null; (line2 = jsonReader[2].readLine()) != null; ) {
                    jsonBuilder[2].append(line2).append("\n");

                }

                //Parse Json
                tokener[0] = new JSONTokener(jsonBuilder[0].toString());
                tokener[1] = new JSONTokener(jsonBuilder[1].toString());
                tokener[2] = new JSONTokener(jsonBuilder[2].toString());
                jsonArray[0] = new JSONArray(tokener[0]);
                jsonArray[1] = new JSONArray(tokener[1]);
                jsonArray[2] = new JSONArray(tokener[2]);

                ArrayList<String> fields = new ArrayList<String>();
                for (int index = 0; index <jsonArray[0].length(); index++) {
                    //Set both values into the listview

                    JSONObject jsonObject = jsonArray[0].getJSONObject(index);
                    JSONObject jsonObject1 = jsonArray[1].getJSONObject(index);
                    JSONObject jsonObject2 = jsonArray[2].getJSONObject(index);




                    if (jsonObject.getString("sura").equals(pageno)) {
                        if (ind < surah1.length) {
                            //  dataModels.add(new DataModel(jsonObject.getString("text"),surah1[ind], "",""));
                             Environment.getExternalStorageDirectory();
                              eng = new File(sdcard+"/QuranFolder", "English.json");
                            ur = new File(sdcard+"/QuranFolder", "Urdu.json");
                            gr = new File(sdcard+"/QuranFolder", "German.json");

                            dataModels.add(new DataModel(jsonObject.getString("text"), surah1[ind], jsonObject1.getString("text"), jsonObject2.getString("text")));
                            ind++;
//
//if(eng.exists()&&ur.exists() && gr.exists())
//{
//
//    dataModels.add(new DataModel(jsonObject.getString("text"), surah1[ind], jsonObject1.getString("text"), jsonObject2.getString("text")));
//    ind++;
//}
//else  if((eng.exists()&&!ur.exists() && !gr.exists())){
//    dataModels.add(new DataModel(jsonObject.getString("text"), surah1[ind],"",""));
//    ind++;
//}else  if((eng.exists()&&ur.exists() && !gr.exists())){
//    dataModels.add(new DataModel(jsonObject.getString("text"), surah1[ind], jsonObject1.getString("text"),""));
//    ind++;
//}
//else  if((eng.exists()&&!ur.exists() && gr.exists())){
//    dataModels.add(new DataModel(jsonObject.getString("text"), surah1[ind], "", jsonObject2.getString("text")));
//    ind++;
//}
//
//else  if((!eng.exists()&&ur.exists() && gr.exists())){
//    dataModels.add(new DataModel("", surah1[ind], jsonObject1.getString("text"), jsonObject2.getString("text")));
//    ind++;
//}
//else  if((!eng.exists()&&ur.exists() && !gr.exists())){
//    dataModels.add(new DataModel("", surah1[ind], jsonObject1.getString("text"), ""));
//    ind++;
//}
//else  if((!eng.exists()&&!ur.exists() && gr.exists())){
//    dataModels.add(new DataModel("", surah1[ind], "", jsonObject2.getString("text")));
//    ind++;
//}
//
//
//else
//{dataModels.add(new DataModel("", surah1[ind],"", ""));
//    ind++;
//
//}

                        }
                    }




                }

                //Toast.makeText(getActivity(),eng+ "", Toast.LENGTH_SHORT).show();
                adapter = new CustomAdapter(dataModels, getActivity());

                listView.setAdapter(adapter);

            } catch (FileNotFoundException e) {
                Log.e("jsonFile", "file not found");
            } catch (IOException e) {
                Log.e("jsonFile", "ioerror");
            } catch (JSONException e) {
                Log.e("jsonFile", "error while parsing json");
            }

        }
        else{
            Toast.makeText(getActivity(), "Not Added Yet", Toast.LENGTH_SHORT).show();

        }



        return rootView;
    }






    public int getPageNumber() {
        return mPageNumber;
    }
}
