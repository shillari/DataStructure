import Exercises.MyQueue;
import Exercises.Stack;

public class Main {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Integer front = queue.dequeue();
        System.out.println(front);

    }

    private static String reverseString(String word) {

        char[] wo = word.toCharArray();
        String k = "";
        for(int i = wo.length-1; i >= 0; i--) {
            k+=wo[i];
        }

        return k;
    }

    public static boolean isBalancedParentheses(String parentheses) {
        Stack<Character> stack = new Stack<>();
        for (char p : parentheses.toCharArray()) {
            if (p == '(') {
                stack.push(p);
            } else if (p == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
