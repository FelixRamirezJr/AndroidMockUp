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
public class Mode1Fragment extends Fragment
{
    View rootView;

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.mode1fragment_layout,container,false);
        return rootView;

    }
}
