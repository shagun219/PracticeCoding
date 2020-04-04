package StacksNQueues;

import java.util.NoSuchElementException;


public class MyStack<T> {

    private static class StackNode<T> {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if(top == null) {
            throw new NoSuchElementException();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode<T> n = new StackNode(item);
        n.next = top;
        top = n;
    }

    public T peek() {
        if(top == null) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
