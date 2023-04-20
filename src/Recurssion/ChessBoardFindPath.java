package Recurssion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import StacksNQueues.MyStack;


public class ChessBoardFindPath {

    private int numOfRows;
    private int numOfColumns;
    private List<Integer> blockedNodes;

    public ChessBoardFindPath(int numOfRows, int numOfColumns, List<Integer> blockedNodes) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.blockedNodes = blockedNodes;
    }

    public String findPathDR(int x, int y) {
        MyStack<Integer> path = new MyStack<>();
        List<Integer> pathFound = new ArrayList<>();
        if(findPathDR(x,y,path, pathFound)) {
            return path.emptyStack();
        }
        return "No path found";
    }

    private boolean findPathDR(int x, int y, MyStack<Integer> path, List<Integer> pathFound) {
        int coordinate = x*10+y;
        if(x >= numOfRows || y >= numOfColumns) {
            return false;
        }
        if(blockedNodes.contains(coordinate)){
            return false;
        }
        if(x == numOfRows-1 && y == numOfColumns-1) {
            path.push(coordinate);
            pathFound.add(coordinate);
            return true;
        }
        if(pathFound.contains(coordinate)) {
            return true;
        }

        if(findPathDR(x, y+1, path, pathFound) || findPathDR(x+1, y, path, pathFound)) {
            path.push(coordinate);
            pathFound.add(coordinate);
            return true;
        }
        return false;
    }

    public String findPathDDR(int x, int y) {
        MyStack<Integer> path = new MyStack<>();
        List<Integer> pathFound = new ArrayList<>();
        if(findPathDDR(x,y,path, pathFound)) {
            return path.emptyStack();
        }
        return "No path found";
    }

    private boolean findPathDDR(int x, int y, MyStack<Integer> path, List<Integer> pathFound) {
        int coordinate = x*10+y;
        if(x >= numOfRows || y >= numOfColumns) {
            return false;
        }
        if(blockedNodes.contains(coordinate)){
            return false;
        }
        if(x == numOfRows-1 && y == numOfColumns-1) {
            path.push(coordinate);
            pathFound.add(coordinate);
            return true;
        }
        if(pathFound.contains(coordinate)) {
            return true;
        }

        if(findPathDR(x+1, y+1, path, pathFound)
                || findPathDR(x, y+1, path, pathFound)
                || findPathDR(x+1, y, path, pathFound)) {
            path.push(coordinate);
            pathFound.add(coordinate);
            return true;
        }
        return false;
    }
}
