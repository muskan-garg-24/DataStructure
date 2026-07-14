package backtracking;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {

    static String[] map = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public static void backtrack(int index, String digits, StringBuilder current, List<String> ans) {

        if (index == digits.length()) {
            ans.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            current.append(letters.charAt(i));

            backtrack(index + 1, digits, current, ans);

            current.deleteCharAt(current.length() - 1);
        }
    }

    public static List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }

        backtrack(0, digits, new StringBuilder(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String digits = sc.next();

        List<String> ans = letterCombinations(digits);

        System.out.println(ans);
        sc.close();
    }
}