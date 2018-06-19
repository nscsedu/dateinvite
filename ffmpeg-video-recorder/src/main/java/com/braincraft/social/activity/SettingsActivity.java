package com.braincraft.social.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;
import com.bumptech.glide.Glide;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity
         {

             public static  String token;
             public static  String mail;
    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;private Switch mySwitch;
             private static final String TAG = "MyActivity";
    private TextView privacy,terms,help,about,blockuser,pushnotification,changepassword,logout;

    String respone_server;

    public static int flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test);
        setContentView(R.layout.pref_settings);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        privacy = (TextView) findViewById(R.id.privacy);
        logout = (TextView) findViewById(R.id.logout);

        terms = (TextView) findViewById(R.id.terms);


        help = (TextView) findViewById(R.id.help);

        about = (TextView) findViewById(R.id.about);

        blockuser = (TextView) findViewById(R.id.blockuser);
        pushnotification = (TextView) findViewById(R.id.pushnotification);

        changepassword = (TextView) findViewById(R.id.change_password);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                //  startActivity(new Intent(SettingsActivity.this,MainTest.class));
              /* startActivity(new Intent(SettingsActivity.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/


                Intent intent = new Intent(SettingsActivity.this, Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);


        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
        }
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/

        Log.v("token41:", token);
        Log.v("mail141:", mail);


        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* startActivity(new Intent(SettingsActivity.this, Privacy.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/


                Intent intent = new Intent(SettingsActivity.this, Privacy.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage(getBaseContext().getPackageName());
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });

        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* startActivity(new Intent(SettingsActivity.this, Terms.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

                Intent intent = new Intent(SettingsActivity.this,Terms.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();



            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* startActivity(new Intent(SettingsActivity.this, Help.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

                Intent intent = new Intent(SettingsActivity.this, Help.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
              //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*startActivity(new Intent(SettingsActivity.this, About.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

                Intent intent = new Intent(SettingsActivity.this, About.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
                //overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();

            }
        });
        blockuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              /* startActivity(new Intent(SettingsActivity.this,BlockUser.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



              /* Intent intent = new Intent(SettingsActivity.this,Page_Activity6.class);

                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();*/


                Intent intent = new Intent(SettingsActivity.this, Page_Activity6.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

            }
        });

        pushnotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* startActivity(new Intent(SettingsActivity.this, PushNotification.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(SettingsActivity.this, PushNotification.class);
                intent.putExtra("token", token);
                intent.putExtra("mail", mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();


            }
        });

        changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SettingsActivity.this, ChangePassword.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();

            }
        });

        mySwitch = (Switch) findViewById(R.id.invisible);
        if (flag == 0)
        {
            mySwitch.setChecked(false);
           }
           else if(flag==1)
        {
            mySwitch.setChecked(true);
        }
       mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean bChecked) {
                if (bChecked) {

                    flag=1;

                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("invisible", 1);


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

                                respone_server = response.getString("msg");
                                Log.v("Response_Like", respone_server);




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
flag=0;
                    String url_like = "http://api.dateinvite.com/users/save.json";


                    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        jsonBody.put("invisible", 0);


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

                                respone_server = response.getString("msg");
                                Log.v("Response_Like", respone_server);




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





        /*ImageView ib = (ImageView)navigationView.findViewById(R.id.settings);
        ib.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                //startActivity(new Intent(MainTest.this,CardActivity.class));

            }
        });*/








    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(SettingsActivity.this,Page_Activity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }












}
