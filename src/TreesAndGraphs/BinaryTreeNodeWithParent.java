package TreesAndGraphs;

public class BinaryTreeNodeWithParent<T extends Comparable> {

    protected T data;
    protected BinaryTreeNodeWithParent<T> parent;
    protected BinaryTreeNodeWithParent<T> left;
    protected BinaryTreeNodeWithParent<T> right;

    public BinaryTreeNodeWithParent(T data) {
        this.data = data;
        parent = null;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public BinaryTreeNodeWithParent<T> getParent() {
        return parent;
    }

    public BinaryTreeNodeWithParent<T> getLeft() {
        return left;
    }

    public BinaryTreeNodeWithParent<T> getRight() {
        return right;
    }
}
