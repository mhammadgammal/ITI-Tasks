package com.example.ititask3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowDetailsActivity extends AppCompatActivity {

    public static final String MESSAGES_PREFERENCES = "MessagesPreferences";
    TextView phoneNumberTV;
    TextView messageTV;
    Button closeBTN, writeBTN, readBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        Intent intent = getIntent();
        phoneNumberTV = findViewById(R.id.phoneTV);
        messageTV = findViewById(R.id.messageTV);
        closeBTN = findViewById(R.id.closeBTN2);
        writeBTN = findViewById(R.id.write_shared_pref);
        readBTN = findViewById(R.id.read_shared_pref);

        String phoneExtra = intent.getStringExtra(MainActivity.PHONE);
        phoneNumberTV.setText(phoneExtra);

        String messageExtra = intent.getStringExtra(MainActivity.MESSAGE);
        messageTV.setText(messageExtra);
        closeBTN.setOnClickListener(view -> finish());
        writeBTN.setOnClickListener(view -> {
            SharedPreferences writePreferences = getSharedPreferences(MESSAGES_PREFERENCES, MODE_PRIVATE);
            SharedPreferences.Editor editor = writePreferences.edit();
            editor.putString(MainActivity.PHONE, phoneExtra);
            editor.putString(MainActivity.MESSAGE, messageExtra);
            editor.apply();

            phoneNumberTV.setText("");
            messageTV.setText("");
        });

        readBTN.setOnClickListener(view -> {
            SharedPreferences readPreferences = getSharedPreferences(MESSAGES_PREFERENCES, MODE_PRIVATE);
            String phone = readPreferences.getString(MainActivity.PHONE, "0XXXXXXXXXXXXX");
            String message = readPreferences.getString(MainActivity.MESSAGE, "");

            phoneNumberTV.setText(phone);
            messageTV.setText(message);
        });
    }
}