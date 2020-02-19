package com.example.tugaskalkulator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText txtusername, txtpassword;
    Button btnmasuk;
    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        pref = getSharedPreferences("login",MODE_PRIVATE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView tvForgot = findViewById(R.id.tvForgot);
        TextView tvCreate = findViewById(R.id.tvCreate);
        txtusername = findViewById(R.id.txtusername);
        txtpassword = findViewById(R.id.txtpassword);
        btnmasuk = findViewById(R.id.btnmasuk);


        String text = "Forgot your password ? help!";
        String text2 = "I don't have a account";
        SpannableString ss = new SpannableString(text);
        SpannableString ss2 = new SpannableString(text2);

        ClickableSpan cs = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(login.this, "Username:Afif,Password:Afif", Toast.LENGTH_SHORT).show();
            }
        };
        ClickableSpan cs2 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Toast.makeText(login.this, "Sudah punya", Toast.LENGTH_SHORT).show();
            }
        };
        ss.setSpan(cs, 23, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss2.setSpan(cs2, 0, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvForgot.setText(ss);
        tvCreate.setText(ss2);
        tvForgot.setMovementMethod(LinkMovementMethod.getInstance());
        tvCreate.setMovementMethod(LinkMovementMethod.getInstance());


        btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (txtusername.getText().toString().equalsIgnoreCase("afif") && txtpassword.getText().toString().equalsIgnoreCase("afif")) {
                    Toast.makeText(login.this, "login berhasil", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(login.this, MainActivity.class);
                    in.putExtra("username", txtusername.getText().toString());
                    editor = pref.edit();
                    editor.putString("username",txtusername.getText().toString());
                    editor.apply();
                    startActivity(in);
                } else {
                    Toast.makeText(login.this, "cek username/password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
