package com.raghavi.math_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Result extends AppCompatActivity {
    ImageButton restart;
    String result1;
    TextView disp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        disp = findViewById(R.id.display);
        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            result1 = null;
        } else {
            result1 = bundle.getString("Result");
        }
        disp.setText(result1);
        restart = findViewById(R.id.res);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Result.this, Game_Screen.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
        startActivity(new Intent(Result.this, MainActivity.class));

    }
}
