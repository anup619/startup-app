package com.example.startup_app.Core.Registration;

import android.app.Activity;

public class RegistrationPresenter implements RegistrationContract.Presenter, RegistrationContract.onRegistrationListener {

    private RegistrationContract.View mRegisterView;
    private RegistrationInteractor mRegisterInteractor;

    public RegistrationPresenter(RegistrationContract.View mRegisterView) {
        this.mRegisterView = mRegisterView;
        mRegisterInteractor = new RegistrationInteractor(this);
    }

    @Override
    public void registerStudent(Activity activity, String email, String password, String name, String phoneNumber, String grade) {
        mRegisterInteractor.performFirebaseStudentRegister(activity, email, password, name, phoneNumber, grade);
    }

    @Override
    public void registerTeacher(Activity activity, String email, String password, String name, String phoneNumber, String subjects) {
        mRegisterInteractor.performFirebaseTeacherRegister(activity, email, password, name, phoneNumber, subjects);
    }

    @Override
    public void onSuccess(String message) {
        mRegisterView.onRegistrationSuccess(message);
    }

    @Override
    public void onFailure(String message) {
        mRegisterView.onRegistrationFailure(message);
    }
}
