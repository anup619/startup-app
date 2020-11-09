package com.example.startup_app.Activity.ui.MyCourses;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyCoursesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MyCoursesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is My Courses fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}