package com.example.puneet.moodpredictor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MoodPrediction extends Activity
{
    TextView setHeart;
    TextView setSkin;
    TextView setTemp;
    TextView setMood;
    TextView setMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_prediction);

        setHeart = findViewById(R.id.tvSetHeart);
        setSkin = findViewById(R.id.tvSetSkin);
        setTemp = findViewById(R.id.tvSetTemp);
        setMood = findViewById(R.id.tvSetMood);
        setMobile = findViewById(R.id.tvSetMobile);

        Intent intent = getIntent();

        String heartbeat = intent.getStringExtra("heartbeat");
        String skin = intent.getStringExtra("skin");
        String temp = intent.getStringExtra("temp");
        String mood = intent.getStringExtra("mood");
        String mobile = intent.getStringExtra("mobile");

        setHeart.setText(heartbeat);
        setSkin.setText(skin);
        setTemp.setText(temp);
        setMood.setText(mood);
        setMobile.setText(mobile);
    }

    public void yes(View view)
    {
        String mood = setMood.getText().toString();

        Intent intent = new Intent(getApplicationContext(),test.class);
        intent.putExtra("mood",mood);
        startActivity(intent);
    }

    public void no(View view)
    {
        setHeart.setText("");
        setSkin.setText("");
        setTemp.setText("");
        setMood.setText("");

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}
