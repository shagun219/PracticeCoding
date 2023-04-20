package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;


public class TreeNode<T> {

    private T data;
    private List<TreeNode<T>> children;

    public TreeNode() {
        data = null;
        children = new ArrayList<>();
    }

    public TreeNode(T data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public T getData() {
        return data;
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }
}
