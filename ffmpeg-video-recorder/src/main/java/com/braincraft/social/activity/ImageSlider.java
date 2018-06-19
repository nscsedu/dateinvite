package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 29/4/2018.
 */

public class ImageSlider extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageslider);





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(ImageSlider.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewPager);



        ViewPagerAdapterslider viewPagerAdapter = new ViewPagerAdapterslider(this);

        viewPager.setAdapter(viewPagerAdapter);



    }
}