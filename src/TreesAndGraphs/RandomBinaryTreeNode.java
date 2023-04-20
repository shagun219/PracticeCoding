package TreesAndGraphs;

public class RandomBinaryTreeNode<T extends Comparable> {

    protected T data;
    protected RandomBinaryTreeNode<T> left;
    protected RandomBinaryTreeNode<T> right;
    protected int size;

    public RandomBinaryTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
        size = 0;
    }

    public T getData() {
        return data;
    }

    public RandomBinaryTreeNode<T> getLeft() {
        return left;
    }

    public RandomBinaryTreeNode<T> getRight() {
        return right;
    }

    public int getSize() {
        return size;
    }

}
