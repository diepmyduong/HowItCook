package com.example.android.howitcook.Model.Helper;

import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.R;

import java.lang.reflect.Field;

/**
 * Created by Admin on 29/12/2015.
 */
public class CourseHelper {
    private Course _course;

    public CourseHelper(Course course){
        _course = course;
    }
    public int getImageResource() throws NoSuchFieldException, IllegalAccessException {
        Field field = R.drawable.class.getDeclaredField(_course.get_imageSrc());
        return field.getInt(this);
    }
}
