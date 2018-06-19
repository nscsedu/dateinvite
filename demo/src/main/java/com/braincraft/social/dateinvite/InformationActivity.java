package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.activity.*;
import com.braincraft.social.activity.InformationActivity1;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class InformationActivity extends Activity {

    private Button back;
    public static String selectedItemText,TestCountry;
    private int pos;
    private Button btn_confirm;
    private Spinner country;
    private EditText editcity,editstate;
    String kid,drink,smoker;
    RadioButton radiokidyes,radiokidno,radiodrinkno,radiosocialdrinker,radioCigar,radioCigarrets,radioNo;
    private static final String TAG = "MyActivity";



    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;


    String username,password;
    int foo,emailpassflag=0;

    String respone_server,response_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_information);
        setContentView(com.braincraft.social.R.layout.layout1_information);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }

        back = (Button) findViewById(com.braincraft.social.R.id.textView1);


        editcity= (EditText) findViewById(com.braincraft.social.R.id.editcity);

        editstate = (EditText) findViewById(com.braincraft.social.R.id.editstate);

        radiokidyes=(RadioButton) findViewById(com.braincraft.social.R.id.radiokidyes);
        radiokidno=(RadioButton) findViewById(com.braincraft.social.R.id.radiokidno);

        radiodrinkno=(RadioButton) findViewById(com.braincraft.social.R.id.radiodrinkno);
        radiosocialdrinker=(RadioButton) findViewById(com.braincraft.social.R.id.radiosocialdrinker);

        radioCigar=(RadioButton) findViewById(com.braincraft.social.R.id.radioCigar);
        radioCigarrets=(RadioButton) findViewById(com.braincraft.social.R.id.radioCigarrets);
        radioNo=(RadioButton) findViewById(com.braincraft.social.R.id.radioNo);


        radiokidyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(  radiokidyes.isChecked()){
                    kid="1";
                }
            }
        });
        radiokidno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(  radiokidno.isChecked()){
                    kid="0";
                }
            }
        });
        radiodrinkno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radiodrinkno.isChecked()){
                    drink="No";
                }
            }
        });

        radiosocialdrinker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(  radiosocialdrinker.isChecked()){
                    drink="Social Drinker";
                }
            }
        });


        radioCigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(  radioCigar.isChecked()){
                    smoker="Cigar";
                }
            }
        });

        radioCigarrets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioCigarrets.isChecked()){
                    smoker="Cigarrets";
                }
            }
        });

        radioNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioNo.isChecked()){
                    smoker="No";
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                startActivity(new Intent(InformationActivity.this,InitCamera.class));

                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                finish();

            }
        });


        btn_confirm= (Button) findViewById(com.braincraft.social.R.id.btn_confirm);

     /*   btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {








                Intent intent = new Intent(InformationActivity.this,InformationActivity1.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Successful",
                        Toast.LENGTH_LONG).show();
            }
        });*/



        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "http://api.dateinvite.com/users/save.json";


                makeRequest(url, new VolleyCallback() {
                    @Override
                    public void onSuccess(JSONObject result) throws JSONException {


                        Log.v("Responseip12:", respone_server);





                        if(foo==1)
                        {
                           /* startActivity(new Intent(RegistarActivity.this,SelectInterest.class));
                            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                            Toast.makeText(getApplicationContext(), "Login Successful",
                                    Toast.LENGTH_LONG).show();*/



                            Intent intent = new Intent(InformationActivity.this,InformationActivity1.class);

                            intent.putExtra("token", token);
                            intent.putExtra("mail",mail);
                            overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            startActivity(intent);
                            Toast.makeText(getApplicationContext(), "Successful",
                                    Toast.LENGTH_LONG).show();
                        }
                        else{



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


        /*country = (Spinner) findViewById(R.id.spinner1);
        com.braincraft.videorecorder.MySpinnerAdapter adapter= new com.braincraft.videorecorder.MySpinnerAdapter(getApplicationContext(),
                R.layout.simple_item_spinner,
                Arrays.asList(getResources().getStringArray(R.array.startingyear)));
        country.setAdapter(adapter);*/



        country = (Spinner) findViewById(com.braincraft.social.R.id.spinner1);


        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedItemText = (String) parent.getItemAtPosition(position);
                TestCountry=selectedItemText;
                Log.i(TAG, "TestCountry1" + TestCountry);


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

        Locale[] locales = Locale.getAvailableLocales();
        ArrayList<String> countries = new ArrayList<String>();
        for (Locale locale : locales) {
            String country = locale.getDisplayCountry();
            if (country.trim().length() > 0 && !countries.contains(country)) {
                countries.add(country);
            }
        }
        Collections.sort(countries);
        for (String country : countries) {
            System.out.println(country);
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, countries);
        // set the view for the Drop down list
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // set the ArrayAdapter to the spinner
        country.setAdapter(dataAdapter);
        String countryCount = country.getSelectedItem().toString().trim();

        Log.e(TAG, "_log : countryCount: " +  countryCount );

        pos=country.getSelectedItemPosition();
        country.setSelection(pos);
        Log.i(TAG, "pos:" + pos);

        String selectedcountry = country.getSelectedItem().toString();
        Log.i(TAG, "selectedcountry:" + selectedcountry);

        System.out.println("# countries found: " + countries.size());


    }




    public void makeRequest( final String url, final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            Log.v("country:", TestCountry);
            Log.v("state:",editstate.getText().toString());
            Log.v("city:",editcity.getText().toString());


            Log.v("kid:", kid);
            Log.v("drink:",drink);
            Log.v("smoker:",smoker);
            jsonBody.put("country",TestCountry);
            jsonBody.put("state",editstate.getText().toString());
            jsonBody.put("city",editcity.getText().toString());

            jsonBody.put("has_kids",kid);
            jsonBody.put("drink",drink);
            jsonBody.put("smoker",smoker);

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Log.v("Response", response.toString());


                try {
                    respone_server = response.getString("response");

                    Log.v("Responseip:", respone_server);
                    // token=response.getJSONObject("user").getString("token");
                    foo = Integer.parseInt(respone_server);
                    if(foo!=1)
                    { response_message= response.getString("msg");
                        Log.v("Response", response_message);


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
                //Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                //Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                String creds = String.format("%s:%s", mail,token);
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);



                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                // params.put("name",   editTextUserName.getText().toString());
                //params.put("birthday", "1990-01-01");
                return params;
            }



        };
        //  rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }




}


