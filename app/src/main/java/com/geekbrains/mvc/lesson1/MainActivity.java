package com.geekbrains.mvc.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.geekbrains.mvc.R;

public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {

    /**
     * Android Views
     **/
    private TextView tv1;
    private Button btnCounter1;
    private TextView tv2;
    private Button btnCounter2;
    private TextView tv3;
    private Button btnCounter3;

    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        btnCounter1 = findViewById(R.id.btnCounter1);
        tv2 = findViewById(R.id.tv2);
        btnCounter2 = findViewById(R.id.btnCounter2);
        tv3 = findViewById(R.id.tv3);
        btnCounter3 = findViewById(R.id.btnCounter3);

        btnCounter1.setOnClickListener(this);
        btnCounter2.setOnClickListener(this);
        btnCounter3.setOnClickListener(this);

        mPresenter = new Presenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCounter1:
                mPresenter.buttonClick(Presenter.ButtonIndex.FIRST);
                break;
            case R.id.btnCounter2:
                mPresenter.buttonClick(Presenter.ButtonIndex.SECOND);
                break;
            case R.id.btnCounter3:
                mPresenter.buttonClick(Presenter.ButtonIndex.THIRD);
                break;
        }
    }

    @Override
    public void setFirstButtonText(Presenter.ButtonIndex btnIndex, int value) {
        btnCounter1.setText("Количество = " + value);
    }

    @Override
    public void setSecondButtonText(Presenter.ButtonIndex btnIndex, int value) {
        btnCounter2.setText("Количество = " + value);
    }

    @Override
    public void setThirdButtonText(Presenter.ButtonIndex btnIndex, int value) {
        btnCounter3.setText("Количество = " + value);
    }
}
