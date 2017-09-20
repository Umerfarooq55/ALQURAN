package com.umerfarooq.AlQuran.popup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.umerfarooq.AlQuran.ListView.CustomAdapter;
import com.umerfarooq.AlQuran.ListView.DataModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import info.androidhive.introslider.R;

public class popactivity extends AppCompatActivity {
EditText text;
    Button search;
    ArrayList<DataModel> dataModels;
    ListView listView;
    private static CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popactivity);
        listView=(ListView)findViewById(R.id.word_list);
        dataModels= new ArrayList<>();
text=(EditText)findViewById(R.id.editText);
        search=(Button)findViewById(R.id.button);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             dataModels.clear();

                String word=text.getText().toString();
                int id = getApplicationContext().getResources().getIdentifier("file1", "raw", getApplicationContext().getPackageName());
                InputStream inputStream = getResources().openRawResource(id);

                try {
                    BufferedReader br= new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    int currentLine = 0;

                    StringBuilder text = new StringBuilder();
                    while ((line = br.readLine()) != null) {


                        text.append(line);
                        text.append('\n');
                        if(line.contains(word)) {
                            dataModels.add(new DataModel(line.toString(), "", "", ", "));

                        }





                        //  }


                    }
                    br.close();
                }
                catch (IOException e) {
                    //You'll need to add proper error handling here
                }


                adapter= new CustomAdapter(dataModels,getApplicationContext());
                listView.setAdapter(adapter);
            }
        });

    }
}
