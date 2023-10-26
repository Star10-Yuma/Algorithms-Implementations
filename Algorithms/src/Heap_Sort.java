import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Heap_Sort {

    public static int left(int i){
        return (2 * i) + 1;
    }

    public static int right(int i){
        return (2 * i) + 2;
    }

    public static void buildMaxHeap(int[] A){
        int n = A.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            maxHeapify(A, i, n);
        }
    }

    public static void maxHeapify(int[] A, int i, int n){
        int l = left(i);
        int r = right(i);
        int largest;


        if(l < n && A[l] > A[i]){
            largest = l;
        } else {
            largest = i;
        }
        if (r < n && A[r] > A[largest]){
            largest = r;
        }
        if(largest != i){
            swap(A, i, largest);
            maxHeapify(A, largest, n);
        }


    }

    public static int[] getKVids(int k, int[] A) {
        int[] highestViews = new int[k];
        int[] copyofA = Arrays.copyOf(A,A.length);
        buildMaxHeap(copyofA);

        int arrayLength = A.length;
        int i = 0;

        while(arrayLength > 0 && i < k){
            highestViews[i++] = copyofA[0];
            swap(copyofA,0,arrayLength-1);
            arrayLength--;
            maxHeapify(copyofA,0,arrayLength);
        }

        return highestViews;
    }



    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public static void main(String[] args){
        int[] A = {1000000,5000000,100000,60000000,7000000};
//        int[] int1000 = readTxt("int500K.txt");
        buildMaxHeap(A);
        System.out.println(Arrays.toString(A));

        System.out.println();


        int[] k = getKVids(3, A);
        System.out.println(Arrays.toString(k));
//        System.out.println(Arrays.toString(A));


    }
}



