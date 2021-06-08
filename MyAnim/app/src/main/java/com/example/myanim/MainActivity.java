package com.example.myanim;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        if(button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale);
                    v.startAnimation(anim);
                }
            });

        }
        Button button2 = findViewById(R.id.button2);
        if(button2 != null) {
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Animation anim2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale2);
                    v.startAnimation(anim2);
                }
            });

        }
    }
}