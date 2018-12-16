package com.example.dell.corsi.model;

import com.example.dell.corsi.R;

import java.util.ArrayList;

public class HomeCourses {

    // this class is responsible for filling the data in home Page

    ArrayList<Courses> courses = new ArrayList<Courses>();
    public ArrayList<Courses> CreateCourses(){
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
        return courses;
    }
}
