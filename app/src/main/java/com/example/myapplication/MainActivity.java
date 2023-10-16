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
        String selectionChars = getResources().getString(R.string.selection_chars);
        String userInput2 = this.UserInputText.getText().toString();
        if(this.spinner.getSelectedItem().toString().equalsIgnoreCase(selectionChars)) {
            String userInput = this.UserInputText.getText().toString();
            Log.i("UserText", userInput);

            int count = WordCounter.getCharsCount(userInput);
            Log.i("UserTextCount", String.valueOf(count));

            this.tvResult.setText(String.valueOf(count));
        }
        if(userInput2.matches("")){
            Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Not Implemented", Toast.LENGTH_SHORT).show();
        }
    }
}