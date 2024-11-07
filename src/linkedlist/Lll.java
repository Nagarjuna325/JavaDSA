package linkedlist;


// creating our own linkedList
public class Lll {

   private Node head;
   private Node tail;

   private int size;

   public Lll(){

       this.size = 0;
   }


  public void insertFirst(int val){

       Node node = new Node(val);
       node.next = head;

       head = node;

       if( tail == null){
           tail = head;
       }

       size += 1;

  }
   public void insertLast( int val){

       if( tail == null) {

           insertFirst(val);

           return;
       }

       Node node = new Node(val);
       tail.next = node;
       tail = node;
       size++;
   }
   public void insert( int val, int index){
       if( index == 0 ){

           insertFirst(val);
           return;
       }

       if( index == size){

           insertLast(val);
           return;
       }

       Node temp = head;
       for( int i = 1; i<index; i++){

           temp = temp.next;
       }
       Node node = new Node(val , temp.next);

       temp.next = node;
       size++;
   }

   public int deleteFirst(){
       int val = head.value;
       head = head.next; // moving heading one step forward

       if( head == null){ // if we have only one item , if head becomes null then tail also becomes null

           tail = null;
       }

       size--;
       return val;

   }

   public void display(){


       Node temp = head;
       while( temp!= null){
           System.out.print(temp.value + "->");
           temp = temp.next;
       }
       System.out.println("END");
   }



   public int deleteLast(){ // by this way we will have a time complexity of O(n) we need to traverse through entire list.

       if( size <= 1){

           return deleteFirst();
       }

       Node secondLast = get(size - 2);
       int val = tail.value;


       tail =  secondLast;
       tail.next = null;


       return val; // we want to written the value to return
   }
   public Node get(int index){

       Node node = head;

       for( int i=0; i< index; i++){

           node = node.next;
       }

       return node;
   }

   // delete an index at any position  we can use do like this

    public int delete(int index){

       if( index == 0){

           return deleteFirst();
       }

       if( index ==  size){

           return deleteLast();
       }

       Node prev = get( index - 1);

       int val = prev.next.value; // remove value from the list it will give 8 vale

        prev.next = prev.next.next; // it will point to 9 now

        return val;
    }
    private class Node {

        private int value;
        private Node next; // intial nothing will point to Null


        // constructor
        public Node(int value){
            this.value = value;
        }

        // constructor
        public Node(int value, Node next){

            this.value = value;
            this.next = next;
        }

    }
}
