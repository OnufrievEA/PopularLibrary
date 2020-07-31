package com.geekbrains.mvc.lesson1;

public interface MainView {
    void setFirstButtonText(Presenter.ButtonIndex btnIndex, int value);

    void setSecondButtonText(Presenter.ButtonIndex btnIndex, int value);

    void setThirdButtonText(Presenter.ButtonIndex btnIndex, int value);
}
