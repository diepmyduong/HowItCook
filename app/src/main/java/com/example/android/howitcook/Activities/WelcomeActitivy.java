package com.example.android.howitcook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.howitcook.Adapter.CategoryAdapter;
import com.example.android.howitcook.Constant;
import com.example.android.howitcook.DAL.CategoryDAL;
import com.example.android.howitcook.DAL.CourseDAL;
import com.example.android.howitcook.Model.Category;
import com.example.android.howitcook.Model.Course;
import com.example.android.howitcook.R;
import com.example.android.howitcook.Store.PreferenceStore;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActitivy extends AppCompatActivity {

    private TextView _txtWelcome;
    private ListView _listCategory;
    private Button _btnSuggest;
    private Button _btnFind;
    private PreferenceStore _store;
    private List<Category> _categories;
    private CategoryAdapter _categoryAdapter;
    private CategoryDAL _db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_actitivy);
        //Set Element
        _txtWelcome = (TextView) findViewById(R.id.txt_welcome);
        _listCategory = (ListView) findViewById(R.id.list_category);
        _btnFind = (Button) findViewById(R.id.btn_find);
        _btnSuggest = (Button) findViewById(R.id.btn_suggest);
        //Get Username
        _store = new PreferenceStore();
        String userName = _store.getValue(PreferenceStore.KEY.PREF_USERNAME,false);
        _txtWelcome.setText("Xin chào " + userName);
        //Set listener
        _btnFind.setOnClickListener(btnFindOnClickListener());
        _btnSuggest.setOnClickListener(btnSuggestOnClickListener());
        _listCategory.setOnItemClickListener(listCategoryItemOnClickListener());
        //Load Category
        _db = new CategoryDAL();
        _categories = new ArrayList<Category>();
        loadCategory();

    }

    private void loadCategory(){
        _categories = _db.getAllList();
        _categoryAdapter = new CategoryAdapter(getApplicationContext(),_categories);
        _listCategory.setAdapter(_categoryAdapter);
    }

    //Listener
    //Button Find On Click
    private View.OnClickListener btnFindOnClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeActitivy.this,SearchActivity.class);
                startActivity(i);
            }
        };
    }
    //Button Suggest On Click
    private View.OnClickListener btnSuggestOnClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                CourseDAL db = new CourseDAL();
                Course course = db.getRandom();
                Intent i = new Intent(WelcomeActitivy.this,CourseDetailActivity.class);
                i.putExtra(Constant.CURRENT_COURSE,course);
                startActivity(i);
            }
        };
    }
    //Category item On Click
    private AdapterView.OnItemClickListener listCategoryItemOnClickListener(){
        return new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Category category = _categories.get(position);
                Intent i = new Intent(WelcomeActitivy.this,CategoryActivity.class);
                i.putExtra(Constant.CURRENT_CATEGORY,category);
                startActivity(i);
            }
        };
    }

}
