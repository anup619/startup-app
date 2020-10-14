package com.example.startup_app.Core.Registration;

import android.app.Activity;

public interface RegistrationContract {

    interface View{
        void onRegistrationSuccess(String message);
        void onRegistrationFailure(String message);
    }

    interface Presenter{
        void registerStudent(Activity activity, String email, String password, String name, String phoneNumber, String grade);
        void registerTeacher(Activity activity, String email, String password, String name, String phoneNumber, String subjects);
    }

    interface Intractor{
        void performFirebaseStudentRegister(Activity activity, String email, String password, String name, String phoneNumber, String grade);
        void performFirebaseTeacherRegister(Activity activity, String email, String password, String name, String phoneNumber, String subjects);
    }

    interface onRegistrationListener{
        void onSuccess(String message);
        void onFailure(String message);
    }

}
