package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class UserInfoActivity extends AppCompatActivity {
    private TextView infoName;
    private TextView infoNumber;
    private TextView infoEmail;
    private TextView infoPassWord;
    private Button logoutBtn;
    private Button infoChangeByn;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_04_information);
        getSupportActionBar().hide();

        infoName = (TextView) findViewById(R.id.info_name);
        infoNumber = (TextView) findViewById(R.id.info_number);
        infoEmail = (TextView) findViewById(R.id.info_email);
        infoPassWord = (TextView) findViewById(R.id.info_pw);
        infoChangeByn = (Button)findViewById(R.id.info_change_btn);
        logoutBtn = (Button) findViewById(R.id.main_logout_btn); // Logout Btn

        // Database 정보 가져오기 - child 당 정보를 가져오려면 객체 하나씩 사용해야함.
        // + child ""부분 현재 로그인 했던 계정으로 받아오도록 해야함.
        // 1. 현재 로그인 계정의 정보를 추출함.
        // 2-1. 데이터베이스 전체에서 로그인계정 문자열과 동일한 데이터베이스를 가져온다?
        // 2-2. 로그인 계정의 ID만 추출한다. -> 이걸로 사용하되 현재 로그인 계정의 문자열을 가지고 와서 특정 문자 뒤로 문자열을 자르는 방식으로 추출하기
        //       int idx = ~.indexOF("@");
        //       String ~ = ~.substring(0, idx);
        // 2-3. 사전 회원가입 시 DB 입력과정 시 Key Value를 이메일 값으로 지정한다. (이게 가장 좋아보임) - 오류 확인됨 key값으로 유효하지 않아 생기는 오류인듯

        // 현재 로그인 계정의 이메일에서 @기준 앞부분만 추출 (ID)
        String email = user.getEmail();
        int idx = email.indexOf("@");
        String email_OF = email.substring(0,idx);


//        mRootRef.child(email_OF).child("PassWord").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                Log.d("UserinfoActivity","ValueEventListener : " + snapshot.getValue());
//                infoPassWord.setText(snapshot.getValue().toString());
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
        mRootRef.child(email_OF).child("Name").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("UserinfoActivity","ValueEventListener : " + snapshot.getValue());
                infoName.setText(snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRootRef.child(email_OF).child("Number").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("UserinfoActivity","ValueEventListener : " + snapshot.getValue());
                infoNumber.setText(snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        mRootRef.child(email_OF).child("Email").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.d("UserinfoActivity","ValueEventListener : " + snapshot.getValue());
                infoEmail.setText(snapshot.getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // Btn - Go to Change Infomation
        infoChangeByn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code
                Toast.makeText(getApplicationContext(), "개인정보 수정페이지로 이동합니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoActivity.this, UserInfoChangeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Btn - LogOut
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(firebaseAuth.getCurrentUser() != null){ //만약 이미 로그인되어있다면
                    firebaseAuth.signOut(); // 로그아웃시킴
                    Toast.makeText(getApplicationContext(), "로그아웃이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserInfoActivity.this, MainActivity.class));
                    finish();
                }
                else{ //로그인 정보가 없는 경우
                    Toast.makeText(getApplicationContext(), "현재 로그인 정보가 없습니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
