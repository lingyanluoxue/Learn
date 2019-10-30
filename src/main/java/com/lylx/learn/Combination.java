package com.lylx.learn;


import java.util.ArrayList;
import java.util.List;

public class Combination {
    public static void main(String[] args) {

        int str1= Integer.parseInt("101", 2);
        System.out.println(str1+"");


//        List<String> result = new ArrayList<>();
//
//        String str[] = { "A", "B", "C" };
//
//        int nCnt = str.length;
//
//        int nBit = (0xFFFFFFFF >>> (32 - nCnt));
//
//        for (int i = 1; i <= nBit; i++) {
//            boolean flag  = false;
//            StringBuilder temp = new StringBuilder();
//            for (int j = 0; j < nCnt; j++) {
//                if ((i << (31 - j)) >> 31 == -1) {
//                    if(flag){
//                        temp.append(",");
//                    }
//                    temp.append(str[j]);
//                    flag = true;
//                }
//            }
//            if (temp.toString().contains("A")){
//                result.add(temp.toString());
//                System.out.println(temp);
//            }
//        }

        String str[] = { "A", "B", "C" };
//        List<String> list = getCombinationList(str,"A");
        List<String> list = getCombinationList(str,"");
        for (String s : list) {
            System.out.println(s);
        }

    }

    /**
     * 获取组合列表
     */
    private static List<String> getCombinationList(String[] element, String containKeyWord) {
        List<String> result = new ArrayList<>();
        int nCnt = element.length;
        int nBit = (0xFFFFFFFF >>> (32 - nCnt));
        for (int i = 1; i <= nBit; i++) {
            boolean flag = false;
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < nCnt; j++) {
                if ((i << (31 - j)) >> 31 == -1) {
                    if (flag) {
                        temp.append(",");
                    }
                    temp.append(element[j]);
                    flag = true;
                }
            }
            if (!containKeyWord.isEmpty()) {
                if (temp.toString().contains(containKeyWord)) {
                    result.add(temp.toString());
                }
            } else {
                result.add(temp.toString());
            }
        }
        return result;
    }
}
