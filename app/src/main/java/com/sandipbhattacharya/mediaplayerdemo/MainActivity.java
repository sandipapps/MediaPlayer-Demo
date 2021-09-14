package com.sandipbhattacharya.mediaplayerdemo;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    // Declare a MediaPlayer object reference
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize the MediaPlayer object reference with null
        mediaPlayer = null;
    }

    public void music(View view) {
        switch (view.getId()){
            case R.id.button:
                // Check if mediaPlayer is null. If true, we'll instantiate the MediaPlayer object
                if(mediaPlayer == null){
                    mediaPlayer = MediaPlayer.create(this, R.raw.music);
                }
                // Then, register OnCompletionListener that calls a user supplied callback method onCompletion() when
                // looping mode was set to false to indicate playback is completed.
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        // Here, call a method to release the MediaPlayer object and to set it to null.
                        stopMusic();
                    }
                });
                // Next, call start() method on mediaPlayer to start playing the music.
                mediaPlayer.start();
                break;
            case R.id.button2:
                if(mediaPlayer != null) {
                    // Here, call pause() method on mediaPlayer to pause the music.
                    mediaPlayer.pause();
                }
                break;
            case R.id.button3:
                if(mediaPlayer != null){
                    // Here, call stop() method on mediaPlayer to stop the music.
                    mediaPlayer.stop();
                    // Call stopMusic() method
                    stopMusic();
                }
                break;
        }
    }

    private void stopMusic() {
        mediaPlayer.release();
        mediaPlayer = null;
    }

    // Call stopMusic() in onStop() overridden method as well.
    @Override
    protected void onStop() {
        super.onStop();
        stopMusic();
    }
}