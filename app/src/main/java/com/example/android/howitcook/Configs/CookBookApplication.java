package com.example.android.howitcook.Configs;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Admin on 8/12/2015.
 */
public class CookBookApplication extends Application{
    private static Context _appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        _appContext = getApplicationContext();
        RealmConfiguration config = new RealmConfiguration.Builder(_appContext).build();
        Realm.setDefaultConfiguration(config);
    }

    public static Context getContext(){
        return _appContext;
    }
}
