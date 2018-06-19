package com.braincraft.social.activity;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ADMIN on 15/6/2018.
 */

public class Myapp extends Application {
    private static final String TAG = Myapp.class
            .getSimpleName();
    private static Myapp mInstance;
    private RequestQueue mRequestQueue;

    public static synchronized Myapp getInstance() {
        return mInstance;
    }


  /*  public static synchronized AppController getInstance() {
        if(mInstance == null){
            mInstance = new AppController();
        }
        return mInstance;
    }*/

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    private RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

// --Commented out by Inspection START (4/24/2018 4:08 PM):
//    public <T> void addToRequestQueue(Request<T> req, String tag) {
//        // set the default tag if tag is empty
//        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
//        getRequestQueue().add(req);
//    }
// --Commented out by Inspection STOP (4/24/2018 4:08 PM)

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

// --Commented out by Inspection START (4/24/2018 4:08 PM):
//    public void cancelPendingRequests(Object tag) {
//        if (mRequestQueue != null) {
//            mRequestQueue.cancelAll(tag);
//        }
//    }
// --Commented out by Inspection STOP (4/24/2018 4:08 PM)
}
