package com.example.dell.corsi.controller;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.dell.corsi.model.Downloads;
import com.example.dell.corsi.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DownloadsFragment extends Fragment {


    public DownloadsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_downloads, container, false);

        // Inflate the layout for this fragment
        ArrayList<Downloads> downloads = new ArrayList<Downloads>();
        downloads.add(new Downloads("Lesson 1","Android apps"));
        downloads.add(new Downloads("Lesson 2","Android apps"));
        downloads.add(new Downloads("Lesson 3","Android apps"));
        downloads.add(new Downloads("Lesson 4","Android apps"));
        downloads.add(new Downloads("Lesson 5","Android apps"));
        downloads.add(new Downloads("Lesson 6","Android apps"));
        downloads.add(new Downloads("Lesson 7","Android apps"));
        downloads.add(new Downloads("Lesson 8","Android apps"));
        downloads.add(new Downloads("Lesson 9","Android apps"));
        downloads.add(new Downloads("Lesson 10","Android apps"));
        downloads.add(new Downloads("Lesson 11","Android apps"));
        downloads.add(new Downloads("Lesson 12","Android apps"));
        downloads.add(new Downloads("Lesson 13","Android apps"));
        downloads.add(new Downloads("Lesson 14","Android apps"));
        downloads.add(new Downloads("Lesson 15","Android apps"));

        DownloadsAdapter arrayAdapter = new DownloadsAdapter(getActivity(),downloads);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        return rootView;
    }

}
