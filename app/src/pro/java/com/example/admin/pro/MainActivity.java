package com.example.admin.lab_127;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.admin.lab_127.data.ItemInfo;

import org.lucasr.dspec.DesignSpecFrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikhail Valuyskiy on 19.06.2015.
 */
public class MainActivity extends Activity {
    private ItemAdapter Adapter_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CustomHeader customHeader = new CustomHeader(getApplicationContext());

        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.VERTICAL);
        ListView listView = new ListView(this);

        listView.setPadding(0, (int)getResources().getDimension(R.dimen.list_item_top), 0, 0);

        listView.setDivider(null);

        List<ItemInfo> values = new ArrayList<ItemInfo>();
        Drawable image = getResources().getDrawable(R.mipmap.clear);

        for (int i = 0; i < 20; i++) {
            ItemInfo info = new ItemInfo(image, getResources().getString(R.string.title) + i, getResources().getString(R.string.details) + i);
            values.add(info);
        }

        Adapter_ = new ItemAdapter(this, values);
        listView.setAdapter(Adapter_);

        layout.addView(customHeader);
        layout.addView(listView);
        setContentView(layout);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
