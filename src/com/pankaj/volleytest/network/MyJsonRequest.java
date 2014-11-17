package com.pankaj.volleytest.network;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

/**
 * 
 * @author pankaj
 *
 */
public class MyJsonRequest extends BaseRequest {

    public MyJsonRequest(Context context) {
        super(context);
    }

    @Override
    public final void doGet(String url, final Map<String, String> params) {
        JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG,
                                    "onResponse :: \n" + response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                /*
                 * Map<String, String> headers = new HashMap<String, String>();
                 * headers.put("CUSTOM_HEADER", "Android");
                 * headers.put("ANOTHER_CUSTOM_HEADER", "Pankaj"); return
                 * headers;
                 */
                return super.getHeaders();
            }

        };
        mNetworkRequest.addToRequestQueue(jsObjRequest);
    }

    @Override
    public final void doPost(String url, Map<String, String> params) {
        // Can override getParams as well as other methods, another way is to
        // pass params into parameter of JsonObjectRequest. So below method has
        // been implemented for that way.
        JsonObjectRequest postRequest = new JsonObjectRequest(url,
                new JSONObject(params), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG,
                                    "onResponse :: \n" + response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                });

        // add the request object to the queue to be executed
        mNetworkRequest.addToRequestQueue(postRequest);
    }

    @Override
    public final void doPut(String url, final Map<String, String> params) {
        JsonObjectRequest putRequest = new JsonObjectRequest(
                Request.Method.PUT, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG,
                                    "onResponse :: \n" + response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

        };

        // add the request object to the queue to be executed
        mNetworkRequest.addToRequestQueue(putRequest);
    }

    @Override
    public final void doDelete(String url, final Map<String, String> params) {
        JsonObjectRequest deleteRequest = new JsonObjectRequest(
                Request.Method.DELETE, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d(TAG,
                                    "onResponse :: \n" + response.toString(4));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse :: " + error.toString());
                    }
                }) {

            @Override
            protected Map<String, String> getParams() {
                return params;
            }

        };

        // add the request object to the queue to be executed
        mNetworkRequest.addToRequestQueue(deleteRequest);
    }
}