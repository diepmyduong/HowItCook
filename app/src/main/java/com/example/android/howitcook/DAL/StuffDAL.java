package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Step;
import com.example.android.howitcook.Model.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Admin on 23/12/2015.
 */
public class StuffDAL {
    public StuffDAL(){}


    public List<Stuff> getAllList(){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Stuff> query = realm.where(Stuff.class);
        RealmResults<Stuff> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
    }

    public Stuff findById(int id){
        Realm realm = Realm.getDefaultInstance();
        Stuff result = realm.where(Stuff.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }

    public List<Stuff> findByCourse(int id){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Stuff> query = realm.where(Stuff.class).equalTo("_courseID",id);
        RealmResults<Stuff> models = query.findAll();
        models.sort("_rank");
        realm.close();
        return  models.subList(0,models.size());
    }
}
