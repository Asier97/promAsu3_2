package com.example.promasu3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejer1(View view) {
        Intent i = new Intent(MainActivity.this,ContactosActivity.class);
        startActivity(i);
    }

    public void ejer2(View view) {
        Intent i = new Intent(MainActivity.this,BibliotecaActivity.class);
        startActivity(i);
    }
}
