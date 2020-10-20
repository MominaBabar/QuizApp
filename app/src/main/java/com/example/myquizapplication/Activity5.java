package com.example.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity5 extends AppCompatActivity {
    TextView t1;
    TextView t2;
    TextView t3;
    TextView t4;
    TextView t5;
    String name;
    String age;
    String cat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        t1 = findViewById(R.id.username);
        t2 = findViewById(R.id.age);
        t3 = findViewById(R.id.cat);
        t4 = findViewById(R.id.ques);
        t5 = findViewById(R.id.score);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        cat = intent.getStringExtra("categoryofquiz");
        String answer = intent.getStringExtra("questionsanswered");
        String score = intent.getStringExtra("score");
        t1.setText(t1.getText()+" "+name);
        t2.setText(t2.getText()+" "+age);
        t3.setText(t3.getText()+" "+cat);
        t4.setText(t4.getText()+" "+answer);
        t5.setText(t5.getText()+" "+score);
    }
    public void onclick(View v)
    {
        Intent intent = new Intent(Activity5.this, Activity2.class);
        intent.putExtra("name",name);
        intent.putExtra("age", age);
        intent.putExtra("categoryofquiz",cat);
        startActivity(intent);
    }
}
