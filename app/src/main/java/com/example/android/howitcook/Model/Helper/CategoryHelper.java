package com.example.android.howitcook.Model.Helper;

import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.R;

import java.lang.reflect.Field;

/**
 * Created by Admin on 29/12/2015.
 */
public class CategoryHelper {
    private Category _category;
    public CategoryHelper(Category category){
        _category = category;
    }
    public int TotalCourse(){
        return _category.get_course().size();
    }
    public int getImageResource() throws IllegalAccessException, NoSuchFieldException {
        Field field = R.drawable.class.getDeclaredField(_category.get_imageSrc());
        return field.getInt(this);
    }
}
