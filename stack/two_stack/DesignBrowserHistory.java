package stack.two_stack;

import java.util.*;

/*
Problem - Design Browser History (LC-1472)

 Approach - Two Stacks
 T.C      - visit -> O(1)
             back -> O(steps)
             forward -> O(steps)
 S.C      - O(n)
*/

public class DesignBrowserHistory {

    private String currentPage;

    private Stack<String> backStack;
    private Stack<String> forwardStack;

    public DesignBrowserHistory(String homepage) {

        currentPage = homepage;

        backStack = new Stack<>();
        forwardStack = new Stack<>();
    }

    public static void main(String[] args) {

        DesignBrowserHistory browser = new DesignBrowserHistory("leetcode.com");

        browser.visit("google.com");
        browser.visit("facebook.com");
        browser.visit("youtube.com");

        System.out.println(browser.back(1));      // facebook.com
        System.out.println(browser.back(1));      // google.com
        System.out.println(browser.forward(1));   // facebook.com

        browser.visit("linkedin.com");

        System.out.println(browser.forward(2));   // linkedin.com
        System.out.println(browser.back(2));      // google.com
        System.out.println(browser.back(7));      // leetcode.com
    }

    public void visit(String url) {

        backStack.push(currentPage);

        currentPage = url;

        forwardStack.clear();
    }

    public String back(int steps) {

        while (steps > 0 && !backStack.isEmpty()) {

            forwardStack.push(currentPage);

            currentPage = backStack.pop();

            steps--;
        }

        return currentPage;
    }

    public String forward(int steps) {

        while (steps > 0 && !forwardStack.isEmpty()) {

            backStack.push(currentPage);

            currentPage = forwardStack.pop();

            steps--;
        }

        return currentPage;
    }
}