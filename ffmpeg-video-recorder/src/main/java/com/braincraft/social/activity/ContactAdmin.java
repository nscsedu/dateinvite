package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 19/4/2018.
 */

public class ContactAdmin  extends AppCompatActivity {
    private Button submit, btnlogin_submit,btn_camera,admin_photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_chat);

        btn_camera=(Button) findViewById(R.id.btn_camera);

        admin_photo=(Button) findViewById(R.id.admin_photo);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                //startActivity(new Intent(ContactAdmin.this,MainTest .class));
                startActivity(new Intent(ContactAdmin.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                //  startActivity(new Intent(Chat.this, com.braincraft.social.dateinvite.MainActivity.class));
                startActivity(new Intent(ContactAdmin.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                // startActivity(new Intent(MainTest.this,Invite.class));

            }
        });


       admin_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                //  startActivity(new Intent(Chat.this, com.braincraft.social.dateinvite.MainActivity.class));
                startActivity(new Intent(ContactAdmin.this, Invite4.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                // startActivity(new Intent(MainTest.this,Invite.class));
                finish();

            }
        });
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
