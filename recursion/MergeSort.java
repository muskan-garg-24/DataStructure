package recursion;

import java.util.Scanner;

public class MergeSort {

    // Main merge sort function
    public void mergeSort(int arr[], int l, int r) {
        // Base condition: if only one element is left
        if (l >= r) {
            return;
        }

        // Find middle point
        int mid = l + (r - l) / 2;

        // Recursively sort first and second halves
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        // Merge the sorted halves
        merge(arr, l, mid, r);
    }

    // Function to merge two sorted halves
    public void merge(int arr[], int l, int mid, int r) {

        // Sizes of two subarrays
        int n1 = mid - l + 1;
        int n2 = r - mid;

        // Temporary arrays
        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = arr[mid + 1 + j];
        }

        // Merge temp arrays back into original array
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements (if any)
        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }

    // Driver code with user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        MergeSort ms = new MergeSort();

        // Call merge sort
        ms.mergeSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
