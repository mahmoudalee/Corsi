package com.example.dell.corsi.model;

public class Sinleton {
    private static String mName;
    private static String mPassword;

    private static String nName;
    private static String nPassword;

    private static Sinleton admin;

    public static Sinleton getAdmin(String name, String password) {
        if (admin == null) {
            admin = new Sinleton(name, password);
        }
        else {nName =name; nPassword = password;}
        return admin;
    }

    private Sinleton(String name, String password) {
        mName = name;
        mPassword = password;
    }

    public String getnName() {
        return nName;
    }

    public String getnPassword() {
        return nPassword;
    }
    public String getmName() {
        return mName;
    }

    public String getmPassword() {
        return mPassword;
    }

}
