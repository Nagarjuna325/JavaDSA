package revision.recrusion;

import java.util.ArrayList;

// find all the occurrence of the elements in the array
public class findAll {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5,4,6,6,6,9,10};
        findAllIndex(arr, 6, 0);
        System.out.println(list);

    }

    static ArrayList<Integer> list = new ArrayList<>();
    static void findAllIndex(int[] arr, int target, int index){

        if( index == arr.length){
            return;
        }

        if( arr[index] == target){
            list.add(index);
        }

        findAllIndex(arr, target, index+1);  // got error first (Stack Over Flow error) because didn't used the index+1 instead written index,
        // So which will be always calling the same function which the same index where it is.
    }

    static ArrayList<Integer> findAllIndex2(int[] arr, int target, int index, ArrayList<Integer> list){

        if( index == arr.length){
            return list;
        }

        if( arr[index] == target){
            list.add(index);
        }

        return findAllIndex2(arr, target, index+1, list);  // got error first (Stack Over Flow error) because didn't used the index+1 instead written index,
        // So which will be always calling the same function which the same index where it is.
    }

    static ArrayList<Integer> findAllIndex3(int[] arr, int target, int index){


        ArrayList<Integer> list = new ArrayList<>();

        if( index == arr.length){
            return list;
        }

        if( arr[index] == target){
            list.add(index);
        }

         ArrayList<Integer> ans= findAllIndex3(arr, target, index+1);

         list.addAll(ans);

         return list;
    }
}
