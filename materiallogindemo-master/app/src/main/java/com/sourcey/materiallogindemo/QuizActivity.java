package com.sourcey.materiallogindemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;
import com.mongodb.client.model.Sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.bson.Document;


public class QuizActivity extends AppCompatActivity {

    MongoClientURI uri = new MongoClientURI("mongodb://root:treehacks-health123@ds239638.mlab.com:39638");
    MongoClient mongoClient = new MongoClient(uri);
    MongoDatabase database = mongoClient.getDatabase("medical");
    MongoCollection<Document> symptoms = database.getCollection("symptoms");
    MongoCollection<Document> userLog = database.getCollection("user-log");


    private quizLib mQuestionLibrary = new quizLib();
    private int numQuestions = mQuestionLibrary.getSize();
    private static int[][] quizData = new int [15][4];
    private static int[][] loggedData = new int [8][5];
    private final String[] diseases = {"Depression", "Anxiety", "Bipolar", "ADHD", "ADD",
            "Hyperactivity", "Parkinson\'s", "Alzheimer\'s"};
    private Map<String, Integer> diseaseMap = new HashMap<>();


    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private int mQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);

        mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
        mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
        mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
        mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));

//        mQuestionNumber++;
//        for(int i = 0; i < 15; i++) {

//            final int i2 = i;
//            System.out.println("Test: " + i2);
//            printQuizData();

            //Start of Button Listener for Button1
            mButtonChoice1.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //My logic for Button goes in here
//                    quizData[i2][0]++;
                    updateQuestion(0);
                }
            });

            //End of Button Listener for Button1

            //Start of Button Listener for Button2
            mButtonChoice2.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //My logic for Button goes in here
//                    quizData[i2][1]++;
                    updateQuestion(1);
                }
            });

            //End of Button Listener for Button2

            //Start of Button Listener for Button3
            mButtonChoice3.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    //My logic for Button goes in here
//                    quizData[i2][2]++;
                    updateQuestion(2);
                }
            });
            //End of Button Listener for Button3


            mButtonChoice4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    quizData[i2][3]++;
                    updateQuestion(3);
                }

            });
    }

    private void updateQuestion(int idx){
        if (mQuestionNumber < 15) {
            quizData[mQuestionNumber][idx]++;

            if (mQuestionNumber == 0) {
                if (idx == 0) {
                    loggedData[0][4]++;
                    loggedData[1][1]++;
                    loggedData[2][1]++;
                    loggedData[5][3]++;
                } else if (idx == 1) {
                    loggedData[0][4]++;
                    loggedData[1][1]++;
                    loggedData[2][1]++;
                    loggedData[4][3]++;
                    loggedData[5][2]++;
                    loggedData[5][3]++;
                }
            } else if (mQuestionNumber == 1) {
                if (idx == 0) {
                    loggedData[6][4]++;
                    loggedData[7][2]++;
                } else if (idx == 1) {
                    loggedData[6][4]++;
                    loggedData[7][2]++;
                }
            } else if (mQuestionNumber == 2) {
                if (idx == 0) {
                    loggedData[6][4]++;
                    loggedData[7][2]++;
                } else if (idx == 2) {
                    loggedData[6][4]++;
                    loggedData[7][1]++;
                }
            } else if (mQuestionNumber == 3) {
                if (idx == 0) {
                    loggedData[6][4]++;
                    loggedData[6][1]++;
                } else if (idx == 2) {
                    loggedData[5][3]++;
                    loggedData[6][1]++;
                    loggedData[7][2]++;
                }
            } else if (mQuestionNumber == 4) {
                if (idx == 0) {
                    loggedData[3][4]++;
                    loggedData[6][1]++;
                    loggedData[5][4]++;
                    loggedData[7][2]++;
                } else if (idx == 1) {
                    loggedData[2][0]++;
                    loggedData[4][2]++;
                    loggedData[4][2]++;
                } else if (idx == 2) {
                    loggedData[6][3]++;
                    loggedData[5][2]++;
                }
            } else if (mQuestionNumber == 5) {
                if (idx == 1) {
                    loggedData[3][1]++;
                } else if (idx == 2) {
                    loggedData[0][2]++;
                    loggedData[1][2]++;
                    loggedData[3][2]++;
                    loggedData[5][2]++;
                } else if (idx == 3) {
                    loggedData[0][3]++;
                    loggedData[0][4]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;

                }
            } else if (mQuestionNumber == 6) {
                if (idx == 0) {
                    loggedData[0][4]++;
                    loggedData[3][4]++;
                } else if (idx == 1) {
                    loggedData[0][4]++;
                    loggedData[3][2]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                } else if (idx == 3) {
                    loggedData[0][3]++;
                }
            } else if (mQuestionNumber == 7) {
                if (idx == 0) {
                    loggedData[6][0]++;
                    loggedData[0][4]++;
                    loggedData[7][2]++;
                } else if (idx == 1) {
                    loggedData[6][0]++;
                    loggedData[0][3]++;
                    loggedData[6][3]++;
                    loggedData[7][2]++;
                }
            } else if (mQuestionNumber == 8) {
                if (idx == 1) {
                    loggedData[0][1]++;
                    loggedData[0][2]++;
                    loggedData[7][4]++;
                } else if (idx == 2) {
                    loggedData[0][2]++;
                    loggedData[0][3]++;
                    loggedData[7][4]++;
                } else if (idx == 3) {
                    loggedData[0][3]++;
                    loggedData[0][4]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                    loggedData[7][4]++;
                }
            } else if (mQuestionNumber == 9) {
                if (idx == 1) {
                    loggedData[7][3]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                } else if (idx == 2) {
                    loggedData[3][2]++;
                    loggedData[4][2]++;
                    loggedData[5][4]++;
                } else if (idx == 3) {
                    loggedData[2][3]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[4][3]++;
                    loggedData[5][3]++;
                    loggedData[7][1]++;
                }
            } else if (mQuestionNumber == 10) {
                if (idx == 1) {
                    loggedData[0][0]++;
                    loggedData[0][1]++;
                    loggedData[0][2]++;
                    loggedData[3][2]++;
                    loggedData[4][3]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                    loggedData[6][4]++;
                } else if (idx == 3) {
                    loggedData[2][0]++;
                }
            } else if (mQuestionNumber == 11) {
                if (idx == 1) {
                    loggedData[0][2]++;
                    loggedData[7][2]++;
                } else if (idx == 2) {
                    loggedData[0][1]++;
                    loggedData[3][1]++;
                    loggedData[3][2]++;
                    loggedData[4][3]++;
                    loggedData[5][3]++;
                } else if (idx == 3) {
                    loggedData[0][0]++;
                    loggedData[2][2]++;
                    loggedData[2][3]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[7][1]++;
                    loggedData[5][2]++;
                }
            } else if (mQuestionNumber == 12) {
                if (idx == 1) {
                    loggedData[0][1]++;
                    loggedData[2][2]++;
                    loggedData[3][2]++;
                    loggedData[4][2]++;
                    loggedData[4][3]++;
                    loggedData[5][2]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                } else if (idx == 3) {
                    loggedData[7][0]++;
                }
            } else if (mQuestionNumber == 13) {
                if (idx == 0) {
                    loggedData[1][3]++;
                    loggedData[3][3]++;
                    loggedData[5][4]++;
                } else if (idx == 1) {
                    loggedData[0][0]++;
                    loggedData[2][1]++;
                    loggedData[3][2]++;
                    loggedData[3][3]++;
                    loggedData[6][2]++;
                    loggedData[7][4]++;
                } else if (idx == 2) {
                    loggedData[1][4]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                }
            } else if (mQuestionNumber == 14) {
                if (idx == 1) {
                    loggedData[0][0]++;
                    loggedData[0][1]++;
                    loggedData[0][2]++;
                    loggedData[0][3]++;
                    loggedData[0][4]++;
                    loggedData[2][1]++;
                    loggedData[2][4]++;
                    loggedData[6][2]++;
                } else if (idx == 2) {
                    loggedData[0][0]++;
                    loggedData[0][1]++;
                    loggedData[1][0]++;
                    loggedData[1][2]++;
                    loggedData[3][2]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[4][3]++;
                    loggedData[5][2]++;
                    loggedData[5][3]++;
                    loggedData[5][4]++;
                } else if (idx == 3) {
                    loggedData[0][0]++;
                    loggedData[2][0]++;
                    loggedData[2][4]++;
                    loggedData[3][3]++;
                    loggedData[3][4]++;
                    loggedData[5][4]++;
                }

                printQuizData(loggedData);
                String redirectPage = buildDiseaseMap(loggedData);
                if (redirectPage.equals("ADHD")) {
                    startActivity(new Intent(QuizActivity.this, exampleDiagnosisOne.class));
                } else if (redirectPage.equals("Parkinson\'s")) {
                    startActivity(new Intent(QuizActivity.this, exampleDiagnosisTwo.class));
                } else {
                    startActivity(new Intent(QuizActivity.this, inconclusive.class));
                }
            }

            mQuestionNumber++;
        }
        if (mQuestionNumber != 15) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
        }

    }

    private String buildDiseaseMap(int[][] loggedData) {

        for(int i = 0; i < loggedData.length; ++i) {

            String disease = diseases[i];
            int count = 0;
            for(int j = 0; j < loggedData[0].length; ++j) {

                count += loggedData[i][j];

            }

            diseaseMap.put(disease, count);
        }

        List<Map.Entry<String, Integer>> diseaseList = entriesSortedByValues((HashMap<String, Integer>) diseaseMap);

        String redirectPage = null;
        for (Map.Entry<String, Integer> entry : diseaseList) {

            if (redirectPage == null) {
                redirectPage = entry.getKey();
            }

            System.out.println(entry.getKey() + ":" + entry.getValue().toString());
        }

        return redirectPage;
    }

    private void printQuizData(int[][] quizData) {

        for(int i = 0; i < quizData.length; ++i) {
            for(int j = 0; j < quizData[0].length; ++j) {
                System.out.print(quizData[i][j] + "\t");
            }
            System.out.println();
        }

    }

    static <K,V extends Comparable<? super V>>
    List<Map.Entry<K, V>> entriesSortedByValues(Map<K,V> map) {

        List<Map.Entry<K,V>> sortedEntries = new ArrayList<Map.Entry<K,V>>(map.entrySet());

        Collections.sort(sortedEntries,
                new Comparator<Map.Entry<K,V>>() {
                    @Override
                    public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                        return e2.getValue().compareTo(e1.getValue());
                    }
                }
        );

        return sortedEntries;
    }

}
