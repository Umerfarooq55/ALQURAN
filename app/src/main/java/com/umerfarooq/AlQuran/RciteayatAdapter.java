package com.umerfarooq.AlQuran;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import info.androidhive.introslider.R;

/**
 * Created by Umerfarooq on 7/27/2017.
 */


public class RciteayatAdapter extends ArrayAdapter<Reciteayat> {

    int mcolorId;

    public RciteayatAdapter(Activity context, ArrayList<Reciteayat> Reciteayat) {

        super(context, 0, Reciteayat);

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
        Reciteayat currentayat = getItem(position);

//        // Find the TextView in the list_item.xml layout with the ID version_name
//        TextView nameTextView = (TextView) listItemView.findViewById(R.id.);
//        // Get the version name from the current AndroidFlavor object and
//        // set this text on the name TextView
//        nameTextView.setText(currentayat.getEnglish());
//

//
//        Button download = (Button) listItemView.findViewById(R.id.downloadMp3);
//
//
//        download.setOnClickListener(new View.OnClickListener() {
//            com.umerfarooq.AlQuran.Downloadmp3.downloadMain3Activity conection = new downloadMain3Activity();
//
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getContext(), downloadMain3Activity.class);
//                getContext().startActivity(i);
//
//            }
//
//        });



        return listItemView;
    }

}


