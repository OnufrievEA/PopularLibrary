package com.geekbrains.mvc.lesson2.mvvm;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.geekbrains.mvc.R;


public class MainActivity extends AppCompatActivity {

    private MVVMViewModel viewModel;

    private EditText editText;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        viewModel = new ViewModelProvider(this).get(MVVMViewModel.class);

        viewModel.text.observe(this, data -> {
            textView.setText(data);
        });

        editText = findViewById(R.id.et);
        textView = findViewById(R.id.tv);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                viewModel.changeText(String.valueOf(charSequence));
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

}