package recur;

public class Recrusionstrings {

     public static void main(String[] args) {

       skip("", "ababacas");
     }


     static void skip( String p, String  up){ // p = answer array which empty intially , up is orginal array

         if(up.isEmpty()){
             System.out.println(p);
             return ;
         }

         char ch = up.charAt(0);

         if( ch == 'a'){
             skip(p , up.substring(1)); // substring will create a new object . as we know strings are immutable and it always creates a new object

         } else {
           skip(p+ch , up.substring(1));
         }


     }
}


  // without using recrusion

//    public static void main(String[] args) {
//        skip("ababacas");
//    }
//
//    static void skip(String up) {
//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < up.length(); i++) {
//            char ch = up.charAt(i);
//
//            // Skip the character if it's 'a'
//            if (ch != 'a') {
//                result.append(ch);
//            }
//        }
//
//        System.out.println(result.toString());
//    }


// 3rd way


// in main System.out.println(skip("baccdah"));
//    static String skip( String  up){ // p = answer array which empty intially , up is orginal array
//
//        if(up.isEmpty()){
//
//            return "" ;
//        }
//
//        char ch = up.charAt(0);
//
//        if( ch == 'a'){
//            return skip(up.substring(1)); // substring will create a new object // when to have a return if u have any data type return before the function and we are calling it we need to have return type
//
//        } else {
//            return ch + skip(up.substring(1)); // hey I know ur going up take this also
//        }
//
//
//    }