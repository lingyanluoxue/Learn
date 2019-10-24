package com.lylx.learn;

public class ParamPassedTest {
    public static void main(String[] args) {
        String str = new String("ceshi");
        change(str);
        //输出结果是 ceshi
        System.out.println(str);

        int num = 1;
        change(num);
        System.out.println(num);

        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }

    public static void change(String str) {
        str = "even";
        System.out.println("change str:" + str);
    }

    public static void change(int num) {
        num = 3;
        System.out.println("change num:" + num);
    }
}
