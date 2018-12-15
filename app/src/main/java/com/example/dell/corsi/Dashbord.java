package com.example.dell.corsi;

public class Dashbord implements DashbordCard {


    private String name;
    private int image;

    public Dashbord(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public int getImage() {
        return image;
    }

    @Override
    public void createCard(String name, int image) {

    }
}
