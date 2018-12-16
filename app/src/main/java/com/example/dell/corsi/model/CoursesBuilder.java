package com.example.dell.corsi.model;

public class CoursesBuilder {

    private String name;
    private String description;
    private int image;

    public CoursesBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public CoursesBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    public CoursesBuilder setImage(int image){
        this.image = image;
        return this;
    }

    //Build a Course Contents and return it
    public Courses addCource(){
        return new Courses(name,description , image);
    }

}
