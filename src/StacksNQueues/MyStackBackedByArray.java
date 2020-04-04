package StacksNQueues;

import java.util.NoSuchElementException;


public class MyStackBackedByArray {

    private int []stack;
    private int defaultCapcity = 10;
    private int top = -1;

    public MyStackBackedByArray() {
        this.stack = new int[10];
    }

    public MyStackBackedByArray(int capacity) {
        this.stack = new int[capacity];
    }

    public int pop() {
        if(top == -1) {
            throw new NoSuchElementException();
        }
        int item = stack[top];
        top--;
        return item;
    }

    public void push(int item) throws Exception {
        if(top == stack.length-1) {
            throw new Exception("Can't add more data, stack is full");
        }
        stack[++top] = item;
    }

    public int peek() {
        if(top == -1) {
            throw new NoSuchElementException();
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top < 0;
    }

    public boolean isFull() {
        return top == stack.length -1;
    }
}
