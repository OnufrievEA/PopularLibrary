package com.geekbrains.mvc;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final List<Integer> mList;

    public Model() {
        mList = new ArrayList<>(3);
        mList.add(0);
        mList.add(0);
        mList.add(0);
    }

    public int getElementValueAtIndex(int index) {
        return mList.get(index);
    }

    public void setElementValueAtIndex(int index, int value) {
        mList.set(index, value);
    }
}
