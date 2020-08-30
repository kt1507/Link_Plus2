package com.example.linkmain;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.linkmain.ui.home.HomeFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져


    //숨겨진 페이지가 열렸는지 체크
    boolean isPageOpen = false;

    Animation translateTopAnim;
    Animation translateBottomAnim;
    Animation translatestartAnim;

    FrameLayout page;

    private Menu mMenu;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();


        // ToolBar Setting
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        getSupportActionBar().hide(); // Toolbar 제거하기

        // Toolbar Menu Icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Toolbar Text Delete
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        // Toolbar 로고 삽입
//        getSupportActionBar().setLogo(R.drawable.logo01);
//        getSupportActionBar().setDisplayUseLogoEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setElevation(200);


//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_camera);
//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF"))); // Toolbar 색상변경
//        getSupportActionBar().setIcon(R.drawable.logo01); // Toolbar 이미지 삽입


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        // nav_header_main 부분 onClick 이벤트 - 버튼으로 Layout 넘기기
        View headerView = navigationView.getHeaderView(0);
        Button loginBtn = (Button) headerView.findViewById(R.id.login_Btn_header); // Login Btn
//        Button loginBtn2 = (Button) findViewById(R.id.drawer_item_accout);
        Button logoutBtn = (Button) headerView.findViewById(R.id.logout_Btn_header); // Logout Btn
        Button DeleteBtn = (Button) headerView.findViewById(R.id.Delete_Btn_header); // Delete Btn
        ImageButton InfoBtn = (ImageButton) headerView.findViewById(R.id.Info_btn); // Info Btn
        final TextView textViewUserEmail = (TextView) headerView.findViewById(R.id.textview_address_header); // TextView UserEmail

//        // Btn - login
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(firebaseAuth.getCurrentUser() != null){ //만약 이미 로그인되어있다면
//                    Toast.makeText(getApplicationContext(), "이미 로그인되었습니다!", Toast.LENGTH_SHORT).show();
//                }
//                else{ //로그인 정보가 없는 경우
//                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                    finish();
//                    Toast.makeText(getApplicationContext(), "로그인화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        // Btn - LogOut
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(firebaseAuth.getCurrentUser() != null){ //만약 이미 로그인되어있다면
//                    firebaseAuth.signOut(); // 로그아웃시킴
//                    Toast.makeText(getApplicationContext(), "로그아웃이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(MainActivity.this, MainActivity.class));
//                    finish();
//                }
//                else{ //로그인 정보가 없는 경우
//                    Toast.makeText(getApplicationContext(), "현재 로그인 정보가 없습니다!", Toast.LENGTH_SHORT).show();
//                    //getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Activity 제거.
//                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
//                }
//
//            }
//        });
        // Btn - Delete
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (firebaseAuth.getCurrentUser() != null) { //만약 이미 로그인되어있다면
                    // 팝업 창
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("회원탈퇴");
                    builder.setMessage("정말 회원을 탈퇴하시겠습니까?\n(확인 시 계정이 영구적으로 삭제됩니다)");
                    builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // String 추출
                            String email_D = user.getEmail();
                            int idx = email_D.indexOf("@");
                            final String email_OF = email_D.substring(0, idx);
                            // DB 해당 계정정보 삭제
                            mRootRef.child("UserInfo").child(email_OF).removeValue();

                            user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(MainActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
                                    ActivityCompat.finishAffinity(MainActivity.this);
                                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                                    finish();
                                }
                            });
                        }
                    });
                    builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "계정 삭제가 취소되었습니다.", Toast.LENGTH_LONG).show();
                        }
                    });
                    builder.setNeutralButton("취소", null);
                    builder.create().show();
                }
                else{//로그인 정보가 없는 경우
                    Toast.makeText(getApplicationContext(), "현재 로그인 정보가 없습니다!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            }
        });
        // Btn - Info
        InfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "로그인화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "계정 정보로 이동합니다.", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(MainActivity.this, UserInfoActivity.class));
                }
            }
        });
        // TextView - 사용자 로그인 상태에 따라 로그인 정보 출력.
        if(user != null) {
            String email = user.getEmail();
            textViewUserEmail.setText(email);
        }
        else{
            textViewUserEmail.setText("로그인 정보 없음");
        }



        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_cat1, R.id.nav_cat2, R.id.nav_cat3, R.id.nav_cat4, R.id.nav_cat5, R.id.nav_cat6, R.id.nav_cat7, R.id.nav_cat8, R.id.nav_email)
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
                FloatingActionButton fab = findViewById(R.id.fab1);
                fab.show();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        // Action Button - 스크롤뷰 진입
        final FloatingActionButton fab = findViewById(R.id.fab1);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "리스트 뷰 올라와서 활성화", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                // Floating Action Button Active Code Edit here.

                if(isPageOpen){ //페이지 열려있으면
                    page.startAnimation(translateBottomAnim); //아래로 닫기 애니메이션 실행
                }else{ //페이지 닫혀있으면
                    page.startAnimation(translateTopAnim); //위로 열기 애니메이션 실행
                    fab.hide();
                }
            }
        });

//        Animbutton = findViewById(R.id.button);
//
//        // 버튼 클릭 이벤트 처리
//        Animbutton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (isPageOpen) { //페이지 열려있으면
//                    page.startAnimation(translateBottomAnim); //아래로 닫기 애니메이션 실행
//                } else { //페이지 닫혀있으면
//                    page.startAnimation(translateTopAnim); //위로 열기 애니메이션 실행
//                }
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.mMenu = menu;
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    // Option Item (상단 바)
/*    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.back_item:
                page.startAnimation(translateBottomAnim); //아래로 닫기 애니메이션 실행
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
*/

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //content.xml 닫는 버튼
    public void onClickCloseListFramelayout(View view){
        page.startAnimation(translateBottomAnim);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Toast.makeText(this.getApplicationContext(),"home",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat1) {
            Toast.makeText(this.getApplicationContext(),"cat1",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat2) {
            Toast.makeText(this.getApplicationContext(),"cat2",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat3) {
            Toast.makeText(this.getApplicationContext(),"cat3",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat4) {
            Toast.makeText(this.getApplicationContext(),"cat4",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat5) {
            Toast.makeText(this.getApplicationContext(),"cat5",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat6) {
            Toast.makeText(this.getApplicationContext(),"cat6",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat7) {
            Toast.makeText(this.getApplicationContext(),"cat7",Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_cat8) {
            Toast.makeText(this.getApplicationContext(),"cat8",Toast.LENGTH_SHORT).show();
        }


        //HomeFragment homeFragment = HomeFragment.sharecategory(category);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onClickNavHome(MenuItem item) {
        ListViewFragment listViewFragment = new ListViewFragment(); // 객체 생성
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();    //프래그먼트 replace
        Bundle bundle = new Bundle();
        bundle.putString("Tab1","모두표시");
        listViewFragment.setArguments(bundle);  //bundle로 데이터 넘김
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT); //navibar 닫음
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();
    }

    public void onClickNavCat1(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        HomeFragment homeFragment = new HomeFragment();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","전기");
        bundle.putString("Tab2","조명");
        bundle.putString("Tab3","판넬");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();
    }

    public void onClickNavCat2(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","소방");
        bundle.putString("Tab2","안전용품");
        bundle.putString("Tab3","청소용품");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat3(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","공구");
        bundle.putString("Tab2","파이프");
        bundle.putString("Tab3","아크릴");
        bundle.putString("Tab4","목재");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat4(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","철물");
        bundle.putString("Tab2","철공예");
        bundle.putString("Tab3","철망");
        bundle.putString("Tab4","볼트");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat5(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","창호");
        bundle.putString("Tab2","장판");
        bundle.putString("Tab3","타일");
        bundle.putString("Tab4","보일러");
        bundle.putString("Tab5","천막");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat6(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","닥트");
        bundle.putString("Tab2","간판");
        bundle.putString("Tab3","식당용품");
        bundle.putString("Tab4","진열대");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat7(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","페인트");
        bundle.putString("Tab2","포장/접착");
        bundle.putString("Tab3","냉동");
        listViewFragment.setArguments(bundle);
        homeFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavCat8(MenuItem item){
        ListViewFragment listViewFragment = new ListViewFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.listview_framelayout,listViewFragment).commit();
        HomeFragment homeFragment = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.map,homeFragment).commit();

        Bundle bundle = new Bundle();
        bundle.putString("Tab1","자동차용품");
        bundle.putString("Tab2","운반기기");
        bundle.putString("Tab3","모터펌프");
        listViewFragment.setArguments(bundle);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(Gravity.LEFT);
    }

    public void onClickNavEmail(MenuItem item){
        // 팝업 창
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("문의 메일 전송하기");
        builder.setMessage("앱 개발팀으로 문의사항을 메일로 전송합니다.\n(확인 시 자동으로 메일 앱으로 전환됩니다)\n\n[메일주소 : ostreetmaster@gmail.com]");
        builder.setPositiveButton("메일 전송하기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("plain/Text");
                String[] address = {"ostreetmaster@gmail.com"};
                email.putExtra(Intent.EXTRA_EMAIL, address);
                email.putExtra(Intent.EXTRA_SUBJECT,"오거리 문의사항 메일 전송");
                email.putExtra(Intent.EXTRA_TEXT, "어플리케이션 [오거리] 문의/건의 사항\n\n[문의/건의사항 입력]\n");
                startActivity(email);
            }
        });
        builder.setNeutralButton("취소", null);
        builder.create().show();
    }
}