package stacksproblem;

import java.util.Arrays;
import java.util.Scanner;

public class TwoStacks {

    static int twoStacks(int x, int[] a , int[] b) {   // why we took only 3 arguments in the function why we are not taking the sum we get and also the count value as 0 intiliz int
        // in the function call because we need to take only those we need to pass in the every fun call and we need to get the sum value

        return twoStacks(x, a, b, 0, 0) - 1; // helper function
    }
        private static int twoStacks(int x, int[] a, int[] b, int sum, int count){

            if(sum >x){
                return count;
            }

            if( a.length == 0 || b.length == 0){
                return count;
            }

            int ans1 = twoStacks( x, Arrays.copyOfRange(a,1,a.length), b, sum + a[0], count+1);
            int ans2 = twoStacks( x, a, Arrays.copyOfRange(b,1,b.length), sum + b[0], count+1);

            return Math.max(ans1, ans2);

        }



    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // no of test cases

        for( int i=0; i < t; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int x = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int j=0; j < n; j++){
                a[j] = sc.nextInt();
            }
            for(int k=0; k < n; k++){
                b[k] = sc.nextInt();
            }

            System.out.println(TwoStacks.twoStacks(x, a, b));

        }
    }
}