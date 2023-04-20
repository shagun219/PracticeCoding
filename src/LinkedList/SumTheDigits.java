package LinkedList;

import java.util.Arrays;
import org.testng.Assert;


public class SumTheDigits {

    public static void main(String []args) {
        //LinkedListSingle num1 = new LinkedListSingle(Arrays.asList(7,1,6));
        //LinkedListSingle num2 = new LinkedListSingle(Arrays.asList(5,9,7));
        LinkedListSingle num1 = new LinkedListSingle(Arrays.asList(6,1,7));
        LinkedListSingle num2 = new LinkedListSingle(Arrays.asList(2,9,5));
        System.out.println("Num 1 :" + num1.toString());
        System.out.println("Num 2 :" + num2.toString());
        //LinkedListSingle actualSum = getSum(num1, num2);
        //System.out.println("Sum : " + actualSum.toString());

        LinkedListSingle reverseSum = getSumReverse(num1, num2);
        System.out.println("ReverseSum : " + reverseSum.toString());
        //LinkedListSingle expectedSum = LinkedListSingle.createSampleLinkedList(Arrays.asList(2,1,9));
        //Assert.assertEquals(actualSum, expectedSum);
    }

    private static LinkedListSingle getSum(LinkedListSingle num1, LinkedListSingle num2) {
        if(num1.getHead() == null) {
            return num2;
        }
        else if(num2.getHead() == null) {
            return num1;
        }

        LinkedListSingle.Node num1Current = num1.getHead();
        LinkedListSingle.Node num2Current = num2.getHead();

        LinkedListSingle sum = new LinkedListSingle();
        LinkedListSingle.Node current = sum.getHead();
        int carry = 0;
        while(num1Current != null || num2Current != null) {
            int digitSum = num1Current.data + num2Current.data + carry;
            current = sum.insertNode(current, digitSum%10);
            carry = digitSum/10;
            num1Current = num1Current.next;
            num2Current = num2Current.next;
        }

        if(num1Current != null || num2Current != null) {
            LinkedListSingle.Node remaining = null;
            if(num1Current == null) {
                remaining = num2Current;
            }
            else {
                remaining = num1Current;
            }
            while(remaining != null) {
                remaining.data = (remaining.data+carry)%10;
                carry = (remaining.data+carry)/10;
                current.next = remaining;
                current = remaining;
                remaining = remaining.next;
            }
        }
        if(carry != 0) {
            sum.addNodeToEnd(new LinkedListSingle.Node(carry));
        }
        return sum;
    }

    private static LinkedListSingle getSumReverse(LinkedListSingle num1, LinkedListSingle num2) {
        int number1 = getNumberFromLinkedList(num1);
        int number2 = getNumberFromLinkedList(num2);
        int sum = number1 + number2;
        return getLinkedListFromNumber(sum);
    }

    public static int getNumberFromLinkedList(LinkedListSingle ll) {
        int num = 0;
        LinkedListSingle.Node current = ll.getHead();
        while(current != null) {
            num = num*10 + current.data;
            current = current.next;
        }
        return num;
    }

    public static int getNumberFromLinkedList(LinkedListSingle.Node startNode) {
        int num = 0;
        LinkedListSingle.Node current = startNode;
        while(current != null) {
            num = num*10 + current.data;
            current = current.next;
        }
        return num;
    }

    public static LinkedListSingle getLinkedListFromNumber(int num) {
        LinkedListSingle ll = new LinkedListSingle();
        while(num>0) {
            ll.addNodeToBeginning(new LinkedListSingle.Node(num%10));
            num = num/10;
        }
        return ll;
    }

    public static LinkedListSingle getLinkedListFromNumberAlt(int num) {
        LinkedListSingle ll = new LinkedListSingle();
        String numStr = String.valueOf(num);
        LinkedListSingle.Node current = ll.getHead();
        for(int i=0; i< numStr.length(); i++){
            current = ll.insertNode(current, Integer.valueOf(numStr.charAt(i)));
        }
        return ll;
    }



}
