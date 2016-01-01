package com.example.android.howitcook.DAL;

import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.StringHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Admin on 12/12/2015.
 */
public class CourseDAL {

    public CourseDAL(){}

    public List<Course> getAllList(){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Course> query = realm.where(Course.class);
        RealmResults<Course> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
    }

    public Course findById(int id){
        Realm realm = Realm.getDefaultInstance();
        Course result = realm.where(Course.class).equalTo("_id",id).findFirst();
        realm.close();
        return  result;
    }

    public List<Course> findByCategory(int id){
        Realm realm = Realm.getDefaultInstance();
        RealmQuery<Course> query = realm.where(Course.class).equalTo("_categoryID",id);
        RealmResults<Course> models = query.findAll();
        realm.close();
        return models.subList(0,models.size());
    }

    public Course getRandom(){
        Random random = new Random();
        List<Course> list = getAllList();
        int index = random.nextInt(list.size()-1);
        return list.get(index);
    }

    public List<Course> findByFilter(String request){
        return findByFilter(request,getAllList());
    }
    public List<Course> findByFilter(String request, List<Course> data){
        request = StringHelper.removeAccent(request.toLowerCase());
        List<Course> result = new ArrayList<>();
        for(Course course: data){
            if(StringHelper.removeAccent(course.get_title().toLowerCase()).contains(request)){
                result.add(course);
                continue;
            }
            if(StringHelper.removeAccent(course.get_description().toLowerCase()).contains(request)){
                result.add(course);
                continue;
            }
        }
        return result;
    }


}
