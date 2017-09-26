package com.umerfarooq.AlQuran.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import info.androidhive.introslider.R;


public class OneFragment extends Fragment {

    public OneFragment() {
        // Required empty public constructor
    }

    private final List<Fragment> mFragmentList = new ArrayList<>();
    public String one;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_one, container, false);
        OnesubFragment fragment1 = new OnesubFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.oneee, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


        root.findViewById(R.id.surah).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                //     //    Toast.makeText(getContext(), "Helloo", Toast.LENGTH_LONG).show();
//                    OnesubFragment onsub = new OnesubFragment();

                OnesubFragment fragment1 = new OnesubFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.oneee, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        }));
        root.findViewById(R.id.subfragmenttwo).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                 //    Toast.makeText(getContext(), "Helloo", Toast.LENGTH_LONG).show();
//                    OnesubFragment onsub = new OnesubFragment();

                TwosubFragment fragment2 = new TwosubFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.oneee, fragment2);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        }));
        root.findViewById(R.id.subfragmentthree).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                 //    Toast.makeText(getContext(), "Helloo", Toast.LENGTH_LONG).show();
//                    OnesubFragment onsub = new OnesubFragment();

              ThreesubFragment fragment3 = new ThreesubFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.oneee, fragment3);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        }));
        root.findViewById(R.id.subfragmentfour).setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // We normally won't show the welcome slider again in real app
                // but this is for testing
                 //    Toast.makeText(getContext(), "Helloo", Toast.LENGTH_LONG).show();
//                    OnesubFragment onsub = new OnesubFragment();

                FoursubFragment fragment4 = new FoursubFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.oneee, fragment4);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


            }
        }));

        return root;
    }


}
