package com.example.dell.corsi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {


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
        courses.add(new Courses("Android Development","Android apps"));
        courses.add(new Courses("IOS Development","Android apps"));
        courses.add(new Courses("Embedded Systems","Android apps"));
        courses.add(new Courses("Machine Learning","Android apps"));
        courses.add(new Courses("Computer Science","Android apps"));
        courses.add(new Courses("Lesson 6","Android apps"));
        courses.add(new Courses("Lesson 7","Android apps"));
        courses.add(new Courses("Lesson 8","Android apps"));
        courses.add(new Courses("Lesson 9","Android apps"));
        courses.add(new Courses("Lesson 10","Android apps"));
        courses.add(new Courses("Lesson 11","Android apps"));
        courses.add(new Courses("Lesson 12","Android apps"));
        courses.add(new Courses("Lesson 13","Android apps"));
        courses.add(new Courses("Lesson 14","Android apps"));
        courses.add(new Courses("Lesson 15","Android apps"));
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
        mAdapter = new CoursesAdapter(courses);
        mRecyclerView.setAdapter(mAdapter);
    }
}
