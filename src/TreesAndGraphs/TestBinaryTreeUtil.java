package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestBinaryTreeUtil {

    @Test
    public void testIsBalancedBinaryTree() {
        List<Integer> sortedList = Arrays.asList(1,2,3,4,5,6,7);
        ArrayList<Integer> sortedArray = new ArrayList<Integer>(sortedList);
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.createBstWithMinHeight(sortedArray);

        Assert.assertTrue(BinaryTreeUtil.isBalancedBinaryTree(bstClass.rootNode));
    }

    @Test
    public void testIsBinarySearchTree() {
        List<Integer> sortedList = Arrays.asList(1,2,2,4,5,6,6,9);
        ArrayList<Integer> sortedArray = new ArrayList<Integer>(sortedList);
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.createBstWithMinHeight(sortedArray);

        Assert.assertTrue(BinaryTreeUtil.isBinarySearchTree(bstClass.rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void testIsBinarySearchTreeNegative() {
        List<Integer> sortedList = Arrays.asList(5,2,4,4,5,3,7);
        ArrayList<Integer> sortedArray = new ArrayList<Integer>(sortedList);
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.createBstWithMinHeight(sortedArray);

        Assert.assertFalse(BinaryTreeUtil.isBinarySearchTree(bstClass.rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}
