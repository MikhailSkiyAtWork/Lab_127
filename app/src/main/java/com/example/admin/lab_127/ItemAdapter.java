package com.example.admin.lab_127;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        CustomListItem customListItem = (CustomListItem)convertView.findViewById(R.id.custom_item);
        ItemInfo item = this.getItem(postition);

        customListItem.setListItemTitle(item.getTitle());
        customListItem.setListItemTitle(item.getDescription());
        return convertView;
    }
}
