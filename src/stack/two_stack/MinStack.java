package stack.two_stack;

import java.util.*;

/*
Problem - Min Stack (LC-155)

 Approach - Two Stacks
 T.C      - push  -> O(1)
            pop   -> O(1)
            top   -> O(1)
            getMin-> O(1)
 S.C      - O(n)
*/

public class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {

        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Min: " + minStack.getMin());

        minStack.pop();

        System.out.println("Top: " + minStack.top());
        System.out.println("Min: " + minStack.getMin());
    }

    public void push(int val) {

        stack.push(val);

        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {

        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }

        stack.pop();
    }

    public int top() {

        return stack.peek();
    }

    public int getMin() {

        return minStack.peek();
    }
}