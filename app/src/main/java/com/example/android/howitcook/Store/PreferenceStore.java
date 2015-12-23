package com.example.android.howitcook.Store;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.android.howitcook.Configs.CookBookApplication;

/**
 * Created by Admin on 8/12/2015.
 */
public class PreferenceStore {

    public static class KEY {
        public static final String PREF_USERNAME = "prefUserName";
    }

    private SharedPreferences getSharedPreferences(){
        return PreferenceManager.getDefaultSharedPreferences(CookBookApplication.getContext());
    }


    public String getValue(String key , boolean removeAfterGet){
        SharedPreferences preferenceManager =getSharedPreferences();
        String result = preferenceManager.getString(key,null);
        if(removeAfterGet){
            setValue(key,null);
        }
        return result;
    }
    public String getValue(String key, String defaultValue , boolean removeAfterGet){
        SharedPreferences preferenceManager =getSharedPreferences();
        String result = preferenceManager.getString(key, defaultValue);
        if(removeAfterGet){
            setValue(key,null);
        }
        return result;
    }


    public void setValue(String key, String value){
        SharedPreferences preferenceManager = getSharedPreferences();
        SharedPreferences.Editor editor = preferenceManager.edit();
        editor.putString(key, value);
        editor.commit();
    }
}
