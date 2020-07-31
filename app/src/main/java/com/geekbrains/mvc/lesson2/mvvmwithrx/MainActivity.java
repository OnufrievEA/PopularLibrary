package com.geekbrains.mvc.lesson2.mvvmwithrx;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.geekbrains.mvc.R;
import com.geekbrains.mvc.lesson2.mvvm.MVVMViewModel;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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

        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                TextWatcher watcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if (!emitter.isDisposed()) { //если еще не отписались
                            emitter.onNext(String.valueOf(charSequence)); //отправляем текущее состояние
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {
                    }
                };
                editText.addTextChangedListener(watcher);
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(String s) {
                viewModel.changeText(s);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });

    }
}