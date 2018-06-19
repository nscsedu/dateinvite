package com.braincraft.social.dateinvite.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Base64;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.dateinvite.Login;
import com.braincraft.social.dateinvite.Privacy;
import com.braincraft.social.dateinvite.R;
import com.braincraft.social.dateinvite.RegistarActivity;
import com.braincraft.social.dateinvite.SelectInterest;
import com.braincraft.social.dateinvite.Terms;
import com.braincraft.social.dateinvite.VolleyCallback;
import com.braincraft.social.dateinvite.VolleyController;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.braincraft.social.activity.chatmessage.name11;


/**
 * Created by Anu on 22/04/17.
 */



public class FragmentRegister extends Fragment {
    private Button btnSkip, btnlogin_submit,registration_submit;
    private static final String TAG = "MyActivity";
    private EditText editTextUserName,editTextEmail,editTextPassword,editTextday,editTextmonth,editTextyear;
    private ProgressDialog pd;
    private static final String URL_REGISTER = "http://173.212.223.213/scouts/api/appusers/";
    TextView terms,privacy;
    int flagstate=1;
    TextView  txtData;
    private  String token,dob;

    int useravailable;

    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    String username,password;
    int foo,emailpassflag=0;

    String respone_server,response_message;
    View view;
    // Button secondButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.reg, container, false);



        txtData=(TextView)view.findViewById(R.id.read);

        SpannableString spannableString = new SpannableString("By choosing to continue,i certify i am atleast 18 years old and i have read and agree to The  DateInvite Terms and Conditions and Privacy Policy");
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //startActivity(new Intent(RegistarActivity.this, com.braincraft.social.activity.Terms.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(true);
                ds.setColor(Color.parseColor("#0000FF"));
            }
        };

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                //startActivity(new Intent(RegistarActivity.this, com.braincraft.social.activity.Privacy.class));
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                ds.setUnderlineText(true);
                ds.setColor(Color.parseColor("#0000FF"));
            }
        };

        spannableString.setSpan(clickableSpan,105,125, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(clickableSpan1,130,144, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //spannableString.setSpan(new StyleSpan(Typeface.BOLD),6,10,0);

        txtData.setText(spannableString);
        txtData.setMovementMethod(LinkMovementMethod.getInstance());

        txtData.setHighlightColor(Color.TRANSPARENT);




       // gestureDetector = new GestureDetector(RegistarActivity.this, RegistarActivity.this);

       // pd = new ProgressDialog(RegistarActivity.this);
        editTextUserName= (EditText) view.findViewById(R.id.editTextUserName);

        editTextEmail = (EditText) view.findViewById(R.id.editTextEmail);

        editTextPassword = (EditText) view.findViewById(R.id.editTextPassword);

        editTextUserName = (EditText) view.findViewById(R.id.editTextUserName);



        editTextyear = (EditText) view.findViewById(R.id.year);
        editTextmonth = (EditText) view.findViewById(R.id.month);
        editTextday = (EditText) view.findViewById(R.id.day);

        dob= editTextyear.getText().toString()+"-"+editTextmonth.getText().toString()+"-"+editTextday.getText().toString();

        registration_submit=(Button) view.findViewById(R.id.registration_submit);

        Log.i(TAG, "year:" +    editTextyear.getText());
        Log.i(TAG, "month:" + editTextmonth.getText().toString());
        Log.i(TAG, "day:" +editTextday.getText().toString());

        Log.i(TAG, "dob:" +dob);






        btnlogin_submit = (Button) view.findViewById(R.id.login_submit);

        btnlogin_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(getActivity(), Login.class);
                getActivity().startActivity(myIntent);
                //getActivity().finish();
                //startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
                /*Toast.makeText(getActivity(), "Login Successful",
                        Toast.LENGTH_LONG).show();*/

            }
        });



        terms = (TextView) view.findViewById(R.id.terms);

        privacy = (TextView) view.findViewById(R.id.privacy);



        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
              /*  startActivity(new Intent(RegistarActivity.this,Terms.class));


                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

               /* Intent myIntent = new Intent(getActivity(), Terms.class);
                getActivity().startActivity(myIntent);*/
                Intent myIntent = new Intent(getActivity(), Terms.class);
                getActivity().startActivity(myIntent);


               /* Intent intent = new Intent(getActivity(),Terms.class);


                //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);*/
                Toast.makeText(getActivity(), "Terms Successful",
                        Toast.LENGTH_LONG).show();

            }
        });

        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
              /*  startActivity(new Intent(RegistarActivity.this,Privacy.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/
               /* Intent myIntent = new Intent(getActivity(), Privacy.class);
                getActivity().startActivity(myIntent);*/
                Intent myIntent = new Intent(getActivity(), Terms.class);
                getActivity().startActivity(myIntent);



               /* Intent intent = new Intent(getActivity(),Privacy.class);


                //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);*/
                Toast.makeText(getActivity(), "Privacy Successful",
                        Toast.LENGTH_LONG).show();
            }
        });
        registration_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // editTextPassword = (EditText) findViewById(R.id.editTextPassword);

                if (TextUtils.isEmpty( editTextPassword.getText().toString().trim())) {
                    editTextPassword.setError("Please enter your Name");
                    editTextUserName.requestFocus();
                    return;
                }


                if (TextUtils.isEmpty( editTextUserName.getText().toString().trim())) {
                    editTextUserName.setError("Please enter your Name");
                    editTextUserName.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
                    editTextEmail.setError("Please enter your Email ID");
                    editTextEmail.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty( editTextyear.getText().toString().trim())) {
                    editTextyear.setError("Please enter your Birth Year");
                    editTextyear.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty( editTextmonth.getText().toString().trim())) {
                    editTextmonth.setError("Please enter your Birth Month");
                    editTextmonth.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty( editTextday.getText().toString().trim())) {
                    editTextday.setError("Please enter your Birth Day");
                    editTextday.requestFocus();
                    return;
                }


                //checkusername();

                // ProgressDialog progressDialog = new ProgressDialog(this , R.style.MyAlertDialogStyle);

                checkusername();

                String url = "http://api.dateinvite.com/users/register.json";


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



                            Intent intent = new Intent(getActivity(),SelectInterest.class);

                            intent.putExtra("token", token);
                            intent.putExtra("mail",editTextEmail.getText().toString());
                          //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                            startActivity(intent);
                            Toast.makeText(getActivity(), "Registration Successful",
                                    Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getActivity(), "Email exists",
                                    Toast.LENGTH_LONG).show();

                            if(emailpassflag==1)
                            {
                                Toast.makeText(getActivity(), "Wrong Email",
                                        Toast.LENGTH_LONG).show();
                            }
                            else if(emailpassflag==2)
                            {
                                Toast.makeText(getActivity(), "Wrong Password",
                                        Toast.LENGTH_LONG).show();
                            }

                        }


                    }

                    @Override
                    public void onError(String result) throws Exception {

                      /*  Toast.makeText(getActivity(), "Oops!!",
                                Toast.LENGTH_LONG).show();*/

                    }
                });
            }
        });



        return view;
    }



    public void makeRequest( final String url, final VolleyCallback callback) {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity(),R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();




            Log.v("name:",editTextUserName.getText().toString());
            Log.v("birthday:",dob);

            jsonBody.put("name",editTextUserName.getText().toString());
            //jsonBody.put("birthday",dob);

            jsonBody.put("birthday",editTextyear.getText().toString()+"-"+editTextmonth.getText().toString()+"-"+editTextday.getText().toString());

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){

            @Override
            public void onResponse(JSONObject response) {

                Log.v("Responsereg", response.toString());

                progressDialog.dismiss();
                try {
                    respone_server = response.getString("response");

                    Log.v("Responseip:", respone_server);
                    if(respone_server.equals("0"))
                    {
                        Toast.makeText(getActivity(), "Email exists",
                                Toast.LENGTH_LONG).show();
                    }
                    token=response.getJSONObject("user").getString("token");


                    mPreferences = android.preference.PreferenceManager.getDefaultSharedPreferences(getActivity());

                    mEditor = mPreferences.edit();

                    mEditor.putString("username",response.getJSONObject("user").getString("username"));
                    mEditor.putString("photo",response.getJSONObject("user").getString("photo"));
                    Log.v("Responseuser", response.getJSONObject("user").getString("username"));

                    mEditor.commit();


                    foo = Integer.parseInt(respone_server);
                    if(foo!=1)
                    {
                        Toast.makeText(getActivity(), "Email exists",
                                Toast.LENGTH_LONG).show();
                        response_message= response.getString("msg");
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
                        Log.v("Response", error.toString());
                        progressDialog.dismiss();
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
                Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);



                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name",   editTextUserName.getText().toString());
                params.put("birthday", "1990-01-01");
                return params;
            }



        };
        // rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getActivity()).addToRequestQueue(rq);

    }




    void checkusername()
    {







        String url_like = "http://api.dateinvite.com/users/check_username.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            jsonBody.put("username", editTextUserName.getText().toString());
            // Log.i(TAG, "sendid:" +id);
            //  jsonBody.put("user",id);

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {

                Log.v("Responseuser", response.toString());

                if (response.toString().toLowerCase().contains("0"))
                {
                    Toast.makeText(getActivity(), "The username is already taken!",
                            Toast.LENGTH_LONG).show();
                }

                try {

                    // respone_server = response.getString("msg");
                    String respone_user = response.getString("response");
                    Log.v("respone_user", respone_user);
                    Log.v("Response_Like", respone_server);
                     useravailable = Integer.parseInt(respone_server);
                    Log.v("useravailable",respone_server);
                    String sresponse="0";
                    Log.v("sresponse123",sresponse);
                    if(respone_user.equals(sresponse))
                    {

                        Toast.makeText(getActivity(), "The username is already taken!",
                                Toast.LENGTH_LONG).show();

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

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                Log.i(TAG, "editTextEmai4:" +    editTextEmail.getText().toString());
                Log.i(TAG, "editTextPassword4:" +editTextPassword.getText().toString());
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                // String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
                //String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                // String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                // params.put("Authorization", auth);
                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }

        };
        // rq.setPriority(Request.Priority.HIGH);
        com.braincraft.social.activity.VolleyController.getInstance(getActivity()).addToRequestQueue(rq);

        //}







    }
}