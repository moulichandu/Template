package com.yeeooh.jpmorgan.api;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YEEOOH on 11/21/2017.
 */

public class CustomStringRequest extends StringRequest {
    HashMap<String,String> hm;
    public CustomStringRequest(int method, String url, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return hm;
    }
    public void setRequestParams(HashMap<String,String> hm)
    {
        this.hm=hm;
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        Log.v("Netowrk reposne","Netowrk reposne "+response);
        return super.parseNetworkResponse(response);
    }
}
