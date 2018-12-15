package com.example.dell.corsi.model;

public class DashbordFactory  {
    public DashbordCard getCard(String name, int image){
        return new Dashbord(name, image);
    }
}
