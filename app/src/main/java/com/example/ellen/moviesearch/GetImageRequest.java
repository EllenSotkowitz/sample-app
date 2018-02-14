package com.example.ellen.moviesearch;

import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.webkit.URLUtil;

import com.android.volley.*;
import com.android.volley.toolbox.ImageRequest;

public class GetImageRequest {
    private static String TAG = GetImageRequest.class.getName();
    private ImageRequest request;

    public GetImageRequest(final ImageView imageView, String poster) {

        request = new ImageRequest(poster,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap bitmap) {
                        imageView.setImageBitmap(bitmap);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null,
                new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, error.getMessage());
                    }
                });
    }

    public void addToQueue(RequestQueue queue) {
        queue.getQueue().add(request);
    }
}
