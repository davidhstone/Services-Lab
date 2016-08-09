package com.example.davidstone.services_lab_media_player.Services;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.IOException;

/**
 * Created by davidstone on 8/8/16.
 */
public class PlayerService extends Service {
    private static final String TAG = "PlayerService";

    public static MediaPlayer mPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = null;

       // String url = "https://googledrive.com/host/0B8E5tqWzlY9IaFRfbUZrRkw4SXM/Infinity.mp3"; // your URL here
       // MediaPlayer mediaPlayer = new MediaPlayer();
       // mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
       // try {
       //     mediaPlayer.setDataSource(url);
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }
       // try {
       //     mediaPlayer.prepare(); // might take long! (for buffering, etc)
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }
       // Log.i(TAG, ": The player is doing something");
       // mediaPlayer.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (mPlayer == null) {
            String url = "https://googledrive.com/host/0B8E5tqWzlY9IaFRfbUZrRkw4SXM/Infinity.mp3"; // your URL here
        mPlayer = new MediaPlayer();
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mPlayer.setDataSource(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            mPlayer.prepare(); // might take long! (for buffering, etc)
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.i(TAG, ": The player is doing something");
        mPlayer.start();
    }  else {
            play();
        }

        return START_NOT_STICKY;
    }

    public void play() {
        if (mPlayer != null && !mPlayer.isPlaying())  {
            mPlayer.start();
        }
    }

    public static void pause() {
       if (mPlayer != null && mPlayer.isPlaying())  {
           mPlayer.pause();
       }
    }
    public static void stop(){
        mPlayer.stop();
        mPlayer.release();
    }
}

// BSR s/t folder sharable link:https://drive.google.com/folderview?id=0B8E5tqWzlY9IOWhWU2kydEFaNWM&usp=sharing