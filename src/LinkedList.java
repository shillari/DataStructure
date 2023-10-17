import java.util.*;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node node = new Node(value);
        head = tail = node;
        length = 1;
    }

    public LinkedList() {
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {

        Node node = new Node(value);
        if (length == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public Node removeLast() {

        if (length == 0)
            return null;

        Node previous = head;
        Node temp = head;
        while (temp.next != null) {
            previous = temp;
            temp = temp.next;
        }
        tail = previous;
        tail.next = null;
        length--;
        if(length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {

        Node node = new Node(value);
        if(length == 0) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst() {

        if(length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if(length == 0) {
            tail = null;
        }
        return temp;
    }

    public Node get(int index) {

        if(length == 0 || index < 0 || index >= length) return null;

        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public boolean set(int index, int value) {

        Node currentNode = get(index);
        if(currentNode != null) {
            currentNode.setValue(value);
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){

        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }

    public Node remove(int index) {

        if (index < 0 || index > length || length == 0) return null;

        if(index == 0) return removeFirst();

        if(index == length-1) return removeLast();

        Node previous = get(index - 1);
        Node currentNode = previous.next;
        previous.next = currentNode.next;
        currentNode.next = null;
        length--;

        return currentNode;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode(){

        if(head == null) return null;

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop() {

        if(head == null) return false;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }

        return false;

    }

//    public Node findKthFromEnd(int k) {
//
//        if(head == null) return null;
//        if(k < 0 || k > length) return null;
//
//        int index = length - k;
//
//        return get(index);
//
//    }

    public Node findKthFromEnd(int k) {
        if(head == null) return null;
        if(k < 0 ) return null;

        Node slow = head;
        Node fast = head;
        int count = 0;
        while (count < k) {
            if(fast == null) return null;
            fast = fast.next;
            count++;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void partitionList(int x) {
        if (head == null) return;

        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node prev1 = dummy1;
        Node prev2 = dummy2;
        Node current = head;

        while (current != null) {
            if (current.value < x) {
                prev1.next = current;
                prev1 = current;
            } else {
                prev2.next = current;
                prev2 = current;
            }
            current = current.next;
        }

        prev2.next = null;
        prev1.next = dummy2.next;

        head = dummy1.next;
    }

    public void removeDuplicates() {

        if (head == null || head.next == null) return;

        HashSet values = new HashSet();
        Node current = head;
        Node previous = null;

        while(current != null) {
            if(values.contains(current.value)) {
                previous.next = current.next;
                length--;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    public void reverseBetween(int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for (int i = 0; i < n - m; i++) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        head = dummy.next;
    }

    public class Node {

        private int value;
        private Node next;

        Node (int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }

}
