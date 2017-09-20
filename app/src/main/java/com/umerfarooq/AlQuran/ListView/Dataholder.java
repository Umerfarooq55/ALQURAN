package com.umerfarooq.AlQuran.ListView;

import android.content.Context;
import android.widget.ArrayAdapter;

import info.androidhive.introslider.R;

/**
 * Created by Umerfarooq on 9/19/2017.
 */

public class Dataholder {

    private int selected;
    private ArrayAdapter<CharSequence> adapter;

    public Dataholder(Context parent) {
        adapter = ArrayAdapter.createFromResource(parent, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    public ArrayAdapter<CharSequence> getAdapter() {
        return adapter;
    }

    public String getText() {
        return (String) adapter.getItem(selected);
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

}