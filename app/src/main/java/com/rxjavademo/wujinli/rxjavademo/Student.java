package com.rxjavademo.wujinli.rxjavademo;

import java.util.List;

/**
 * author: WuJinLi
 * time  : 17/5/24
 * desc  : 创建学生类
 */

public class Student {
    private String name;
    private int id;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    private List<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Course {
        private String course_name;
        private int course_sorce;


        public Course(String course_name, int course_sorce) {
            this.course_name = course_name;
            this.course_sorce = course_sorce;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public int getCourse_sorce() {
            return course_sorce;
        }

        public void setCourse_sorce(int course_sorce) {
            this.course_sorce = course_sorce;
        }
    }

}
