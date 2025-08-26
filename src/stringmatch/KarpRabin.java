package stringmatch;

public class KarpRabin {

    int PRIME = 100;

    // calculating the hashcode
    long hashcode(String s) {

        long hash = 0;
        for( int i = 0; i < s.length(); i++){

            hash = (long) (hash + s.charAt(i)*Math.pow(PRIME , i));
        }

        return hash;

    }


    // method to calculate the hashcode on rolling window basis and updates it

    long updateHash(long prevHash, char oldChar, char newChar, int patternLength){

        long newHash = (prevHash - oldChar) / PRIME;
        newHash = (long) (newHash + newChar* Math.pow(PRIME, patternLength - 1));
        return newHash;
    }


    // now th karp rabin  algorithm

    public void search( String text, String pattern){
        int patternLength = pattern.length();
        int textLength = text.length();

        long patternHash = hashcode(pattern);
        long textHash = hashcode(text.substring(0, patternLength));

        for( int i = 0; i< textLength - patternLength; i++ ){ // why textlenght - patternlenght only?

            if( textHash == patternHash){
                if( text.substring(i,i+patternLength).equals(pattern)){
                    System.out.print("Pattern found at index" + i);
                }
            }

            if( i < textLength - patternLength){
                textHash = updateHash( textHash , text.charAt(i), text.charAt(i+ patternLength), patternLength);
            }

        }



    }


}


//NOTES:

// Average time is O(N) , and worst case time is O(N*N) If collisions happens.

// use of hash values  not HashMap