package linearsearch;

public class SearchInStrings {

    public static void main(String[] args) {
        String str1 = "Varun";
        char ch = 'a';
        // boolean ans = search(str1 , ch);
        char ans = searc(str1 , ch);
        System.out.println(ans);
    }

    static boolean search(String str, char target){

        // case 1 - str1 length is 0
        if( str.length() == 0){
            return false;
        }


          for( int i = 0; i < str.length(); i++){
              if( target == str.charAt(i) ){
                  return true;
              }
          }

          return false;


    }

 // returning the char
    static char searc(String str, char target){

        // case 1 - str1 length is 0
        if( str.length() == 0){
            return ' '; // before error I got I used "" double quotes which is a string.
        }


        for( int i = 0; i < str.length(); i++){
            if( target == str.charAt(i) ){
                return str.charAt(i);
            }
        }

        return ' ';


    }
}
