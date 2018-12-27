package com.lylx.learn.datastructure.Postfix;

public class InfixAndPostfix {

    public static void main(String[] args) {
        String input = args[0];
        String output;
        System.out.println("Enter infix is " + input);
        InToPost theTrans = new InToPost(input);
        output = theTrans.doTrans();
        System.out.println("Postfix is " + output);

        int answer;
        ParsePost parsePost = new ParsePost(output);
        answer = parsePost.doParse();
        System.out.println("The answer is "+ answer);

    }

}
