package com.braincraft.social.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 25/4/2018.
 */

public class chatmessage extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator1 p = new Paginator1();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    public String new_token2,new_mail2;
    final Context context = this;
    public  int itemcount=0;

    private ImageView sendmessage;


    //  public static  ArrayList<String> image_list;

    public static  ArrayList<String> image_list = new ArrayList<String>();


    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;
    private LinearLayout messages,videomessages,likedme,liked,contact_admin,colombia,colombia1,usa,usa1,brazil,brazil1,lrv,cardrv,canada1,canada;
    private ImageView likedandme,normalmessage,videomessage,goprofile,col2;
    private TextView go,editprofile,col1,col3,contactad;
    private CardView card_view;
    private  EditText chat_message;

private TextView userid;
    public  static ArrayList<String> ImgUrl1= new ArrayList<>();
    // public static  JSONObject elem;
//public static String city;
    public static  ArrayList<String> name_list = new ArrayList<String>();
    public static   String[] city_list;
    //public static   String[] name_list;
    public static int Dinner=0,Drinks=0,Coffee=0;
    int k=0;
    public static String[] myArray = new String[20];
    int foo,emailpassflag=0;
    private EditText editTextEmail,editTextPassword;
    String username,password,useridstr;
    public static int sendid=0;
    private static final String TAG = "MyActivity";
    String respone_server,response_message,Available,response_from_server;

    private JSONArray result;
    public static String location;

    public static   String token;
    public static  String mail;
    public static String tmp_username;

    List<MessageModel> MessageModelList;
    ListView MessageListView;

    public static  String[] name1={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
    ,"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
    ,"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"};
    public static  String[] name11={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
    ,"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"};

    public static  String[] city1={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
    ,"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"};

    public static String[] age1_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static  String[] message={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static String[] date_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};


    private int preflag=0,nextflag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar7);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);



       userid = (TextView) toolbar.findViewById(R.id.username);


        // setSupportActionBar(toolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
              /*  startActivity(new Intent(Page_Activity1.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



               /* Intent intent = new Intent(Page_Activity2.this,Page_Activity.class);

                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();*/




                Intent intent = new Intent(chatmessage.this,Page_Activity1.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);

       final ScrollView  scroll=(ScrollView) findViewById(R.id.messagelist);
        scroll.fullScroll(View.FOCUS_DOWN);

        scroll.post(new Runnable() {
            public void run() {
                scroll.fullScroll(View.FOCUS_DOWN);
            }
        });

        //RFERENCE VIEWS
        rv = (RecyclerView) findViewById(R.id.rv);

        firstpage = (Button) findViewById(R.id.firstpage);

        sendmessage = (ImageView) findViewById(R.id.sendmessage);

         chat_message=(EditText) findViewById(R.id.chat_message);


       /* Toast.makeText(getApplicationContext(), "ChatMessage!!",
                Toast.LENGTH_LONG).show(); firstpage = (Button) findViewById(R.id.firstpage);*/

        sendmessage = (ImageView) findViewById(R.id.sendmessage);

        chat_message=(EditText) findViewById(R.id.chat_message);


       /* Toast.makeText(getApplicationContext(), "ChatMessage!!",
                Toast.LENGTH_LONG).show();*/


        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");

            useridstr = bundle.getString("search");
           username = bundle.getString("username");
        }

        userid.setText(username);
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/





        sendid=  Integer.parseInt(useridstr);





        sendmessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){




messagecreate();
                //}

               /* Intent intent = new Intent(chatmessage.this,chatmessage.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();*/
              /* Intent intent = getIntent();
                finish();
                startActivity(intent);*/
              restart();

            }
        });


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        //  SharedPreferences.Editor editor = pref.edit();

        new_token2=pref.getString("token_key", null);
        new_mail2=pref.getString("mail_key", null);


        /*
         final LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
   layoutManager.setStackFromEnd(true);
   recyclerView.setLayoutManager(layoutManager);
         */


        final LinearLayoutManager layoutManager = new LinearLayoutManager(chatmessage.this);
      //  layoutManager = new GridLayoutManager(chatmessage.this, 1);

      //  layoutManager.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
//        layoutManager.setStackFromEnd(true);
       // layoutManager.setReverseLayout(true);
       layoutManager.setStackFromEnd(true);
        rv.setLayoutManager(layoutManager);

       // rv.setStackFromEnd(true);

//        rv.smoothScrollToPosition(rv.getAdapter().getItemCount());


        String url_like = "http://api.dateinvite.com/messages/chat.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
           // jsonBody.put("user", 7921);
            Log.i(TAG, "sendid:" +sendid);
           // Log.v("sendid:",useridstr);
            jsonBody.put("user",sendid);
            //sendid=0;

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {

                Log.v("Responsechatlist", response.toString());




                try {
                    JSONArray list = response.getJSONArray("messages");

                    respone_server = response.getString("messages");
                    Log.v("Response_Like", respone_server);


                    if(list != null){

                        //  for(int i = 0; i <=1;i++){
                        for(int i = 0; i < list.length();i++){
                            // JSONObject object = jarray.getJSONObject(i);

                            //  String username1= object.getString("username");

                            //   Log.v(" username1:",  username1);


                            JSONObject elem = list.getJSONObject(i);

                            Log.v("message22:", elem.getString("message"));

                            Log.v("date22:", elem.getString("date"));
                            name11[itemcount]= elem.getString("message");

                            date_list[itemcount]=elem.getString("date");

                           // city1[itemcount]= elem.getString("user");
                           // Log.v("user123:", city1[itemcount]);

                            JSONObject parentObject = new JSONObject(elem.getString("user"));

                            Log.v("id11:", parentObject.getString("id"));
                            city1[itemcount]= parentObject.getString("id");
                           // Log.v("user123:", elem.getString(city1[itemcount]));
                           // JSONArray list1 = response.getJSONArray("messages");

                           /* JSONParser parser = new JSONParser();
                            JSONObject jsonuser = (JSONObject) parser.parse(city1[itemcount]);
                            Log.v("use23:",  jsonuser.getString("id"));*/
                           // Log.v("user123:", city1[itemcount].getString("user"));
                         //  userid.setText(elem.getString("username"));

                            itemcount++;




                        }
                        rv.setAdapter(new MyAdapter7(chatmessage.this, p.generatePage(currentPage),ImgUrl1,itemcount));

                        rv.scrollToPosition(itemcount);
                        // rv.smoothScrollToPosition(rv.getAdapter().getItemCount());

                       // recyclerView.scrollToPosition(itemcount;

                        //rv.smoothScrollToPosition(itemcount);

                       // recyclerView.smoothScrollToPosition(15);
                        //adapter.notifyDataSetChanged();
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
                Log.v("mailResponse", mail);
                Log.v("tokenResponse", token);
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");useridstr
                 String creds = String.format("%s:%s",mail,token);
                // String creds = String.format("%s:%s",mail,token);
              //  String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                //String creds = String.format("%s:%s","t1@test.com","da6f885eb0d26f06ecc8c6021924c94d");
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

    private void toggleButtons() {
        if (currentPage == totalPages) {
            nextBtn.setEnabled(false);
            prevBtn.setEnabled(true);
        } else if (currentPage == 0) {
            prevBtn.setEnabled(false);
            nextBtn.setEnabled(true);
        } else if (currentPage >= 1 && currentPage <= totalPages) {
            nextBtn.setEnabled(true);
            prevBtn.setEnabled(true);
        }
    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(MainTest.this,PushNotification.class));

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }*/
        /*else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

public void restart()
{


   /* Intent intent = getIntent();
    overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
    finish();
    startActivity(intent);*/
      Intent intent = new Intent(chatmessage.this,chatmessage.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);

                intent.putExtra("search",useridstr);
                intent.putExtra("username",username );


                startActivity(intent);
    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

}

public void messagecreate()
    {

        String url_like = "http://api.dateinvite.com/messages/create.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            jsonBody.put("message", chat_message.getText().toString());
            Log.i(TAG, "sendmessage:" +chat_message.getText().toString());
            Log.i(TAG, "sendid1:" +sendid);
            jsonBody.put("to",sendid);

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

                    response_from_server = response.getString("response");
                    Log.v("Response_chat:", respone_server);
                    Log.v(" response_from_server:", response_from_server);
                    foo = Integer.parseInt(response_from_server);
                   // foo=0;

                    if(foo!=1)
                    {
                        Intent intent = new Intent(chatmessage.this,Testcrop2.class);

                     /*   useridstr = bundle.getString("search");
                        username = bundle.getString("username");*/


                        intent.putExtra("token", token);
                        intent.putExtra("mail",mail);
                        intent.putExtra("search",useridstr);
                        intent.putExtra("username",username);
                        overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                        startActivity(intent);
                        finish();
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
                Log.v("mailResponse", mail);
                Log.v("tokenResponse", token);
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                String creds = String.format("%s:%s",mail,token);
                //String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
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