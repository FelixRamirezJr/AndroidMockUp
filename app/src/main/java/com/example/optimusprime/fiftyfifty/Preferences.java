package com.example.optimusprime.fiftyfifty;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;


public class Preferences extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        ScrollView sv = new ScrollView(this);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        TextView tv = new TextView(this);
        tv.setText("Dynamic layouts ftw!");
        ll.addView(tv);

        EditText et = new EditText(this);
        et.setText("weeeeeeeeeee~!");
        ll.addView(et);

        Button b = new Button(this);
        b.setText("Click For Preferences");
        ll.addView(b);

            b.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v)
                {
                    // This is Creating the CheckBoxes Should Extract From the YELP API
                    String [] arr = new String[5];
                    arr[0] = "Bars";arr[1] = "Strip Clubs";arr[2] = "Restaurants"; arr[3] = "SuperMarkets";arr[4] = "Vegan Places";
                    for(int i = 0; i < arr.length; i++) {
                        CheckBox cb = new CheckBox(getApplicationContext());
                        cb.setText(arr[i]);
                        ll.addView(cb);
                    }
                }
            });
        this.setContentView(sv);

    }
}