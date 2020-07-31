package com.geekbrains.mvc.lesson1;

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
        switch (buttonIndex) {
            case FIRST:
                newModelValue = calcNewModelValue(0);
                mModel.setElementValueAtIndex(0, newModelValue);
                mView.setFirstButtonText(ButtonIndex.FIRST, newModelValue);
                break;
            case SECOND:
                newModelValue = calcNewModelValue(1);
                mModel.setElementValueAtIndex(1, newModelValue);
                mView.setSecondButtonText(ButtonIndex.SECOND, newModelValue);
                break;
            case THIRD:
                newModelValue = calcNewModelValue(2);
                mModel.setElementValueAtIndex(2, newModelValue);
                mView.setThirdButtonText(ButtonIndex.THIRD, newModelValue);
                break;
        }
    }
}
