import java.util.Arrays;

public class main {

        public static void quickSort(int[] A, int p, int r) {
            if (p < r) {
                int[] indices = partition(A, p, r);
                quickSort(A, p, indices[0] - 1);
                quickSort(A, indices[1] + 1, r);
            }
        }

        private static int[] partition(int[] A, int p, int r) {
            int pivot = A[r];
            int i = p - 1;
            int j = r;
            int k = p;
            while (k < j) {
                if (A[k] < pivot) {
                    i = i + 1;
                    swap(A, i, k);
                    k++;
                } else if (A[k] == pivot) {
                    k++;
                } else {
                    j = j - 1;
                    swap(A, j, k);
                }
            }
            swap(A, j, r);
            int[] indices = {i + 1, j};
            return indices;
        }

        private static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

    public static void main(String[] args) {
        int[] A = {10, 80, 30, 90, 40, 50, 70, 70, 90};
        int p = 0;
        int r = A.length - 1;
        quickSort(A, p, r);
        System.out.println(Arrays.toString(A));
    }
    }

