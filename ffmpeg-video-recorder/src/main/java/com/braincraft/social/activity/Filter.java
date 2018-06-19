package com.braincraft.social.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.braincraft.social.R;

import static com.braincraft.social.activity.InformationActivity.selectedItemText;

/**
 * Created by ADMIN on 26/4/2018.
 */

public class Filter extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    String selected, spinner_item;
   public static EditText agefrom,ageto,location;
    private Spinner spinner;
    public static  String token="token";
    public static   String mail="test@test.com";
    public static String str_agefrom,str_ageto,str_location;
    public static String prefagefrom="20",prefageto="30";
    public static String location_filter="chile"+"30"+"20";
    public static String from_age="20";
    public static String to_age="30";
    public String text;

    private SharedPreferences mPreferences;
    public static SharedPreferences.Editor mEditor;

    private EditText mName, mPassword;
    private Button btnLogin;
    private CheckBox mCheckBox;

    private TextView reset;

    public int from=20,to=30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter);

        Spinner mySpinner=(Spinner) findViewById(R.id.sp);
         // = mySpinner.getSelectedItem().toString();

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemText = (String) parent.getItemAtPosition(position);
                text=selectedItemText;
               // Log.i(TAG, "TestCountry1" + TestCountry);
                Log.v("text211",text);

                /*Intent intent = new Intent(InformationActivity.this, InformationActivity1.class);
                intent.putExtra("message", TestCountry);
                startActivity(intent);*/

                // Notify the selected item text
               /* Toast.makeText
                        (getApplicationContext(), "Selected : " + selectedItemText, Toast.LENGTH_SHORT)
                        .show();*/
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

//        Log.v("text12:",text);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
        }
       /* token = bundle.getString("token");
         mail = bundle.getString("mail");*/

        Log.v("token123:",token);
        Log.v("mail123:",mail);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Filter.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //overridePendingTransition( R.anim.slide_down_animation,R.anim.slide_up_animation);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);
        spinner = (Spinner) findViewById(R.id.sp);

        agefrom = (EditText) findViewById(R.id.agefrom);
        ageto = (EditText) findViewById(R.id.ageto);
       location = (EditText) findViewById(R.id.location);
        reset = (TextView) findViewById(R.id.reset);

        submit = (Button) findViewById(R.id.submit);
        spinner.setPrompt("Title");
        str_agefrom=agefrom.getText().toString();
        str_ageto=ageto.getText().toString();
        str_agefrom=location.getText().toString();
       /* mPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        mEditor = mPreferences.edit();


        mEditor.putString("first",location.getText().toString());
        mEditor.commit();*/

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
       submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEditor = mPreferences.edit();


                mEditor.putString("first",location.getText().toString());
                mEditor.putString("age1",agefrom.getText().toString());
                mEditor.putString("age2",ageto.getText().toString());
                mEditor.putString("Looking",text);
                mEditor.commit();

                str_agefrom=agefrom.getText().toString();
                str_ageto=ageto.getText().toString();
                str_agefrom=location.getText().toString();

              /*  Intent intent = new Intent(Filter.this,Page_Activity.class);
                intent.putExtra("token",  token);
                intent.putExtra("mail", mail);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();*/




                Intent intent = new Intent(Filter.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();
            }
        });

       reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mEditor = mPreferences.edit();


                mEditor.putString("first","");
                mEditor.putString("age1","");
                mEditor.putString("age2","");
                mEditor.putString("Looking","");
                mEditor.commit();

                str_agefrom=agefrom.getText().toString();
                str_ageto=ageto.getText().toString();
                str_agefrom=location.getText().toString();

              /*  Intent intent = new Intent(Filter.this,Page_Activity.class);
                intent.putExtra("token",  token);
                intent.putExtra("mail", mail);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();*/



                Intent intent = new Intent(Filter.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();
            }
        });


       /* mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        //mPreferences = getSharedPreferences("tabian.com.sharedpreferencestest", Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();


        mEditor.putString("first",location.getText().toString());
        mEditor.commit();*/




       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("location_filter",location_filter);

        editor.apply();*/
        //  SharedPreferences.Editor editor = getSharedPreferences("MyPrefsFile", MODE_PRIVATE).edit();


        //editor.putString("name", "Elena");


        //editor.putInt("idName", 12);


        //editor.apply();


      /*  SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("location_filter", "Chile");*/
       /* SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("NameOfShared", "Value");
        editor.commit();*/


       /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("location_filter", "Chile");
        editor.commit();*/


        // sp.setPrompt("Title");
       /* sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selected = sp.getSelectedItem().toString();
                if (selected.equals("Country"))
                { spinner_item="";

                }

                if (!selected.equals("Country"))
                    spinner_item = selected;
                System.out.println(selected);


            }



            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                sp.setPrompt("Set Text");
            }


        });*/
    }



}