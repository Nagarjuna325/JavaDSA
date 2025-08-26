package revision.recrusion;

public class recursion {

    // factorial of a number
    public static void main(String[] args) {

        int n = 5;
        int m = 1232;
        System.out.println(fac(n));
        System.out.println(sum(n));
        System.out.println(digit(m));
        //System.out.println(reverse(m));



    }

    //factorial of a number

    public static int fac(int n){

        if( n <= 1){
            return 1;
        }

        return n*fac(n-1);
    }

    // Sum of n numbers using the recursion

    public static int sum(int n){
        if( n == 1){
            return 1;
        }

        return n+sum(n-1);
    }

    // Sum of digits we need to find using the recrusion

    public static int digit(int n){

        if( n == 0){
            return 0;
        }
        return (n % 10) + digit(n/10);

    }

    // important concept

    public static void fun(int n){

        if( n == 0){
            return;
        }

        System.out.println(n);

        fun(n--);
    }

    // reverse a number using the recursion

    static int sum = 0;
    public static void reverse(int n){

        if( n == 0){
            return ;
        }
        int rem = n % 10;
        sum = sum * 10 + rem;
        reverse( n /10);
    }

    public static int reverse2(int n){

        // Sometimes you might need some additional variables in the arguments
        // in that case make another function

        int digits = (int)(Math.log10(n)) + 1;
        return helper(n , digits);

    }

    public static int helper(int n, int digits){

        if( n % 10 == n){
            return n;
        }

        int rem = n % 10;
        return rem *(int)(Math.pow(10, digits - 1)) + helper( n/10, digits);
    }
}
