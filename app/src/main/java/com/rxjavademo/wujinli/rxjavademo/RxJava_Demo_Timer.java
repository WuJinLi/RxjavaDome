package com.rxjavademo.wujinli.rxjavademo;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :创建出一个Obaservable后，在给定的延迟时间时，发送一个0
 */

public class RxJava_Demo_Timer {
    public static void main(String[] args) {
        Observable
                .timer(10, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.println(aLong);
                    }
                });

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 由于默认在computation调度器上执行，并不是在main()主线程，所以给main()设置了20毫秒的延迟。
     * 如果timer(0,)，设置延迟为0，main()就不需要sleep()
     */
}
