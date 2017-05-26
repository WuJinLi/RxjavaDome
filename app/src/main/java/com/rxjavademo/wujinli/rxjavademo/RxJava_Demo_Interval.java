package com.rxjavademo.wujinli.rxjavademo;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :间隔
 * <p>
 * //固定间隔 发射从0开始的整数序列
 * Observable<Long> interval(long interval, TimeUnit unit)
 * <p>
 * //有延迟时间，然后根据固定间隔 发射从0开始的整数序列
 * Observable<Long> interval(long initialDelay, long period, TimeUnit unit)
 */

public class RxJava_Demo_Interval {
    public static void main(String[] args) {
//        infinite();
        period();
    }

    /**
     * 当前线程， 延迟1秒后，间隔为2s，发送一个从0开始的整数序列
     */
    private static void period() {
        Observable
                .interval(1, 2, TimeUnit.SECONDS, Schedulers.immediate())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.print(aLong);
                    }
                });
    }

    /**
     * 当前线程，间隔为500毫米，无限发送一个从0开始的整数序列
     */
    private static void infinite() {
        Observable
                .interval(500, TimeUnit.MILLISECONDS, Schedulers.immediate())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.print(aLong);
                    }
                });
    }
}
