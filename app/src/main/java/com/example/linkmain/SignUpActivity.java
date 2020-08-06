package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
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


public class SignUpActivity extends AppCompatActivity {
    private EditText email_join;
    private EditText pwd_join;
    private EditText pwd_check_join;
    private Button btn;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        email_join = (EditText) findViewById(R.id.sign_up_email);
        pwd_join = (EditText) findViewById(R.id.sign_up_pwd);
        pwd_check_join = (EditText) findViewById(R.id.sign_up_pwd_check);
        btn = (Button) findViewById(R.id.sign_up_btn);

        firebaseAuth = FirebaseAuth.getInstance(); //firebase 연동

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //입력 정보 정보 가져옴
                String email = email_join.getText().toString().trim();
                String pwd = pwd_join.getText().toString().trim();
                String pwd_check = pwd_check_join.getText().toString().trim();

                if(pwd.equals(pwd_check)) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                                // overridePendingTransition(FADE_IN_ANIMATION, FADE_OUT_ANIMATION); // 슬라이딩 애니메이션 화면전환 사용시 사용
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "등록 에러", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }
                    });

                } // if - pwd equals
                else{
                    Toast.makeText(getApplicationContext(), "입력하신 비밀번호가 일치하지 않습니다.", Toast.LENGTH_LONG);
                    return;
                } // else - pwd equals
            } // onClick END
        }); // 버튼 onClickListener END
    } // onCreate END
} // public class END
