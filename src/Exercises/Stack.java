package Exercises;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> stackList = new ArrayList<>();

    public ArrayList<T> getStackList() {
        return stackList;
    }

    public void printStack() {
        for (int i = stackList.size()-1; i >= 0; i--) {
            System.out.println(stackList.get(i));
        }
    }

    public boolean isEmpty() {
        return stackList.size() == 0;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return stackList.get(stackList.size() - 1);
        }
    }

    public int size() {
        return stackList.size();
    }

    public void push(T dat) {
        stackList.add(dat);
    }

    public T pop() {

        if(stackList == null || stackList.isEmpty()) return null;

        return stackList.remove(stackList.size()-1);
    }

    public void sortStack(Stack<Integer> stack) {

        Stack<Integer> newStack = new Stack();
        while (!stack.isEmpty()){
            int temp = stack.pop();

            while (!newStack.isEmpty() && newStack.peek() > temp) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }

        while (!newStack.isEmpty()) {
            stack.push(newStack.pop());
        }
    }

}
