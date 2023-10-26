import java.util.Arrays;

public class threeway {

        public static void quickSort(int[] A, int p, int r) {

            if(p >= r){
                return;
            }

            if (p < r) {
                int[] q = partition(A, p, r);
                quickSort(A, p, q[0] - 1);
                quickSort(A, q[1] + 1, r);
            }
        }

        private static int[] partition(int[] A, int p, int r) {

            int pivot = A[p];
            int i = p + 1;
            int k = r;
            int j = p;


            while (i <= k) {
                int comparenum = 0;

                if(A[i] < pivot){
                    comparenum = -1;
                }

                if(A[i] > pivot){
                    comparenum = 1;
                }

                if (comparenum < 0) {
                    swap(A, j++, i++);

                } else if (comparenum > 0) {
                    swap(A, i, k--);
                } else {
                    i++;
                }
            }
            int[] array = { j, k};
            return array;
        }

        private static void swap(int[] A, int i, int j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }

        public static void main(String[] args) {
            int[] A = {10, 80, 30, 90, 40, 50, 70, 70, 90};
            int length = A.length - 1;

            System.out.println("Before three way quick sort");
            System.out.println(Arrays.toString(A));

            System.out.println();

            quickSort(A, 0, length);
            System.out.println("After three way quick sort");
            System.out.println(Arrays.toString(A));

        }
    }

