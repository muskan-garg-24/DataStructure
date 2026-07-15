package backtracking;

import java.util.*;

public class SplittingStringIntoDescendingConsecutiveValues {

    public static boolean backtrack(int index, long previous, int count, String s) {

        if (index == s.length()) {
            return count >= 2;
        }

        long current = 0;

        for (int i = index; i < s.length(); i++) {

            current = current * 10 + (s.charAt(i) - '0');

            if (previous == -1 || current == previous - 1) {

                if (backtrack(i + 1, current, count + 1, s)) {
                    return true;
                }

            } else if (previous != -1 && current >= previous) {
                break;
            }
        }

        return false;
    }

    public static boolean splitString(String s) {
        return backtrack(0, -1, 0, s);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(splitString(s));
        sc.close();
    }
}
