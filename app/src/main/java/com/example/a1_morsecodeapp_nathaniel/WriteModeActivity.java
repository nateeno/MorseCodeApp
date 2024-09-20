package com.example.a1_morsecodeapp_nathaniel;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WriteModeActivity extends AppCompatActivity {
    private TextView morseCodeView;
    private TextView translatedTextView;
    private StringBuilder currentInput = new StringBuilder();

    private Handler handler = new Handler();
    private Runnable endOfLetterRunnable = new Runnable() {
        @Override
        public void run() {
            String morseCode = currentInput.toString();
            Character character = MorseCode.getCharacter(morseCode);
            if (character != null) {
                translatedTextView.append(character.toString());
                currentInput = new StringBuilder();
            }
            morseCodeView.setText(currentInput.toString());
        }
    };

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_mode);

        morseCodeView = findViewById(R.id.morseCodeView);
        translatedTextView = findViewById(R.id.translatedTextView);
        Button morseButton = findViewById(R.id.btn_input);
        ImageButton clearButton = findViewById(R.id.btn_clear);

        morseButton.setOnTouchListener(new View.OnTouchListener() {
            private long touchDownTime = 0;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchDownTime = System.currentTimeMillis();
                        handler.removeCallbacks(endOfLetterRunnable);
                        return true;

                    case MotionEvent.ACTION_UP:
                        long touchDuration = System.currentTimeMillis() - touchDownTime;
                        String morseSymbol = MorseCode.interpretDuration(touchDuration);
                        currentInput.append(morseSymbol);
                        morseCodeView.setText(currentInput.toString());
                        handler.postDelayed(endOfLetterRunnable, MorseCode.INTER_SPACE);
                        return true;
                }
                return false;
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentInput = new StringBuilder();
                morseCodeView.setText("");
                translatedTextView.setText("");
            }
        });
    }
}