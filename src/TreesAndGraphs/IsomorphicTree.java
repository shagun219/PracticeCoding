package TreesAndGraphs;

public class IsomorphicTree<T extends Comparable> {

    boolean isIsomorphic(BinaryTreeNode<T> tree1, BinaryTreeNode<T> tree2) {
        if(tree1 == null && tree2 == null) {
            return true;
        }
        if(tree1 == null || tree2 == null) {
            return false;
        }
        //root node
        if(tree1.data.compareTo(tree2.data) != 0) {
            return false;
        }
        return (isIsomorphic(tree1.left, tree2.right) && isIsomorphic(tree1.right, tree2.left))
            || (isIsomorphic(tree1.left, tree2.left) && isIsomorphic(tree1.right, tree2.right));
    }
}


