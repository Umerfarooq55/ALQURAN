package com.umerfarooq.AlQuran.ListView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import info.androidhive.introslider.R;

/**
 * Created by Umerfarooq on 8/8/2017.
 */

public class SuraAdapter extends ArrayAdapter<Sura> {

    int mcolorId;

    public SuraAdapter(Activity context, ArrayList<Sura> Words) {

        super(context, 0, Words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Sura currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView SuraEnglish = (TextView) listItemView.findViewById(R.id.SuraEnglissh);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        SuraEnglish.setText(currentWord.getSuraEnglish());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView SuraArabic = (TextView) listItemView.findViewById(R.id.SuraArabic);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        SuraArabic.setText(currentWord.getSuraArabic());

        TextView SuraMeaning = (TextView) listItemView.findViewById(R.id.SuraMeaning);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        SuraMeaning.setText(currentWord.getmSuraMeaning());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView SuraNumber = (TextView) listItemView.findViewById(R.id.SuraNumber);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        SuraNumber.setText(currentWord.getmSuraNumber());




//        View text = listItemView.findViewById(R.id.text_text);
//        int color = ContextCompat.getColor(getContext(), mcolorId);
//        text.setBackgroundColor(color);
//         Return the whole list item layout (containing 2 TextViews and an ImageView)
//         so that it can be shown in the ListView

        return listItemView;
    }

}

