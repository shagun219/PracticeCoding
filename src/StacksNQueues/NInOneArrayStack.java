package StacksNQueues;

import java.util.Arrays;


public class NInOneArrayStack<T> {

    int []stack;
    int totalCapacity;
    int []stackTops;
    int numOfStacks;

    public NInOneArrayStack(int arraySize,int numOfStacks) {
        stack = new int[arraySize];
        totalCapacity =arraySize;
        stackTops = new int[numOfStacks];
        Arrays.fill(stackTops, -1);
        this.numOfStacks = numOfStacks;

    }

    public void push(int item, int stackIndex) throws Exception {
        if(isFull(stackIndex)) {
            throw new Exception("Stack is already full");
        }
        int insertIndex;
        if(isEmpty(stackIndex)) {
            insertIndex = getStartIndex(stackIndex);
        }
        else {
            insertIndex = stackTops[stackIndex]+1;
        }
        stack[insertIndex] = item;
        stackTops[stackIndex] = insertIndex;
    }

    public int pop(int stackIndex) throws Exception {
        if(isEmpty(stackIndex)) {
            throw new Exception("Stack is empty");
        }
        int item = stack[stackTops[stackIndex]];
        stack[stackTops[stackIndex]] = 0; // not necessary
        stackTops[stackIndex]--;
        return item;
    }

    public int peek(int stackIndex) throws Exception {
        if(isEmpty(stackIndex)) {
            throw new Exception("Stack is empty");
        }
        int item = stack[stackTops[stackIndex]];
        return item;
    }

    public boolean isEmpty(int stackIndex) {
        if(stackTops[stackIndex] < getStartIndex(stackIndex)) {
            return true;
        }
        return false;
    }

    public boolean isFull(int stackIndex) {
        if(stackTops[stackIndex] == getEndIndex(stackIndex)) {
            return true;
        }
        return false;
    }

    public int indexOfStackTop(int stackIndex) {
        return stackTops[stackIndex];
    }

    private int getStartIndex(int stackIndex) {
        int perStackCapacity = totalCapacity/numOfStacks;
        return perStackCapacity*stackIndex;
    }

    private int getEndIndex(int stackIndex) {
        int perStackCapacity = totalCapacity/numOfStacks;
        int endIndex = (perStackCapacity*(stackIndex+1)) -1;
        if(stackIndex == numOfStacks-1) {
            endIndex = totalCapacity-1;
        }
        return endIndex;
    }
}
