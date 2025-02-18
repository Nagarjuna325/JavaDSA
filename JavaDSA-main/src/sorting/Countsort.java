package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Countsort {

// error forget the array declaration also in java
//    int[] arr = new int[]{1,3,3,4};
//    int max = 0;
//
//    for( int i = 0; i < arr.length; i++){
//        if( arr[i] > max){
//            max = arr[i];
//        }
//    }
//
//
//    int[] countarr = new int[max+1];

   public static void countSort(int[] array){

       if( array == null || array.length <= 1){
           return;
       }

       int max = array[0];

       for( int i =0; i < array.length; i++ ){
           if( array[i] > max){
                max = array[i];
           }
       }


       int[] countArray = new int[max + 1];

       for( int num : array){  // observe here carefully the index array value if it is 3 then it will increase the value of that index
           // in the countArray itself countArray[3] means index ++ it is increased.
           countArray[num]++;
       }

      int index = 0;

       for(int i=0; i <= max; i++){
           while(countArray[i]>0){
               array[index] = i;
               index++;
               countArray[i]--;
           }
       }
   }

   // second way using HashMaps

    public static void countSortHash(int[] array){

        if( array == null || array.length <= 1){
            return;
        }

        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();

        Map<Integer, Integer> countMap = new HashMap<>();

        for(int num: array){
            countMap.put(num, countMap.getOrDefault(num, 0) +1);
        }

        int index = 0;

        for( int i = min; i <= max; i++){
            int count = countMap.getOrDefault(i, 0);
            for(int j =0; j < count; j++){
                array[index] = i;
                index++;
            }
        }

    }

    public static void main(String[] args) {


        int[] arr = new  int[]{1,3,3,2,4,5,4};
        // error 2
         countSort(arr);

          //error3
        //System.out.println(Arrays.toString(countSort(arr))); // ❌ Error: countSort() is void

        System.out.println(Arrays.toString(arr));
    }
}


//So is Map an interface or a class and also HashMap  int max = Arrays.stream(array).max().getAsInt();
//int min = Arrays.stream(array).min().getAsInt();
//
//Map<Integer, Integer> countMap = new HashMap<>();and how does this lines of code work
//ChatGPT said:
//        1. Is Map an Interface or a Class?
//Map<K, V> is an interface in Java (java.util.Map).
//It provides a collection of key-value pairs where keys are unique.
//It has multiple implementations like:
//HashMap
//        TreeMap
//LinkedHashMap
//        ConcurrentHashMap
//2. Is HashMap an Interface or a Class?
//HashMap<K, V> is a concrete class that implements the Map<K, V> interface.
//It is based on a hashing mechanism, providing fast O(1) average time complexity for get(), put(), and remove() operations.
//        3. Understanding the Code
//        java
//Copy
//        Edit
//int max = Arrays.stream(array).max().getAsInt();
//int min = Arrays.stream(array).min().getAsInt();
//
//Map<Integer, Integer> countMap = new HashMap<>();
//(a) Finding the Maximum and Minimum Value in an Array
//        java
//Copy
//        Edit
//int max = Arrays.stream(array).max().getAsInt();
//int min = Arrays.stream(array).min().getAsInt();
//Arrays.stream(array) → Converts the array into a stream.
//        .max() → Finds the maximum value in the stream (returns OptionalInt).
//        .getAsInt() → Extracts the value from OptionalInt.
//        Similarly, .min().getAsInt() finds the minimum value.
//        (b) Creating a HashMap
//        java
//Copy
//        Edit
//Map<Integer, Integer> countMap = new HashMap<>();
//Creates a HashMap<Integer, Integer>, where:
//Keys (Integer) → Represents numbers from the array.
//Values (Integer) → Represents the count (frequency) of each number.
//        🔹 Example Usage:
//
//java
//        Copy
//Edit
//int[] array = {1, 2, 3, 3, 4, 4, 5};
//
//Map<Integer, Integer> countMap = new HashMap<>();
//
//for (int num : array) {
//        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//
//        System.out.println(countMap);
//🔹 Output:
//
//java
//        Copy
//Edit
//{1=1, 2=1, 3=2, 4=2, 5=1}
//countMap.getOrDefault(num, 0) + 1 → Gets the current count or 0 if not found, then increments.
//Would you like a breakdown of how HashMap works internally? 🚀
//
//
//
//
//
//
//You said:
//Map<Integer, Integer> countMap = new HashMap<>(); expecially this line I am asking
//ChatGPT said:
//Understanding This Line:
//java
//        Copy
//Edit
//Map<Integer, Integer> countMap = new HashMap<>();
//This line declares and initializes a HashMap in Java. Let’s break it down:
//
//        1. Map<Integer, Integer> (Interface Type)
//Map<K, V> is an interface where:
//K (Key) → First Integer represents keys (e.g., numbers in an array).
//V (Value) → Second Integer represents values (e.g., count of occurrences).
//Declaring countMap as a Map (interface) allows flexibility (you can later change HashMap to TreeMap, LinkedHashMap, etc.).
//        2. new HashMap<>() (Concrete Class)
//HashMap<> is an implementation of Map using hashing for fast lookup.
//The <Integer, Integer> inside HashMap<> is inferred from the declaration.
//        3. Why Use Map<Integer, Integer>?
//This is typically used for counting occurrences of numbers in an array.
//
//Example Usage:
//java
//        Copy
//Edit
//int[] array = {1, 2, 3, 3, 4, 4, 5};
//
//Map<Integer, Integer> countMap = new HashMap<>();
//
//for (int num : array) {
//        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//
//        System.out.println(countMap);
//Output:
//java
//        Copy
//Edit
//{1=1, 2=1, 3=2, 4=2, 5=1}
//put(num, countMap.getOrDefault(num, 0) + 1):
//getOrDefault(num, 0) → Gets current count, or 0 if key doesn’t exist.
//        +1 → Increments count.
//put(num, newCount) → Updates the map.
//Would you like an internal working of HashMap? 🚀
//
//
//
//
//
//
//You said:
//why we cannott use HashMap<Integer, Integer> countMap = new HashMap<>();
//ChatGPT said:
//You can use:
//
//java
//        Copy
//Edit
//HashMap<Integer, Integer> countMap = new HashMap<>();
//But using:
//
//java
//        Copy
//Edit
//Map<Integer, Integer> countMap = new HashMap<>();
//is generally preferred.
//
//Key Differences:
//        ✅ 1. Using Map<Integer, Integer> countMap = new HashMap<>(); (Recommended)
//Map is an interface, and HashMap is a concrete class.
//Declaring it as Map allows flexibility to switch to other Map implementations like:
//TreeMap<Integer, Integer>
//LinkedHashMap<Integer, Integer>
//Code becomes more maintainable and follows the "program to an interface" principle.
//❌ 2. Using HashMap<Integer, Integer> countMap = new HashMap<>();
//Directly tying your variable to HashMap makes it less flexible.
//If later you want to change it to TreeMap or LinkedHashMap, you must modify all occurrences of HashMap in the code.
//Example - Why Map is Better?
//If you declare:
//
//java
//        Copy
//Edit
//Map<Integer, Integer> countMap = new HashMap<>();
//Later, if you decide that you need a sorted map, you can change only the initialization:
//
//java
//        Copy
//Edit
//Map<Integer, Integer> countMap = new TreeMap<>();
//No other part of the code needs to change.
//
//Final Answer:
//        ✅ You can use HashMap<Integer, Integer> countMap = new HashMap<>();, but it's recommended to use Map<Integer, Integer> countMap = new HashMap<>(); for flexibility and maintainability.
//
//Would you like a practical example where switching between HashMap and TreeMap makes a difference? 🚀



//Yes in real world
//ChatGPT said:
//Real-World Example: Counting Word Frequency in a Document
//Let’s say we have a document and we need to count how many times each word appears. Depending on how we want to store and access the data, we can choose between HashMap and TreeMap.
//
//        Scenario 1: Using HashMap (Unordered, Fast)
//✅ Best for performance (O(1) average time complexity) when order doesn’t matter.
//
//java
//        Copy
//Edit
//import java.util.*;
//
//public class WordCountExample {
//    public static void main(String[] args) {
//        String text = "apple banana apple orange banana apple grape";
//        String[] words = text.split(" ");
//
//        Map<String, Integer> wordCount = new HashMap<>();
//
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//
//        System.out.println(wordCount);  // Output may be unordered
//    }
//}
//Output (Unordered)
//Copy
//        Edit
//{orange=1, banana=2, grape=1, apple=3}
//        📌 Pros:
//        ✔️ Fastest retrieval (O(1))
//        📌 Cons:
//        ❌ Unordered output
//
//Scenario 2: Using TreeMap (Sorted, Ordered Output)
//✅ Best when we need the words sorted alphabetically (O(log n) complexity).
//
//java
//        Copy
//Edit
//import java.util.*;
//
//public class WordCountExample {
//    public static void main(String[] args) {
//        String text = "apple banana apple orange banana apple grape";
//        String[] words = text.split(" ");
//
//        Map<String, Integer> wordCount = new TreeMap<>();
//
//        for (String word : words) {
//            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
//        }
//
//        System.out.println(wordCount);  // Output is sorted
//    }
//}
//Output (Sorted)
//Copy
//        Edit
//{apple=3, banana=2, grape=1, orange=1}
//        📌 Pros:
//        ✔️ Keys are sorted alphabetically (apple → banana → grape → orange)
//📌 Cons:
//        ❌ Slower than HashMap (O(log n) instead of O(1))
//
//When to Use HashMap vs. TreeMap
//Scenario	Use HashMap 🚀	Use TreeMap 📌
//Fast lookup & insert (O(1))	✅ Yes	❌ No (O(log n))
//Maintain sorted order	❌ No	✅ Yes
//Need predictable iteration order	❌ No	✅ Yes
//Handling large data sets efficiently	✅ Yes	❌ No (slower for big data)
//Final Conclusion
//Use HashMap when speed is most important (e.g., fast lookups, caching).
//Use TreeMap when you need a sorted structure (e.g., storing contacts alphabetically, leaderboard rankings).
//Would you like more real-world examples? 🚀




//for(int num: array){
//        countMap.put(num, countMap.getOrDefault(num, 0) +1);
//        } why we need  +1 because hby using inside countMap.getOrDefault we are already comparing the values and putting the default is 0 if it is not there right
//ChatGPT said:
//Great question! Let's break it down step by step.
//
//Understanding the Code
//        java
//Copy
//        Edit
//for (int num : array) {
//        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//This loop counts occurrences of each number in the array using a HashMap.
//
//        Step-by-Step Execution
//Let's Assume the Input Array:
//java
//        Copy
//Edit
//int[] array = {1, 2, 1, 3, 2, 1};
//        And initially, the countMap is empty.
//
//Iteration Breakdown:
//num	countMap.getOrDefault(num, 0)	countMap.put(num, value + 1)	Updated countMap
//1	0 (not in map)	1 (0 + 1)	{1=1}
//        2	0 (not in map)	1 (0 + 1)	{1=1, 2=1}
//        1	1 (already in map)	2 (1 + 1)	{1=2, 2=1}
//        3	0 (not in map)	1 (0 + 1)	{1=2, 2=1, 3=1}
//        2	1 (already in map)	2 (1 + 1)	{1=2, 2=2, 3=1}
//        1	2 (already in map)	3 (2 + 1)	{1=3, 2=2, 3=1}
//Why Do We Need +1?
//        countMap.getOrDefault(num, 0) only gets the current count, but we need to increase it by 1.
//If we just did:
//java
//        Copy
//Edit
//countMap.put(num, countMap.getOrDefault(num, 0));
//It would not update the count, just reinsert the same value.
//Without +1, the Map Would Always Store 0
//For example:
//
//java
//        Copy
//Edit
//countMap.put(num, countMap.getOrDefault(num, 0)); // Wrong
//This means 1 would always be stored as 0, because it's never increased.
//Final Summary
//✔ countMap.getOrDefault(num, 0) → Fetches the current count (or 0 if not found).
//        ✔ +1 → Increments the count so we properly track occurrences.
//        ✔ countMap.put(num, newValue) → Updates the Map with the new count.
//
//Would you like me to modify this logic to use .compute() instead (a more modern alternative)? 🚀




//what is this .getOrDefault(num, 0) means we knwo we will get Method checks where the key is present in the countMap or not if not it will increase the value if not present it will assign a new count value as 1 to that key right
//ChatGPT said:
//Yes! You almost got it right! Let's go step by step. 🚀
//
//        Understanding .getOrDefault(num, 0)
//This method is used to retrieve a value from a Map.
//
//        java
//        Copy
//Edit
//countMap.getOrDefault(num, 0)
//If num is present in countMap, it returns its current count.
//If num is NOT present, it returns 0 (default value).
//What Happens in Code?
//java
//        Copy
//Edit
//for (int num : array) {
//        countMap.put(num, countMap.getOrDefault(num, 0) + 1);
//        }
//Step-by-Step Execution
//Let's assume our array is:
//
//java
//        Copy
//Edit
//int[] array = {2, 3, 2, 4, 3, 2};
//👉 countMap starts empty ({ }).
//
//Iteration Breakdown:
//num	countMap.getOrDefault(num, 0) (Current Count)	+1 (Increase Count)	countMap.put(num, newCount) (Updated Map)
//        2	0 (not in map)	1	{2=1}
//        3	0 (not in map)	1	{2=1, 3=1}
//        2	1 (already in map)	2	{2=2, 3=1}
//        4	0 (not in map)	1	{2=2, 3=1, 4=1}
//        3	1 (already in map)	2	{2=2, 3=2, 4=1}
//        2	2 (already in map)	3	{2=3, 3=2, 4=1}
//Final countMap Output
//        Copy
//Edit
//{2=3, 3=2, 4=1}
//Breaking Down the Logic
//java
//        Copy
//Edit
//countMap.getOrDefault(num, 0) + 1
//First time we see a number (num)
//
//It’s not in countMap, so getOrDefault(num, 0) returns 0.
//We add 1, so count becomes 1.
//We store it in countMap.
//Next time we see the same number (num)
//
//getOrDefault(num, 0) returns current count.
//We add 1 to the existing count.
//We update the map with the new count.
//What If We Didn’t Use getOrDefault(num, 0)?
//If we wrote:
//
//java
//        Copy
//Edit
//countMap.put(num, countMap.get(num) + 1);
//        🚨 Problem: If num is not in the map yet, countMap.get(num) will return null, causing a NullPointerException.
//
//        That’s why we must use .getOrDefault(num, 0), to handle the case where the key isn’t present yet.
//
//        Final Answer
//✔ Yes, you are correct!
//        ✔ .getOrDefault(num, 0) checks if num exists in countMap.
//        ✔ If num exists, it gets its current count and increases it.
//        ✔ If num does NOT exist, it starts at 0 and increases to 1.
//
//Would you like a real-world example of when this is useful? 🚀
//













