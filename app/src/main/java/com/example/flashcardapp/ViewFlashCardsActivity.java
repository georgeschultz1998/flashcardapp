package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewFlashCardsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flash_cards);

        // Retrieve the data from the NewFlashCardActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String question = extras.getString("question");
            String answer = extras.getString("answer");

            // Display the data in the UI
            TextView questionTextView = findViewById(R.id.questionTextView);
            TextView answerTextView = findViewById(R.id.answerTextView);

            questionTextView.setText(question);
            answerTextView.setText(answer);
        }
    }
}
