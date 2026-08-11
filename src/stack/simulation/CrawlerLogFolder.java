package stack.simulation;

import java.util.*;

/*
Problem - Crawler Log Folder (LC-1598)

 Approach - Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class CrawlerLogFolder {

    public static void main(String[] args) {

        String[] logs = {"d1/", "d2/", "../", "d21/", "./"};

        System.out.println(minOperations(logs));
    }
      
    public static int minOperations(String[] logs) {
      
        Stack<String> stack = new Stack<>();

        for (String log : logs) {

            if (log.equals("../")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else if (log.equals("./")) {

                continue;

            } else {

                stack.push(log);
            }
        }

        return stack.size();
    }
}