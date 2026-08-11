package recursion;

import java.util.*;

public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        helper(n, 0, 0, "", ans);

        return ans;
    }

    public static void helper(int n, int open, int close, String current, List<String> ans) {

        // Base Case
        if (current.length() == 2 * n) {
            ans.add(current);
            return;
        }

        // Include '('
        if (open < n) {
            helper(n, open + 1, close, current + "(", ans);
        }

        // Include ')'
        if (close < open) {
            helper(n, open, close + 1, current + ")", ans);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        List<String> ans = generateParenthesis(n);

        System.out.println(ans);

        sc.close();
    }
}