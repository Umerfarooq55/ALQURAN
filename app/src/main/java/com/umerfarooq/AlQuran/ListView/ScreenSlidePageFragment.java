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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import info.androidhive.introslider.R;


public class ScreenSlidePageFragment extends Fragment {
    ArrayList<DataModel> dataModels;
    ListView listView;
    TextView textpageno;

    private static CustomAdapter adapter;
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
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
        // Inflate the layout containing a title and body text.
        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_screen_slide_page, container, false);

        // Set the title view to show the page number.

               textpageno = (TextView) rootView.findViewById(R.id.textpageno);
        String pageno = String.valueOf(mPageNumber+1);
        textpageno.setText(pageno);

        Toast.makeText(getActivity(), "umer", Toast.LENGTH_SHORT).show();

                listView = (ListView)rootView. findViewById(R.id.list);
        dataModels = new ArrayList<>();
        int id = this.getResources().getIdentifier("file" + (mPageNumber+1), "raw", getActivity().getPackageName());
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


        adapter = new CustomAdapter(dataModels, getActivity());
        listView.setAdapter(adapter);









        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
