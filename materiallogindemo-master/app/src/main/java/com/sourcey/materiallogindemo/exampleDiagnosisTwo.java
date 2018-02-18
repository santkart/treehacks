package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class exampleDiagnosisTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_diagnosis_two);

        Button buttonChoiceN = (Button)findViewById(R.id.diagnosis2Next);
        buttonChoiceN.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view) {

               startActivity(new Intent(exampleDiagnosisTwo.this, exampleDiagnosisTwoNext.class));
            }

        });
    }
}
