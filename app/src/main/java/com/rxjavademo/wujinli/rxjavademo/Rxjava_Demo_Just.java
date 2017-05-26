package com.rxjavademo.wujinli.rxjavademo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.functions.Action1;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  :just(T...)是一个快捷创建队列的方法。但这代码依然有点多，onCompleted()和onError(Throwable e)，
 * 只是打印一下字符串并不需要用到这两个方法。而且Observable不能每次发送一个事件都要重写3个回调方法，
 * 这样多余代码太多。
 * <p>
 * just将单个数据转换为发射那个数据的Observable， 数据是原样发出 ，数组与Iterable整个对象则当作单个数据发出
 */

public class Rxjava_Demo_Just {
    public static void main(String[] args) {
//        xHello1();
//        ex_arr();
        ex_list();
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

    /**
     * 单独的对象
     */
    public static void ex_simpleObject() {
        System.out.print("单个对象：");
        Observable
                .just("haha")
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }


    /**
     * 集合
     */

    public static void ex_list() {
        System.out.print("集合list：");
        final List<String> list = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            list.add(i + "");
        }

        Observable
                .just(list)
                .subscribe(new Action1<List<String>>() {
                    @Override
                    public void call(List<String> strings) {
                        for (String str : strings) {
                            System.out.println(str);
                        }
                    }
                });
    }


    /**
     * 数组
     */

    public static void ex_arr() {
        System.out.print("数组arr：");
        int[] arr = {1, 2, 3};

        Observable
                .just(arr)
                .subscribe(new Action1<int[]>() {
                    @Override
                    public void call(int[] ints) {
                        for (int i : ints) {
                            System.out.println(i + "");
                        }
                    }
                });
    }
}
