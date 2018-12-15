package com.example.dell.corsi;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

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
            Uri uri = Uri.parse("rtsp://r5---sn-4g5ednsk.googlevideo.com/Cj0LENy73wIaNAlsm0m-RMLpjhMYDSANFC2pIhRcMOCoAUIASARgqbeJ2oCnyohbigELX2JObFI4U1M1UU0M/A56623EBC6919EB104FBAC2422C2EB0224B03800.5A3EEDF79DAE90C9A33DF6DAE76461DC1E4FB059/yt6/1/video.3gp");
            videoView.setVideoURI(uri);
            videoView.start();
        }catch (Exception e){
            Toast.makeText(this,"No Connection founded",Toast.LENGTH_LONG).show();
        }


    }
}
