package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braincraft.social.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InformationActivity1 extends Activity {

    private Button back;
    private int pos;
    private Button btn_confirm;
    private  EditText about_you,dating_type;
    private Spinner country;
    RadioButton radioCoffee,radioDinner,radioDrinks,radionight;
    String type_date;
    private ProgressDialog pd;
    private static final String URL_REGISTER = "http://173.212.223.213/scouts/api/appusers/";
    private static final String TAG = "MyActivity";


    String message,editcity,editstate,kid,drink,smoker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information1);
//        setContentView(R.layout.layout2_information);
        pd = new ProgressDialog(InformationActivity1.this);

        back = (Button) findViewById(R.id.textView1);

        radioCoffee=(RadioButton) findViewById(R.id.radioCoffee);
        radioDinner=(RadioButton) findViewById(R.id.radioDinner);
        radioDrinks=(RadioButton) findViewById(R.id.radioDrinks);
        radionight=(RadioButton) findViewById(R.id.radiokidno);


        about_you= (EditText) findViewById(R.id.about_you);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InformationActivity1.this,InformationActivity.class));

                Log.i(TAG, "about_you" +   about_you.getText().toString());
                Log.i(TAG, "about_you" +   type_date);
                //Log.i(TAG, "editTextPassword3" +editTextPassword.getText().toString());

                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });

        radioDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioDinner.isChecked()){
                    type_date="Dinner";
                }




            }
        });
        radioCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioCoffee.isChecked()){
                    type_date="Coffee";
                }




            }
        });
        radioDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioDrinks.isChecked()){
                    type_date="Drinks";
                }




            }
        });

        radionight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radionight.isChecked()){
                    type_date="NightOut";
                }




            }
        });
        btn_confirm= (Button) findViewById(R.id.btn_confirm);

        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InformationActivity1.this,MainTest.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });


      /*  Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
        String editcity = bundle.getString("editcity");
        String editstate = bundle.getString("editstate");
        String kid = bundle.getString("kid");
        String drink = bundle.getString("drink");
        String smoker = bundle.getString("smoker");

        Log.i(TAG, "message123:" + message);
        Log.i(TAG, "editcity:" + editcity);
        Log.i(TAG, "editstate:" +editstate);
        Log.i(TAG, "kid:" + kid);
        Log.i(TAG, "drink:" +drink);
        Log.i(TAG, "smoker:" +smoker);*/


       /* country = (Spinner) findViewById(R.id.spinner1);
        com.braincraft.videorecorder.MySpinnerAdapter adapter= new com.braincraft.videorecorder.MySpinnerAdapter(getApplicationContext(),
                R.layout.simple_item_spinner,
                Arrays.asList(getResources().getStringArray(R.array.startingyear)));
        country.setAdapter(adapter);*/





    }


    private void signupRequest() {
        pd.setMessage("Signing Up . . .");
        pd.show();
        RequestQueue queue = Volley.newRequestQueue(InformationActivity1.this);
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
                           /* if(status.equals("true"))
                            {
                                startActivity(new Intent(HomeActivity.this,LoginActivity.class));
                            }
                            else{
                                Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();
                            }*/





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

                Log.i(TAG, "about_you" +   about_you.getText().toString());
                Log.i(TAG, "about_you" +   type_date);

                Log.i(TAG, "message123:" + message);
                Log.i(TAG, "editcity:" + editcity);
                Log.i(TAG, "editstate:" +editstate);
                Log.i(TAG, "kid:" + kid);
                Log.i(TAG, "drink:" +drink);
                Log.i(TAG, "smoker:" +smoker);



                params.put("about_you", about_you.getText().toString());
                params.put("type_date", type_date);
                params.put(" message",  message);
                params.put("editcity", editcity);
                params.put("editstate",editstate);

                params.put("kid",  kid);
                params.put("drink", drink);
                params.put("smoker",smoker);
                Log.e("params",params+"");
                return params;
            }
        };
        postRequest.setRetryPolicy(new DefaultRetryPolicy(0, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        queue.add(postRequest);

    }

}


