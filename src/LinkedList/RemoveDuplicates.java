package LinkedList;

import java.util.Arrays;
import java.util.HashSet;
import org.testng.Assert;


public class RemoveDuplicates {

    public static void main(String []args) {
        LinkedListSingle input = new LinkedListSingle(Arrays.asList(1,2,3,2,4,3,2,5,6,7,5,6,1));
        input.print();
        LinkedListSingle expectedOutput = new LinkedListSingle(Arrays.asList(1,2,3,4,5,6,7));
        /*removeDuplicates(input);
        input.printLinkedList();
        Assert.assertEquals(input.toString(), expectedOutput.toString());*/

        removeDuplicatesWithoutStorage(input);
        input.print();
        Assert.assertEquals(input.toString(), expectedOutput.toString());

    }

    private static void removeDuplicates(LinkedListSingle ll) {
        HashSet<Integer> dataSeen = new HashSet<>();
        LinkedListSingle.Node prev = null;
        LinkedListSingle.Node current = ll.getHead();
        while(current != null) {
            if(dataSeen.contains(current.data)) {
                prev.next = current.next;
            }
            else{
                dataSeen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }

    //O(n^2)
    private static void removeDuplicatesWithoutStorage(LinkedListSingle ll) {
        if(ll == null || ll.isEmpty()) {
            return;
        }
        LinkedListSingle.Node current = ll.getHead();
        while(current != null) {
            LinkedListSingle.Node prev = current;
            LinkedListSingle.Node runner = current.next;
            while(runner != null) {
                if(runner.data == current.data) {
                    prev.next = runner.next;
                }
                else {
                    prev = runner;
                }
                runner = runner.next;
            }
            current = current.next;
        }
    }
}
