
public class Main {

    public static void main(String[] args) {

        LinkedList myLinkedList = new LinkedList();
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        myLinkedList.getHead();
        myLinkedList.getTail();
        myLinkedList.getLength();

//        System.out.println(myLinkedList.findMiddleNode().getValue());
//        System.out.println(myLinkedList.hasLoop());
//        System.out.println(myLinkedList.findKthFromEnd(1).getValue());
//        myLinkedList.remove(0);
//
//        myLinkedList.getHead();
//        myLinkedList.getTail();
//        myLinkedList.getLength();

        myLinkedList.reverseBetween(1, 3);

        System.out.println("\nLinked List:");
        myLinkedList.printList();

    }

}
