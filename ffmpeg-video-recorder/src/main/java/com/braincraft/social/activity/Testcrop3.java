package com.braincraft.social.activity;

import android.*;
import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
//import com.braincraft.social.dateinvite.*;
//import com.braincraft.social.dateinvite.Testcrop;
import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.braincraft.social.*;
import com.braincraft.social.R;
import com.braincraft.social.dateinvite.base.*;
import com.braincraft.social.dateinvite.base.AppHelper;
//import com.braincraft.social.dateinvite.base.AppHelper;
//import com.braincraft.social.dateinvite.base.*;

import junit.framework.Test;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



/**
 * Created by User on 4/7/2018.
 */

public class Testcrop3 extends Activity {

    ImageView imageView;
    //Button buttonCamera, buttonGallery ;
    TextView buttonnext,buttonCamera, buttonGallery;
    File file;
    Uri uri;
    Intent CamIntent, GalIntent, CropIntent ;
    public  static final int RequestPermissionCode  = 1 ;
    DisplayMetrics displayMetrics ;
    int width, height;
    String email_saved;
    String token_saved;

    int foo,emailpassflag=0;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;


    private static final String TAG = MainActivity.class.getSimpleName();
    private ImageView mAvatar;
    private Uri mCropImageUri;
    private LinearLayout mContainer;
    private  String filename;
    SharedPreferences shared;
    private Context mContext;
    public static ArrayList<String> arrPackage;
    private SessionManager mSessionManager;
    public static  ArrayList<String> places = new ArrayList<String>();
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.braincraft.social.R.layout.inphoto);

        // setContentView(R.layout.init_photo);

        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();


        email_saved = mPreferences.getString("email", "");
        token_saved = mPreferences.getString("token", "");

        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }

        imageView = (ImageView)findViewById(R.id.imageview);
        buttonCamera = (TextView)findViewById(R.id.button2);
        buttonGallery = (TextView)findViewById(R.id.button1);
        buttonnext = (TextView) findViewById(R.id.Next);
        mAvatar = findViewById(R.id.profile_avatar);

        EnableRuntimePermission();

        buttonCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ClickImageFromCamera() ;

            }
        });

        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GetImageFromGallery();

            }
        });
        buttonnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* startActivity(new Intent(Testcrop.this,InitCamera.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();*/





            }
        });



        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    public void ClickImageFromCamera() {

        CamIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

        file = new File(Environment.getExternalStorageDirectory(),
                "file" + String.valueOf(System.currentTimeMillis()) + ".jpg");
        uri = Uri.fromFile(file);

        CamIntent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, uri);

        CamIntent.putExtra("return-data", true);

        startActivityForResult(CamIntent, 0);

    }

    public void GetImageFromGallery(){

        GalIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(Intent.createChooser(GalIntent, "Select Image From Gallery"), 2);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {

            ImageCropFunction();
            uploadAvatar();


        }
        else if (requestCode == 2) {

            if (data != null) {

                uri = data.getData();

                ImageCropFunction();



                uploadAvatar();
            }
        }
        else if (requestCode == 1) {

            if (data != null) {

                Bundle bundle = data.getExtras();

                Bitmap bitmap = bundle.getParcelable("data");

                imageView.setImageBitmap(bitmap);
                uploadAvatar();
               /* startActivity(new Intent(Testcrop.this,InitCamera.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
              finish();*/







            }
        }
    }

    public void ImageCropFunction() {

        // Image Crop Code
        try {
            CropIntent = new Intent("com.android.camera.action.CROP");

            CropIntent.setDataAndType(uri, "image/*");

            CropIntent.putExtra("crop", "true");
            CropIntent.putExtra("outputX", 180);
            CropIntent.putExtra("outputY", 180);
            CropIntent.putExtra("aspectX", 9);
            CropIntent.putExtra("aspectY", 16);
            CropIntent.putExtra("scaleUpIfNeeded", true);
            CropIntent.putExtra("return-data", true);

            startActivityForResult(CropIntent, 1);

        } catch (ActivityNotFoundException e) {

        }
    }
    //Image Crop Code End Here

    public void EnableRuntimePermission(){

        if (ActivityCompat.shouldShowRequestPermissionRationale(Testcrop3.this,
                android.Manifest.permission.CAMERA))
        {

            Toast.makeText(Testcrop3.this,"CAMERA permission allows us to Access CAMERA app", Toast.LENGTH_LONG).show();

        } else {

            ActivityCompat.requestPermissions(Testcrop3.this,new String[]{
                    Manifest.permission.CAMERA}, RequestPermissionCode);

        }
    }

    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    //Toast.makeText(Testcrop.this,"Permission Granted, Now your application can access CAMERA.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(Testcrop3.this,"Permission Canceled, Now your application cannot access CAMERA.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }


    private void uploadAvatar() {
       /* final ProgressDialog progressDialog = new ProgressDialog(Testcrop3.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();*/
        // progressDialog.setMessage("Uploading Avatar...");
        //progressDialog.show();

        final String id = "1";
        String url = "http://api.dateinvite.com/photos/upload.json";
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                // progressDialog.dismiss();
                String resultResponse = new String(response.data);
                try {
                    JSONObject obj = new JSONObject(resultResponse);
                    Log.d(TAG, "Response3:" + resultResponse);
                    // JSONObject object = new JSONObject(json);
                    filename = obj.getString("filename");
                    Log.v("filename:",  filename);

                    places.add(filename);
                    Log.v("size1:", String.valueOf(places.size()));

                    Log.v("filename:",  filename);


                    mSharedPreferences = getPreferences(Context.MODE_PRIVATE);

                    // Get SharedPreferences editor
                    mEditor = mSharedPreferences.edit();
                    Set colorsSet = new HashSet();

                    // add all the colors to the Set
                    colorsSet.addAll(places);

                    mEditor.putStringSet(
                            "key",
                            colorsSet
                    );
                    mEditor.apply();






                    changephoto();

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "JSON Error: " + e);
                    //showUploadSnackBar();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // progressDialog.dismiss();
                Log.d(TAG, "Volley Error: " + error);
                //  showUploadSnackBar();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<String, String>();
                //String creds = String.format("%s:%s","and5@test.com","123123");
                // Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                //  Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                // String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
                // String creds = String.format("%s:%s","t2@test.com","15ab5efa606ea9f5002f206c0af2046f");
                //String creds = String.format("%s:%s",mail,token);
                Log.v("email_saved:", email_saved);
                Log.v("token_saved:", token_saved);


                // String creds = String.format("%s:%s","t1@test.com","da6f885eb0d26f06ecc8c6021924c94d");
                String creds = String.format("%s:%s",email_saved,token_saved);
                String auth = "Basic " + Base64.encodeToString(creds.getBytes(), Base64.DEFAULT);
                params.put("Authorization", auth);



                return params;
            }
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }


            @Override
            protected Map<String, VolleyMultipartRequest.DataPart> getByteData() {
                Map<String, VolleyMultipartRequest.DataPart> params = new HashMap<>();
                if (mAvatar == null) {
                    Log.i(TAG, "avatar null");
                }
                //params.put("avatar", new DataPart("img_" + id + ".jpg", AppHelper.getFileDataFromDrawable(getApplicationContext(), mAvatar.getDrawable()), "image/jpg"));
                params.put("avatar", new VolleyMultipartRequest.DataPart("img_" + id + ".jpg", AppHelper.getFileDataFromDrawable(getApplicationContext(), imageView .getDrawable()), "image/jpg"));
                // imageView  params.put("avatar", new DataPart("img_" + id + ".mp4", AppHelper.getFileDataFromDrawable(getApplicationContext(), mAvatar.getDrawable()), "video/mp4"));

                return params;
            }
        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // Myapp.getInstance().addToRequestQueue(multipartRequest);
        com.braincraft.social.dateinvite.base.MyApplication.getInstance().addToRequestQueue(multipartRequest);
    }

    /**
     * SnackBar to retry in case of network issues
     */
   /* private void showUploadSnackBar() {
        Snackbar.make(mContainer, "Network Error. Failed to upload avatar", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uploadAvatar();
                    }
                }).show();
    }*/


    public void changephoto()
    {



        //  Log.i(TAG, "likeflagoff1:" + likeflag);


        //  Log.i(TAG, "likeflagoff2:" + likeflag);



        String url_like = "http://api.dateinvite.com/users/save.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {

            jsonBody = new JSONObject();
            jsonBody.put("photo",filename);


                   /* JSONArray arr = new JSONArray();

                    ArrayList<String> myAList=new ArrayList<String>();



                    Set<String> colorsSet =mSharedPreferences.getStringSet("key", null);

                    for(String color : colorsSet){
                      //  mTextView.setText(mTextView.getText() + "\n" + color);
                        arr.put(color);
                    }


                   int l=places.size();
                    Log.v("size:", String.valueOf(l));


                    jsonBody.put("photos", arr);

                    Log.v("array:", arr.toString());
                    JSONObject jsonObj = new JSONObject(arr.toString());
                    Log.v("Response_liked", jsonObj.toString());*/
/*
                   //photos code
                    JSONArray arr = new JSONArray();
                    arr.put("a12133d94af70e914cc1cff741f6a55b");
                    arr.put("e7158cc8380abc75726bfcb57a66d610");
                    jsonBody.put("photos", arr);
*/
            //  Log.v("filename:",  jsonBody);

                    /*JSONArray arr = new JSONArray();
                    arr.put("a12133d94af70e914cc1cff741f6a55b");
                    arr.put("e7158cc8380abc75726bfcb57a66d610");

                    JSONObject json = new JSONObject();
                    json.put("photo", arr);*/
                    /*JSONObject jsonObjSend = new JSONObject();
                    JSONArray arr = new JSONArray();
                    arr.put("1e49cc644dce03064bb30e69e978bbfd");
                   // arr.put("value2");
                    jsonObjSend.put("photos", arr);*/
                   /* JSONObject jsonObjSend = new JSONObject();
                    jsonObjSend.put("elementi", new JSONArray(new Object[] { "a12133d94af70e914cc1cff741f6a55b"} ));*/

        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {

                Log.v("Responsephotos1", response.toString());



                try {





                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.v("Responsephotos", error.toString());
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
                //String creds = String.format("%s:%s","and5@test.com","123123");
                // Log.i(TAG, "editTextEmai2:" +    editTextEmail.getText().toString());
                //  Log.i(TAG, "editTextPassword2:" +editTextPassword.getText().toString());
                // String creds = String.format("%s:%s", editTextEmail.getText().toString(),editTextPassword.getText().toString());
                //  String creds = String.format("%s:%s","t2@test.com","15ab5efa606ea9f5002f206c0af2046f");
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

        //}




        Intent intent = new Intent(Testcrop3.this,InitCamera.class);

        intent.putExtra("token", token);
        intent.putExtra("mail",mail);
        overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Successful",
                Toast.LENGTH_LONG).show();



    }

}
