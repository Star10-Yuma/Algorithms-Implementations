import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadixSort {

        public static void radixSort(int[] A, int d) {
            for (int i = 1; i <= d; i++) {
                stableSortOnDigit(A, i);
            }
        }

        private static void stableSortOnDigit(int[] A, int digit) {
            int n = A.length;

            // Create a list of empty lists to hold elements based on the digit
            List<List<Integer>> buckets = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<>());
            }

            // Add elements to the appropriate bucket based on the digit
            for (int i = 0; i < n; i++) {
                int digitValue = (int)(A[i] / Math.pow(10, digit - 1)) % 10;
                buckets.get(digitValue).add(A[i]);
            }

            // Concatenate the lists and update the original array
            int index = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < buckets.get(i).size(); j++) {
                    A[index++] = buckets.get(i).get(j);
                }
            }
        }


    public static void main(String[] args){
        int [] array = {10,300,495,40};
        radixSort(array, 3);

        System.out.println(Arrays.toString(array));
    }

}
