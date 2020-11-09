package com.example.startup_app.Activity.ui.MainMenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainMenuViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MainMenuViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Main Menu fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}