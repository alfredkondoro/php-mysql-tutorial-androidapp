package com.example.androidphpmysql;

import android.content.Context;
import android.content.SharedPreferences;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class SharedPrefManager {
    private static SharedPrefManager nInstance;
    private RequestQueue nRequestQueue;
    private static Context nCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_EMAIL = "useremail";
    private static final String KEY_USER_ID = "userid";


    private SharedPrefManager(Context context){
        nCtx = context;
    }

    public static synchronized SharedPrefManager getInstance(Context context){
        if (nInstance == null){
            nInstance = new SharedPrefManager (context);
        }
        return nInstance;
    }
    public boolean userLogin(int id, String username, String email){
        SharedPreferences sharedPreferences = nCtx.getSharedPreferences (SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit ();

        editor.putInt (KEY_USER_ID, id);
        editor.putString (KEY_USER_EMAIL, email);
        editor.putString (KEY_USERNAME, username);

        editor.apply ();
        return true;
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences = nCtx.getSharedPreferences (SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if(sharedPreferences.getString (KEY_USERNAME,null) != null){
            return true;
        }
        return false;
    }
    public boolean logout(){
        SharedPreferences sharedPreferences = nCtx.getSharedPreferences (SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit ();
        editor.clear ();
        editor.apply ();
        return true;
    }
}
