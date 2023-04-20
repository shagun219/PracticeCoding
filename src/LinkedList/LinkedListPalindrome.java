package LinkedList;

import java.util.Arrays;
import org.testng.Assert;


public class LinkedListPalindrome {

    public static void main(String []args) {
        LinkedListSingle palEven = new LinkedListSingle(Arrays.asList(6,1,7,7,1,6));
        LinkedListSingle palOdd = new LinkedListSingle(Arrays.asList(3,3,9,3,3));
        LinkedListSingle palOdd2 = new LinkedListSingle(Arrays.asList(12,3,9,3,12));
        LinkedListSingle notPalEven = new LinkedListSingle(Arrays.asList(1,2,2,4));
        LinkedListSingle notPalOdd = new LinkedListSingle(Arrays.asList(1,5,3,2,4));

        Assert.assertTrue(isPalindrome(palEven));
        Assert.assertTrue(isPalindrome(palOdd));
        Assert.assertFalse(isPalindrome(notPalEven));
        Assert.assertFalse(isPalindrome(notPalOdd));

    }

    private static boolean isPalindrome(LinkedListSingle ll) {
        if(ll == null || ll.getHead() == null) {
            return false;
        }
        LinkedListSingle.Node current = ll.getHead();
        LinkedListSingle.Node runner = ll.getHead();
        LinkedListSingle firstHalfLL = new LinkedListSingle();
        boolean isLengthEven = true;
        while(runner != null) {
            if(runner.next == null) {
                isLengthEven = false;
                runner = runner.next;
            }
            else {
                //Move runner first to avoid de-linking of nodes due to reversal
                runner = runner.next.next;
                LinkedListSingle.Node temp = current.next;
                firstHalfLL.addNodeToBeginning(current);
                //Move current
                current = temp;

            }
        }
        LinkedListSingle secondHalfLL = null;
        if(isLengthEven) {
            secondHalfLL = new LinkedListSingle(current);
        }
        else {
            secondHalfLL = new LinkedListSingle(current.next);
        }

        return firstHalfLL.equals(secondHalfLL);
    }
}
