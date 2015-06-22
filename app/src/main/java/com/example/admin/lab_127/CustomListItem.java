package com.example.admin.lab_127;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class CustomListItem extends LinearLayout {

    //region Private fields
    private TextView listItemTitle_;
    private TextView listItemDetails_;
    private Bitmap listItemImage_;
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

    public void setListItemImage(Bitmap image) {
        this.listItemImage_= image;
    }
    //endregion

    private void init(AttributeSet attributeSet, int defStyle) {
        View view = inflate(getContext(), R.layout.custom_list_item, null);
        listItemTitle_ = (TextView) view.findViewById(R.id.list_item_title);
        listItemDetails_ = (TextView) view.findViewById(R.id.list_item_details);
       // listItemImage_ = (Bitmap) view.findViewById(R.id.list_item_image_view);
        addView(view);
    }

}
