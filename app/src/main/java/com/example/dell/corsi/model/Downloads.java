package com.example.dell.corsi.model;

public class Downloads {
    private String name;
    private String description;

    public Downloads (String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
}
