package com.example.android.howitcook.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.R;

import java.util.List;

/**
 * Created by Admin on 12/12/2015.
 */
public class CategoryAdapter extends ArrayAdapter{

    private List<Category> _categories;

    public CategoryAdapter(Context context, List<Category> objects) {
        super(context, 0, objects);
        this._categories = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category categori = _categories.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.categories_item_template,parent,false);
        }
        TextView txtTitle = (TextView)convertView.findViewById(R.id.txt_category_title);
        TextView txtDescription = (TextView) convertView.findViewById(R.id.txt_category_description);
        ImageView imgCategoriBackground = (ImageView)convertView.findViewById(R.id.img_item_background);

        txtTitle.setText(categori.get_title());
        try {
            imgCategoriBackground.setImageResource(categori.getImageResource());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        txtDescription.setText("Có "+categori.TotalCourse()+" món ăn");
//        imgCategoriBackground.setImageURI(null);
//        imgCategoriBackground.setImageURI(Uri.parse("android.resource://com.examole.android.howitcook/drawable/"+categori.get_imageSrc()));
        return  convertView;
    }
}
