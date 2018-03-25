package com.raghavi.math_quiz;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

public class Game_Screen extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> questions;
    ArrayList<String> ans1;
    ArrayList<String> ans2;
    ArrayList<String> ans3;
    ArrayList<String> answers;

    int count = 0, i = 0, TimeCounter=60 , result = 0, num1, num2;

    Button next1;
    Button button1;
    Button button2;
    Button button3;
    TextView textView;
    TextView time;
    final Timer t = new Timer();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

outState.putInt("Time_Counter",TimeCounter);
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        TimeCounter=savedInstanceState.getInt("Time_Counter");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game__screen);

        ans1 = new ArrayList<String>();
        ans2 = new ArrayList<String>();
        ans3 = new ArrayList<String>();
        answers = new ArrayList<String>();
        questions = new ArrayList<String>();
        button1 = (Button) findViewById(R.id.opt1);
        button1.setOnClickListener(this);

        button2 = (Button) findViewById(R.id.opt2);
        button2.setOnClickListener(this);

        button3 = (Button) findViewById(R.id.opt3);
        button3.setOnClickListener(this);

        next1 = (Button) findViewById(R.id.next);
        textView = (TextView) findViewById(R.id.ques);
        time = (TextView) findViewById(R.id.timer);


       /* questions.add("2+2=?");
        ans1.add("4");
        ans2.add("5");
        ans3.add("1");
        answers.add("4");
*/
        num1 = (int) (Math.random() * 11) + 1;
        num2 = (int) (Math.random() * 11) + 1;
        questions.add(num1 + "+" + num2 + "=?");
        ans1.add(String.valueOf((int) (Math.random() * 11) + 1));
        ans2.add(String.valueOf(num1 + num2));
        ans3.add(String.valueOf((int) (Math.random() * 11) + 1));
        answers.add(String.valueOf(num1 + num2));

        String ques = questions.get(0).toString();
        String a1 = ans1.get(0).toString();
        String a2 = ans2.get(0).toString();
        String a3 = ans3.get(0).toString();
        textView.setText(ques);
        button1.setText(a1);
        button2.setText(a2);
        button3.setText(a3);


        /*if(savedInstanceState !=null)
        {
            TimeCounter = savedInstanceState.getInt("Time_Counter",60);
        }
  else
        {
            TimeCounter=60;
        }*/

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              //  button1.setBackgroundColor(Color.DKGRAY);
                //button2.setBackgroundColor(Color.DKGRAY);
                //button3.setBackgroundColor(Color.DKGRAY);

                ++count;

                //What is this statement?
                //count = count % (questions.size());

                if (TimeCounter > 0) {

                    //addition
                    num1 = (int) (Math.random() * 11) + 1;
                    num2 = (int) (Math.random() * 11) + 1;
                    questions.add(num1 + "+" + num2 + "=?");
                    ans1.add(String.valueOf((int) (Math.random() * 11) + 1));
                    ans2.add(String.valueOf(num1 + num2));
                    ans3.add(String.valueOf((int) (Math.random() * 11) + 1));
                    answers.add(String.valueOf(num1 + num2));

//subtraction
                    num1 = (int) (Math.random() * 11) + 1;
                    num2 = (int) (Math.random() * 11) + 1;
                    if (num1 > num2) {
                        questions.add(num1 + "-" + num2 + "=?");
                    } else {
                        questions.add(num2 + "-" + num1 + "=?");
                    }
                    ans1.add(String.valueOf(Math.abs(num1 - num2)));
                    ans2.add(String.valueOf((int) (Math.random() * 11) + 1));
                    ans3.add(String.valueOf((int) (Math.random() * 11) + 1));
                    answers.add(String.valueOf(Math.abs(num1 - num2)));

                    //multiplication
                    num1 = (int) (Math.random() * 11) + 1;
                    num2 = (int) (Math.random() * 11) + 1;
                    questions.add(num1 + "*" + num2 + "=?");
                    ans1.add(String.valueOf((int) (Math.random() * 11) + 1));
                    ans2.add(String.valueOf(num1 * num2));
                    ans3.add(String.valueOf((int) (Math.random() * 11) + 1));
                    answers.add(String.valueOf(num1 * num2));


                    //division
                    num1 = (int) (Math.random() * 11) + 1;
                    num2 = (int) (Math.random() * 11) + 1;
                    if (num1 % num2 != 0) {
                        num1 = num1 - num1 % num2;
                    }
                    questions.add(num1 + "/" + num2 + "=?");
                    ans1.add(String.valueOf((int) (Math.random() * 11) + 1));
                    ans2.add(String.valueOf((int) (Math.random() * 11) + 1));
                    ans3.add(String.valueOf(num1 / num2));
                    answers.add(String.valueOf(num1 / num2));

                    //You had count + 1 (Not necessary when you've already incremented)
                    textView.setText((String) questions.get(count));
                    button1.setText((String) ans1.get(count));
                    button2.setText((String) ans2.get(count));
                    button3.setText((String) ans3.get(count));

//addition

                } else {
                    //startActivity(new Intent(Game_Screen.this, Result.class));
                    Intent i = new Intent(view.getContext(), Result.class);
                    i.putExtra("Result", String.valueOf(result));
                    startActivity(i);
                }

            }

        });




/*
       final Enumeration<String> e= Collections.enumeration(questions);
        final Enumeration<String> a1= Collections.enumeration(ans1);
        final Enumeration<String> a2= Collections.enumeration(ans2);
        final Enumeration<String> a3= Collections.enumeration(ans3);
        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
if(e.hasMoreElements())
{
    textView.setText(e.nextElement());
    button1.setText(a1.nextElement());
    button2.setText(a2.nextElement());
    button3.setText(a3.nextElement());
}
            }

        });
*/

//timer
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (TimeCounter == i) {
                            t.cancel();

                        }
                        time.setText(String.valueOf(TimeCounter) + " seconds remaining");
                        TimeCounter--;
                    }
                });
            }
        }, 0, 1000);

//activity change
        Handler handler = new Handler();
        final Runnable r = new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(Game_Screen.this, Result.class);
                i.putExtra("Result", String.valueOf(result));
                startActivity(i);
            }
        };
        handler.postDelayed(r, 60000);

    }


    @Override
    public void onBackPressed() {

        Intent i = new Intent(this, Result.class);
        i.putExtra("Result", String.valueOf(result));
        startActivity(i);
        //startActivity(new Intent(Game_Screen.this, Result.class));

    }

    /*public void result_calc(View v) {
        if (v.getId() == R.id.opt1) {
            if (button1.getText().toString().matches(answers.get(count).toString())) {
                result++;
                Toast.makeText(getApplicationContext(), result + "good", Toast.LENGTH_SHORT).show();
                // button1.setText("Correct");
            }
        } else if (v.getId() == R.id.opt2) {
            if (button2.getText().toString().matches(answers.get(count).toString())) {
                result++;
                Toast.makeText(getApplicationContext(), result + "good", Toast.LENGTH_SHORT).show();
                // button1.setText("Correct");
            }
        } else if (button3.getText().toString().matches(answers.get(count).toString())) {
            result++;
            Toast.makeText(getApplicationContext(), result + "good", Toast.LENGTH_SHORT).show();
            // button1.setText("Correct");
        }
count++;
    }*/
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.opt1:
                if (button1.getText().equals(answers.get(count))) {
                    result++;
                   /*Toast toast= Toast.makeText(getApplicationContext(), "Awesome!", Toast.LENGTH_SHORT);
                    View view=toast.getView();

                    view.setBackgroundColor(Color.RED);
                    TextView text=(TextView) view.findViewById(R.id.message);
                    text.setShadowLayer(0,0,0,Color.TRANSPARENT);
                    text.setTextColor(Color.BLACK);
                    toast.show();
                    button1.setText("Correct");
                    button1.setBackgroundColor(Color.GREEN);
*/
                   button1.setText("Correct");
                    Toast.makeText(getApplicationContext(), "Awesome!", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.opt2:
                if (button2.getText().equals(answers.get(count))) {
                    result++;
                    button2.setText("Correct");
                    Toast.makeText(getApplicationContext(), "Awesome!", Toast.LENGTH_SHORT).show();

                    //button2.setBackgroundColor(Color.GREEN);
                }
                break;
            case R.id.opt3:
                if (button3.getText().equals(answers.get(count))) {
                    result++;
                    Toast.makeText(getApplicationContext(), "Awesome!", Toast.LENGTH_SHORT).show();
                    button3.setText("Correct");
                    //button3.setBackgroundColor(Color.GREEN);
                }
                break;
        }

    }

}
