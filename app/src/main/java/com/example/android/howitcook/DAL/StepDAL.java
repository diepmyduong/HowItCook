package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Step;
import com.example.android.howitcook.Model.Stuff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Admin on 23/12/2015.
 */
public class StepDAL {

    public StepDAL(){}


    public List<Step> getAllList(){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Step> query = realm.where(Step.class);
        RealmResults<Step> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
    }

    public Step findById(int id){
        Realm realm = Realm.getDefaultInstance();
        Step result = realm.where(Step.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }

    public List<Step> findByCourse(int id){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Step> query = realm.where(Step.class).equalTo("_courseID",id);
        RealmResults<Step> models = query.findAll();
        models.sort("_rank");
        realm.close();
        return  models.subList(0,models.size());
    }
}
