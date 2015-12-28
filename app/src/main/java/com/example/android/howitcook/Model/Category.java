package com.example.android.howitcook.Model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import com.example.android.howitcook.DAL.CourseDAL;
import com.example.android.howitcook.Model.Helper.CategoryHelper;
import com.example.android.howitcook.R;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admin on 12/12/2015.
 */
public class Category extends RealmObject implements Serializable {
    //Private Properties
    @PrimaryKey
    @Index
    private int _id;
    private String _title;
    private String _imageSrc;
    @Ignore
    private List<Course> _course;
    @Ignore
    private CategoryHelper _helper;

    public Category(){}
    public Category(int _id, String _title, String _imageSrc) {
        this();
        this._id = _id;
        this._title = _title;
        this._imageSrc = _imageSrc;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_title() {
        return _title;
    }

    public void set_title(String _title) {
        this._title = _title;
    }

    public List<Course> get_course() {
        if(_course == null){
            CourseDAL db = new CourseDAL();
            _course = db.findByCategory(this.get_id());
        }
        return _course;
    }

    public void set_course(List<Course> _course) {
        this._course = _course;
    }


    public String get_imageSrc() {
        return _imageSrc;
    }

    public void set_imageSrc(String _imageSrc) {
        this._imageSrc = _imageSrc;
    }

    public CategoryHelper get_helper() {
        if(_helper == null){
            _helper = new CategoryHelper(this);
        }
        return _helper;
    }

    //    public int getImageResource() throws IllegalAccessException, NoSuchFieldException {
//        Field field = R.drawable.class.getDeclaredField(this.get_imageSrc());
//        return field.getInt(this);
//    }
//    public int TotalCourse(){
//        return get_course().size();
//    }
}
