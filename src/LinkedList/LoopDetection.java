package LinkedList;

import java.util.Arrays;
import org.testng.Assert;


public class LoopDetection {

    public static void main(String []args) {
        LinkedListSingle ll1 = new LinkedListSingle(Arrays.asList(1,2,3,4,5,6));
        Assert.assertNull(detectLoop(ll1));
        LinkedListSingle.Node expectedLoopNode = ll1.findNodeAt(3);
        ll1.addNodeToEnd(expectedLoopNode);
        LinkedListSingle.Node actualLoopNode = detectLoop(ll1);
        Assert.assertTrue(actualLoopNode == expectedLoopNode);
    }

    //O(n^2)
    private static LinkedListSingle.Node detectLoop(LinkedListSingle ll) {
        if(ll == null || ll.getHead() == null) {
            return null;
        }
        LinkedListSingle.Node current = ll.getHead().next;
        int position = 2;
        while(current != null) {
            LinkedListSingle.Node runner = ll.getHead();
            int runnerCount = 1;
            while(runner != current) {
                if(runner == null) {
                    break;
                }
                runner = runner.next;
                runnerCount++;
            }
            if(runner != null && runnerCount != position) {
                return runner;
            }
            current = current.next;
            position++;
        }
        return null;
    }

}
