package com.example.ititask7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.ititask7.databinding.ActivityDayDetailBinding;

import java.util.Arrays;
import java.util.List;

public class DayDetailActivity extends AppCompatActivity {
    ActivityDayDetailBinding binding;
    private int position;
    private final List<String> daysOfWeak = Arrays.asList("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    private final List<Integer> daysImage = Arrays.asList(R.mipmap.number_one,
            R.mipmap.number_two,
            R.mipmap.number_three,
            R.mipmap.number_four,
            R.mipmap.number_five,
            R.mipmap.number_six,
            R.mipmap.number_seven);
    //comment
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDayDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String day = intent.getStringExtra(MainActivity.DAY_KEY);
        int dayImage = intent.getIntExtra(MainActivity.DAY_IMAGE_KEY, -1);
        position = intent.getIntExtra(MainActivity.POSITION_KEY, -1);
        binding.dayTxtView.setText(day);
        binding.dayDescTextView.setText(day + "description");
        binding.dayImageImg.setImageResource(dayImage);
        binding.nextDayBtn.setOnClickListener(view -> {
            if (position == daysOfWeak.size() - 1) {
                position = -1;
                moveToNextDay();
            }
            else
                moveToNextDay();
        });
        binding.previousDayButton.setOnClickListener(view -> {
            if (position == 0) {
                position = daysOfWeak.size();
                moveToPrevDay();
            }
            else
                moveToPrevDay();
        });

    }

    @SuppressLint("SetTextI18n")
    private void moveToPrevDay() {
        --position;
        binding.dayTxtView.setText(daysOfWeak.get(position));
        binding.dayDescTextView.setText(daysOfWeak.get(position) + "description");
        binding.dayImageImg.setImageResource(daysImage.get(position));

    }

    @SuppressLint("SetTextI18n")
    private void moveToNextDay() {
        ++position;
        binding.dayTxtView.setText(daysOfWeak.get(position));
        binding.dayDescTextView.setText(daysOfWeak.get(position) + "description");
        binding.dayImageImg.setImageResource(daysImage.get(position));

    }
}