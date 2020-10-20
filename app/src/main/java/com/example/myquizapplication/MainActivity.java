package com.example.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    final int requestcode = 555;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onnext(View v)
    {
        if(R.id.button==v.getId())
        {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            startActivity(intent);
        }
    }

    }
