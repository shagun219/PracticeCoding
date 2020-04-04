package LinkedList;

import java.util.Arrays;
import org.testng.Assert;


public class Intersection {

    public static void main(String []args) {
        LinkedListSingle ll1 = new LinkedListSingle(Arrays.asList(1,2,3,4,5,6));
        LinkedListSingle.Node expectedIntersectionNode = ll1.findNodeAt(3);
        LinkedListSingle ll2 = new LinkedListSingle(Arrays.asList(7,8,9));
        ll2.addNodeToEnd(expectedIntersectionNode);
        LinkedListSingle ll3 = new LinkedListSingle(Arrays.asList(1,2,7,8,9));

        LinkedListSingle.Node actualIntersectionNode = getIntersection(ll1, ll2);
        Assert.assertTrue(actualIntersectionNode == expectedIntersectionNode);
        Assert.assertNull(getIntersection(ll1,ll3));
    }

    private static LinkedListSingle.Node getIntersection(LinkedListSingle ll1, LinkedListSingle ll2) {
        //can we use hashcode of nodes as key in map to reduce runtime to O(n)?
        if(ll1 == null || ll1.getHead() == null
            || ll2 == null || ll2.getHead() == null) {
            return null;
        }
        LinkedListSingle.Node runner1 = ll1.getHead();
        while(runner1 != null){
            LinkedListSingle.Node runner2 = ll2.getHead();
            while(runner2 != null) {
                if(runner2 == runner1) {
                    return runner1;
                }
                runner2 = runner2.next;
            }
            runner1 = runner1.next;
        }
        return null;
    }
}
