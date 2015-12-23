package com.example.android.howitcook.Model;

import com.example.android.howitcook.DAL.CourseDAL;

import java.io.Serializable;

/**
 * Created by Admin on 23/12/2015.
 */
public class Step implements Serializable{
    private int _id;
    private int _courseID;
    private int _rank;
    private String _content;
    private Course _course;

    public Step(){}
    public Step(int _id, int _courseID, int _rank, String _content) {
        this();
        this._id = _id;
        this._courseID = _courseID;
        this._rank = _rank;
        this._content = _content;
    }
    public Step(int _id, int _courseID, int _rank, String _content, Course _course) {
        this(_id,_courseID,_rank,_content);
        this._course = _course;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_courseID() {
        return _courseID;
    }

    public void set_courseID(int _courseID) {
        this._courseID = _courseID;
    }

    public int get_rank() {
        return _rank;
    }

    public void set_rank(int _rank) {
        this._rank = _rank;
    }

    public String get_content() {
        return _content;
    }

    public void set_content(String _content) {
        this._content = _content;
    }

    public Course get_course() {
        if(_course == null){
            CourseDAL db = new CourseDAL();
            _course = db.findById(get_courseID());
        }
        return _course;
    }

    public void set_course(Course _course) {
        this._course = _course;
    }
}
