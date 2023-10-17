public class Queue {

    private Node first;
    private Node last;
    private int length;

    public Queue(int value) {
        Node newNode = new Node(value);
        first = last = newNode;
        length++;
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);
        if(length == 0)
            first = last = newNode;
        else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if(length == 0) return null;

        Node temp = first;
        if(length == 1)
            first = last = null;
        else if(length > 1) {
            first = first.next;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    class Node {
         private int value;
         private Node next;

         Node(int value) {
             this.value = value;
         }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }
}
