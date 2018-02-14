package com.example.ellen.moviesearch;

import com.android.volley.toolbox.JsonObjectRequest;

public class OmdbRequest {
    protected static final String API_KEY = "ee60b1cc";
    protected static final String BASE_URL = "http://www.omdbapi.com/?apikey=%s";
    protected JsonObjectRequest request;

    public interface ErrorListener {
        void onErrorResponse(Exception error);
    }

    public void addToQueue(RequestQueue queue) {
        queue.getQueue().add(request);
    }
}
