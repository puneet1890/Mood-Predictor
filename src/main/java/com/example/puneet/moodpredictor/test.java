package com.example.puneet.moodpredictor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class test extends YouTubeBaseActivity {
    YouTubePlayerView youTubePlayer;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    Intent in;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        in = getIntent();
        mood = in.getStringExtra("mood");

        youTubePlayer = findViewById(R.id.UTube_player_view);

        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Toast.makeText(getApplicationContext(), "Playing Video", Toast.LENGTH_LONG).show();

                if (mood.equals("Happy")) {
                    youTubePlayer.loadPlaylist("PLCU2AKdwPmvp-sVKvqCv0IHyc-pWPjQhZ");
                } else if (mood.equals("Sad")) {
                    youTubePlayer.loadPlaylist("PLqVUpa-84iyg25x62yn86sBnaIcxuUMvH");
                } else if (mood.equals("Excited")) {
                    youTubePlayer.loadPlaylist("PLNCA1T91UH30u2NRMM_08QKUWt2wACnOm");
                } else if (mood.equals("Angry")) {
                    youTubePlayer.loadPlaylist("PL7VO6WZyyYVT9hQrMAs3xjaS0U9gt8QBt");
                }
                else if (mood.equals("Depressed")) {
                    youTubePlayer.loadPlaylist("PL5D7fjEEs5yflZzSZAhxfgQmN6C_6UJ1W");
                }
                else {
                    Toast.makeText(getApplicationContext(), "Could not recognise your mood, Please retry once again", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(), "Failed to play Video", Toast.LENGTH_LONG).show();
            }
        };

        youTubePlayer.initialize(PlayerConfig.getApiKey(), onInitializedListener);
    }
}

