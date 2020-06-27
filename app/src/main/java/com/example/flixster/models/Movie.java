package com.example.flixster.models;

import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel // annotation indicates class is Parcelable
public class Movie {
    // fields must be public for parceler
    String backdropPath;
    String posterPath;
    String title;
    String overView;
    String tvReleaseDate;
    Double voteAverage;
    String popularity;
    Integer id;

    // no-arg, empty constructor required for Parceler
    public Movie() {}

    public String getTvReleaseDate() {
        return tvReleaseDate;
    }

    //Construct Movie by parsing through data in jsonObject
    public Movie(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
         posterPath = jsonObject.getString("poster_path");
         title = jsonObject.getString("title");
         overView = jsonObject.getString("overview");
        tvReleaseDate = jsonObject.getString("release_date");
         voteAverage = jsonObject.getDouble("vote_average");
        popularity = jsonObject.getString("popularity");
        id = jsonObject.getInt("id");
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
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverView() {
        return overView;
    }

    public Double getVoteAverage() {
        return voteAverage;
    }

    public Integer getId() {
        return id;
    }

    public String getPopularity() {
        return popularity;
    }
}
