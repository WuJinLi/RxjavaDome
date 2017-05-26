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
//        xHello();
        create();
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

    public static void create() {
        /**
         * 建议在传递给create方法的函数中检查观察者的isUnsubscribed状态，以便在没有观察者的时候，
         * 让Observable停止发射数据或者做昂贵的运算
         */
        Observable
                .create(new Observable.OnSubscribe<Integer>() {

                    @Override
                    public void call(Subscriber<? super Integer> subscriber) {
                        try {
                            if (!subscriber.isUnsubscribed()) {
                                for (int i = 0; i < 5; i++) {
                                    subscriber.onNext(i);
                                }
                            }
                            subscriber.onCompleted();
                        } catch (Exception e) {
                            subscriber.onError(e);
                        }

                    }
                })
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.println("Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println(integer + ",");
                    }
                });
    }
}
