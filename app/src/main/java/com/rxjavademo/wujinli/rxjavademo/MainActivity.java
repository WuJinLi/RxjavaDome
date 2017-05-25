package com.rxjavademo.wujinli.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_start;
    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void setListener() {
        btn_start.setOnClickListener(this);
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        tv_show = (TextView) findViewById(R.id.tv_show);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                xHello();
                break;
            default:
                break;
        }
    }

    public void xHello() {
        //观察者
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                tv_show.setText(s);
            }
        };

        //被观察者
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("helloword0");
                subscriber.onNext("helloword1");
                subscriber.onNext("helloword2");
                subscriber.onNext("helloword3");
                subscriber.onNext("helloword4");
                subscriber.onNext("helloword5");
                subscriber.onNext("helloword6");
            }
        });

        //订阅
        observable.subscribe(observer);
    }
}
