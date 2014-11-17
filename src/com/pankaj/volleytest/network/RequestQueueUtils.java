package com.pankaj.volleytest.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.Volley;

class RequestQueueUtils {
    private static final String TAG = RequestQueueUtils.class.getSimpleName();
    private static final int INITIAL_TIMEOUT = 20 * 1000;
    private static final int MAX_RETRY = 1;
    private static final float BACKOFF_MULTIPLIER = 1.0f;

    private static RequestQueueUtils mQueueUtils;
    private RequestQueue mRequestQueue;
    private Context mContext;

    private RequestQueueUtils(Context context) {
        mContext = context.getApplicationContext();
        mRequestQueue = Volley.newRequestQueue(mContext);
    }

    final static synchronized RequestQueueUtils getInstance(Context context) {
        if (mQueueUtils == null) {
            mQueueUtils = new RequestQueueUtils(context);
        }
        return mQueueUtils;
    }

    /**
     * Adds the specified request to the global queue, if tag is specified then
     * it is used else Default TAG is used.
     * 
     * @param request
     * @param tag
     */
    final <T> void addToRequestQueue(Request<T> request, String tag) {
        // set the default tag if tag is empty
        request.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        VolleyLog.d("Adding request to queue: %s", request.getUrl());

        // There is no direct way to specify request timeout value in Volley,
        // but there is a workaround, you need to set a RetryPolicy on the
        // request object. The DefaultRetryPolicy class takes an argument called
        // initialTimeout, this can be used to specify a request timeout, make
        // sure the maximum retry count is 1 so that volley does not retry the
        // request after the timeout has been exceeded.
        request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
                MAX_RETRY, BACKOFF_MULTIPLIER));
        mRequestQueue.add(request);
    }

    /**
     * Adds the specified request to the global queue using the Default TAG.
     * 
     * @param request
     * @param tag
     */
    final <T> void addToRequestQueue(Request<T> request) {
        Log.d(TAG, "Inside addToRequestQueue...");
        // set the default tag if tag is empty
        request.setTag(TAG);
        VolleyLog.d("Adding request to queue: %s", request.getUrl());

        // There is no direct way to specify request timeout value in Volley,
        // but there is a workaround, you need to set a RetryPolicy on the
        // request object. The DefaultRetryPolicy class takes an argument called
        // initialTimeout, this can be used to specify a request timeout, make
        // sure the maximum retry count is 1 so that volley does not retry the
        // request after the timeout has been exceeded.
        request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
                MAX_RETRY, BACKOFF_MULTIPLIER));
        mRequestQueue.add(request);
    }

    /**
     * Cancels all pending requests by the specified TAG, it is important to
     * specify a TAG so that the pending/ongoing requests can be cancelled.
     * 
     * @param tag
     */
    final void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}