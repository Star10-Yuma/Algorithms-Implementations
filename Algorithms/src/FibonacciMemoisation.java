public class FibonacciMemoisation {



        public static int fibonacci(int n, int[] memo) {
            if (n <= 1) {
                return n;
            } else if (memo[n] != 0) {
                return memo[n];
            } else {
                int result = fibonacci(n-1, memo) + fibonacci(n-2, memo);
                memo[n] = result;
                return result;
            }
        }

        public static void main(String[] args) {
            int n = 10;
            int[] memo = new int[n+1];
            System.out.println(fibonacci(n, memo));
            System.out.println(fibonacci(n, memo));
            System.out.println(fibonacci(n, memo));
            System.out.println(fibonacci(n, memo));
            System.out.println(fibonacci(n, memo));

        }


}
