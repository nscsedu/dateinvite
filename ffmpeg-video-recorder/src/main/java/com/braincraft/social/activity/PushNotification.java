package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 19/4/2018.
 */

public class PushNotification   extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    public static  String token;
    public static  String mail;
    private Switch mySwitch1;
    private Switch mySwitch2;
    private Switch mySwitch3;

    public static int flag1=0;
    public static int flag2=0;
    public static int flag3=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.push_notification);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
        }



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Push Notification");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               /* startActivity(new Intent(PushNotification.this,SettingsActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/


                Intent intent = new Intent(PushNotification.this,SettingsActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
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

        mySwitch1 = (Switch) findViewById(R.id.myswitch1);
        if (flag1 == 0)
        {
            mySwitch1.setChecked(false);
        }
        else if(flag1==1)
        {
            mySwitch1.setChecked(true);
        }
        mySwitch2 = (Switch) findViewById(R.id.myswitch2);
        if (flag2 == 0)
        {
            mySwitch2.setChecked(false);
        }
        else if(flag2==1)
        {
            mySwitch2.setChecked(true);
        }
        mySwitch3= (Switch) findViewById(R.id.myswitch3);
        if (flag3 == 0)
        {
            mySwitch3.setChecked(false);
        }
        else if(flag3==1)
        {
            mySwitch3.setChecked(true);
        }


        mySwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {

                    flag1=1;

                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_invite", 1);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                } else {
                    flag1=0;
                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_invite", 0);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                }
            }
        });





        mySwitch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {

                    flag2=1;

                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_sayhi", 1);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                } else {
                    flag2=0;
                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_sayhi", 0);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                }
            }
        });



        mySwitch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {

                    flag3=1;

                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_message", 1);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                } else {
                    flag3=0;
                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("push_message", 0);


                    } catch (Exception ex){
                        Log.v("", "ERROR: "+ex.getMessage());
                    }

                    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
                        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                url, null,
                                new Response.Listener<JSONObject>() {*/
                        @Override
                        public void onResponse(JSONObject response) {

                            Log.v("ResponseLike", response.toString());



                            try {






                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Log.v("Response", error.toString());
                                    String err = null;
                                    if (error instanceof com.android.volley.NoConnectionError){
                                        err = "No internet Access!";
                                    }
                                    try {

                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }) {


                        @Override
                        public Map<String, String> getHeaders() throws AuthFailureError {
                            HashMap<String, String> params = new HashMap<String, String>();
                            Log.v("mailResponse", mail);
                            Log.v("tokenResponse", token);
                            //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                            // String creds = String.format("%s:%s",mail,token);
                            String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                            String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                            params.put("Authorization", auth);
                            return params;
                        }
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            return params;
                        }

                    };
                    // rq.setPriority(Request.Priority.HIGH);
                    VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);
                }
            }
        });

    }
}
