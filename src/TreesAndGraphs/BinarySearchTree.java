package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree<T extends Comparable> {

    protected BinaryTreeNode<T> rootNode = null;

    public void insert(T data) {
        if(data == null) {
            return;
            //or throw exception
        }
        rootNode = insert(rootNode, data);
    }

    private BinaryTreeNode<T> insert(BinaryTreeNode<T> nodeAt, T data) {
        if(nodeAt == null) {
            return new BinaryTreeNode<>(data);
        }
        else {
            if(data.compareTo(nodeAt.getData()) < 1) {
                nodeAt.left = insert(nodeAt.left, data);
            }
            else {
                nodeAt.right = insert(nodeAt.right, data);
            }
        }
        return nodeAt; //return the node passed to the function
    }

    public void insertTrial(T data) {
        if(data == null) {
            return;
            //or throw exception
        }
        if(rootNode == null) {
            BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data);
            rootNode = newNode;
            return;
        }
        insertTrial(rootNode, data);
    }

    private void insertTrial(BinaryTreeNode<T> nodeAt, T data) {
        if(data.compareTo(nodeAt.getData()) < 1) {
            if(nodeAt.left != null) {
                insertTrial(nodeAt.left, data);
            }
            else {
                BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data);
                nodeAt.left = newNode;
            }
        }
        else {
            if(nodeAt.right != null) {
                insertTrial(nodeAt.right, data);
            }
            else {
                BinaryTreeNode<T> newNode = new BinaryTreeNode<>(data);
                nodeAt.right = newNode;
            }
        }
    }

    public void createBstWithMinHeight(List<T> sortedArray) {
        if(sortedArray == null || sortedArray.isEmpty()) {
            return;
        }
        rootNode = createBstWithMinHeightTT(sortedArray);
    }

    private BinaryTreeNode<T> createBstWithMinHeightTT(List<T> sortedArray) {
        if(sortedArray.size() == 1) {
            return new BinaryTreeNode<>(sortedArray.get(0));
        }
        int mid = sortedArray.size()/2;
        BinaryTreeNode<T> root = new BinaryTreeNode<>(sortedArray.get(mid));
        root.left = createBstWithMinHeightTT(sortedArray.subList(0, mid));
        if(mid+1 < sortedArray.size()) {
            root.right = createBstWithMinHeightTT(sortedArray.subList(mid+1, sortedArray.size()));
        }

        return root;
    }

    public int getTreeHeight() {
        return getTreeHeight(rootNode);
    }

    private int getTreeHeight(BinaryTreeNode<T> root) {
        if(root.left == null && root.right == null) {
            return 0;
        }
        int leftTreeHeight = getTreeHeight(root.left);
        int rightTreeHeight = getTreeHeight(root.right);
        return leftTreeHeight > rightTreeHeight ? leftTreeHeight+1 : rightTreeHeight+1;
    }
}
