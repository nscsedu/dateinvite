package com.braincraft.social.activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.braincraft.social.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.braincraft.social.R;
import com.pnikosis.materialishprogress.ProgressWheel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 25/5/2018.
 */

public class infinite_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{
    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator p = new Paginator();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
   public static ArrayList<String> ImgUrl= new ArrayList<>();
public static int pageno=1;
Context c;
    String token="token";
    String search;
    String mail="test@test.com";
    // public static  JSONObject elem;
//public static String city;
    public static  ArrayList<String> name_list = new ArrayList<String>();
    public static   String[] city_list;
    //public static   String[] name_list;
    public static int Dinner=0,Drinks=0,Coffee=0;
    int k=0;
    public static int id=0;
    public String str_id;
    public static String[] myArray = new String[20];
    int foo,emailpassflag=0;
    private EditText editTextEmail,editTextPassword;
    String username,password;
    private static final String TAG = "MyActivity";
    String respone_server,response_message,Available;

    private JSONArray result;
    public static String location1;
    final Context context = this;

    public static String tmp_username;

    //public static String[] city={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"};

    public static String[] name={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};
    public static int[] mArray = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6
            ,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9};


    public static ArrayList arrayList=new ArrayList();



    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;
    private LinearLayout messages,videomessages,likedme,liked,contact_admin,colombia,colombia1,usa,usa1,brazil,brazil1,lrv,cardrv,canada1,canada;
    private ImageView likedandme,normalmessage,videomessage,goprofile,col2;

    private CardView card_view;
    public static Button coffee_image,drinks_image,dinner_image,available_for;
    private int preflag=0,nextflag=0;
    public String new_token;


    private ActionBarDrawerToggle mDrawerToggle;


    public static  String agefrom="";
    public static   String ageto="";
    public static  String locationfilter="";




    private boolean isImage = false;
    private String reviewImageLink;
    private MediaController mc;
    public int likeflag=0;
    private int currentpage;
    private int count=0;

    public static VideoView vd;

    public int message=5;
    String pos;

    public static TextView sendinvitation,like_off,blockuser;
    public static TextView select,left,right;
    private Button submit, btnlogin_submit;
    private  ImageView profilephoto;
    ViewPager viewPager;
    private TextView go,editprofile,col1,col3,contactad,age,city,about,kids,drink,smoke,city_country,location,dateoption,userid;

    public static String loc;

    // we will be loading 15 items per page or per load
    // you can change this to fit your specifications.
    // When you change this, there will be no need to update your php page,
    // as php will be ordered what to load and limit by android java
    private static final int LOAD_LIMIT = 15;

    // last id to be loaded from php page,
    // we will need to keep track or database id field to know which id was loaded last
    // and where to begin loading
    private String lastId = "0"; // this will issued to php page, so no harm make it string

    // we need this variable to lock and unlock loading more
    // e.g we should not load more when volley is already loading,
    // loading will be activated when volley completes loading
    private boolean itShouldLoadMore = true;

    // initialize adapter and data structure here
    private RecyclerAdapter recyclerAdapter;
    private ArrayList<RecyclerModel> recyclerModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.container_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        contactad = (TextView) findViewById(R.id.contactad);
        contact_admin = (LinearLayout) findViewById(R.id.demo1);
        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/MyriadPro.ttf");


        contactad.setTypeface(tf);
        // you must assign all objects to avoid nullPointerException
        recyclerModels = new ArrayList<>();
        recyclerAdapter = new RecyclerAdapter(recyclerModels);

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        layoutManager = new GridLayoutManager(infinite_main.this, 2);
       recyclerView.setLayoutManager(layoutManager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(c);
        navigationView.setNavigationItemSelectedListener(this);



        View header = navigationView.getHeaderView(0);
        settings = (ImageView) header.findViewById(R.id.settings);
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
        go = (TextView) header.findViewById(R.id.go);

        final EditText  search = (EditText) header.findViewById(R.id.search);



        colombia = (LinearLayout)findViewById(R.id.colombia);
        usa = (LinearLayout) findViewById(R.id.usa);
        brazil = (LinearLayout) findViewById(R.id.brazil);
        canada = (LinearLayout) findViewById(R.id.canada);


        colombia1 = (LinearLayout)findViewById(R.id.colombia1);
        usa1 = (LinearLayout) findViewById(R.id.usa1);
        brazil1 = (LinearLayout) findViewById(R.id.brazil1);
        canada1 = (LinearLayout) findViewById(R.id.canada1);



        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");
            agefrom = bundle.getString("agefrom");
            ageto = bundle.getString("ageto");
            locationfilter = bundle.getString("locationfilter");

        }
       /* token = bundle.getString("token");
         mail = bundle.getString("mail");*/

       /* Log.v("agefrom:",agefrom);
        Log.v(" ageto:", ageto);

        Log.v("locationfilter:", locationfilter);*/

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("token_key", "token");
        editor.putString("token_key", "mail");

        new_token=pref.getString("token_key", null);

        Log.v("new_token:",token);


        TextView btn =  (TextView) findViewById(R.id.test123);
        assert btn != null;










        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
            /* startActivity(new Intent(Page_Activity.this, SettingsActivity.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/



                Intent intent = new Intent(infinite_main.this,SettingsActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();

            }
        });

        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                // startActivity(new Intent(Page_Activity.this, Liked.class));

                /*startActivity(new Intent(Page_Activity.this, Page_Activity1.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                // finish();

                Intent intent = new Intent(infinite_main.this,Page_Activity1.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();


            }
        });
        likedme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /* startActivity(new Intent(Page_Activity.this, LikedMe.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/



                Intent intent = new Intent(infinite_main.this,Page_Activity3.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();
            }
        });
        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                // startActivity(new Intent(Page_Activity.this, Liked.class));
              /* startActivity(new Intent(Page_Activity.this, Page_Activity2.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                //  finish();

                Intent intent = new Intent(infinite_main.this,Page_Activity2.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();
            }
        });

        videomessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                /*startActivity(new Intent(Page_Activity.this, VideoMessage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

              /*  Intent intent = new Intent(Page_Activity.this,VideoMessage.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();*/



                Intent intent = new Intent(infinite_main.this,Page_Activity4.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);

                finish();
            }
        });
        colombia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                colombia1.setBackgroundColor(getResources().getColor(R.color.red));
                usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));


            }
        });
        brazil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                brazil1.setBackgroundColor(getResources().getColor(R.color.red));
                colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));


            }
        });
        usa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                usa1.setBackgroundColor(getResources().getColor(R.color.red));
                colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));

            }
        });


        canada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.red));
                colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));

            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(infinite_main.this, Testcrop1.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });


        contact_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              /*  startActivity(new Intent(Page_Activity.this, ContactAdmin.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                final android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context,R.style.MyAlertDialogTheme);
                builder.setTitle("Choose");



                builder.setItems(new CharSequence[]
                                {"Administrator", "Tutorial", "Cancel"},


                        // builder.setTextColor(Color.MAGENTA);
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position
                                // of the selected item

                                switch (which) {
                                    case 0:

                                        // Toast.makeText(context, "clicked 1", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(infinite_main.this, ContactAdmin.class));
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                        finish();
                                        break;
                                    case 1:
                                        startActivity(new Intent(infinite_main.this, ImageSlider.class));
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                        finish();
                                        break;
                                    case 2:
                                        // Toast.makeText(context, "clicked 3", Toast.LENGTH_SHORT).show();
                                        dialog.dismiss();
                                        break;

                                }
                            }
                        });
                // builder.setMessage(Html.fromHtml("<font color='#FF7F27'>This is a test</font>"));


                builder.create().show();



            }
        });


        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              /*  startActivity(new Intent(Page_Activity.this, Invite.class));

                overridePendingTransition( R.anim.slide_up_animation,R.anim.slide_down_animation);
                finish();*/

/*
                startActivity(new Intent(Page_Activity.this, InviteNew.class));

                overridePendingTransition( R.anim.fade_in,R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(infinite_main.this,InviteNew1.class);

                intent.putExtra("search",search.getText().toString());
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();

            }
        });

        /*lrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(infinite_main.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        cardrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(infinite_main.this, Invite.class));
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

       /* rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(infinite_main.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/




        videomessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
               /* startActivity(new Intent(Page_Activity.this, VideoMessage.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

              /*  Intent intent = new Intent(Page_Activity.this,VideoMessage.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();*/


                Intent intent = new Intent(infinite_main.this,Page_Activity4.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);

                finish();

            }
        });

        normalmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /*  startActivity(new Intent(Page_Activity.this, MessageText.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

                Intent intent = new Intent(infinite_main.this,Page_Activity1.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                finish();

            }
        });
        likedandme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /*  startActivity(new Intent(Page_Activity.this, LikedMe.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(infinite_main.this,Page_Activity3.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();


               /* Intent intent = new Intent(Page_Activity.this,Page_Activity3.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();*/

            }
        });

        goprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /*startActivity(new Intent(Page_Activity.this, Filter.class));
                overridePendingTransition( R.anim.slide_up_animation,R.anim.slide_down_animation);

                finish();*/

                Intent intent = new Intent(infinite_main.this,Filter.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                finish();


            }
        });












        //we can now set adapter to recyclerView;
        recyclerView.setAdapter(recyclerAdapter);

        // create a function for the first load
        firstLoadData();

        // here add a recyclerView listener, to listen to scrolling,
        // we don't care when user scrolls upwards, will only be careful when user scrolls downwards
        // this listener is freely provided for by android, no external library
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            // for this tutorial, this is the ONLY method that we need, ignore the rest
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    // Recycle view scrolling downwards...
                    // this if statement detects when user reaches the end of recyclerView, this is only time we should load more
                    if (!recyclerView.canScrollVertically(RecyclerView.FOCUS_DOWN)) {
                        // remember "!" is the same as "== false"
                        // here we are now allowed to load more, but we need to be careful
                        // we must check if itShouldLoadMore variable is true [unlocked]
                        if (itShouldLoadMore) {
                            loadMore();
                        }
                    }

                }
            }
        });

        setSupportActionBar(toolbar);


    }

    // this function will load 15 items as indicated in the LOAD_LIMIT variable field
    private void firstLoadData() {

       // String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?limit=" + LOAD_LIMIT;
        String url = "http://api.dateinvite.com/users.json";
        Log.v("Responsedemo2", url);
        // to make you understand everything, to the php page, we will be doing something like this
        // $limit = $_GET['limit']
        // then [SELECT * FROM table_name ORDER_BY id DESC LIMIT $limit ]

        itShouldLoadMore = false; // lock this guy,(itShouldLoadMore) to make sure,
        // user will not load more when volley is processing another request
        // only load more when  volley is free

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        String url_like = "http://api.dateinvite.com/users.json";
        //String url = "http://api.dateinvite.com/users.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            //  Log.i(TAG, "sendid:" +id);
            // jsonBody.put("page",3);

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


                progressDialog.dismiss();
                // remember here we are in the main thread, that means,
                //volley has finished processing request, and we have our response.
                // What else are you waiting for? update itShouldLoadMore = true;
                itShouldLoadMore = true;


                try {

                    respone_server = response.getString("response");


                    JSONArray list = response.getJSONArray("users");
                    ArrayList<AndroidVersion> android_version = new ArrayList<>();
                    if(list != null){

                        for(int i = 0; i < list.length();i++){
                            JSONObject elem = list.getJSONObject(i);
                            Log.v("username:", elem.getString("username"));
                            Log.v("city:", elem.getString("city"));
                            Log.v("country:", elem.getString("country"));
                            Log.v("age:", elem.getString("age"));
                            Log.v("available_for:", elem.getString("available_for"));

                            Log.v("cover:", elem.getString("cover"));

                            Log.v("cover:", elem.getString("cover"));

                            String url=elem.getString("cover");
                           loc=elem.getString("city")+"  "+elem.getString("country");

                            ImgUrl.add(url);


                            Available=elem.getString("available_for");

                                        /*tmp_username= elem.getString("username");
                                        myArray[k]=tmp_username;
                                        Log.v("name[k]:",  myArray[k]);*/


                            Log.v("name[k]:",name[k]);
                            k++;
                           // recyclerModels.add(new RecyclerModel(elem.getString("age"),loc,  elem.getString("username")));
                            recyclerModels.add(new RecyclerModel(elem.getString("age"),loc ,elem.getString("cover"), elem.getString("username")));

                            recyclerAdapter.notifyDataSetChanged();



                        }

                        //return android_version;

                        // rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage),ImgUrl));
                    }



                    response.getString("users");
                    Log.v("users",response.getString("users"));
                    Log.v("Responseip:", respone_server);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        // also here, volley is not processing, unlock it should load more
                        itShouldLoadMore = true;
                        progressDialog.dismiss();
                        Toast.makeText(infinite_main.this, "network error!", Toast.LENGTH_SHORT).show();
                        new AlertDialog.Builder(infinite_main.this)
                                .setMessage(error.toString())
                                .show();


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

                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                // String creds = String.format("%s:%s",mail,token);
                String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
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



        //Volley.newRequestQueue(this).add(jsonArrayRequest);
       // VolleyController.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }

    private void loadMore() {
pageno++;

        String url = "http://hacksmile.com/hack_smile_tutorials/loadmore.php?action=loadmore&lastId=" + "234" + "&limit=" + LOAD_LIMIT;
        String url_like = "http://api.dateinvite.com/users.json";

        Log.v("Responsedemo1", url);
        // our php page starts loading from 250 to 1, because we have [ORDER BY id DESC]
        // So until you clearly understand everything, for this tutorial use ORDER BY ID DESC
        // so we will do something like this to the php page
        //==============================================
        // $limit = $_GET['limit']
        // $lastId = $_GET['lastId']
        // then [SELECT * FROM table_name WHERE id < $lastId ORDER_BY id DESC LIMIT $limit ]
        // here we shall load 15 items from table where lastId id less than last loaded id

        // if you are using [ASC] in sql, your query might change to tis
        // then [SELECT * FROM table_name WHERE id > $lastId ORDER_BY id DESC LIMIT $limit ]
        // for this tutorial let's stick to [DESC]


        itShouldLoadMore = false; // lock this until volley completes processing

        // progressWheel is just a loading spinner, please see the content_main.xml
        final ProgressWheel progressWheel = (ProgressWheel) this.findViewById(R.id.progress_wheel);
        progressWheel.setVisibility(View.VISIBLE);

        //String url = "http://api.dateinvite.com/users.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            //  Log.i(TAG, "sendid:" +id);
           // Log.v("page", page);
             jsonBody.put("page",pageno);

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
                progressWheel.setVisibility(View.GONE);
                Log.v("Responsedemo", response.toString());
                // since volley has completed and it has our response, now let's update
                // itShouldLoadMore

                itShouldLoadMore = true;




               /* progressDialog.dismiss();

                itShouldLoadMore = true;*/


                try {

                    respone_server = response.getString("response");


                    JSONArray list = response.getJSONArray("users");
                    ArrayList<AndroidVersion> android_version = new ArrayList<>();
                    if(list != null){

                        for(int i = 0; i < list.length();i++){
                            JSONObject elem = list.getJSONObject(i);
                         /*   Log.v("username:", elem.getString("username"));
                            Log.v("city:", elem.getString("city"));
                            Log.v("country:", elem.getString("country"));
                            Log.v("age:", elem.getString("age"));
                            Log.v("available_for:", elem.getString("available_for"));

                            Log.v("cover:", elem.getString("cover"));

                            Log.v("cover:", elem.getString("cover"));*/

                            String url=elem.getString("cover");

                            ImgUrl.add(url);


                            Available=elem.getString("available_for");

                                        /*tmp_username= elem.getString("username");
                                        myArray[k]=tmp_username;
                                        Log.v("name[k]:",  myArray[k]);*/


//                            Log.v("name[k]:",name[k]);
                            k++;
                            recyclerModels.add(new RecyclerModel(elem.getString("age"),loc ,elem.getString("cover"), elem.getString("username")));

                            recyclerAdapter.notifyDataSetChanged();



                        }

                        //return android_version;

                        // rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage),ImgUrl));
                    }



                    response.getString("users");
                    Log.v("users",response.getString("users"));
                    Log.v("Responseip:", respone_server);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        // also here, volley is not processing, unlock it should load more
                        progressWheel.setVisibility(View.GONE);
                        // volley finished and returned network error, update and unlock  itShouldLoadMore
                        itShouldLoadMore = true;
                        Toast.makeText(infinite_main.this, "Failed to load more, network error", Toast.LENGTH_SHORT).show();

                    }
                }) {


            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();

                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
                // String creds = String.format("%s:%s",mail,token);
                String creds = String.format("%s:%s","androidtest5@test.com","60d4a5e30b05fd9cf79705885b8df6b6");
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



        //Volley.newRequestQueue(this).add(jsonArrayRequest);
        // VolleyController.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

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
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        // user is in notifications fragment
        // and selected 'Mark all as Read'


        return super.onOptionsItemSelected(item);
    }*/


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

       // Toast.makeText(NavActivity.this, "onOptionsItemSelected", Toast.LENGTH_SHORT).show();

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }*/

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

       DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (item.getItemId() == android.R.id.home) {
            if(drawer .isDrawerOpen(Gravity.LEFT)) {
                drawer .closeDrawer(Gravity.LEFT);
            }else{
                drawer .openDrawer(Gravity.LEFT);
            }

        }else if (item.getItemId()== R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }*/
}
