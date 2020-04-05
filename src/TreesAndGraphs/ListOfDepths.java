package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.testng.annotations.Test;


public class ListOfDepths<T> {

    public List<LinkedList<BinaryTreeNode<T>>> listOfDepthsOfABinaryTree(BinaryTreeNode<T> root) {
        List<LinkedList<BinaryTreeNode<T>>> listOfDepths = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue1 = new LinkedList<>();
        Queue<BinaryTreeNode<T>> queue2 = new LinkedList<>();
        queue1.add(root);

        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            LinkedList<BinaryTreeNode<T>> ll = new LinkedList<>();
            if(!queue1.isEmpty()) {
                juggleQueues(ll,queue1, queue2);
            }
            else {
                juggleQueues(ll, queue2, queue1);
            }
            listOfDepths.add(ll);
        }
        return listOfDepths;
    }

    private void juggleQueues(LinkedList<BinaryTreeNode<T>> ll,
            Queue<BinaryTreeNode<T>> popQueue, Queue<BinaryTreeNode<T>> pushQueue) {
        if(!popQueue.isEmpty()) {
            while(!popQueue.isEmpty()) {
                BinaryTreeNode<T> node = popQueue.poll();
                ll.add(node);
                if(node.getLeft() != null) {
                    pushQueue.add(node.getLeft());
                }
                if(node.getRight() != null) {
                    pushQueue.add(node.getRight());
                }
            }
        }
    }
}
