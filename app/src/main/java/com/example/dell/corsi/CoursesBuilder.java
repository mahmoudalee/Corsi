package com.example.dell.corsi;

public class CoursesBuilder {

    private String name;
    private String description;

    public CoursesBuilder setName(String name) {
        this.name = name;
        return this;
    }
    public CoursesBuilder setDescription(String description) {
        this.description = description;
        return this;
    }
    public Courses addCource(){
        return new Courses(name,description);
    }

}
