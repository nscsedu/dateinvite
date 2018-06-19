package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 25/4/2018.
 */

public class UploadImage1 extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    TextView btn_confirm,btn_back,addphoto;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadimage1);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle("");
        btn_confirm= (TextView) findViewById(R.id.btn_confirm);
        btn_back= (TextView) findViewById(R.id.btn_back);
        addphoto= (TextView) findViewById(R.id.addphoto);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(InformationActivity1.this,MainTest.class));


                startActivity(new Intent(UploadImage1.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();


                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(InformationActivity1.this,MainTest.class));


               /* startActivity(new Intent(UploadImage1.this,WhatsApp.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
finish();*/

                Intent intent = new Intent(UploadImage1.this,WhatsApp.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();

                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });
        addphoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(InformationActivity1.this,MainTest.class));


               /* startActivity(new Intent(UploadImage1.this,UploadImage2.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();*/

                Intent intent = new Intent(UploadImage1.this,UploadImage2.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
              //  finish();




                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });


    }
}