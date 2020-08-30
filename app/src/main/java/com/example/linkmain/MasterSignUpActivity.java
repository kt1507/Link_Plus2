package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MasterSignUpActivity extends AppCompatActivity {
    private EditText email_join;
    private EditText pwd_join;
    private EditText pwd_check_join;
    private EditText name_join;
    private EditText number_join;
    private ImageButton btn;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_03_signup_03);
//        getSupportActionBar().hide();

        email_join = (EditText) findViewById(R.id.sign_up_email);
        pwd_join = (EditText) findViewById(R.id.sign_up_pwd);
        pwd_check_join = (EditText) findViewById(R.id.sign_up_pwd_check);
        name_join = (EditText) findViewById(R.id.sign_up_name);
        number_join = (EditText) findViewById(R.id.sign_up_number);
        btn = (ImageButton) findViewById(R.id.sign_up_btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //입력 정보 정보 가져옴
                final String email = email_join.getText().toString().trim();
                // email에서 ID String 추출
                int idx = email_join.getText().toString().indexOf("@");
                final String ID = email_join.getText().toString().substring(0,idx); // email에서 ID만 추출한 값

                final String pwd = pwd_join.getText().toString().trim();
                String pwd_check = pwd_check_join.getText().toString().trim();
                final String name = name_join.getText().toString().trim();
                final String number = number_join.getText().toString().trim();

                if (email_join.getText().toString().length() == 0){
                    Toast.makeText(MasterSignUpActivity.this, "이메일을 입력하세요.", Toast.LENGTH_SHORT).show();
                    email_join.requestFocus();
                    return;
                } // else if - email is empty
                /* 존재하는 email 처리 (FirebaseAuthUserCollisionException) */
                if (pwd_join.getText().toString().length() == 0){
                    Toast.makeText(MasterSignUpActivity.this, "비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwd_join.requestFocus();
                    return;
                } // else if - pwd is empty
                if (pwd_check_join.getText().toString().length() == 0){
                    Toast.makeText(MasterSignUpActivity.this, "비밀번호 확인란을 입력하세요.", Toast.LENGTH_SHORT).show();
                    pwd_check_join.requestFocus();
                    return;
                } // else if -pwd check is empty
                if (!pwd_join.getText().toString().equals(pwd_check_join.getText().toString())){
                    Toast.makeText(MasterSignUpActivity.this, "입력하신 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    pwd_join.setText("");
                    pwd_check_join.setText("");
                    pwd_join.requestFocus();
                    return;
                } // else if - pwd equals


                if(pwd_join.getText().toString().equals(pwd_check_join.getText().toString())) {
                    firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(MasterSignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
//                                sendVerificationEmail(email, email_link, pwd, name, number);
                                Intent intent = new Intent(MasterSignUpActivity.this, LoginActivity.class);
                                startActivity(intent);
                                Toast.makeText(getApplicationContext(), "회원가입이 성공적으로 처리되었습니다.\n", Toast.LENGTH_SHORT).show();

                                /*firebase Database User information*/
                                mRootRef.child("UserInfo").child(ID).child("Email").setValue(email); // 설명: database - [email] 하위 - "Email" 하위 - Data 값: [email_link]
                                mRootRef.child("UserInfo").child(ID).child("PassWord").setValue(pwd);
                                mRootRef.child("UserInfo").child(ID).child("ID").setValue(ID);
                                mRootRef.child("UserInfo").child(ID).child("Name").setValue(name);
                                mRootRef.child("UserInfo").child(ID).child("Number").setValue(number);
                                mRootRef.child("UserInfo").child(ID).child("Master").setValue("Master-Un-Authentication");

                                String emailValue = "Email: " + email + "\n" + "ID: " + ID + "\n" + "이름: " + name + "\n" + "전화번호: " + number + "\n";

                                Intent email = new Intent(Intent.ACTION_SEND);
                                email.setType("plain/Text");
                                String[] address = {"ostreetmaster@gmail.com"};
                                email.putExtra(Intent.EXTRA_EMAIL, address);
                                email.putExtra(Intent.EXTRA_SUBJECT,"오거리 사업자 계정 신청");
                                email.putExtra(Intent.EXTRA_TEXT, "오거리 어플리케이션에 대한 사업자 계정 권한 신청입니다.\n" + "어플리케이션 [오거리] 사업자 계정 신청 정보\n" + emailValue);
                                startActivity(email);
                                finish();
                            }
                            else {
                                // 팝업 창
                                AlertDialog.Builder builder = new AlertDialog.Builder(MasterSignUpActivity.this);
                                builder.setTitle("회원가입 실패");
                                builder.setMessage("이메일/페스워드의 형식이 잘못되었습니다.\n\n(Email : 유효한 계정 이메일 주소)\n(PW : 영문 4자 이상 + 숫자 2개 이상 포함)");
                                builder.setNeutralButton("확인", null);
                                builder.create().show();
                                email_join.requestFocus();
                                return;
                            } // else - email 입력형식 오류
                        }
                    });
                } // if - pwd equals
            } // onClick END
        }); // 버튼 onClickListener END
    } // onCreate END

    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(MasterSignUpActivity.this, SignUpAccessActivity.class));
        finish();
    }

} // public class END


