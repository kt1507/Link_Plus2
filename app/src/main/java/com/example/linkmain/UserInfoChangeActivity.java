package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class UserInfoChangeActivity extends AppCompatActivity {
    private EditText change_name;
    private EditText change_number;
    private EditText change_ID;
    private EditText change_pw;
    private Button change_Save_btn;
    private Button change_cancel_btn;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private FirebaseUser user = firebaseAuth.getCurrentUser(); // User 정보 ;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_infomation_change);
        getSupportActionBar().hide();

        change_name = (EditText)findViewById(R.id.change_info_name);
        change_number = (EditText)findViewById(R.id.change_info_number);
        change_ID = (EditText)findViewById(R.id.change_info_id);
        change_pw = (EditText)findViewById(R.id.change_info_pw);
        change_Save_btn = (Button)findViewById(R.id.change_info_save);
        change_cancel_btn = (Button)findViewById(R.id.change_info_cancel);

        // 입력 정보 가져오기
        final String ID = change_ID.getText().toString();
        final String Password = change_pw.getText().toString();
        final String Name = change_name.getText().toString();
        final String Number = change_number.getText().toString();

        // Btn - Save Infomation to Database
        change_Save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code
                String email = user.getEmail();
                int idx = email.indexOf("@");
                String email_OF = email.substring(0,idx);

                Map<String,Object> taskMap = new HashMap<String, Object>();
                taskMap.put(email_OF+"/ID", change_ID.getText().toString());
                taskMap.put(email_OF+"/PassWord",change_pw.getText().toString());
                taskMap.put(email_OF+"/Name",change_name.getText().toString());
                taskMap.put(email_OF+"/Number",change_number.getText().toString());

                mRootRef.updateChildren(taskMap);

                Toast.makeText(getApplicationContext(), "개인정보 수정이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoChangeActivity.this, UserInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
        // Btn - Cancel Infomation to Database
        change_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "개인정보 수정을 취소합니다!\n개인정보 수정페이지로 다시 이동합니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoChangeActivity.this, UserInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
