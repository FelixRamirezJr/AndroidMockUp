/*
Custom List View To be able to handle multiple images and text
Created By Felix Ramirez
 */


package com.example.optimusprime.fiftyfifty;

/**
 * Created by Optimus Prime on 5/8/2015.
 */
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class CustomListAdapter extends ArrayAdapter<String>
{

    private final Activity context;
    private final String[] itemname;

    private final Integer[] imgid; // The Business Pic
    private final Integer[] starImg; // The Star Pics


    private final String[] description;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid,String[] description,Integer[] starImg)
    {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;

        this.description = description;
        this.starImg = starImg;
    }

    public View getView(int position,View view,ViewGroup parent)
    {
        LayoutInflater inflater=context.getLayoutInflater();

        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item); // Item
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon); // This is the Picture of the Business ID
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1); // Text View
        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);



        extratxt.setText("Description "+description[position]);
         ////////////////// Add the Stars Logic for the ///////////////////////
        ImageView imageSt = (ImageView) rowView.findViewById(R.id.stars); // This is getting the Stars ID
        imageSt.setImageResource(starImg[position]);
        ////////////////// End of the Star Logic /////////////////////////////
        return rowView;

    };
}