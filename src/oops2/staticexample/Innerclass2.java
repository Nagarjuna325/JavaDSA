package oops2.staticexample;


class Test {
    static String name;
    public Test(String name){
        Test.name = name;
    }
}


public class Innerclass2 {

    public static void main(String[] args){

             Test a = new  Test("kunal");
             Test b = new  Test("Runal");

             System.out.println(a.name);
             System.out.println(b.name);

             // Output will be both will show rahul WHY?
    }
}
