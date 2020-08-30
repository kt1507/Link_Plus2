package com.example.linkmain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
//    private TextView infoPassWord;
    private Button logoutBtn;
    private Button infoChangeBtn;
    private Button DeleteBtn;
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_04_information);
//        getSupportActionBar().hide();

        infoName = (TextView) findViewById(R.id.info_name);
        infoNumber = (TextView) findViewById(R.id.info_number);
        infoEmail = (TextView) findViewById(R.id.info_email);
//        infoPassWord = (TextView) findViewById(R.id.info_pw);
        infoChangeBtn = (Button) findViewById(R.id.info_change_btn);
//        DeleteBtn = (Button)findViewById(R.id.main_delete_btn);
        logoutBtn = (Button) findViewById(R.id.main_logout_btn); // Logout Btn

        // Database 정보 가져오기 - child 당 정보를 가져오려면 객체 하나씩 사용해야함.
        // + child ""부분 현재 로그인 했던 계정으로 받아오도록 해야함.
        // 1. 현재 로그인 계정의 정보를 추출함.
        // 2-1. 데이터베이스 전체에서 로그인계정 문자열과 동일한 데이터베이스를 가져온다?
        // 2-2. 로그인 계정의 ID만 추출한다. -> 이걸로 사용하되 현재 로그인 계정의 문자열을 가지고 와서 특정 문자 뒤로 문자열을 자르는 방식으로 추출하기
        //       int idx = ~.indexOF("@");
        //       String ~ = ~.substring(0, idx);
        // 2-3. 사전 회원가입 시 DB 입력과정 시 Key Value를 이메일 값으로 지정한다. (이게 가장 좋아보임) - 오류 확인됨 key값으로 유효하지 않아 생기는 오류인듯

        if (currentUser != null || mRootRef != null) {
            // 현재 로그인 계정의 이메일에서 @기준 앞부분만 추출 (ID)
            String email = currentUser.getEmail();
            int idx = email.indexOf("@");
            String email_OF = email.substring(0, idx);
            //firebaseAuth.signOut(); // 로그아웃시킴

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
            mRootRef.child("UserInfo").child(email_OF).child("Name").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("UserinfoActivity", "ValueEventListener : " + snapshot.getValue());
                    infoName.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            mRootRef.child("UserInfo").child(email_OF).child("Number").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("UserinfoActivity", "ValueEventListener : " + snapshot.getValue());
                    infoNumber.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            mRootRef.child("UserInfo").child(email_OF).child("Email").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Log.d("UserinfoActivity", "ValueEventListener : " + snapshot.getValue());
                    infoEmail.setText(snapshot.getValue().toString());
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

            // Btn - Go to Change Infomation
            infoChangeBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Active Code
                    Toast.makeText(getApplicationContext(), "개인정보 수정페이지로 이동합니다!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UserInfoActivity.this, UserInfoChangeActivity.class);
                    startActivity(intent);
                }
            });
            // Btn - LogOut
            logoutBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (firebaseAuth.getCurrentUser() != null) { //만약 이미 로그인되어있다면
                        firebaseAuth.signOut(); // 로그아웃시킴
                        Toast.makeText(getApplicationContext(), "로그아웃이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(UserInfoActivity.this, MainActivity.class));
                        finish();
                    } else { //로그인 정보가 없는 경우
                        Toast.makeText(getApplicationContext(), "현재 로그인 정보가 없습니다!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
//            DeleteBtn.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // 팝업 창
//                    AlertDialog.Builder builder = new AlertDialog.Builder(UserInfoActivity.this);
//                    builder.setTitle("회원탈퇴");
//                    builder.setMessage("정말 회원을 탈퇴하시겠습니까?\n(확인 시 계정이 영구적으로 삭제됩니다)");
//                    builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            currentUser.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
//                                @Override
//                                public void onComplete(@NonNull Task<Void> task) {
//                                    // String 추출
//                                    String email_D = currentUser.getEmail();
//                                    int idx = email_D.indexOf("@");
//                                    final String email_OF = email_D.substring(0,idx);
//                                    // DB 해당 계정정보 삭제
//                                    mRootRef.child(email_OF).removeValue();
//                                    Toast.makeText(UserInfoActivity.this, "계정이 삭제 되었습니다.", Toast.LENGTH_LONG).show();
//                                    startActivity(new Intent(UserInfoActivity.this, MainActivity.class));
//                                    finish();
//                                }
//                            });
//                        }
//                    });
//                    builder.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            Toast.makeText(UserInfoActivity.this, "계정 삭제가 취소되었습니다.", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                    builder.setNeutralButton("취소",null);
//                    builder.create().show();
//                }
//            });
        }
        else{
            startActivity(new Intent(UserInfoActivity.this, MainActivity.class));
            finish();
        }
    } //onCreate END

    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(UserInfoActivity.this, MainActivity.class));
        finish();
    }

}
