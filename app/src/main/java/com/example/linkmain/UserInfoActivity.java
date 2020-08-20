package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInfoActivity extends AppCompatActivity {
    private EditText infoName;
    private Button infoSave;
    private Button infoCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_infomation);
        getSupportActionBar().hide();

        final DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference(); // Database 연동

        infoName = (EditText)findViewById(R.id.info_name);
        infoSave = (Button)findViewById(R.id.info_save);
        infoCancel = (Button)findViewById(R.id.info_cancel);


        // Btn - Save Infomation to Database
        infoSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code
            }
        });

        // Btn - Cancel Infomation to Database
        infoCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Active Code
            }
        });

    }

}
