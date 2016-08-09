package com.example.davidstone.services_lab_media_player;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.davidstone.services_lab_media_player.Services.PlayerService;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
    }



    private void setViews(){
        setServiceViews();

    }

    private void setServiceViews(){

        Button playButton  = (Button) findViewById(R.id.play_button);
        Button pauseButton = (Button) findViewById(R.id.pause_button);
        Button stopButton = (Button) findViewById(R.id.stop_button);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, PlayerService.class);
            //    intent.putExtra("name", "Dave" );
                startService(intent);
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add code to get pause working here
                PlayerService.pause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerService.stop();
                stopService(new Intent(MainActivity.this, PlayerService.class));

            }
        });
    }


}
