package com.example.optimusprime.fiftyfifty;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Optimus Prime on 4/6/2015.
 */
public class Mode2Fragment extends Fragment
{
    ListView list;
    String[] itemname =
            {
                    "Cafe 101",
                    "Strip N Tease",
                    "Pink Poodle",
                    "Gnarly SexShop",
                    "Burger King",
                    "McDonalds",
                    "Applebee's",
                    "Somethine Else",
                    "Last One"
            };

    String[] desc =
            {
                    "This is a Cafe And We sell shit",
                    "Come and See",
                    "Your wife will not like this",
                    "HMMMMPHHH",
                    "MUAHHAHA",
                    "Okay I this is getting old",
                    "Dam I shouldn't have put enough",
                    "Finally Done Woohoo",
                    "This should be Scrollable"
            };

    String[] stringLocations;
    double[] starRatings;

    Integer[] imgid =
     {
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe,
            R.drawable.cafe
    };

    double[] ratingVal = {2.5 , 3, 5, 4.5, 5, 1, 1.5, 3, 2};
    Integer[] starPics;

    View rootView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        ImageView imageview = (ImageView)getActivity().findViewById(R.id.yelpLogo);

        starPics = new Integer[ratingVal.length]; // Number of images depending on the size of the data

        // Looping Through and Checking the ratings to associate with the list view
        for(int i = 0; i <ratingVal.length; i++)
        {
            if (ratingVal[i] == 1)
            {
            starPics[i] = R.drawable.onestar;
            } else if (ratingVal[i] == 1.5) {
                starPics[i] = R.drawable.oneandahalf;
            } else if (ratingVal[i] == 2) {
                starPics[i] = R.drawable.twostar;

            } else if (ratingVal[i] == 2.5) {
                starPics[i] = R.drawable.twoandahalf;

            } else if (ratingVal[i] == 3) {
                starPics[i] = R.drawable.threestar;

            } else if (ratingVal[i] == 3.5) {
                starPics[i] = R.drawable.threeandahalf;

            } else if (ratingVal[i] == 4) {
                starPics[i] = R.drawable.fourstar;

            } else if (ratingVal[i] == 4.5) {
                starPics[i] = R.drawable.fourandahalf;

            } else {
                starPics[i] = R.drawable.fivestar;

            }
        }

        CustomListAdapter adapter=new CustomListAdapter(getActivity(), itemname, imgid,desc,starPics);
        list = new ListView(getActivity());
       // list=(ListView)getView().findViewById(R.id.list);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {
                // TODO Auto-generated method stub
                String Slecteditem= itemname[+position];
                Toast.makeText(getActivity().getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();

            }
        });
            container.addView(list);
            rootView = inflater.inflate(R.layout.mode2fragment_layout, container, false);
           return rootView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        //here you can initialise your variables,listeners,e.t.c ;
        super.onActivityCreated(savedInstanceState);

        ImageView imageview = (ImageView)getActivity().findViewById(R.id.yelpLogo);
    }

    protected View findViewById(int id)
    {
        return getView().findViewById(id);
    }
}
