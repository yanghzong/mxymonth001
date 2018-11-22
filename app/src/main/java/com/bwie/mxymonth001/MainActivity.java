package com.bwie.mxymonth001;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView txtTitle;
    private ProgressBar bar;
    private  int num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                ObjectAnimator.ofFloat(txtTitle,"rotationX",0,360),
                ObjectAnimator.ofFloat(txtTitle,"alpha",0.3f,1.0f),
                ObjectAnimator.ofFloat(txtTitle,"scaleX",0.5f,3),
                ObjectAnimator.ofFloat(txtTitle,"scaleY",0.5f,3)
        );
        set.setDuration(3000).start();

        bar.setMax(100);
        handlers.sendEmptyMessage(20);
        handler.sendEmptyMessageDelayed(100,5000);
    }

    private void initView() {
        txtTitle = findViewById(R.id.txt_title);
        bar = findViewById(R.id.bar);
    }
    Handler handlers = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            bar.setProgress(num);
            num+=20;
            sendEmptyMessageDelayed(20,1000);
        }
    };
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what==100) {
                Intent intent = new Intent(MainActivity.this, ShowActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
}

