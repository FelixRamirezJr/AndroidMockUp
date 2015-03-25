package com.example.optimusprime.fiftyfifty;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


/**
 * Created by Optimus Prime on 3/21/2015.
 */
public class DemoDirections extends AsyncTask<String, Integer,String> {
    String overViewString = "";
    GoogleMap parentMap;
    ArrayList<LatLng> latLngsList;
    static Marker halfMarker;
    MarkerOptions halfMarkerRef;
    static ArrayList<Polyline> polyLinesList = new ArrayList<>();

    //This is a hacky way to do this
    //TODO: in the future, we should not pass this reference from the parent.
    //TODO: Separate this into different classes
    public DemoDirections(GoogleMap mapRef) {
        //To access the Maps and Directions API for directions
        parentMap = mapRef;
    }

    /**
     * This is an asynchronous call. This will not execute on the main thread.
     * TODO: Have a way in the main thread to wait for the result of this function call
     * @param src
     * @return
     */
    protected String doInBackground(String... src) {

        //The default JSON query request URL
        String urlString = "http://maps.googleapis.com/maps/api/directions/json?" +
                "origin=" + src[0] +"&destination="+ src[1] +"&sensor=false";
        Log.d("URL", urlString);
        HttpURLConnection urlConnection;
        URL url;

        try {
            //URL object to open a connection to the Google API server
            url = new URL(urlString);
            //Open connection to establish input stream
            urlConnection = (HttpURLConnection) url.openConnection();
            String test = "";
            String strLn;
            StringBuilder sb = new StringBuilder();

            //Input reader from the server
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(urlConnection.getInputStream()), 16384);

            //Append strings until there is nothing left to read
            while((strLn = input.readLine()) != null)
            {
                sb.append(strLn);
            }
            input.close();
            test=sb.toString();

            //Convert the string into a JSON object that contains all the information about directions
            //For future I think this function should only return the JSON object and have
            //another class parse the JSON object.
            //For now we are only parsing just for the overview polyline hashcode for directions
            JSONObject jObj = new JSONObject(test);
            JSONArray routesArray = jObj.getJSONArray("routes");
            JSONObject routes = routesArray.getJSONObject(0);
            JSONArray legsArray = routes.getJSONArray("legs");
            JSONObject legs = legsArray.getJSONObject(0);
            //JSONObject steps =legsArray.getJSONObject(0);
            JSONObject polyLine = routes.getJSONObject("overview_polyline");
            JSONArray stepsArray = legs.getJSONArray("steps");
            JSONObject steps = stepsArray.getJSONObject(0);
            JSONObject distObj = steps.getJSONObject("distance");
            double nigger = distObj.getInt("value");

            //JSONObject stepsArray = steps.getJSONObject("steps");
            //JSONObject stepsDistance = distanceArray.getJSONObject("distance");
            //JSONObject distanceValue = distanceArray.getJSONObject(1);
            //int distance = distanceArray.getInt("distance");
            //JSONObject stepDistance = distanceArray.getJSONObject("distance");
            double halfwayDistance = 3.0 /*stepsDistance.getInt("value");*/;
            //String distance = distanceArray.getString("text");
            Log.d("distance",Double.toString(halfwayDistance));

            overViewString =  polyLine.getString("points");
            Log.d("test1 string: ", overViewString);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Return
        return overViewString;
    }

    protected void onProgressUpdate(Integer... i){

    }

    /**
     * Need to update this.
     * TODO: This function should not draw the lines but for now it will
     * TODO: Later on, We should draw the lines in a different class.
     * @param result
     */
    protected void onPostExecute(String result)
    {

        if (halfMarker!=null) {Log.d("isNULL","false");halfMarker.remove();}else Log.d("isNUL","true");
        //We get the hashed code and use the PolyUtil to get the arraylist of LatLng objects
        latLngsList = (ArrayList<LatLng>) PolyUtil.decode(result);

        //If there was a previous directions drawn, delete it.
        for(Polyline p : polyLinesList){
            p.remove();
        }
        polyLinesList.clear();

        //Draw the lines on map
        Polyline line;



        try {
            for (int i = 0; i < latLngsList.size(); i++) {
                line = parentMap.addPolyline(new PolylineOptions()
                        .add(latLngsList.get(i), latLngsList.get(i + 1))
                        .width(5).color(Color.RED));
                polyLinesList.add(line);
                if(i==latLngsList.size()/2){
                    LatLng loc = new LatLng(latLngsList.get(i).latitude,latLngsList.get(i).longitude);
                    halfMarkerRef = new MarkerOptions().position(loc).title("half marker");
                    halfMarker = parentMap.addMarker(halfMarkerRef);
                }

            }


        }
        catch (Exception e){ e.printStackTrace();}
        Log.d("Size", Integer.toString(latLngsList.size()));
    }
}

