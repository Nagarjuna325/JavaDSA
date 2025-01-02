package stacks;

public class CustomStack {

    protected int[] data;

    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
        this(DEFAULT_SIZE);
    }
    public CustomStack(int size) {

        this.data = new int[size];

    }

    public boolean push(int item){


        if(isFull()){
            System.out.println("Stack is Full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

   public boolean isFull() {
        return ptr == data.length - 1; // ptr is at the last index
   }

   public boolean isEmpty () {
        return ptr == -1;
   }


   public int pop() throws Exception{

        if (isEmpty()){
            throw new Exception(" Cannot pop from an empty stack");

        }
       int removed = data[ptr];
        ptr--;
        return removed ;
   }


   public int peak() throws Exception{

       if (isEmpty()){
           throw new Exception(" Cannot peak from an empty stack");

       }
        return data[ptr];
   }

}
