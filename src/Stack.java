public class Stack {

    private Node top;
    private int height;

    public Stack(int value) {
        Node first = new Node(value);
        this.top = first;
        height++;
    }

    public void push(int value) {
        Node newNode = new Node(value);

        if(height > 0) {
            newNode.next = top;
        }
        top = newNode;
        height++;
    }

    public Node pop() {
        if(height > 0) {
            Node temp = top;
            top = top.next;
            temp.next = null;
            height--;
            return temp;
        }
        return null;
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
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

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
}
