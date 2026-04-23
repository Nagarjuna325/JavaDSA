package stringsandstringbuilder;

public class Peformance {

    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            series = series + ch; // series += ch
        }

        System.out.println(series);
    }


    // whats the issue with this program performance

    // See we know strings are immutable and each time a new String object is created and adding to
    // it and the remaining are garbage collected here

    // a + b
    // ab+ c  - new object
    // abc + d
    // ... like this


    // So that means we need a datatype which will create a single object and keep on adding to it
    // So that datatype is called StringBuilder class

}
