package TreesAndGraphs;

public class BinaryTreeUtil<T extends Comparable> {


    public static <T extends Comparable> int getTreeHeight(BinaryTreeNode<T> root) {
        if(root == null) {
            return 0;
        }
        int leftTreeHeight =  getTreeHeight(root.getLeft());
        int rightTreeHeight =  getTreeHeight(root.getRight());
        return leftTreeHeight > rightTreeHeight ? leftTreeHeight +1 : rightTreeHeight +1;
    }

    //Balanced binary tree is a tree where height of the two subtrees at any node differ max by 1
    public static <T extends Comparable> boolean isBalancedBinaryTree(BinaryTreeNode<T> root) {
        if(root == null) {
            return true;
        }
        try {
            int leftSubtreeHeight = checkTreeHeight(root.getLeft());
            int rightSubtreeHeight = checkTreeHeight(root.getRight());
            return Math.abs(leftSubtreeHeight-rightSubtreeHeight) <= 1;
        }
        catch(Exception ex) {
            //Clearly indicates is not balanced
        }
        return false;
    }

    public static <T extends Comparable> int checkTreeHeight(BinaryTreeNode<T> root) throws Exception {
        if(root == null) {
            return -1;
        }
        int leftTreeHeight =  checkTreeHeight(root.getLeft());
        int rightTreeHeight =  checkTreeHeight(root.getRight());
        if(Math.abs(leftTreeHeight-rightTreeHeight) > 1) {
            throw new Exception("Not balanced");
        }
        return Math.max(leftTreeHeight, rightTreeHeight) + 1;
    }

    //NOTE : not just left.data <= data < right.data but all left descendants <= node < all right descendants for
    // each node
    public static <T extends Comparable> boolean isBinarySearchTree(BinaryTreeNode<T> root, T minValue, T maxValue) {
        if(root == null) {
            return true;
        }
        if(root.getLeft() != null && root.getLeft().getData().compareTo(root.getData()) >1) {
            return false;
        }
        if(root.getRight() != null && root.getRight().getData().compareTo(root.getData()) <= 1) {
            return false;
        }
        boolean isLeftSubtreeBST = isBinarySearchTree(root.getLeft(), minValue, root.getLeft().getData());
        boolean isRightSubtreeBST = isBinarySearchTree(root.getRight(), root.getRight().getData(), maxValue);

        return isLeftSubtreeBST &&  isLeftSubtreeBST;
    }
}
