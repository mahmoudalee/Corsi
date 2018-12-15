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

import java.util.ArrayList;

public class HomeFragment
         extends DashboardFragment
        implements CoursesAdapter.ListItemClickListener {



    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    ArrayList<Courses> courses = new ArrayList<Courses>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
//
//        // Inflate the layout for this fragment
        courses.add(new CoursesBuilder().setName("Android Development (Basics)").setDescription("Learn Java and build mobile apps").setImage(R.drawable.slide1).addCource());
        courses.add(new CoursesBuilder().setName("IOS Development").setDescription("Build an App for the iPhone and iPad").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Embedded Systems").setDescription("Android apps").setImage(R.drawable.slide3).addCource());
        courses.add(new CoursesBuilder().setName("Machine Learning").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Computer Science").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 6").setDescription("Android apps").setImage(R.drawable.fb).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 7").setDescription("Android apps").setImage(R.drawable.fb).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 8").setDescription("Android apps").setImage(R.drawable.tw).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 9").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 10").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 11").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 12").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 13").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 14").setDescription("Android apps").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Lesson 15").setDescription("Android apps").setImage(R.drawable.slide3).addCource());
//
//        CoursesAdapter arrayAdapter = new CoursesAdapter(getActivity(),courses);
//        ListView listView = (ListView) rootView.findViewById(R.id.listCourses);
//        listView.setAdapter(arrayAdapter);

           return inflater.inflate(R.layout.fragment_home, container, false);
//        return rootView;
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

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getActivity().getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

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


    public static ArrayList<Dashbord> checkForDashboard = new ArrayList<Dashbord>();
    @Override
    public void onListItemClick(int itemIndex) {
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
