package com.rxjavademo.wujinli.rxjavademo;

import rx.Observable;
import rx.Observer;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  :just(T...)是一个快捷创建队列的方法。但这代码依然有点多，onCompleted()和onError(Throwable e)，
 * 只是打印一下字符串并不需要用到这两个方法。而且Observable不能每次发送一个事件都要重写3个回调方法，
 * 这样多余代码太多。
 */

public class Rxjava_Demo_Just {
    public static void main(String[] args) {
        xHello1();
    }


    public static void xHello1() {
        Observable
                .just("hellword1", "helloword2", "helloword3")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        System.out.println(s);
                    }
                });
    }
}
