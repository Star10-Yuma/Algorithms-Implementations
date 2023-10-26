import java.util.Arrays;

public class InsertionSort {


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

    public static boolean ascendingOrderChecker(int[] array){

        for(int i = 0; i < array.length; i++){
            //This checks if the number currently in that index is less than the one on the right position (the number that is right after it)
            if(array[i] > array[i + 1]){
                return false;
            }

        }

        return true;

    }


    public static void insertionSortDescending(int[] array) {

        //i = 1 as we need to start at the second index to compare the numbers
        //This for loop will iterate through the whole arraylist
        for (int i = 1; i < array.length; i++) {
            //This current variable stores the current number in the array so the one in index 2 of the list
            int current = array[i];

            //
            int j = i - 1;

            //This while condition will keep going till it is not true
            //The condition checks if j (the index number 0) is greater than 0 and that it is greater than the current variable which is at index 1
            //**To make this descending I just changed the > to < less than so that it moves the lower value integers to the right (end of the list)**
            while (j >= 0 && array[j] < current) {
                //This shifts the item in index number j to the right side if it fulfills the condition
                array[j + 1] = array[j];
                //Then we decrement j (so minus by 1) so that it goes back to the original index as in line 21 we shifted it by 1 (so we added 1)
                //j is now back again to 0 so the index number 0 in the list
                j--;

            }

            //This stores the current number which will be sorted into the list
            array[j + 1] = current;


        }
    }


    public static void timeTestResults(int[] array) {
        int num = 11;
        long totalTime = 0;

        System.out.println("Insertion Sort TEST:");
        for (int i = 1; i < num; i++) {
            long startTime = System.nanoTime();
            insertionSortAscending(array);
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

        int[] numbers = {7, 3, 1, 1, 2};

//
//        boolean ascendingCheck = ascendingOrderChecker(numbers);
//
//        System.out.println(Arrays.toString(numbers));
//
//        System.out.println(ascendingCheck);


//        timeTestResults(numbers);



        System.out.print("List in ascending order: ");
        insertionSortAscending(numbers);
        System.out.print(Arrays.toString(numbers));
        timeTestResults(numbers);

        System.out.println();
        System.out.println();

//        System.out.print("List in descending order: ");
//        insertionSortDescending(numbers);
//        System.out.print(Arrays.toString(numbers));


    }
}
