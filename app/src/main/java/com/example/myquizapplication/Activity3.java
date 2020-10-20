package com.example.myquizapplication;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    Button nextbutton;
    Button backbutton;
    Button truebutton;
    Button falsebutton;
    EditText questionbox;
    EditText scorebox;
    EditText extra;
    Button finish;
    int score;
    public ArrayList<Question> questions = new ArrayList<>();

    int index;
    String category;
    String user;
    String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent intent = getIntent();
        user = intent.getStringExtra("name");
        age = intent.getStringExtra("age");
        category = intent.getStringExtra("categoryofquiz");
        score = 0;
        nextbutton = findViewById(R.id.next);
        backbutton = findViewById(R.id.back);
        truebutton = findViewById(R.id.button1);
        falsebutton = findViewById(R.id.button2);
        questionbox = findViewById(R.id.editText);
        scorebox = findViewById(R.id.editText3);
        finish = findViewById(R.id.button6);
        finish.setVisibility(View.INVISIBLE);
        scorebox.setText(scorebox.getText()+" "+Integer.toString(score)+" /5");
        Resources res = getResources();
        String[] list;
        if(category.equals("GeneralKnowledge"))
        {
            list = res.getStringArray(R.array.GeneralKnowledge);
        }
        else if(category.equals("Music"))
        {
            list = res.getStringArray(R.array.Music);
        }
        else if(category.equals("TV dramas"))
        {
            list = res.getStringArray(R.array.TVDramas);
        }
        else if(category.equals("Maths"))
        {
            list = res.getStringArray(R.array.Maths);
        }
        else if(category.equals("Physics"))
        {
            list = res.getStringArray(R.array.Physics);
        }
        else
        {
            list = res.getStringArray(R.array.GeneralKnowledge);
        }

        for(int i = 0; i<list.length; i=i+3)
        {
            questions.add(new Question(list[i],Boolean.parseBoolean(list[i+1]),false, list[i+2]));
        }
        questionbox.setText(questions.get(0).getQuestionText());
        index = 0;

    }
    public void onTrueFalseClick(View v)
    {
        boolean correct = questions.get(index).getCorrectAnswer();
        boolean userChoice = Boolean.parseBoolean( ((Button)v).getText().toString());
        if(correct == userChoice)
        {
            score = score+questions.get(index).getScore();
            Toast.makeText(Activity3.this,"Answer is correct!",
                    Toast.LENGTH_SHORT).show();
        }
        else
        {
            score = score-questions.get(index).getScore();
            Toast.makeText(Activity3.this,"Answer is incorrect!",
                    Toast.LENGTH_SHORT).show();
        }
        questions.get(index).setAnswered(true);
        if(questions.get(index).isAnswered())
        {
            truebutton.setEnabled(false);
            falsebutton.setEnabled(false);
        }
        else
        {
            truebutton.setEnabled(true);
            falsebutton.setEnabled(true);
        }
        scorebox.setText("Score: "+Integer.toString(score)+" /5");


    }

    public void onNextClick(View v) {
        index=index+1;
        if(index>4)
        {
            index=0;
        }
        String q = questions.get(index).getQuestionText();
        questionbox.setText(q);

        if(index==4)
        {
            finish.setVisibility(View.VISIBLE);
        }
        else
        {
            finish.setVisibility(View.INVISIBLE);
        }
        if(questions.get(index).isAnswered())
        {
            truebutton.setEnabled(false);
            falsebutton.setEnabled(false);
        }
        else
        {
            truebutton.setEnabled(true);
            falsebutton.setEnabled(true);
        }
    }
    public void onBackClick(View v) {
        if(index!=0)
        {
            index=index-1;
            String q = questions.get(index).getQuestionText();
            questionbox.setText(q);
        }
        if(questions.get(index).isAnswered())
        {
            truebutton.setEnabled(false);
            falsebutton.setEnabled(false);
        }
        else
        {
            truebutton.setEnabled(true);
            falsebutton.setEnabled(true);
        }

    }
    public void onhintclick(View v)
    {
        Intent intent = new Intent(Activity3.this, Activity44.class);
        intent.putExtra("categoryofquiz",category);
        intent.putExtra("questionno",Integer.toString(index));
        intent.putExtra("answer",Boolean.toString(questions.get(index).getCorrectAnswer()));
        intent.putExtra("hint",questions.get(index).getHint());
        intent.putExtra("score", Integer.toString(score));
        startActivityForResult(intent,555);
    }
    public void onfinishclick(View v)
    {
        int count = 0;
        for(int i = 0; i<questions.size(); i++)
        {
            if(questions.get(i).isAnswered())
            {
                count++;
            }
        }
        Intent intent = new Intent(Activity3.this, Activity5.class);
        intent.putExtra("name",user);
        intent.putExtra("age", age);
        intent.putExtra("categoryofquiz",category);
        intent.putExtra("questionsanswered",Integer.toString(count));
        intent.putExtra("score", Integer.toString(score));
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode!=RESULT_OK)
        {
            return;
        }
        String hintshown = data.getStringExtra("shown");
        String i = data.getStringExtra("index");
        String sc = data.getStringExtra("scores");
        int y = Integer.parseInt(sc);
        int x = Integer.parseInt(i);
        if(hintshown.equals("true"))
        {
            y = y+questions.get(index).getDeductedscore();
            score = y;
            scorebox.setText("Score:"+" "+Integer.toString(score)+" /5");
            questions.get(x).setAnswered(true);
            truebutton.setEnabled(false);
            falsebutton.setEnabled(false);
            Toast.makeText(this, "Hint seen. No points for this question.", Toast.LENGTH_SHORT).show();
        }
    }
}
