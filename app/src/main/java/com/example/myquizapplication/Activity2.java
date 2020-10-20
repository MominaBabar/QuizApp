package com.example.myquizapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {
    Button start;
    EditText name;
    EditText age;
    Spinner categories;
    String category;
    String nameofuser;
    String agevalue;
    boolean valid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        start = findViewById(R.id.button2);
        name = findViewById(R.id.editText);
        age = findViewById(R.id.editText2);
        categories = findViewById(R.id.spinner);
        Intent intent = getIntent();
        if(intent!=null)
        {
            name.setText(intent.getStringExtra("name"));
            age.setText(intent.getStringExtra("age"));
            String c = intent.getStringExtra("categoryofquiz");
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            categories.setAdapter(adapter);
            int spinnerPosition = adapter.getPosition(c);
            categories.setSelection(spinnerPosition);
        }



    }
    public void onstartquiz(View v)
    {
        if(TextUtils.isEmpty(name.getText()) || TextUtils.isEmpty(age.getText()))
        {
            Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent intent = new Intent(Activity2.this, Activity3.class);
            nameofuser = name.getText().toString();
            agevalue = age.getText().toString();
            category = categories.getSelectedItem().toString();
            intent.putExtra("name",nameofuser);
            intent.putExtra("age", agevalue);
            intent.putExtra("categoryofquiz",category);
            startActivity(intent);
        }



    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void goback(View v)
    {
        onBackPressed();
    }


}
