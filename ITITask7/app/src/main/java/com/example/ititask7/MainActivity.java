package com.example.ititask7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.ititask7.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DaysAdapter.OnDayClickListener{
    ActivityMainBinding binding;
    protected static final String DAY_KEY = "DAY_KEY";
    protected static final String DAY_IMAGE_KEY = "DAY_IMAGE_KEY";
    protected static final String POSITION_KEY = "POSITION_KEY";
    private final List<String> daysOfWeak = Arrays.asList("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday");
    private final List<Integer> daysImage = Arrays.asList(R.mipmap.number_one,
            R.mipmap.number_two,
            R.mipmap.number_three,
            R.mipmap.number_four,
            R.mipmap.number_five,
            R.mipmap.number_six,
            R.mipmap.number_seven);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        DaysAdapter adapter = new DaysAdapter(this);
        adapter.setDaysList(daysOfWeak);
        adapter.setImageOfDays(daysImage);
        binding.daysRecycler.setAdapter(adapter);

    }

    @Override
    public void onDayClickListener(int position) {
        Intent intent = new Intent(this, DayDetailActivity.class);
        intent.putExtra(DAY_IMAGE_KEY, daysImage.get(position));
        intent.putExtra(DAY_KEY, daysOfWeak.get(position));
        intent.putExtra(POSITION_KEY, position);
        startActivity(intent);

    }
}