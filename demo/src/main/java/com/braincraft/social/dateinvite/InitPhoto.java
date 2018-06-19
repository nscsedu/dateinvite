package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.activity.*;

/**
 * Created by ADMIN on 3/4/2018.
 */

public class InitPhoto extends Activity {

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button samplevideo, opencamera, test1, skipvideo;
    private ImageView ivImage;
    private String userChoosenTask;
    TextView testabc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.initcamera);
        // test1=(Button)findViewById(com.braincraft.social.R.id.test1);
        samplevideo = (Button) findViewById(R.id.samplevideo);
        opencamera = (Button) findViewById(R.id.opencamera);



        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitPhoto.this, MainActivity.class));

            }
        });

       /*skipvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitCamera.this,InformationActivity.class));

            }
        });*/


    }

}



