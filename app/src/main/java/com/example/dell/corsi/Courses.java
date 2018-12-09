package com.example.dell.corsi;

public class Courses {
    private String name;
    private String description;

    public Courses (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
}
