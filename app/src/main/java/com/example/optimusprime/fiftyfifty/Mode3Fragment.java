package com.example.optimusprime.fiftyfifty;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Optimus Prime on 4/6/2015.
 */
public class Mode3Fragment extends Fragment {

    View rootView;
    QuickAction mQuickAction = null;
    private ArrayList<String> YelpData;
    private ArrayAdapter<String> YelpAdapter;
    private ListView lvYelpData;
    String[] stringLocations;
    double[] starRatings;
    DrawView drawView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //   super.onViewCreate()

        rootView = inflater.inflate(R.layout.mode3fragment_layout, container, false);
        LinearLayout ll = new LinearLayout(getActivity());
        ll.setOrientation(LinearLayout.VERTICAL);
        //  rootView.addView(ll);


        ///////////////////////////////////////
        // CREATING THE BACK BUTTON AND LAYOUT
        ///////////////////////////////////////
        //Button backButton = new Button(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.FILL_PARENT);
        params.weight = (int) 1.0f;
        params.gravity = Gravity.RIGHT;
        //backButton.setLayoutParams(params);
        ///////END OF BACK BUTTON CREATION/////


        return rootView;

    }

    public void bubbleClick(View v) {

    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);
        //lvYelpData = (ListView) findViewById(R.id.lvContacts);

        //Set a linearLayout to add buttons
        LinearLayout linearLayout = new LinearLayout(getActivity());
        // Set the layout full width, full height
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL); //or VERTICAL

        //////////////////// //////
        // Creating The Yelp Logo
        /////////////////////////
        ImageView yelpPic = new ImageView(getActivity());
        LinearLayout.LayoutParams vp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        yelpPic.setLayoutParams(vp);
        yelpPic.setMaxHeight(50);
        yelpPic.setMaxWidth(50);
        yelpPic.setImageDrawable(getResources().getDrawable(R.drawable.yelplogo));
        linearLayout.addView(yelpPic);
        ////////////////////// END OF YELP LOGO ///////////////////////

        ///////////////////////////////////////////////////////////////////////
        // This is setting up the text view. Which should contain all the info
        ///////////////////////////////////////////////////////////////////////

        /////////// Populating Fake Data //////// For the Yelp Info
        stringLocations = new String[3];
        starRatings = new double[3];


        stringLocations[0] = "Company: Burger King\n" +
                " 1234 Fake Street\n" +
                "408-988-9999\n" +
                "Summary: Hellow this is the random stuff";

        stringLocations[1] = "Company: McDonalds\n" +
                " Some Random Location\n" +
                "408-988-9111\n" +
                "This Place offers a wide variety of food!";

        stringLocations[2] = "Company: TacoBell\n" +
                " 445 Castro St, San Francisco\n" +
                "506-222-5555\n" +
                "The only place you can get cheap nasty fat burritos!";

        /////// Populating fake data for the Ratings ////
        starRatings[0] = 5;
        starRatings[1] = 3.5;
        starRatings[2] = 2;

        /////////////////////////////////////////////////////////////
        ////// Loop runs by the amount of yelp services it found ////
        ////////////////////////////////////////////////////////////
        for (int i = 0; i < stringLocations.length; i++)
        {
            TextView count = new TextView(getActivity());
            count.setText( (i+ 1) + " Business Info ");
            count.setLayoutParams(params);
            linearLayout.addView(count);


            //////////////////////// This is setting up the Business pic //////////

            ImageView businessPic = new ImageView(getActivity());
            LinearLayout.LayoutParams vp3 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            businessPic.setLayoutParams(vp3);
            businessPic.setMaxHeight(50);
            businessPic.setMaxWidth(50);
            businessPic.setImageDrawable(getResources().getDrawable(R.drawable.cafe));
            linearLayout.addView(businessPic);
            ///// End of setting up the business pic /////


            //// Setting up the basic yelp information ///
            TextView tv = new TextView(getActivity());
            tv.setText(stringLocations[i]);
            tv.setLayoutParams(params);
            linearLayout.addView(tv);
            //////////////////////// END OF THE TEXT //////////////////////////////


            ///////////////////////////////////////////////////////////////////////
            /////// Setting up the rating
            /////////////////////////////////////////////////////////////////////
            ImageView ratePic = new ImageView(getActivity());
            LinearLayout.LayoutParams vp2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ratePic.setLayoutParams(vp2);
            ratePic.setMaxHeight(50);
            ratePic.setMaxWidth(50);


            if (starRatings[i] == 1) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.onestar));
            } else if (starRatings[i] == 1.5) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.oneandahalf));

            } else if (starRatings[i] == 2) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.twostar));

            } else if (starRatings[i] == 2.5) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.twoandahalf));

            } else if (starRatings[i] == 3) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.threestar));

            } else if (starRatings[i] == 3.5) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.threeandahalf));

            } else if (starRatings[i] == 4) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.fourstar));

            } else if (starRatings[i] == 4.5) {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.fourandahalf));

            } else {
                ratePic.setImageDrawable(getResources().getDrawable(R.drawable.fivestar));

            }
            ratePic.setImageDrawable(getResources().getDrawable(R.drawable.fourandahalf));
            linearLayout.addView(ratePic);
            //// End of the Yelp Information.


            ImageButton ib = new ImageButton(getActivity());
            LinearLayout.LayoutParams vp4 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            ib.setImageResource(R.drawable.nav);
            ib.setLayoutParams(vp4);
            ib.setBackgroundColor(Color.TRANSPARENT);
           // ib.setOnClickListener(); // Should implement later
            ib.setId(i); // Setting An ID for On Click
            linearLayout.addView(ib);

            //  Button b = new Button(getActivity());

        }


        ////////////////////////////////////////////////////////////
        // Below You this logic to implement the Multiple Yelp Data
        ///////////////////////////////////////////////////////////
        /*
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
        //////////////// END OF YELP RATE////////////
        */
        /////////////////////// Done setting up the Logo //////////////////

        ViewGroup viewGroup = (ViewGroup) view;
        viewGroup.addView(linearLayout);
    }

}
