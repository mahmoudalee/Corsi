package com.example.dell.corsi.controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dell.corsi.model.Courses;
import com.example.dell.corsi.model.CoursesBuilder;
import com.example.dell.corsi.model.Dashbord;
import com.example.dell.corsi.R;
import com.example.dell.corsi.model.HomeCourses;

import java.util.ArrayList;

public class HomeFragment
        extends DashboardFragment
        implements CoursesAdapter.ListItemClickListener {



    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    HomeCourses homeCourses = new HomeCourses();
    ArrayList<Courses> courses ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // the object returns the courses as arrayList and
        //  each item on it has the content of the course
        courses = homeCourses.CreateCourses();

//      Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        sliderDotspanel = (LinearLayout) view.findViewById(R.id.SliderDots);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());

        viewPager.setAdapter(viewPagerAdapter);

        //viewPagerAdapter.getCount() returns the number of images that add in ViewPagerAdapter class
        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        // used to create the dots that indicate which photo shown in home
        for(int i = 0; i < dotscount; i++){
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);
        }
        //set the default active to the first dot
        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                //used to change the position of the active dot by set all of them non-active
                //  then set the active one useing the position
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_courses);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext() , LinearLayoutManager.HORIZONTAL , false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CoursesAdapter(courses , this);
        mRecyclerView.setAdapter(mAdapter);
    }

    //a variable stores card's data which add to Dashboard
    public static ArrayList<Dashbord> checkForDashboard = new ArrayList<Dashbord>();

    @Override
    public void onListItemClick(int itemIndex) {

        // Validation to Check if the user entered any data or not
        // true flag refers to the card that going to be added is not in dashboard so it will be added
        boolean flag = true;
        if(!checkForDashboard.isEmpty())
        {
            for (int i=0 ; i<checkForDashboard.size() ; i++){
                if(!checkForDashboard.get(i).getName().equals(courses.get(itemIndex).getName())) {
                    flag = true;
                }
                else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            DashboardFragment.addToDashboard(courses.get(itemIndex).getName(), courses.get(itemIndex).getImage());
            checkForDashboard.add((Dashbord) dashbordFactory.getCard(courses.get(itemIndex).getName(), courses.get(itemIndex).getImage()));
        }
        Intent intent = new Intent(getActivity() , AndroidCourse.class);
        startActivity(intent);
    }
}
