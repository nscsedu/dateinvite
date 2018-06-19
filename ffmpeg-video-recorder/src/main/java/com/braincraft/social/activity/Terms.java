package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 15/4/2018.
 */

public class Terms  extends AppCompatActivity {
    private Button submit, btnlogin_submit;

    String token="token";
    String search;
    String mail="test@test.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Dateinvite");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               /* startActivity(new Intent(About.this,SettingsActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(Terms.this,SettingsActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
                //overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            search = bundle.getString("search");

            token = bundle.getString("token");

            mail = bundle.getString("mail");

        }


        WebView wv;
        wv = (WebView) findViewById(R.id.webView1);
        wv.loadUrl("file:///android_asset/Terms.html");

    }
}