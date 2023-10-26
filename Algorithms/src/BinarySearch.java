public class BinarySearch {


    public static int binarySearch(int[] arr, int target) {
        //The two pointers
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            //find the middle element
            //to avoid exceeding the int range if the array is very large we just do end - start
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                //If the target is less than mid it checks the left side of the array
                end = mid - 1;
            } else if (target > arr[mid]) {
                //If the target is greater than mid it checks the right side of the array
                start = mid + 1;

            } else {
                return mid;
            }
        }
        //If nothing is executed in while loop (target does not exist in the array) then it just returns -1
        return -1;
    }

    //This is a better version of binarySearch method as it checks whether the array is in ascending or descending order
    public static int orderAgnosticBinarySearch(int[] arr, int target) {
        //The two pointers
        int start = 0;
        int end = arr.length - 1;

        //check if its ascending or descending
        //Simplified version
        boolean isAsc = arr[start] < arr[end];
//        if (arr[start] < arr[end]){
//            isAsc = true;
//        }else{
//            isAsc = false;
//        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else if (target > arr[mid]) {
                    start = mid + 1;

                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else if (target < arr[mid]) {
                    start = mid + 1;

                }
            }
        }
        return -1;
    }

    public static void printSearchResponse(int arr[], int target) {
        int result = orderAgnosticBinarySearch(arr, target);
        if (result != -1) {
            System.out.println("The target number: " + target + " is in the " + result + " index in the array");
        } else {
            System.out.println("The number does not exist in the array");
        }
    }


    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 9, 11, 12, 14, 20, 36, 45};
        int[] array = {75,60,50,11,5,4};

        int target = 50;
//        int ans = binarySearch(arr,target);
//        System.out.println(ans);

        printSearchResponse(array, target);
    }
}
