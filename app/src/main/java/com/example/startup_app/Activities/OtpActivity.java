package com.example.startup_app.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.startup_app.R;
import com.google.firebase.auth.FirebaseAuth;

public class OtpActivity extends AppCompatActivity {

    EditText edtTextPhone,edtTextOtp;
    Button verifyBtn,generateOtpBtn;
    FirebaseAuth PhoneAuth;
    private String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_activity);
        edtTextOtp = findViewById(R.id.editTextOtp);
        edtTextPhone = findViewById(R.id.editTextPhoneNumber);
        verifyBtn = findViewById(R.id.btnVerify);
        generateOtpBtn = findViewById(R.id.btnGenOtp);




    }
}