package com.example.tugaskalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtAngka1;
    EditText txtAngka2;
    Button btnTambah;
    Button btnKurang;
    Button btnKali;
    Button btnBagi;
    TextView tvHasil;
    TextView tvLempar;
    login objek = new login();

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String username;
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            username = "Afif";

        } else {
            username = extras.getString("username");
        }
//        tvLempar.setText(username);


        txtAngka1 = findViewById(R.id.txtAngka1);
        txtAngka2 = findViewById(R.id.txtAngka2);
        btnTambah = findViewById(R.id.btnTambah);
        btnKurang = findViewById(R.id.btnKurang);
        btnKali = findViewById(R.id.btnKali);
        btnBagi = findViewById(R.id.btnBagi);
        tvHasil = findViewById(R.id.tvHasil);
        tvLempar = findViewById(R.id.tvLempar);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                try {

                    Double a = Double.valueOf(txtAngka1.getText().toString());
                    Double b = Double.valueOf(txtAngka2.getText().toString());
                    Double hasil = a + b;
                    tvHasil.setText(a + "+" + b + "=" + hasil);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Belum Diisi", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(txtAngka1.getText().toString());
                    Double b = Double.valueOf(txtAngka2.getText().toString());
                    Double hasil = a - b;
                    tvHasil.setText(a + "-" + b + "=" + hasil);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Belum diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    Double a = Double.valueOf(txtAngka1.getText().toString());
                    Double b = Double.valueOf(txtAngka2.getText().toString());
                    Double hasil = a * b;
                    tvHasil.setText(a + "x" + b + "=" + hasil);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Belum diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Double a = Double.valueOf(txtAngka1.getText().toString());
                    Double b = Double.valueOf(txtAngka2.getText().toString());
                    Double hasil = a / b;
                    tvHasil.setText(a + ":" + b + "=" + hasil);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Belum diisi", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvLempar.setText("Welcome " + username);
    }
}
