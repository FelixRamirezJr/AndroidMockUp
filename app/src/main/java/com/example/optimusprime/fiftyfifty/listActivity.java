package com.example.optimusprime.fiftyfifty;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;


public class listActivity extends ActionBarActivity
{
    ArrayList<Button> locations = new ArrayList<>();
    String [] stringLocations;
    double [] starRatings;
    RelativeLayout rl= null;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

       // setContentView(R.layout.activity_list); // Try moving this to the bottom if it crashes...
        rl = new RelativeLayout(this);

        stringLocations = new String[4]; // When screen is located, Should ask for the
        starRatings = new double[4];

        // Creating an Array of the location names and along with the star rating so we can test the information.
        stringLocations[0] = "The Pink Poodle"; stringLocations[1] = "408 MX"; stringLocations[2] = "McDonalds"; stringLocations[3] = "Taco Bell";
        starRatings[0] = 3; starRatings[1] = 5; starRatings[2] = 4; starRatings[3] = 3.5;

        // LOOP THROUGHT THE LOCATIONS THAAT WAS GIVEN TO USE FROM THE YELP API
        for(int i = 0; i < stringLocations.length; i++)
        {
            //////////////////////////////////////////////////////////
            // This is creating the Parameters for the Relative Layout
            //////////////////////////////////////////////////////////
            RelativeLayout.LayoutParams lprams = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
            Button tv1 = new Button(this);
            ImageView rate = new ImageView(this);


            // These following conditions will set up the ratings for the Certain Object

               // LinearLayout.LayoutParams vp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);

                RelativeLayout.LayoutParams viewParams = new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

                rate.setMaxHeight(50);
                rate.setMaxWidth(50);
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                // The following will set the Image Drawable according to the Yelp Information of the stars that has been passed in.
                ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if(starRatings[i] == 1) {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.onestar));
                }
                else if(starRatings[i] == 1.5)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.oneandahalf));

                }
                else if(starRatings[i] == 2)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.twostar));

                }
                else if(starRatings[i] == 2.5)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.twoandahalf));

                }
                else if(starRatings[i] == 3)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.threestar));

                }
                else if(starRatings[i] == 3.5)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.threeandahalf));

                }
                else if(starRatings[i] == 4)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.fourstar));

                }
                else if(starRatings[i] == 4.5)
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.fourandahalf));

                }
                else
                {
                    rate.setImageDrawable(getResources().getDrawable(R.drawable.fivestar));

                }


            tv1.setText( (i + 1) + stringLocations[i]);
            // PICTURES ARE BEING ADDED BUT IT IS NOT WORKING CORRECTLY....
            if(i > 0)
            {
                lprams.addRule(RelativeLayout.BELOW, i);
               // viewParams.addRule(RelativeLayout.RIGHT_OF,i);
            }
            //Setting up the layouts for the Button AKA the Location for Selection...

            tv1.setLayoutParams(lprams);

                tv1.setId(i+ 1);
                count++;

            // Adding The Two objects to the view...

            rl.addView(tv1);

            // Setting up the Location of the ImageView
            if(i > 0)
            {
                lprams.addRule(RelativeLayout.ALIGN_RIGHT,i);
            }
            else
            {
                lprams.addRule(RelativeLayout.ALIGN_RIGHT,0);
            }
            rate.setLayoutParams(lprams);
            rate.setId(i+1);

            rl.addView(rate);
            count++;
        }

        setContentView(rl); // Try this maybe???
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    public void mode1Click(View v) {
        Intent moveMode1 = new Intent(this, MainActivity.class);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
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
