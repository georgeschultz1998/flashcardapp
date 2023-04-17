package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewFlashCardsActivity extends AppCompatActivity {

    private TextView questionAnswerTextView;
    private Button prevButton;
    private Button nextButton;
    private TextView cardNumberTextView;

    private int currentCardIndex = 0;

    private String[] questionArray = {
            "What is React Native?",
            "What are the benefits of using React Native?",
            "What are some popular apps built with React Native?",
            "How does React Native differ from React?",
            "What are some limitations of React Native?"
    };

    private String[] answerArray = {
            "React Native is a JavaScript framework for building mobile apps that allows developers to use React to create a rich mobile UI from declarative components.",
            "Some benefits of using React Native include faster development times, reduced costs, the ability to share code between platforms, and a smoother user experience.",
            "Some popular apps built with React Native include Facebook, Instagram, Airbnb, Uber Eats, and Walmart.",
            "React is a JavaScript library for building web applications, while React Native is a framework for building native mobile apps. React Native uses native components and APIs, while React renders components to a web page.",
            "Some limitations of React Native include limited access to native device APIs, less flexibility in UI design, and potential performance issues with complex apps."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flash_cards);

        questionAnswerTextView = findViewById(R.id.questionAnswerTextView);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        cardNumberTextView = findViewById(R.id.cardNumberTextView);

        showQuestion();

        questionAnswerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questionAnswerTextView.getText().toString().equals(questionArray[currentCardIndex])) {
                    showAnswer();
                } else {
                    showQuestion();
                }
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentCardIndex == 0) {
                    currentCardIndex = questionArray.length - 1;
                } else {
                    currentCardIndex--;
                }
                showQuestion();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentCardIndex == questionArray.length - 1) {
                    currentCardIndex = 0;
                } else {
                    currentCardIndex++;
                }
                showQuestion();
            }
        });
    }

    private void showQuestion() {
        questionAnswerTextView.setText(questionArray[currentCardIndex]);
        cardNumberTextView.setText("Card " + (currentCardIndex + 1) + " of " + questionArray.length);
    }

    private void showAnswer() {
        questionAnswerTextView.setText(answerArray[currentCardIndex]);
        cardNumberTextView.setText("Card " + (currentCardIndex + 1) + " of " + questionArray.length);
    }
}
