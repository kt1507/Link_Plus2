package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private Button join;
    private Button login;
    private Button btn_email;
    private Button btn_pw;
    private EditText email_login;
    private EditText pwd_login;

    private FirebaseAuth firebaseAuth;

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

        firebaseAuth = firebaseAuth.getInstance(); // firebaseAuth 호출

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                firebaseAuth.signInWithEmailAndPassword(email, pwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "로그인에 성공하였습니다!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    // overridePendingTransition(FADE_IN_ANIMATION, FADE_OUT_ANIMATION); // 슬라이딩 애니메이션 화면전환 사용시 사용
                                } else {
                                    Toast.makeText(getApplicationContext(), "아이디 혹은 페스워드가 올바르지 않습니다!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
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
}

