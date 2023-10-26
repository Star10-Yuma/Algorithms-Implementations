public class MaxValue {


    public static int arrayMax(int[] array){
        //Sets the max as the first integer in the array
        int max = array[0];

        //The for loop goes through the whole array
        //int i does not need to be set to 0 as max is already set at array[0]
        for(int i = 1; i < array.length; i++){
            //The if condition checks each time during the for loop when integer i is put in the array index and checks if it is greater than the current max that is set
            //If it is greater the max variable is changed to that number which is in the array
            if (array[i] > max){
                max = array[i];

                //**Doing i++ is wrong as then it skips the array index numbers that are not multiples of 2 e.g it will skip array[3] which is 8 in numArray below
//                i++;

                //I did this to check how i works and until which number it stops to in the array length
//                System.out.println(i);
            }
            System.out.println("The elements in the array it is looping due to i++:");
            System.out.println(i);

        }
        System.out.println();

        System.out.println("The maximum value in this array is: ");
        //After the for loop is done this returns the max integer
        return max;
    }


    public static void forLoopTest(int[] array){

        //This proves that depending on where integer i is set to either 0 or 1 it will output different values of the array
        for(int i = 0; i < array.length; i++){
            System.out.println(array[i]);
            //The i++ basically adds 1 making i = 0 to 1 then when it loops it increments by one making i = 2 and skipping 1

            //****This is also showed that if integer i in the for loop condition is set to an even number it will loop only through the next even numbers
            //But if integer i is set to an odd number like 1 then it will loop througn the odd numbers meaning the array indexing will be odd positions e.g array[1], array[3], array[5]
           //**This only happens if you do i++** Otherwise the for loop would work normally and print out each element
            i++;
        }
    }


    public static void main(String[] args){
        int[] numArray = {1,2,8,4,5,6};

       int maxNum = arrayMax(numArray);

       System.out.println(maxNum);
//
//        forLoopTest(numArray);

    }
}
