package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitialQuestion extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial_question);
        Button aButtonChoice = (Button)findViewById(R.id.greatButton);
        aButtonChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InitialQuestion.this, FeelingGreat.class));

            }

        });
        Button bButtonChoice = (Button)findViewById(R.id.suckyButton);
        bButtonChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(InitialQuestion.this, QuizActivity.class));

            }

        });
    }
}