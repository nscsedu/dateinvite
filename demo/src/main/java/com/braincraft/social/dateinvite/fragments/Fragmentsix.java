package com.braincraft.social.dateinvite.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.braincraft.social.dateinvite.MessageBeforeReg;
import com.braincraft.social.dateinvite.R;
import com.braincraft.social.dateinvite.RegistarActivity;
import com.braincraft.social.dateinvite.ViewTest;


/**
 * Created by Anu on 22/04/17.
 */



public class Fragmentsix extends Fragment {

    private SharedPreferences mPreferences;
    public static SharedPreferences.Editor mEditor;

    private Button submit, btnlogin_submit;
    private TextView t;
    private Button back;
  //  final Context context = this;
    private int pos;
    private Button btn_confirm;
    View view;


    // Button secondButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.sixfrag, container, false);


        SharedPreferences mPreferences1 = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = mPreferences1.edit();
        String first = mPreferences1.getString("pager_flag", "");
        Log.v("first123:",first);


        if (first.toLowerCase().contains("1"))
        {
            Fragmentsix mFragment = new Fragmentsix();
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            FragmentRegister bdf = new FragmentRegister();
            ft.replace(R.id.container_a, bdf);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            ft.addToBackStack(null);
            ft.remove(mFragment);
            // getActivity().getFragmentManager().beginTransaction().remove(this).commit();
            ft.commit();
        }


        back = (Button) view.findViewById(com.braincraft.social.R.id.textView1);

   View  viewbutton = (View) getActivity().findViewById(R.id.logindemo1);
        viewbutton.setVisibility(View.INVISIBLE);
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
                        getContext());

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


        btn_confirm= (Button) view.findViewById(com.braincraft.social.R.id.btn_confirm);


        mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEditor = mPreferences.edit();


                mEditor.putString("pager_flag","1");

                mEditor.commit();

               // ((ViewTest)this.getac).pager_flag=1;
               /* FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentRegister llf = new FragmentRegister();
                ft.replace(R.id.container_a, llf);
               // getActivity().getSupportFragmentManager().popBackStack();
                //ft.commit();
                getActivity().getSupportFragmentManager().popBackStack();
                ft.commit();*/

                Fragmentsix mFragment = new Fragmentsix();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                FragmentRegister bdf = new FragmentRegister();
                ft.replace(R.id.container_a, bdf);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
                ft.remove(mFragment);
               // getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                ft.commit();
                //ft.remove(Fragmentsix).commit();
               /* startActivity(new Intent(MessageBeforeReg.this,RegistarActivity.class));
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                finish();*/
                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });
// get the reference of Button
        // secondButton = (Button) view.findViewById(R.id.secondButton);
// perform setOnClickListener on second Button
       /* secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// display a message by using a Toast
                Toast.makeText(getActivity(), "Second Fragment", Toast.LENGTH_LONG).show();
            }
        });*/
        return view;
    }
}