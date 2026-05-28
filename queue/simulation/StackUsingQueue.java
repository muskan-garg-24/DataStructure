package queue.simulation;

import java.util.LinkedList;
import java.util.Queue;

class StackUsingQueue {

    Queue<Integer> q;

    public StackUsingQueue() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        q.offer(x);

        int size = q.size();

        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }

    public void printStack() {
        System.out.println(q);
    }

    public static void main(String[] args) {

        StackUsingQueue st = new StackUsingQueue();

        st.push(1);
        st.push(2);
        st.push(3);

        System.out.println(st.top());

        System.out.println(st.pop());

        System.out.println(st.top());

        System.out.println(st.empty());
        st.printStack();

        System.out.println(st.pop());

        System.out.println(st.pop());

        System.out.println(st.empty());

        st.printStack();
    }
}
