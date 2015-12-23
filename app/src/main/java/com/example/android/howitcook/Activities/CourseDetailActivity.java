package com.example.android.howitcook.Activities;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.android.howitcook.Constant;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.Model.Stuff;
import com.example.android.howitcook.R;

import org.w3c.dom.Text;

public class CourseDetailActivity extends AppCompatActivity {

    //Private Properties
    private TextView _txtCourseTitle;
    private TextView _txtCourseDescription;
    private ImageView _imgCourseImage;
    private ListView _listStuff;
    private ListView _listStep;
    private Course _currentCourse;
    private ArrayAdapter<String> _stuffAdapter;
    private ArrayAdapter<String> _stepAdapter;
    private LinearLayout _lineStuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        //Set element
        _txtCourseTitle = (TextView)findViewById(R.id.txt_course_title);
        _txtCourseDescription = (TextView)findViewById(R.id.txt_course_description);
        _imgCourseImage = (ImageView)findViewById(R.id.img_course_item);
        _listStuff = (ListView)findViewById(R.id.list_stuff);
        _listStep = (ListView)findViewById(R.id.list_step);
        _lineStuff = (LinearLayout)findViewById(R.id.line_stuff);
        //Get Course
        _currentCourse = (Course)getIntent().getSerializableExtra(Constant.CURRENT_COURSE);
        //Set Title
        _txtCourseTitle.setText(_currentCourse.get_title());
        //Set Description
        _txtCourseDescription.setText(_currentCourse.get_description());
        //Set Image
        try {
            _imgCourseImage.setImageResource(_currentCourse.getImageResource());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //Set List stuff
        for(Stuff stuff: _currentCourse.get_stuffs()){
            TextView textView = new TextView(this);
            textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            textView.setText("_ "+stuff.get_content());
            _lineStuff.addView(textView);
        }
        _stuffAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                                                android.R.id.text1,
                                                _currentCourse.get_stuffs_at_list());
        _listStuff.setAdapter(_stuffAdapter);
        //Set List step
        _stepAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
                android.R.id.text1,
                _currentCourse.get_steps_at_list());
        _listStep.setAdapter(_stepAdapter);
    }
}
