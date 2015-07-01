package com.example.admin.lab_127;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class CustomListItem extends LinearLayout {

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

    public void setListItemImage(Drawable itemImage) {
        this.listItemImage_.setImageDrawable(itemImage);
    }
    //endregion

    private void init(AttributeSet attributeSet, int defStyle) {

        // Linear Layout(Vertical) for textViews (just for Title and Details)
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding((int) getResources().getDimension(R.dimen.padding_left_for_text),
                0,
                (int) getResources().getDimension(R.dimen.padding_right_for_text),
                0);

        // Linear Layout(Horizontal) for Image+TextViews
        LinearLayout horizontalLayout = new LinearLayout(getContext());
        horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);
        horizontalLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,(int)getResources().getDimension(R.dimen.list_item_height)));
        horizontalLayout.setPadding(0,(int)getResources().getDimension(R.dimen.list_item_top),0,0);

        // Initialize the item of ListView
        listItemTitle_ = new TextView(getContext());
        listItemDetails_ = new TextView(getContext());
        listItemImage_ = new ImageView(getContext());

        // Add items into Vertical LinearLayout
        // Add Title
        linearLayout.addView(listItemTitle_);
        // Add Details
        linearLayout.addView(listItemDetails_);

        // Add items into horizontal LinearLayout
        // Add Image
        horizontalLayout.addView(listItemImage_);
        // Add LinearLayout (Title + Details)
        horizontalLayout.addView(linearLayout);

        addView(horizontalLayout);
    }
}
