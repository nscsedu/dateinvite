package com.braincraft.social.dateinvite;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {
    private Button btnSkip, btnlogin_submit;
    private static final String TAG = "MyActivity";
    private EditText editTextUserName,editTextEmail,editTextPassword;
    private ProgressDialog pd;
    private static final String URL_REGISTER = "http://173.212.223.213/scouts/api/appusers/";
    TextView terms,privacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);

        pd = new ProgressDialog(HomeActivity.this);
        editTextUserName= (EditText) findViewById(R.id.editTextUserName);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);

        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        Log.i(TAG, "editTextUserName" +    editTextUserName.getText().toString());
        Log.i(TAG, "editTextEmail" + editTextEmail.getText().toString());
        Log.i(TAG, "editTextPassword" +editTextPassword.getText().toString());


        btnlogin_submit = (Button) findViewById(R.id.login_submit);


        terms = (TextView) findViewById(R.id.terms);

        privacy = (TextView) findViewById(R.id.privacy);

        btnlogin_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                startActivity(new Intent(HomeActivity.this,LoginActivity.class));


                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                startActivity(new Intent(HomeActivity.this,Terms.class));


                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                startActivity(new Intent(HomeActivity.this,Privacy.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });
        //signupRequest();
    }
    private void signupRequest() {
        pd.setMessage("Signing Up . . .");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
        String response = null;
        final String finalResponse = response;

        Log.e("<<<",URL_REGISTER+"");
        StringRequest postRequest = new StringRequest(Request.Method.POST, URL_REGISTER,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        pd.hide();
                        //Response
                        JSONObject jsonObject = null;
                        try {
                            jsonObject = new JSONObject(response);

                            /*
                            "status":"true","result":"Registration successfully."*/
                            String result=jsonObject.getString("result");
                            String status=jsonObject.getString("status");
                            if(status.equals("true"))
                            {
                                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                            }





                        }


                        catch (JSONException e) {
                            e.printStackTrace();
                        }



//                        if (response.equals("Successfully Signed In")) {
//
//                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
//
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("ErrorResponse", finalResponse);


                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();


                Log.i(TAG, "editTextUserName" +    editTextUserName.getText().toString());
                Log.i(TAG, "editTextEmail" + editTextEmail.getText().toString());
                Log.i(TAG, "editTextPassword" +editTextPassword.getText().toString());

                params.put("full_name",  editTextUserName.getText().toString());
                params.put("identity", editTextEmail.getText().toString());
                params.put("password", editTextPassword.getText().toString());
                Log.e("params",params+"");
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }
}
