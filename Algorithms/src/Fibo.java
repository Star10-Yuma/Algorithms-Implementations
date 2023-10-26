public class Fibo {


    public static int fibo(int n){

        if(n ==2){
            System.out.println("Reached stopping condition n = 2");
            return 1;
        }

        if(n==1){
            System.out.println("Reached stopping condition n = 1");
            return 0;
        }
            return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args){

        System.out.println(fibo(8));
    }
}
