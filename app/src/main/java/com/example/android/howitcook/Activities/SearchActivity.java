package com.example.android.howitcook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.android.howitcook.Adapter.CourseAdapter;
import com.example.android.howitcook.Constant;
import com.example.android.howitcook.DAL.CourseDAL;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.R;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    //Private Properties
    private EditText _editSearchBox;
    private ImageView _imgSearchButton;
    private ListView _listCourse;
    private CourseAdapter _courseAdapter;
    private CourseDAL _db;
    private List<Course> _courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        //Set Element
        _editSearchBox = (EditText)findViewById(R.id.edit_search_box);
        _imgSearchButton = (ImageView)findViewById(R.id.img_search_button);
        _listCourse = (ListView)findViewById(R.id.list_course);
        //Set Database
        _db = new CourseDAL();
        //Set Listener
        _imgSearchButton.setOnClickListener(searchButtonOnClickListener());
        _listCourse.setOnItemClickListener(listCourseItemOnClickListener());
    }

    //Listener
    //Search Button On Click
    private View.OnClickListener searchButtonOnClickListener(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get request
                String request = _editSearchBox.getText().toString();
                if(request.isEmpty() || request == ""){
                    _courses = _db.getAllList();
                    _courseAdapter = new CourseAdapter(getApplicationContext(),_courses);
                    _listCourse.setAdapter(_courseAdapter);
                }else{
                    _courses = _db.findByFilter(request);
                    _courseAdapter = new CourseAdapter(getApplicationContext(),_courses);
                    _listCourse.setAdapter(_courseAdapter);
                }
            }
        };
    }
    //Course of Category On Click
    private AdapterView.OnItemClickListener listCourseItemOnClickListener(){
        return new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Get Course
                Course course = _courses.get(position);
                Intent i = new Intent(SearchActivity.this,CourseDetailActivity.class);
                i.putExtra(Constant.CURRENT_COURSE,course);
                startActivity(i);
            }
        };
    }

}
