package com.braincraft.social.activity;

import android.widget.ImageView;

/**
 * Created by ADMIN on 25/5/2018.
 */

public class RecyclerModel {
    private String title;
    private String description;
    private String location;
    private String thumbnail;
   // private  ImageView thumbnail;

    public RecyclerModel(String title, String description,String  thumbnail,String location) {
        this.title = title;
        this.description = description;

       this.thumbnail = thumbnail;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }
    public String getLocation() {
        return location;
    }
}