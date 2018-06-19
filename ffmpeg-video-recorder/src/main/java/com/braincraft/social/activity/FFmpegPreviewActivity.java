package com.braincraft.social.activity;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.CallSuper;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.DecelerateInterpolator;
import android.webkit.PermissionRequest;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.bikomobile.multipart.Multipart;
import com.bikomobile.multipart.Utils.BytesUtils;
import com.bikomobile.multipart.Utils.SplitBytes;
import com.braincraft.social.R;
import com.braincraft.social.activity.params.ActivityThemeParamsI;
import com.braincraft.social.activity.params.FFmpegPreviewActivityParams;
import com.braincraft.social.recorder.MediaClipsRecorder;
import com.braincraft.social.ui.ViewUtil;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.braincraft.social.activity.chatmessage.name11;

public class FFmpegPreviewActivity
        extends AbstractDynamicStyledActivity
        implements OnClickListener, OnCompletionListener, Callback, OnVideoSizeChangedListener,
                OnLayoutChangeListener {

    private static final String TAG = FFmpegPreviewActivity.class.getSimpleName();

    private static final String UPLOAD_URL = "http://media.dateinvite.com/upload.php";
    public static final String REQUEST_PARAMS_KEY = "params";

    public static final int RESULT_ERROR = RESULT_FIRST_USER;
    public static final String RESULT_ERROR_PATH_KEY = "error";

    private static final String LOG_TAG = "FFmpegPreviewActivity";

    protected static final int PROGRESS_UPDATE_INTERVAL_MILLIS = 50;
    public String Path,PathImage;


String responsetovideo;
    private Uri mVideoUri = null;
    private Uri mImageUri = null;

    private static final int SELECT_PHOTO_REQUEST_CODE = 100;
    private static final int SELECT_VIDEO_REQUEST_CODE = 101;
    String email_saved,email_saved1;
    String token_saved,token_saved1;
    ProgressDialog loading;
    // User params
    protected FFmpegPreviewActivityParams mParams;

    // UI variables
    protected RelativeLayout mPreviewVideoParent,previe_text;
    protected SurfaceView mSurfaceView;
    protected ImageView mPlayButton;
    protected ProgressBar mProgressBar;
    protected MediaClipsRecorder mMediaClipsRecorder;
    // State variables
    protected MediaPlayer mMediaPlayer;
    protected int mVideoWidth;
    protected int mVideoHeight;
    protected Button Back,deletefile,nextpage;
    protected DecelerateInterpolator mInterpolator;
    private  String hash_id;
    int foo,emailpassflag=0;
    public static  String token="token";
    public static   String mail="test@test.com";
    public String gender,lookingfor;
    String videoflag="0";
    String videosendid="0";
    int vsendid=0;
    private SharedPreferences mPreferences4,mPreferencesv,mPreferences5;
    public static SharedPreferences.Editor mEditor4,mEditorv,mEditor5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences mPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor2 = mPreferences2.edit();
         videoflag = mPreferences2.getString("videoflag", "");
        videosendid = mPreferences2.getString("videosendid", "");
//        vsendid = Integer.parseInt(videosendid);
        Log.v("videosendid", videosendid);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            token = bundle.getString("token");
            mail = bundle.getString("mail");




//            Log.v("fftoken", token);
            //Log.v("ffmail", mail);

        }

        if (!extractIntentParams()) {
            return;
        }
        layoutView();
        setupToolbar((Toolbar) findViewById(R.id.toolbar));

        mPreviewVideoParent = (RelativeLayout) findViewById(R.id.preview_video_parent);
        mPreviewVideoParent.addOnLayoutChangeListener(this);


        previe_text = (RelativeLayout) findViewById(R.id.preview_text);
        mPreviewVideoParent.addOnLayoutChangeListener(this);

        mSurfaceView = (SurfaceView) findViewById(R.id.preview_video);
        mSurfaceView.getHolder().addCallback(this);
        mSurfaceView.setOnClickListener(this);

        mPlayButton = (ImageView) findViewById(R.id.play_button);
        mPlayButton.setOnClickListener(this);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mProgressBar.setProgressDrawable(ViewUtil.tintDrawable(
                mProgressBar.getProgressDrawable(), getThemeParams().getProgressColor()));

        mInterpolator = new DecelerateInterpolator();


        Back = (Button) findViewById(R.id.back);
        Back.setOnClickListener(this);
        deletefile = (Button) findViewById(R.id.delete_file);
        deletefile.setOnClickListener(this);


        nextpage = (Button) findViewById(R.id.nextpage);
        nextpage.setOnClickListener(this);


        SharedPreferences mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = mPreferences.edit();


         email_saved = mPreferences.getString("smail", "");
        token_saved = mPreferences.getString("stoken", "");


        Log.v("email_saved111", email_saved);
        Log.v("token_saved111", token_saved);

       // previe_text.setVisibility(View.VISIBLE);
    }

    @Override
    protected void layoutView() {
        setContentView(R.layout.activity_ffmpeg_preview);
    }

    @Override
    protected boolean extractIntentParams() {
        Intent intent = getIntent();
        mParams = (FFmpegPreviewActivityParams)
                        intent.getSerializableExtra(REQUEST_PARAMS_KEY);
        if (mParams == null) {
            onError(new InvalidParameterException(
                    "Intent did not have FFmpegPreviewActivity.REQUEST_PARAMS_KEY set."));
            return false;
        }
        return true;
    }

    @Override
    protected ActivityThemeParamsI getThemeParams() {
        return mParams.getThemeParams();
    }

    @Override
    protected void setupToolbar(android.support.v7.widget.Toolbar toolbar) {
        super.setupToolbar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationIcon(ViewUtil.tintDrawable(
                toolbar.getNavigationIcon(), getThemeParams().getToolbarWidgetColor()));
    }

    @Override
    @CallSuper
    public boolean onCreateOptionsMenu(final Menu menu) {
       /* if (mParams.isConfirmation()) {
            getMenuInflater().inflate(R.menu.menu_done, menu);
            MenuItem menuItemFinish = menu.findItem(R.id.menu_finish);
            if (menuItemFinish != null) {
                Drawable menuItemFinishIcon = menuItemFinish.getIcon();
                if (menuItemFinishIcon != null) {
                    menuItemFinish.setIcon(ViewUtil.tintDrawable(
                            menuItemFinishIcon, getThemeParams().getToolbarWidgetColor()));
                }
            }
        }*/
        return true;
    }

    @Override
    @CallSuper
    public boolean onOptionsItemSelected(MenuItem item) {
       /* if (item.getItemId() == R.id.menu_finish) {
            finishWithResult(RESULT_OK);
            return true;
        } else {*/
            return super.onOptionsItemSelected(item);
        //}
    }

    @Override
    protected void onPause() {
        if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
            mMediaPlayer.pause();
            mPlayButton.setVisibility(View.VISIBLE);
        }
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.play_button) {
            if (mMediaPlayer != null && !mMediaPlayer.isPlaying()) {
                previe_text.setVisibility(View.GONE);
                play();
            }
            mPlayButton.setVisibility(View.GONE);
          //  mPlayButton.setVisibility(View.VISIBLE);
        } else if (id == R.id.preview_video) {
            if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                pause();
            }
        }
        else if (id == R.id.delete_file) {
            if (mMediaPlayer != null && !mMediaPlayer.isPlaying()) {


                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                //Do your Yes progress



                                File file = new File(Path);

                                Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
                                Log.v("log_tag","deleted234: " + Path);
                                Log.v("log_tag","converturi:" +Uri.fromFile(file));
                                Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
                                Uri uriFromPath = Uri.fromFile(new File(Path));
                                Log.v("log_tag","deleted234: " + uriFromPath);

                                boolean deleted = file.delete();

                                File fileimage = new File(PathImage);
                                boolean deletedimage = fileimage.delete();
                                Log.v("log_tag","deletedimage: " + deletedimage);



                             /*   Toast.makeText(getApplicationContext(), " Video deleted", Toast.LENGTH_LONG).show();


                                Intent i = getBaseContext().getPackageManager()
                                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);*/
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //Do your No progress
                                break;
                        }
                    }
                };
                AlertDialog.Builder ab = new AlertDialog.Builder(this);
                ab.setMessage("Are you sure to delete?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();



/* right code
                File file = new File(Path);
                boolean deleted = file.delete();
                Log.v("log_tag","deleted: " + deleted);*/


           /*  String   dir="/data/user/0/com.braincraft.videorecorder.demo/testfolder";


                File myDir = new File(Environment.getExternalStorageDirectory() + "/"+dir);
                if (myDir.isDirectory()) {
                    String[] children = myDir.list();
                    for (int i = 0; i < children.length; i++) {
                        new File(myDir, children[i]).delete();
                    }
                }*/



                //mMediaClipsRecorder.deleteClips();
            //mMediaClipsRecorder.removeLastClip();
               /* File file = new File(selectedFilePath);
                boolean deleted = file.delete();*/

              /*  File dir = getFilesDir();
                Log.i(LOG_TAG, "dir:" + dir);
                File file = new File(dir, "myfilename");
                boolean deleted = file.delete();*/

               // new File(Uri.parse(mParams.getVideoFileUri()).toString).delete();


               // Toast.makeText(getApplicationContext(), " item deleted...", Toast.LENGTH_LONG).show();
            }

        }
        else if (id == R.id.back) {

           // firstvideo()

           /* File file = new File(Path);

            Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
            Log.v("log_tag","deleted234: " + Path);
            Log.v("log_tag","converturi:" +Uri.fromFile(file));
            Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
            Uri uriFromPath = Uri.fromFile(new File(Path));
            Log.v("log_tag","deleted234: " + uriFromPath);

            uploadVideo("test", Uri.parse(new File(Path).toString()));*/
            //  changevideo();
            //Toast.makeText(FFmpegPreviewActivity.this, "Video Saved to :/DateInvite", Toast.LENGTH_SHORT).show();
            /*Intent intent = new Intent(this, FFmpegRecorderActivity.class);
            startActivity(intent);
            finish();*/


           /* Intent i = getBaseContext().getPackageManager()
                    .getLaunchIntentForPackage( getBaseContext().getPackageName() );
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i);

             File file = new File(Path);

                                Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
                                Log.v("log_tag","deleted234: " + Path);
                                Log.v("log_tag","converturi:" +Uri.fromFile(file));
                                Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
                                Uri uriFromPath = Uri.fromFile(new File(Path));
                                Log.v("log_tag","deleted234: " + uriFromPath);

            */
           // launchSelectedVideo();

           /* File file = new File(Path);

            Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
            Log.v("log_tag","Path234: " + Path);
            Log.v("log_tag","converturi:" +Uri.fromFile(file));
            Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
            Uri uriFromPath = Uri.fromFile(new File(Path));
            Log.v("log_tag","deleted234: " + uriFromPath);

           // uploadVideo("test", Uri.parse(new File(Path).toString()));
            mPreferencesv = PreferenceManager.getDefaultSharedPreferences(this);

            mEditorv = mPreferencesv.edit();


            mEditorv.putString("Path",Path);

            mEditorv.commit();*/


          //  changevideo();
            Toast.makeText(FFmpegPreviewActivity.this, "Video Saved to :/DateInvite", Toast.LENGTH_SHORT).show();
            /*if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                if (mParams.isConfirmation()) {
                    new AlertDialog.Builder(this)
                            .setCancelable(false)
                            .setTitle(R.string.are_you_sure)
                            .setMessage(R.string.discard_video_msg)
                            .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finishWithResult(RESULT_CANCELED);
                                }
                            })
                            .setNegativeButton(R.string.cancel, null)
                            .show();
                } else {
                    finishWithResult(RESULT_CANCELED);
                }
            }*/
        }
        //mPreferences5 = PreferenceManager.getDefaultSharedPreferences(this);
        else if (id == R.id.nextpage) {







          //  File file = new File(Path);
            //  boolean deleted = file.delete();
          //  Log.v("log_tag", "path123: " + file);

            String name = "test";

            ;
            Log.v("log_tag", "videoflag:" + videoflag);



            File file = new File(Path);

            Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
            Log.v("log_tag","Path234: " + Path);
            Log.v("log_tag","converturi:" +Uri.fromFile(file));
            Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
            Uri uriFromPath = Uri.fromFile(new File(Path));
            Log.v("log_tag","deleted234: " + uriFromPath);

            // uploadVideo("test", Uri.parse(new File(Path).toString()));
            mPreferencesv = PreferenceManager.getDefaultSharedPreferences(this);

            mEditorv = mPreferencesv.edit();


            mEditorv.putString("Path",Path);

            mEditorv.commit();
            //videoflag="1";
            if (videoflag.toLowerCase().contains("1"))

            {firstvideo();
               /* File file = new File(Path);

                Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
                Log.v("log_tag","Path234: " + Path);
                Log.v("log_tag","converturi:" +Uri.fromFile(file));
                Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
                Uri uriFromPath = Uri.fromFile(new File(Path));
                Log.v("log_tag","deleted234: " + uriFromPath);*/

                 //uploadVideo("test", Uri.parse(new File(Path).toString()));



                vsendid = Integer.parseInt(videosendid);
                mPreferences4 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

                mEditor4 = mPreferences4.edit();


                mEditor4.putString("videoflag","0");
               // Log.v("log_tag", "path123: " + file);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                        if (!hash_id.equals("0"))
                        {
                           // changevideo();
                            sendvideo();
                        }
                    }
                }, 10000);

               // sendvideo();

              /* if( responsetovideo.toLowerCase().contains("The video was sent!".toLowerCase()))

                {
                    Intent intent = new Intent(FFmpegPreviewActivity.this,Page_Activity4.class);
                    overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                    startActivity(intent);
                }*/
              /*  Intent intent = new Intent(FFmpegPreviewActivity.this,Page_Activity4.class);


               overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);*/
            //  last();
            }

            else
            {
               // changevideo();
            mPreferences5 = PreferenceManager.getDefaultSharedPreferences(this);
            mEditor5 = mPreferences5.edit();


            mEditor5.putString("hash_id",hash_id);

            mEditor5.commit();


                Intent intent = new Intent(FFmpegPreviewActivity.this,InformationActivity.class);

                intent.putExtra("token",token_saved);
                intent.putExtra("mail",email_saved);
                overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
                startActivity(intent);

            }

           /* Intent intent = new Intent(FFmpegPreviewActivity.this,InformationActivity.class);

            intent.putExtra("token",token_saved);
            intent.putExtra("mail",email_saved);
            overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
            startActivity(intent);
            Toast.makeText(getApplicationContext(), "Successful",
                    Toast.LENGTH_LONG).show();*/

          //  Uri.fromFile(file);

            Log.v("log_tag","uri:" +Uri.fromFile(file));

          // uploadVideo(name, Uri.fromFile(file));



            //startActivity(new Intent(FFmpegPreviewActivity.this, InformationActivity.class));

           // uploadVideo(name, mVideoUri);

           /*  Intent intent = new Intent(this, InformationActivity.class);
            startActivity(intent);
            finish();*/

           // startActivity(new Intent(FFmpegPreviewActivity.this,InformationActivity.class));
           // Toast.makeText(FFmpegPreviewActivity.this, "Video Saved to :/DateInvite", Toast.LENGTH_SHORT).show();

          /*  File file = new File(Path);
          //  boolean deleted = file.delete();
            Log.v("log_tag","path123: " + file);



                if (array == null || array.size() <= part) {
                    loading.dismiss();
                    return;
                }

                final Multipart multipart = new Multipart(getApplicationContext());

                multipart.addParam("title", title);
                multipart.addParam("chunk", "" + (part+1));
                multipart.addParam("chunks", "" + array.size());

                SplitBytes.Bytes bytes = array.get(part);
                multipart.addFile("video/mp4", "myfile", "video", bytes.getBytes());

                multipart.launchRequest(UPLOAD_URL, new Response.Listener<NetworkResponse>() {
                    @Override
                    public void onResponse(NetworkResponse response) {
                        String resultResponse = new String(response.data);

                        Log.d(TAG, "Responsevideo:" + resultResponse);

                        try {
                            JSONObject obj = new JSONObject(resultResponse);
                            Log.d(TAG, "Response31:" + resultResponse);
                            // JSONObject object = new JSONObject(json);
                            hash_id = obj.getString("hashed_id");
                            Log.v("hashed_id:",  hash_id);



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d(TAG, "JSON Error: " + e);

                        }

                        uploadVideo(title, part+1, array);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                    }
                });*/

        }
    }

    @Override
    public void onBackPressed() {
       /* if (mParams.isConfirmation()) {
            new AlertDialog.Builder(this)
                    .setCancelable(false)
                    .setTitle(R.string.are_you_sure)
                    .setMessage(R.string.discard_video_msg)
                    .setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finishWithResult(RESULT_CANCELED);
                        }
                    })
                    .setNegativeButton(R.string.cancel, null)
                    .show();
        } else {
            finishWithResult(RESULT_CANCELED);
        }*/
        /*Intent intent = new Intent(this, FFmpegRecorderActivity.class);
        startActivity(intent);
        finish();*/


        Intent i = getBaseContext().getPackageManager()
                .getLaunchIntentForPackage( getBaseContext().getPackageName() );
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        //startActivity(new Intent(FFmpegPreviewActivity.this, FFmpegRecorderActivity.class));
    }

    protected void onError(Exception e) {
        Log.e(LOG_TAG, "Unexpected Error", e);
        Intent intent = new Intent();
        intent.putExtra(RESULT_ERROR_PATH_KEY, e);
        finishWithResult(RESULT_ERROR, intent);
    }

    protected void finishWithResult(int result) {
        finishWithResult(result, null);
    }

    protected void finishWithResult(int result, Intent intent) {
        stop();
        setResult(result, intent);
        finish();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try { // Log.i(log_tag, "Uri:" +Uri.parse(mParams.getVideoFileUri());

            Log.v("log_tag","Uri: " + Uri.parse(mParams.getVideoFileUri()));
            Log.v("log_tag","Uri123: " + mParams.getVideoFileUri());

            Path=mParams.getVideoFileUri();

            Log.v("log_tag"," Path123: " + Path);

            Path= Path.substring(7);

            Log.v("log_tag"," Path4: " + Path);

            PathImage=Path;



            PathImage = PathImage.substring(0,PathImage.length()-3);
            PathImage =  PathImage + "jpg";


            File fileimage = new File(PathImage);
            boolean deletedimage = fileimage.delete();
            Log.v("log_tag","deletedimage: " + deletedimage);

            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setOnCompletionListener(this);
            mMediaPlayer.setOnVideoSizeChangedListener(this);
            mMediaPlayer.reset();
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setDataSource(this, Uri.parse(mParams.getVideoFileUri()));
            mMediaPlayer.setDisplay(holder);
            mMediaPlayer.prepare();
            mMediaPlayer.seekTo(0);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Error setting up media player", e);
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        stop();
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        animateProgress(mProgressBar.getMax())
                .addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        super.onAnimationEnd(animation);
                        if (mMediaPlayer != null) {
                            mMediaPlayer.seekTo(0);
                            animateProgress(0);
                            mPlayButton.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }

    @Override
    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
        mVideoWidth = width;
        mVideoHeight = height;


        //mVideoWidth = 360;
       // mVideoHeight = 640;
        updateSurfaceSize();
        Log.v(LOG_TAG, "mVideoHeight:" + mVideoHeight);
        Log.v(LOG_TAG, "mVideoWidth:" +    mVideoWidth);

    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft,
            int oldTop, int oldRight, int oldBottom) {
        updateSurfaceSize();
    }

    // Scale the surface size to the largest size that fits both width and height within the parent.
    protected void updateSurfaceSize() {
        if (mVideoWidth > 0 && mVideoHeight > 0) {
            int width = mPreviewVideoParent.getMeasuredWidth();
            int height = mPreviewVideoParent.getMeasuredHeight();
            /*width=1920;
            height=1080;*/
            Log.v("log_tag"," width: " + width);
            Log.v("log_tag"," height: " + height);
            float videoAspectRatio = (float) mVideoWidth / mVideoHeight;
            float parentAspectRatio = (float) width / height;
            Log.v("log_tag","videoAspectRatio: " + videoAspectRatio);
            Log.v("log_tag","parentAspectRatio: " + parentAspectRatio);
            float ratioDiff = videoAspectRatio - parentAspectRatio;
            if (ratioDiff > 0) {
                height = (int)(width / videoAspectRatio);
                Log.v("log_tag","videoAspectRatio1: " + videoAspectRatio);
                Log.v("log_tag"," height2: " + height);

            } else {
                width = (int)(height * videoAspectRatio);
               // width = (int)(height * (9/16));
                /*videoAspectRatio=9/16;
                width = (int)(height *  videoAspectRatio);*/
                Log.v("log_tag","videoAspectRatio2: " + videoAspectRatio);
                Log.v("log_tag","height1: " + height);
                Log.v("log_tag","width1: " + width);

            }
            RelativeLayout.LayoutParams layoutParams =
                    (RelativeLayout.LayoutParams) mSurfaceView.getLayoutParams();
            if (layoutParams.width != width || layoutParams.height != height) {
                layoutParams.width = width;
                layoutParams.height = height;




                Log.v("log_tag","  layoutParams.width: " +  layoutParams.width);
                Log.v("log_tag"," layoutParams.height: " + layoutParams.height);
                mSurfaceView.setLayoutParams(layoutParams);
            }
        }
    }

    protected void play() {
       // previe_text.setVisibility(View.GONE);
        mMediaPlayer.start();
        updateProgress();
    }
    protected void delete()
    {
       // File file = new File(selectedFilePath);
       // boolean deleted = file.delete();
    }

    protected void pause() {
        mMediaPlayer.pause();
       mPlayButton.setVisibility(View.VISIBLE);
    }

    protected void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    private void deleteTempFolder(String dir) {
        File myDir = new File(Environment.getExternalStorageDirectory() + "/"+dir);
        if (myDir.isDirectory()) {
            String[] children = myDir.list();
            for (int i = 0; i < children.length; i++) {
                new File(myDir, children[i]).delete();
            }
        }
    }

    protected void updateProgress() {
        if (mMediaPlayer == null) {
            return;
        }
        if (mMediaPlayer.getDuration() > 0) {
            animateProgress(mProgressBar.getMax()
                    * mMediaPlayer.getCurrentPosition() / mMediaPlayer.getDuration());
        }
        if (mMediaPlayer.isPlaying()) {
            mProgressBar.postDelayed(new Runnable() {
                @Override
                public void run() {
                    updateProgress();
                }
            }, PROGRESS_UPDATE_INTERVAL_MILLIS);
        }

    }

    protected ObjectAnimator animateProgress(int progress) {
        ObjectAnimator animation = ObjectAnimator.ofInt(mProgressBar, "progress", progress);
        animation.setDuration(getResources().getInteger(android.R.integer.config_shortAnimTime));
        animation.setInterpolator(mInterpolator);
        animation.start();
        return animation;
    }



    private void uploadVideo(String name, Uri videoUri) {
        final Context context = getApplicationContext();

       // loading = ProgressDialog.show(this, "Uploading...", "Please wait...", false, false);

        int size = 1024 * 1024 * 5;
        byte[] bytes = BytesUtils.getBytesFromVideoUri(context, videoUri);

        List<SplitBytes.Bytes> array = null;
        if (bytes != null && bytes.length > 0) {
            array = SplitBytes.getBytesForPart(bytes, size);
        }

        Log.v("log_tag","name:" +name);

        Log.v("log_tag","array:" +array);

        uploadVideo(name, 0, array);

    }

    private void uploadVideo(final String title, final int part, final List<SplitBytes.Bytes> array) {
       /* final ProgressDialog progressDialog = new ProgressDialog(FFmpegPreviewActivity.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();*/
        if (array == null || array.size() <= part) {
            //loading.dismiss();
            return;
        }

        final Multipart multipart = new Multipart(getApplicationContext());

        multipart.addParam("title", title);
        multipart.addParam("chunk", "" + (part+1));
        multipart.addParam("chunks", "" + array.size());
        Log.d(TAG, "number:" + part);
        SplitBytes.Bytes bytes = array.get(part);
        multipart.addFile("video/mp4", "myfile", "video", bytes.getBytes());

        multipart.launchRequest(UPLOAD_URL, new Response.Listener<NetworkResponse>() {
            @Override
            public void onResponse(NetworkResponse response) {
              //  progressDialog.dismiss();
                String resultResponse = new String(response.data);

                Log.d(TAG, "" + resultResponse);

                Toast.makeText(getApplicationContext(), resultResponse,
                        Toast.LENGTH_LONG).show();

                try {
                    JSONObject obj = new JSONObject(resultResponse);
                    Log.d(TAG, "Response31:" + resultResponse);
                    Toast.makeText(getApplicationContext(), resultResponse,
                            Toast.LENGTH_LONG).show();
                    // JSONObject object = new JSONObject(json);
                    hash_id = obj.getString("hashed_id");
                    Log.v("hashed_id:",  hash_id);
                    changevideo();
                   /* Toast.makeText(getApplicationContext(), hash_id,
                            Toast.LENGTH_LONG).show();*/



                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d(TAG, "JSON Error: " + e);

                }

                uploadVideo(title, part+1, array);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
              //  progressDialog.dismiss();
                //loading.dismiss();
            }
        });
    }

    private void launchSelectedVideo() {
        Intent photoPickerIntent = new Intent();
        photoPickerIntent.setAction(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("video/*");
        startActivityForResult(Intent.createChooser(photoPickerIntent, "Select Video"), SELECT_VIDEO_REQUEST_CODE);
    }


   /* public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        PermissionRequest.onRequestPermissionsResult(this, requestCode, permissions, grantResults);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        switch (requestCode) {
            case SELECT_PHOTO_REQUEST_CODE:
                if (resultCode == RESULT_OK) {
                    ArrayList<Uri> images = new ArrayList<>();
                    if (intent.getData() != null) { // Single image
                        images.add(intent.getData());
                    } else { // Multiple images
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                            for (int i = 0; i < intent.getClipData().getItemCount(); i++) {
                                images.add(intent.getClipData().getItemAt(i).getUri());
                            }
                        }
                    }

                    //showImages(images);
                }
                break;
            case SELECT_VIDEO_REQUEST_CODE:

                Uri selectedVideoPath = intent.getData();
                String name="test";
               // uploadVideo(name, selectedVideoPath);
                Log.v("uri321", selectedVideoPath.toString());
               // showVideo(selectedVideoPath);
                break;
        }
    }






    public void changevideo()
    {
        final ProgressDialog progressDialog = new ProgressDialog(FFmpegPreviewActivity.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        Toast.makeText(getApplicationContext(), hash_id,
                Toast.LENGTH_LONG).show();


        String url_like = "http://api.dateinvite.com/users/save.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {

        JSONObject jsonBody = new JSONObject();
        try {
            Log.v("hash_id123:", hash_id);
            jsonBody = new JSONObject();
            jsonBody.put("video",hash_id);



        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();
                Log.v("Responsevideochange:", response.toString());

                Toast.makeText(getApplicationContext(), response.toString(),
                        Toast.LENGTH_LONG).show();

                try {





                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
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
                Log.i(TAG, "mails:" +   email_saved);
                Log.i(TAG, "tokens:" +  token_saved);

                //String creds = String.format("%s:%s","t2@test.com","15ab5efa606ea9f5002f206c0af2046f");
                String creds = String.format("%s:%s",email_saved,token_saved);
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

    public void sendvideo()
    {
        uploadVideo("test", Uri.parse(new File(Path).toString()));


        final ProgressDialog progressDialog = new ProgressDialog(FFmpegPreviewActivity.this,R.style.MyAlertDialogStyle);
        progressDialog.setMessage("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        progressDialog.show();

        Toast.makeText(getApplicationContext(), hash_id,
                Toast.LENGTH_LONG).show();


        String url_like = "http://api.dateinvite.com/videos/create.json";


        //  public void makeRequestlike( final String url_like,  final VolleyCallback callback) {


        SharedPreferences mPreferences6 = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor6 = mPreferences6.edit();


        email_saved1 = mPreferences6.getString("mail3", "");
        token_saved1 = mPreferences6.getString("token3", "");

        JSONObject jsonBody = new JSONObject();
        try {
            Log.i(TAG, "mail3:" +   email_saved1);
            Log.i(TAG, "token3:" +  token_saved1);
            Log.v("videosendid1", videosendid);
            Log.v("hash_id123:", hash_id);
            jsonBody = new JSONObject();
            jsonBody.put("video",hash_id);
            //jsonBody.put("video","3a9fb2c5b55acc4e3deec595c24538bc");
            jsonBody.put("to",vsendid);

           // jsonBody.put("to",14787);


        } catch (Exception ex){
            Log.v("", "ERROR: "+ex.getMessage());
        }

        JsonObjectRequest rq= new JsonObjectRequest(Request.Method.POST,  url_like,jsonBody, new Response.Listener<JSONObject>(){
            /*CustomJSONObjectRequest rq = new CustomJSONObjectRequest(Request.Method.POST,
                    url, null,
                    new Response.Listener<JSONObject>() {*/
            @Override
            public void onResponse(JSONObject response) {
                progressDialog.dismiss();


                Log.v("Responsevideochange:", response.toString());
               responsetovideo=response.toString();
                Toast.makeText(getApplicationContext(), response.toString(),
                        Toast.LENGTH_LONG).show();





                try {
                    String respone_server = response.getString("response");
                    foo = Integer.parseInt(respone_server);
                    if (foo == 1)
                    {
                        last();
                }


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
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

              // String creds = String.format("%s:%s","t1@test.com","da6f885eb0d26f06ecc8c6021924c94d");
               String creds = String.format("%s:%s",email_saved1,token_saved1);
                //String creds = String.format("%s:%s",email_saved1,token_saved1);
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

void firstvideo()
{
    File file = new File(Path);

    Log.v("log_tag","uriuri:" + Uri.parse(new File(Path).toString()));
    Log.v("log_tag","deleted234: " + Path);
    Log.v("log_tag","converturi:" +Uri.fromFile(file));
    Log.v("log_tag","deleted23456: " + Uri.fromFile(new File(Path)));
    Uri uriFromPath = Uri.fromFile(new File(Path));
    Log.v("log_tag","deleted234: " + uriFromPath);

    uploadVideo("test", Uri.parse(new File(Path).toString()));
}


void last()
{
    Intent intent = new Intent(FFmpegPreviewActivity.this,Page_Activity4.class);
    overridePendingTransition(com.braincraft.social.R.anim.fade_in, com.braincraft.social.R.anim.fade_out);
    startActivity(intent);
}
}
