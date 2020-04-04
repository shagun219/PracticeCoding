package LinkedList;

import java.util.Arrays;


public class RemoveNode {

    public static void main(String []args) {
        LinkedListSingle input = new LinkedListSingle(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        System.out.println("Before: " + input.toString());
        LinkedListSingle.Node n = input.findNodeAt(1);
        deleteNodeFromLinkedList(n);
        System.out.println("After: " + input.toString());
    }

    private static void deleteNodeFromLinkedList(LinkedListSingle.Node n) {
        if(n == null) {
            System.out.println("Passed node is null");
            return;
        }
        else if(n.next == null) {
            System.out.println("Passed node is the last node, cannot be deleted");
            return;
        }
        LinkedListSingle.Node nextNode = n.next;
        n.data = nextNode.data;
        n.next = nextNode.next;
    }
}
