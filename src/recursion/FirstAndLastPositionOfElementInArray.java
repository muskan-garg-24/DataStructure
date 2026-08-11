package recursion;

import java.util.Scanner;
class FirstAndLastPositionOfElementInArray {

    public static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target, 0, nums.length - 1);
        int last = findLast(nums, target, 0, nums.length - 1);

        return new int[]{first, last};
    }

    // Recursive function to find first occurrence
    private static int findFirst(int[] nums, int target, int low, int high) {

        // Base Case
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {

            // Check if this is the first occurrence
            if (mid == 0 || nums[mid - 1] != target) {
                return mid;
            }

            return findFirst(nums, target, low, mid - 1);
        }

        if (nums[mid] < target) {
            return findFirst(nums, target, mid + 1, high);
        }

        return findFirst(nums, target, low, mid - 1);
    }

    // Recursive function to find last occurrence
    private static int findLast(int[] nums, int target, int low, int high) {

        // Base Case
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        if (nums[mid] == target) {

            // Check if this is the last occurrence
            if (mid == nums.length - 1 || nums[mid + 1] != target) {
                return mid;
            }

            return findLast(nums, target, mid + 1, high);
        }

        if (nums[mid] < target) {
            return findLast(nums, target, mid + 1, high);
        }

        return findLast(nums, target, low, mid - 1);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] ans = searchRange(nums, target);

        System.out.println("First Occurrence = " + ans[0]);
        System.out.println("Last Occurrence = " + ans[1]);

        sc.close();
    }
} 