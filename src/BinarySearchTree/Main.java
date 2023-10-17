package BinarySearchTree;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(47);
        tree.insert(21);
        tree.insert(76);
        tree.insert(18);
        tree.insert(52);
        tree.insert(82);
        tree.insert(27);

        System.out.println("Contains 17: " + tree.contains(17));
        System.out.println("Contains 0: " + tree.contains(0));
        System.out.println("Contains 76: " + tree.contains(76));

        System.out.println(tree.root.left.right.value);
    }
}
