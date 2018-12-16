package com.example.dell.corsi.model;

import com.example.dell.corsi.R;

import java.util.ArrayList;

public class HomeCourses {

    // this class is responsible for filling the data in home Page
    ArrayList<Courses> courses = new ArrayList<Courses>();
    public ArrayList<Courses> CreateCourses(){
        courses.add(new CoursesBuilder().setName("Android Development (Basics)").setDescription("Learn Java and build mobile apps").setImage(R.drawable.slide1).addCource());
        courses.add(new CoursesBuilder().setName("IOS Development").setDescription("Build an App for the iPhone and iPad").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Embedded Systems").setDescription("Design & build Electronic Circuits").setImage(R.drawable.slide3).addCource());
        courses.add(new CoursesBuilder().setName("Machine Learning").setDescription("Learn Probabilities and Mathematics").setImage(R.drawable.slide2).addCource());
        courses.add(new CoursesBuilder().setName("Computer Science").setDescription("Learn Algorithms ").setImage(R.drawable.slide1).addCource());
        return courses;
    }
}
