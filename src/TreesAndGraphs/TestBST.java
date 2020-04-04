package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.annotations.Test;


public class TestBST {

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.insert( 4);
        bstClass.insert(3);
        bstClass.insert(5);
        bstClass.insert(6);

        StringBuilder path = new StringBuilder();
        BinaryTreeTraversals.inOrder(bstClass.rootNode, path);
        System.out.println("Tree Inorder: " + path.toString());
    }

    @Test
    public void testBSTWithMinHeight() {
        List<Integer> sortedList = Arrays.asList(1,2,3,4,5,6,7);
        ArrayList<Integer> sortedArray = new ArrayList<Integer>(sortedList);
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.createBstWithMinHeight(sortedArray);

        StringBuilder path = new StringBuilder();
        BinaryTreeTraversals.inOrder(bstClass.rootNode, path);
        System.out.println("Tree Inorder: " + path.toString());
        System.out.println("Tree height: " + bstClass.getTreeHeight());

    }

    @Test
    public void testInsertTrial() {
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.insertTrial(4);
        bstClass.insertTrial(3);
        bstClass.insertTrial(5);
        bstClass.insertTrial(6);

        StringBuilder path = new StringBuilder();
        BinaryTreeTraversals.inOrder(bstClass.rootNode, path);
        System.out.println("Tree Inorder: " + path.toString());

    }
}
