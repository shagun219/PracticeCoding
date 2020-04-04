package LinkedList;

import java.util.Arrays;


public class PartitionLinkedList {

    public static void main(String []args) {
        LinkedListSingle input = new LinkedListSingle(Arrays.asList(3,5,8,5,10,2,1));
        input.print();
        //LinkedListSingle expectedOutput = LinkedListSingle.createSampleLinkedList(Arrays.asList(1,2,3,4,5,6,7));
        partitionLinkedList(input,5);
        input.print();
        //Assert.assertEquals(input.toString(), expectedOutput.toString());
    }

    private static void partitionLinkedList(LinkedListSingle ll, int partitionKey) {
        if(ll == null || ll.getHead() == null) {
            return;
        }
        LinkedListSingle.Node current = ll.getHead();
        LinkedListSingle.Node runner = ll.getHead();
        while(runner != null){
            if(runner.data < partitionKey) {
                swapData(current, runner);
                current = current.next;
                runner = runner.next;
            }
            else {
                runner = runner.next;
            }
        }

    }

    private static void swapData(LinkedListSingle.Node n1, LinkedListSingle.Node n2) {
        if(n1 == n2) {
            return;
        }
        int t = n1.data;
        n1.data = n2.data;
        n2.data = t;
    }
}
