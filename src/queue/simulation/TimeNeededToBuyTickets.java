package queue.simulation;

import java.util.LinkedList;
import java.util.Queue;

class TimeNeededToBuyTickets {

    public static int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.offer(i);
        }

        int time = 0;

        while (!q.isEmpty()) {

            int index = q.poll();

            tickets[index]--;

            time++;

            if (tickets[index] == 0 && index == k) {
                return time;
            }

            if (tickets[index] > 0) {
                q.offer(index);
            }
        }

        return time;
    }

    public static void main(String[] args) {


        int[] tickets1 = {2, 3, 2};
        int k1 = 2;

        System.out.println(timeRequiredToBuy(tickets1, k1));
        System.out.println(" ");


        int[] tickets2 = {5, 1, 1, 1};
        int k2 = 0;

        System.out.println(timeRequiredToBuy(tickets2, k2));
        System.out.println(" ");


        int[] tickets3 = {1, 1, 1};
        int k3 = 2;

        System.out.println(timeRequiredToBuy(tickets3, k3));
        System.out.println(" ");


        int[] tickets4 = {2, 2, 2};
        int k4 = 1;

        System.out.println(timeRequiredToBuy(tickets4, k4));
    }
}