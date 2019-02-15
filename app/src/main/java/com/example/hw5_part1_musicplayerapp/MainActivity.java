package com.example.hw5_part1_musicplayerapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    private RadioGroup radioGroup;
//    boolean moodPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize RadioGroup
        radioGroup=findViewById(R.id.radioGroup);

    }

    public void radioclick(View view){

        ImageView imvu = findViewById(R.id.my_pic);
        int id = view.getId();

        if (id == R.id.rad_dramatic) {
            imvu.setImageResource(R.drawable.dramatic);
            if(mp!=null){
                mp.stop();
            }
            Toast.makeText(this,"Is this the real life?!",Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(this, R.raw.dramaticsong);
            mp.start();

        } else if (id == R.id.rad_love) {
            imvu.setImageResource(R.drawable.love);
            if(mp!=null){
                mp.stop();
            }
            Toast.makeText(this,"I bless the rains down in Africa!",Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(this, R.raw.lovesong);
            mp.start();

        } else if (id == R.id.rad_happy) {
            imvu.setImageResource(R.drawable.happy);
            if(mp!=null){
                mp.stop();
            }
            Toast.makeText(this,"It's fun to stay at the Y-M-C-A!",Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(this, R.raw.happysong);
            mp.start();

        } else {
            Toast.makeText(this,"Stop/Pause the Music",Toast.LENGTH_SHORT).show();
        }
    }


    public void startPlay(View view) {
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Select a Mood",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mp.start();
        }
    }

    public void stopPlay(View view) {
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Select a Mood",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mp.stop();
            mp.prepareAsync();
        }
    }

    public void pausePlay(View view) {
        if (radioGroup.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(this,"Select a Mood",Toast.LENGTH_SHORT).show();
        }
        else
        {
            mp.pause();
        }
    }
}
