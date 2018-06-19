package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.braincraft.social.R;

/**
 * Created by ADMIN on 5/5/2018.
 */

public class WhatsApp extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    private TextView t;
    private Button back;
    private int pos;
    private Button btn_confirm;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.whatsapp);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }


        back = (Button) findViewById(R.id.textView1);

        t=(TextView ) findViewById(R.id.important);
        String first = " Your WhatsApp number will not be visible on your profile. Your number will only be visible to us.";
        String next = "<font color='#FF0000'>Important!</font>";
        t.setText(Html.fromHtml( next+first));
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WhatsApp.this,InformationActivity1.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                //Log.i(TAG, "editTextPassword3" +editTextPassword.getText().toString());

                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });


        btn_confirm= (Button) findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(WhatsApp.this,UploadImage1.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/


                Intent intent = new Intent(WhatsApp.this,UploadImage1.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
               // finish();


                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });





    }
}