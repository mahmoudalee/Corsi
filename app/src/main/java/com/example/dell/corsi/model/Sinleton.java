package com.example.dell.corsi.model;

public class Sinleton {
    //my userName and Password saved in the first time in sign up
    private static String mName;
    private static String mPassword;

    //new userName and password entered in login
    private static String nName;
    private static String nPassword;


    private static Sinleton user;

    // Check if the user Exist or Not
    public static Sinleton getAdmin(String name, String password) {
        if (user == null) {
            user = new Sinleton(name, password);
        }
        else {nName =name; nPassword = password;}
        return user;
    }

    private Sinleton(String name, String password) {
        mName = name;
        mPassword = password;
    }

    public String getmName() {
        return mName;
    }
    public String getmPassword() {
        return mPassword;
    }

    public String getnName() {
        return nName;
    }
    public String getnPassword() {
        return nPassword;
    }



}
