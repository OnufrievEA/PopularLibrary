package com.geekbrains.mvc.lesson2.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MVVMViewModel extends ViewModel {

    public MutableLiveData<String> text = new MutableLiveData<>();

    public void changeText(String string) {
        text.setValue(string);
    }
}
