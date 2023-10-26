public class Recursion {

    public static int Factorial(int n){
        if (n == 1){
            return n;
        }
        else{
            int factorial = n * Factorial(n-1);
            return factorial;
        }
    }

    public static int iterativeFactorial(int n){
        int num = 1;

        if(n > 1) {
            for (int i = 1; i <= n; i++) {
                num = num * i;
            }
        }
        return num;
    }


    public static void main(String[] args){

        System.out.println(iterativeFactorial(4));

    }
}
