package com.example.a1_morsecodeapp_nathaniel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    private Spinner languageSpinner;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        languageSpinner = findViewById(R.id.language_spinner);
        saveButton = findViewById(R.id.btn_save);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.language_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(adapter);

        // Load saved language from SharedPreferences
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        if (language.equals("en")) {
            languageSpinner.setSelection(0);
        } else if (language.equals("no")) {
            languageSpinner.setSelection(1);
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad;
                switch (languageSpinner.getSelectedItemPosition()) {
                    case 0:
                        languageToLoad = "en";
                        break;
                    case 1:
                        languageToLoad = "no";
                        break;
                    default:
                        languageToLoad = "en";
                        break;
                }

                // Save language to SharedPreferences
                SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
                editor.putString("My_Lang", languageToLoad);
                editor.apply();

                // Switch back to MainActivity
                Intent intent = new Intent(SettingsActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);


            }
        });
    }
}