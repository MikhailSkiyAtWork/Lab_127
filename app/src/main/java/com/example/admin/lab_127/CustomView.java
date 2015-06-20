package com.example.admin.lab_127;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by Mikhail Valuyskiy on 19.06.2015.
 */
public class CustomView extends LinearLayout {

    private TextView titleTextView_;
    private TextView detailsTextView_;

    //region Public constructors
    public CustomView(Context context) {
        super(context);
        init(null, 0);
    }

    public CustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0);
    }

    public CustomView(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
        init(attributeSet, defStyle);
    }
    //endregion

    //region accessors
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
    public boolean onTouchEvent(MotionEvent event){
        int action = event.getAction();
        boolean touched=false;
        switch (action){
            case MotionEvent.ACTION_DOWN:
                touched = true;
                break;
            default:
                break;
        }

        if (touched){
            Toast.makeText(getContext(), (String) "HI, I am custom View!",
                    Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    private void init(AttributeSet attributeSet, int defStyle) {
        View view = inflate(getContext(), R.layout.custom_view, null);
        titleTextView_ = (TextView) view.findViewById(R.id.tv1);
        detailsTextView_ = (TextView) view.findViewById(R.id.tv2);
        addView(view);
    }
}
