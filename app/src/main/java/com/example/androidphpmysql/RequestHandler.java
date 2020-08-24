package com.example.androidphpmysql;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class RequestHandler {
    private static RequestHandler nInstance;
    private RequestQueue nRequestQueue;
    private static Context nCtx;

    private RequestHandler(Context context){
        nCtx =context;
        nRequestQueue= getRequestQueue();
    }

    public static synchronized RequestHandler getInstance(Context context){
        if (nInstance == null){
            nInstance = new RequestHandler (context);
        }
        return nInstance;
    }

    private RequestQueue getRequestQueue() {
        if(nRequestQueue == null){
            nRequestQueue= Volley.newRequestQueue (nCtx.getApplicationContext ());
        }
        return nRequestQueue;
    }
    public <T> void addToRequestQueue(Request<T> req){ getRequestQueue ().add (req);}
}
