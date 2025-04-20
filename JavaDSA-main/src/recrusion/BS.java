package recrusion;

public class BS {

    public static void main(String[] args) {

//        int[] arr = {2, 4, 5, 8, 10 , 15, 25, 30};
//
//        int target = 5;

        int[] arr = {-12, 21, 45, 56 , 65, 75, 89, 90};
        int target = 56;

        System.out.println(search(arr, target, 0 , arr.length -1));

    }


    static int search(int[] arr, int target, int s, int e){

        if( s > e){
            return -1;
        }

        int m = s + ( e - s) / 2;

        if( arr[m] == target){

            return m;
        }

        if( target < arr[m]){

           return search(arr, target, s, m - 1);  // make sure to return the result of the function call // what will happen if dont keep
            // the return it will just in the stack and the main function will not complete its execution of the code.
        }

        else{
            return search(arr, target, m+1, e);
        }
    }
}

// also understand what is overhead means in the usage.

//So what this OVERHEAD IN intellih Idea which we see using the debug pointer which it is telling no of hits
//
//
//ChatGPT said:
//Great question! When you're debugging in IntelliJ IDEA and it shows "overhead" or "number of hits", especially when stepping through code or hovering over loops or method calls, here's what it actually means:
//
//        🧠 What is Overhead in Debug Mode?
//In this context, overhead refers to the extra cost (time or resource usage) due to:
//
//Recursive function calls
//
//Loop iterations
//
//Repeated method invocations
//
//Or even IDE operations during debugging (like stepping into every call)
//
//So, if you're stepping through recursive code (like your original Fibonacci), you'll see the overhead skyrocket because it's calling the same function many times with the same input.
//
//        🔢 What is the "Number of Hits"?
//When you use breakpoints in IntelliJ, and run in debug mode, you might see:
//
//Hit count: 1
//
//Hit count: 12
//
//etc.
//
//This just means:
//
//        "How many times has the debugger reached this line?"
//
//In loops or recursive functions, this shows how many times that line has been executed. Useful for tracking performance and understanding recursion depth or loop iterations.
//
//🛠 Example with Recursive Fibonacci:
//Your original code:
//
//java
//        Copy
//Edit
//static int fib(int n){
//    if( n <= 0){
//        return 1;
//    }
//
//    return fib(n-1) + fib(n-2);
//}
//If you set a breakpoint inside this method and run fib(5):
//
//The debugger will hit this line many times because fib(3), fib(2) are repeated multiple times.
//
//So the "overhead" is high — you’re doing redundant calculations.
//
//        ✅ In DP version (memoization or tabulation):
//The number of hits will be fewer.
//
//Each Fibonacci number is calculated only once.
//
//        So, the overhead is low — it's much more efficient.
//
//        🔍 Summary:
//
//Term	Meaning
//Overhead	Extra time/computation due to repeated/redundant calls
//Number of Hits	How many times the debugger reached this line
//High overhead	Often means performance is poor (like in recursion)
//Low overhead	Code is optimized (like in DP version)
//Let me know if you'd like me to show a visual diagram of how the recursive calls work vs how DP does it in a single pass!
