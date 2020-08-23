package com.example.linkmain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {

    private Button join;
    private Button login;
    private Button btn_email;
    private Button btn_pw;
    private EditText email_login;
    private EditText pwd_login;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        join = (Button) findViewById(R.id.main_join_btn); // Btn - SignUp Button
        login = (Button) findViewById(R.id.main_login_btn); // Btn - login Button
        btn_email = (Button) findViewById(R.id.search_email); // Btn - search email
        btn_pw = (Button) findViewById(R.id.search_pw); // Btn - search password
        email_login = (EditText) findViewById(R.id.main_email);
        pwd_login = (EditText) findViewById(R.id.main_pwd);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // String
                String email = email_login.getText().toString().trim();
                String pwd = pwd_login.getText().toString().trim();

                if (email_login.getText().toString().length() == 0){
                    Toast.makeText(LoginActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                    email_login.requestFocus();
                    return;
                } // else if - email is empty
                if (pwd_login.getText().toString().length() == 0){
                    Toast.makeText(LoginActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwd_login.requestFocus();
                    return;
                } // else if - pwd is empty

                // 이메일과 페스워드를 통한 로그인방식
                firebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = firebaseAuth.getCurrentUser();
                                    if (user != null && user.isEmailVerified())
                                    {
                                        Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                    else if(user != null && !user.isEmailVerified())
                                    {
                                        Toast.makeText(getApplicationContext(), "이메일 인증 필요!", Toast.LENGTH_SHORT).show();
                                        user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(getApplicationContext(), "이메일이 전송되었습니다!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                        firebaseAuth.signOut();
//                                      finish();
                                    }
                                    else{
                                        Toast.makeText(getApplicationContext(), "CurrentUser is null!", Toast.LENGTH_SHORT).show();
                                    }
//                                    if (currentUser.isEmailVerified())
//                                    /*
//                                        현재 오류가 나고 강제 ShutDown이 발생하는 이유는 currentUser의 값이 Null이라서 그렇다.
//                                        오류명: Attempt to invoke virtual method 'boolean com.google.firebase.auth.FirebaseUser.isEmailVerified()' on a null object reference
//                                        로그인을 하고 있는 입장에서 로그인 하려는 계정의 이메일 인증상태를 물어보니 그런 것으로
//                                        1. 인증 창을 따로 구분한다.
//                                        2. 대체할 수 있는 isEmailVerified() 구문을 찾는다.
//                                    */
//                                    {
//                                        Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show();
//                                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                        startActivity(intent);
//                                        finish();
//                                    }
//                                    else
//                                    {
//                                        //FirebaseAuth.getInstance().signOut();
//                                        Toast.makeText(getApplicationContext(), "이메일 인증 필요!", Toast.LENGTH_SHORT).show();
//                                        //currentUser.sendEmailVerification();
//                                        currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                            @Override
//                                            public void onComplete(@NonNull Task<Void> task) {
//                                                if(task.isSuccessful()){
//                                                    Toast.makeText(getApplicationContext(), "이메일이 전송되었습니다!", Toast.LENGTH_SHORT).show();
//                                                }
//                                            }
//                                        });
//                                        finish();
//                                    }

//                                    checkIfEmailVerified();

//                                    Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show();
//                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                                    startActivity(intent);
//                                    finish();
                                    // overridePendingTransition(FADE_IN_ANIMATION, FADE_OUT_ANIMATION); // 슬라이딩 애니메이션 화면전환 사용시 사용
                                } else {
                                    Toast.makeText(getApplicationContext(), "아이디 혹은 페스워드가 올바르지 않습니다!", Toast.LENGTH_SHORT).show();
                                }
                            }
                }); // SignInWuthEmailAndPassword END

                // Email 인증상태 확인
               // checkIfEmailVerified();

            }
        });

        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        // 아이디찾기 + 비밀번호찾기 버튼 OnClick 사용시
        /*
        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btn_pw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
         */

    }

   private void checkIfEmailVerified()
    {
        if (currentUser.isEmailVerified())
                                    /*
                                        현재 오류가 나고 강제 ShutDown이 발생하는 이유는 currentUser의 값이 Null이라서 그렇다.
                                        오류명: Attempt to invoke virtual method 'boolean com.google.firebase.auth.FirebaseUser.isEmailVerified()' on a null object reference
                                        로그인을 하고 있는 입장에서 로그인 하려는 계정의 이메일 인증상태를 물어보니 그런 것으로
                                        1. 인증 창을 따로 구분한다.
                                        2. 대체할 수 있는 isEmailVerified() 구문을 찾는다.
                                    */
        {
            Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            //FirebaseAuth.getInstance().signOut();
            Toast.makeText(getApplicationContext(), "이메일 인증 필요!", Toast.LENGTH_SHORT).show();
            //currentUser.sendEmailVerification();
            currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(getApplicationContext(), "이메일이 전송되었습니다!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            firebaseAuth.signOut();
            finish();
        }
    }

//    // 이메일 전송하기
//    public void sendEmailVerificationWithContinueUrl() {
//        currentUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(getApplicationContext(), "이메일 전송이 완료되었습니다!\n확인 후 인증해주세요!", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//
//        //확인메일 현지화 (언어설정)
//        firebaseAuth.setLanguageCode("fr");
//    }
}

