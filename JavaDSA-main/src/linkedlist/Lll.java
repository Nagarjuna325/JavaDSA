package linkedlist;


//import java.lang.classfile.components.ClassPrinter;

// creating our own linkedList
public class Lll {

   private Node head;
   private Node tail;

   private int size;

   public Lll(){

       this.size = 0;
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



   // insertion of elements

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


// insert of a node using Recrusion is useful when we are asked to solve the insert in linkedlist if they dont give us size and tail node.


    public void insertRec(int val, int index){

        head = insertRec( val, index, head);

    }

    private Node insertRec(int val, int index, Node node){ // index remaining where the loaction we need to insert

        if( index == 0){
            Node temp = new Node(val, node);

            size++;

            return temp;
        }

        // first 9.next = 7 ,9 will be return to 5 next,  5.next = 9
        node.next = insertRec( val , index - 1, node.next); // why node.next  because we want to move to back own which is 9.1 = next so  going forward


        return node; // in every function call it is returning itself and

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

    // Leetcode 83 questions
    public void duplicates() {

        Node node = head ;

        while ( node.next != null){ // why while beacuase we dont know tail

            if (node.value == node.next.value ) {

                node.next = node.next.next;
                size--;
            } else {

                node = node.next;
            }
        }

        tail = node;
        tail.next = null;
    }


    // 21 Leetcode questions

    public static Lll merge(Lll first, Lll second){ // why u got error when i used so other name apart from Lll because we need to use same class type of Lll we defined

        Node f = first.head;
        Node s = second.head;

        Lll ans = new Lll();

        while( f != null && s != null){

            if( f.value < s.value){

                ans.insertLast(f.value); // why we are using insertLast simple because we adding the node elements at the end of the node not at first so thats why.
                f = f.next;
            } else {

                ans.insertLast(s.value);
                s = s.next;

            }
        }

        while( f != null){ // case to check if anything is left in first Node so all the remaining will be added to end of the new list

            ans.insertLast( f.value);
            f = f.next;
        }

        while( s != null){

            ans.insertLast( s.value);
            s = s.next;
        }

        return ans;

    }



    // leetcode 141 LinkedList cycle
    // when there is a cycle apply fast and slow pointer

//    public boolean hasCycle(ListNode head) {
//
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while( fast != null && fast.next != null){
//
//            fast = fast.next.next; // for jumping 2 positions
//            slow = slow.next;
//
//            if( fast == slow){
//
//                return true;
//
//
//
//            }
//
//
//        }
//
//        return false;
//
//    }
//
//
//    // Finding the length of the linkedList cycle
//
//    public int LengthCycle(ListNode head) {   // changed the return type as we need to return the length value.
//
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while( fast != null && fast.next != null){
//
//            fast = fast.next.next; // for jumping 2 positions
//            slow = slow.next;
//
//            if( fast == slow){
//
//             // calculate the lenght
//
//                ListNode temp = slow;
//                int length = 0 ;
//
//                do {
//                     temp = temp.next;
//                     length++;
//                }while( temp != slow);
//
//                return length;
//
//
//
//
//            }
//
//
//        }
//
//        return 0;
//
//    }


    // 142. finding where the node of the cycle starts

//    public ListNode detectCycle(ListNode head) {
//
//        ListNode fast = head;
//        ListNode slow = head;
//
//        while( fast != null && fast.next != null){
//
//            fast = fast.next.next; // for jumping 2 positions
//            slow = slow.next;
//
//            if( fast == slow){
//
//                length = LengthCycle(slow);
//                break;
//
//            }
//
//
//        }
//
//        return false;
//
//    }
//
//    if ( length == 0){
//
//        retun null;
//    }
//
//    // Now we have cycle from above
//    // we need to find the start of the NODE
//    ListNode f = head;
//    ListNode s = head;
//
//
//    while( length > 0) {
//
//        s = s.next;
//        length--;
//
//    }
//   // Keep moving both forward and they will meet at cycle start
//
//    while( f != s){
//
//        f = f.next;
//        s = s.next;
//    }
//
//    return s;


}
