import java.util.Arrays;

public class SelectionSort {


    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int iMinNum = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[iMinNum]) {
                    iMinNum = j;
                }

            }

            if (iMinNum != i) {

                int temp = array[iMinNum];
                array[iMinNum] = array[i];
                array[i] = temp;

            }

        }

    }

    public static void timeTestResultsSelectSort(int[] array) {
        int num = 11;
        long totalTime = 0;

        System.out.println("Selection Sort TEST:");

        for (int i = 1; i < num; i++) {
            long startTime = System.nanoTime();
            selectionSort(array);
            long endTime = System.nanoTime();
            long elapsedTime = endTime - startTime;
            System.out.print("Time test " + i + " :" + " " + elapsedTime + " nanoseconds");
            System.out.println();
            totalTime += elapsedTime;
        }

        long averageTime = totalTime / 10;

        System.out.println();

        System.out.println("Total time of all these tests is: " + totalTime + " nanoseconds");
        System.out.println("The average time taken of these tests is: " + averageTime + " nanoseconds");

    }

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 6, 8, 7, 0, 9};

        InsertionSort.timeTestResults(numbers);

        System.out.println();

        timeTestResultsSelectSort(numbers);


    }
}
