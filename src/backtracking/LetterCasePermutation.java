package backtracking;

import java.util.*;

public class LetterCasePermutation {

    public static void backtrack(int index, char[] chars, List<String> ans) {

        if (index == chars.length) {
            ans.add(new String(chars));
            return;
        }

        if (Character.isDigit(chars[index])) {

            backtrack(index + 1, chars, ans);

        } else {

            // Lowercase
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(index + 1, chars, ans);

            // Uppercase
            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(index + 1, chars, ans);
        }
    }

    public static List<String> letterCasePermutation(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(0, s.toCharArray(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        List<String> ans = letterCasePermutation(s);

        System.out.println(ans);
        sc.close();
    }
}