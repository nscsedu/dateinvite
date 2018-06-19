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
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.braincraft.social.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import  com.braincraft.social.activity.ProfileActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;



import static android.content.ContentValues.TAG;
import static com.braincraft.social.activity.Filter.agefrom;
import static com.braincraft.social.activity.Filter.ageto;
import static com.braincraft.social.activity.Filter.location_filter;
import static com.braincraft.social.activity.Filter.prefagefrom;
//import static com.braincraft.social.activity.Filter.mEditor;

/**
 * Created by ADMIN on 25/4/2018.
 */

public class Page_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator p = new Paginator();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    ArrayList<String> ImgUrl= new ArrayList<>();
int col=0,br=0,peru=0,us=0;

    int selectionStart;
    int selectionEnd;

    public static  String token="token";
    public static   String mail="test@test.com";
    public static  String agefrom="";
    public static   String ageto="";
    public static  String locationfilter="";

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
    final Context context = this;
    private SharedPreferences mPreferences;
    private SharedPreferences.Editor mEditor;
    private SharedPreferences.Editor mEditor1;
    private SharedPreferences.Editor mEditor2;
    private SharedPreferences.Editor mEditor3;
    public static String tmp_username;

    public static String[] city={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"};

    public static String[] name={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",
            "test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20"};
    public static int[] mArray = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6
            ,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9};

    public static int[] coffe_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
    ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int[] drinks_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int[] dinner_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0
            ,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static String[] age_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0",
            "0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"
    ,"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
    private final String android_version_names[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    public static ArrayList arrayList=new ArrayList();
    private final String android_image_urls[] = {
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png",
            "http://api.learn2crack.com/android/images/donut.png",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };


    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings,imageprofile;
    private LinearLayout messages,videomessages,likedme,liked,contact_admin,colombia,colombia1,usa,usa1,brazil,brazil1,lrv,cardrv,canada1,canada;
    private ImageView likedandme,normalmessage,videomessage,goprofile,col2;
    private TextView go,editprofile,col1,col3,contactad,userprofile;
    private CardView card_view;
    public static Button coffee_image,drinks_image,dinner_image;
    private int preflag=0,nextflag=0;
    public String new_token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //RFERENCE VIEWS
        rv = (RecyclerView) findViewById(R.id.rv);
        nextBtn = (Button) findViewById(R.id.nextBtn);
        contactad = (TextView) findViewById(R.id.contactad);
        prevBtn = (Button) findViewById(R.id.prevBtn);

        /*coffee_image= (Button) findViewById(R.id.coffee_image);
        dinner_image=(Button) findViewById(R.id.dinner_image);
        drinks_image=(Button) findViewById(R.id.drinks_image) ;

        coffee_image.setVisibility(View.GONE);
        dinner_image.setVisibility(View.GONE);
        drinks_image.setVisibility(View.GONE);*/

        // card_view = (CardView) findViewById(R.id.card_view);



        firstpage = (Button) findViewById(R.id.firstpage);

      /*  col1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                col1.setBackgroundColor(Color.RED);
                col2.setBackgroundColor(Color.RED);
                col3.setBackgroundColor(Color.RED);

            }
        });

        col2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                col1.setBackgroundColor(Color.RED);
                col2.setBackgroundColor(Color.RED);
                col3.setBackgroundColor(Color.RED);

            }
        });
        col3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                col1.setBackgroundColor(Color.RED);
                col2.setBackgroundColor(Color.RED);
                col3.setBackgroundColor(Color.RED);

            }
        });*/



        prevBtn.setVisibility(View.GONE);
        prevBtn.setEnabled(false);

        // contact_admin=(TextView) findViewById(R.id.contact_admin);

        contact_admin = (LinearLayout) findViewById(R.id.demo1);



        Typeface tf = Typeface.createFromAsset(getAssets(),
                "fonts/MyriadPro.ttf");


        contactad.setTypeface(tf);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        layoutManager = new GridLayoutManager(Page_Activity.this, 2);
        rv.setLayoutManager(layoutManager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //RECYCLER PROPERTIES
        //  rv.setLayoutManager(new LinearLayoutManager(this));

        //ADAPTER
        // rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage)));




        View header = navigationView.getHeaderView(0);
        settings = (ImageView) header.findViewById(R.id.settings);
        messages = (LinearLayout) header.findViewById(R.id.messages);
        lrv = (LinearLayout) findViewById(R.id.lrv);
        cardrv = (LinearLayout) findViewById(R.id.cardrv);

        userprofile = (TextView) header.findViewById(R.id.userprofile);

       imageprofile = (ImageView) header.findViewById(R.id.imageprofile);

        SharedPreferences mPreferences3 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor3 = mPreferences3.edit();
        String urdid = mPreferences3.getString("username", "");
        String usrphoto = mPreferences3.getString("photo", "");
        Glide.with(this)
                .load(usrphoto)
                .override(200, 200)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageprofile);
        userprofile.setText(urdid);

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



            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

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

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {*/
        // String url = "https://api.ipify.org/?format=json";
        String url = "http://api.dateinvite.com/users.json";

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
           /* }
        });*/





        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
            /* startActivity(new Intent(Page_Activity.this, SettingsActivity.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/



                Intent intent = new Intent(Page_Activity.this,SettingsActivity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
               // finish();

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

                Intent intent = new Intent(Page_Activity.this,Page_Activity1.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
              //  overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();


            }
        });
        likedme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /* startActivity(new Intent(Page_Activity.this, LikedMe.class));

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/



                Intent intent = new Intent(Page_Activity.this,Page_Activity3.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();
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

                Intent intent = new Intent(Page_Activity.this,Page_Activity2.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//
                //finish();
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

                Intent intent = new Intent(Page_Activity.this,Page_Activity4.class);

              //  Intent intent = new Intent(Page_Activity.this,Page_Activity4.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

              //  finish();
            }
        });
        SharedPreferences mPreferences1 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor1 = mPreferences1.edit();
        String loc = mPreferences1.getString("first", "");

        if(loc.equals("Colombia"))
        {
            colombia1.setBackgroundColor(getResources().getColor(R.color.red));
            usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));

        }
        else if(loc.equals("Brazil"))
        {
            brazil1.setBackgroundColor(getResources().getColor(R.color.red));
            colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));
        }
        else if(loc.equals("United States"))
        {
            usa1.setBackgroundColor(getResources().getColor(R.color.red));
            colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));
        }
        else if(loc.equals("Peru"))
        {
            usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            canada1.setBackgroundColor(getResources().getColor(R.color.red));
            colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
        }
        else
        {
            usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
            brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
        }

        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        colombia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                colombia1.setBackgroundColor(getResources().getColor(R.color.red));
                usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.grey_500));

               mEditor = mPreferences.edit();


                mEditor.putString("first","Colombia");

                mEditor.commit();

                Intent intent = new Intent(Page_Activity.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
              //  finish();



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
                mEditor = mPreferences.edit();

                mEditor.putString("first","Brazil");

                mEditor.commit();

                Intent intent = new Intent(Page_Activity.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();


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
                mEditor = mPreferences.edit();

                mEditor.putString("first","United States");

                mEditor.commit();

                Intent intent = new Intent(Page_Activity.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

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

                usa1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                colombia1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                brazil1.setBackgroundColor(getResources().getColor(R.color.grey_500));
                canada1.setBackgroundColor(getResources().getColor(R.color.red));
                mEditor = mPreferences.edit();

               mEditor.putString("first","Peru");

                mEditor.commit();

                Intent intent = new Intent(Page_Activity.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
              //  overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

            }
        });

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /*  startActivity(new Intent(Page_Activity.this, Testcrop1.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                //Intent intent = new Intent(SelectInterest.this,ImageChange.class);
             // Intent intent = new Intent(Page_Activity.this,Testcrop1.class);
                //Intent intent = new Intent(Page_Activity.this,ProfileActivity.class);
                Intent intent = new Intent(Page_Activity.this,Testcrop3.class);

                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();
            }
        });


        contact_admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


              /*  startActivity(new Intent(Page_Activity.this, ContactAdmin.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/

                final AlertDialog.Builder builder = new AlertDialog.Builder(context,R.style.MyAlertDialogTheme);
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
                                        startActivity(new Intent(Page_Activity.this, ContactAdmin.class));
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                        //finish();
                                        break;
                                    case 1:
                                        startActivity(new Intent(Page_Activity.this, ImageSlider.class));
                                        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                       // finish();
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



                Intent intent = new Intent(Page_Activity.this,InviteNew1.class);

                intent.putExtra("search",search.getText().toString());
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finisoverridePendingTransition(R.anim.fade_in, R.anim.fade_out);h();

            }
        });

        lrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();

            }
        });
        cardrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });
      /* card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });*/

        rv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Invite.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        });




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


                Intent intent = new Intent(Page_Activity.this,Page_Activity4.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();

            }
        });

        normalmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /*  startActivity(new Intent(Page_Activity.this, MessageText.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

                Intent intent = new Intent(Page_Activity.this,Page_Activity1.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                //finish();

            }
        });
        likedandme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
              /*  startActivity(new Intent(Page_Activity.this, LikedMe.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/



                Intent intent = new Intent(Page_Activity.this,Page_Activity3.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();


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

                Intent intent = new Intent(Page_Activity.this,Filter.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
               // finish();


            }
        });

        firstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(Page_Activity.this, Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });
        final ArrayList<AndroidVersion> androidVersions = prepareData();
        // rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage)));

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
               // int testnum=p.generatePage(currentPage);
                rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage),ImgUrl));
                toggleButtons();

            }
        });
        // }
        prevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage -= 1;

                rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage),ImgUrl));

                toggleButtons();
            }
        });


        /*for(int i=0;i<name_list.length;i++)
        {
            Log.v("array", name_list[i]);
        }*/


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

       /* CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {*/


        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();


            SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mPreferences.edit();
            String first = mPreferences.getString("first", "");
            jsonBody.put("location_filter",  first);
            String age1 = mPreferences.getString("age1", "");
            String age2 = mPreferences.getString("age2", "");
            Log.v("age11",age1);
            Log.v("age22",age2);
            Log.v("first11",first);
           String Looking = mPreferences.getString("Looking", "");
            Log.v("Looking",Looking);
            jsonBody.put("ageFrom",age1);
            jsonBody.put("ageTo",age2);
           jsonBody.put("Looking",Looking);

         /*   SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = mPreferences.edit();

            String first = mPreferences.getString("first", "");
            String age1 = mPreferences.getString("age1", "");
            String age2 = mPreferences.getString("age2", "");

            Log.v("first",first);
            Log.v("age1",age1);
            Log.v("age2",age2);
            jsonBody.put("location_filter",  first);
            jsonBody.put("ageFrom",age1);
            jsonBody.put("ageTo",age2);*/

            // jsonBody.put("location_filter", restoredText);

           /* final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String value123=(mSharedPreference.getString("NameOfShared", "Default_Value"));
            Log.v("value123",value123);*/
          /*  SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            String name = preferences.getString("location_filter", "");

            Log.v("namepref",name);*/

            // Log.v("prefagefrom",pagefrom);
            // Log.v("prefageto",pageto);
            //  jsonBody.put("ageFrom", 20);
            //jsonBody.put("ageTo",30);
            //  Log.v("prefagefrom",prefagefrom);

          /*  jsonBody.put("ageFrom", agefrom);
            jsonBody.put("ageTo", ageto);
            jsonBody.put("Looking", "");
            jsonBody.put("location_filter", location_filter);
            // jsonBody.put("user", 9606);"ageFrom":"number", "ageTo":"number""location_filter":"location-search",
           // SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
            //  SharedPreferences.Editor editor = pref.edit();




         /*  String location_filter=pref.getString("location_filter", null);

            Log.v("location_filter123:",location_filter);*/

          /*  final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
            String value=(mSharedPreference.getString("NameOfShared", "Default_Value"));
            Log.v("value:",value);*/
           /* SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
            Log.v("", "preferences: "+preferences);*/

            // jsonBody.put("location_filter","Chile");
            // jsonBody.put("ageFrom","20");
            //jsonBody.put("ageTo","30");
            //jsonBody.put("Looking","Women who like women");

           /* SharedPreferences prefs = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
            String restoredText = prefs.getString("text", null);
            if (restoredText != null) {
                String name = prefs.getString("name", "No name defined");//"No name defined" is the default value.
                int idName = prefs.getInt("idName", 0); //0 is the default value.

                Log.v("shared", name);
               // Log.v("idName", idName);
            }*/


        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject response) {

                Log.v("Response321", response.toString());



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
                            location=elem.getString("city")+"  "+elem.getString("country");
                            Log.v("location:", location);
                            Log.v("cover:", elem.getString("cover"));

                            Log.v("cover:", elem.getString("cover"));

                            String url=elem.getString("cover");

                            ImgUrl.add(url);


                            Available=elem.getString("available_for");
                            if(Available.contains("Coffee"))
                            {
                                coffe_list[k]=1;
                            }
                            if(Available.contains("Dinner"))
                            {
                                dinner_list[k]=1;
                            }
                            if(Available.contains("Drinks"))
                            {
                                drinks_list[k]=1;
                            }

                            Log.i(TAG, "coffe_list[k]:" +coffe_list[k]);
                            Log.i(TAG, "drinks_list[k]:" +drinks_list[k]);
                            Log.i(TAG, "dinner_list[k]:" +dinner_list[k]);

                                        /*tmp_username= elem.getString("username");
                                        myArray[k]=tmp_username;
                                        Log.v("name[k]:",  myArray[k]);*/
                            name[k]=elem.getString("username");
                            city[k]=location;
                            age_list[k]=elem.getString("age");
                            Log.v("name[k]:",name[k]);
                            k++;
                                      /*  tmp_username= elem.getString("username");
                                       name_list.add(tmp_username);
                                        Log.v("tmp_username:",  tmp_username);

                                        myArray[k]=tmp_username;
                                        k++;


                                        Log.v("name[k]:",  myArray[k]);



                                        location=elem.getString("city")+""+elem.getString("country");
                                        Log.v("location:", location);*/

                                      /*  AndroidVersion androidVersion = new AndroidVersion();
                                        androidVersion.setAndroid_version_name(android_version_names[i]);
                                        androidVersion.setAndroid_image_url(android_image_urls[i]);
                                        android_version.add(androidVersion);*/


                        }
                        //return android_version;

                        rv.setAdapter(new MyAdapter(Page_Activity.this, p.generatePage(currentPage),ImgUrl));
                    }


                      /* Log.v("auth_msg",response.getString("auth_msg"));
                            Log.v("auth_msg123",response.getJSONObject("user").getString("email"));
                            Log.v("token",response.getJSONObject("user").getString("token"));
                            Log.v("messages",response.getJSONObject("counters").getString("messages"));
                            Log.v("video_messages",response.getJSONObject("counters").getString("video_messages"));
                            Log.v("liked_me",response.getJSONObject("counters").getString("liked_me"));
                            Log.v("invites",response.getJSONObject("counters").getString("invites"));*/
//                            Log.v("users",response.getString("users[0]"));
                    response.getString("users");
                    Log.v("users",response.getString("users"));
                    Log.v("Responseip:", respone_server);
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
                Log.v("mailResponse", mail);
                Log.v("tokenResponse", token);
                //  String creds = String.format("%s:%s","and5@test.com","a224af585f97ef309cb15e28116f14ea");
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
        // rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }

/*
    private void getHistoryDetails(String url){

        //Creating a string request
        StringRequest stringRequest = new StringRequest(url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        Log.e("responseBlood",response+"");

                        JSONObject jsonObject = null;
                        try {

                            jsonObject = new JSONObject(response);

                            Log.e("Result>>",result+"");
                            Log.e("statusBlood",jsonObject.getString("status"));
                            if(jsonObject.getString("status").equals("false")){


                            }
                            else
                            {
                                result = jsonObject.getJSONArray("result");



                                Log.e("listSizeBlood",result.length()+"");
                                if(result.length()<1){
                                    // openDialog();
                                }
                                else {
                                    for(int i=0;i<result.length();i++){
                                        JSONObject json = result.getJSONObject(i);

                                    }


                                }

                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());


        requestQueue.add(stringRequest);
    }
    */

    private ArrayList<AndroidVersion> prepareData(){

        ArrayList<AndroidVersion> android_version = new ArrayList<>();
        for(int i=0;i<android_version_names.length;i++){
            AndroidVersion androidVersion = new AndroidVersion();
            androidVersion.setAndroid_version_name(android_version_names[i]);
            androidVersion.setAndroid_image_url(android_image_urls[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }

}