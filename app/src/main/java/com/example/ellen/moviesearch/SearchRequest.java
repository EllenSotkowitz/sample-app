package com.example.ellen.moviesearch;

import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.List;

public class SearchRequest extends OmdbRequest {
    private static String SEARCH_TAG = "Search";

    public interface Listener {
        void onResponse(List<MovieData> response);
    }

    public SearchRequest(String tag, final Listener listener, final ErrorListener errorListener) {
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append("&s=%s");
        String url = stringBuilder.toString();
        url = String.format(url, API_KEY, tag);
        request = new JsonObjectRequest(
                com.android.volley.Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String movieData;
                        try {
                            movieData = response.getString(SEARCH_TAG);
                            Gson gson = new Gson();
                            Type type = new TypeToken<List<MovieData>>() {
                            }.getType();
                            List<MovieData> list = gson.fromJson(movieData, type);
                            listener.onResponse(list);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        errorListener.onErrorResponse(error);
                    }
                });
    }
}
