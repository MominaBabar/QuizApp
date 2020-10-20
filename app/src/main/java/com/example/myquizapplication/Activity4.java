package com.example.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Activity4 extends AppCompatActivity {
    Button show;
    Button back;
    EditText box;
    String hint;
    String category;
    String qno;
    String hintshowed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
        show = findViewById(R.id.show);
        back = findViewById(R.id.back);
        box = findViewById(R.id.editText4);
        hintshowed = "false";
        Intent intent = getIntent();
        qno = intent.getStringExtra("questionno");
        category = intent.getStringExtra("category");
        hint = intent.getStringExtra("hint");

    }
    public void showhint()
    {
        box.setText(hint);
        hintshowed = "true";
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void backpress()
    {
        Intent intent = new Intent();
        intent.putExtra("hintshown",hintshowed);
        setResult(RESULT_OK);
        onBackPressed();
    }


}
