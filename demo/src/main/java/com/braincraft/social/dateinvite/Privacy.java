package com.braincraft.social.dateinvite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.braincraft.social.activity.MainTest;

/**
 * Created by ADMIN on 15/4/2018.
 */

public class Privacy  extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy);







        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed

                startActivity(new Intent(Privacy.this,RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        toolbar.setNavigationIcon(com.braincraft.social.R.drawable.back_icon);

    }
}
