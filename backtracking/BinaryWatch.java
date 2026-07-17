package backtracking;

import java.util.*;

public class BinaryWatch {

    public static void backtrack(int index, int remaining, int hour, int minute, int[] leds, List<String> ans) {

        if (hour > 11 || minute > 59) {
            return;
        }

        if (remaining == 0) {

            ans.add(hour + ":" + (minute < 10 ? "0" : "") + minute);

            return;
        }

        for (int i = index; i < leds.length; i++) {

            if (i < 4) {
                backtrack(i + 1, remaining - 1, hour + leds[i], minute, leds, ans);
            } else {
                backtrack(i + 1, remaining - 1, hour, minute + leds[i], leds, ans);
            }
        }
    }

    public static List<String> readBinaryWatch(int turnedOn) {

        List<String> ans = new ArrayList<>();

        int[] leds = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

        backtrack(0, turnedOn, 0, 0, leds, ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int turnedOn = sc.nextInt();

        List<String> ans = readBinaryWatch(turnedOn);

        System.out.println(ans);
        sc.close();
    }
}
