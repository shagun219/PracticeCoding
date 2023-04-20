package TreesAndGraphs;

import java.util.Random;


public class RandomBinaryTree<T extends Comparable> {

    public void insert(RandomBinaryTreeNode<T> root, T data) {
        if(data == null) {
            return;
        }
        if(root == null) {
            RandomBinaryTreeNode<T> newNode = new RandomBinaryTreeNode<>(data);
            root = newNode;
        }
        else if(data.compareTo(root.data) <= 1) {
            insert(root.left, data);
        }
        else {
            insert(root.right, data);
        }
        root.size += 1;
    }

    public RandomBinaryTreeNode<T> getRandomNode(RandomBinaryTreeNode<T> root) {
        if(root == null) {
            return null;
        }
        Random rand = new Random();
        int randNum = rand.nextInt(root.size);
        int leftSubtreeSize = root.left == null ? 0 : root.left.size;
        if(randNum < leftSubtreeSize) {
            return getRandomNode(root.left);
        }
        else if (randNum == leftSubtreeSize) {
            return root;
        }
        else {
            return getRandomNode(root.right);
        }
    }
}
