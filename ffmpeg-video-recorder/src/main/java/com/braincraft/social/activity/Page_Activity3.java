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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.braincraft.social.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 25/4/2018.
 */

public class Page_Activity3 extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator1 p = new Paginator1();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    public String new_token3,new_mail3;
    final Context context = this;
    public  int itemcount=0;
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
    String respone_server,response_message,Available;

    private JSONArray result;
    public static String location;

    public static  String token;
    public static String mail;
    public static String tmp_username;

    List<MessageModel> MessageModelList;
    ListView MessageListView;

    public static  String[] name1={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};
    public static  String[] name11={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};

    public static  String[] city1={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"};

    public static String[] age1_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    public static  String[] message={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};
    public static String[] date_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};


    private int preflag=0,nextflag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar4);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);






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




                Intent intent = new Intent(Page_Activity3.this,Page_Activity.class);
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

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
        }
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/

        Log.v("token5:",token);
        Log.v("mail15:",mail);


        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        //  SharedPreferences.Editor editor = pref.edit();

        new_token3=pref.getString("token_key", null);
        new_mail3=pref.getString("mail_key", null);

       // Log.v("new_token3:",new_token3);
       // Log.v("new_mail3:",new_mail3);






        prevBtn.setVisibility(View.GONE);
        prevBtn.setEnabled(false);



        layoutManager = new GridLayoutManager(Page_Activity3.this, 1);
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
      /*  settings = (ImageView) header.findViewById(R.id.settings);
        messages = (LinearLayout) header.findViewById(R.id.messages);
        lrv = (LinearLayout) findViewById(R.id.lrv);
        cardrv = (LinearLayout) findViewById(R.id.cardrv);

        liked = (LinearLayout) header.findViewById(R.id.liked);
        likedme = (LinearLayout) header.findViewById(R.id.likedme);
        videomessages = (LinearLayout) header.findViewById(R.id.videomessages);
        editprofile = (TextView) header.findViewById(R.id.editprofile);

        normalmessage = (ImageView) toolbar.findViewById(R.id.normalmessage);
        videomessage = (ImageView) toolbar.findViewById(R.id.videomessage);
        likedandme = (ImageView) toolbar.findViewById(R.id.likedandme);
        goprofile = (ImageView) toolbar.findViewById(R.id.goprofile);
        go = (TextView) header.findViewById(R.id.go);*/

        String url = "http://api.dateinvite.com/likes/liked_me.json";
        // String url = "http://api.dateinvite.com/messages.json";
        // final TextView txtView = (TextView) findViewById(R.id.textView3);
        //assert txtView != null;
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




        /*settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, SettingsActivity.class));
                //startActivity(new Intent(Page_Activity.this, AndroidListViewActivity.class));
                //startActivity(new Intent(Page_Activity.this, ListDisplay.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/

      /*  messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, MessageText.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        likedme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, LikedMe.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, Liked.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                // startActivity(new Intent(MainTest.this,Invite.class));
                finish();
            }
        });

        videomessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, VideoMessage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });*/

        /*editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, Testcrop1.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });*/



      /*  go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity1.this, Invite.class));
                // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition( R.anim.slide_up_animation,R.anim.slide_down_animation);
                finish();

            }
        });*/

      /*  lrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity1.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        cardrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity1.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/
      /* card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/

      /*  rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity1.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/




      /*  videomessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, VideoMessage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        normalmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, MessageText.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        likedandme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(Page_Activity1.this, LikedMe.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        goprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity1.this, Filter.class));
                overridePendingTransition( R.anim.slide_up_animation,R.anim.slide_down_animation);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });*/

        firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity3.this, Page_Activity.class));
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
               // rv.setAdapter(new MyAdapter3(Page_Activity3.this, p.generatePage(currentPage),ImgUrl1));
                toggleButtons();

            }
        });
        // }
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

               // rv.setAdapter(new MyAdapter3(Page_Activity3.this, p.generatePage(currentPage),ImgUrl1));

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

        CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.v("Response_liked", response.toString());
                        JSONObject jsonObject = null;


                      /*  try
                        {
                            JSONObject jsono = new JSONObject(data);
                            JSONArray jarray = jsono.getJSONArray("posts");

                            for (int i = 0; i < jarray.length(); i++) {

                                JSONObject object = jarray.getJSONObject(i);
                                JSONObject bigImage = object.getJSONObject("thumbnail_images");
                                JSONObject tiMed = bigImage.getJSONObject("medium");
                                String imageURL = tiMed.getString("url");

                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        } */



                       /* JSONParser parser = new JSONParser();
                        JSONObject items = parser.getJSONFromUrl(productInfoUrl);
                        try {
                            JSONArray itemsDetails = items.getJSONArray("prodCat_list");
                            if(itemsDetails.length()>0){

                                for (int i = 0; i < itemsDetails.length(); i++) {
                                    JSONArray productWithCategories = itemsDetails.getJSONArray(i);
                                    JSONObject object = productWithCategories.getJSONObject(i);

                                    Product productInfo = new Product( object.getString("sku"), object.getInt("cat_id"), object.getInt("position"));
                                    ProductDbHandler productDbHandler = new ProductDbHandler(context);
                                    productDbHandler.addProducts(productInfo);
                                }
                            }
                            else
                                System.out.println("No product to add");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }*/

                       /* try
                        {
                            respone_server = response.getString("response");
                            JSONArray jarray =  respone_server.getS("posts");

                            for (int i = 0; i < jarray.length(); i++) {

                                JSONObject object = jarray.getJSONObject(i);
                                JSONObject bigImage = object.getJSONObject("thumbnail_images");
                                JSONObject tiMed = bigImage.getJSONObject("medium");
                                String imageURL = tiMed.getString("url");

                            }
                        }catch (JSONException e) {
                            e.printStackTrace();
                        } */


                        try {
                            //MessageModelList=new ArrayList<>();
                            //respone_server = response.getString("response");
                            respone_server = response.getString("response");
                            //   JSONArray jarray = response.getJSONArray("messages");

                            JSONArray list = response.getJSONArray("likes");
                            ArrayList<AndroidVersion> android_version = new ArrayList<>();

                            if(list != null){

                              //  for(int i = 0; i <=1;i++){
                                    for(int i = 0; i < list.length();i++){
                                    // JSONObject object = jarray.getJSONObject(i);

                                    //  String username1= object.getString("username");

                                    //   Log.v(" username1:",  username1);

                                    JSONObject elem = list.getJSONObject(i);

                                    message[k]=elem.getString("date");
                                    Log.v("id1:", elem.getString("id"));

                                    Log.v("user2:", elem.getString("user"));

                                    Log.v("date2:", elem.getString("date"));

                                    date_list[k]=elem.getString("date");

                                    String user1= elem.getString("user");

                                    Log.v("user2:", user1);


                                    // JSONParser parser = new JSONParser();
                                    // JSONObject json = (JSONObject) parser.parse(user1);

                                    // Log.v("state1:",json.getString("state"));
                                    // String test=json.getString("state");

                                    JSONObject parentObject = new JSONObject(user1);


                                    Log.v("username2:", parentObject.getString("username"));
                                    Log.v("city2:", parentObject.getString("city"));
                                    Log.v("country2:", parentObject.getString("country"));
                                    Log.v("state2:", parentObject.getString("state"));
                                    Log.v("age2:", parentObject.getString("age"));

                                    Log.v("photo2:", parentObject.getString("photo"));

                                    String url= parentObject.getString("photo");

                                    image_list.add(url);

                                    ImgUrl1.add(url);

                                    location= parentObject.getString("state")+" "+parentObject.getString("city")+" "+parentObject.getString("country")+","+parentObject.getString("age")+"y";
//                                    Log.v("location1:", location);
                                    String country=parentObject.getString("country");
                                    Log.v("country22:", country);
                                    city1[k]= location;
                                    // age1_list[k]= parentObject.getString("age");
                                    String tmp=parentObject.getString("username");
                                    Log.v("tmp2:", tmp);
                                    name1[k]= tmp;
                                        Log.v("tmpur", parentObject.getString("username"));
                                        name11[k]= parentObject.getString("username");
                                    Log.v("name1[k]", name1[k]);

                                    k++;
                                    Log.v("name11[k]", name11[k]);


                                    itemcount++;
/*                                    messageModel.setUsername(CommonFunction.stringNullCheck(parentObject.getString("username")));
                                    messageModel.setLocation(CommonFunction.stringNullCheck(location));

                                    messageModel.setMessage(CommonFunction.stringNullCheck(elem.getString("message")));
                                    messageModel.setAge(CommonFunction.stringNullCheck(parentObject.getString("age")));

                                    MessageModelList.add(messageModel);*/
                                    // JSONObject list1 = response.JSONObject("users");
                                    // Log.v("list1:",list1.getString("state"));

                                    //String myString = myJsonObject.getJSONObject("offer").getJSONObject("business").getString("name");
                                    //String myString =elm.getJSONObject("offer").getString("state");
/*
                                    if(elem != null) {
                                        JSONArray prods = elem.getJSONArray("messages");
                                        if (prods != null) {
                                            for (int j = 0; j < prods.length(); j++) {
                                                JSONObject innerElem = prods.getJSONObject(j);
                                                if (innerElem != null) {
                                                   // int cat_id = innerELem.getInt("cat_id");
                                                    int pos = innerElem.getInt("position");
                                                    String sku = innerElem.getString("sku");


                                                    Log.v("username1:", innerElem.getString("username"));
                                                    Log.v("city1:", innerElem.getString("city"));
                                                    Log.v("country1:", innerElem.getString("country"));
                                                    Log.v("state1:", innerElem.getString("state"));
                                                }
                                            }
                                        }
                                    }*/



                                }
                                rv.setAdapter(new MyAdapter3(Page_Activity3.this, p.generatePage(currentPage),ImgUrl1,itemcount));

                               /* MessageCustomAdapter historyCustomAdapter = new  MessageCustomAdapter(MessageText.this, R.layout.message_text, MessageModelList);

                               MessageListView .setAdapter(historyCustomAdapter);*/
                                // MessageCustomAdapter adapter = new MessageCustomAdapter(MessageText.this,MessageModelList);

                                //setting adapter to recyclerview
                                // recyclerView.setAdapter(adapter);

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
                Log.v("token51:",token);
                Log.v("mail151:",mail);
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                //String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
                String creds = String.format("%s:%s",mail,token);
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

}