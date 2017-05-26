package com.rxjavademo.wujinli.rxjavademo;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :重复
 * <p>
 * 创建一个发射特定数据重复多次的Observable，允许重复的发射某个数据序列，也可以限制重复的次数
 * <p>
 * Repeat不是创建一个Observable，而是重复发射原始Observable的数据序列，这个序列或者是无限的，或者通过repeat(n)指定重复次数
 * <p>
 * 默认在trampoline调度器上执行
 */

public class RxJava_Demo_Repeat {

    public static void main(String[] args) {
        repeatWhen();
    }

    /**
     * 无限重复
     */
    private static void withOutParameter() {
        Observable
                .just("hello")
                .repeat()
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    /**
     * 有次数的重复
     */
    public static void withParameter() {
        Observable.just("hello")
                .repeat(2)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }


    /**
     *
     */
    public static void repeatWhen() {
        Observable.range(2, 5)
                .repeatWhen(new Func1<Observable<? extends Void>, Observable<?>>() {
                    @Override
                    public Observable<?> call(Observable<? extends Void> observable) {
                        return observable.delay(1, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onCompleted() {
                        System.out.print("Completed");
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.print(e.getMessage());
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.print(integer + ", ");
                    }
                });

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
