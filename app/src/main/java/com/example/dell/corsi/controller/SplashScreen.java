package com.example.dell.corsi.controller;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.dell.corsi.R;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        EasySplashScreen easySplashScreen = new EasySplashScreen(SplashScreen.this).withFullScreen()
                .withTargetActivity(SignUp.class).
                        withSplashTimeOut(4000).
                        withBackgroundColor(Color.parseColor("#232222")).
                        withLogo(R.drawable.logo).withHeaderText("Welcome student !!!").
                        withFooterText("Developed by \n       MMK").
                        withBeforeLogoText("This is Coursi app").
                        withAfterLogoText("For online courses");

        easySplashScreen.getHeaderTextView().setTextColor(Color.WHITE);
        easySplashScreen.getHeaderTextView().setPaddingRelative(0,50,0,0);

        easySplashScreen.getFooterTextView().setTextColor(Color.WHITE);
        easySplashScreen.getFooterTextView().setPaddingRelative(0,0,0,50);

        easySplashScreen.getAfterLogoTextView().setTextColor(Color.WHITE);
        easySplashScreen.getBeforeLogoTextView().setTextColor(Color.WHITE);

        easySplashScreen.getLogo().setPaddingRelative(0,40,0,50);

        View view = easySplashScreen.create();

        setContentView(view);

    }
}
