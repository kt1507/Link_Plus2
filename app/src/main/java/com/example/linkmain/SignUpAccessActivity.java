package com.example.linkmain;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpAccessActivity extends AppCompatActivity {

    private Button NormalUser;
    private Button MasterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_03_signup_01);
        getSupportActionBar().hide();

        NormalUser = (Button)findViewById(R.id.signup_access_normal);
        MasterUser = (Button)findViewById(R.id.signup_access_master);

        // Btn - Info
        NormalUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpAccessActivity.this, SignUpActivity.class));
                finish();
            }
        });

        MasterUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpAccessActivity.this, MasterSignUpActivity.class));
                finish();
            }
        });
    }
}
