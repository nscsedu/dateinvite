package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


import com.braincraft.social.R;

/**
 * Created by ADMIN on 30/4/2018.
 */

public class Chat extends AppCompatActivity {
    private ImageView imageView_messgae;
    private Button submit, btnlogin_submit,btn_camera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        imageView_messgae=(ImageView) findViewById(R.id.imageView);
        btn_camera=(Button) findViewById(R.id.btn_camera);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        imageView_messgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Chat.this, Invite1.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });



        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              //  startActivity(new Intent(Chat.this, com.braincraft.social.dateinvite.MainActivity.class));
                startActivity(new Intent(Chat.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                // startActivity(new Intent(MainTest.this,Invite.class));

            }
        });


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                //startActivity(new Intent(ContactAdmin.this,MainTest .class));
                startActivity(new Intent(Chat.this,MessageText.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);

       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Privacy.this,HomeActivity.class));
            }
        });*/



    }
}
