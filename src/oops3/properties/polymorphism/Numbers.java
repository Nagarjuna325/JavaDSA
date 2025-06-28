package oops3.properties.polymorphism;

public class Numbers {

    int sum(int a, int b){  // what if we use double type here we keep it and in the below we if we call it won't give us
        // error when calling? -IMP
        return a + b;
    }

    int sum(int a, int b, int c){
        return a + b + c;
    }

    public static void main(String[] args){

        Numbers obj = new Numbers();

        obj.sum(2,3);
        obj.sum(2,3,4);
    }
}
