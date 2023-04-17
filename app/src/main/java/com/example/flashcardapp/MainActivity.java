package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button newFlashCardButton;
    private Button viewFlashCardsButton;
    private Button settingsButton;

    private String[] questionArray = {"Question 1", "Question 2", "Question 3", "Question 4", "Question 5"};
    private String[] answerArray = {"Answer 1", "Answer 2", "Answer 3", "Answer 4", "Answer 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the UI components
        newFlashCardButton = findViewById(R.id.newFlashCardButton);
        viewFlashCardsButton = findViewById(R.id.viewFlashCardsButton);
        settingsButton = findViewById(R.id.settingsButton);

        // Set onClick listeners for the buttons
        newFlashCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewFlashCardActivity.class);
                intent.putExtra("questionArray", questionArray);
                intent.putExtra("answerArray", answerArray);
                startActivityForResult(intent, 1);
            }
        });

        viewFlashCardsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewFlashCardsActivity.class);
                intent.putExtra("questionArray", questionArray);
                intent.putExtra("answerArray", answerArray);
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> updatedQuestionList = data.getStringArrayListExtra("updatedQuestionList");
                ArrayList<String> updatedAnswerList = data.getStringArrayListExtra("updatedAnswerList");
                if (updatedQuestionList != null && updatedAnswerList != null) {
                    Log.d("MainActivity", "Updated question list size: " + updatedQuestionList.size());
                    Log.d("MainActivity", "Updated answer list size: " + updatedAnswerList.size());
                    questionArray = updatedQuestionList.toArray(new String[updatedQuestionList.size()]);
                    answerArray = updatedAnswerList.toArray(new String[updatedAnswerList.size()]);
                } else {
                    Log.e("MainActivity", "Updated question or answer list is null");
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
