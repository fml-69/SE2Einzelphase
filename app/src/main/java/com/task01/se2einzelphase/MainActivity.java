package com.task01.se2einzelphase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button sendBtn;
    private Button extraTaskBtn;
    private TextView outputText;
    private EditText inputValue;
    private Networker networker;
    private NumberWorker numberWorker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendBtn = findViewById(R.id.sendToServer);
        sendBtn.setOnClickListener(
                v -> {
                    inputValue = findViewById(R.id.inputNumber);
                    networker = new Networker(inputValue.getText().toString());
                    networker.start();
                    try{
                        networker.join();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    outputText = findViewById(R.id.outputText);
                    outputText.setText(networker.getOutputString());
                }
        );
        extraTaskBtn = findViewById(R.id.executeExtraTask);
        extraTaskBtn.setOnClickListener(
                v -> {
                    inputValue = findViewById(R.id.inputNumber);
                    numberWorker = new NumberWorker(inputValue.getText().toString());
                    numberWorker.start();
                    try{
                        numberWorker.join();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    outputText = findViewById(R.id.outputText);
                    outputText.setText(numberWorker.getOutputString());
                }
        );
    }
}