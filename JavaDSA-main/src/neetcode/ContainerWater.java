package neetcode;


// 02/12/2025
public class ContainerWater {

    // Container with most water - Concept from Techdose


    // Brute Force approach - TC - O(N^2) SC - O(1)
    public static int maxB(int[] arr){

        int maxArea = 0;

        for(int i = 0; i < arr.length - 1; i++ ){
            for( int j = i+1; j < arr.length; j++){

                int width = j - i;
                int minHeight = Math.min(arr[i], arr[j]);
                int area = minHeight * width;

                maxArea = Math.max(area, maxArea);
            }
        }

        return maxArea;
    }


    public static void main(String args[]){


        // struggled in array declarations also forgot {} [1,3,4] written like this directly
        int[] arr = new int[]{1, 4, 6, 7, 3, 4, 8, 6};

        int h = ContainerWater.maxO(arr);

        System.out.println(h);
    }



    // Optimized one two pointer approach means greedy one


    // doubts I got struggled to figure out where to keep the if conditions it inside or outside the while loop
    public static int maxO(int[] arr){

        int maxArea = 0;

        int left = 0;
        int right = arr.length - 1;

        while( left < right){

            int width = right - left;

            int minHeight = Math.min(arr[left], arr[right]);

            int area = minHeight * width;
             maxArea = Math.max(area, maxArea);

            if( arr[left] < arr[right]){
                left++;
            }
            else right--;

        }

        return maxArea;
    }
}
