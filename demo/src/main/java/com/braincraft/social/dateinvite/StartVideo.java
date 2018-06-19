package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by ADMIN on 2/4/2018.
 */

public class StartVideo extends Activity {

    private Button samplevideo;
    private int pos;
    private Button opencamera,skip;
    private Spinner country;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newcamera);
       /* samplevideo = (Button) findViewById(com.braincraft.social.R.id.samplevideo);

        samplevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        opencamera= (Button) findViewById(com.braincraft.social.R.id.opencamera);

        opencamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartVideo.this,MainActivity.class));

            }
        });


       skip = (Button) findViewById(com.braincraft.social.R.id.skip);

       skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
*/

       /* country = (Spinner) findViewById(R.id.spinner1);
        com.braincraft.videorecorder.MySpinnerAdapter adapter= new com.braincraft.videorecorder.MySpinnerAdapter(getApplicationContext(),
                R.layout.simple_item_spinner,
                Arrays.asList(getResources().getStringArray(R.array.startingyear)));
        country.setAdapter(adapter);*/





    }




}


