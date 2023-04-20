package LinkedList;

import java.util.Arrays;


public class TestLinkedListSingle {

    public static void main(String []args) {
        LinkedListSingle input = new LinkedListSingle(Arrays.asList(1,2,3,2,4,3,2,5,6,7,5,6));
        input.print();
        LinkedListSingle.Node kthFromEnd = input.findFromEndNodeAt(10);
        System.out.println(kthFromEnd == null ? "Not Found" :kthFromEnd.toString());
    }
}
