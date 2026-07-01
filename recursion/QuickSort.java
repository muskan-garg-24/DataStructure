package recursion;

public class QuickSort {

    // Main Quick Sort function
    public void quickSort(int[] arr, int low, int high) {
        // Base condition: 0 or 1 element
        if (low < high) {

            // Partitioning index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Partition function (Lomuto Partition Scheme)
    private int partition(int[] arr, int low, int high) {

        // Choosing last element as pivot
        int pivot = arr[high];

        // Index of smaller element
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Optional: Driver code for testing
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        QuickSort qs = new QuickSort();

        qs.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
