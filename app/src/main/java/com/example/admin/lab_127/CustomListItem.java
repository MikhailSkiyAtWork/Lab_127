package com.example.admin.lab_127;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class CustomListItem extends LinearLayout{

    //region Private fields
    private TextView listItemTitle_;
    private TextView listItemDetails_;
    private ImageView listItemImage_;
    //endregion

    //region Public constructors
    public CustomListItem(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CustomListItem(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(attributeSet, defStyle);
    }
    //endregion

    //region Accessors
    public void setListItemTitle(String title) {
        this.listItemTitle_.setText(title);
    }

    public String getTitle() {
        return listItemTitle_.getText().toString();
    }

    public void setListItemDetails(String details) {
        this.listItemDetails_.setText(details);
    }

    public String getListItemDetails() {
        return listItemDetails_.getText().toString();
    }

    public void setListItemImage(Bitmap itemImage){
        this.listItemImage_.setImageBitmap(itemImage);
    }


    //endregion

    private void init(AttributeSet attributeSet, int defStyle) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding(0, 0, 0, 0);
        listItemTitle_ = new TextView(getContext());
        listItemTitle_.setText("Title");

        listItemDetails_  = new TextView(getContext());
        listItemDetails_.setText("Details");

        listItemImage_ = new ImageView(getContext());
        listItemImage_.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.clear));

        addView(linearLayout);
        linearLayout.addView(listItemTitle_);
        linearLayout.addView(listItemDetails_);
    }
}
