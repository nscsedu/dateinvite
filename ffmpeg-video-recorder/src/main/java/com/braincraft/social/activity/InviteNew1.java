package com.braincraft.social.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.braincraft.social.activity.Page_Activity1.image_list;
import static com.braincraft.social.activity.ViewPagerAdapter.newpos;
import static com.braincraft.social.activity.ViewPagerAdapter.posinvite;







import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.*;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 4/20/2018.
 */

public class InviteNew1 extends AppCompatActivity {


    private GridLayoutManager layoutManager;
    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator p = new Paginator();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    ArrayList<String> ImgUrl= new ArrayList<>();


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
   private ViewPager viewPager;
    private TextView go,editprofile,col1,col3,contactad,age,city,about,kids,drink,smoke,city_country,location,dateoption,userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitenew);

        viewPager = (ViewPager) findViewById(R.id.viewPager);


       /* ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentOne(), "FRAG1");
        adapter.addFragment(new FragmentTwo(), "FRAG2");*/

        //adapter.addFragment(new FragmentRegister(), "FRAG3");
        //viewPager.setAdapter(adapter);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FragmentImage(), "FRAG1");
        adapter.addFragment(new FragmentVideo(), "FRAG2");

        //adapter.addFragment(new FragmentRegister(), "FRAG3");
        //viewPager.setAdapter(adapter);
      /*  Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {

            pos = bundle.getString("pos");
        }*/
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/

       /* Toast.makeText(getApplicationContext(), "OopsInvitenew!!",
                Toast.LENGTH_LONG).show();*/
        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            search = bundle.getString("search");

            token = bundle.getString("token");

            mail = bundle.getString("mail");

        }

        Log.v(" search321",  search);
        Log.v("token321",  token);
        Log.v("mail321",  mail);
        kids=(TextView) findViewById(R.id.kids);
        drink=(TextView) findViewById(R.id.drink);
        smoke=(TextView) findViewById(R.id.smoke);


        age=(TextView) findViewById(R.id.age);
        city_country=(TextView) findViewById(R.id.city_country);
        about=(TextView) findViewById(R.id.aboutinfo);
        profilephoto=(ImageView) findViewById(R.id.profileimage);

        location=(TextView) findViewById(R.id.city_country);
        dateoption=(TextView)findViewById(R.id.available_for) ;


        select=(TextView) findViewById(R.id.select);
       // vd = (VideoView) findViewById(R.id.VideoView);

        left=(TextView) findViewById(R.id.left);
        right=(TextView) findViewById(R.id.right);

        left.setVisibility(View.GONE);
        // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");

        Uri uri  = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test);

        mc = new MediaController(this);
      //  vd.setMediaController(mc);

       // vd.setVideoURI(uri);

       // vd.setVisibility(View.GONE);




//..................***********..................
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


        // vd.start();




     //   viewPager = (ViewPager) findViewById(R.id.viewPager);

        sendinvitation = (TextView) findViewById(R.id.sendinvitation);

        like_off = (TextView) findViewById(R.id.like_off);

        blockuser = (TextView) findViewById(R.id.blockuser);
       /* ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);*/




        currentpage = viewPager.getCurrentItem();

        Log.i(TAG, "currentpage123:" +  currentpage);


        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                //DO YOUR CODE
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
               /* overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                //DO YOUR CODE
                viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
               /* overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/

            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
               /* startActivity(new Intent(InviteNew1.this,Page_Activity.class));

                overridePendingTransition(R.anim.your_left_to_right, R.anim.your_right_to_left);
                finish();*/





                Intent intent = new Intent(InviteNew1.this,Page_Activity.class);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
               // overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);

        userid = (TextView) toolbar.findViewById(R.id.userid);
       // like_off.setBackgroundResource(R.drawable.like_off);
       // checklike();
        sendinvitation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                /*startActivity(new Intent(Invite.this,Interaction.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/
                Log.i(TAG, "id123:" +  id);

                Intent intent = new Intent(InviteNew1.this, Interaction.class);
                intent.putExtra("search", search);
                intent.putExtra("token", token);
                intent.putExtra("mail",mail);
                intent.putExtra("id",id);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });




      blockuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){


                Log.i(TAG, "likeflagoff1:" + likeflag);


                Log.i(TAG, "likeflagoff2:" + likeflag);

               /* android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(
                        context);


                alertDialogBuilder.setTitle("Alert!");


                alertDialogBuilder
                        .setMessage("Are you sure want to block" +"\n"+

                                "this user.")
                        .setCancelable(false)
                        .setPositiveButton("Confirm",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {

                            }
                        })
                ;


                android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();


                alertDialog.show();





                TextView messageText = (TextView) alertDialog.findViewById(android.R.id.message);
                messageText.setGravity(Gravity.CENTER);
                alertDialog.show();

                final Button positiveButton = alertDialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE);
                LinearLayout.LayoutParams positiveButtonLL = (LinearLayout.LayoutParams) positiveButton.getLayoutParams();
                positiveButtonLL.gravity = Gravity.CENTER;
                positiveButton.setLayoutParams(positiveButtonLL);

                alertDialog.show();*/

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(InviteNew1.this);

                // Setting Dialog Title
                alertDialog.setTitle("Alert!");

                // Setting Dialog Message
                alertDialog.setMessage("Are you sure want to block\n"
                        +"this user?");

                // Setting Icon to Dialog
               // alertDialog.setIcon(R.drawable.delete);

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        // Write your code here to invoke YES event
                      //  Toast.makeText(getApplicationContext(), "You clicked on YES", Toast.LENGTH_SHORT).show();
                        String url_block = "http://api.dateinvite.com/blocks/create.json";


                        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                        JSONObject jsonBody = new JSONObject();
                        try {
                            jsonBody = new JSONObject();
                            // jsonBody.put("user", 9606);
                            Log.i(TAG, "sendid:" +id);
                            jsonBody.put("user",id);

                        } catch (Exception ex){
                            Log.v("", "ERROR: "+ex.getMessage());
                        }

                        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST, url_block,jsonBody, new Response.Listener<JSONObject>(){
                            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                                    url, null,
                                    new Response.Listener<JSONObject>() {*/
                            @Override
                            public void onResponse(JSONObject response) {

                                Log.v("Responseblock", response.toString());



                                try {

                                    respone_server = response.getString("msg");
                                    Log.v("Response_Like", respone_server);
                                    if(respone_server.equals("Your Like was saved"))
                                    {
                                        like_off.setBackgroundResource(R.drawable.like_on);
                                    }
                                    else if(respone_server.equals("Your Like was deleted"))
                                    {
                                        like_off.setBackgroundResource(R.drawable.like_off);
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
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                       // Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                // Showing Alert Message
                alertDialog.show();









                //}


            }
        });


        Log.i(TAG, "likeflagoff1:" + likeflag);
        like_off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Log.i(TAG, "likeflagoff1:" + likeflag);


                Log.i(TAG, "likeflagoff2:" + likeflag);



                String url_like = "http://api.dateinvite.com/likes/create.json";


              //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

                    JSONObject jsonBody = new JSONObject();
                    try {
                        jsonBody = new JSONObject();
                        // jsonBody.put("user", 9606);
                        Log.i(TAG, "sendid:" +id);
                        jsonBody.put("user",id);

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
                                Log.v("Response_Like1", respone_server);
                                if(respone_server.equals("Your Like was saved"))
                                {
                                    like_off.setBackgroundResource(R.drawable.like_on);
                                }
                                else if(respone_server.equals("Your Like was deleted"))
                                {
                                    like_off.setBackgroundResource(R.drawable.like_off);
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

                //}




            }
        });


        Log.i(TAG, "likeflagon:" + likeflag);
        Log.i(TAG, "posinvite123:" + posinvite);

        Log.i(TAG, "newpos123:" +  newpos);
        select.setVisibility(View.GONE);




    }



    // JSONObject jObj = new JSONObject(stringaRis);


    public void makeRequest( final String url,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody = new JSONObject();
            // jsonBody.put("user", 9606);
            jsonBody.put("username",search);

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {

                Log.v("Responsejsonbody", response.toString());



                try {
                    //MessageModelList=new ArrayList<>();
                    //respone_server = response.getString("response");
                    respone_server = response.getString("response");
                    //   JSONArray jarray = response.getJSONArray("messages");

                    JSONArray list = response.getJSONArray("users");
                    ArrayList<AndroidVersion> android_version = new ArrayList<>();

                    if(list != null){

                        // for(int i = 0; i <=1;i++){
                        for(int i = 0; i < list.length();i++){


                            JSONObject elem = list.getJSONObject(i);


                            Log.v("age2:", elem.getString("age"));

                            Log.v("aboutinfo:", elem.getString("about"));



                            age.setText(elem.getString("age"));

                            about.setText("  "+elem.getString("about"));
                            List<String> images=new ArrayList<>();

                            images.add(elem.getString("photo"));

                            Glide.with(context)
                                    .load(images.get(0))
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .into(profilephoto);

                            if(elem.getString("has_kids").equals("0")) {
                                kids.setText("  " + "Have Kids:" + "  " + "No");
                            }
                            else
                            {
                                kids.setText("  " + "Have Kids:" + "  " + "Yes");
                            }

                            drink.setText("  "+"Drink:"+"  "+elem.getString("drink"));
                            smoke.setText("  "+"Smoke:"+"  "+elem.getString("smoker"));
                            String available="  "+elem.getString("available_for");
                             available = available.replace(";", "\n ");
                             //available="coffee"+"\n"+"dinner";
                            dateoption.setText(available);

                            String city_state=elem.getString("city")+", "+elem.getString("country");
                            Log.v("city123:", elem.getString("city"));
                            Log.v("country123:", elem.getString("country"));

                            Log.v("id123:", elem.getString("id"));
                            str_id=elem.getString("id");
                            Log.v("str_id:", str_id);

                           id=Integer.parseInt( str_id);
                            //Log.v("id:", id);

                        //   id = Integer.parseInt(str_id.getText().toString());

                            location.setText(elem.getString("city")+", "+elem.getString("state"));

                           userid.setText(elem.getString("username"));







                        }


                    }



                    response.getString("users");
                    Log.v("users22",response.getString("users"));
                    Log.v("Responseip2:", respone_server);
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
        // rq.setPriority(Request.Priority.HIGH);
        VolleyController.getInstance(getApplicationContext()).addToRequestQueue(rq);

    }

public void checklike()
{

    String url_like = "http://api.dateinvite.com/likes/liked.json";


    //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

    JSONObject jsonBody = new JSONObject();
    try {
        jsonBody = new JSONObject();
        // jsonBody.put("user", 9606);
        Log.i(TAG, "sendid:" +id);
       // jsonBody.put("user",id);

    } catch (Exception ex){
        Log.v("", "ERROR: "+ex.getMessage());
    }

    JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
        /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {*/
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

                    // for(int i = 0; i <=1;i++){
                    for(int i = 0; i < list.length();i++){
                        // JSONObject object = jarray.getJSONObject(i);

                        //  String username1= object.getString("username");

                        //   Log.v(" username1:",  username1);

                        JSONObject elem = list.getJSONObject(i);


                        Log.v("id1:", elem.getString("id"));
                        Log.i(TAG, "sendid1:" +id);
                   if(62855==Integer.parseInt(elem.getString("id")))
                   {                        Log.i(TAG, "sendid2:" +id);

                       like_off.setBackgroundResource(R.drawable.like_on);
                   }





                    }
                    //rv.setAdapter(new MyAdapter2(Page_Activity2.this, p.generatePage(currentPage),ImgUrl1,itemcount));

                               /* MessageCustomAdapter historyCustomAdapter = new  MessageCustomAdapter(MessageText.this, R.layout.message_text, MessageModelList);

                               MessageListView .setAdapter(historyCustomAdapter);*/
                    // MessageCustomAdapter adapter = new MessageCustomAdapter(MessageText.this,MessageModelList);

                    //setting adapter to recyclerview
                    // recyclerView.setAdapter(adapter);

                }



                response.getString("users");
                Log.v("users22",response.getString("users"));
                Log.v("Responseip2:", respone_server);
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
                   // callback.onSuccess(response);


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





    // Adapter for the viewpager using FragmentPagerAdapter
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
