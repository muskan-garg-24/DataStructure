package stack.two_stack;

import java.util.*;

/*
Problem - Design a Text Editor (LC-2296)

 Approach - Two Stacks

 T.C      - addText -> O(text.length())
            deleteText -> O(k)
            cursorLeft -> O(k)
            cursorRight-> O(k)
 S.C      - O(n)
*/

public class DesignTextEditor {

    private Stack<Character> left;
    private Stack<Character> right;

    public DesignTextEditor() {

        left = new Stack<>();
        right = new Stack<>();
    }

    public static void main(String[] args) {

        DesignTextEditor editor = new DesignTextEditor();

        editor.addText("leetcode");

        System.out.println(editor.deleteText(4));     // 4

        editor.addText("practice");

        System.out.println(editor.cursorRight(3));    // practice

        System.out.println(editor.cursorLeft(8));     // leet

        System.out.println(editor.deleteText(10));    // 4

        System.out.println(editor.cursorLeft(2));     // ""

        System.out.println(editor.cursorRight(6));    // practi
    }

    public void addText(String text) {

        for (char ch : text.toCharArray()) {
            left.push(ch);
        }
    }

    public int deleteText(int k) {

        int deleted = 0;

        while (k > 0 && !left.isEmpty()) {

            left.pop();

            deleted++;
            k--;
        }

        return deleted;
    }

    public String cursorLeft(int k) {

        while (k > 0 && !left.isEmpty()) {

            right.push(left.pop());

            k--;
        }

        return getLast10Characters();
    }

    public String cursorRight(int k) {

        while (k > 0 && !right.isEmpty()) {

            left.push(right.pop());

            k--;
        }

        return getLast10Characters();
    }

    private String getLast10Characters() {

        StringBuilder sb = new StringBuilder();

        int count = 0;

        for (int i = left.size() - 1;
             i >= 0 && count < 10;
             i--, count++) {

            sb.append(left.get(i));
        }

        return sb.reverse().toString();
    }
}