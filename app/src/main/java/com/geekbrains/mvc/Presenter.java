package com.geekbrains.mvc;

public class Presenter {

    public enum ButtonIndex {FIRST, SECOND, THIRD}

    private final Model mModel;
    private final MainView mView;

    public Presenter(MainView mainView) {
        mModel = new Model();
        mView = mainView;
    }

    private int calcNewModelValue(int modelElementIndex) {
        int currentValue = mModel.getElementValueAtIndex(modelElementIndex);
        return currentValue + 1;
    }

    public void buttonClick(ButtonIndex buttonIndex) {
        int newModelValue;
        newModelValue = calcNewModelValue(buttonIndex.ordinal());
        mModel.setElementValueAtIndex(buttonIndex.ordinal(), newModelValue);
        mView.setButtonText(buttonIndex, newModelValue);
    }
}
