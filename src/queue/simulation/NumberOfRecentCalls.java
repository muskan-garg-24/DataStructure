package queue.simulation;

import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.offer(t);

        while (queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}

public class NumberOfRecentCalls {

    public static void main(String[] args) {

        RecentCounter rc = new RecentCounter();

        System.out.println(rc.ping(1));     
        System.out.println(rc.ping(100));   
        System.out.println(rc.ping(3001));  
        System.out.println(rc.ping(3002));  
        System.out.println(" ");


        RecentCounter rc2 = new RecentCounter();

        System.out.println(rc2.ping(10));    
        System.out.println(rc2.ping(2000));  
        System.out.println(rc2.ping(5000));  
        System.out.println(" ");


        RecentCounter rc3 = new RecentCounter();

        System.out.println(rc3.ping(1));     
        System.out.println(rc3.ping(4000));  
        System.out.println(rc3.ping(7000)); 
        System.out.println(" "); 


        RecentCounter rc4 = new RecentCounter();

        System.out.println(rc4.ping(1000));  
        System.out.println(rc4.ping(2000));  
        System.out.println(rc4.ping(3000));  
        System.out.println(rc4.ping(4000));  
        System.out.println(rc4.ping(8000));  
    }
}



