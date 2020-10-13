package com.example.startup_app.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.startup_app.Core.Registration.RegistrationContract;
import com.example.startup_app.Core.Registration.RegistrationPresenter;
import com.example.startup_app.R;

public class Student_registration extends AppCompatActivity implements RegistrationContract.View {

    EditText students_name, students_email, students_password, students_phno;
    Button done, choose_class;
    String Class;
    private RegistrationPresenter mRegistrationPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_registration);
        initViews();

    }

    private void initViews() {

        students_name = findViewById(R.id.Student_name);
        students_email = findViewById(R.id.editTextSignUpEmail);
        students_password = findViewById(R.id.editTextSignUpPassword);
        students_phno = findViewById(R.id.Students_phno);
        done = findViewById(R.id.btnSignUp);
        choose_class = findViewById(R.id.Choose_class);

        choose_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = showChooseClassDialog();
            }
        });

        mRegistrationPresenter = new RegistrationPresenter(this);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateDetails();
            }
        });

    }

    public String showChooseClassDialog() {
        AlertDialog.Builder chosseClassDialog;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            chosseClassDialog = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            chosseClassDialog = new AlertDialog.Builder(this);
        }

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.choose_class, null);

        chosseClassDialog.setView(view);
        chosseClassDialog.setCancelable(false);
        final AlertDialog dialog = chosseClassDialog.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        Button class_5th, class_6th, class_7th, class_8th, class_9th, class_10th;
        class_5th = view.findViewById(R.id.Class_5th);
        class_6th = view.findViewById(R.id.Class_6th);
        class_7th = view.findViewById(R.id.Class_7th);
        class_8th = view.findViewById(R.id.Class_8th);
        class_9th = view.findViewById(R.id.Class_9th);
        class_10th = view.findViewById(R.id.Class_10th);

        class_5th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 5th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        class_6th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 6th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        class_7th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 7th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        class_8th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 8th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        class_9th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 9th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        class_10th.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = "Class 10th";
                dialog.dismiss();
                choose_class.setText(Class);
            }
        });
        return Class;
    }

//    @Override
//    public void onClick(View view) {
//        Log.d("TAG",Integer.toString(view.getId()));
//        switch (view.getId()) {
//            case R.id.btnSignUp:
//                Log.d("TAG","HEY");
//                validateDetails();
//                break;
//        }
//    }

    @Override
    public void onRegistrationSuccess(String message) {
        Log.d("TAG","task.getResult().toString()");
        Toast.makeText(getApplicationContext(), "Successfully Registered" , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRegistrationFailure(String message) {
        Toast.makeText(getApplicationContext(),message , Toast.LENGTH_SHORT).show();
    }

    private void validateDetails() {
        if(TextUtils.isEmpty(students_email.getText().toString())){
            students_email.setError("Email cannot be empty");
        }else if(TextUtils.isEmpty(students_password.getText().toString())){
            students_password.setError("Password cannot be empty");
        }else if(TextUtils.isEmpty(students_name.getText().toString())){
            students_name.setError("name cannot be empty");
        }else if(TextUtils.isEmpty(students_phno.getText().toString())){
            students_phno.setError("Phone Number cannot be empty");
        }else if(TextUtils.equals(choose_class.getText().toString(),"Choose Class")){
            choose_class.setError("Select your class");
        }else{
            initRegistration(students_email.getText().toString(), students_password.getText().toString(), students_name.getText().toString(), students_phno.getText().toString(), choose_class.getText().toString());
        }
    }

    private void initRegistration(String email, String password, String name, String phoneNumber, String grade) {
        mRegistrationPresenter.register(this,email,password,name,phoneNumber,grade);
        startActivity(new Intent(Student_registration.this,Login.class));
    }

}


