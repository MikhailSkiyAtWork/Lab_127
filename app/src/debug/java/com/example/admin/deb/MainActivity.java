package com.example.admin.deb;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.admin.lab_127.CustomHeader;
import com.example.admin.lab_127.ItemAdapter;
import com.example.admin.lab_127.R;
import com.example.admin.lab_127.data.ItemInfo;

import org.lucasr.dspec.DesignSpec;
import org.lucasr.dspec.DesignSpecFrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by Mikhail Valuyskiy on 19.06.2015.
 */
public class MainActivity extends Activity {
    DesignSpecFrameLayout designSpecLayout_;

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

        DesignSpec designSpec = DesignSpec.fromResource(layout, R.raw.main_activity_spec);
        layout.getOverlay().add(designSpec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        menu.add(getString(R.string.show_baseline_grid))
                .setCheckable(true)
                .setChecked(designSpecLayout_.getDesignSpec().isBaselineGridVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        designSpecLayout_.getDesignSpec().setBaselineGridVisible(checked);
                        return true;
                    }
                });

        menu.add(getString(R.string.show_keylines))
                .setCheckable(true)
                .setChecked(designSpecLayout_.getDesignSpec().areKeylinesVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        designSpecLayout_.getDesignSpec().setKeylinesVisible(checked);
                        return true;
                    }
                });

        menu.add(getString(R.string.show_spacings))
                .setCheckable(true)
                .setChecked(designSpecLayout_.getDesignSpec().areSpacingsVisible())
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        boolean checked = !item.isChecked();
                        item.setChecked(checked);
                        designSpecLayout_.getDesignSpec().setSpacingsVisible(checked);
                        return true;
                    }
                });
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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
