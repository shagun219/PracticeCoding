package StacksNQueues;

import java.util.NoSuchElementException;

//TimeComplexity = O(1) for all operations
//SpaceComplexity = O(2N) ~= O(N)
public class MyStackWithMin<T extends Comparable<T>> {

    private static class StackNode<T> {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackNode<T> top;
    private StackNode<T> min;
    private MyStack<StackNode<T>> minStack;

    public MyStackWithMin() {
        top = null;
        min = null;
    }

    public T pop() {
        if(top == null) {
            throw new NoSuchElementException();
        }
        if(top == minStack.peek()) {
            minStack.pop();
        }
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        if(item == null) {
            return;
        }
        StackNode<T> n = new StackNode(item);
        if(item.compareTo(min.data) < 1) {
            min = n;
            minStack.push(n);
        }
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

    public T min() {
        return min.data;
    }

    /*private StackNode<T> findMin(MyStackWithMin<T> origStack) {
        MyStackWithMin<T> tempStack;
        StackNode<T> min = origStack.top;
        StackNode<T> runner = origStack.top;
        while(runner != null) {
            if(runner.data.compareTo(min.data) < 1) {
                min = top;
            }
            runner = runner.next;
        }
        return min;
    }*/
}
