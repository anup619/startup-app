package com.example.startup_app.Core.Registration;

import android.app.Activity;

public interface RegistrationContract {

    interface View{
        void onRegistrationSuccess(String message);
        void onRegistrationFailure(String message);
    }

    interface Presenter{
        void register(Activity activity, String email, String password, String name, String phoneNumber, String grade);
    }

    interface Intractor{
        void performFirebaseRegister(Activity activity, String email, String password, String name, String phoneNumber, String grade);
    }

    interface onRegistrationListener{
        void onSuccess(String message);
        void onFailure(String message);
    }

}
