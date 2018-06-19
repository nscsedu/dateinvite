package com.braincraft.social.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.DisplayMetrics;
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
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.braincraft.social.activity.ViewPagerAdapter.newpos;
import static com.braincraft.social.activity.ViewPagerAdapter.posinvite;

/**
 * Created by User on 4/20/2018.
 */

public class InviteNew extends AppCompatActivity {


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
    ViewPager viewPager;
    private TextView go,editprofile,col1,col3,contactad,age,city,about,kids,drink,smoke,city_country,location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invitenew);



      /*  Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {

            pos = bundle.getString("pos");
        }*/
       /* token = bundle.getString("token");
        mail = bundle.getString("mail");*/


        Bundle bundle = getIntent().getExtras();

        if (bundle != null)
        {
            search = bundle.getString("search");

        }


       kids=(TextView) findViewById(R.id.kids);
       drink=(TextView) findViewById(R.id.drink);
      smoke=(TextView) findViewById(R.id.smoke);


        age=(TextView) findViewById(R.id.age);
        city_country=(TextView) findViewById(R.id.city_country);
        about=(TextView) findViewById(R.id.aboutinfo);

        location=(TextView) findViewById(R.id.city_country);


        select=(TextView) findViewById(R.id.select);
        vd = (VideoView) findViewById(R.id.VideoView);

        left=(TextView) findViewById(R.id.left);
        right=(TextView) findViewById(R.id.right);

        left.setVisibility(View.GONE);
        // Uri uri = Uri.parse("android.resource://" + getPackageName() + "test");

        Uri uri  = Uri.parse("android.resource://" + getPackageName() + "/"
                + R.raw.test);

        mc = new MediaController(this);
        vd.setMediaController(mc);

        vd.setVideoURI(uri);

        vd.setVisibility(View.GONE);



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




        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sendinvitation = (TextView) findViewById(R.id.sendinvitation);

        like_off = (TextView) findViewById(R.id.like_off);

        blockuser=(TextView) findViewById(R.id.blockuser);


        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);




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
                startActivity(new Intent(InviteNew.this,Page_Activity.class));
                //overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                overridePendingTransition(R.anim.your_left_to_right, R.anim.your_right_to_left);
                finish();
            }
        });
        toolbar.setNavigationIcon(R.drawable.back_icon);
        sendinvitation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                /*startActivity(new Intent(Invite.this,Interaction.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);*/


                Intent intent = new Intent(InviteNew.this, Interaction.class);
                intent.putExtra("message", message);

                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });

        Log.i(TAG, "likeflagoff1:" + likeflag);
        like_off.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //DO YOUR CODE
                Log.i(TAG, "likeflagoff1:" + likeflag);
                like_off.setBackgroundResource(R.drawable.like_on);

                Log.i(TAG, "likeflagoff2:" + likeflag);



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

                            kids.setText("  "+"Have Kids:"+"  "+elem.getString("has_kids"));
                            drink.setText("  "+"Drink:"+"  "+elem.getString("drink"));
                            smoke.setText("  "+"Smoke:"+"  "+elem.getString("smoker"));

                            available_for.setText("  "+"Smoke:"+"  "+elem.getString("available_for"));

                            String city_state=elem.getString("city")+", "+elem.getString("country");
                            Log.v("city123:", elem.getString("city"));
                            Log.v("country123:", elem.getString("country"));

                            location.setText(elem.getString("country"));


                           /* city_country.setText(elem.getString("age"));

                            Log.v("city123:", elem.getString("city"));
                            Log.v("country123:", elem.getString("country"));*/

                            //String city_state=elem.getString("city")+", "+elem.getString("country");


                           // city.setText(city_state);

                           // Log.v("date2:", elem.getString("date"));



                          /*  String user1= elem.getString("user");

                            Log.v("user2:", user1);


                            JSONObject parentObject = new JSONObject(user1);


                            Log.v("username2:", parentObject.getString("username"));
                            Log.v("city2:", parentObject.getString("city"));
                            Log.v("country2:", parentObject.getString("country"));
                            Log.v("state2:", parentObject.getString("state"));
                            Log.v("age2:", parentObject.getString("age"));

                            Log.v("photo2:", parentObject.getString("photo"));

                            String url= parentObject.getString("photo");



                            location= parentObject.getString("city")+"  "+parentObject.getString("country");

                            String country=parentObject.getString("country");
                            Log.v("country22:", country);


                            String tmp=parentObject.getString("username")+"  "+parentObject.getString("age")+"y";
                            Log.v("tmp2:", tmp);


                            k++;
*/






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


}
