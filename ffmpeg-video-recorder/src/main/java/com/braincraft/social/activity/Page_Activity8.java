package com.braincraft.social.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 10/6/2018.
 */

public class Page_Activity8 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator1 p = new Paginator1();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    public String new_token4,new_mail4;
    final Context context = this;
    public  int itemcount=0;
    //  public static  ArrayList<String> image_list;

    public static ArrayList<String> image_list = new ArrayList<String>();
  //  private static final String TAG = "MyActivity";
    private SharedPreferences mPreferences1;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;

    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;
    private LinearLayout messages,videomessages,likedme,liked,contact_admin,colombia,colombia1,usa,usa1,brazil,brazil1,lrv,cardrv,canada1,canada;
    private ImageView likedandme,normalmessage,videomessage,goprofile,col2;
    private TextView go,editprofile,col1,col3,contactad;
    private CardView card_view;


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
    String username,password;
    private static final String TAG = "MyActivity";
    String respone_server,response_message,Available, email_saved, token_saved;;
    public static Uri uri;
    private JSONArray result;
    public static String location;

    String token;
    String mail;
    String videoid;
    public static String tmp_username;

    List<MessageModel> MessageModelList;
    ListView MessageListView;

    public static  String[] name1={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
            ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};

    public static  String[] city1={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};

    public static String[] age1_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static  String[] message={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
            ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static String[] date_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static  String[] video_url={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"
            ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static String[] uri_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static String[] video_count={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static int[] video_list2={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

    private int preflag=0,nextflag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar8);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();

        mail = mPreferences.getString("mail", "");
        token = mPreferences.getString("token", "");
        videoid = mPreferences.getString("videoid", "");


       /* token=pref.getString("token", null);
        mail=pref.getString("mail", null);
        videoid=pref.getString("videoid", null);

        email_saved = mPreferences.getString("email", "");
        token_saved = mPreferences.getString("token", "");
        Log.v("1token", token_saved);
        Log.v("1mail",  email_saved);*/

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




                Intent intent = new Intent(Page_Activity8.this,Page_Activity4.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
              //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();


            }
        });

        toolbar.setNavigationIcon(R.drawable.back_icon);

        //RFERENCE VIEWS
        rv = (RecyclerView) findViewById(R.id.rv);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        prevBtn = (Button) findViewById(R.id.prevBtn);
        // card_view = (CardView) findViewById(R.id.card_view);



        firstpage = (Button) findViewById(R.id.firstpage);



        Bundle bundle = getIntent().getExtras();

       /* if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
            videoid = bundle.getString("videoid");
        }*/

       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/

//        Log.v("token5:",token);
       // Log.v("mail15:",mail);34

       // Log.v("videoid34:",videoid);

       /* SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        //  SharedPreferences.Editor editor = pref.edit();

        new_token4=pref.getString("token_key", null);
        new_mail4=pref.getString("mail_key", null);*/

        /*SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();
        token=pref.getString("token", null);
        mail=pref.getString("mail", null);
        videoid=pref.getString("videoid", null);*/
        //  Log.v("new_token4:",new_token4);
        // Log.v("new_mail4:",new_mail4);




        prevBtn.setVisibility(View.GONE);
        prevBtn.setEnabled(false);



        layoutManager = new GridLayoutManager(Page_Activity8.this, 1);
        rv.setLayoutManager(layoutManager);

       /* DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        //RECYCLER PROPERTIES
        //  rv.setLayoutManager(new LinearLayoutManager(this));

        //ADAPTER
        //   rv.setAdapter(new MyAdapter1(Page_Activity1.this, p.generatePage(currentPage)));




        // View header = navigationView.getHeaderView(0);


        String url = "http://api.dateinvite.com/videos/view.json";

        makeRequest(url, new VolleyCallback() {
            @Override
            public void onSuccess(JSONObject result) throws JSONException {


                Log.v("Responseip123:", respone_server);


                int foo = Integer.parseInt(respone_server);
                //  Log.v("Responseip12:", foo);
                //if(respone_server.equals(1))
                if(foo==1)
                {

                           /* Toast.makeText(getApplicationContext(), "Fetch Successful",
                                    Toast.LENGTH_LONG).show();*/
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





        firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity8.this, Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });



        //NAVIGATE
        // if (MyAdapter.j < 18)
        // {

        if(currentPage==0)
        {
            Log.i(TAG, "cur1:" + currentPage);
            prevBtn.setVisibility(View.GONE);
        }
        else
        { Log.i(TAG, "cur2:" + currentPage);
            prevBtn.setVisibility(View.VISIBLE);
        }



        if(currentPage==2)
        { Log.i(TAG, "cur3:" + currentPage);
            nextBtn.setVisibility(View.GONE);
        }
        else
        { Log.i(TAG, "cur4:" + currentPage);
            nextBtn.setVisibility(View.VISIBLE);
        }
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevBtn.setVisibility(View.VISIBLE);

                currentPage += 1;
                // enableDisableButtons();
                // rv.setAdapter(new MyAdapter4(Page_Activity4.this, p.generatePage(currentPage),ImgUrl1));
                toggleButtons();

            }
        });
        // }
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

                //rv.setAdapter(new MyAdapter4(Page_Activity4.this, p.generatePage(currentPage),ImgUrl1));

                toggleButtons();
            }
        });


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
    public void makeRequest( final String url, final VolleyCallback callback) {
        Log.v("Response_123", "123");
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
           // Log.i(TAG, "sendid:" +id);Integer.parseInt(position)
            //jsonBody.put("user",8581);
            jsonBody.put("user",videoid);
            Log.v("videoid78", videoid);
           // Log.v("jsonBody",jsonBody);
        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST, url,jsonBody, new Response.Listener<JSONObject>(){

            @Override
                    public void onResponse(JSONObject response) {

                        Log.v("Response_allvideo", response.toString());
                        JSONObject jsonObject = null;









                        try {

                            respone_server = response.getString("response");


                            JSONArray list = response.getJSONArray("videos");
                            ArrayList<AndroidVersion> android_version = new ArrayList<>();

                            if(list != null){

                                for(int i = 0; i < list.length();i++){


                                    JSONObject elem = list.getJSONObject(i);

                                   /* message[k]=elem.getString("date");
                                    Log.v("id1:", elem.getString("id"));

                                    Log.v("user2:", elem.getString("user"));

                                    Log.v("date2:", elem.getString("date"));

                                    date_list[k]=elem.getString("date");
                                    video_count[k]="Messages received:"+elem.getString("video_count");*/
                                    message[k]=elem.getString("date");
                                    uri_list[k]=elem.getString("video");
                                    Log.v("video_play:", elem.getString("video"));
                                    uri = Uri.parse(elem.getString("video"));
                                    String stringUri;
                                    stringUri = uri.toString();
                                   video_url[k]=stringUri;
                                    Log.v("date22:", elem.getString("date"));
                                    String user1= elem.getString("user");

                                    //Log.v("user12:", user1);
                                  //  Log.v("videocount:", video_count[k]);



                                    JSONObject parentObject = new JSONObject(user1);

                                   // Log.v("age2:", parentObject.getString("age"));
                                  // Log.v("username2:", parentObject.getString("username"));
                                    location= parentObject.getString("city")+"  "+parentObject.getString("country");
                                   Log.v("location11:", location);
                                    city1[k]= location;
                                    String tmp=parentObject.getString("username")+"  "+parentObject.getString("age")+"y";
                                    Log.v("tmp22:", tmp);
                                    name1[k]= tmp;
                                    String url= parentObject.getString("photo");

                                    image_list.add(url);

                                    ImgUrl1.add(url);

                                  /*  Log.v("city2:", parentObject.getString("city"));
                                    Log.v("country2:", parentObject.getString("country"));
                                    Log.v("state2:", parentObject.getString("state"));
                                    Log.v("age2:", parentObject.getString("age"));

                                    Log.v("photo2:", parentObject.getString("photo"));

                                    String url= parentObject.getString("photo");

                                    image_list.add(url);

                                    ImgUrl1.add(url);

                                    location= parentObject.getString("city")+"  "+parentObject.getString("country");
//                                    Log.v("location1:", location);
                                    String country=parentObject.getString("country");
                                    Log.v("country22:", country);
                                    city1[k]= location;
                                    // age1_list[k]= parentObject.getString("age");
                                    String tmp=parentObject.getString("username")+"  "+parentObject.getString("age")+"y";
                                    Log.v("tmp2:", tmp);
                                    name1[k]= tmp;
                                    Log.v("name1[k]", name1[k]);
                                    k++;*/

                                    k++;
                                    itemcount++;




                                }
                                rv.setAdapter(new MyAdapter8(Page_Activity8.this, p.generatePage(currentPage),ImgUrl1,itemcount));



                            }



//                            response.getString("users");
                            // Log.v("users22",response.getString("users"));
                            // Log.v("Responseip2:", respone_server);
                            foo = Integer.parseInt(respone_server);
                            if(foo!=1)
                            { response_message= response.getString("msg");
                                Log.v("Response2", response_message);

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
                        Log.v("Response214", error.toString());
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
//                Log.v("token61:",token);
              // Log.v("mail161:",mail);
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                //String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");

                String creds = String.format("%s:%s", mail,token);
                //String creds = String.format("%s:%s", email_saved,token_saved);
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
        //rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }

}