package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {10, 3, 6, 2, 1, 7 };

        System.out.println(Arrays.toString(bubble(arr)));

    }

    static int[] bubble(int[] arr ){

        int n = arr.length;



        // when revising thought this is also a 2 pointer approach  - 05/15/2025
        // no it is not a 2 pointer appproach
        for(int i = 0; i < n - 1; i++){  // if we take  i < n we will get array index out of bounds error.
            for(int j = 0; j < n - i - 1; j++){  // if we keep <= also we will get an error tell me what is that error?
                if( arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j + 1] = temp;
                }
            }
        }

        return arr;
    }
}
