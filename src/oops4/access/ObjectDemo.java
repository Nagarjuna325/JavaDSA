package oops4.access;

public class   ObjectDemo {
    int num;
    float gpa;

    public ObjectDemo(int num, float gpa) {
        this.num = num;
        this.gpa = gpa;
    }

    // already covered these 2
    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }


    // we will go in details of how to create it in hashmap lecture
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((ObjectDemo)obj).num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(12, 56.8f);
        ObjectDemo obj2 = new ObjectDemo(12, 78.9f);

        if (obj1 == obj2) { // == or comaprator checks whether both refernce is pointing to the same object or not
            System.out.println("obj1 is equal to obj2");
        }

        if (obj1.equals(obj2)) { // equals method checks the content of the object.
            System.out.println("obj1 is equal to obj2");
        }

        System.out.println(obj1 instanceof ObjectDemo);

        System.out.println(obj1.getClass().getName());

//        System.out.println(obj.hashCode());
//        System.out.println(obj2.hashCode());
    }

}


// what is hashcode?

// an internal representation of object with a unqiue number. a random number for identifying a object not adrress of the object.

// one mis-conception in java is hashcode is a address value - NO it is wrong, w cannot get a address value in java

// So hashcode is a some random number which is implemented or generated using some algorithm internally.

// How to compare the values of objects obj1 > obj2? will learn in interfaces and obstract one. how to do this? Just problems it will
// be conufused now which value to compare here now.?
//if (obj1 < obj2) {
//        System.out.println("obj1 is equal to obj2");
//        }