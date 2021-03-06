package com.example.dyn_frag;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {




        private TextView tv;
        private boolean paused = true;
        private FloatingActionButton fab;
        private Drawable PLAY;
        private Drawable PAUSE;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            tv = findViewById(R.id.Text_Timer);
            fab = findViewById(R.id.play_pause_fab);
            PLAY = getResources().getDrawable(android.R.drawable.ic_media_pause);
            PAUSE = getResources().getDrawable(android.R.drawable.ic_media_play);

            if (savedInstanceState != null) {
                int seconds = getIntent().getExtras().getInt( "seconds" );
                paused = savedInstanceState.getBoolean("paused");
                seconds = savedInstanceState.getInt("seconds");
                setIcon();
            }
            runTimer();
        }

        private void setIcon() {
            Drawable icon = paused ? PAUSE : PLAY;
            fab.setImageDrawable(icon);
        }

        @Override
        protected void onSaveInstanceState(@NonNull Bundle outState) {
            super.onSaveInstanceState(outState);
            int seconds = getIntent().getExtras().getInt( "seconds" );
            outState.putInt("seconds", seconds);
            outState.putBoolean("paused", paused);

        }

        public void startTimer(View view) {
            paused = !paused;
            setIcon();
        }

        public void runTimer() {
            final int[] seconds = {getIntent().getExtras().getInt( "seconds" )};
            final Handler handler = new Handler(getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {

                    int sec = seconds[0] % 60;
                    int min = (seconds[0] % 3600) / 60;
                    int hour = seconds[0] / 3600;
                    tv.setText(String.format("%02d : %02d : %02d", hour, min, sec));
                    if (!paused)
                        seconds[0]--;
                    if  (seconds[0] == 0)
                        paused = true;

                    handler.postDelayed(this, 1000);



                    }

                });
            };
                };






