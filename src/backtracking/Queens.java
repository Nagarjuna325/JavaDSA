package backtracking;

public class Queens {
     // no of ways we can place a queen so int value at static datatype
    public static void main( String[] args){
        int n = 5;

        boolean[][]  board = new boolean[n][n];
         // queen(board , 0); // Just prints all the matrix

        // if we want count also

        System.out.print(queen(board , 0));

    }


   // how we got like to take int and also we need to pass the boolean board because in the after every recrusion call after placing a single q at a position we need to take remaining board right
    // excluding that row so we need to take the board and also how to choose what is the other variable we need to pass
    // we can also pass col also but if we see every time a row is finished we will be starting form same 0 if took column so its of no use we can take but

    static int queen(boolean[][] board, int row) {


       // when does my recursion call will end if my row becomes length of the board.
        if( row == board.length){

            display(board); // function to display the board

            System.out.println();
            return 1;
        }


        int count = 0;
        // placing the queen and checking  for every row and col

        for(int col = 0; col < board.length; col++){
            // place the queen if it is safe

             if(isSafe(board, row , col)){
                 board[row][col] = true;
                 count += queen(board , row + 1);

                 // change it back to normal backtracking here

                 board[row][col] = false;
             }
        }

        return count;
    }


     // implementing the isSafe method

    static boolean isSafe( boolean[][] board, int row, int col){
       // check vertical row

        for( int i=0; i < row; i++){
            if( board[i][col]){ // is true means there is a queen there

                return false;
            }
        }

        // diagonal left

        int maxleft = Math.min( row , col);

        for( int i = 1 ; i <=maxleft;  i++){

            if( board[row - i][col - i]){
                return false;
            }
        }



        // diagonal right

        int maxright = Math.min( row , board.length - col -1);

        for( int i = 1 ; i <=maxright;  i++){

            if( board[row - i][ col + i]){
                return false;
            }
        }

        // none of the checks return false then it is true

        return true;
    }

    static void display(boolean[][] board){

        for( boolean[] row : board){
            for( boolean  element : row){

                if( element){ // if it is true

                    System.out.print( "Q");
                }
                else{
                    System.out.print("0");
                }
            }
            System.out.println();  // return to a new line row
        }
    }

}
