package com.example.ititask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText phoneEDT;
    EditText messageEDT;
    Button nextBTN;
    Button closeBTN;
    static final String PHONE = "PhoneNumber";
    static final String MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phoneEDT = findViewById(R.id.phoneNumEDT);
        messageEDT = findViewById(R.id.messageEDT);
        nextBTN = findViewById(R.id.nxtBTN);
        closeBTN = findViewById(R.id.clseBTN);
        nextBTN.setOnClickListener(view -> intentToShowDetails());
        closeBTN.setOnClickListener(view -> finish());
    }

    private void intentToShowDetails() {
        Intent intent = new Intent(MainActivity.this, ShowDetailsActivity.class);
        intent.putExtra(PHONE, phoneEDT.getText().toString());
        intent.putExtra(MESSAGE, messageEDT.getText().toString());
        startActivity(intent);
    }
}