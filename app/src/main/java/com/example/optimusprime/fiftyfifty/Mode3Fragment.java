package com.example.optimusprime.fiftyfifty;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Optimus Prime on 4/6/2015.
 */
public class Mode3Fragment extends Fragment
{

    View rootView;
    QuickAction mQuickAction = null;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.mode3fragment_layout, container, false);

        return rootView;

    }

    public void bubbleClick (View v)
    {

    }


}
