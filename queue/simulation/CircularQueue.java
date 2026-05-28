package queue.simulation;

class CircularQueue {

    int[] arr;
    int front;
    int rear;
    int size;
    int count;

    public CircularQueue(int k) {

        arr = new int[k];
        size = k;

        front = 0;
        rear = -1;
        count = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % size;

        arr[rear] = value;

        count++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % size;

        count--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public void printQueue() {

        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
    }
    public static void main(String[] args) {

        CircularQueue q = new CircularQueue(3);

        System.out.println(q.enQueue(1));
        System.out.println(q.enQueue(2));
        System.out.println(q.enQueue(3));
        System.out.println(q.enQueue(4));

        System.out.println(q.Rear());

        System.out.println(q.isFull());
        q.printQueue();

        System.out.println(q.deQueue());

        System.out.println(q.enQueue(4));

        System.out.println(q.Rear());

        q.printQueue();
    }
}
