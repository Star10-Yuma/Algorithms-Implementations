import java.util.Arrays;

public class ShellSort {

    public static void ShellSort(int [] array) {
        int h = 1;
        int n = array.length;

        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = 1; i < n; i++) {
                for (int j = i; j >= h && array[j] < array[j - h];) {
                    swap(array,j,j-h);
                }
            }
            h = h/3;
        }

    }


    public static void swap (int[] array, int i, int j){
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public static void main(String[] args){
        int[] array = {10,2,3,7,9,4};
        System.out.println("Array without ShellSort: " + Arrays.toString(array));
        ShellSort(array);
        System.out.println("Array with ShellSort: " + Arrays.toString(array));
    }

}
