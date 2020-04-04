package StacksNQueues;

import java.util.NoSuchElementException;


public class MyQueue<T> {

    private static class QueueNode<T> {
        T data;
        QueueNode next;

        public QueueNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    QueueNode<T> start;
    QueueNode<T> end;

    public void add(T data) {
        QueueNode<T> qn = new QueueNode(data);
        if(start == null) {
            start = qn;
        }
        else {
            qn.next = end;
        }
        end = qn;
    }

    public T remove() {
        if(start == null) {
            throw new NoSuchElementException();
        }
        T data = start.data;
        if(start == end) {
            //start.next == null
            start = null;
            end = null;
        }
        else {
            start = start.next;
        }
        return data;
    }

    public T peek() {
        if(start == null) {
            throw new NoSuchElementException();
        }
        return start.data;
    }

    public boolean isEmpty() {
        return start == null;
    }
}
