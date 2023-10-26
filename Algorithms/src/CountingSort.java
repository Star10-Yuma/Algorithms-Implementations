import java.util.Arrays;

public class CountingSort {


    public static int getMaxNum(int[] array) {
        int arrayLength = array.length;
        int maxNum = 0;

        for (int i = 0; i < arrayLength; i++) {
            if (array[i] > maxNum) {
                maxNum = array[i];
            }
        }

        return maxNum;
    }

    public static int[] countSort(int[] array) {
        int n = array.length;
        int k = getMaxNum(array);

        int[] count = new int[k + 1];

        for (int i = 0; i < n; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= k; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] outputArray = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            outputArray[count[array[i]]-1] = array[i];
            count[array[i]]--;
        }

        for (int i = 0; i < n; i++) {
            array[i] = outputArray[i];
        }


        return outputArray;

    }


    public static void main(String[] args) {
        int[] numArr = {2,1,1,0,2,5,4,0,2,8,7,7,9,2,0,1,9};
        int[] sortedArr = countSort(numArr);

        System.out.println(Arrays.toString(sortedArr));
    }
}
