import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] array, int l, int h){
        if(l < h){
            int pivot = partition(array,l,h);
            sort(array,l,pivot-1);
            sort(array,pivot+1,h);
        }
    }

    public static int partition(int[] array, int l, int h){
        int pivot = array[h];
        int i = l - 1;
        int j = l;

        while(j < h){
            if(array[j] <=pivot){
                i++;
                swap(array, i, j);
            }
            j++;
        }
        swap(array, i+1, h);
        return i + 1;

    }

    public static void swap (int[] array, int i, int j){
        int temporary = array[i];
        array[i] = array[j];
        array[j] = temporary;
    }

    public static void main(String[] args){
        int[] array = {10,2,3,7,9,4};
        System.out.println("Array without QuickSort: " + Arrays.toString(array));
        int lastElementIndexNum = array.length - 1;
        sort(array, 0, lastElementIndexNum);
        System.out.println("Array with QuickSort: " + Arrays.toString(array));
    }
}
