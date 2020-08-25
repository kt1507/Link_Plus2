package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    //숨겨진 페이지가 열렸는지 체크
    boolean isPageOpen = false;

    Animation translateTopAnim;
    Animation translateBottomAnim;
    Animation translatestartAnim;

    FrameLayout page;
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
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cat1, R.id.nav_cat2, R.id.nav_cat3, R.id.nav_cat4, R.id.nav_cat5, R.id.nav_cat6, R.id.nav_cat7, R.id.nav_cat8)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.listview_framelayout, new ListViewFragment());
        fragmentTransaction.commit();

        page = findViewById(R.id.listview_framelayout);

        /* 위, 아래로 슬라이딩하는 애니메이션 객체 로딩 */
        translateTopAnim = AnimationUtils.loadAnimation(this, R.anim.translate_top);
        translateBottomAnim = AnimationUtils.loadAnimation(this, R.anim.translate_bottom);
        translatestartAnim = AnimationUtils.loadAnimation(this, R.anim.start_listview_fragment);

        page.startAnimation(translatestartAnim);
        page.setVisibility(View.INVISIBLE); //페이지 슬라이딩 끝난 후 페이지 안보이게
        //페이지 다 닫기고 버튼 글자 변경 및 isPageOpen 변수 값 변경
        isPageOpen = false;

        //페이지 열기 리스너 설정
        translateTopAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                page.setVisibility(View.VISIBLE); // 슬라이딩 시작할 때 페이지 보이게
                //Animbutton.setText("닫기");
                isPageOpen = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // 페이지 다 열리고 버튼 글자 변경 및 isPageOpen 변수 값 변경

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //페이지 닫기 리스너 설정
        translateBottomAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //Animbutton.setText("열기");
                isPageOpen = false;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                page.setVisibility(View.INVISIBLE); //페이지 슬라이딩 끝난 후 페이지 안보이게
                //페이지 다 닫기고 버튼 글자 변경 및 isPageOpen 변수 값 변경

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Action Button - 스크롤뷰 진입
        FloatingActionButton fab_1 = findViewById(R.id.fab);
        fab_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "리스트 뷰 올라와서 활성화", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                // Floating Action Button Active Code Edit here.

                if(isPageOpen){ //페이지 열려있으면
                    page.startAnimation(translateBottomAnim); //아래로 닫기 애니메이션 실행
                }else{ //페이지 닫혀있으면
                    page.startAnimation(translateTopAnim); //위로 열기 애니메이션 실행
                }
            }
        });

        /*Animbutton = findViewById(R.id.button);

        // 버튼 클릭 이벤트 처리
        Animbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen) { //페이지 열려있으면
                    page.startAnimation(translateBottomAnim); //아래로 닫기 애니메이션 실행
                } else { //페이지 닫혀있으면
                    page.startAnimation(translateTopAnim); //위로 열기 애니메이션 실행
                }
            }
        });*/
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
