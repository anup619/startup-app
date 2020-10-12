package com.example.startup_app.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.startup_app.R;

public class SignUpAs extends AppCompatActivity {

    LinearLayout teacher,student;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_as);
        teacher = findViewById(R.id.Teacher_layout);
        student = findViewById(R.id.Student_layout);
        final int bg_color = ContextCompat.getColor(this, R.color.colorPurple300);
        teacher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                teacher.setBackgroundColor(bg_color);
                return false;
            }
        });
        student.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                student.setBackgroundColor(bg_color);
                return false;
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpAs.this, Student_registeration.class);
                startActivity(intent);
                finish();
            }
        });
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpAs.this, Student_registeration.class);
                startActivity(intent);
                finish();
            }
        });
    }
}