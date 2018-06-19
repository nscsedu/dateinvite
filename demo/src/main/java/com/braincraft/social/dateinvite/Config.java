package com.braincraft.social.dateinvite;

/**
 * Created by Belal on 11/23/2015.
 */
public class Config {
    //  public static final String UPLOAD_URL= "http://192.168.100.245/vdeo/simplifiedupload.php";
   // public static final String UPLOAD_URL= "http://192.168.0.104/vdeo/simplifiedupload.php";
    //public static final String UPLOAD_URL= "http://103.222.22.133/magura_acland_youtube/simplifiedupload.php";
      public static final String UPLOAD_URL= "http://www.shopgallery.co.za/magura_youtube/VideoUpload/simplifiedupload.php";
    //  public static final String COMMONUPLOAD_URL= "http://www.shopgallery.co.za/magura_youtube/VideoUpload/commonup.php";

    public static final String TAG_URL = "url";
    public static final String TAG_SIZE = "size";

    // global topic to receive app wide push notifications
    public static final String TOPIC_GLOBAL = "global";

    // broadcast receiver intent filters
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final String PUSH_NOTIFICATION = "pushNotification";

    // id to handle the notification in the notification tray
    public static final int NOTIFICATION_ID = 100;
    public static final int NOTIFICATION_ID_BIG_IMAGE = 101;

    public static final String SHARED_PREF = "ah_firebase";
}
