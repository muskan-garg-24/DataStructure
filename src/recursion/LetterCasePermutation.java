package recursion;

import java.util.*;

public class LetterCasePermutation {

    public static List<String> letterCasePermutation(String s) {

        List<String> ans = new ArrayList<>();

        helper(s.toCharArray(), 0, ans);

        return ans;
    }

    public static void helper(char[] str, int index, List<String> ans) {

        // Base Case
        if (index == str.length) {
            ans.add(new String(str));
            return;
        }

        // If current character is a digit
        if (Character.isDigit(str[index])) {
            helper(str, index + 1, ans);
            return;
        }

        // Lowercase
        str[index] = Character.toLowerCase(str[index]);
        helper(str, index + 1, ans);

        // Uppercase
        str[index] = Character.toUpperCase(str[index]);
        helper(str, index + 1, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter String: ");
        String s = sc.next();

        List<String> ans = letterCasePermutation(s);

        System.out.println(ans);

        sc.close();
    }
}