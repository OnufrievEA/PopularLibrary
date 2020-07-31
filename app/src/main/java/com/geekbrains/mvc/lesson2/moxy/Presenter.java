package com.geekbrains.mvc.lesson2.moxy;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class Presenter extends MvpPresenter<MainView> {

    public void transferTextToTextView(String text) {
        getViewState().setResText(text);
    }
}
