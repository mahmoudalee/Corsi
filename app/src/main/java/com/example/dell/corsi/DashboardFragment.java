package com.example.dell.corsi;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment {

    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mlayoutManager;
    RecyclerView.Adapter mAdapter;
    public static ArrayList<Dashbord> dashbords = new ArrayList<Dashbord>();

    static DashbordFactory dashbordFactory = new DashbordFactory();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        dashbords.add((Dashbord) dashbordFactory.getCard("Android Development", R.drawable.slide1));
//        dashbords.add((Dashbord) dashbordFactory.getCard("Android Development",R.drawable.slide2));
//        dashbords.add(new Dashbord("Embadded Systems",R.drawable.slide3));
//        dashbords.add(new Dashbord("Android Development",R.drawable.slide1));
//        dashbords.add(new Dashbord("Android Development",R.drawable.slide2));
//        dashbords.add(new Dashbord("Embadded Systems",R.drawable.slide3));
//        dashbords.add(new Dashbord("Android Development",R.drawable.slide2));
//        dashbords.add(new Dashbord("Embadded Systems",R.drawable.slide3));

        return inflater.inflate(R.layout.fragment_dashboard, container, false);


    }

    public static void addToDashboard(String name , int image ) {
        dashbords.add((Dashbord) dashbordFactory.getCard(name, image));
    }



    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_dashboard);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mlayoutManager);
        mAdapter = new DashbordAdapter(dashbords);
        mRecyclerView.setAdapter(mAdapter);
    }

}
