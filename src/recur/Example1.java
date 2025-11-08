package recur;

public class Example1 {

    public static void main(String[] args) {
        // Q1. Write a function that prints hello world
        // Q2. Print Hello World 5 times
        // 2 ways we call message() function 5 times - 1 way
        // other way 5 print statement in the same function

        // Q3. Now the question is we need to call the function only one time to print "Hello World" - 5 times
        // and we should use 5 print statements in a single function
        // So how can we do it?

          message1();
    }

    // So we observe carefully all the functions have same body and defination of the method is same



    static void message1(){
        System.out.println("Hello World");
        message2();
    }

    static void message2(){
        System.out.println("Hello World");
        message3();
    }

    static void message3(){
        System.out.println("Hello World");
        message4();
    }
    static void message4(){
        System.out.println("Hello World");
        message5();
    }
    static void message5(){
        System.out.println("Hello World");
    }
}


//  All the functions call goes into the "Stack Memory" excetues and print and comes
// out of the memory

// How the function call works in language
// while the function is not finished executing it will be in Stack memory
// when a function completes it execeution it comes out of the stack and flow of the programm
// goes to from where it is called.

// As many times u call the same function also it will take seperate memory in the stack
// even it is of the same function also

// Why recursion? - too solve complex problems easily.
// we can convert any recursion into iteration and vice versa any problem
// iteration means - for loops.
// When to use recursion? -
// Space complexity - 0(N)
// able to break bigger problems into smaller problems


// How to find a problem can be solved using the recursive way
// first see if we can break a problem down to the smallest sub-problem - time stampe - 56:00
// // Fibonic series

// 0 , 1 , 2 , 3 , 5 , 8,
// F(n) = F(n-1) + F(n-2) -recurrence relation
// and find the base condition - F(0) , F(1) - answer already provided too u
//  What is the tale recursion
// if it prints last statement

// what are the variables which will go where in the recursion?
// Identifying it is very important
// 1. Arguments
// 2. return type
// 3. Body of the function
