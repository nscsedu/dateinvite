package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by User on 4/20/2018.
 */

public class VideoMessage extends AppCompatActivity {
    private Button sendinvitation;
    private Button submit, btnlogin_submit;
    private TextView allmessage;
    String token;
    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_messagelayout);

        //sendinvitation=(Button) findViewById(R.id.sendinvitation);

        allmessage=(TextView) findViewById(R.id.allmessage);

        allmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(VideoMessage.this, AllVideomessage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                // startActivity(new Intent(MainTest.this,Invite.class));

            }
        });
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
        }
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/

        Log.v("token5:",token);
        Log.v("mail15:",mail);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               // startActivity(new Intent(VideoMessage.this,MainTest.class));
               /* startActivity(new Intent(VideoMessage.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(VideoMessage.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
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
