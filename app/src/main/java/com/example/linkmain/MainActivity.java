package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    //숨겨진 페이지가 열렸는지 체크
    boolean isPageOpen = false;

    Animation translateTopAnim;
    Animation translateBottomAnim;

    ListView page;
    Button Animbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //FloatingActionButton fab = findViewById(R.id.fab);
        //fab.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View view) {
      //          Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
     //                   .setAction("Action", null).show();
      //      }
      //  });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        page = findViewById(R.id.listview);

        //anim 폴더의 애니메이션 가져와서 준비
        translateTopAnim = AnimationUtils.loadAnimation(this,R.anim.translate_top);
        translateBottomAnim = AnimationUtils.loadAnimation(this,R.anim.translate_bottom);

        //페이지 슬라이딩 이벤트가 발생했을 때 애니메이션이 시작 됐는지 종료 됐는지 감지
        SlidingPageAnimationListener animListener = new SlidingPageAnimationListener();

        translateTopAnim.setAnimationListener(animListener);
        translateBottomAnim.setAnimationListener(animListener);

        //버튼을 눌렀을 때
        Animbutton = findViewById(R.id.button);
        Animbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(isPageOpen){
                    page.startAnimation(translateTopAnim);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateBottomAnim);
                }
            }
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener{
        @Override
        public void onAnimationStart(Animation animation){

        }

        public void onAnimationEnd(Animation animation){
            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);

                Animbutton.setText("열기");
                isPageOpen = false;
            }else{
                Animbutton.setText("닫기");
                isPageOpen = true;
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.action_listview:
                startActivity(new Intent(MainActivity.this, ListViewActivity.class));
                return true;
            case R.id.action_login:
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
