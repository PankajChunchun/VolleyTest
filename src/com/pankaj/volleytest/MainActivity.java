package com.pankaj.volleytest;

import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.pankaj.volleytest.network.MyJsonRequest;
import com.pankaj.volleytest.network.MyStringRequest;
import com.pankaj.volleytest.network.MyImageRequest;

public class MainActivity extends Activity implements
        MyImageRequest.ImageDownloader {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.imageView);
        // http://www.androidhive.info/2014/05/android-working-with-volley-library-1/
        // http://arnab.ch/blog/2013/08/asynchronous-http-requests-in-android-using-volley/
        // http://www.itsalif.info/content/android-volley-tutorial-http-get-post-put

        // Prepare map to request parameters
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", "Pankaj Kumar");
        params.put("domain",
                "http://stackoverflow.com/users/550966/pankaj-kumar");

        // Do network requests
        MyJsonRequest jsonRequest = new MyJsonRequest(getApplicationContext());
        // jsonRequest.doGet("http://httpbin.org/get", params);
        // Do POST request
        // jsonRequest.doPost("http://httpbin.org/post", params);
        // Do PUT request
        // jsonRequest.doPut("http://httpbin.org/put", params);
        // Do DELETE request
        // jsonRequest.doDelete("http://httpbin.org/delete", params);

        // To test String request
        MyStringRequest myStringRequest = new MyStringRequest(
                getApplicationContext());
        // Do POST request
        // myStringRequest.doPost("http://httpbin.org/post", params);
        // Do PUT request
        // myStringRequest.doPut("http://httpbin.org/put", params);
        // Do DELETE request
        // myStringRequest.doDelete("http://httpbin.org/delete", params);

        // To test image request
        MyImageRequest imageRequest = new MyImageRequest(
                getApplicationContext(), this);
        imageRequest.doGet("http://i62.tinypic.com/72ylmo.png", null);

    }

    @Override
    public void onResonse(Bitmap bitmap) {
        mImageView.setImageBitmap(bitmap);
    }
}
