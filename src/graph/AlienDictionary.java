package graph;

import java.util.*;

public class AlienDictionary {

    public static String findOrder(String[] words) {

        int[] indegree = new int[26];
        boolean[] exists = new boolean[26];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }

        // Mark existing characters
        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Build graph
        for (int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());

            int j = 0;

            while (j < len && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }

            // Invalid:
            // longer word comes before its prefix
            if (j == len) {

                if (s1.length() > s2.length()) {
                    return "";
                }

                continue;
            }

            int u = s1.charAt(j) - 'a';
            int v = s2.charAt(j) - 'a';

            graph.get(u).add(v);
            indegree[v]++;
        }

        // Topological Sort
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {

            if (exists[i] && indegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            result.append((char) (node + 'a'));

            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Count unique characters
        int uniqueChars = 0;

        for (boolean present : exists) {
            if (present) {
                uniqueChars++;
            }
        }

        // Cycle detected
        if (result.length() != uniqueChars) {
            return "";
        }

        return result.toString();
    }

    public static void main(String[] args) {

        String[] words = {
            "baa",
            "abcd",
            "abca",
            "cab",
            "cad"
        };

        String order = findOrder(words);

        System.out.println(order);
    }
}