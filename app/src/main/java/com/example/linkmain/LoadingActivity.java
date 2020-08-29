package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoadingActivity extends AppCompatActivity {

    private ImageView imgAndroid;
    private ImageView iconAndroid;
    private Animation anim01;
    private Animation anim02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_page);

        Toast.makeText(getApplicationContext(), "로딩 중", Toast.LENGTH_SHORT).show();
        initView();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), "로딩 끝 - 앱이 실행됩니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        },2000);
    }
    private void initView(){
        imgAndroid = (ImageView) findViewById(R.id.loading_img);
        iconAndroid = (ImageView) findViewById(R.id.loading_icon);

        anim01 = AnimationUtils.loadAnimation(this, R.anim.scale_down);
        imgAndroid.setAnimation(anim01);
        anim02 = AnimationUtils.loadAnimation(this, R.anim.rotation2);
        iconAndroid.setAnimation(anim02);
    }
}
