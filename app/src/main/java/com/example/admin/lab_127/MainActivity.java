package com.example.admin.lab_127;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.admin.lab_127.data.ItemInfo;

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


        LinearLayout layout = new LinearLayout(getApplicationContext());
        ListView listView = new ListView(this);
        listView.setPadding(0,70,0,0);



        CustomHeader customHeader = new CustomHeader(getApplicationContext());



       // CustomListItem customListItem = new CustomListItem(getApplicationContext());

        layout.addView(customHeader);





        List<ItemInfo> values = new ArrayList<ItemInfo>();
        Bitmap image = BitmapFactory.decodeResource(getResources(), R.mipmap.clear);
        ItemInfo info = new ItemInfo(image,"Hi","android");
        ItemInfo info2 = new ItemInfo(image,"Hi2","android");
        values.add(info);
        values.add(info2);

        for (int i=0;i<10;i++){
            ItemInfo info4 = new ItemInfo(image,"Hi"+i,"android" +i);
            values.add(info4);
        }



        setContentView(R.layout.activity_main);

//        ListView lv = new ListView(this);
//        String[] val = new String[]{"jiw","dfgg"};
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,customListItem,val);
//        lv.setAdapter(adapter);

        Adapter_ = new ItemAdapter(this, values);
        listView.setAdapter(Adapter_);


        layout.addView(listView);
        setContentView(layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
