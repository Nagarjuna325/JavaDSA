package recur;

public class Maze {

    public static void main(String[] args) {
//      int c = count( 3 , 3);
//      System.out.println(c);

        paths("", 3 , 3);
    }


    static int count( int r , int c){ // calculating the no of paths thats it

        if( r == 1 || c == 1){
            return 1;
        }

        int left = count( r-1, c);
        int right = count( r, c-1);

        return left + right;
    }

    static void paths( String p, int r , int c){

        if( r == 1 && c == 1){ // because here we are finding all the paths so we need to reach till the end (1,1)
            System.out.println(p);
            return;
        }

        if( r > 1){
            paths( p + 'D' , r -1, c);
        }

        if( c > 1){
            paths( p + 'R' , r , c - 1);
        }


    }
}




//    so what if i remove system.out.println inside the path recrusion and can we use system.out.println inside the main
//        ChatGPT said:
//        ChatGPT
//        If you remove the System.out.println(p) inside the paths() method and try to use System.out.println(paths()); inside the main method, it won't work as expected unless you modify the paths() method to return something that can be printed.
//
//        Currently, the paths() method is void, meaning it does not return any value. If you remove the System.out.println(p) from within the paths() method without modifying the method to return something, nothing will be printed because the method doesn't generate output for System.out.println() to display.
//
//        To Achieve What You Want:
//        You need to modify the paths() method to return the paths, and then print them in the main method. Here's how you can modify your code to return a list of paths and print it from the main method:
//
//        Updated Code to Return and Print Paths in main:
//        java
//        Copy code
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class Maze {
//
//    public static void main(String[] args) {
//        List<String> result = paths("", 3 , 3);  // Call the modified paths method
//        System.out.println(result);  // Print the result (list of paths)
//    }
//
//    // Method that returns a list of paths
//    static List<String> paths(String p, int r, int c) {
//        List<String> pathList = new ArrayList<>();  // To store all paths // new is used to create a object in the memory
//
//        if (r == 1 && c == 1) {  // Base condition
//            pathList.add(p);  // Add the completed path to the list
//            return pathList;
//        }
//
//        // If moving down is possible
//        if (r > 1) {
//            pathList.addAll(paths(p + 'D', r - 1, c));  // Add 'D' for down
//        }
//
//        // If moving right is possible
//        if (c > 1) {
//            pathList.addAll(paths(p + 'R', r, c - 1));  // Add 'R' for right
//        }
//
//        return pathList;  // Return the list of all paths
//    }
//}
//    How This Works:
//        Modified paths() Method: Instead of printing the paths inside the method, the paths() method now builds a list of all paths and returns it to the caller (main() method).
//        Return Statement: The paths() method uses recursion to add all possible paths to the list, and once it's done, it returns the list.
//        Main Method: In the main() method, you call paths() and store the result in a List<String>. Then, you print this list using System.out.println(result);.
//        Output:
//        The output would look something like this (depending on the size of the maze):
//
//        csharp
//        Copy code
//        [DDRR, DRDR, DRRD, RDDR, RDRD, RRDD]
//        This prints all possible paths from the top-left corner (3, 3) to the bottom-right corner (1, 1), where 'D' represents a move down and 'R' represents a move right.
//
//        To Summarize:
//        If you remove System.out.println(p) from inside paths() and don't modify the method, nothing will be printed.
//        If you want to print the result from the main() method, you need to change the paths() method to return a value (like a list of paths), and then print that value in main().
//
