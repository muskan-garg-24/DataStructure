package backtracking;

import java.util.*;

public class PalindromePartitioning {

    public static void backtrack(int start, String s, List<String> current, List<List<String>> ans) {

        if (start == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                current.add(s.substring(start, end + 1));

                backtrack(end + 1, s, current, ans);

                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(0, s, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        List<List<String>> ans = partition(s);

        System.out.println(ans);
        sc.close();
    }
}
