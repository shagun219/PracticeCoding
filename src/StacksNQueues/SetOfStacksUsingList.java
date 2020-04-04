package StacksNQueues;

import java.util.ArrayList;
import java.util.NoSuchElementException;


public class SetOfStacksUsingList {

    ArrayList<MyStackBackedByArray> setOfStacks = new ArrayList<>(3);
    int threshold;

    public SetOfStacksUsingList() {
        threshold = 10;//default;
    }

    public SetOfStacksUsingList(int threshold) {
        this.threshold = threshold;
    }

    public void push(int data) throws Exception {
        MyStackBackedByArray currentStack = getCurrentStack();
        if(currentStack == null || currentStack.isFull()) {
            currentStack = new MyStackBackedByArray(threshold);
            setOfStacks.add(currentStack);
        }
        currentStack.push(data);
    }

    public int pop() {
        MyStackBackedByArray lastStack = getCurrentStack();
        if(lastStack == null) {
            throw new NoSuchElementException();
        }
        int item = lastStack.pop();
        if(lastStack.isEmpty()) {
            setOfStacks.remove(setOfStacks.size()-1);
        }
        return item;
    }

    public int peek() {
        MyStackBackedByArray lastStack = getCurrentStack();
        if(lastStack == null) {
            throw new NoSuchElementException();
        }
        return lastStack.peek();
    }

    public boolean isEmpty() {
        return setOfStacks.size() == 0;
    }

    //rollover strategy to save space
    public int popAt(int index) throws Exception {
        if(index < 0 || index > setOfStacks.size()) {
            return -1;
        }
        if(index == setOfStacks.size()-1) {
            return pop();
        }
        MyStackBackedByArray popStack = setOfStacks.get(index);
        int item = popStack.pop();
        for(int i = index+1; index < setOfStacks.size(); i++) {
            MyStackBackedByArray iterStack = setOfStacks.get(i);
            MyStackBackedByArray tempStack = new MyStackBackedByArray(threshold);
            while(!iterStack.isEmpty()){
                //pop all elements
                tempStack.push(iterStack.pop());
            }
            popStack.push(tempStack.pop());
            while(!tempStack.isEmpty()) {
                //copy back
                iterStack.push(tempStack.pop());
            }
            popStack = iterStack;
        }
        if(popStack.isEmpty()) {
            setOfStacks.remove(setOfStacks.size()-1);
        }
        return item;
    }
    private MyStackBackedByArray getCurrentStack() {
        if(setOfStacks.isEmpty()) {
            return null;
        }
        return setOfStacks.get(setOfStacks.size()-1);
    }
}
