package com.lylx.learn.datastructure.Postfix;

public class StackX {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public StackX(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * put item on top of stack
     * 入栈
     */
    public void push(char pushValue) {
        stackArray[++top] = pushValue;
    }

    /**
     * take item from top of stack
     * 出栈
     */
    public char pop() {
        return stackArray[top--];
    }

    /**
     * peek at top of stack
     * 查看栈顶数据
     */
    public char peek() {
        return stackArray[top];
    }

    /**
     * true if stack is empty
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * @rerurn size
     */
    public int size() {
        return top + 1;
    }

    /**
     * @return item at index n
     */
    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int i = 0; i < size(); i++) {
            System.out.print(peekN(i));
            System.out.print("  ");
        }
        System.out.println("");
    }
}
