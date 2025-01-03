package stacks;

public class DynamicStack extends CustomStack{  // inheritence implementation


    public DynamicStack() {  // creating a constructor why constructor?
        super(); // it will call CustomStack()
    }

    public DynamicStack(int size){
        super(); // it will call customStack(int size)
    }

    @Override
    public boolean push(int item) {
        //return super.push(item);
        if ( this.isFull()){

            // double the array size
            int[] temp = new int[data.length * 2];

            // copy all previous items in new data
            for (int i=0 ; i < data.length; i++){
                temp[i] = data[i];
            }

            data = temp;
        }


        //at this point we know that array is not full
        // so insert a item

        return super.push(item); // learn what is super is?
    }
}
