package com.example.linkmain;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class UserInfoChangeActivity extends AppCompatActivity {
    private EditText change_name;
    private EditText change_number;
//    private EditText change_ID;
    private EditText change_pw;
    private ImageButton change_Save_btn;
//    private Button change_cancel_btn;
    private ImageButton DeleteBtn;

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(); // firebase 연동;
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동
    private FirebaseUser currentUser = firebaseAuth.getCurrentUser();; // 현재 유져

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_05_information_change);
//        getSupportActionBar().hide();

        change_name = (EditText)findViewById(R.id.change_info_name);
        change_number = (EditText)findViewById(R.id.change_info_number);
//        change_ID = (EditText)findViewById(R.id.change_info_id);
        change_pw = (EditText)findViewById(R.id.change_info_pw);
        change_Save_btn = (ImageButton)findViewById(R.id.change_info_save);
//        change_cancel_btn = (Button)findViewById(R.id.change_info_cancel);
//        DeleteBtn = (ImageButton) findViewById(R.id.Delete_Btn); // Delete Btn

        // 입력 정보 가져오기
//        final String ID = change_ID.getText().toString();
        final String Password = change_pw.getText().toString();
        final String Name = change_name.getText().toString();
        final String Number = change_number.getText().toString();

        // Btn - Save Infomation to Database
        change_Save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code
                String email = currentUser.getEmail();
                int idx = email.indexOf("@");
                String email_OF = email.substring(0,idx);

                Map<String,Object> taskMap = new HashMap<String, Object>();
//                taskMap.put(email_OF+"/ID", change_ID.getText().toString());
                if(change_pw.getText().toString().length() != 0){
                    taskMap.put("/UserInfo/" + email_OF + "/PassWord", change_pw.getText().toString());
                    // FirebaseAuth Password 변경
                    currentUser.updatePassword(change_pw.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(getApplicationContext(), "Password 수정 완료!", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                if(change_name.getText().toString().length() != 0) {
                    taskMap.put("/UserInfo/"+ email_OF + "/Name", change_name.getText().toString());
                }
                if(change_number.getText().toString().length() != 0) {
                    taskMap.put("/UserInfo/"+ email_OF + "/Number", change_number.getText().toString());
                }
                mRootRef.updateChildren(taskMap);

                Toast.makeText(getApplicationContext(), "개인정보 수정이 성공적으로 완료되었습니다!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(UserInfoChangeActivity.this, UserInfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(UserInfoChangeActivity.this, UserInfoActivity.class));
        finish();
    }

}
