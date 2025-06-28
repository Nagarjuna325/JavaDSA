package sorting;


// 02/08/2025

import java.util.Arrays;

public class RadixSort {

    int[] arr = new  int[]{29,83,471,36,91,8}; // as it is a instance variable it belongs to class if we need to access it
    // we need an object created for the RadixSort class
    // but if we declare it as a static int arr - we can access it directly in main method.


    // finding maximum count of the digit in the arr
    public static int count(int[] arr){


        int count = 0;

        for(int i = 0; i < arr.length; i++){ // O(logN) -TC
            int countc = 0;
          while( arr[i] != 0){
              arr[i] /= 10;
              countc++;
          }

          if( countc > count){
              count = countc;
          }
        }

        return count;
    }


     // O(1) - TC - IF  there is a log function then it will be.
//    public static int countDigits(int num) {
//        if (num == 0) return 1; // Special case for zero
//        return (int) Math.log10(Math.abs(num)) + 1;
//    }


    // other way using streams

   public static void radixSort(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt();

        // do count sort for every digit place
       for(int exp = 1; max/exp > 0; exp *= 10 ){
           countSort1(arr, exp);
       }
   }


   //
    public static void countSort1(int[] arr, int exp){

        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // size of the count array is 10 because 0 - 9

        Arrays.fill(count, 0);

        for(int i=0; i<n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        System.out.println("\nCount array for " + exp + " : " + Arrays.toString(count));

        for(int i=1; i<10; i++) {
            count[i] = count[i] + count[i-1];
        }

        System.out.println("Updated count array " + Arrays.toString(count));


//        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
//        count[(arr[i] / exp) % 10]--;
//        We are placing elements into the output array based on their digit position (from count array).
//                We are iterating from right to left (i = n - 1 to 0) to maintain stable sorting.

        for(int i=n-1; i>=0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        System.out.println("Output array " + Arrays.toString(output));

        System.arraycopy(output, 0, arr, 0, n);

    }





    public static void main(String[] args) {

//       RadixSort rs = new RadixSort();
//
//       // why we used rs.arr
//       System.out.println(rs.count(rs.arr));


       // Kunal
        int[] arr = {29, 83, 471, 36, 91, 8};

        System.out.println("Origin array: " + Arrays.toString(arr));
        radixSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}


//why it is showing me error when I just write the for loop in the RadixSort class also ddirectly
//        ChatGPT said:
//If you wrote a for loop directly inside the RadixSort class (outside any method), Java would throw a compilation error because Java does not allow executable statements (like loops) directly inside a class body.
//
//Example of Incorrect Code:
//java
//        Copy
//Edit
//package sorting;
//
//public class RadixSort {
//
//    int[] arr = new int[]{29, 83, 471, 36, 91, 8};
//
//    // ❌ ERROR: Loop cannot be directly inside a class body
//    for (int i = 0; i < arr.length; i++) {
//        System.out.println(arr[i]);
//    }
//
//    public static void main(String[] args) {
//    }
//}
//Why is this an Error?
//        In Java, all executable code (like loops, if conditions, and method calls) must be inside a method or a constructor.
//Code that is directly inside the class (but outside methods) is only allowed for:
//Variable declarations.
//Instance initializers (inside {} blocks).
//Static initializers (static {} blocks).
//How to Fix It?
//        ✅ Solution 1: Put the loop inside a method
//java
//        Copy
//Edit
//package sorting;
//
//public class RadixSort {
//
//    int[] arr = new int[]{29, 83, 471, 36, 91, 8};
//
//    public void printArray() {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        RadixSort rs = new RadixSort();
//        rs.printArray(); // Calling the method
//    }
//}
//✅ Solution 2: Use an Instance Initializer Block
//If you want to run the loop immediately when the object is created, you can use an instance initializer block:
//
//java
//        Copy
//Edit
//package sorting;
//
//public class RadixSort {
//
//    int[] arr = new int[]{29, 83, 471, 36, 91, 8};
//
//    // Instance initializer block
//    {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        new RadixSort(); // Object creation will trigger instance initializer
//    }
//}
//Output:
//
//Copy
//        Edit
//29
//        83
//        471
//        36
//        91
//        8
//        ✅ Solution 3: Use a Static Block (for Static Arrays)
//If the array is static, you can use a static initializer block:
//
//java
//        Copy
//Edit
//package sorting;
//
//public class RadixSort {
//
//    static int[] arr = new int[]{29, 83, 471, 36, 91, 8};
//
//    // Static initializer block
//    static {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
//    }
//
//    public static void main(String[] args) {
//        // No need to create an object, static block runs automatically
//    }
//}
//Conclusion
//You cannot write a loop directly inside a class body in Java. Instead, you should:
//
//Place it inside a method (printArray()).
//Use an instance initializer {} (runs when an object is created).
//Use a static initializer static {} (runs once when the class is loaded).
//Would you like further explanation on any of these concepts?



//at last sstep 10* 4 = 40 so reminder is 0
//ChatGPT said:
//You're absolutely right to think about how division and remainders work! Let’s go deeper into why the last step gives 0.
//
//Understanding the Final Step (num /= 10)
//When we divide 4 / 10, we get 0 because Java discards the decimal part in integer division. Let's go step by step.
//
//Step-by-Step Breakdown
//Let's take num = 471 and apply integer division:
//
//Step	num Value	num / 10 (Integer Division)	New num	Explanation
//1	471	471 / 10 = 47.1 → 47	47	Last digit (1) is removed
//2	47	47 / 10 = 4.7 → 4	4	Last digit (7) is removed
//3	4	4 / 10 = 0.4 → 0	0	Last digit (4) is removed
//        Now num = 0, so the loop stops.
//
//What About the Remainder?
//You're thinking about this:
//
//        4 / 10 = 0.4 (In integer division, this becomes 0)
//The remainder (%) is 4 % 10 = 4
//However, in our digit counting method, we don't need to use the remainder (%) because we are only removing digits (not extracting them). We keep dividing by 10 until the number becomes 0.
//
//Why Doesn’t 10 * 4 Matter?
//You mentioned:
//
//        "At last step, 10 * 4 = 40, so remainder is 0."
//
//        But actually, we're not multiplying back. Instead, we are repeatedly dividing without decimals.
//
//If we were keeping track of the remainder:
//
//        471 % 10 = 1 (Last digit)
//        47 % 10 = 7
//        4 % 10 = 4
//But since we are only counting digits, we don’t need %. Instead, we just keep reducing num by dividing it by 10.
//
//Key Takeaways
//✅ Integer division (/) keeps only the whole number, discarding decimals.
//        ✅ We don't need the remainder (%) since we are counting digits, not extracting them.
//        ✅ Loop runs until num == 0, ensuring we count all digits.
//
//Let me know if this clears things up or if you'd like further clarification! 🚀😊




//why we need rs.arr we created and object and calling the method right already
//ChatGPT said:
//Great question! Let's clarify why we need rs.arr when calling the method.
//
//        1. Understanding How Methods Work
//When calling a method in Java, we need to pass actual arguments that match the method parameters.
//
//Your count Method
//        java
//Copy
//        Edit
//public static int count(int[] arr)
//This method expects an array (int[] arr) as input.
//It does not directly use the instance variable arr of the RadixSort class.
//        2. Calling count() in main()
//Incorrect Code:
//java
//        Copy
//Edit
//System.out.println(rs.count(int[] arr)); // ❌ Compilation error
//int[] arr is not valid Java syntax inside method calls.
//You must pass an actual array variable.
//Why rs.arr?
//Since arr is an instance variable in RadixSort, we access it using rs.arr (where rs is the object of the class).
//
//Correct Code:
//java
//        Copy
//Edit
//System.out.println(rs.count(rs.arr)); // ✅ Pass the actual array
//rs.arr refers to the arr defined inside the RadixSort instance.
//This passes the actual array to the method.
//        3. Alternative Approach: Call count() Without Arguments
//If we want count() to automatically use the instance variable, we can change it to not require an argument:
//
//Modified count() (Non-Static & Uses Instance Variable)
//java
//        Copy
//Edit
//public int count() { // Removed int[] arr parameter
//    int count = 0;
//
//    for (int i = 0; i < arr.length; i++) {
//        int num = arr[i];
//        int countc = 0;
//
//        while (num != 0) {
//            num /= 10;
//            countc++;
//        }
//
//        if (countc > count) {
//            count = countc;
//        }
//    }
//
//    return count;
//}
//Now Call It Like This (No Need for rs.arr)
//java
//        Copy
//Edit
//RadixSort rs = new RadixSort();
//System.out.println(rs.count()); // ✅ No need to pass arr
//Now count() directly accesses arr inside the class without requiring a parameter.
//This makes the code cleaner and easier to use.
//        Final Thoughts
//Approach	Pros	Cons
//rs.count(rs.arr)	More flexible (can pass any array)	Requires explicit parameter
//rs.count()	Cleaner syntax, always uses instance arr	Can't analyze other arrays without modifying the class
//        👉 Use rs.count() if you always work with RadixSort's array.
//        👉 Use rs.count(anyArray) if you need flexibility to process different arrays.
//
//Let me know if you have any doubts! 🚀😊
//
//
//
//
//
//
//
//You said:
//ohh so we create the array in main class then it fine right
//        ChatGPT said:
//Yes, exactly! If you create the array inside the main method, then you can directly pass it to the count method without needing rs.arr.
//
//        Example: Creating the Array in main()
//If you define the array inside main, you can pass it directly:
//
//java
//        Copy
//Edit
//public class RadixSort {
//
//    public static int count(int[] arr) {
//        int count = 0;
//
//        for (int i = 0; i < arr.length; i++) {
//            int num = arr[i];
//            int countc = 0;
//
//            while (num != 0) {
//                num /= 10;
//                countc++;
//            }
//
//            if (countc > count) {
//                count = countc;
//            }
//        }
//
//        return count;
//    }
//
//    public static void main(String[] args) {
//        int[] arr = {29, 83, 471, 36, 91, 8}; // ✅ Defined inside main
//        System.out.println("Max digit count: " + count(arr)); // ✅ Pass directly
//    }
//}
//Why This Works?
//The array exists in main(), so we don't need to store it in an instance variable.
//We pass arr directly to count(arr), and it works fine.
//When to Use rs.arr vs. arr in main()?
//Approach	When to Use
//rs.arr (Instance Variable)	When the array belongs to the object and might be used across multiple methods.
//arr inside main()	When the array is only used in main() and passed directly to methods.
//        Final Answer
//✔ Yes, if you create the array inside main, you can just pass it directly without using rs.arr.
//✔ If the array is a property of the class (RadixSort), then use rs.arr.
//
//🚀 Now you fully understand both approaches! Let me know if you need more examples. 😊
//
//
//
//
//
//
//
//You said:
//but why does have not creatd the object here for the RadixSort tio get the method
//ChatGPT said:
//Great observation! The reason we don’t need to create an object to call count(arr) in main() is because count is a static method.
//
//1. Static Methods Can Be Called Without an Object
//In the corrected version of your code, the count method is defined as:
//
//java
//        Copy
//Edit
//public static int count(int[] arr)
//Since it is static, it belongs to the class itself, not to any instance of RadixSort.
//This means we can call it using RadixSort.count(arr) without creating an object.
//How Static Methods Work
//Static methods belong to the class itself and do not require an object.
//Instance methods belong to an object, so you must create an instance to call them.
//        2. Calling Static Method Without an Object
//In main(), we call:
//
//java
//        Copy
//Edit
//System.out.println("Max digit count: " + count(arr));
//Since main is also static, it can directly call other static methods in the same class without needing an object.
//
//Alternatively, we could write:
//
//java
//        Copy
//Edit
//System.out.println("Max digit count: " + RadixSort.count(arr)); // Explicit class reference
//This makes it clearer that count belongs to the RadixSort class.
//
//        3. When Would We Need an Object?
//If count were not static, like this:
//
//java
//        Copy
//Edit
//public int count(int[] arr) {  // ❌ No static keyword
//    Then calling count(arr) inside main() would cause an error.
//    We would have to create an object like this:
//
//    java
//            Copy
//    Edit
//    RadixSort rs = new RadixSort();
//    System.out.println("Max digit count: " + rs.count(arr)); // ✅ Now it works
//    Final Answer
//✔ We don’t need an object (rs) because count is static and belongs to the class.
//✔ If count were not static, we would have to create an instance of RadixSort before calling it.
//
//    Let me know if this makes sense or if you need more clarification! 🚀😊
//
//
//
//
//
//
//
//    You said:
//    then why does we created the object for the before one where the arr is in RadixSort there also class is static only right
//    ChatGPT said:
//    Great question! Let's break it down step by step. 🔍
//
//    1. Difference Between the Two Cases
//    You noticed that in one case, we needed to create an object (rs = new RadixSort();), but in another case, we didn’t. The key difference is where the array (arr) is stored.
//
//    Case	Where is arr Stored?	How We Access It?
//✅ No Object Needed	arr is created inside main() and passed directly.	Call count(arr) because it's static.
//❌ Object Needed	arr is an instance variable of RadixSort (inside the class, not static).	Need rs.arr to access it.
//    2. When arr is in main() (No Object Needed)
//    java
//            Copy
//    Edit
//    public class RadixSort {
//        public static int count(int[] arr) {  // ✅ Static method
//            int count = 0;
//
//            for (int i = 0; i < arr.length; i++) {
//                int num = arr[i];
//                int countc = 0;
//
//                while (num != 0) {
//                    num /= 10;
//                    countc++;
//                }
//
//                if (countc > count) {
//                    count = countc;
//                }
//            }
//            return count;
//        }
//
//        public static void main(String[] args) {
//            int[] arr = {29, 83, 471, 36, 91, 8};  // ✅ Created inside main
//            System.out.println("Max digit count: " + count(arr));  // ✅ No object needed
//        }
//    }
//    Why No Object?
//            The arr is created in main(), so it is already accessible.
//    The count method is static, so we can directly call it inside main().
//    3. When arr is an Instance Variable (Object Needed)
//    java
//            Copy
//    Edit
//    public class RadixSort {
//        int[] arr = {29, 83, 471, 36, 91, 8};  // ❌ Instance variable (NOT static)
//
//        public static int count(int[] arr) {  // ✅ Static method
//            int count = 0;
//
//            for (int i = 0; i < arr.length; i++) {
//                int num = arr[i];
//                int countc = 0;
//
//                while (num != 0) {
//                    num /= 10;
//                    countc++;
//                }
//
//                if (countc > count) {
//                    count = countc;
//                }
//            }
//            return count;
//        }
//
//        public static void main(String[] args) {
//            RadixSort rs = new RadixSort();  // ✅ Object created
//            System.out.println("Max digit count: " + count(rs.arr));  // ✅ Access instance variable using object
//        }
//    }
//    Why Do We Need an Object Here?
//            The array arr belongs to an instance of the class (RadixSort).
//            It is not static, so we cannot access it directly inside main(), which is static.
//    We create an object rs to access rs.arr.
//    4. When Would We Make arr Static?
//    If we define arr as static inside RadixSort, then we don’t need an object:
//
//    java
//            Copy
//    Edit
//    public class RadixSort {
//        static int[] arr = {29, 83, 471, 36, 91, 8};  // ✅ Now static
//
//        public static int count(int[] arr) {
//            int count = 0;
//
//            for (int i = 0; i < arr.length; i++) {
//                int num = arr[i];
//                int countc = 0;
//
//                while (num != 0) {
//                    num /= 10;
//                    countc++;
//                }
//
//                if (countc > count) {
//                    count = countc;
//                }
//            }
//            return count;
//        }
//
//        public static void main(String[] args) {
//            System.out.println("Max digit count: " + count(arr));  // ✅ No object needed
//        }
//    }
//    Why This Works?
//            arr is now static, so it belongs to the class instead of an instance.
//    Since main() and count() are also static, they can directly access arr without creating an object.
//            Summary
//    Where arr is Stored	Needs an Object?	Why?
//            Inside main()	❌ No	It is a local variable in main().
//            Instance Variable (int[] arr = {...} inside RadixSort)	✅ Yes	It is not static, so we need an object (rs.arr).
//            Static Variable (static int[] arr = {...} inside RadixSort)	❌ No	It belongs to the class, so it can be accessed directly.
//    Final Answer
//    If arr is inside main() → ✅ No need for an object.
//    If arr is an instance variable (not static) → ❌ Need an object (rs.arr).
//            If arr is static → ✅ No need for an object.
//🚀 Hope this makes it clear! Let me know if you have any more doubts. 😊
//
//
//
//
//
//
//
//    You said:
//    so if made the arr static I can acces it directly right
//    ChatGPT said:
//    Yes! ✅ If you make arr static, you can access it directly without needing an object.
//
//            Example: Accessing static arr Directly
//    java
//            Copy
//    Edit
//    public class RadixSort {
//        static int[] arr = {29, 83, 471, 36, 91, 8};  // ✅ Now it's static
//
//        public static int count(int[] arr) {
//            int count = 0;
//
//            for (int i = 0; i < arr.length; i++) {
//                int num = arr[i];
//                int countc = 0;
//
//                while (num != 0) {
//                    num /= 10;
//                    countc++;
//                }
//
//                if (countc > count) {
//                    count = countc;
//                }
//            }
//            return count;
//        }
//
//        public static void main(String[] args) {
//            System.out.println("Max digit count: " + count(arr));  // ✅ No object needed
//        }
//    }
//    Why This Works?
//            Since arr is static, it belongs to the class instead of an instance.
//    Both main() and count() are also static, so they can directly access arr without needing an object.
//    What If arr Is Not Static?
//    If arr is not static, like this:
//
//    java
//            Copy
//    Edit
//    int[] arr = {29, 83, 471, 36, 91, 8};  // ❌ Not static
//    Then calling count(arr) inside main() will cause an error. You would need to create an object first:
//
//    java
//            Copy
//    Edit
//    RadixSort rs = new RadixSort();
//    System.out.println("Max digit count: " + count(rs.arr));  // ✅ Need rs.arr
//    Conclusion
//✔ Making arr static means you can access it directly without creating an object.
//✔ If arr is not static, you must create an object to access it.
//
//🚀 Now you fully understand static vs. instance variables! Let me know if you have any more doubts. 😊
//









