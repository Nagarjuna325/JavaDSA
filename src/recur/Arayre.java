package recur;

import java.util.ArrayList;

public class Arayre {

        public static void main(String[] args) {
            int[] arr = {2, 3, 1, 4, 4, 5};

            // Initialize the ArrayList before passing it to the method
            ArrayList<Integer> list = new ArrayList<>();

            // Call the method and store the result
            ArrayList<Integer> ans = findAllIndex(arr, 4, 0, list);

            // Print the result
            System.out.println(ans);
        }

        static ArrayList<Integer> findAllIndex(int[] arr, int target, int index, ArrayList<Integer> list) {
            if (index == arr.length) {
                return list;
            }
            if (arr[index] == target) {
                list.add(index);
            }
            return findAllIndex(arr, target, index + 1, list);
        }


}
