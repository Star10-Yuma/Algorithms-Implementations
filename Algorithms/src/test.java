import java.util.Arrays;

public class test {



    public static int left(int i) {
        return 2 * i + 1;
    }

    public static int right(int i) {
        return 2 * i + 2;
    }

    public static void buildMaxHeap(int[] arr, int n) {
        // Starting from the last non-leaf node and moving upwards,
        // call maxHeapify on each node to create a max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, n, i);
        }
    }

    public static void maxHeapify(int[] arr, int n, int i) {
        // Find the left and right children of the current node
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Assume the current node is the largest
        int largest = i;

        // Compare the current node with its left and right children, if they exist
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If the largest node is not the current node, swap them and recursively
        // call maxHeapify on the largest node
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            maxHeapify(arr, n, largest);
        }
    }


    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args){
        int[] A = {1000000,5000000,10,3000000};
        buildMaxHeap(A, A.length);
        System.out.println(Arrays.toString(A));
//        int[] k = getTopK(4,A);
//        System.out.println(Arrays.toString(k));

    }
}
