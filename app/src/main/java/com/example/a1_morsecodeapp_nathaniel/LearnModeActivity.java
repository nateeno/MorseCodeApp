package com.example.a1_morsecodeapp_nathaniel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.os.Handler;

import static com.example.a1_morsecodeapp_nathaniel.LevelManager.Level;
import static com.example.a1_morsecodeapp_nathaniel.LevelManager.initializeLevels;

public class LearnModeActivity extends AppCompatActivity {
    // Fields for the activity
    private List<Level> levels;
    private TextView tvLevelInfo, tvCurrentInput, tvCurrentLetter, tvTranslatedLetter, tvIntroMessage;
    private Button btnInput, btnSelectLevel;
    private Handler handler = new Handler();
    private StringBuilder currentInput = new StringBuilder();
    private Iterator<Map.Entry<String, Character>> currentLevelIterator;
    private int currentLevelIndex;
    private Map.Entry<String, Character> currentLetterEntry;
    private TextView tvUserInput;
    SharedPreferences sharedPrefs;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();  // Load and apply the saved language
        setContentView(R.layout.activity_learn_mode);
        setContentView(R.layout.activity_learn_mode);

        tvLevelInfo = findViewById(R.id.tv_level_info);
        tvCurrentInput = findViewById(R.id.tv_current_input);
        tvCurrentLetter = findViewById(R.id.tv_current_letter);
        btnInput = findViewById(R.id.btn_input);
        tvTranslatedLetter = findViewById(R.id.tv_translated_letter);
        tvIntroMessage = findViewById(R.id.tv_intro_message);
        tvUserInput = findViewById(R.id.tv_user_input);
        sharedPrefs = getSharedPreferences("LevelData", MODE_PRIVATE);

        // Home button code
        ImageButton homeButton = findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LearnModeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnInput.setOnTouchListener(new View.OnTouchListener() {
            private long touchDownTime = 0;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        touchDownTime = System.currentTimeMillis();
                        handler.removeCallbacks(endOfLetterRunnable);
                        return true;

                    case MotionEvent.ACTION_UP:
                        long touchDuration = System.currentTimeMillis() - touchDownTime;
                        String morseSymbol = MorseCode.interpretDuration(touchDuration);
                        currentInput.append(morseSymbol);
                        tvCurrentInput.setText(currentInput.toString());

                        // Translate Morse code to text
                        String translatedText = "";
                        for (Level level : levels) {
                            Character character = level.getMorseCodeMap().get(currentInput.toString());
                            if (character != null) {
                                translatedText = character.toString();
                                break;
                            }
                        }

                        // Update tvUserInput
                        tvUserInput.setText(translatedText);

                        handler.postDelayed(endOfLetterRunnable, MorseCode.INTER_SPACE);
                        return true;
                }
                return false;
            }
        });

        levels = initializeLevels();
        startLevel(0);

        btnSelectLevel = findViewById(R.id.btn_select_level);
        btnSelectLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLevelSelectionDialog();
            }
        });
    }

    private int getHighestLevelUnlocked() {
        return sharedPrefs.getInt("HighestLevelUnlocked", 0);
    }

    private void updateHighestLevelUnlocked() {
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putInt("HighestLevelUnlocked", currentLevelIndex);
        editor.apply();
    }

    private void startLevel(int levelIndex) {
        currentLevelIndex = levelIndex;
        tvUserInput.setText("");

        if (levelIndex < levels.size()) {
            Level level = levels.get(levelIndex);

            // Declare levelInfo here
            String levelInfo;

            if (level.isHardLevel()) {
                // For hard levels, show "Write: " + letter but not the Morse code
                levelInfo = "Write: " + getLetters(level.getMorseCodeMap());
            } else {
                // For non-hard levels, show the complete info including Morse code
                levelInfo = getString(R.string.level_info, level.getLevelNumber(), getMorseCodeEntries(level.getMorseCodeMap()));
            }
            tvLevelInfo.setText(levelInfo);

            currentLevelIterator = level.getMorseCodeMap().entrySet().iterator();

            String introMessage = LevelManager.getIntroMessage(levelIndex, this);
            tvIntroMessage.setText(introMessage);

            if (currentLevelIterator.hasNext()) {
                currentLetterEntry = currentLevelIterator.next();
                startLearningLetter(currentLetterEntry);
            }
        } else {
            // All levels completed
            tvLevelInfo.setText(R.string.all_levels_completed);
        }
    }

    private String getLetters(Map<String, Character> map) {
        StringBuilder letters = new StringBuilder();
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            letters.append(entry.getValue()).append(" ");
        }
        return letters.toString().trim();
    }

    private void showLevelSelectionDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        ListView listView = new ListView(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, getLevelsArray());
        listView.setAdapter(adapter);
        dialogBuilder.setView(listView);
        final AlertDialog dialog = dialogBuilder.create();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position <= getHighestLevelUnlocked()) {
                    startLevel(position);
                    dialog.dismiss();
                } else {
                    Toast.makeText(LearnModeActivity.this, "This level is locked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        dialog.show();
    }

    private String[] getLevelsArray() {
        int highestLevelUnlocked = getHighestLevelUnlocked();
        String[] levelsArray = new String[levels.size()];
        for (int i = 0; i < levels.size(); i++) {
            if (i <= highestLevelUnlocked) {
                levelsArray[i] = "Level " + (i + 1);
            } else {
                levelsArray[i] = "Level " + (i + 1) + " (Locked)";
            }
        }
        return levelsArray;
    }

    private String getMorseCodeEntries(Map<String, Character> map) {
        StringBuilder entries = new StringBuilder();
        for (Map.Entry<String, Character> entry : map.entrySet()) {
            entries.append(entry.getValue()).append(" ").append(entry.getKey());
        }
        return entries.toString();
    }

    private void startLearningLetter(Map.Entry<String, Character> letterEntry) {
    }

    private Runnable endOfLetterRunnable = new Runnable() {
        @Override
        public void run() {
            String morseCode = currentInput.toString();

            if (currentLetterEntry != null && morseCode.equals(currentLetterEntry.getKey())) {
                // Correct input
                tvTranslatedLetter.setText(currentLetterEntry.getValue().toString()); // Show the translated letter
                currentInput = new StringBuilder();
                tvCurrentInput.setText("");
                tvTranslatedLetter.setText("");
                if (currentLevelIterator.hasNext()) {
                    currentLetterEntry = currentLevelIterator.next();
                    startLearningLetter(currentLetterEntry);
                } else {
                    updateHighestLevelUnlocked();
                    startLevel(currentLevelIndex + 1);
                }
            } else {
                // If the input was incorrect
                currentInput = new StringBuilder();
                tvCurrentInput.setText("");
                tvTranslatedLetter.setText("");
                startLearningLetter(currentLetterEntry);
            }
        }
    };

    // LANG
    private void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "en");

        Locale locale = new Locale(language);
        Locale.setDefault(locale);

        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration config = res.getConfiguration();
        config.setLocale(locale);
        res.updateConfiguration(config, dm);
    }
}