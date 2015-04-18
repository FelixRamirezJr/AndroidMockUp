package com.example.optimusprime.fiftyfifty;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity implements GoogleMap.OnMapClickListener
{
    FlyOutContainer root;

    // Below Are the Variables for The Map API
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    LocationManager locationManager;    //To grab the system's location service
    Location location;                  //Location object
    LatLng demoLoc;                     //Demo location
    MarkerOptions newMarkerRef;         //Object that we can to the map via addMarker function
    Marker newMarker;                   //The actual marker object that we see on map
    SupportMapFragment mMapFragment;
    Fragment fragment;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;

    //These variables are for the directions API
    DemoDirections d;
    ActionItem addAction = new ActionItem();
    // Creating Variables for The Action Bar.


    // MenuItem menuButtons;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(0x00000000);
        this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_main,null);
        this.setContentView(root);
        // setUpMapIfNeeded(); // This should be implemented later
    }

    // This is the OnResume Especially for google maps
    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    /////////////////////////////////////////////////////
    // The Following Function Sets up the Map If Needed
    ////////////////////////////////////////////////////
    private void setUpMapIfNeeded()
    {
        /*
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null)
        {
            // Try to obtain the map from the SupportMapFragment.
          //  mMapFragment = SupportMapFragment.newInstance();
          //  FragmentTransaction fragmentTransaction = ((SupportMapFragment) getFragmentManager().findFragmentById(R.id.mapView).getChildFragmentManager());
         //   fragmentTransaction.add(R.id.game_map_container, mMapFragment);
        //    fragmentTransaction.commit();
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapView))
                   .getMap();
            //To use current locations
            mMap.setMyLocationEnabled(true);
            mMap.getUiSettings().setMyLocationButtonEnabled(true);
            //To enable map clickable events
            mMap.setOnMapClickListener(this);
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
                mMap.setMyLocationEnabled(true);
                mMap.getUiSettings().setMyLocationButtonEnabled(true);
            }
            //This gets the last known current location of the device
            getCurrentLocation();
        }
        */
    } // End of the Set Up map option...


    ///////////////////////////
    // This is a Demo Location
    ////////////////////////////
    private void setUpMap()
    {
        //Demo Location
        demoLoc = new LatLng(37.7578018,-122.4657954);
        mMap.addMarker(new MarkerOptions().position(demoLoc).title("Custom Marker"));
    } // End of the Demo Location


    /************************************************************
     *
     * This is the start up function so that when the application starts
     * it automatically grabs the users last known location and centers it around
     * that location. NEED TO CLEAN THIS FUNCTION TO MAKE IT MORE ELEGANT!
     *
     *
     ************************************************************/
    private void getCurrentLocation(){
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        if(location == null)
            location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

        if(location != null)
        {
            double lat = location.getLatitude();
            double lng = location.getLongitude();
            demoLoc = new LatLng(lat, lng);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(demoLoc, 14));
            mMap.addMarker(new MarkerOptions().position(demoLoc).title("CurrentLocation"));
        }
        else
        {
            Toast.makeText(this, "What is BBB: ", Toast.LENGTH_SHORT).show();
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(demoLoc, 14));
        }

    } // End of the getCurrentLocation Function...


    /************************************************************
     *
     * This is the listener function that takes in a LatLng object with the
     * latitude and longitude data. This function only allows one dropped marker
     * at a time. For future development we will expand this to multiple
     *
     *
     ************************************************************/
    public void onMapClick(LatLng point){
        //allow only one usable marker at a time
        if(newMarker != null) newMarker.remove();
        newMarkerRef = new MarkerOptions().position(point).title("new marker");
        newMarker = mMap.addMarker(newMarkerRef);
        //newMarker.setDraggable(true);

        //Get the directions JSON object
        getDirections(demoLoc, point);
    } // End of the On Map click


    /************************************************************
     *
     * This is the listener function that takes in a LatLng object with the
     * latitude and longitude data. This function only allows one dropped marker
     * at a time. For future development we will expand this to multiple
     * TODO: NEED TO CLEAN THIS SHIZ UP!
     *
     ************************************************************/
    public void getDirections(LatLng start, LatLng end){
        Log.d("getDirections", "Entered getDirections");
        String startString = start.latitude + "," + start.longitude;
        String endString = end.latitude + "," + end.longitude;

        //Get the directions JSON object
        String overViewPolyString = "";
        Log.d("getDirections", "Before Getting Directions");
        d = new DemoDirections(mMap);
        d.execute(startString, endString, overViewPolyString);
    } // End Of the get Diretion Method....


    ////////////////////////////////////////////////////////////////////////////////////////////
    ///// THIS SHOULD BE THE END OF ALL THE GOOGLE MAPS STUFF -  BELOW WOULD BEGIN OUT UI DESIGN
    ////////////////////////////////////////////////////////////////////////////////////////////


    public void listClick(View v)
    {
        Intent moveToList = new Intent(this, listActivity.class);
        startActivity(new Intent(getApplicationContext(), listActivity.class));
    }


    //////////////////////////////////////////////////////
    // THIS FOLLOWING METHOD SHOULD CALL THE POP UP BLOB
    ////////////////////////////////////////////////////
    public void meetClick(View v)
    {
        //Intent moveMyMeat = new Intent(this, MeetUp.class);
        //startActivity(new Intent(getApplicationContext(), MeetUp.class));
        addAction.setTitle("Bank Of America \n 123 Fake Street \n 209-567-7777 \n 98765");

        // Creating The Actions..
        ActionItem something = new ActionItem();
        ActionItem one = new ActionItem();
        ActionItem two = new ActionItem();
        ActionItem three = new ActionItem();
        ActionItem four = new ActionItem();
        ActionItem five = new ActionItem();




        something.setTitle("Click");
        one.setTitle("One");
        two.setTitle("Two");
        three.setTitle("Three");
        four.setTitle("Four");
        five.setTitle("Five");


        final QuickAction mQuickAction = new QuickAction(this,QuickAction.VERTICAL);
        mQuickAction.addActionItem(addAction);
       // mQuickAction.addActionItem(something);
       // mQuickAction.addActionItem(one);
       // mQuickAction.addActionItem(two);
       // mQuickAction.addActionItem(three);
       // mQuickAction.addActionItem(four);
       // mQuickAction.addActionItem(five);


        mQuickAction.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener() {
            @Override
            public void onItemClick(QuickAction source, int pos, int actionId)
            {
                if(pos == 0)
                {
                    Toast.makeText(MainActivity.this,"Add Item Selected",Toast.LENGTH_SHORT).show();
                }
                else if(pos == 1)
                {
                    Toast.makeText(MainActivity.this,"Something Selected",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"NOTHING?", Toast.LENGTH_LONG).show();
                }
            }
        });
       // addAction.setIcon(getResources().getDrawable(R.drawable.ic));
       mQuickAction.show(v);
    }

    public void mode1Click(View v){
        Intent moveMode1 = new Intent(this, MainActivity.class);
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void mode2Click(View v){
        Intent moveMode2 = new Intent(this, Mode2.class);
        startActivity(new Intent(getApplicationContext(), Mode2.class));
    }

    public void mode3Click(View v)
    {
        // In here I Will modify the Android Mode 3 just to test the activity...
       // Intent moveMode3 = new Intent(this, Mode3.class);
       // startActivity(new Intent(getApplicationContext(), Mode3.class));

        Intent navIntent = new Intent(this,NavigationExample.class);
        startActivity(navIntent);
    }

    public void ContactClick(View v){
        Intent Contact = new Intent(this, Mode3.class);
        startActivity(new Intent(getApplicationContext(), Contacts.class));
    }

    public void preferencesClick(View v)
    {
        Intent preference = new Intent(this,Preferences.class);
        startActivity(new Intent(getApplicationContext(),Preferences.class));
    }

    public void setActivityBackgroundColor(int color){
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }


    public void toggleMenu (View v)
    {
        this.root.toggleMenu();
        if( (this.root.menuCurrentState == this.root.menuCurrentState.OPEN) || (this.root.menuCurrentState == root.menuCurrentState.OPENING) )
        {
            //Does not work
            View b = findViewById(R.id.MenuButton);
            b.setVisibility(View.GONE);
        }
        else
        {
            setVisible(true);
            View b = findViewById(R.id.MenuButton);
            b.setVisibility(View.VISIBLE);

        }
    }
}