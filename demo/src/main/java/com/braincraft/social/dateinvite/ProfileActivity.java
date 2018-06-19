package com.braincraft.social.dateinvite;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.braincraft.social.dateinvite.R;

import com.braincraft.social.dateinvite.base.AppHelper;
import com.braincraft.social.dateinvite.base.MyApplication;
import com.braincraft.social.dateinvite.base.VolleyMultipartRequest;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import id.zelory.compressor.Compressor;

import com.android.volley.toolbox.Volley;


import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = ProfileActivity.class.getSimpleName();



    TextView buttonnext,buttonCamera, buttonGallery;
    File file;
    Uri uri;
    Intent CamIntent, GalIntent, CropIntent ;




    private ImageView mAvatar;
    private Uri mCropImageUri;
    private LinearLayout mContainer;
    private  String filename;

    private SessionManager mSessionManager;


    int foo,emailpassflag=0;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profileupdate);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




            Log.v("firsttoken", token);
            Log.v("firstmail", mail);

        }

        //initiate shared preferences handler class
        mSessionManager = new SessionManager(this);

        mContainer = findViewById(R.id.container);
        mAvatar = findViewById(R.id.profile_avatar);
        TextView  cameraAction = findViewById(R.id.camera_action);
        TextView  galleryAction = findViewById(R.id.button1);

        //Check if avatar previously uploaded in preferences and load url
        if (!"hello".equalsIgnoreCase(mSessionManager.getUrl())) {
            //Picasso library to display images
            Picasso.get().load(mSessionManager.getUrl()).placeholder(R.drawable.lissa).into(mAvatar);
        }

        cameraAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
                //ClickImageFromCamera();
            }
        });
        galleryAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });
    }

    /**
     * Show image chooser options
     * Uses https://github.com/ArthurHub/Android-Image-Cropper library
     * to generate square images.
     * Replace with your own if you don't need the image cropper library
     */
    private void selectImage() {
        CropImage.startPickImageActivity(this);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        // handle result of pick image chooser
        if (requestCode == CropImage.PICK_IMAGE_CHOOSER_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            Uri imageUri = CropImage.getPickImageResultUri(this, data);

            // For API >= 23 we need to check specifically that we have permissions to read external storage.
            if (CropImage.isReadExternalStoragePermissionsRequired(this, imageUri)) {
                // request permissions and handle the result in onRequestPermissionsResult()
                mCropImageUri = imageUri;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 0);
                }
            } else {
                // no permissions required or already grunted, can start crop image activity
                startCropImageActivity(imageUri);
            }


        }

        // handle result of CropImageActivity
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri uri = result.getUri();
                try {
                    //Uses https://github.com/zetbaitsu/Compressor library to compress selected image
                    File file = new Compressor(this).compressToFile(new File(uri.getPath()));
                    Picasso.get().load(file).into(mAvatar);
                    Toast.makeText(this, "Compressed", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Failed Compress", Toast.LENGTH_SHORT).show();
                    Picasso.get().load(uri).into(mAvatar);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        uploadAvatar();
                    }
                }, 1000);
            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                //TODO handle cropping error
                Toast.makeText(this, "Cropping failed: " + result.getError(), Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (mCropImageUri != null && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            // required permissions granted, start crop image activity
            startCropImageActivity(mCropImageUri);
        } else {
            Toast.makeText(this, "Cancelling, required permissions are not granted", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Start crop image activity for the given image.
     */
    private void startCropImageActivity(Uri imageUri) {
        CropImage.activity(imageUri)
                .setGuidelines(CropImageView.Guidelines.ON)
                .setAllowFlipping(false)
                .setActivityTitle("Crop Image")
                .setCropMenuCropButtonIcon(R.drawable.ic_check)
                .setAllowRotation(true)
                .setInitialCropWindowPaddingRatio(0)
                .setFixAspectRatio(true)
                .setAspectRatio(1, 1)
                .setOutputCompressQuality(80)
                .setOutputCompressFormat(Bitmap.CompressFormat.JPEG)
                .setMultiTouchEnabled(true)
                .start(this);
    }

    /**
     * Upload image selected using volley
     */
    private void uploadAvatar() {
       // final ProgressDialog progressDialog = new ProgressDialog(this);
       // final ProgressDialog progressDialog = new ProgressDialog(ProfileActivity.this,R.style.MyAlertDialogStyle);
        final ProgressDialog progressDialog = new ProgressDialog(ProfileActivity.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.show();

        final String id = "1";
        String url = "http://api.dateinvite.com/photos/upload.json";
        VolleyMultipartRequest multipartRequest = new VolleyMultipartRequest(Request.Method.POST, url, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
                progressDialog.dismiss();
                String resultResponse = new String(response.data);
                try {
                    JSONObject obj = new JSONObject(resultResponse);
                    Log.d(TAG, "Response3:" + resultResponse);
                    // JSONObject object = new JSONObject(json);
                    filename = obj.getString("filename");
                    Log.v("filename:",  filename);

                    changephoto();
                    /*if (!obj.getBoolean("error")) {
                        String avatar = obj.getString("avatar");
                        mSessionManager.setUrl(avatar);
                        // Picasso.get().load(avatar).placeholder(R.drawable.lissa).into(mAvatar);
                        Toast.makeText(MainActivity.this, "Avatar Changed", Toast.LENGTH_SHORT).show();
                    } else {
                        Log.d(TAG, "Response: " + resultResponse);
                    }*/
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "JSON Error: " + e);
                    showUploadSnackBar();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Log.d(TAG, "Volley Error: " + error);
                showUploadSnackBar();
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
                Map<String, String> params = new HashMap<>();
                params.put("id", id);
                return params;
            }


            @Override
            protected Map<String, DataPart> getByteData() {
                Map<String, DataPart> params = new HashMap<>();
                if (mAvatar == null) {
                    Log.i(TAG, "avatar null");
                }
                params.put("avatar", new DataPart("img_" + id + ".jpg", AppHelper.getFileDataFromDrawable(getApplicationContext(), mAvatar.getDrawable()), "image/jpg"));
                //  params.put("avatar", new DataPart("img_" + id + ".mp4", AppHelper.getFileDataFromDrawable(getApplicationContext(), mAvatar.getDrawable()), "video/mp4"));

                return params;
            }
        };

        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(5000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MyApplication.getInstance().addToRequestQueue(multipartRequest);
    }

    /**
     * SnackBar to retry in case of network issues
     */
    private void showUploadSnackBar() {

        Toast.makeText(getApplicationContext(), "Network Error",
                Toast.LENGTH_LONG).show();

      /*  Snackbar.make(mContainer, "Network Error. Failed to upload avatar", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        uploadAvatar();
                    }
                }).show();*/
    }


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


            //photos code
                   /* JSONArray arr = new JSONArray();
                    arr.put("filename");

                    jsonBody.put("photos", arr);*/


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
                String creds = String.format("%s:%s",mail,token);
                //  String creds = String.format("%s:%s","t2@test.com","15ab5efa606ea9f5002f206c0af2046f");
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





      /*  Intent intent = new Intent(ProfileActivity.this,Terms.class);

        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Successful",
                Toast.LENGTH_LONG).show();*/


        Intent intent = new Intent(ProfileActivity.this,InitCamera.class);

        intent.putExtra("token", token);
        intent.putExtra("mail",mail);
        overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
        startActivity(intent);
        Toast.makeText(getApplicationContext(), "Successful",
                Toast.LENGTH_LONG).show();



    }


}
