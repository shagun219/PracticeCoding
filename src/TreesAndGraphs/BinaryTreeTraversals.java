package TreesAndGraphs;

public class BinaryTreeTraversals<T extends Comparable> {

    public static <T extends Comparable> String preOrder(BinaryTreeNode<T> root, StringBuilder pathBuilder) {
        if(pathBuilder == null) {
            //throw exception
            //pathBuilder = new StringBuilder();
        }
        if(root == null) {
            return pathBuilder.toString();
        }
        else {
            pathBuilder.append(root.data.toString() + ",");
            preOrder(root.left, pathBuilder);
            preOrder(root.right, pathBuilder);
        }
        return pathBuilder.toString();
    }

    public static <T extends Comparable> String inOrder(BinaryTreeNode<T> root, StringBuilder pathBuilder) {
        if(pathBuilder == null) {
            //throw exception
            //pathBuilder = new StringBuilder();
        }
        if(root == null) {
            return pathBuilder.toString();
        }
        else {
            inOrder(root.left, pathBuilder);
            pathBuilder.append(root.data.toString() + ",");
            inOrder(root.right, pathBuilder);
        }
        return pathBuilder.toString();
    }

    public static <T extends Comparable> String postOrder(BinaryTreeNode<T> root, StringBuilder pathBuilder) {
        if(pathBuilder == null) {
            //throw exception
            //pathBuilder = new StringBuilder();
        }
        if(root == null) {
            return pathBuilder.toString();
        }
        else {
            postOrder(root.left, pathBuilder);
            postOrder(root.right, pathBuilder);
            pathBuilder.append(root.data.toString() + ",");
        }
        return pathBuilder.toString();
    }

}
