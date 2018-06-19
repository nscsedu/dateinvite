package com.braincraft.social.dateinvite;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braincraft.social.activity.Page_Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 2/4/2018.
 */

public class LoginActivity extends AppCompatActivity {
    private Button submit, btnlogin_submit;
    String username,password;
    ProgressBar progressBar;
    private ProgressDialog pd;
    private static final String URL_REGISTER = "http://api.dateinvite.com/users/login.json ";
    private Context context;
    private static final String TAG = "MyActivity";
    CoordinatorLayout coordinatorLayout;
    private EditText editTextEmail,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
       // getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);
      /*  Drawable d=getResources().getDrawable(R.drawable.back_icon);
        getActionBar().setBackgroundDrawable(d);*/
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.back_icon);



        editTextEmail= (EditText) findViewById(R.id.Email);

        editTextPassword = (EditText) findViewById(R.id.Password);


       // StrNoofDay = NoofDay.getText().toString().trim();

        username =  editTextEmail.getText().toString();
         password = editTextPassword.getText().toString();

        Log.i(TAG, "username:" +  username);
        Log.i(TAG, "password:" +password);


        Log.i(TAG, "editTextEmai2" +    editTextEmail.getText().toString());
        Log.i(TAG, "editTextPassword2" +editTextPassword.getText().toString());


        btnlogin_submit = (Button) findViewById(R.id.button);

        btnlogin_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i(TAG, "editTextEmail1:" +  username);
                Log.i(TAG, "editTextPassword1:" +password);

                Log.i(TAG, "editTextEmail3" +    editTextEmail.getText().toString());
                Log.i(TAG, "editTextPassword3" +editTextPassword.getText().toString());
//userLogin();
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                //startActivity(new Intent(LoginActivity.this,SelectInterest.class));
                startActivity(new Intent(LoginActivity.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(LoginActivity.this,RegistarActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);

    }
    private void userLogin() {
        //first getting the values
        Log.e("URLs1:",URL_REGISTER+"");

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Login , Please wait....");
        progressDialog.setCancelable(false);
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REGISTER ,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressBar.setVisibility(View.GONE);

                        Log.e("URLs",URL_REGISTER+"");

                        try {
                            //converting response to json object
                            JSONObject jsonObject = new JSONObject(response);
                            Log.e("response>>",response+"");

                            progressDialog.dismiss();
                            if (CommonFunction.optStringNullCheck(jsonObject,"status").equalsIgnoreCase("false")){
                                showAlert("This is False");





                                Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                                Intent mainIntent = new Intent(LoginActivity.this, SelectInterest.class);

                                startActivity(mainIntent);
                                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                Snackbar.make(coordinatorLayout,
                                        "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                                        .setAction("CLOSE", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                // Custom action
                                            }
                                        }).show();
                                finish();

                                progressDialog.dismiss();
                            }
                            else
                            {
                                JSONObject jsonData = jsonObject.getJSONObject("result");
                               /* CommonFunction.savePreferences(getApplicationContext(), CommonKey.USER_NAME,jsonData.getString("username"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.EMAIL,jsonData.getString("email"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.ID,jsonData.getString("id"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.PHOTO,jsonData.getString("profile_img"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.SCOUT_ID,jsonData.getString("scout_id"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.ACTIVE,jsonData.getString("active"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.LAST_NAME,jsonData.getString("last_login"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.FIRST_NAME,jsonData.getString("first_name"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.LAST_NAME,jsonData.getString("last_name"));
                                CommonFunction.savePreferences(getApplicationContext(), CommonKey.CREATED_ON,jsonData.getString("created_on"));
*/
                                if(jsonObject.getString("response").equalsIgnoreCase("1")) {

                                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                                    Intent mainIntent = new Intent(LoginActivity.this, SelectInterest.class);

                                    startActivity(mainIntent);
                                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                                    Snackbar.make(coordinatorLayout,
                                            "This is a simple Snackbar", Snackbar.LENGTH_LONG)
                                            .setAction("CLOSE", new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    // Custom action
                                                }
                                            }).show();
                                    finish();

                                    progressDialog.dismiss();
                                }
                                finish();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();Log.e("Error",error+"");
                        Toast.makeText(getApplicationContext(),"Error", Toast.LENGTH_SHORT).show();
                    }
                }) {
           /* @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("email",  editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());
                return params;
            }*/


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                String creds = String.format("%s:%s","and5@test,","PASSWORD");
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);

       /* stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(stringRequest);*/
    }
    public  void showAlert(String msg){
        new AlertDialog.Builder(context)
                .setTitle("Error")

                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Whatever...
                    }
                }).create().show();
    }
}