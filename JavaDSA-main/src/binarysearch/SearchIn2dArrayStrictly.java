package binarysearch;

public class SearchIn2dArrayStrictly {

    public static void main(String[] args) {

    }

    public static int[] binarySearch(int[][]  matrix, int row, int cStart, int cEnd, int target){

        while( cStart <= cEnd){

            int mid = cStart + (cEnd - cStart)/2;

            if( matrix[row][mid] == target){
                return new int[]{row, mid};
            }
            if( matrix[row][mid] < target){
                cStart = mid + 1;
            } else{
                cEnd = mid - 1;
            }
        }

        return new int[]{-1,1};

    }


    // the main search algorithm the steps we need to know how to implement the logic
    public static int[] search(int[][] matrix , int target){

        int r = matrix.length;
        int c = matrix[0].length; // matrix may be empty

        if( r == 1){ // if we have only one row available.
            return binarySearch(matrix, 0, 0, c-1, target);
        }

        // run the loop till 2rows are remaining because if we have 1row anyway the above if condition it will execute the
        // search

        int rStart = 0;
        int rEnd = r -1;
        int cMid = c/2;

        while( rStart < (rEnd - 1)){ // while this is true I will have more than 2 rows

            int mid = rStart + (rEnd - rStart)/2;

            if( matrix[mid][cMid] == target){

                return new int[]{mid, cMid};
            }if( matrix[mid][cMid] < target){
                rStart = mid;
            } else{
                rEnd = mid;
            }
        }

        // now we will have 2 rows
        // now checking in the 2 rows whether the target is in 2 rows or not

        if( matrix[rStart][cMid]== target){
            return new int[]{rStart, cMid};
        }
        //if()

        return new int[]{rStart, cMid};
//       return [-1,-1];
    }
}
