package com.braincraft.social.dateinvite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.*;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.braincraft.social.activity.*;
import com.braincraft.social.dateinvite.fragments.FragmentRegister;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 15/5/2018.
 */

public class Login extends AppCompatActivity {
    int foo,emailpassflag=0;
    private EditText editTextEmail,editTextPassword;
    String username,password,token;
    private static final String TAG = "MyActivity";
    String respone_server,response_message;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        Button btn =  (Button) findViewById(R.id.button);
        assert btn != null;


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               /* startActivity(new Intent(Login.this,RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/
                /*Intent intent = new Intent(Login.this, FragmentRegister.class);
                startActivity(intent);*/

               /* FragmentRegister fragment = new FragmentRegister();

                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.container_a, fragment, TAG);
                fragmentTransaction.commitAllowingStateLoss();*/
                FragmentRegister fragment = new FragmentRegister();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.myFrame, fragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.addToBackStack(null);
               // ft.remove(Login);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
                ft.commit();

            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);

        editTextEmail= (EditText) findViewById(R.id.Email);

        editTextPassword = (EditText) findViewById(R.id.Password);


        username =  editTextEmail.getText().toString();
        password = editTextPassword.getText().toString();

        Log.i(TAG, "username:" +  username);
        Log.i(TAG, "password:" +password);


        Log.i(TAG, "editTextEmai:" +    editTextEmail.getText().toString());
        Log.i(TAG, "editTextPassword:" +editTextPassword.getText().toString());

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String url = "https://api.ipify.org/?format=json";
                String url = "http://api.dateinvite.com/users/login.json";

               // final TextView txtView = (TextView) findViewById(R.id.textView3);
                //assert txtView != null;
                makeRequest(url, new VolleyCallback() {
                    @Override
                    public void onSuccess(JSONObject result) throws JSONException {


                        Log.v("Responseip12:", respone_server);


                        int foo = Integer.parseInt(respone_server);
                      //  Log.v("Responseip12:", foo);
                        //if(respone_server.equals(1))
                        if(foo==1)
                        {
                           /* startActivity(new Intent(Login.this,InviteNew.class));
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/


                           Intent intent = new Intent(Login.this,Page_Activity.class);
                          //  Intent intent = new Intent(Login.this,chatmessage.class);
                           // Intent intent = new Intent(Login.this,infinite_main.class);
                            intent.putExtra("token", token);
                            intent.putExtra("mail",editTextEmail.getText().toString());
                          //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            startActivity(intent);
                            overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            finish();
                            Toast.makeText(getApplicationContext(), "Login Successful",
                                    Toast.LENGTH_LONG).show();




                           /* Intent intent = new Intent(InformationActivity.this, com.braincraft.social.activity.InformationActivity1.class);
                intent.putExtra("message", TestCountry);
                intent.putExtra("editcity",  editcity.getText().toString());
                intent.putExtra("editstate", editstate.getText().toString());
                intent.putExtra("kid",  kid);
                intent.putExtra("drink", drink);
                intent.putExtra("smoker",  smoker);
                            overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            startActivity(intent);
                            finish();*/
                        }
                        else{

                            if(emailpassflag==1)
                            {
                                Toast.makeText(getApplicationContext(), "Wrong Email",
                                        Toast.LENGTH_LONG).show();
                            }
                            else if(emailpassflag==2)
                            {
                                Toast.makeText(getApplicationContext(), "Wrong Password",
                                        Toast.LENGTH_LONG).show();
                            }

                        }

                       // txtView.setText(String.format("My IP is: %s", result.getString("ip")));
                        //txtView.setTextColor(Color.BLUE);
                    }

                    @Override
                    public void onError(String result) throws Exception {
                        Toast.makeText(getApplicationContext(), "Oops!!",
                                Toast.LENGTH_LONG).show();
                        //txtView.setText(result);
                       // txtView.setTextColor(Color.RED);


                    }
                });
            }
        });

    }

    public void makeRequest( final String url, final VolleyCallback callback) {

        final ProgressDialog progressDialog = new ProgressDialog(Login.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();


        CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.v("Response", response.toString());
                        progressDialog.dismiss();
                       // Log.v("Response123", getString("status"));

                        try {
                             respone_server = response.getString("response");
                            Log.v("auth_msg",response.getString("auth_msg"));
                           // Log.v("auth_msg",response.getString("auth_msg"));
                            Log.v("auth_msg123",response.getJSONObject("user").getString("email"));
                            Log.v("token",response.getJSONObject("user").getString("token"));
                            token=response.getJSONObject("user").getString("token");
                            Log.v("messages",response.getJSONObject("counters").getString("messages"));
                            Log.v("video_messages",response.getJSONObject("counters").getString("video_messages"));
                            Log.v("liked_me",response.getJSONObject("counters").getString("liked_me"));
                            Log.v("invites",response.getJSONObject("counters").getString("invites"));
                            Log.v("Responseip:", respone_server);
                            foo = Integer.parseInt(respone_server);


                            mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(Login.this);

                            mEditor = mPreferences.edit();

                            mEditor.putString("username",response.getJSONObject("user").getString("username"));
                            mEditor.putString("photo",response.getJSONObject("user").getString("photo"));

                            mEditor.putString("state",response.getJSONObject("user").getString("state"));
                            mEditor.putString("country",response.getJSONObject("user").getString("country"));
                            mEditor.putString("city",response.getJSONObject("user").getString("city"));
                            mEditor.putString("about",response.getJSONObject("user").getString("about"));


                            mEditor.putString("smoker",response.getJSONObject("user").getString("smoker"));
                            mEditor.putString("drink",response.getJSONObject("user").getString("drink"));
                            mEditor.putString("has_kids",response.getJSONObject("user").getString("has_kids"));
                            mEditor.putString("available_for",response.getJSONObject("user").getString("available_for"));


                            mEditor.putString("email",response.getJSONObject("user").getString("email"));
                            mEditor.putString("token",response.getJSONObject("user").getString("token"));

                            mEditor.commit();


                            if(foo!=1)
                            { response_message= response.getString("msg");
                                Log.v("Response", response_message);

                                if(response_message.equals("email_wrong"))
                                {
                                    emailpassflag=1;
                                }
                                else if (response_message.equals("password_wrong"))
                                {
                                    emailpassflag=2;
                                }
                            }
                            if (respone_server != "null") {
                                callback.onSuccess(response);

                               /* if(ip=="1")
                                {
                                    startActivity(new Intent(Login.this,Page_Activity.class));
                                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                    Toast.makeText(getApplicationContext(), "rifght",
                                            Toast.LENGTH_LONG).show();
                                }
                                else{
                                    Toast.makeText(getApplicationContext(), "Wrong",
                                            Toast.LENGTH_LONG).show();
                                }*/
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Log.v("Response", error.toString());
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

            /* @Override
             public Map<String, String> getHeaders() throws AuthFailureError {
                 HashMap<String, String> headers = new HashMap<String, String>();
                 headers.put("Content-Type", "application/json");
                 return headers;
             }*/
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                //String creds = String.format("%s:%s","and5@test.com","123123");
                Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                String creds = String.format("%s:%s",editTextEmail.getText().toString(),editTextPassword.getText().toString());
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
        rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }


    //Example of using Async Task
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        MyAsync myTask = new MyAsync(this);
//        myTask.execute("https://api.callhub.io/v2/conference/");
//    }


}

