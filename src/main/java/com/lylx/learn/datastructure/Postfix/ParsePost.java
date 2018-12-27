package com.lylx.learn.datastructure.Postfix;

public class ParsePost {
    private String inputPostfix;
    private StackNum theStack;

    public ParsePost(String inputPostfix) {
        this.inputPostfix = inputPostfix;
    }

    public int doParse() {
        theStack = new StackNum(20);
        int num1, num2, interAns;
        for (int i = 0; i < inputPostfix.length(); i++) {
            char ch = inputPostfix.charAt(i);
            theStack.displayStack("" + ch + " ");
            if (Character.isDigit(ch)) {
                theStack.push(ch - '0');
            } else {
                num2 = theStack.pop();
                num1 = theStack.pop();
                switch (ch) {
                    case '+':
                        interAns = num1 + num2;
                        break;
                    case '-':
                        interAns = num1 - num2;
                        break;
                    case '*':
                        interAns = num1 * num2;
                        break;
                    case '/':
                        interAns = num1 / num2;
                        break;
                    default:
                        interAns = 0;
                        break;
                }
                theStack.push(interAns);
            }
        }
        interAns = theStack.pop();
        return interAns;
    }
}
