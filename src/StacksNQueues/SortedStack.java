package StacksNQueues;

public class SortedStack<T extends Comparable<T>> {

    private static class StackNode<T> {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private StackNode<T> top = null;
    private StackNode<T> min;
    private StackNode<T> minNext;
    SortedStack<T> extraStack;

    public T pop() {
        if(top == null) {
            return null;
        }
        T item = null;
        if(extraStack.isEmpty()) {
            item = top.data;
            top = top.next;
        }
        else {
            while(!extraStack.isEmpty()) {
                push(extraStack.pop());
            }
            item = top.data;
            top = top.next;
        }
        return item;
    }

    public void push(T item) {
        StackNode<T> n = new StackNode(item);
        if(top == null) {
            top = n;
            return;
        }

        if(item.compareTo(top.data) > 1) {
            while(item.compareTo(top.data) > 1) {
                extraStack.push(pop());
            }
        }
        else if(extraStack.peek() != null || item.compareTo(extraStack.peek()) <= 1) {
            push(extraStack.pop());
        }
        n.next = top;
        top = n;
    }

    public T peek() {
        if(top == null) {
            return null;
        }
        while(!extraStack.isEmpty()) {
            push(extraStack.pop());
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
