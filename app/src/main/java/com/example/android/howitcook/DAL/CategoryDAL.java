package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Category;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Admin on 12/12/2015.
 */
public class CategoryDAL {

    public CategoryDAL(){
    }
    public List<Category> getAllList(){

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Category> query = realm.where(Category.class);
        RealmResults<Category> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
    }

    public Category findById(int id){
        Realm realm = Realm.getDefaultInstance();
        Category result = realm.where(Category.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }
}
