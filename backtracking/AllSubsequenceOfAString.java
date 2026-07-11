package backtracking;
import java.util.*;
class AllSubsequenceOfAString {
    
    public List<String> powerSet(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(0, s, new StringBuilder(), ans);
        Collections.sort(ans);
        return ans;
    }
    
    private void backtrack(int index, String s, StringBuilder current, List<String> ans) {
        
        if (index == s.length()) {
            ans.add(current.toString());
            return;
        }

        current.append(s.charAt(index));
        backtrack(index + 1, s, current, ans);

        current.deleteCharAt(current.length() - 1);

        backtrack(index + 1, s, current, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        AllSubsequenceOfAString sol = new AllSubsequenceOfAString();
        List<String> result = sol.powerSet(s);

        System.out.println(result);
        sc.close();
    }
} 