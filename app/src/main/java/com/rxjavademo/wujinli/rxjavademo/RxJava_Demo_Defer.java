package com.rxjavademo.wujinli.rxjavademo;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :直到有观察者订阅时才创建Observable，然后使用Observable工厂方法为每个观察者创建一个新的Observable，
 *         对每个观察者都是这样，每个订阅者都以为自己订阅的是同一个Observable，但实际每个订阅者获取的是它们自己的单独的数据序列
 */

public class RxJava_Demo_Defer {

    public static void main(String[] args) {
        Observable.defer(new Func0<Observable<Integer>>() {
            @Override
            public Observable<Integer> call() {
                return Observable.just(1, 2, 3);
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                System.out.print(integer + ",");
            }
        });
    }
}
