package queue.simulation;

import java.util.*;

/*
Problem - 649. Dota2 Senate

Brute Approach   - Simulate banning process using string operations
Brute T.C        - O(n^2)
Brute S.C        - O(n)

Optimal Approach - Two Queues Simulation
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class Dota2Senate {

    public static void main(String[] args) {

        String senate = "RDD";

        // System.out.println("Brute: " + predictPartyVictoryBrute(senate));
        System.out.println("Optimal: " + predictPartyVictory(senate));
    }

    public static String predictPartyVictoryBrute(String senate) {

        List<Character> list = new ArrayList<>();

        for (char ch : senate.toCharArray()) {
            list.add(ch);
        }

        int index = 0;

        while (true) {

            int radiant = 0;
            int dire = 0;

            for (char ch : list) {

                if (ch == 'R') {
                    radiant++;
                } else {
                    dire++;
                }
            }

            if (radiant == 0) {
                return "Dire";
            }

            if (dire == 0) {
                return "Radiant";
            }

            char current = list.get(index);

            for (int i = 1; i < list.size(); i++) {

                int next = (index + i) % list.size();

                if (list.get(next) != current) {

                    list.remove(next);

                    if (next < index) {
                        index--;
                    }

                    break;
                }
            }

            index = (index + 1) % list.size();
        }
    }

    public static String predictPartyVictory(String senate) {

        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        for (int i = 0; i < n; i++) {

            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {

            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            if (rIndex < dIndex) {

                radiant.offer(rIndex + n);

            } else {

                dire.offer(dIndex + n);
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}