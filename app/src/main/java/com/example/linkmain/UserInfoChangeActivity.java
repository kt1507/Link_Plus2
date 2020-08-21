package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoChangeActivity extends AppCompatActivity {
    private EditText change_name;
    private EditText change_number;
    private EditText change_ID;
    private EditText change_pw;
    private Button change_Save_btn;
    private Button change_cancel_btn;

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


        // Btn - Save Infomation to Database
        change_Save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code

            }
        });
        // Btn - Cancel Infomation to Database
        change_cancel_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code

            }
        });
    }
}
