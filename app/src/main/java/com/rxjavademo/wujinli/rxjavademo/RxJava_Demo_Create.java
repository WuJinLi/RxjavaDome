package com.rxjavademo.wujinli.rxjavademo;



import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * author: WuJinLi
 * time  : 17/5/23
 * desc  :
 */

public class RxJava_Demo_Create {

    public static void main(String[] args) {
        xHello();
    }


    public static void xHello() {
        /**
         * 观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String str) {
                System.out.println(str);
            }
        };

        /**
         * 被观察者
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("helloword1");
                subscriber.onNext("helloword2");
                subscriber.onNext("helloword3");
            }
        });


        observable.subscribe(observer);
    }
}
