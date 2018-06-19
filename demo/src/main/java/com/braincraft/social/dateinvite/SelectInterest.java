package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.preference.*;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 7/3/2018.
 */

public class SelectInterest extends Activity {
    private SharedPreferences mPreferences;
    public static SharedPreferences.Editor mEditor;
    private TextView back;
    private int pos,select_gen=0,select_interest=0,i_man=0,i_woman=0,in_man=0,in_woman=0,flagtest=0,type_manwoman=0,interested_manwoman=0;
    private ImageView confirm,iam_man,iam_woman,interestedin_man,interestedin_woman;
    private static final String TAG = "MyActivity";

    int foo,emailpassflag=0;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    String respone_server,response_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interest_selection);

        iam_man = (ImageView) findViewById(R.id.iam_man);
        iam_woman = (ImageView) findViewById(R.id.iam_woman);
        interestedin_man = (ImageView) findViewById(R.id.interestedin_man);
        interestedin_woman = (ImageView) findViewById(R.id.interestedin_woman);
        confirm = (ImageView) findViewById(R.id.continueform);

        // iam_man .setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

        iam_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               i_man=1;
                i_woman=0;
                type_manwoman=1;
                flagtest=1;
                //iam_man .setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

                iam_man.setImageResource(R.drawable.man2);

                iam_woman .setImageResource(R.drawable.woman1);
                gender="Male";
               // confirm.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });
        iam_woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_manwoman=2;
                i_woman=1;
                i_man=0;
                flagtest=1;
               // iam_woman .setBackgroundColor(getResources().getColor(android.R.color.darker_gray));

                iam_woman.setImageResource(R.drawable.woman2);

                iam_man.setImageResource(R.drawable.man1);
                gender="Female";
               // confirm.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });
        interestedin_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interested_manwoman=1;
                in_man=1;
                in_woman=0;
               // interestedin_man .setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                interestedin_man.setImageResource(R.drawable.man2);
                interestedin_woman .setImageResource(R.drawable.woman1);
                if( flagtest==1) {
                   // confirm.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
                    confirm.setImageResource(R.drawable.continue1);
                }
               lookingfor="Male";
            }
        });
        interestedin_woman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interested_manwoman=2;
                in_woman=1;
                in_man=0;
                interestedin_woman .setBackgroundColor(getResources().getColor(android.R.color.darker_gray));
                interestedin_woman.setImageResource(R.drawable.woman2);
                interestedin_man .setImageResource(R.drawable.man1);
                if( flagtest==1) {
                    //confirm.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));

                    confirm.setImageResource(R.drawable.continue1);
                }
                lookingfor="Female";
            }
        });


       /* if((i_man==1||i_woman==1)&&(in_man==1||in_woman==1))
        {
            confirm.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        }*/



/*
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                if((i_man==1||i_woman==1)&&(in_man==1||in_woman==1))
                {

                    startActivity(new Intent(SelectInterest.this, Testcrop.class));
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    finish();

                }
            }
        });

*/
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }


        mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(this);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mEditor = mPreferences.edit();


                mEditor.putString("smail",mail);
                mEditor.putString("stoken",token);

                mEditor.commit();



                String url = "http://api.dateinvite.com/users/save.json";


                makeRequest(url, new VolleyCallback() {
                    @Override
                    public void onSuccess(JSONObject result) throws JSONException {


                        Log.v("Responseip12:", respone_server);





                        if(foo==1)
                        {
                            if((i_man==1||i_woman==1)&&(in_man==1||in_woman==1))
                            {
                                //startActivity(new Intent(SelectInterest.this, FFmpegRecorderActivity.class));
                                // startActivity(new Intent(SelectInterest.this, ProfileImage.class));
                              /*  startActivity(new Intent(SelectInterest.this, Testcrop.class));
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();*/
                                // startActivity(new Intent(SelectInterest.this, com.braincraft.social.activity.InformationActivity.class));

                               Intent intent = new Intent(SelectInterest.this,Testcrop.class);
                              //  Intent intent = new Intent(SelectInterest.this,ProfileActivity.class);
                                //Intent intent = new Intent(SelectInterest.this,ImageChange.class);
                                //Intent intent = new Intent(SelectInterest.this,Testcrop.class);
                                intent.putExtra("token", token);
                                intent.putExtra("mail",mail);
                                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "Successful",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        else{

                            /*if(emailpassflag==1)
                            {
                                Toast.makeText(getApplicationContext(), "Wrong Email",
                                        Toast.LENGTH_LONG).show();
                            }
                            else if(emailpassflag==2)
                            {
                                Toast.makeText(getApplicationContext(), "Wrong Password",
                                        Toast.LENGTH_LONG).show();
                            }*/

                        }


                    }

                    @Override
                    public void onError(String result) throws Exception {
                        Toast.makeText(getApplicationContext(), "Oops!!",
                                Toast.LENGTH_LONG).show();

                    }
                });
            }
        });











    }



    public void makeRequest( final String url, final VolleyCallback callback) {
       /* final ProgressDialog progressDialog = new ProgressDialog(SelectInterest.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();*/

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            Log.v("gender1:", gender);
            Log.v("lookingfor1:",lookingfor);
            jsonBody.put("gender",gender);
            jsonBody.put("gender_seeking",lookingfor);

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){


            /* CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {*/
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.v("ResponseInterest", response.toString());
                       // progressDialog.dismiss();


                        try {
                            respone_server = response.getString("response");

                            Log.v("Responseip:", respone_server);
                            foo = Integer.parseInt(respone_server);
                            if(foo!=1)
                            {
                            }

                            if (respone_server != "null") {
                                callback.onSuccess(response);


                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("Response", error.toString());
                      //  progressDialog.dismiss();
                        String err = null;
                        if (error instanceof com.android.volley.NoConnectionError){
                            err = "No internet Access!";
                        }
                        try {
                            if(err != "null") {
                                callback.onError(err);
                            }
                            else {
                                callback.onError(error.toString());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                //String creds = String.format("%s:%s","and5@test.com","123123");
               // Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
              //  Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
               // String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
                String creds = String.format("%s:%s",mail,token);
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);



                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
               // params.put("name",   editTextUserName.getText().toString());
               // params.put("birthday", "1990-01-01");
                return params;
            }



        };
       // rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }

}


