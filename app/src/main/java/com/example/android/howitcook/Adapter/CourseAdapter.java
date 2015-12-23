package com.example.android.howitcook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.R;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Admin on 13/12/2015.
 */
public class CourseAdapter extends ArrayAdapter {
    private List<Course> _course;

    public CourseAdapter(Context context, List<Course> objects) {
        super(context, 0, objects);
        _course = objects;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Course course = _course.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.course_item_template,parent,false);
        }
        TextView txtCourseTitle = (TextView)convertView.findViewById(R.id.txt_course_title);
        TextView txtCourseDescription = (TextView)convertView.findViewById(R.id.txt_course_description);
        ImageView imgCourse = (ImageView) convertView.findViewById(R.id.img_course_item);

        txtCourseTitle.setText(course.get_title());
        txtCourseDescription.setText(course.get_description());
        try {
            imgCourse.setImageResource(course.getImageResource());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return  convertView;
    }

}
