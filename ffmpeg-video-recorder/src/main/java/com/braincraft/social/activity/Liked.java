package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.braincraft.social.R;

/**
 * Created by User on 4/20/2018.
 */

public class Liked  extends AppCompatActivity {
    private Button sendinvitation;
    private Button submit, btnlogin_submit;

    private LinearLayout lt1,lt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liked);

        sendinvitation=(Button) findViewById(R.id.sendinvitation);



       lt1=(LinearLayout) findViewById(R.id.lt1);


        lt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Liked.this, Invite2.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });


        lt2=(LinearLayout) findViewById(R.id.lt2);


        lt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Liked.this, Invite2.class));
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Liked");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
              //  startActivity(new Intent(Liked.this,MainTest.class));
                startActivity(new Intent(Liked.this,Page_Activity.class));
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
