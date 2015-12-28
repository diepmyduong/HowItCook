package com.example.android.howitcook.Activities;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.howitcook.Configs.CookBookApplication;
import com.example.android.howitcook.R;
import com.example.android.howitcook.Store.DatabaseBuilder;
import com.example.android.howitcook.Store.PreferenceStore;

import org.json.JSONException;
import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Private Properties
    private EditText _editUserName;
    private Button _btnNext;
    private TextView _txtAskName;
    private TextToSpeech _textToSpeech;
    private PreferenceStore _store;
    private Intent _nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Khởi tạo
        _store = new PreferenceStore();
        _nextActivity = new Intent(MainActivity.this,WelcomeActitivy.class);
        _editUserName = (EditText) findViewById(R.id.edit_username);
        _btnNext = (Button) findViewById(R.id.btn_next);
        _btnNext.setOnClickListener(this);
        DatabaseBuilder dbBuilder = new DatabaseBuilder(getApplicationContext());
        try {
            dbBuilder.createDatabase();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //Kiểm tra đã đăng ký tên người dùng chưa
        String userName = _store.getValue(PreferenceStore.KEY.PREF_USERNAME,false);
        if(userName != null){
            //Nếu rồi thì chuyển sang trang Welcome
            startActivity(_nextActivity);
        }else{
            //Load Database

        }
    }

    @Override
    public void onClick(View v) {
        String userName = _editUserName.getText().toString();
        if(userName.isEmpty()){
            return;
        }else{
            _store.setValue(PreferenceStore.KEY.PREF_USERNAME,userName);
            startActivity(_nextActivity);
            finish();
        }
    }
}
