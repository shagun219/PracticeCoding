package LinkedList;

import java.util.List;


public class LinkedListSingle {

    public static class Node {
        public int data;
        public Node next;

        public Node() {

        }

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Data:"+data+"\n";
        }
    }

    private Node head;

    public LinkedListSingle() {
        head = null;
    }

    public LinkedListSingle(Node n) {
        head = n;
    }

    public LinkedListSingle(LinkedListSingle l) {
        this.head = l.head;
    }

    public LinkedListSingle(List<Integer> data) {
        Node current = null;
        for(Integer d : data) {
            Node n = new Node(d);
            if(current == null) {
                head = n;
            }
            else {
                current.next = n;
            }
            current = n;
        }
    }

    @Override
    public String toString() {
        Object ob;
        StringBuilder cs = new StringBuilder();
        if(head == null) {
            return null;
        }
        Node current = head;
        while(current.next != null) {
            cs.append(current.data);
            cs.append("->");
            current = current.next;
        }
        cs.append(current.data);
        return cs.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        if(obj == null || !(obj instanceof LinkedListSingle)){
            return false;
        }
        LinkedListSingle ll = (LinkedListSingle)obj;
        if(ll.head == null) {
            return false;
        }
        if(this.head == ll.head) {
            return true;
        }
        Node current = head;
        Node llCurrent = ll.head;
        while(current != null) {
            if(llCurrent == null || llCurrent.data != current.data) {
                return false;
            }
            llCurrent = llCurrent.next;
            current = current.next;
        }
        if(llCurrent == null) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(head == null) {
            return true;
        }
        return false;
    }

    public void addNodeToEnd(Node n) {
        if(n == null) {
            //do nothing
            return;
        }
        n.next = null;
        if(head == null) {
            head = n;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = n;
    }

    //O(1)
    public void addNodeToBeginning(Node n) {
        if(n == null) {
            //do nothing
            return;
        }
        if(head == null) {
            n.next = null;
        }
        else {
            n.next = head;
        }
        head = n;
    }

    //position starts from 1
    public void addNodeAt(Node n, int position) {
        if(n == null || position < 1) {
            //do nothing
            return;
        }
        if(position == 1) {
            addNodeToBeginning(n);
            return;
        }
        int count = 1;
        Node current = head;
        while(current != null) {
            if(count+1 == position) {
                n.next = current.next;
                current.next = n;
            }
            current = current.next;
            count++;
        }
    }

    public Node insertNode(Node nodeAt, int data) {
        Node newNode = new Node(data);
        if(nodeAt == null) {
            //LinkedList is empty, add the first node
            head = newNode;
        }
        else {
            Node temp = nodeAt.next;
            nodeAt.next = newNode;
            newNode.next =temp;
        }
        return newNode;
    }

    public Node removeNodeFromEnd() {
        if(head == null) {
            return head;
        }
        if(head.next == null) {
            Node last = head;
            head = null;
            return last;
        }
        Node current = head;
        Node prev = head;
        while(current.next != null) {
            prev = current;
            current = current.next;
        }
        prev.next = null;
        return current;
    }

    public Node removeNodeFromBeginning() {
        if(head == null) {
            return null;
        }
        Node first = head;
        head = head.next;
        first.next = null;
        return first;
    }

    //position starts from 1
    //returns null if not found
    public Node removeNodeAt(int position) {
        if(head == null || position < 1) {
            return null;
        }
        if(position == 1) {
            return removeNodeFromBeginning();
        }
        Node current = head;
        Node prev = head;
        int count = 1;
        while(current.next != null) {
            if(count == position) {
                prev.next = current.next;
                return prev;
            }
            prev = current;
            current = current.next;
            count++;
        }
        return null;
    }

    public Node removeNode(Node n) {
        if(head == null || n == null) {
            return null;
        }
        Node current = head;
        Node prev = null;
        while(current != null) {
            if(current.data == n.data) {
                if(prev == null) {
                    head = current.next;
                }
                else {
                    prev.next = current.next;
                }
                return current;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }

    //returns null if not found
    public Node findNodeAt(int position) {
        if(head == null || position < 1) {
            return null;
        }
        int count = 1;
        Node current = head;
        while(current != null) {
            if(count == position) {
                return current;
            }
            current = current.next;
            count++;
        }
        return null;
    }

    public Node findFromEndNodeAt(int position) {
        if(head == null || position < 1) {
            return null;
        }
        Node start = head;
        Node runner = head;
        int count = 1;
        while(runner.next != null) {
            if(count < position) {
                count++;
            }
            else {
                start = start.next;
            }
            runner = runner.next;
        }
        return count == position ? start : null;
    }
    //returns position of first occurrence of the node with matching value
    //else returns -1
    public int findNodeFirstOccurrenceWithValue(Node n, int value) {
        if(head == null) {
            return -1;
        }
        int count = 1;
        Node current = head;
        while(current != null) {
            if(current.data == value) {
                return count;
            }
            current = current.next;
            count++;
        }
        return -1;
    }

    public Node getHead() {
        return head;
    }

    public Node getLastNode() {
        Node current = head;
        if(current == null) {
            return null;
        }
        while(current.next != null) {
            current = current.next;
        }
        return current;
    }

    public void print() {
        if(head == null) {
            return;
        }
        Node current = head;
        while(current.next != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println(current.data);
    }

}
