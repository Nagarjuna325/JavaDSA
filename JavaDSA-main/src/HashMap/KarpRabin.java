package HashMap;

public class KarpRabin {
    private final int PRIME = 101;  // declared a prime number take any


    // calculating the hash
    private double calculateHash(String str) {
        double hash = 0;
        for(int i=0; i < str.length(); i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // the patternLength the pattern we are searching for.

    private double updateHash(double prevHash, char oldChar, char newChar, int patternLength) {
        double newHash = (prevHash - oldChar) / PRIME;
        newHash = newHash + newChar * Math.pow(PRIME, patternLength - 1);
        return newHash;
    }

    public void search(String text, String pattern) {
        int patternLength = pattern.length();
        double patternHash = calculateHash(pattern);
        double textHash = calculateHash(text.substring(0, patternLength));


        // why we took onlu text.length() - patternLength ? why

        for(int i=0; i<= text.length() - patternLength; i++) {
            if(textHash == patternHash) {
                if(text.substring(i, i+patternLength).equals(pattern)) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            if (i < text.length() - patternLength) {
                textHash = updateHash(textHash, text.charAt(i), text.charAt(i + patternLength), patternLength);
            }
        }
    }

    public static void main(String[] args) {
        KarpRabin algo = new KarpRabin();
        algo.search("ApoorvKunalRahul", "Kunal");
    }
}


// O( n+m) - linear timecomplexity

// using normal search - quadratic time complexity - O(n*m)

// the above function is called rolling hash implementation.