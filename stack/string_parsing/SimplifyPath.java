package stack.string_parsing;

import java.util.*;

/*
Problem - Simplify Path (LC-71)

 Approach - Stack + String Parsing
 T.C      - O(n)
 S.C      - O(n)
*/

public class SimplifyPath {

    public static void main(String[] args) {

        String path = "/home//foo/";

        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();

        String[] directories = path.split("/");

        for (String directory : directories) {

            if (directory.equals("") || directory.equals(".")) {

                continue;

            } else if (directory.equals("..")) {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                stack.push(directory);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (String directory : stack) {

            answer.append("/");
            answer.append(directory);
        }

        return answer.length() == 0 ? "/" : answer.toString();
    }
}