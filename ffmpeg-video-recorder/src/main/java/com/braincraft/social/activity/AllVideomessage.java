package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by User on 5/1/2018.
 */

public class AllVideomessage extends AppCompatActivity {
    private Button sendinvitation;
    private Button submit, btnlogin_submit;
    private TextView allmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allvideomessage);

        //sendinvitation=(Button) findViewById(R.id.sendinvitation);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                // startActivity(new Intent(VideoMessage.this,MainTest.class));
                startActivity(new Intent(AllVideomessage.this,VideoMessage.class));
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
