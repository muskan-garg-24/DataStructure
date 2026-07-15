package backtracking;

import java.util.*;

public class RestoreIPAddresses {

    public static void backtrack(int index,
                                 int parts,
                                 String s,
                                 List<String> current,
                                 List<String> ans) {

        if (parts == 4 && index == s.length()) {
            ans.add(String.join(".", current));
            return;
        }

        if (parts == 4 || index == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if (isValid(part)) {

                current.add(part);

                backtrack(index + len, parts + 1, s, current, ans);

                current.remove(current.size() - 1);
            }
        }
    }

    public static boolean isValid(String part) {

        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(part);

        return value >= 0 && value <= 255;
    }

    public static List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(0, 0, s, new ArrayList<>(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        List<String> ans = restoreIpAddresses(s);

        System.out.println(ans);
        sc.close();
    }
}
