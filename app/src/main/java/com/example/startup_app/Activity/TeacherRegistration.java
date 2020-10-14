package com.example.startup_app.Activity;

import android.content.DialogInterface;
import android.mtp.MtpConstants;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.startup_app.R;

public class TeacherRegistration extends AppCompatActivity {
    EditText teachers_name, teachers_email, teachers_password, teachers_phno;
    Button done, choose_subject,ok,cancel;
    Boolean Maths,Science,English,all;
    CheckBox subject_maths,subject_science,subject_english,subject_all;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_registration);
        teachers_name = findViewById(R.id.Teacher_name);
        teachers_email = findViewById(R.id.Teacher_email);
        teachers_password = findViewById(R.id.Teacher_password);
        teachers_phno = findViewById(R.id.Teacher_phno);
        done = findViewById(R.id.Teacher_done);
        choose_subject = findViewById(R.id.Choose_Subjects);

        choose_subject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChooseSubjectDialog();
            }
        });

    }

    private void ChooseSubjectDialog() {
        AlertDialog.Builder chooseSubjectDialog;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            chooseSubjectDialog = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            chooseSubjectDialog = new AlertDialog.Builder(this);
        }

        LayoutInflater inflater = getLayoutInflater();

        View view = inflater.inflate(R.layout.choose_subject, null);

        chooseSubjectDialog.setView(view);
        chooseSubjectDialog.setCancelable(false);

        subject_maths = view.findViewById(R.id.Subject_Maths);
        subject_english = view.findViewById(R.id.Subject_English);
        subject_science = view.findViewById(R.id.Subject_Science);
        subject_all = view.findViewById(R.id.Subject_ALL);
        ok = view.findViewById(R.id.Choose_Subjects_ok);
        cancel = view.findViewById(R.id.Choose_Subjects_cancel);

        final AlertDialog dialog = chooseSubjectDialog.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        subject_maths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subject_maths.isChecked()) {
                    Maths = Boolean.TRUE;
                }
            }
        });
        subject_english.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subject_english.isChecked()) {
                    English = Boolean.TRUE;
                }
            }
        });
        subject_science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subject_science.isChecked()) {
                    Science = Boolean.TRUE;
                }
            }
        });
        subject_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (subject_all.isChecked()) {
                    all = Boolean.TRUE;
                    Maths = Boolean.FALSE;
                    English = Boolean.FALSE;
                    Science = Boolean.FALSE;
                    subject_science.setChecked(false);
                    subject_english.setChecked(false);
                    subject_maths.setChecked(false);
                }
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(subject_all.isChecked()==false){
                    if(subject_english.isChecked() && (subject_science.isChecked()==false && subject_maths.isChecked()==false)){
                        choose_subject.setText("English");
                    }
                    else if(subject_maths.isChecked() && (subject_science.isChecked()==false && subject_english.isChecked()==false)){
                        choose_subject.setText("Maths");
                    }
                    else if(subject_science.isChecked() && (subject_english.isChecked()==false && subject_maths.isChecked()==false)) {
                        choose_subject.setText("Science");
                    }
                    else if(subject_english.isChecked() && subject_maths.isChecked() && (subject_science.isChecked()==false)){
                        choose_subject.setText("English, Maths");
                    }
                    else if(subject_english.isChecked() && subject_science.isChecked() && (subject_maths.isChecked()==false)){
                        choose_subject.setText("English, Science");
                    }
                    else if(subject_maths.isChecked() && subject_science.isChecked() && (subject_english.isChecked()==false)){
                        choose_subject.setText("Maths, Science");
                    }
                    else if (subject_maths.isChecked() && subject_science.isChecked() && subject_english.isChecked()){
                        choose_subject.setText("All");
                    }

                }else {
                    choose_subject.setText("All");
                }
                dialog.dismiss();
            }

        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
