package com.pankaj.volleytest.network;

import java.util.Map;

import android.content.Context;

/**
 * 
 * @author pankaj
 *
 */
// TODO: Pass listeners from method argument to handle callback from caller.
public abstract class BaseRequest {

    protected static final String TAG = BaseRequest.class.getSimpleName();
    protected RequestQueueUtils mNetworkRequest = null;
    protected Context mContext = null;

    public BaseRequest(Context context) {
        mContext = context;
        mNetworkRequest = RequestQueueUtils.getInstance(context);
    }

    public abstract void doGet(String url, final Map<String, String> params);

    public abstract void doPost(String url, final Map<String, String> params);

    public abstract void doPut(String url, final Map<String, String> params);

    public abstract void doDelete(String url, final Map<String, String> params);
}
