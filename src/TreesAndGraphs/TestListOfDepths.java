package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.testng.annotations.Test;


public class TestListOfDepths {

    @Test
    public void testListOfDepths() {
        List<Integer> sortedList = Arrays.asList(1,2,3,4,5,6,7);
        ArrayList<Integer> sortedArray = new ArrayList<Integer>(sortedList);
        BinarySearchTree<Integer> bstClass = new BinarySearchTree<>();
        bstClass.createBstWithMinHeight(sortedArray);

        ListOfDepths<Integer> lodClass = new ListOfDepths<>();
        List<LinkedList<BinaryTreeNode<Integer>>> listOfDepths = lodClass.listOfDepthsOfABinaryTree(bstClass.rootNode);
        int depth = 0;
        for(LinkedList<BinaryTreeNode<Integer>> listAtDepth : listOfDepths) {
            System.out.println("Nodes at depth "+ depth + " : " + getListData(listAtDepth));
            depth++;
        }
    }

    private String getListData(LinkedList<BinaryTreeNode<Integer>> ll) {
        StringBuilder sb = new StringBuilder();
        for(BinaryTreeNode<Integer> node : ll) {
            sb.append(node.data).append(",");
        }
        if(sb.length() >0) {
            sb.setLength(sb.length()-1);
        }
        return sb.toString();
    }
}
