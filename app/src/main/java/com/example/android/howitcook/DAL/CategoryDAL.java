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

//    private List<Category> _categories;

    public CategoryDAL(){
//        _categories = new ArrayList<>();
//        _categories.add(new Category(1,"Canh","categories_1"));
//        _categories.add(new Category(2,"Xào","categories_2"));
//        _categories.add(new Category(3,"Hầm","categories_3"));
//        _categories.add(new Category(4,"Chiên","categories_4"));
//        _categories.add(new Category(5,"Rang","categories_5"));
//        _categories.add(new Category(6,"Cuốn","categories_6"));
//        _categories.add(new Category(7,"Cơm","categories_7"));
//        _categories.add(new Category(8,"Bánh","categories_8"));
//        _categories.add(new Category(9,"Chè","categories_9"));
    }
    public List<Category> getAllList(){

        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Category> query = realm.where(Category.class);
        RealmResults<Category> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
//        return _categories;
    }

    public Category findById(int id){
//        for(Category category : _categories){
//            if(category.get_id() == id){
//                return category;
//            }
//        }
//        return null;
        Realm realm = Realm.getDefaultInstance();
        Category result = realm.where(Category.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }
}
