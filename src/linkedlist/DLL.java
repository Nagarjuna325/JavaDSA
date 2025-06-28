package linkedlist;

public class DLL {


    Node head;

    public void insertFirst(int val){

        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if( head != null){
            head.prev = node;
        }
        head = node;

    }


    public void display(){


        Node node = head; // initial node

         while ( node != null){
             System.out.print( node.val + "->");
             node = node.next; // reassigning the node to next one
         }
         System.out.println();
    }


// to display output in reverse order.
    public void displayReverse(){


        Node node = head; // initial node
        Node last = null;

        while ( node != null){
            System.out.print( node.val + "->");
            last = node;
            node = node.next; // reassigning the node to next one
        }
        System.out.println();


        while( last != null){

            System.out.print( last.val + "->");

            last = last.prev;
        }
    }

    public class Node{

        int val;
        Node next;
        Node prev;


        // Constructor declaration
        public Node(int val){

            this.val = val;
        }

        // Constructor declaration
        public Node(int val, Node next, Node prev){

            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
