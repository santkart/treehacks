package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exampleDiagnosisOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_diagnosis_one);

        Button buttonChoice = (Button)findViewById(R.id.diagnosis1Next);
        buttonChoice.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //My logic for Button goes in here
                startActivity(new Intent(exampleDiagnosisOne.this, exampleDiagnosisOneNext.class));
            }
        });
    }
}
