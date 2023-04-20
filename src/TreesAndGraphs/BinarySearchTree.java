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
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 0;
        }
        int leftTreeHeight = getTreeHeight(root.left);
        int rightTreeHeight = getTreeHeight(root.right);
        return leftTreeHeight > rightTreeHeight ? leftTreeHeight+1 : rightTreeHeight+1;
    }

    public BinaryTreeNodeWithParent<T> createBstMinHeightWithParent(List<T> sortedArray) {
        return createBstMinHeightWithParent(sortedArray, null);
    }

    public BinaryTreeNodeWithParent<T> createBstMinHeightWithParent(List<T> sortedArray,
            BinaryTreeNodeWithParent<T> parent) {
        if(sortedArray == null || sortedArray.isEmpty()) {
            return null;
        }
        int mid = sortedArray.size();
        BinaryTreeNodeWithParent<T> node = new BinaryTreeNodeWithParent<>(sortedArray.get(mid));
        node.parent = parent;
        node.left = mid > 0 ? createBstMinHeightWithParent(sortedArray.subList(0, mid), node) : null;
        node .right = mid+1 < sortedArray.size() ? createBstMinHeightWithParent(sortedArray.subList(mid+1,
                sortedArray.size()-1), node) : null;
        return node;
    }

    public BinaryTreeNodeWithParent<T> nextNodeInOrder(BinaryTreeNodeWithParent<T> node){
        if(node == null) {
            return null;
        }
        else if(node.right != null) {
            BinaryTreeNodeWithParent<T> cNode = node.right;
            while(cNode.left != null) {
                cNode = cNode.left;
            }
            return cNode;
        }
        else {
            BinaryTreeNodeWithParent<T> child = node;
            BinaryTreeNodeWithParent<T> parent = node.parent;
            while(parent != null && parent.left != child) {
                child = parent;
                parent = parent.parent;
            }
            return parent;
        }
    }
}
