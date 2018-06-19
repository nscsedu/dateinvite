package com.braincraft.social.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
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
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ADMIN on 22/4/2018.
 */

public class MessageText extends AppCompatActivity {


    RecyclerView rv;
    public static Button nextBtn, prevBtn,firstpage;
    Paginator p = new Paginator();
    private int totalPages = Paginator.TOTAL_NUM_ITEMS / Paginator.ITEMS_PER_PAGE;
    private int currentPage = 0;
    private  int flag=0;
    ArrayList<String> ImgUrl= new ArrayList<>();
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

    public static String tmp_username;

    List<MessageModel> MessageModelList;
    ListView MessageListView;

    public static String[] city={"New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose","New York","Los Angeles","Chicago","Houston","Phoenix","Philadelphia","San Antonio","San Diego","Dallas","San Jose"};

    public static String[] name={"test1","test2","test3","test4","test5","test6","test7","test8","test9","test10","test11","test12","test13","test14","test15","test16","test17","test18","test19","test20",};
    public static int[] mArray = {R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6
            ,R.drawable.album7,R.drawable.album8,R.drawable.album9,R.drawable.album10,R.drawable.album11,R.drawable.album1,R.drawable.album2,R.drawable.album3,R.drawable.album4,R.drawable.album5,R.drawable.album6,R.drawable.album7,R.drawable.album8,R.drawable.album9};

    public static int[] coffe_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int[] drinks_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static int[] dinner_list={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    public static String[] age_list={"0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0","0"};
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
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };


    private RecyclerView recyclerView;
    private AlbumsAdapter adapter;
    private List<Album> albumList;
    private ImageView settings;
    private LinearLayout messages,videomessages,likedme,liked,contact_admin,colombia,colombia1,usa,usa1,brazil,brazil1,lrv,cardrv,canada1,canada;
    private ImageView likedandme,normalmessage,videomessage,goprofile,col2;
    private TextView go,editprofile,col1,col3,contactad;
    private CardView card_view;
    public static Button coffee_image,drinks_image,dinner_image;
    private int preflag=0,nextflag=0;






    private Button sendinvitation;
    private Button submit, btnlogin_submit;
    private ImageView imageView_messgae;
    private LinearLayout lt1,lt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_list);

        sendinvitation=(Button) findViewById(R.id.sendinvitation);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



       // imageView_messgae=(ImageView) findViewById(R.id.imageView);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("");


        String url = "http://api.dateinvite.com/messages.json";

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



       /* imageView_messgae.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(MessageText.this, Chat.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });*/




/*
        lt1=(LinearLayout) findViewById(R.id.lt1);


        lt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(MessageText.this, Chat.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });


        lt2=(LinearLayout) findViewById(R.id.lt2);


        lt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DO YOUR CODE
                startActivity(new Intent(MessageText.this, Chat.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();

            }
        });*/

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                //startActivity(new Intent(MessageText.this,MainTest.class));
                startActivity(new Intent(MessageText.this,Page_Activity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });


        toolbar.setNavigationIcon(R.drawable.back_icon);


       /* Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
                startActivity(new Intent(Privacy.this,HomeActivity.class));
            }
        });*/



    }




    public void makeRequest( final String url, final VolleyCallback callback) {

        CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Log.v("Response321", response.toString());
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
                          MessageModelList=new ArrayList<>();
                            //respone_server = response.getString("response");
                            respone_server = response.getString("response");
                         //   JSONArray jarray = response.getJSONArray("messages");

                            JSONArray list = response.getJSONArray("messages");
                            ArrayList<AndroidVersion> android_version = new ArrayList<>();

                            if(list != null){

                                for(int i = 0; i <= list.length();i++){
                                   // JSONObject object = jarray.getJSONObject(i);

                                  //  String username1= object.getString("username");

                                 //   Log.v(" username1:",  username1);

                                    JSONObject elem = list.getJSONObject(i);
                                    Log.v("message1:", elem.getString("message"));
                                    Log.v("id1:", elem.getString("id"));

                                    Log.v("user:", elem.getString("user"));

                                    Log.v("date:", elem.getString("date"));

                                    String user1= elem.getString("user");

                                    Log.v("user1:", user1);


                                   // JSONParser parser = new JSONParser();
                                   // JSONObject json = (JSONObject) parser.parse(user1);

                                   // Log.v("state1:",json.getString("state"));
                                   // String test=json.getString("state");

                                    JSONObject parentObject = new JSONObject(user1);


                                    Log.v("username1:", parentObject.getString("username"));
                                    Log.v("city1:", parentObject.getString("city"));
                                    Log.v("country1:", parentObject.getString("country"));
                                    Log.v("state1:", parentObject.getString("state"));
                                    Log.v("age1:", parentObject.getString("age"));

                                    Log.v("photo:", parentObject.getString("photo"));

                                    location=elem.getString("city")+"  "+elem.getString("country");
                                    Log.v("location1:", location);





                                   MessageModel messageModel=new  MessageModel();
                                    messageModel.setUsername(CommonFunction.stringNullCheck(parentObject.getString("username")));
                                    messageModel.setLocation(CommonFunction.stringNullCheck(location));
                                    // contactBloodDonner.setPhone(CommonFunction.stringNullCheck(json.getString("user_phone")));


                                    messageModel.setMessage(CommonFunction.stringNullCheck(elem.getString("message")));
                                    messageModel.setAge(CommonFunction.stringNullCheck(parentObject.getString("age")));
                                    //messageModel.setDate(CommonFunction.stringNullCheck(json.getString("place_address")));
                                    MessageModelList.add(messageModel);
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

                               /* MessageCustomAdapter historyCustomAdapter = new  MessageCustomAdapter(MessageText.this, R.layout.message_text, MessageModelList);

                               MessageListView .setAdapter(historyCustomAdapter);*/
                                MessageCustomAdapter adapter = new MessageCustomAdapter(MessageText.this,MessageModelList);

                                //setting adapter to recyclerview
                                recyclerView.setAdapter(adapter);

                            }



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

                String creds = String.format("%s:%s","and6@test.com","970118cf50c71de453073dbec8bf605a");
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
