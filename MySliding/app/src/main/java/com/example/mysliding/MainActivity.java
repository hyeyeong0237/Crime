package com.example.mysliding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Animation translateLeft;
    Animation translateRight;

    LinearLayout page;
    Button button;

    boolean isPageOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        translateLeft = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        SlidingAnimationListener animListener = new SlidingAnimationListener();
        translateLeft.setAnimationListener(animListener);
        translateRight.setAnimationListener(animListener);


        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isPageOpen){
                    page.startAnimation(translateRight);
                }else {
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeft);
                }
            }
        });
    }

    class SlidingAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            if(isPageOpen){
                page.setVisibility(View.VISIBLE);

                button.setText("열기");
                isPageOpen = false;
            }else{
                button.setText("닫기");
                isPageOpen = true;

            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}