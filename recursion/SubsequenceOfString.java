package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubsequenceOfString {
  public static List<String> powerSet(String s) {

        List<String> ans = new ArrayList<>();

        helper(s, 0, "", ans);

        Collections.sort(ans);

        return ans;
    }

    // Recursive function
    private static void helper(String s, int index, String current, List<String> ans) {

        // Base Case
        if (index == s.length()) {
            ans.add(current);
            return;
        }

        // Include current character
        helper(s, index + 1, current + s.charAt(index), ans);

        // Exclude current character
        helper(s, index + 1, current, ans);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        List<String> result = powerSet(s);

        System.out.println("All Subsequences:");

        for (String str : result) {
            System.out.println("\"" + str + "\"");
        }

        sc.close();
    }
}
