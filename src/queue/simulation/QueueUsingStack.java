package queue.simulation;

import java.util.Stack;

class QueueUsingStack {

    Stack<Integer> input;
    Stack<Integer> output;

    public QueueUsingStack() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    public int peek() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }

    public void printQueue() {

    System.out.println("Input Stack: " + input);

    System.out.println("Output Stack: " + output);
   }

    public static void main(String[] args) {

        QueueUsingStack q = new QueueUsingStack();

        q.push(1);
        q.push(2);
        q.push(3);

        System.out.println(q.peek());

        System.out.println(q.pop());

        System.out.println(q.peek());

        System.out.println(q.empty());
        q.printQueue();

        System.out.println(q.pop());

        System.out.println(q.pop());

        System.out.println(q.empty());

        q.printQueue();
    }
}
