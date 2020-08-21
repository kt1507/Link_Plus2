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
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;


public class SignUpActivity extends AppCompatActivity {
    private EditText email_join;
    private EditText pwd_join;
    private EditText pwd_check_join;
    private Button btn;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        email_join = (EditText) findViewById(R.id.sign_up_email);
        pwd_join = (EditText) findViewById(R.id.sign_up_pwd);
        pwd_check_join = (EditText) findViewById(R.id.sign_up_pwd_check);
        btn = (Button) findViewById(R.id.sign_up_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //입력 정보 정보 가져옴
                final String email = email_join.getText().toString().trim();
                final String pwd = pwd_join.getText().toString().trim();
                String pwd_check = pwd_check_join.getText().toString().trim();
                final String email_link = email + "@linkplus.com";

                if (email_join.getText().toString().length() == 0){
                    Toast.makeText(SignUpActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                    email_join.requestFocus();
                    return;
                } // else if - email is empty
                /* 존재하는 email 처리 (FirebaseAuthUserCollisionException) */
                if (pwd_join.getText().toString().length() == 0){
                    Toast.makeText(SignUpActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwd_join.requestFocus();
                    return;
                } // else if - pwd is empty
                if (pwd_check_join.getText().toString().length() == 0){
                    Toast.makeText(SignUpActivity.this, "비밀번호 확인란을 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwd_check_join.requestFocus();
                    return;
                } // else if -pwd check is empty
                if (!pwd_join.getText().toString().equals(pwd_check_join.getText().toString())){
                    Toast.makeText(SignUpActivity.this, "입력하신 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwd_join.setText("");
                    pwd_check_join.setText("");
                    pwd_join.requestFocus();
                    return;
                } // else if - pwd equals

                if(pwd_join.getText().toString().equals(pwd_check_join.getText().toString())) {
                    firebaseAuth.createUserWithEmailAndPassword(email_link, pwd).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "회원가입이 성공적으로 처리되었습니다.\n", Toast.LENGTH_SHORT).show();

                                /*firebase Database User information*/
                                mRootRef.child(email).child("Email").setValue(email_link); // 설명: database - [email] 하위 - "Email" 하위 - Data 값: [email_link]
                                mRootRef.child(email).child("PassWord").setValue(pwd);
                                // overridePendingTransition(FADE_IN_ANIMATION, FADE_OUT_ANIMATION); // 슬라이딩 애니메이션 화면전환 사용시 사용
                                finish();
                            }
                            else {
                                Toast.makeText(SignUpActivity.this, "이메일 양식을 지켜주세요", Toast.LENGTH_SHORT).show();
                                email_join.requestFocus();
                                return;
                            } // else - email 입력형식 오류
                        }
                    });
                } // if - pwd equals
            } // onClick END
        }); // 버튼 onClickListener END
    } // onCreate END

    private void sendVerificationEmail(){
        ActionCodeSettings actionCodeSettings =
                ActionCodeSettings.newBuilder()
                        // URL you want to redirect back to. The domain (www.example.com) for this
                        // URL must be whitelisted in the Firebase Console.
                        .setUrl("https://www.example.com/finishSignUp?cartId=1234")
                        // This must be true
                        .setHandleCodeInApp(true)
                        .setIOSBundleId("com.example.ios")
                        .setAndroidPackageName(
                                "com.example.android",
                                true, /* installIfNotAvailable */
                                "12"    /* minimumVersion */)
                        .build();
    } // sendVerificationEmail END

    @IgnoreExtraProperties
    public class User {

        public String username;
        public String email;

        public User() {
            // Default constructor required for calls to DataSnapshot.getValue(User.class)
        }

        public User(String username, String email) {
            this.username = username;
            this.email = email;
        }

    }

} // public class END


