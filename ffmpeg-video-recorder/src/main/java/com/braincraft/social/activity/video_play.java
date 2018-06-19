package com.braincraft.social.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import com.braincraft.social.R;

import static com.braincraft.social.activity.Page_Activity4.uri;
import static com.braincraft.social.activity.Page_Activity4.uri_list;

/**
 * Created by ADMIN on 12/6/2018.
 */

public class video_play extends Activity {
    private static final String TAG = "PRANJAL";
    private boolean isImage = false;
    private String reviewImageLink;
    private MediaController mc;
    public static  String token="token";
    public static   String mail="test@test.com";
    public static  String position="0";
int pos=0;
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

//            position= bundle.getString("position");


//            Log.v("firsttoken", token);
          //  Log.v("firstmail", mail);
          //  Log.v("position123", position);

        }
     //  pos = Integer.parseInt(position);
        // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");

        /*Uri uri  = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test);*/
        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();


       position = mPreferences.getString("pos", "");

        Log.v("123position:", position);
        String stringUri;
        stringUri = uri.toString();
        Log.v("stringUri:", stringUri);

//        Log.v("pos:", position);

        Log.v("uri_list[pos]:", uri_list[Integer.parseInt(position)]);

        Log.v("stringUri:", stringUri);

        mc = new MediaController(this);
        vd.setMediaController(mc);

        vd.setVideoURI(Uri.parse(uri_list[Integer.parseInt(position)]));
        vd.start();

        // startActivity(new Intent(Video.this,InitCamera.class));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //startActivity(new Intent(Video.this,InitCamera.class));


                Intent intent = new Intent(video_play.this,Page_Activity4.class);

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