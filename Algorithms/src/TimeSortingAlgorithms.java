import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class TimeSortingAlgorithms {


    public static int[] readTxt(String fileName) {
        ArrayList<Integer> fileData = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File(fileName));
            while (scanner.hasNextInt()) {
                fileData.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int[] fileArray = new int[fileData.size()];
        for (int i = 0; i < fileData.size(); i++) {
            fileArray[i] = fileData.get(i);
        }

        return fileArray;
    }

    public static int[] insertionSortAscending(int[] array) {

        //i = 1 as we need to start at the second index to compare the numbers
        //This for loop will iterate through the whole arraylist
        for (int i = 1; i < array.length; i++) {
            //This current variable stores the current number in the array so the one in index 2 of the list
            int current = array[i];

            //
            int j = i - 1;

            //This while condition will keep going till it is not true
            //The condition checks if j (the index number 0) is greater than 0 and that it is greater than the current variable which is at index 1
            while (j >= 0 && array[j] > current) {
                //This shifts the item in index number j to the right side if it fulfills the condition
                array[j + 1] = array[j];
                //Then we decrement j (so minus by 1) so that it goes back to the original index as in line 21 we shifted it by 1 (so we added 1)
                //j is decremented for the operation below in line 28
                j--;

            }

            //This stores the current number which will be sorted into the list
            //*This sets the current variable which is currently not in the array to the position it should be in
            array[j + 1] = current;


        }
        return array;
    }

    public static void mergeSort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }


    private static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1];
        int[] R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = A[q + j + 1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void quickSort(int[] A, int p, int r) {

        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }
    }

    public static void threeWayQuickSort(int[] A, int p, int r) {
        if (p >= r){
            return;
        }

        if (p < r) {
            int[] q = threeWayPartition(A, p, r);
            quickSort(A, p, q[0] - 1);
            quickSort(A, q[1] + 1, r);
        }
    }

    public static void medianQuickSort(int[] A, int p, int r) {
        int midNum = (p + r) / 2;
        int medianNum = getMedianNum(A[p], A[midNum], A[r]);

        if (medianNum == A[midNum]) {
            swap(A, midNum, r);
        }

        if (medianNum == A[p]) {
            swap(A, p, r);
        }
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }


    }

    public static void quickSortForInsertionSort(int[] A, int p, int r) {
        int k = 3;

        if (r - p + 1 < k) {
            return;
        }
        if (p < r) {
            int q = partition(A, p, r);
            quickSort(A, p, q - 1);
            quickSort(A, q + 1, r);
        }

    }


    public static int partition(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i = i + 1;
                swap(A, i, j);
            }
        }
        swap(A, i + 1, r);
        return i + 1;
    }

    public static int[] threeWayPartition(int[] A, int p, int r) {
        int pivot = A[p];
        int i = p + 1;
        int k = r;
        int j = p;

        while (i <= k) {
            int compareNum = Integer.compare(A[i], pivot);
            if (compareNum < 0) {
                swap(A, j++, i++);

            } else if (compareNum > 0) {
                swap(A, i, k--);
            } else {
                i++;
            }
        }
        int[] array = { j, k};
        return array;
    }

    public static int getMedianNum(int p, int q, int r) {
        int[] array = {p, q, r};
        insertionSortAscending(array);
        int medianNum = array[1];
        return medianNum;
    }


    public static void swap(int[] A, int i, int j) {
        int temporary = A[i];
        A[i] = A[j];
        A[j] = temporary;
    }

    private static long arrayAndSortTypeTimer(int[] array, String sortType) {

        int arrayLength = array.length - 1;
        long startTime = System.nanoTime();

        if (sortType.equals("InsertionSort")) {
            insertionSortAscending(array);
        } else if (sortType.equals("MergeSort")) {
            mergeSort(array, 0, arrayLength);
        } else if (sortType.equals("QuickSort")) {
            quickSort(array, 0, arrayLength);
        } else if (sortType.equals("QuickSortWithInsertionSort")) {
            quickSortForInsertionSort(array, 0, arrayLength);
            insertionSortAscending(array);
        } else if (sortType.equals("ThreeWayQuickSort")) {
            threeWayQuickSort(array, 0, arrayLength);
        } else if (sortType.equals("medianQuickSort")) {
            medianQuickSort(array, 0, arrayLength);
        }

        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        return elapsedTime;
    }

    public static void int20kSortTests() {
        int[] int20k = readTxt("int20k.txt");
        int[] int20kClone1 = int20k.clone();
        int[] int20kClone2 = int20k.clone();
        int[] int20kClone3 = int20k.clone();
        int[] int20kClone4 = int20k.clone();
        int[] int20kClone5 = int20k.clone();


        System.out.println("Testing times using int20k.txt file:");
        System.out.println();
        long int20kInsertionSort = arrayAndSortTypeTimer(int20k, "InsertionSort");
        long int20kMergeSort = arrayAndSortTypeTimer(int20kClone1, "MergeSort");
        long int20kQuickSort = arrayAndSortTypeTimer(int20kClone2, "QuickSort");
        long int20kQuickSortWithInsertionSort = arrayAndSortTypeTimer(int20kClone3, "QuickSortWithInsertionSort");
        long int20kThreeWayQuickSort = arrayAndSortTypeTimer(int20kClone4, "ThreeWayQuickSort");
        long int20kMedianQuickSort = arrayAndSortTypeTimer(int20kClone5, "medianQuickSort");

        System.out.println("Time taken for InsertionSort: " + int20kInsertionSort + " nanoseconds");
        System.out.println("Time taken for MergeSort: " + int20kMergeSort + " nanoseconds");
        System.out.println("Time taken for QuickSort: " + int20kQuickSort + " nanoseconds");
        System.out.println("Time taken for QuickSort with Insertion Sort: " + int20kQuickSortWithInsertionSort + " nanoseconds");
        System.out.println("Time taken for Three Way QuickSort: " + int20kThreeWayQuickSort + " nanoseconds");
        System.out.println("Time taken for Median QuickSort: " + int20kMedianQuickSort + " nanoseconds");

    }

    public static void int1000SortTests() {
        int[] int1000 = readTxt("int1000.txt");
        int[] int1000Clone1 = int1000.clone();
        int[] int1000Clone2 = int1000.clone();
        int[] int1000Clone3 = int1000.clone();
        int[] int1000Clone4 = int1000.clone();
        int[] int1000Clone5 = int1000.clone();

        System.out.println("Testing times using int1000.txt file:");
        System.out.println();
        long int1000InsertionSort = arrayAndSortTypeTimer(int1000, "InsertionSort");
        long int1000MergeSort = arrayAndSortTypeTimer(int1000Clone1, "MergeSort");
        long int1000QuickSort = arrayAndSortTypeTimer(int1000Clone2, "QuickSort");
        long int1000QuickSortWithInsertionSort = arrayAndSortTypeTimer(int1000Clone3, "QuickSortWithInsertionSort");
        long int1000ThreeWayQuickSort = arrayAndSortTypeTimer(int1000Clone4, "ThreeWayQuickSort");
        long int1000MedianQuickSort = arrayAndSortTypeTimer(int1000Clone5, "medianQuickSort");


        System.out.println("Time taken for InsertionSort: " + int1000InsertionSort + " nanoseconds");
        System.out.println("Time taken for MergeSort: " + int1000MergeSort + " nanoseconds");
        System.out.println("Time taken for QuickSort: " + int1000QuickSort + " nanoseconds");
        System.out.println("Time taken for QuickSort with Insertion Sort: " + int1000QuickSortWithInsertionSort + " nanoseconds");
        System.out.println("Time taken for Three Way QuickSort: " + int1000ThreeWayQuickSort + " nanoseconds");
        System.out.println("Time taken for Median QuickSort: " + int1000MedianQuickSort + " nanoseconds");

    }

    public static void int500kSortTests() {
        int[] int500k = readTxt("int500k.txt");
        int[] int500kClone1 = int500k.clone();
        int[] int500kClone2 = int500k.clone();
        int[] int500kClone3 = int500k.clone();
        int[] int500kClone4 = int500k.clone();
        int[] int500kClone5 = int500k.clone();

        System.out.println("Testing times using int500k.txt file:");
        System.out.println();
        long int500kInsertionSort = arrayAndSortTypeTimer(int500k, "InsertionSort");
        long int500kMergeSort = arrayAndSortTypeTimer(int500kClone1, "MergeSort");
        long int500kQuickSort = arrayAndSortTypeTimer(int500kClone2, "QuickSort");
        long int500kQuickSortWithInsertionSort = arrayAndSortTypeTimer(int500kClone3, "QuickSortWithInsertionSort");
        long int500kThreeWayQuickSort = arrayAndSortTypeTimer(int500kClone4, "ThreeWayQuickSort");
        long int500kMedianQuickSort = arrayAndSortTypeTimer(int500kClone5, "medianQuickSort");


        System.out.println("Time taken for InsertionSort: " + int500kInsertionSort + " nanoseconds");
        System.out.println("Time taken for MergeSort: " + int500kMergeSort + " nanoseconds");
        System.out.println("Time taken for QuickSort: " + int500kQuickSort + " nanoseconds");
        System.out.println("Time taken for QuickSort with Insertion Sort: " + int500kQuickSortWithInsertionSort + " nanoseconds");
        System.out.println("Time taken for Three Way QuickSort: " + int500kThreeWayQuickSort + " nanoseconds");
        System.out.println("Time taken for Median QuickSort: " + int500kMedianQuickSort + " nanoseconds");

    }

    public static void intBigSortTests() {
        int[] intBig = readTxt("intBig.txt");
        int[] intBigClone1 = intBig.clone();
        int[] intBigClone2 = intBig.clone();
        int[] intBigClone3 = intBig.clone();
        int[] intBigClone4 = intBig.clone();
        int[] intBigClone5 = intBig.clone();

        //one million numbers
        System.out.println("Testing times using intBig.txt file:");
        System.out.println();
        long intBigInsertionSort = arrayAndSortTypeTimer(intBig, "InsertionSort");
        long intBigMergeSort = arrayAndSortTypeTimer(intBigClone1, "MergeSort");
        long intBigQuickSort = arrayAndSortTypeTimer(intBigClone2, "QuickSort");
        long intBigQuickSortWithInsertionSort = arrayAndSortTypeTimer(intBigClone3, "QuickSortWithInsertionSort");
        long intBigThreeWayQuickSort = arrayAndSortTypeTimer(intBigClone4, "ThreeWayQuickSort");
        long intBigMedianQuickSort = arrayAndSortTypeTimer(intBigClone5, "medianQuickSort");


        System.out.println("Time taken for InsertionSort: " + intBigInsertionSort + " nanoseconds");
        System.out.println("Time taken for MergeSort: " + intBigMergeSort + " nanoseconds");
        System.out.println("Time taken for QuickSort: " + intBigQuickSort + " nanoseconds");
        System.out.println("Time taken for QuickSort with Insertion Sort: " + intBigQuickSortWithInsertionSort + " nanoseconds");
        System.out.println("Time taken for Three Way QuickSort: " + intBigThreeWayQuickSort + " nanoseconds");
        System.out.println("Time taken for Median QuickSort: " + intBigMedianQuickSort + " nanoseconds");

    }

    public static void dutchSortTests() {
        int[] dutch = readTxt("dutch.txt");
        int[] dutchClone1 = dutch.clone();
        int[] dutchClone2 = dutch.clone();
        int[] dutchClone3 = dutch.clone();
        int[] dutchClone4 = dutch.clone();
        int[] dutchClone5 = dutch.clone();

        //half a million numbers
        System.out.println("Testing times using dutch.txt file:");
        System.out.println();
        long dutchInsertionSort = arrayAndSortTypeTimer(dutch, "InsertionSort");
        long dutchMergeSort = arrayAndSortTypeTimer(dutchClone1, "MergeSort");
        long dutchQuickSort = arrayAndSortTypeTimer(dutchClone2, "QuickSort");
        long dutchQuickSortWithInsertionSort = arrayAndSortTypeTimer(dutchClone3, "QuickSortWithInsertionSort");
        long dutchThreeWayQuickSort = arrayAndSortTypeTimer(dutchClone4, "ThreeWayQuickSort");
        long dutchMedianQuickSort = arrayAndSortTypeTimer(dutchClone5, "medianQuickSort");

        System.out.println("Time taken for InsertionSort: " + dutchInsertionSort + " nanoseconds");
        System.out.println("Time taken for MergeSort: " + dutchMergeSort + " nanoseconds");
        System.out.println("Time taken for QuickSort: " + dutchQuickSort + " nanoseconds");
        System.out.println("Time taken for QuickSort with Insertion Sort: " + dutchQuickSortWithInsertionSort + " nanoseconds");
        System.out.println("Time taken for Three Way QuickSort: " + dutchThreeWayQuickSort + " nanoseconds");
        System.out.println("Time taken for Median QuickSort: " + dutchMedianQuickSort + " nanoseconds");

    }


    public static void main(String[] args) {

        System.out.println("_______________________________________________________________________________");
        System.out.println();

        int1000SortTests();

        System.out.println();
        System.out.println("_______________________________________________________________________________");
        System.out.println();

        int20kSortTests();

        System.out.println();
        System.out.println("_______________________________________________________________________________");
        System.out.println();

        int500kSortTests();

        System.out.println();
        System.out.println("_______________________________________________________________________________");
        System.out.println();

        dutchSortTests();

        System.out.println();
        System.out.println("_______________________________________________________________________________");
        System.out.println();

        intBigSortTests();

    }

}



