package com.example.tugaskalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class ControlClass extends AppCompatActivity {
        private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
        if (sharedPreferences.getString("username","").isEmpty()){
            Intent in = new Intent(ControlClass.this,login.class);
            startActivity(in);
            finish();
        }else{
            Intent in = new Intent(ControlClass.this,MainActivity.class);
            startActivity(in);
            finish();
        }
    }

}
