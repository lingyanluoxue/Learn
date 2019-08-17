package com.lylx.learn.ClassLoaderTest;

public class Person {
    private String name;
    // 创建实例对象，执行 Person 的非静态资源
    private static Person person = new Person();
    private static int n = 10;
    private int age = setAge();

    {
        System.out.println("父类构造代码块：age = " + age);
    }

    static {
        System.out.println("父类静态代码块：n = " + n);
    }

    public static int setAge() {
        return n++;
    }

    public Person() {
        System.out.println("父类无参构造函数：age = " + age);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("父类有参构造函数：age = " + age);
    }
}
