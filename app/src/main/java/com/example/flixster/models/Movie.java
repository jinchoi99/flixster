package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    //iterate through movieJsonArray and construct Movie object for each movie
    //this is a static method -> call by Movie.fromJsonArray(), not by instantiating Movie object Ob1 and then calling Ob1.fromJsonArray()
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for(int i=0; i<movieJsonArray.length(); i++){
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }
}
