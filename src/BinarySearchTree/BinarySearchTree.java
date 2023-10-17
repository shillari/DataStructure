package BinarySearchTree;

import Exercises.Stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

    Node root;

    public boolean insert(int value) {

        Node newNode = new Node(value);

        if(root == null) {
            root = newNode;
            return true;
        }

        Node temp = root;
        while (temp != null) {
            if(temp.getValue() == value) return false;

            if(value > temp.getValue()) {
                if(temp.getRight() == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.getRight();
            } else {
                if(temp.getLeft() == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.getLeft();
            }
        }
        return false;
    }

    public boolean contains(int value) {

        if(root == null) return false;

        Node temp = root;
        while (temp != null) {
            if(value == temp.getValue()) return true;

            if(value < temp.getValue())
                temp = temp.getLeft();
            else
                temp = temp.getRight();
        }
        return false;
    }

    private Node deleteNode(Node currentNode, int value) {

        if(currentNode == null) return null;

        if(value < currentNode.getValue()) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if(value > currentNode.getValue()) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {
            if(currentNode.left == null && currentNode.right == null) {
                currentNode = null;
            } else if(currentNode.left == null) {
                currentNode = currentNode.right;
            } else if(currentNode.right == null) {
                currentNode = currentNode.left;
            } else {
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right, value);
            }
        }

        return currentNode;
    }

    private boolean rContains(Node currentNode, int value) {

        if(currentNode == null) return false;

        if(currentNode.value == value) return true;

        if(value < currentNode.value) {
            return rContains(currentNode.left, value);
        }

        return rContains(currentNode.right, value);
    }

    private Node rInsert(Node currentNode, int value) {
        if (currentNode == null) return new Node(value);

        if (value < currentNode.value) {
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }

    /*
     * public methods
     */
    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    public boolean rContains(int value) {
        return rContains(root, value);
    }

    public int minValue(Node currentNode) {

        while (currentNode.left != null) {
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public ArrayList<Integer> BFS() {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);

        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.value);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                results.add(currentNode.value);
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInOrder() {
        ArrayList<Integer> results = new ArrayList<>();

        class Traverse {
            Traverse(Node currentNode) {
                if (currentNode.left != null) {
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if (currentNode.right != null) {
                    new Traverse(currentNode.right);
                }
            }
        }

        new Traverse(root);
        return results;
    }

    public Integer kthSmallest(int k) {
        Stack<Node> stack = new Stack<>();
        Node node = this.root;

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            k -= 1;
            if (k == 0) {
                return node.value;
            }
            node = node.right;
        }
        return null;
    }

    class Node {

        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
    }
}
