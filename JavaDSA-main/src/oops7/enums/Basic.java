package oops7.enums;

public class Basic {
    enum Week {// overall type
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // public, static and final
        // since its final you cannot create child enums
        // type of all this Monday ,... so on is where it is declared, Week. is Week

        void display() {

        }

        Week() {
            System.out.println("Constructor called for " + this);
        }

        //@Override
        public void hello() {
            System.out.println("hey how are you");
        }
        //  the above constructor, Week() is not public or protected, only private or default
        // why? we dont want to create new objects
        // this is not the enum concept, thats why

        // internally: public static final Week Monday = new Week();
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Week week;
        week = Week.Monday;
        week.hello();
        System.out.println(Week.valueOf("Monday"));
//        for(Week day : Week.values()) {
//            System.out.println(day);
//        }
//       Class obj = Class.forName("Basic");
//       System.out.println(obj);
//        System.out.println(week.ordinal());
    }
}


// enums are used to create our own datatypes in java.they are constant and cannot be changed. and also static.
// when we want to use a fixed group of objects we can use enums. Jan , feb march,.. dec.

// a enum cannot be a super class also why?
// enum can implement has many interfaces
// but it cannot extend a class.