package com.rxjavademo.wujinli.rxjavademo;

import java.text.SimpleDateFormat;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  :  map()就是对象的变换。
 * 对于Observer只是希望它来响应事件,并不希望参与更改事件。
 * 例如代码打印出了当前时间2016-08-05 10:53:38。假设这样一个场景nowTime()是一个第三库中的方法，
 * 返回的对象结果本身不能直接修改，如果想要在时间前加上几个汉字来说明一下，就可以用到操作符map。
 * 在上面的代码中加入一个rxMap()方法
 * <p>
 * map是一对一的变换
 */

public class RxJava_Demo_Map {
    public static void main(String[] args) {
        xMap();
    }


    public static String nowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(System.currentTimeMillis());
    }


    public static void xMap() {
        Observable.just(nowTime())
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return "北京时间" + s;
                    }
                })
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }
}
