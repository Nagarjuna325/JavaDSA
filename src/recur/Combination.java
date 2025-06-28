package recur;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        int target = 6; // Define the target sum

        Combination comb = new Combination();
        List<List<Integer>> result = comb.combinationSum(arr, target);

        // Printing the result
        System.out.println(result);
    }

    public void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        // Include the current element in the combination if it's <= target
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1); // Backtrack
        }
        // Move to the next element
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}

