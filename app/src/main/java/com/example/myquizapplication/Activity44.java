package com.example.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity44 extends AppCompatActivity {
    Button showbutton;
    EditText t1;
    String hint;
    String answer;
    String isshown;
    String index;
    String score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_44);
       Intent intent = getIntent();
       t1 = findViewById(R.id.editText5);
       hint = intent.getStringExtra("hint");
       answer = intent.getStringExtra("answer");
       index = intent.getStringExtra("questionno");
       score = intent.getStringExtra("score");
       isshown = "false";

    }
    public void showhint(View v)
    {
         t1.setText(answer+". "+hint);
         isshown = "true";
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onback(View v)
    {
        Intent i = new Intent();
        i.putExtra("shown", isshown);
        i.putExtra("index", index);
        i.putExtra("scores",score);
        setResult(RESULT_OK,i);
        onBackPressed();
    }
}
