package recursion;
/*
Problem

Given an array and an element x, return all indexes where x occurs.

Example
Input:
arr = [1, 2, 3, 2, 4, 2]
x = 2

Output:
1 3 5
*/
import java.util.ArrayList;
import java.util.Scanner;

public class FindIndexes {

    // Recursive function to find all indexes
    public static void findIndexes(int[] arr, int index, int x, ArrayList<Integer> ans) {

        // Base Case
        if (index == arr.length) {
            return;
        }

        // If current element matches x, store its index
        if (arr[index] == x) {
            ans.add(index);
        }

        // Recursive Call
        findIndexes(arr, index + 1, x, ans);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int x = sc.nextInt();

        ArrayList<Integer> ans = new ArrayList<>();

        findIndexes(arr, 0, x, ans);

        if (ans.isEmpty()) {
            System.out.println("Element not found.");
        } else {
            System.out.println("Indexes: " + ans);
        }

        sc.close();
    }
}