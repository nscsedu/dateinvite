package com.braincraft.social.dateinvite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.braincraft.social.R;
import com.braincraft.social.activity.IndividualInvitation;

/**
 * Created by ADMIN on 22/4/2018.
 */

public class Interaction extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    private ImageView hello,coffe,drink,dinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaction);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("androidtest");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Interaction.this,Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        hello.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(Interaction.this,IndividualInvitation.class));

            }
        });
       dinner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(Interaction.this,IndividualInvitation.class));

            }
        });
       coffe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(Interaction.this,IndividualInvitation.class));

            }
        });
        drink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                startActivity(new Intent(Interaction.this,IndividualInvitation.class));

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
