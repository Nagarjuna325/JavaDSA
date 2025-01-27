package oops2.singleton;


// singleton class is a class which helps to create a single instance only for a class
// we cannot create more instance than one instance for a class

// when u want to create only one class we should not allow any other objects to access the constructor to that class
// right
public class Singleton {

     private Singleton (){   // in this class only we can use this

     }

     private static Singleton instance;  // so what happened is we are creating a instance in the class here

    // and it is given to the object which is needs it when we create a through getInstance() method
     public static Singleton  getInstance(){

         // check whether 1 obj only is created or not
         if( instance == null){
             instance = new Singleton();
         }
          return instance;
     }
}
