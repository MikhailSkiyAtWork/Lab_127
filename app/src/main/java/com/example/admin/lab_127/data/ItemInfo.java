package com.example.admin.lab_127.data;

import android.graphics.Bitmap;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class ItemInfo {
    private String title_;
    private String description_;
    private Bitmap image_;

    public ItemInfo(Bitmap image, String title, String description) {
        this.image_ = image;
        this.title_ = title;
        this.description_ = description;
    }

    public ItemInfo( String title, String description) {
        this.title_ = title;
        this.description_ = description;
    }

    public String getTitle() {
        return title_;
    }

    public String getDescription() {
        return description_;
    }

    public Bitmap getImage(){
        return image_;
    }
}
