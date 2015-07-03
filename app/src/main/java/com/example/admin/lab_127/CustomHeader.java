package com.example.admin.lab_127;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Mikhail Valuyskiy on 19.06.2015.
 */
public class CustomHeader extends LinearLayout {

    //region Private fields
    private TextView titleTextView_;
    private TextView detailsTextView_;
    //endregion

    //region Public constructors
    public CustomHeader(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CustomHeader(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(attributeSet, defStyle);
    }
    //endregion

    //region Accessors
    public void setTitle(String title) {
        this.titleTextView_.setText(title);
    }

    public String getTitle() {
        return titleTextView_.getText().toString();
    }

    public void setDetails(String details) {
        this.detailsTextView_.setText(details);
    }

    public String getDetails() {
        return detailsTextView_.getText().toString();
    }
    //endregion

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        boolean touched = false;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                touched = true;
                break;
            default:
                break;
        }

        if (touched) {
            Toast.makeText(getContext(), getResources().getString(R.string.toast),
                    Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void init(AttributeSet attributeSet, int defStyle) {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setPadding((int) getResources().getDimension(R.dimen.padding_left_for_header),
                (int) getResources().getDimension(R.dimen.padding_top_for_header),
                (int) getResources().getDimension(R.dimen.padding_right_for_header),
                0);

        linearLayout.setLayoutParams(new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, (int) getResources().getDimension(R.dimen.list_item_height)));

        titleTextView_ = new TextView(getContext());
        titleTextView_.setText(R.string.title);
        titleTextView_.setTextColor(Color.rgb(200, 0, 0));

        detailsTextView_ = new TextView(getContext());
        detailsTextView_.setText(R.string.details);
        detailsTextView_.setTextColor(Color.rgb(200, 0, 0));

        addView(linearLayout);
        linearLayout.addView(titleTextView_);
        linearLayout.addView(detailsTextView_);
    }
}
