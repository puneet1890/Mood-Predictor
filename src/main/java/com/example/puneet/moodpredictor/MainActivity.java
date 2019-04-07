package com.example.puneet.moodpredictor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity
{
    EditText etMobile;

    String heartbeat;
    String mobile;
    String mood;
    String skin;
    String temp;

    Api api;
    String getmobile;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Mood Tracker", "onCreate() of MainActivity");

        etMobile = findViewById(R.id.etMobile);
    }

    public void getMood(View view)
    {
        Log.d("Mood Tracker", "in getMood() of MainActivity");

        getmobile = etMobile.getText().toString();

        // Fetching the data
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-154-226-182.ap-south-1.compute.amazonaws.com:8080/MoodDetector/rest/user/handleLogin/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(Api.class);
        getData();

    } //End of getMood() Hook method

    private void getData()
    {
        Call<MoodBean> call = api.getData(getmobile);

        call.enqueue(new Callback<MoodBean>()
        {
            @Override
            public void onResponse(@NotNull Call<MoodBean> call, @NotNull Response<MoodBean> response)
            {
                MoodBean bean = response.body();

                if (bean != null)
                {
                    heartbeat = bean.getHeartbeat();
                    mobile = bean.getMobile();
                    mood = bean.getMood();
                    skin = bean.getSkin();
                    temp = bean.getTemp();

                    //Logging to the console
                    Log.d("Mood Tracker","MoodBean obj created "+bean.toString());

                    //Passing the data to the next Activity
                    Intent in = new Intent(getApplicationContext(), MoodPrediction.class);

                    in.putExtra("heartbeat", heartbeat);
                    in.putExtra("mobile", mobile);
                    in.putExtra("mood", mood);
                    in.putExtra("skin", skin);
                    in.putExtra("temp", temp);

                    startActivity(in);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"MoodBean obj not created",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<MoodBean> call, @NotNull Throwable t)
            {
                Toast.makeText(getApplicationContext(),"Failed to connect in getData() "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    } // End of getData()

 /*   private void getMoodDetails()
    {
        Map<String,String> parameters = new HashMap<>();
        parameters.put("id","1234567890");
        parameters.put("temp","5600");
        parameters.put("bpm","3400");
        parameters.put("skin","2300");

        Call<MoodBean> call = api.getMoodDetails(parameters);

        call.enqueue(new Callback<MoodBean>()
        {
            @Override
            public void onResponse(@NotNull Call<MoodBean> call,@NotNull Response<MoodBean> response)
            {
                MoodBean mood = response.body();

                if(mood != null)
                {
                    Toast.makeText(getApplicationContext(), "MoodBean obj created"+mood.toString(), Toast.LENGTH_LONG).show();
                    Log.d("Mood Tracker", "MoodBean obj created"+mood.toString());
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"MoodBean obj not created",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<MoodBean> call,@NotNull Throwable t)
            {
                Toast.makeText(getApplicationContext(),"Failed to connect in getMoodDetails() "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    } *///End of getMoodDetails
} //End of Main Activity

