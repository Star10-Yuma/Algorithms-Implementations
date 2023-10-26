import java.util.Arrays;
public class Heap {
        public static void heapSort(int[] A) {
            int n = A.length;
            buildMaxHeap(A);
            int s = n;
            for (int i = n - 1; i >= 1; i--) {
                swap(A, 0, i);
                s--;
                maxHeapify(A, 0, s);
            }
        }

        public static void buildMaxHeap(int[] A) {
            int n = A.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                maxHeapify(A, i, n);
            }
        }

        public static void maxHeapify(int[] A, int i, int n) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && A[left] > A[largest]) {
                largest = left;
            }
            if (right < n && A[right] > A[largest]) {
                largest = right;
            }
            if (largest != i) {
                swap(A, i, largest);
                maxHeapify(A, largest, n);
            }
        }

    public static int parent(int i) {
        return (i) / 2;
    }

        public static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        heapSort(A);
        System.out.println(Arrays.toString(A));
    }


}
