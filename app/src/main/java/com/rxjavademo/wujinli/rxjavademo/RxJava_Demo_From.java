package com.rxjavademo.wujinli.rxjavademo;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * author: WuJinLi
 * time  : 17/5/25
 * desc  :将其他类型的对象和数据类型转换为Observable，默认不在任何特定的调度器上执行
 */

public class RxJava_Demo_From {

    public static void main(String[] args) {
        System.out.println("Integer [] arrays:");
        arrays();
        System.out.println("List集合：");
        iterable();
        System.out.println("Future：");
        future();
    }

    private static void arrays() {
        Integer[] arr = {1, 2, 3, 4, 5};

        Observable
                .from(arr)
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.print(integer + ",");
                    }
                });
    }

    private static void iterable() {
        Observable.from(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8))
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer integer) {
                        System.out.print(integer + ",");
                    }
                });
    }

    private static void future() {
        //线程池对象
        ExecutorService executorService = Executors.newCachedThreadPool();

        //submit，产生 Future 对象
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                double d = Math.PI + (Math.random() * 10);
                TimeUnit.SECONDS.sleep(1);//模拟耗时操作，可以改为1查看结果
                return "Future -- > " + d;
            }
        });

        //关闭线程池
        executorService.shutdown();

        Observable.from(future, 2, TimeUnit.SECONDS)
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        System.out.println(s);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }, new Action0() {
                    @Override
                    public void call() {
                        System.out.println("终止");
                    }
                });
    }


}
