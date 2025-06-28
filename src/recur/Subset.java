package recur;

import java.util.ArrayList;

public class Subset {

    public static void main(String[] args) {


        System.out.println(subs("", "abcd"));


    }



    static void setq(String p, String up ) {

        if(up.isEmpty()){
            System.out.println(p);
            return ;

        }

        char ch = up.charAt(0);

        setq(p + ch,up.substring(1) ); // add it
        setq( p , up.substring(1));  // ignore it the char at postion
        // want to get Ascii values also in the output
        // then just have one more function instead of two have 3 and print Ascii values
        setq( p + (ch+0), up.substring(1));
    }


     // another way to return answer in a arraylist form by using refrence variable -- very important point

    static ArrayList<String> subs(String p , String up){

        if(up.isEmpty()){

            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;

        }

        char ch = up.charAt(0);
        ArrayList<String> left = subs( p+ch , up.substring(1));
        ArrayList<String> right = subs( p , up.substring(1));

        // same 3rd in this also

        ArrayList<String> ascii = subs( p+ch , up.substring(1));

        left.addAll(right);

        //left.addAll(ascii);

        return left;
    }


}
