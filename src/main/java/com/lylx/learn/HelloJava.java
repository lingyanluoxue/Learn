package com.lylx.learn;

import com.lylx.learn.datastructure.link.Link;

import java.util.*;

public class HelloJava {

    private static int test = 1;

    public static void main(String[] args) {

//        User user = new User(0, "lylx");
//        System.out.printf("user:" + user);

//        traverse(args);

//        consoleParam(args);

//        useLabel();

//        String json = "{" + "\"code\": 0," + "\"message\": \"ok\"," + "\"content\": {\n" + "\"id\": 1" + "}" + "}";
//        BaseModel<Content> sing = new Gson().fromJson(json, new TypeToken <BaseModel<Content>>() {
//        }.getType());
//        System.out.println(sing);
//        System.out.println(sing.getContent().getName());
    }

    private static void useLabel() {
        loop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 5) break loop;
                System.out.println("j:" + j);
            }
            System.out.println("i:" + i);
        }
    }


    private static void traverse(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    /**
     * a_b_c_d_e_f_g_h_i_j
     * a b c d e f g h i j
     * <p>
     * 遍历:flatMap
     */
    private static void consoleParam(String... args) {
        for (String arg : args) {
            String[] splitArgs = arg.split("_");
            for (String splitArg : splitArgs) {
                System.out.print(splitArg + " ");
            }
        }
    }
}
