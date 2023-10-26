import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int array[], int lowerBound, int upperBound) {

        int midElement = 0;
        if (lowerBound < upperBound) {
            midElement = (lowerBound + upperBound) / 2;
            int midOne = midElement + 1;
            mergeSort(array, lowerBound, midElement);
            mergeSort(array, midOne, upperBound);
            merge(array, lowerBound, midElement, upperBound);
        }
    }

    public static void merge(int array[], int lowerBound, int midElement, int upperBound) {
        int i = lowerBound;
        int j = midElement + 1;
        int k = lowerBound;

        int[] sortedArray = new int[upperBound + 1];

        while (i <= midElement && j <= upperBound) {
            if (array[i] <= array[j]) {
                sortedArray[k] = array[i];
                i++;
            } else {
                sortedArray[k] = array[j];
                k++;
            }
        }

        if (i > midElement) {
            while (j <= upperBound) {
                sortedArray[k] = array[j];
                j++;
                k++;
            }
        } else {
            while (i <= midElement) {
                sortedArray[k] = array[i];
                i++;
                k++;
            }
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 7, 6, 8};
        mergeSort(array, 1, 8);
    }
}

