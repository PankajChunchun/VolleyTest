package com.pankaj.volleytest.network;

import java.util.Map;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

public class MyImageRequest extends BaseRequest {

    private ImageDownloader mDownloader;

    public MyImageRequest(Context context, ImageDownloader downloader) {
        super(context);
        mDownloader = downloader;
    }

    @Override
    public void doGet(String url, Map<String, String> params) {
        ImageRequest imageRequest = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        Log.d(TAG, "Image downloaded");
                        mDownloader.onResonse(response);
                    }
                }, 0, 0, null, new Response.ErrorListener() {
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "Error while Image downloading...");
                    }
                });
        mNetworkRequest.addToRequestQueue(imageRequest);
    }

    @Override
    public void doPost(String url, Map<String, String> params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doPut(String url, Map<String, String> params) {
        // TODO Auto-generated method stub

    }

    @Override
    public void doDelete(String url, Map<String, String> params) {
        // TODO Auto-generated method stub

    }

    public static interface ImageDownloader {
        public void onResonse(Bitmap bitmap);
    }
}
