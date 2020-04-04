package StacksNQueues;

import java.util.NoSuchElementException;


public class QueueUsingStacks<T> {

    MyStack<T> stackPop;
    MyStack<T> stackPush;

    public void add(T data) throws Exception {
        stackPush.push(data);
    }

    public T remove() {
        if(stackPop.isEmpty()) {
            if(stackPush.isEmpty()) {
                throw new NoSuchElementException();
            }
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public T peek() {
        if(stackPop.isEmpty()) {
            if(stackPush.isEmpty()) {
                throw new NoSuchElementException();
            }
            while(!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public boolean isEmpty() {
        return stackPush.isEmpty() && stackPop.isEmpty();
    }
}
