package com.example.android.howitcook.Model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import com.example.android.howitcook.DAL.CourseDAL;
import com.example.android.howitcook.R;
/**
 * Created by Admin on 12/12/2015.
 */
public class Category implements Serializable{
    //Private Properties
    private int _id;
    private String _title;
    private List<Course> _course;
    private String _imageSrc;

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
            _course = db.findByCatelory(this.get_id());
        }
        return _course;
    }

    public void set_course(List<Course> _course) {
        this._course = _course;
    }

    public int TotalCourse(){
        return get_course().size();
    }

    public String get_imageSrc() {
        return _imageSrc;
    }

    public void set_imageSrc(String _imageSrc) {
        this._imageSrc = _imageSrc;
    }

    public int getImageResource() throws NoSuchFieldException, IllegalAccessException {
        Field field = R.drawable.class.getDeclaredField(this.get_imageSrc());
        return field.getInt(this);
    }
}
