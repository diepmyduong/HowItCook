package com.example.android.howitcook.Store;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Step;
import com.example.android.howitcook.Model.Stuff;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.realm.Realm;
import io.realm.internal.android.JsonUtils;

/**
 * Created by Admin on 28/12/2015.
 */
public class DatabaseBuilder {

    private Context _context;

    public DatabaseBuilder(Context context)
    {
        _context = context;
    }

    public void createDatabase() throws JSONException {
        //Load data form json
        List<Category> categories = loadCategoryFromJSON(loadJSONFromAsset("category.json"));
        List<Course> courses = loadCoursesFormJSON(loadJSONFromAsset("course.json"));
        List<Step> steps = loadStepsFormJSON(loadJSONFromAsset("step.json"));
        List<Stuff> stuffs = loadStuffsFormJSON(loadJSONFromAsset("stuff.json"));
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(categories);
        realm.copyToRealmOrUpdate(courses);
        realm.copyToRealmOrUpdate(stuffs);
        realm.copyToRealmOrUpdate(steps);
        realm.commitTransaction();
    }

    private String loadJSONFromAsset (String filename) {
        String json = null;
        try {
            InputStream is = _context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private List<Category> loadCategoryFromJSON(String json) throws JSONException {
        List<Category> result = new ArrayList<>();
        JSONArray jsCategories = new JSONArray(json);
        for(int i = 0; i < jsCategories.length()-1;i++){
            JSONObject jsCategory = jsCategories.getJSONObject(i);
            Category category = new Category();
            category.set_id(jsCategory.getInt("id"));
            category.set_title(jsCategory.getString("title"));
            category.set_imageSrc(jsCategory.getString("image"));
            result.add(category);
        }
        return  result;
    }
    private List<Course> loadCoursesFormJSON(String json) throws JSONException {
        List<Course> result = new ArrayList<>();
        JSONArray jsCourses = new JSONArray(json);
        for(int i = 0; i < jsCourses.length()-1;i++){
            JSONObject jsCourse = jsCourses.getJSONObject(i);
            Course course = new Course();
            course.set_id(jsCourse.getInt("id"));
            course.set_title(jsCourse.getString("title"));
            course.set_description(jsCourse.getString("description"));
            course.set_imageSrc(jsCourse.getString("image"));
            course.set_categoryID(jsCourse.getInt("categoryId"));
            result.add(course);
        }
        return  result;
    }
    private List<Step> loadStepsFormJSON(String json) throws JSONException {
        List<Step> result = new ArrayList<>();
        JSONArray jsSteps = new JSONArray(json);
        for(int i = 0; i < jsSteps.length()-1;i++){
            JSONObject jsStep = jsSteps.getJSONObject(i);
            Step step = new Step();
            step.set_id(jsStep.getInt("id"));
            step.set_courseID(jsStep.getInt("courseID"));
            step.set_rank(jsStep.getInt("rank"));
            step.set_content(jsStep.getString("content"));
            result.add(step);
        }
        return  result;
    }
    private List<Stuff> loadStuffsFormJSON(String json) throws JSONException {
        List<Stuff> result = new ArrayList<>();
        JSONArray jsStuffs = new JSONArray(json);
        for(int i = 0; i < jsStuffs.length()-1;i++){
            JSONObject jsStuff = jsStuffs.getJSONObject(i);
            Stuff stuff = new Stuff();
            stuff.set_id(jsStuff.getInt("id"));
            stuff.set_courseID(jsStuff.getInt("courseID"));
            stuff.set_rank(jsStuff.getInt("rank"));
            stuff.set_content(jsStuff.getString("content"));
            result.add(stuff);
        }
        return  result;
    }
}
