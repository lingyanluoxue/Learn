package com.lylx.learn.ClassLoaderTest;

/**
 * 执行顺序：
 * 1. 父类静态资源
 * 2. 子类静态资源
 * 3. 父类非静态资源
 * 4. 父类构造函数
 * 5. 子类非静态资源
 * 6. 子类构造函数
 */
public class Student extends Person {
    private static int num = 20;
    private String school;

    {
        school = "大学";
        System.out.println("子类构造代码块：" + school);
    }

    static {
        System.out.println("子类静态代码块");
    }

    public Student() {
        System.out.println("子类无参构造函数");
    }

    public Student(String name, int age) {
        super(name, age);
        System.out.println("子类有参构造函数");
    }

    public static void main(String[] args) {
        Person p1 = new Student();
        System.out.println("----------");
        Person p2 = new Student("张三",40);

//        父类构造代码块：age = 0
//        父类无参构造函数：age = 0
//        父类静态代码块：n = 10
//        子类静态代码块
//        父类构造代码块：age = 10
//        父类无参构造函数：age = 10
//        子类构造代码块：大学
//        子类无参构造函数
//        ----------
//        父类构造代码块：age = 11
//        父类有参构造函数：age = 40
//        子类构造代码块：大学
//        子类有参构造函数
    }
}
