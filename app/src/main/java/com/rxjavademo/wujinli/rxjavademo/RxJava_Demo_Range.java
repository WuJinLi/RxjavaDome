package com.rxjavademo.wujinli.rxjavademo;

import rx.Observable;
import rx.functions.Action1;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :创建一个发射特定整数序列的Observable，默认不在任何特定的调度器上执行
 */

public class RxJava_Demo_Range {

    public static void main(String[] args) {

        Observable
                .range(2, 3)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.print(integer + ", ");
                    }
                });
    }
}
