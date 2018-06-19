package com.braincraft.social.dateinvite;

/**
 * Created by ADMIN on 15/4/2018.
 */
import java.net.URI;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends Activity {
    private static final String TAG = "PRANJAL";
    private boolean isImage = false;
    private String reviewImageLink;
    private MediaController mc;

    public static  String token="token";
    public static   String mail="test@test.com";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_main);
        VideoView vd = (VideoView) findViewById(R.id.VideoView);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }

       // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");

        Uri uri  = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test);

        mc = new MediaController(this);
        vd.setMediaController(mc);

        vd.setVideoURI(uri);
        vd.start();

       // startActivity(new Intent(Video.this,InitCamera.class));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Video.this,InitCamera.class));


                Intent intent = new Intent(Video.this, InitCamera.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
            }
        }, 10000);


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Video.this,InitCamera.class));
            }
        });*/
    }

}