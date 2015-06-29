package com.example.admin.lab_127;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.lab_127.data.ItemInfo;

import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 22.06.2015.
 */
public class ItemAdapter extends ArrayAdapter<ItemInfo> {

    public ItemAdapter(Context context, List<ItemInfo> items) {
        super(context, R.layout.custom_list_item, items);

    }

    @Override
    public View getView(int postition,View convertView, ViewGroup parent){
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(getContext());
        LinearLayout layout = new LinearLayout(getContext());
        layout.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        ));

       // layout.setPadding(0, 70, 0, 0);

        ItemInfo item = this.getItem(postition);
        CustomListItem customListItem_ = new CustomListItem(getContext());
        customListItem_.setListItemTitle(item.getTitle());
        customListItem_.setListItemDetails(item.getDescription());
        customListItem_.setListItemImage(item.getImage());

        layout.addView(customListItem_);

        horizontalScrollView.addView(layout);
        convertView = horizontalScrollView;
        return convertView;


//        ItemInfo item = this.getItem(postition);
//        convertView =  LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
//
//        CustomListItem customListItem_ = new CustomListItem(getContext());
//        customListItem_.setListItemTitle(item.getTitle());
//        customListItem_.setListItemTitle(item.getDescription());
//        return convertView;
    }
}
