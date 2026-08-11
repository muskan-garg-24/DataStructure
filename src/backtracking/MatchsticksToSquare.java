package backtracking;

import java.util.*;

public class MatchsticksToSquare {

    public static boolean backtrack(int index, int[] matchsticks, int[] sides, int target) {

        if (index == matchsticks.length) {

            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;
        }

        for (int i = 0; i < 4; i++) {

            if (sides[i] + matchsticks[index] > target) {
                continue;
            }

            sides[i] += matchsticks[index];

            if (backtrack(index + 1, matchsticks, sides, target)) {
                return true;
            }

            sides[i] -= matchsticks[index];

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }

    public static void reverse(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    public static boolean makesquare(int[] matchsticks) {

        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;

        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        Arrays.sort(matchsticks);
        reverse(matchsticks);

        int[] sides = new int[4];

        return backtrack(0, matchsticks, sides, sum / 4);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] matchsticks = new int[n];

        for (int i = 0; i < n; i++) {
            matchsticks[i] = sc.nextInt();
        }

        System.out.println(makesquare(matchsticks));
        sc.close();
    }
}
