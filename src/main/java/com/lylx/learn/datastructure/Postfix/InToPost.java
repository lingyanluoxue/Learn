package com.lylx.learn.datastructure.Postfix;

/**
 * infix to postfix conversion
 */
public class InToPost {

    private StackX theStack;
    private String input;
    private String output = "";

    public InToPost(String input) {
        this.input = input;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }

    /**
     * do translation to postfix
     */
    public String doTrans() {
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            theStack.displayStack("For " + ch + " ");
            switch (ch) {
                case '+':
                case '-':
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOperator(ch, 2);
                    break;
                case '(':
                    theStack.push(ch);
                    break;
                case ')':
                    gotParen();
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!theStack.isEmpty()) {
            theStack.displayStack("While ");
            output = output + theStack.pop();
        }
        theStack.displayStack("End ");
        return output;
    }

    /**
     * got right paren from input
     */
    private void gotParen() {
        while (!theStack.isEmpty()) {
            char chPop = theStack.pop();
            if (chPop == '(') {
                break;
            } else {
                output = output + chPop;
            }
        }
    }

    /**
     * got operator from input
     *
     * @param opThis     operator read from the infix
     * @param opThisPrec precedence of opThis
     */
    private void gotOperator(char opThis, int opThisPrec) {
        while (!theStack.isEmpty()) {
            char opTop = theStack.pop();
            if (opTop == '(') {
                theStack.push(opTop);
                break;
            } else {
                int opTopPrec;
                if (opTop == '+' || opTop == '-') {
                    opTopPrec = 1;
                } else {
                    opTopPrec = 2;
                }
                if (opTopPrec < opThisPrec) {
                    theStack.push(opTop);
                    break;
                } else {
                    output = output + opTop;
                }
            }
        }
        theStack.push(opThis);
    }

}
