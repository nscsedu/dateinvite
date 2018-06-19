package com.braincraft.social.dateinvite;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ADMIN on 17/4/2018.
 */

public class VideoUploadtoServer extends Activity implements View.OnClickListener {


    private static final String CHANNEL_LIST_URL = "http://www.shopgallery.co.za/magura_youtube/VideoUpload/listinfo.php";
    //
    public static final String KEY_VIDEO_UPLODER_NAME = "username";
    public static final String KEY_VIDEO_UPLODER_PHONE = "userPhoneNo";
    public static final String KEY_VIDEO_TITLE = "video_title";
    public static final String KEY_VIDEO_DESCRIPTION = "video_description";
    public static final String KEY_VIDEO_FILE_NAME = "video_file_name";


    private EditText edt_txt_post_name;
    private EditText edt_txt_post_phone_no;
    private EditText edt_txt_video_title;
    private EditText edt_txt_video_descript;

    private Button btn_choose_file,btn_post_submit;
    private Button buttonUpload;
    private TextView txt_path;
    private TextView textViewResponse;

    private static final int SELECT_VIDEO = 3;
    private String selectedPath;
    private static final int PERMISSION_REQUEST_CODE = 1;


    private TextView back;
    private int pos,select_gen=0,select_interest=0,i_man=0,i_woman=0,in_man=0,in_woman=0,flagtest=0,type_manwoman=0,interested_manwoman=0;
    private Button confirm,iam_man,iam_woman,interestedin_man,interestedin_woman;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_upload_screen);






        btn_choose_file = (Button) findViewById(R.id.btn_choose_file);
        // buttonUpload = (Button)rootView. findViewById(R.id.buttonUpload);
        btn_post_submit = (Button) findViewById(R.id.btn_post_submit);

        txt_path = (TextView) findViewById(R.id.txt_path);
        textViewResponse = (TextView)findViewById(R.id.textViewResponse);

        btn_choose_file.setOnClickListener(this);
        btn_post_submit.setOnClickListener(this);




        if (Build.VERSION.SDK_INT >= 23)
        {
            if (checkPermission())
            {
                // Code for above or equal 23 API Oriented Device
                // Your Permission granted already .Do next code
            } else {
                requestPermission(); // Code for permission
            }
        }
        else
        {

            // Code for Below 23 API Oriented Device
            // Do next code
        }




    }

    private void chooseVideo() {
        Intent intent = new Intent();
        intent.setType("video/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select a Video "), SELECT_VIDEO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_VIDEO) {
                System.out.println("SELECT_VIDEO");
                Uri selectedImageUri = data.getData();
                selectedPath = getPath(selectedImageUri);
                txt_path.setText(selectedPath);
            }
        }
    }

    public String getPath(Uri uri) {

        Cursor cursor =  this.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        String document_id = cursor.getString(0);
        document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
        cursor.close();

        cursor = this.getContentResolver().query(
                MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                null, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
        cursor.moveToFirst();
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.Video.Media.DATA));
        cursor.close();

        return path;
    }

    private void uploadVideo() {
        class UploadVideo extends AsyncTask<Void, Void, String> {
            //            final String username = edt_txt_post_name.getText().toString().trim();
//            final String video_title = edt_txt_video_title.getText().toString().trim();
//            final String video_description = edt_txt_video_descript.getText().toString().trim();
            ProgressDialog uploading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                //uploading = ProgressDialog.show(getActivity(), "Uploading File", "Please wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                uploading.dismiss();
                textViewResponse.setText(Html.fromHtml("<b>Uploaded at <a href='" + s + "'>" + s + "</a></b>"));
                textViewResponse.setMovementMethod(LinkMovementMethod.getInstance());
                /*edt_txt_post_name.setText("");
                edt_txt_post_phone_no.setText("");
                edt_txt_video_title.setText("");
                edt_txt_video_descript.setText("");*/
            }

            @Override
            protected String doInBackground(Void... params) {



                Upload u = new Upload();
                String msg = u.upLoad2Server(selectedPath);
                //  String msg = u.upLoad2Server(username,video_title,video_description,selectedPath);
                return msg;
            }
        }
        UploadVideo uv = new UploadVideo();
        uv.execute();
    }


    private void updateUserBasicInfo() {
        //pd = ProgressDialog.show(getActivity(),"","Updating data please wait");
        final StringRequest stringRequest = new StringRequest(Request.Method.POST, CHANNEL_LIST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {

                            JSONObject patientInfoObject = new JSONObject(response);

                            //Toast.makeText(getActivity(),response,Toast.LENGTH_LONG).show();
                            Log.e("response",response.toString()+"<<<<");



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                       // Toast.makeText(getActivity(),error.toString(),Toast.LENGTH_LONG).show();
                        Log.e("VolleyError",error.toString()+"<<<<");

                    }
                }) {


            @Override
            public String getBodyContentType() {
                //return "application/json; charset=utf-8";
                return "application/x-www-form-urlencoded";
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                //Adding parameters to request

                /*params.put("username", edt_txt_post_name.getText().toString());
                params.put("video_title", edt_txt_video_title.getText().toString());
                params.put("video_description", edt_txt_video_descript.getText().toString());*/
                params.put("video_file_name", txt_path.getText().toString());
               /* params.put("userPhoneNo", edt_txt_post_phone_no.getText().toString());*/
                //  params.put("Content-Type", "application/json; charset=utf-8");

                Log.e("param",params+"");
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }

    private void requestPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(this, "Write External Storage permission allows us to do store images. Please allow this permission in App Settings.", Toast.LENGTH_LONG).show();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Log.e("value", "Permission Granted, Now you can use local drive .");
                } else {
                    Log.e("value", "Permission Denied, You cannot use local drive .");
                }
                break;
        }
    }


    @Override
    public void onClick(View v) {

        if (v == btn_choose_file) {
            chooseVideo();
        }
        if (v == btn_post_submit) {

           /* if(edt_txt_post_name.getText().toString().equals("")){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show();
            }else if(edt_txt_post_phone_no.getText().toString().equals("")){
                Toast.makeText(this,"Please enter phone no",Toast.LENGTH_LONG).show();
            }else if(edt_txt_video_title.getText().toString().equals("")){
                Toast.makeText(this,"Please enter video title",Toast.LENGTH_LONG).show();
            }else if(edt_txt_video_descript.getText().toString().equals("")){
                Toast.makeText(this,"Please enter video description",Toast.LENGTH_LONG).show();
            }*/ if(txt_path.getText().toString().equals("")){
                Toast.makeText(this,"Please Choose a Video",Toast.LENGTH_LONG).show();
            } else {
                startActivity(new Intent(VideoUploadtoServer.this,WelcomeActivity.class));
               // uploadVideo();
                //updateUserBasicInfo();
                // videoInformation();

            }
//


        }
    }

}


