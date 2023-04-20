package StacksNQueues;

import java.util.NoSuchElementException;
import java.util.Stack;


public class SetOfStacks<T> {

    private static class StackNode<T> {
        T data;
        StackNode next;

        public StackNode(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private int threshold;
    private int totalElements = 0;
    private MyStack<StackNode<T>> stackOfTopNodes;

    private StackNode<T> top;

    public void push(T data) throws Exception {
        if(data == null) {
            throw new Exception("Can't add null");
        }
        StackNode<T> n = new StackNode(data);
        if(isEmpty() || thresholdReached()) {
            stackOfTopNodes.push(n);
        }
        n.next =top;
        top = n;
        totalElements++;
    }

    public T pop() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        T item = top.data;
        top = top.next;
        if(totalElements%threshold == 1) {
            stackOfTopNodes.pop();
        }
        totalElements--;
        return item;
    }

    public T peek() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        return top.data;
    }

    //O(threshold) ~= constant
    public T popAt(int index) {
        if(!subStackExists(index)) {
            throw new NoSuchElementException();
        }
        T item = null;
        int subStackCount = getNumberOfSubStacks();
        if(subStackCount-1 == index) {
            stackOfTopNodes.pop();
            item = top.data;
            top = top.next;
            totalElements--;
            if(!thresholdReached()) {
                stackOfTopNodes.push(top);
            }
        }
        else {
            StackNode<T> nextTop = null;
            MyStack<StackNode<T>> tempStack = new MyStack<StackNode<T>>();
            for(int count = subStackCount-1; count>index; count--)  {
                nextTop = stackOfTopNodes.pop();
                tempStack.push(nextTop);
            }
            StackNode<T> currentTop = stackOfTopNodes.pop();
            item = currentTop.data;
            StackNode<T> runner = nextTop;
            while(runner.next != currentTop) {
                runner = runner.next;
            }
            runner.next = currentTop.next;
            stackOfTopNodes.push(currentTop.next);
            while(tempStack.isEmpty()){
                stackOfTopNodes.push(tempStack.pop());
            }
            totalElements--;
        }

        return item;
    }

    public boolean isEmpty() {
        return totalElements == 0;
    }

    private boolean thresholdReached() {
        return totalElements%threshold == 0;
    }

    private boolean subStackExists(int index) {
        return index+1 <= getNumberOfSubStacks();
    }

    private int getNumberOfSubStacks() {
        int numOfSubStacks = totalElements/threshold;
        if(!thresholdReached()) {
            numOfSubStacks++;
        }
        return numOfSubStacks;
    }

}
