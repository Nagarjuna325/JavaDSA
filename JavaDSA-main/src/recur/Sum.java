package recur;

public class Sum {
    public static void main(String[] args) {
//        int ans = sum(5);
//        System.out.println(ans);

        int n = 5;
        int sum = 0;
        for(int i =0; i<=5; i++){
            sum = sum + n;
            n = n -1;

        }

        System.out.println(sum);
    }

//    static int sum(int n) {
//        if (n <= 1) { //base condition
//            return 1;
//        }
//
//       //System.out.println("name");
//
//        return n + sum(n-1);
//
//        //System.out.println("name");
//    }

//   int sum = 0;
//    for(int i =0; i<n; i++){
//
//       sum = sum + n;
//           n = n -1;
//
//   }
}
