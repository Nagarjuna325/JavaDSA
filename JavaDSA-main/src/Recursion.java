public class Recursion {

    public static void main(String[] args) {
//
//       int ans = fac(5);
//        System.out.println( ans);

        nev(5);
    }

    static void fun(int n){

        if( n==0){
            return ;
        }
        System.out.println(n);
        fun(n-1);
    }

    static void funrev(int n){

        if( n==0){
            return ;
        }

        funrev(n-1);
        System.out.println(n);
    }


    // factorial

    static int fac( int n){

        if ( n <= 1) {
            return 1;
        }

        return n* fac(n-1);

    }

    static void nev(int n){
        if( n == 0){
            return;
        }

        System.out.println(n);
        nev(--n);  // nev(n--);  pass first and substract later , --n subtract first and pass it, so for n-- we are always passing 5 value only. 
    }
}

// time complexity is 0(n)

// Space complexity is also O(n) as it is storing those many function calls in the stack.
