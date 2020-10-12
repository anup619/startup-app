package com.example.startup_app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.startup_app.Core.Login.LoginContract;
import com.example.startup_app.Core.Login.LoginPresenter;
import com.example.startup_app.R;

public class Login extends AppCompatActivity implements LoginContract.View, View.OnClickListener {

    Button signup_btn,login_go_btn;
    EditText editTextEmail,editTextPassword;
    private LoginPresenter mLoginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();

    }

    private void initViews() {

        Toast.makeText(getApplicationContext(), "Internet Required" , Toast.LENGTH_SHORT).show();
        login_go_btn = (Button)findViewById(R.id.btnLogin);
        login_go_btn.setOnClickListener(this);
        signup_btn = (Button) findViewById(R.id.btnSignUp);
        signup_btn.setOnClickListener(this);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        mLoginPresenter = new LoginPresenter(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                checkLoginDetails();
                break;
            case R.id.btnSignUp:
                moveToRegisterActivity();
                break;
        }
    }

    private void moveToRegisterActivity() {
        Intent intent = new Intent(getApplicationContext(), SignUpAs.class);
        startActivity(intent);
    }

    private void checkLoginDetails() {
        if(!TextUtils.isEmpty(editTextEmail.getText().toString()) && !TextUtils.isEmpty(editTextPassword.getText().toString())){
            initLogin(editTextEmail.getText().toString(), editTextPassword.getText().toString());
        }else{
            if(TextUtils.isEmpty(editTextEmail.getText().toString())){
                editTextEmail.setError("Please enter a valid email");
            }if(TextUtils.isEmpty(editTextPassword.getText().toString())){
                editTextPassword.setError("Please enter password");
            }
        }
    }

    private void initLogin(String email, String password) {
        mLoginPresenter.login(this, email, password);
    }



    @Override
    public void onLoginSuccess(String message) {
        Log.d("TAG","task.getResult().toString()");
        Toast.makeText(getApplicationContext(), "Successfully Logged in" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginFailure(String message) {
        Toast.makeText(getApplicationContext(),message , Toast.LENGTH_SHORT).show();
    }
}