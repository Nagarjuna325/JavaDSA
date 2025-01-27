package oops4.access;

public class A {
    protected int num;
    String name;
    int[] arr;

    public int getNum() { // getters and setters
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public A(int num, String name) {
        this.num = num;
        this.name = name;
        this.arr = new int[num];
    }
}
