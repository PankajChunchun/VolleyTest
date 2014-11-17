package com.pankaj.volleytest.network;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MyStringRequest extends BaseRequest {

    public MyStringRequest(Context context) {
        super(context);
    }

    @Override
    public void doGet(String url, final Map<String, String> params) {

        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d(TAG, "onResponse ::\n" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                /*Map<String, String> headers = new HashMap<String, String>();
                headers.put("CUSTOM_HEADER", "Android");
                headers.put("ANOTHER_CUSTOM_HEADER", "Pankaj");
                return headers;*/
                return super.getHeaders();
            }
        };
        mNetworkRequest.addToRequestQueue(postRequest);
    }

    @Override
    public void doPost(String url, final Map<String, String> params) {
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d(TAG, "onResponse ::\n" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {
            @Override
            protected Map<String, String> getParams() {
                return params;
            }
        };
        mNetworkRequest.addToRequestQueue(postRequest);
    }

    @Override
    public void doPut(String url, final Map<String, String> params) {

        StringRequest putRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d(TAG, "onResponse ::\n" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

        };

        mNetworkRequest.addToRequestQueue(putRequest);
    }

    @Override
    public void doDelete(String url, final Map<String, String> params) {
        StringRequest deleteRequest = new StringRequest(Request.Method.DELETE,
                url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d(TAG, "onResponse ::\n" + response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error.
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

        };
        mNetworkRequest.addToRequestQueue(deleteRequest);
    }
}
