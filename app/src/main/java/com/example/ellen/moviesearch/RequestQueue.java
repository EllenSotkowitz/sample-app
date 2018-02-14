package com.example.ellen.moviesearch;

import android.content.Context;

import com.android.volley.toolbox.Volley;

public class RequestQueue {
    private com.android.volley.RequestQueue queue;
    private static RequestQueue instance;

    public com.android.volley.RequestQueue getQueue(){
        return queue;
    }

    public static RequestQueue getInstance(Context context) {
        if (instance == null) {
            instance = new RequestQueue(context);
        }
        return instance;
    }

    private RequestQueue(Context context) {
        this.queue = Volley.newRequestQueue(context);
    }
}
