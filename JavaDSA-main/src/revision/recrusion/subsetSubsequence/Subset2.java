package revision.recrusion.subsetSubsequence;

import java.util.ArrayList;

public class Subset2 {

    // creating and dealing with sets of  a string from a given string

    public static void main(String[] args) {

        subseq("", "abc");

    }

    static void subseq(String p, String up){

        if( up.isEmpty()){

            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);

        subseq(p+ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    // now returing the result in ArrayList form

    static ArrayList<String> sub(String p, String up){

        if( up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        ArrayList<String> left = sub(p+ch, up.substring(1));
        ArrayList<String> right = sub(p, up.substring(1));

        left.addAll(right);
        return left;
    }
}
