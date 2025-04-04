package binarysearch;

public class SmallestLetter {


    public static void main(String[] args) {

        char[] arr = {'c','f', 'j'};
        char target = 'c';

        char ans = nextGreatestLetter(arr, target);

        System.out.println(ans);
    }

    public static char nextGreatestLetter(char[] letters, char target) {

        int end = letters.length;

        int start = 0;

        while ( start < end){

            int mid = start + (end - start)/2;

            if( target < letters[mid]){
                //end = mid - 1;  // error 2 consider mid - 1 which is wrong
                // why we used end = mid instead of mid -1 why?
                end = mid;
            }
            else{
                start = mid + 1;
            }
            //  else{ // why we changed this case? because if we carefully read the questions it does not want to return if we found
            // target it wants to return nearst greater than target only.
            //     return letters[mid];
            //  }


        }

        // return letters[start]; // error 1

        // understand the code the if nothing is found it asked us to return the start value in the code I didnt read it properly.

        return letters[start%letters.length];

        // or

        // if (start > end)  // if start == length;
        // return 0;
        //    return letters[0];

        //The modulo operation (% letters.length) ensures that if start exceeds the array bounds, it wraps around to the beginning of the array.

    }
}
