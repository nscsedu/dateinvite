package com.braincraft.social.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bikomobile.multipart.Multipart;
import com.bikomobile.multipart.Utils.BytesUtils;
import com.bikomobile.multipart.Utils.SplitBytes;
import com.braincraft.social.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class InformationActivity1 extends Activity {

    private Button back;
    private int pos;
    private Button btn_confirm;
    private  EditText about_you,dating_type;
    private Spinner country;
    RadioButton radioCoffee,radioDinner,radioDrinks,radionight;
    String type_date1,type_date2,type_date3,typedate;
    private ProgressDialog pd;
    private static final String URL_REGISTER = "http://173.212.223.213/scouts/api/appusers/";
    private static final String TAG = "MyActivity";
    String message = "message";
    String editcity = "editcity";
    String editstate ="editstate";
    String kid = "kid";
    String drink = "drink";
    String smoker = "smoker";
    String Path = "Path";
    String TestCountry = "TestCountry";
    private SharedPreferences mPreferences1;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private static final String UPLOAD_URL = "http://media.dateinvite.com/upload.php";
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    private  String hash_id="0";
    String username,password;
    int foo,emailpassflag=0;
    String cvideo="0";

    String respone_server,response_message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information1);
//        setContentView(R.layout.layout2_information);

        /*    mEditor.putString("country",TestCountry);
            mEditor.putString("city",editcity.getText().toString());
            mEditor.putString("state",editstate.getText().toString());


            mEditor.putString("smoker",smoker);
            mEditor.putString("drink",drink);
            mEditor.putString("has_kids",kid);*/


      //  SharedPreferences mPreferences6 = PreferenceManager.getDefaultSharedPreferences(this);
       // SharedPreferences.Editor editor6 = mPreferences6.edit();



        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();
        TestCountry = mPreferences.getString("country", "");
        editcity = mPreferences.getString("city", "");
        editstate = mPreferences.getString("state", "");
        kid = mPreferences.getString("has_kids", "");
        drink = mPreferences.getString("drink", "");
        smoker = mPreferences.getString("smoker", "");
        Path = mPreferences.getString("Path", "");
        hash_id = mPreferences.getString("hash_id", "");

        Log.v("TestCountry", TestCountry);
        Log.v("editcity", editcity);
        Log.v("editstate", editstate);
        Log.v("kid", kid);
        Log.v("drink", drink);
        Log.v("smoker", smoker);

        Log.v("log_tag","newpath123" + Path);
        final String available_for_saved = mPreferences.getString("available_for", "");
      final  String about_saved = mPreferences.getString("about", "");
        Log.v("about_saved:",available_for_saved);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




//            Log.v("firsttoken", token);
            //Log.v("firstmail", mail);

        }




        pd = new ProgressDialog(InformationActivity1.this);





        back = (Button) findViewById(R.id.textView1);

        radioCoffee=(RadioButton) findViewById(R.id.radioCoffee);
        radioDinner=(RadioButton) findViewById(R.id.radioDinner);
        radioDrinks=(RadioButton) findViewById(R.id.radioDrinks);
        radionight=(RadioButton) findViewById(R.id.radiokidno);



        if(available_for_saved.toLowerCase().contains("inne".toLowerCase()))
        {
            radioDinner.setChecked(true);
            type_date2="Dinner";
        }
        if(available_for_saved.toLowerCase().contains("rink".toLowerCase()))
        {
            radioDrinks.setChecked(true);
            type_date3="Drinks";
        }

        if(available_for_saved.toLowerCase().contains("offe".toLowerCase()))
        {
            radioCoffee.setChecked(true);
            type_date1="Coffee";
        }


        about_you= (EditText) findViewById(R.id.about_you);
        Log.v("about_saved:", about_saved);

        about_you.setText(about_saved);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(InformationActivity1.this,InformationActivity.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                //Log.i(TAG, "about_you" +   type_date);
                //Log.i(TAG, "editTextPassword3" +editTextPassword.getText().toString());

                // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });

        radioDinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioDinner.isChecked()){

                    type_date2="Dinner";
                    Log.v("date2:", type_date2);
                }


//typedate=type_date2+";";

            }
        });
        radioCoffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioCoffee.isChecked()){
                    type_date1="Coffee";
                    Log.v("date1:", type_date1);
                }

                // typedate=type_date1+";";


            }
        });
        radioDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radioDrinks.isChecked()){
                    type_date3="Drinks";
                    Log.v("date3:", type_date3);
                }


                // typedate=type_date3+";";

            }
        });

        radionight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( radionight.isChecked()){
                    //type_date="NightOut";
                }




            }
        });

        if(type_date1==null){
            type_date1="";
        }
        if(type_date2==null){
            type_date2="";
        }
        if(type_date3==null){
            type_date3="";
        }


        btn_confirm= (Button) findViewById(R.id.btn_confirm);

       /* btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(InformationActivity1.this,MainTest.class));


               startActivity(new Intent(InformationActivity1.this,WhatsApp.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
               // startActivity(new Intent(InformationActivity.this,MainActivity.class));
            }
        });*/
        final  SharedPreferences mPreferences1 = PreferenceManager.getDefaultSharedPreferences(this);


        btn_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               uploadVideo("test", Uri.parse(new File(Path).toString()));
               // changevideo();
              /*  if (!hash_id.equals("0"))
                {
                    changevideo();
                }*/
               /* Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                        if (!hash_id.equals("0"))
                        {
                            changevideo();
                        }
                    }
                }, 10000);*/
                /*if (!hash_id.equals("0"))
                {
                    changevideo();
                }*/

               // if( cvideo.toLowerCase().contains("The user information was saved!".toLowerCase()))


                String url = "http://api.dateinvite.com/users/save.json";


                makeRequest(url, new VolleyCallback() {
                    @Override
                    public void onSuccess(JSONObject result) throws JSONException {


                        Log.v("Responseip12:", respone_server);





                        if(foo==1)
                        {




                            Intent intent = new Intent(InformationActivity1.this,WhatsApp.class);

                            intent.putExtra("token", token);
                            intent.putExtra("mail",mail);
                            overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            startActivity(intent);

                            Toast.makeText(getApplicationContext(), " Successful",
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





                //changevideo();



            }
        });



       /* Bundle bundle = getIntent().getExtras();
        message = bundle.getString("message");
        editcity = bundle.getString("editcity");
       editstate = bundle.getString("editstate");
        kid = bundle.getString("kid");
         drink = bundle.getString("drink");
         smoker = bundle.getString("smoker");

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





    public void makeRequest( final String url, final VolleyCallback callback) {
        final ProgressDialog progressDialog = new ProgressDialog(InformationActivity1.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            typedate=type_date1+";"+type_date2+";"+type_date3+";";
            Log.v("typedate1", typedate);
            typedate= typedate.substring(0,  typedate.length() - 1);
            Log.v("typedate2", typedate);

           /* final String needle = ";";
            final int needleSize = needle.length();
           String first= typedate.substring(0, 1);
           if(first==";")
           {
               typedate = typedate.startsWith(needle) ? typedate.substring(needleSize) :typedate;

           }
           */
            typedate = new StringBuffer(typedate).reverse().toString();
            // typedate= typedate.substring(0,  typedate.length() - 1);
            typedate = new StringBuffer(typedate).reverse().toString();
            Log.v("typedate3", typedate);


            Log.v("TestCountry1", TestCountry);
            Log.v("editcity1", editcity);
            Log.v("editstate1", editstate);
            Log.v("kid1", kid);
            Log.v("drink1", drink);
            Log.v("smoker1", smoker);



            jsonBody.put("country",TestCountry);
            jsonBody.put("state",editstate);
            jsonBody.put("city",editcity);
            jsonBody.put("has_kids",kid);
            jsonBody.put("drink",drink);
            jsonBody.put("smoker",smoker);
            Log.v("newabout:", about_you.getText().toString());
            Log.v("newtype:", typedate);
            jsonBody.put("about",about_you.getText().toString());
            jsonBody.put("available_for",typedate);


            mEditor = mPreferences1.edit();

            mEditor.putString("about",about_you.getText().toString());
            mEditor.putString("available_for",typedate);

            mEditor.commit();


        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.v("Response", response.toString());


                try {
                    respone_server = response.getString("response");

                    Log.v("Responseip:", respone_server);
                    //  token=response.getJSONObject("user").getString("token");
                    foo = Integer.parseInt(respone_server);
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


    private void uploadVideo(String name, Uri videoUri) {
        final Context context = getApplicationContext();

        // loading = ProgressDialog.show(this, "Uploading...", "Please wait...", false, false);

        int size = 1024 * 1024 * 5;
        byte[] bytes = BytesUtils.getBytesFromVideoUri(context, videoUri);

        List<SplitBytes.Bytes> array = null;
        if (bytes != null && bytes.length > 0) {
            array = SplitBytes.getBytesForPart(bytes, size);
        }

        Log.v("log_tag","name:" +name);

        Log.v("log_tag","array:" +array);

        uploadVideo(name, 0, array);

    }

    private void uploadVideo(final String title, final int part, final List<SplitBytes.Bytes> array) {
       final ProgressDialog progressDialog = new ProgressDialog(InformationActivity1.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();
        if (array == null || array.size() <= part) {
            //loading.dismiss();
            return;
        }

        final Multipart multipart = new Multipart(getApplicationContext());

        multipart.addParam("title", title);
        multipart.addParam("chunk", "" + (part+1));
        multipart.addParam("chunks", "" + array.size());
        Log.d(TAG, "number:" + part);
        SplitBytes.Bytes bytes = array.get(part);
        multipart.addFile("video/mp4", "myfile", "video", bytes.getBytes());

        multipart.launchRequest(UPLOAD_URL, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                //  progressDialog.dismiss();
                String resultResponse = new String(response.data);

                Log.d(TAG, "" + resultResponse);

                Toast.makeText(getApplicationContext(), resultResponse,
                        Toast.LENGTH_LONG).show();

                try {
                    JSONObject obj = new JSONObject(resultResponse);
                    Log.d(TAG, "Response22:" + resultResponse);
                    Toast.makeText(getApplicationContext(), resultResponse,
                            Toast.LENGTH_LONG).show();
                    // JSONObject object = new JSONObject(json);
                    hash_id = obj.getString("hashed_id");
                    Log.v("hashed_id1:",  hash_id);
                   /* Toast.makeText(getApplicationContext(), hash_id,
                            Toast.LENGTH_LONG).show();*/

                    changevideo();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "JSON Error: " + e);

                }

                uploadVideo(title, part+1, array);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //  progressDialog.dismiss();
                //loading.dismiss();
            }
        });
    }

    public void changevideo()
    {
        final ProgressDialog progressDialog = new ProgressDialog(InformationActivity1.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        Toast.makeText(getApplicationContext(), hash_id,
                Toast.LENGTH_LONG).show();


        String url_like = "http://api.dateinvite.com/users/save.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            Log.v("hash_id123:", hash_id);
            jsonBody = new JSONObject();
            jsonBody.put("video",hash_id);



        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.v("Responsevideochange:", response.toString());


                cvideo=response.toString();

                Toast.makeText(getApplicationContext(), response.toString(),
                        Toast.LENGTH_LONG).show();

                try {





                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Log.v("Responsephotos", error.toString());
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
                //String creds = String.format("%s:%s","and5@test.com","123123");
                // Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                //  Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                // String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
               // Log.i(TAG, "mails:" +   email_saved);
               // Log.i(TAG, "tokens:" +  token_saved);

                //String creds = String.format("%s:%s","t2@test.com","15ab5efa606ea9f5002f206c0af2046f");
             //   String creds = String.format("%s:%s",email_saved,token_saved);
                String creds = String.format("%s:%s", mail,token);
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

        //}






    }
}


