package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText UserInputText;
    private TextView tvResult;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.UserInputText = findViewById(R.id.UserInputText);
        this.tvResult = findViewById(R.id.tvResult);

        this.spinner = (Spinner) findViewById(R.id.SpinCountOption);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.selection_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(adapter);
    }

    public void ButtonCounterClick(View view) {
        String selectionWords = getResources().getString(R.string.selection_words);
        String selectionChars = getResources().getString(R.string.selection_chars);
        String userInput = this.UserInputText.getText().toString();

        if (this.spinner.getSelectedItem().toString().equalsIgnoreCase(selectionWords)) {
            int count = WordCounter.getWordsCount(userInput);
            this.tvResult.setText(String.valueOf(count));
        } else if (this.spinner.getSelectedItem().toString().equalsIgnoreCase(selectionChars)) {
            int count = WordCounter.getSymbolsCount(userInput);
            this.tvResult.setText(String.valueOf(count));
        } else {
            Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
        }

        if (userInput.matches("")) {
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }
    }


}