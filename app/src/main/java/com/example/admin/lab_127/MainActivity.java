package com.example.admin.lab_127;

import android.app.Activity;
import android.content.res.TypedArray;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
        setContentView(R.layout.activity_main);

        CustomHeader cv = (CustomHeader)this.findViewById(R.id.custom_view);
        cv.setTitle("Hi");
        cv.setDetails("People");

        List<ItemInfo> values = new ArrayList<ItemInfo>();
        ItemInfo info = new ItemInfo("Hi","android");
        ListView listView = (ListView) this.findViewById(R.id.list_view);
        Adapter_ = new ItemAdapter(this, values);
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
