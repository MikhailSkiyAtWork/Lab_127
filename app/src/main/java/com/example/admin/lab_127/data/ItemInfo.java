package com.example.admin.lab_127.data;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class ItemInfo {
    private String title_;
    private String description_;
    private int imageId_;

    public ItemInfo(int imageId, String title, String description) {
        this.imageId_ = imageId;
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
}
