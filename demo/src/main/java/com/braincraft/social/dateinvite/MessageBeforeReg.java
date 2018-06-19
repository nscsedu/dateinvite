package com.braincraft.social.dateinvite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

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


import com.braincraft.social.activity.*;

/**
 * Created by ADMIN on 13/5/2018.
 */

public class MessageBeforeReg  extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    private TextView t;
    private Button back;
    final Context context = this;
    private int pos;
    private Button btn_confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.braincraft.social.R.layout.test1);


        back = (Button) findViewById(com.braincraft.social.R.id.textView1);

      /*  t=(TextView ) findViewById(com.braincraft.social.R.id.important);
        String first = " Your WhatsApp number will not be visible on your profile. Your number will only be visible to us.";
        String next = "<font color='#FF0000'>Important!</font>";
        t.setText(Html.fromHtml( next+first));*/
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* startActivity(new Intent(MessageBeforeReg.this, com.braincraft.social.activity.InformationActivity1.class));
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                finish();*/
                //Log.i(TAG, "editTextPassword3" +editTextPassword.getText().toString());

                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
               /* AlertDialog alertDialog = new AlertDialog.Builder(MessageBeforeReg.this).create();
               // alertDialog.setTitle("Alert");
                alertDialog.setMessage("We are sorry,if you are not willing" +"\n"+
                        "to meet someone from the very" +"\n"+
                        "beginning,maybe Dateinvite is not for" +"\n"+
                        "you.We suggest apps like Tinder or " +"\n"+
                        "Badoo that mostly involve text" +"\n"+
                        "chatting.Thank you for your interest in" +"\n"+
                        "our app.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();*/
                android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(
                        context);

                // set title


                // set dialog message
                alertDialogBuilder
                        .setMessage("We are sorry,if you are not willing" +"\n"+
                                "to meet someone from the very" +"\n"+
                                "beginning,maybe Dateinvite is not for" +"\n"+
                                "you.We suggest apps like Tinder or " +"\n"+
                                "Badoo that mostly involve text" +"\n"+
                                "chatting.Thank you for your interest in" +"\n"+
                                "our app.")
                        .setCancelable(false)
                        .setPositiveButton("OK",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // Toast.makeText(getApplicationContext(), "Press and Hold to record", Toast.LENGTH_LONG).show();


                                // if this button is clicked, close
                                // current activity
                                // FFmpegRecorderActivity.this.finish();
                            }
                        })
                ;

                // create alert dialog
                android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();





                TextView messageText = (TextView) alertDialog.findViewById(android.R.id.message);
                messageText.setGravity(Gravity.CENTER);
                alertDialog.show();

                final Button positiveButton = alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = Gravity.CENTER;
                positiveButton.setLayoutParams(positiveButtonLL);

                alertDialog.show();


            }
        });


        btn_confirm= (Button) findViewById(com.braincraft.social.R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessageBeforeReg.this,RegistarActivity.class));
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                finish();
                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });





    }
}