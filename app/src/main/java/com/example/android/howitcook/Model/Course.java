package com.example.android.howitcook.Model;

import com.example.android.howitcook.DAL.CategoryDAL;
import com.example.android.howitcook.DAL.StepDAL;
import com.example.android.howitcook.DAL.StuffDAL;
import com.example.android.howitcook.Model.Helper.CourseHelper;
import com.example.android.howitcook.R;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Admin on 12/12/2015.
 */
public class Course extends RealmObject implements Serializable {
    //Private Properties
    @PrimaryKey
    @Index
    private int _id;
    private String _title;
    private String _description;
    private String _imageSrc;
    private int _categoryID;
    @Ignore
    private Category _category;
    @Ignore
    private List<Stuff> _stuffs;
    @Ignore
    private List<Step> _steps;
    @Ignore
    private CourseHelper _helper;

    public Course(){}

    public Course(int _id, String _title, String _description, String _imageSrc, int _categoryID) {
        this._id = _id;
        this._title = _title;
        this._description = _description;
        this._imageSrc = _imageSrc;
        this._categoryID = _categoryID;
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

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public List<Stuff> get_stuffs(){
        if(_stuffs == null){
            StuffDAL db = new StuffDAL();
            _stuffs = db.findByCourse(get_id());
        }
        return _stuffs;
    }

    public void set_stuffs(List<Stuff> _stuff) {
        this._stuffs = _stuffs;
    }

    public List<Step> get_steps(){
        if(_steps == null){
            StepDAL db = new StepDAL();
            _steps = db.findByCourse(this.get_id());
        }
        return _steps;
    }

    public void set_steps(List<Step> _steps) {
        this._steps = _steps;
    }

    public String get_imageSrc() {
        return _imageSrc;
    }

    public void set_imageSrc(String _imageSrc) {
        this._imageSrc = _imageSrc;
    }

    public Category get_category() {
        if(_category == null){
            CategoryDAL db = new CategoryDAL();
            this._category = db.findById(this.get_categoryID());
        }
        return _category;
    }

    public void set_category(Category _category) {
        this._category = _category;
    }

    public int get_categoryID() {
        return _categoryID;
    }

    public void set_categoryID(int _categoryID) {
        this._categoryID = _categoryID;
    }

    public CourseHelper get_helper() {
        if(_helper == null){
            _helper = new CourseHelper(this);
        }
        return _helper;
    }

    //    public int getImageResource() throws NoSuchFieldException, IllegalAccessException {
//        Field field = R.drawable.class.getDeclaredField(this.get_imageSrc());
//        return field.getInt(this);
//    }
}
