package com.example.startup_app.Activities;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.startup_app.R;

public class Student_registeration extends AppCompatActivity {

    EditText students_name,students_email,students_password,students_phno;
    Button done,choose_class;
    String Class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_regestration);
        students_name = findViewById(R.id.Student_name);
        students_email = findViewById(R.id.Student_email);
        students_password = findViewById(R.id.Student_password);
        students_phno = findViewById(R.id.Students_phno);
        done = findViewById(R.id.Stduent_Done);
        choose_class = findViewById(R.id.Choose_class);

        choose_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = showChooseClassDialog();
            }
        });
    }

    public String showChooseClassDialog() {
        AlertDialog.Builder chosseClassDialog;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            chosseClassDialog = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        }
        else{
            chosseClassDialog = new AlertDialog.Builder(this);
        }

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.choose_class,null);

        chosseClassDialog.setView(view);
        chosseClassDialog.setCancelable(false);
        final  AlertDialog dialog = chosseClassDialog.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        Button class_5th,class_6th,class_7th,class_8th,class_9th,class_10th;
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
}