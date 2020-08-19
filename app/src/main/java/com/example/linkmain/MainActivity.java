package com.example.linkmain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private FirebaseAuth firebaseAuth;
    private  FirebaseUser user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동
        user = firebaseAuth.getCurrentUser(); // User 정보

        // nav_header_main 부분 onClick 이벤트 - 버튼으로 Layout 넘기기
        View headerView = navigationView.getHeaderView(0);
        Button loginBtn = (Button) headerView.findViewById(R.id.login_Btn_header); // Login Btn
        Button logoutBtn = (Button) headerView.findViewById(R.id.logout_Btn_header); // Logout Btn
        Button DeleteBtn = (Button) headerView.findViewById(R.id.Delete_Btn_header); // Delete Btn
        final TextView textViewUserEmail = (TextView) headerView.findViewById(R.id.textview_email_header); // TextView UserEmail

        // Btn - login
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firebaseAuth.getCurrentUser() != null){ //만약 이미 로그인되어있다면
                    Toast.makeText(getApplicationContext(), "이미 로그인되었습니다!", Toast.LENGTH_SHORT).show();
                }
                else{ //로그인 정보가 없는 경우
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    Toast.makeText(getApplicationContext(), "로그인화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // Btn - LogOut
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firebaseAuth.getCurrentUser() != null){ //만약 이미 로그인되어있다면
                    firebaseAuth.signOut(); // 로그아웃시킴
                    Toast.makeText(getApplicationContext(), "로그아웃이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                    finish();
                }
                else{ //로그인 정보가 없는 경우
                    Toast.makeText(getApplicationContext(), "현재 로그인 정보가 없습니다!", Toast.LENGTH_SHORT).show();
                    //getIntent().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Activity 제거.
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }

            }
        });
        // Btn - Delete
        DeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("회원탈퇴");
                builder.setMessage("정말 회원을 탈퇴하시겠습니까?\n(확인 시 계정이 영구적으로 삭제됩니다)");
                builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(MainActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
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
                builder.setNeutralButton("취소",null);
                builder.create().show();
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
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
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
                Toast.makeText(getApplicationContext(), "로그인화면으로 이동합니다!", Toast.LENGTH_SHORT).show();
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
