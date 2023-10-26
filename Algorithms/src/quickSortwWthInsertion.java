import java.util.Arrays;

public class quickSortwWthInsertion {

    public static void quicksort(int[] arr, int left, int right, int k) {
        if (right - left + 1 < k) {
            return; // return without sorting the subarray if it has fewer than k elements
        }
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quicksort(arr, left, pivotIndex - 1, k);
            quicksort(arr, pivotIndex + 1, right, k);
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = current;
        }
    }

    public static void quicksortWithInsertionSort(int[] arr, int k) {
        quicksort(arr, 0, arr.length - 1, k);
        insertionSort(arr); // run insertion sort on the entire array to finish the sorting process
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] A = {3, 7, 5, 2, 9, 6, 2, 9, 67, 99};
        int p = 0;
        int r = A.length - 1;
        quicksort(A, p, r,5);
        System.out.println(Arrays.toString(A));
        quicksortWithInsertionSort(A,10);
        System.out.println(Arrays.toString(A));

    }
}
