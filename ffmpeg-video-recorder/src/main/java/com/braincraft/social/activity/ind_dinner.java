package com.braincraft.social.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.braincraft.social.activity.InviteNew1.id;

/**
 * Created by User on 5/1/2018.
 */

public class ind_dinner extends AppCompatActivity {
    private Button submit, btnlogin_submit, sendinvitation;
    private EditText invitemessage;
    private static final String TAG = "MyActivity";
    public int message=6;
    public static String search;
    public static  String token;
    public static   String mail;
    String sendstring="[invite-dinner-en]\n";
    // public String str_id;
    //public int id=0;
    public String str_id,respone_server;
    // ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ind_dinner);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            search = bundle.getString("search");

            token = bundle.getString("token");

            mail = bundle.getString("mail");
//           str_id = bundle.getString("id");

        }

        Log.v("jsearch", search);
        Log.v("jtoken ",  token );
        Log.v("jmaile", mail);

        // id=Integer.parseInt(str_id);




        invitemessage=(EditText) findViewById(R.id.invitedinner);

        sendinvitation=(Button) findViewById(R.id.sendinvitation);
      /*  viewPager = (ViewPager) findViewById(R.id.viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);*/

      /*  Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");

        Log.i(TAG, "message123:" + message);*/


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Invite:androidtest");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               /* startActivity(new Intent(IndividualInvitation.this,Interaction.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                Intent intent = new Intent(ind_dinner.this, Interaction.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);



        sendinvitation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){




                String url_invite = "http://api.dateinvite.com/messages/create.json";


                //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody = new JSONObject();
                    // jsonBody.put("user", 9606); {"message":"message invitation", "to":"12155", "invite":"1"}
                    Log.i(TAG, "sendid:" +id);
                    Log.i(TAG, "sendmessage:" +invitemessage.getText().toString());
                    Log.v("invitemessage:",invitemessage.getText().toString());
                    Log.v("new_token:",token);
                    sendstring=sendstring+invitemessage.getText().toString();
                    Log.i(TAG, "sendmessage:" +sendstring);
                    // jsonBody.put("message",invitemessage.getText().toString());
                    jsonBody.put("message", sendstring);
                    jsonBody.put("to",id);
                    jsonBody.put("invite",1);

                } catch (Exception ex){
                    Log.v("", "ERROR: "+ex.getMessage());
                }

                JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_invite,jsonBody, new Response.Listener<JSONObject>(){
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
                        String creds = String.format("%s:%s",mail,token);
                       // String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
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

                Intent intent = new Intent(ind_dinner.this, InviteNew1.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        });
       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Privacy.this,HomeActivity.class));
            }
        });*/



    }




}
