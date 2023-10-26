public class median {

        public static void quickSort(int[] A, int p, int r) {
            if (p < r) {
                int q = partition(A, p, r);
                quickSort(A, p, q - 1);
                quickSort(A, q + 1, r);
            }
        }

        private static int partition(int[] A, int p, int r) {
            int mid = (p + r) / 2;
            int median = getMedian(A[p], A[mid], A[r]);
            int pivotIndex = p;
            if (median == A[mid]) {
                pivotIndex = mid;
            } else if (median == A[r]) {
                pivotIndex = r;
            }
            int pivot = A[pivotIndex];
            swap(A, pivotIndex, r);
            int i = p - 1;
            for (int j = p; j <= r - 1; j++) {
                if (A[j] <= pivot) {
                    i = i + 1;
                    swap(A, i, j);
                }
            }
            swap(A, i + 1, r);
            return i + 1;
        }

        private static int getMedian(int a, int b, int c) {
            int median = a;
            if ((b <= a && a <= c) || (c <= a && a <= b)) {
                median = a;
            } else if ((a <= b && b <= c) || (c <= b && b <= a)) {
                median = b;
            } else if ((a <= c && c <= b) || (b <= c && c <= a)) {
                median = c;
            }
            return median;
        }

        private static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        public static void main(String[] args) {
            int[] A = {3, 7, 5, 2, 9, 6, 2, 9, 67, 99};
            int p = 0;
            int r = A.length - 1;
            quickSort(A, p, r);
            for (int i = 0; i < A.length; i++) {
                System.out.print(A[i] + " ");
            }
            System.out.println();
            int length = A.length-1;
            System.out.println(getMedian(A[0], A[length/2], A[length]));
        }
    }

