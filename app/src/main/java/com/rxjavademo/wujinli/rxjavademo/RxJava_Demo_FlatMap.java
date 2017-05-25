package com.rxjavademo.wujinli.rxjavademo;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  :latMap() 和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。
 * 但需要注意，和 map() 不同的是， flatMap() 中返回的是个 Observable 对象，
 * 并且这个 Observable 对象并不是被直接发送到了 Subscriber 的回调方法中。
 * <p>
 * flatMap() 的原理是这样的：
 * 使用传入的事件对象创建一个 Observable 对象；
 * 并不发送这个 Observable, 而是将它激活，于是它开始发送事件；
 * 每一个创建出来的 Observable 发送的事件，都被汇入同一个 Observable ，
 * 而这个 Observable 负责将这些事件统一交给 Subscriber 的回调方法。这三个步骤，把事件拆成了两级，通过一组新创建的
 * Observable将初始的对象『铺平』之后通过统一路径分发了下去。而这个『铺平』就是 flatMap() 所谓的 flat。
 */

public class RxJava_Demo_FlatMap {
    private static List<Student> list = new ArrayList<>();

    public static void main(String[] args) {
        addData();
        showScore();
    }


    private static void showScore() {
        Observable.from(list)
                .filter(new Func1<Student, Boolean>() {
                    @Override
                    public Boolean call(Student student) {
                        return student.getId() == 102;
                    }
                })
                .flatMap(new Func1<Student, Observable<Student.Course>>() {
                    @Override
                    public Observable<Student.Course> call(Student student) {
                        return Observable.from(student.getCourses());
                    }
                })
                .subscribe(new Action1<Student.Course>() {
                    @Override
                    public void call(Student.Course course) {
                        System.out.println(course.getCourse_name() + ":" + course.getCourse_sorce
                                ());
                    }
                });
    }


    private static void addData() {
        Student s_1 = new Student();

        s_1.setName("张三");
        s_1.setId(101);

        List<Student.Course> list1 = new ArrayList<>();
        list1.add(new Student.Course("语文", 90));
        list1.add(new Student.Course("数学", 100));

        s_1.setCourses(list1);


        Student s_2 = new Student();
        s_2.setName("李四");
        s_2.setId(102);

        List<Student.Course> list2 = new ArrayList<>();
        list2.add(new Student.Course("语文", 96));
        list2.add(new Student.Course("数学", 97));

        s_2.setCourses(list2);

        list.add(s_1);
        list.add(s_2);
    }
}
