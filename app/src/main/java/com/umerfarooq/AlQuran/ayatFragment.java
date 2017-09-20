package com.umerfarooq.AlQuran;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.introslider.R;


public class ayatFragment extends Fragment {
    public ayatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.wordlist, container, false);
//        final ArrayList<Reciteayat> words = new ArrayList<Reciteayat>();
//
//       final Button downloadMp3 = downloadMain3Activity.downloadMp3;
//
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم" , downloadMp3));
//        words.add(new Reciteayat("بسم الله الرحمن الرحيم", downloadMp3));
//
//        RciteayatAdapter adapter = new RciteayatAdapter(getActivity(), words);
//
//        ListView listView = (ListView) rootView.findViewById(R.id.word_list);
//        listView.setAdapter(adapter);
//        downloadMp3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                Reciteayat word = words.get(position);
//                downloadMain3Activity connection = new downloadMain3Activity();
//                switch (view.getId()) {
//                    case R.id.downloadMp3:
//                        if (connection.isConnectingToInternet())
//                            new DownloadTask(getContext(), downloadPdf, Utils.downloadPdfUrl);
////                        else
////                            Toast.makeText(MainActivity.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.downloadDoc:
//                        if (connection.isConnectingToInternet())
//                            new DownloadTask(getContext(), downloadDoc, Utils.downloadDocUrl);
////                        else
////                            Toast.makeText(MainActivity.this, "Oops!! There is no internet connection. Please enable internet connection and try again.", Toast.LENGTH_SHORT).show();
//                        break;
//                }
//
//            }
//        });
        return rootView;
    }
}


