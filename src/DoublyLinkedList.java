public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList() {

    }

    public DoublyLinkedList(int value) {
        Node node = new Node(value);
        head = node;
        tail = node;
        length = 1;
    }

    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {

        Node node = new Node(value);
        if(length == 0) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        length++;
    }

    public Node removeLast() {
        if(head == null) return null;

        Node last = tail;
        if(length == 1) {
            head = tail = null;
        } else {
            tail = last.prev;
            tail.next = null;
            last.prev = null;
        }
        length--;
        return last;
    }

    public void prepend(int value) {

        Node node = new Node(value);
        if(head == null) head = tail = node;
        else {
            head.prev = node;
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst() {

        if(head == null) return null;

        Node removed = head;
        if(length == 1) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
            removed.next = null;
        }
        length--;
        return removed;
    }

    public Node get(int index) {

        if(head == null || index < 0 || index >= length) return null;

        Node selected = null;
        if(index < Math.floorDiv(length, 2)) {
            selected = head;
            for(int i = 0; i < length; i++) {
                if(i == index) return selected;
                selected = selected.next;
            }
        } else {
            selected = tail;
            for(int i = length-1; i >= index; i--) {
                if(i == index) return selected;
                selected = selected.prev;
            }
        }

        return null;
    }

    public boolean set(int index, int value) {

        if(head == null) return false;

        Node selected = get(index);
        if(selected == null) return false;

        selected.value = value;
        return true;
    }

    public boolean insert(int index, int value) {

        if(index < 0 || index > length) return false;

        if(index == 0) {
            prepend(value);
            return true;
        }
        if(index == length) {
            append(value);
            return true;
        }

        Node next = get(index);
        Node prev = next.prev;
        Node newNode = new Node(value);
        prev.next = newNode;
        newNode.prev = prev;
        next.prev = newNode;
        newNode.next = next;
        length++;
        return true;
    }

    public Node remove(int index) {

        if(index < 0 || index >= length) return null;

        if(index == 0) return removeFirst();
        if(index == length-1) return removeLast();

        Node selected = get(index);
        Node prev = selected.prev;
        Node next = selected.next;
        prev.next = next;
        next.prev = prev;
        selected.prev = selected.next = null;
        length--;
        return selected;
    }

    public void swapFirstLast() {

        if(length < 2) return;

        int headValue = head.value;
        head.value = tail.value;
        tail.value = headValue;
    }

    public void reverse() {

        if(length < 2) return;

        Node previous = tail;
        Node current = tail;
        while (current != null){
            previous = current.prev;
            current.prev = current.next;
            current.next = current = previous;
        }
        current = tail;
        tail = head;
        head = current;
    }

    public boolean isPalindrome() {

        if(length <= 1) return true;

        Node beginning = head;
        Node end = tail;
        while (beginning != end) {
            if(beginning.value != end.value) return false;

            beginning = beginning.next;
            end = end.prev;
        }

        return true;
    }

    public void swapPairs() {


    }

    public Node getHead() {
        System.out.println("Head: " + (head == null ? null : head.value));
        return head;
    }

    public Node getTail() {
        System.out.println("Tail: " + (tail == null ? null : tail.value));
        return tail;
    }

    public int getLength() {
        System.out.println("Length: " + length);
        return length;
    }

}
