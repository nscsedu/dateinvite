package com.braincraft.social.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 22/4/2018.
 */

public class Interaction extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    private TextView english,spanish,portugues;
    int flag=0;
    //public int id=0;

    public int message;
    String search;
    public String str_id;
    public int id=0;
    public static  String token;
    public static   String mail;
    private ImageView hello,coffe,drink,dinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interaction);

        /*Bundle bundle = getIntent().getExtras();
        message = bundle.getInt("message");*/
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("androidtest");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if(message==1)
                {
                    startActivity(new Intent(Interaction.this,Invite1.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
               else if(message==2)
                {
                    startActivity(new Intent(Interaction.this,Invite2.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
                else if(message==3)
                {
                    startActivity(new Intent(Interaction.this,Invite3.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }
                else if(message==4)
                {
                    startActivity(new Intent(Interaction.this,Invite4.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();
                }


                else  {
                    startActivity(new Intent(Interaction.this, Invite.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();

                }*/

                Intent intent = new Intent(Interaction.this, InviteNew1.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);
        coffe=(ImageView) findViewById(R.id.coffe);
        hello=(ImageView) findViewById(R.id.hello);
        drink=(ImageView) findViewById(R.id.cocktail);
        dinner=(ImageView) findViewById(R.id.dinner);



        english=(TextView) findViewById(R.id.english);
       spanish=(TextView) findViewById(R.id.spanish);
        portugues=(TextView) findViewById(R.id.portugues);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
           search = bundle.getString("search");

            token = bundle.getString("token");

            mail = bundle.getString("mail");

          //  str_id = bundle.getString("id");

        }

        Log.v("isearch", search);
        Log.v("itoken ",  token );
        Log.v("imaile", mail);


//        id=Integer.parseInt(str_id);



        english.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                english.setBackgroundResource(R.drawable.button_bgash_rounded_corners);
               english.setTextColor(Color.parseColor("#FFFFFF"));


                spanish.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                spanish.setTextColor(Color.parseColor("#000000"));

                portugues.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                portugues.setTextColor(Color.parseColor("#000000"));



            }
        });

       spanish.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                spanish.setBackgroundResource(R.drawable.button_bgash_rounded_corners);
                spanish.setTextColor(Color.parseColor("#FFFFFF"));


                english.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                english.setTextColor(Color.parseColor("#000000"));

                portugues.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                portugues.setTextColor(Color.parseColor("#000000"));

            }
        });
        portugues.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                portugues.setBackgroundResource(R.drawable.button_bgash_rounded_corners);
                portugues.setTextColor(Color.parseColor("#FFFFFF"));

                spanish.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                spanish.setTextColor(Color.parseColor("#000000"));

                english.setBackgroundResource(R.drawable.button_bgwhite_rounded_corners);
                english.setTextColor(Color.parseColor("#000000"));

            }
        });


        hello.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
              /*  startActivity(new Intent(Interaction.this,IndividualInvitation.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

               /* Intent intent = new Intent(Interaction.this, IndividualInvitation.class);
                intent.putExtra("message", message);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(Interaction.this, IndividualInvitation.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
       dinner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR
                flag=1;

              /* startActivity(new Intent(Interaction.this,ind_dinner.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
               /* Intent intent = new Intent(Interaction.this, ind_dinner.class);
                intent.putExtra("message", message);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(Interaction.this, ind_dinner.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


               /* Intent intent = new Intent(Interaction.this, IndividualInvitation.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                intent.putExtra("message", flag);


                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

            }
        });
       coffe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                /*startActivity(new Intent(Interaction.this,IndividualInvitation.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                Intent intent = new Intent(Interaction.this, IndividualInvitation.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
               startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        drink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
               /* startActivity(new Intent(Interaction.this,ind_drink.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                /*Intent intent = new Intent(Interaction.this, ind_drink.class);
                intent.putExtra("message", message);
               startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/


                Intent intent = new Intent(Interaction.this, ind_drink.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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
