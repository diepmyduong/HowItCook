package com.example.android.howitcook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.howitcook.Adapter.CourseAdapter;
import com.example.android.howitcook.Constant;
import com.example.android.howitcook.DAL.CategoryDAL;
import com.example.android.howitcook.DAL.CourseDAL;
import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.R;

public class CategoryActivity extends AppCompatActivity {

    private TextView _txtCategoryTitle;
    private ListView _listCourse;
    private EditText _editSearchBox;
    private ImageView _imgSearchButton;
    private CourseAdapter _courseAdapter;
    private Category _currentCategory;
    private CourseDAL _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //Set Element
        _txtCategoryTitle = (TextView)findViewById(R.id.txt_category_title);
        _listCourse = (ListView) findViewById(R.id.list_course);
        _editSearchBox = (EditText)findViewById(R.id.edit_search_box);
        _imgSearchButton = (ImageView)findViewById(R.id.img_search_button);
        //Get Category
        _db = new CourseDAL();
        int id = (int)getIntent().getSerializableExtra(Constant.CURRENT_CATEGORY);
        _currentCategory = new CategoryDAL().findById(id);
        //Set Title
        _txtCategoryTitle.setText(_currentCategory.get_title());
        //Load Course Of Category
        _courseAdapter = new CourseAdapter(getApplicationContext(),_currentCategory.get_course());
        _listCourse.setAdapter(_courseAdapter);
        //Set Listener
        _imgSearchButton.setOnClickListener(searchButtonOnClickListener());
        _listCourse.setOnItemClickListener(listCourseItemOnClickListener());
    }

    //Listener
    //Search Button On Click
    private View.OnClickListener searchButtonOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get request
                String request = _editSearchBox.getText().toString();
                //load result
                if(request.isEmpty() || request == ""){
                    _courseAdapter = new CourseAdapter(getApplicationContext(), _currentCategory.get_course());
                    _listCourse.setAdapter(_courseAdapter);
                }else{
                    _courseAdapter = new CourseAdapter(getApplicationContext(), _db.findByFilter(request, _currentCategory.get_course()));
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
                Course course = _currentCategory.get_course().get(position);
                Intent i = new Intent(CategoryActivity.this,CourseDetailActivity.class);
                i.putExtra(Constant.CURRENT_COURSE,course.get_id());
                startActivity(i);
            }
        };
    }
}
