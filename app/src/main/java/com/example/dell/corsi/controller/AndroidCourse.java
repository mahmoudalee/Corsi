package com.example.dell.corsi.controller;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.dell.corsi.R;

public class AndroidCourse extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_course);
        videoView = (VideoView) findViewById(R.id.android_video);
        mediaController = new MediaController(this);
        videoView.requestFocus();
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        try {
//            Uri uri = Uri.parse("rtsp://r2---sn-4g5edns7.googlevideo.com/Cj0LENy73wIaNAmiVPuQ4tEkohMYDSANFC2VjBZcMOCoAUIASARg3pTw96b90rBaigELcWNKRnNXc0s3QzAM/9347E185C7A684AD65D1F352C30B5F9F10C7D0BC.4F5009EE0EFB110AD63A1C2FD1CFF48E2729DE7D/yt6/1/video.3gp");
            Uri uri = Uri.parse("https://l.facebook.com/l.php?u=https%3A%2F%2Fm.youtube.com%2Fwatch%3Fv%3DjunCRL5Jm2w%26app%3Dm%26fbclid%3DIwAR1TmehlwqN4yylDfBL53ldi9q4ejG1ZIjUsIj2GJRPl5FR-9rKK6C4SKs4&h=AT30-Zca-FssR4HIqeb6aYPiJrHZBSp4tfKaJI48d6Y4k3q8y0X14rZwUhK-TZiU6IHQG0g0_xx81kw4qb2X6K7LCb0Z1kJ5mtzYl72hLCeCEzpDJz1LfpVJB0D3f2r48Scinw");
            videoView.setVideoURI(uri);
            videoView.start();
        }catch (Exception e){
            Toast.makeText(this,"No Connection founded",Toast.LENGTH_LONG).show();
        }


    }
}
