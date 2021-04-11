package com.example.squishyrollremake.API;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

public class AnimeSingleton {

    public static AnimeSingleton instance;
    private RequestQueue requestQueue;
    private static Context context;

    private AnimeSingleton(Context context){
        this.context = context;
    }

    public static AnimeSingleton getInstance() {
        if(instance == null){
            instance = new AnimeSingleton(context);
        }
        return instance;
    }



    //build request queue

    public RequestQueue getRequestQueue() {
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
}
