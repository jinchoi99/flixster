package com.example.flixster.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Movie {

    String posterPath;
    String title;
    String overView;

    //Construct Movie by parsing through data in jsonObject
    public Movie(JSONObject jsonObject) throws JSONException {
         posterPath = jsonObject.getString("poster_path");
         title = jsonObject.getString("title");
         overView = jsonObject.getString("overview");

    }
}
