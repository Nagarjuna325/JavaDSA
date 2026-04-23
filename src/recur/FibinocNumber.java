package recur;

public class FibinocNumber {

    public static void main(String[] args) {

        int a = 6;
        System.out.println(fib(a));
    }


    static int fib(int n){

        if( n <= 0){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    // The same question we can solve using the dynamic programming using memoization
    // because we draw the recursive tree and see the flow there we will be doing a lot of calculations repeatedly because we know that
    // lot extra calculation we are doing means repeating the code ourselves so many times.

}
