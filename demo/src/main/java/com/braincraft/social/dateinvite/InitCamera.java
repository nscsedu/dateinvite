package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.braincraft.social.activity.InformationActivity;
import com.braincraft.social.activity.Chat;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ADMIN on 3/4/2018.
 */

public class InitCamera extends Activity {

    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button test1;
    private ImageView ivImage;
    private String userChoosenTask;
    TextView testabc,skipvideo;

    private TextView samplevideo,opencamera;

    int foo,emailpassflag=0;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.initcamera);
        setContentView(R.layout.layout5_initcamera);



        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }

       // test1=(Button)findViewById(com.braincraft.social.R.id.test1);
        samplevideo= (TextView) findViewById(R.id.samplevideo);
        opencamera= (TextView) findViewById(R.id.opencamera);
        skipvideo= (TextView) findViewById(R.id.skipvideo);


        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InitCamera.this,MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });

        samplevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(InitCamera.this,Video.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
               // finish();

                Intent intent = new Intent(InitCamera.this,Video.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);

            }
        });

       skipvideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(InitCamera.this,InformationActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(InitCamera.this,InformationActivity.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Successful",
                        Toast.LENGTH_LONG).show();

            }
        });


    }







}



