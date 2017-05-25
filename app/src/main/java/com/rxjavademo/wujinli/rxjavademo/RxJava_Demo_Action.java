package com.rxjavademo.wujinli.rxjavademo;

import java.text.SimpleDateFormat;

import rx.Observable;
import rx.functions.Action1;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  :  Action0和Action1
 * 共同点：都是接口，都只有一个方法，都没有返回值
 * 不同点：Action0内的方法是call()，Action1内的方法是call(T t)。Action1有形参而Action0没有。
 * <p>
 * 有些时候只关心执行onNext()，并不考虑onCompleted()和onError(Throwable e)，就可以使用Action1。
 * Action0就可以理解为是执行onCompleted()。
 */

public class RxJava_Demo_Action {
    public static void main(String[] args) {
        xAction1();
    }


    public static String nowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(System.currentTimeMillis());
    }


    public static void xAction1() {
        Observable
                .just(nowTime())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                });
    }

    /**
     * Action0就可以理解为是执行onCompleted()。这里引用一下扔物线大神的博客来进行说明
     *
     *
     *
     * Action1<String> onNextAction = new Action1<String>() {
     // onNext()
     @Override public void call(String s) {
     Log.d(tag, s);
     }
     };
     Action1<Throwable> onErrorAction = new Action1<Throwable>() {
     // onError()
     @Override public void call(Throwable throwable) {
     // Error handling
     }
     };
     Action0 onCompletedAction = new Action0() {
     // onCompleted()
     @Override public void call() {
     Log.d(tag, "completed");
     }
     };
     // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
     observable.subscribe(onNextAction);
     // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
     observable.subscribe(onNextAction, onErrorAction);
     // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、
     onError() 和 onCompleted()
     observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
     */


}
