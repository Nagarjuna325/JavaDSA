package backtracking;

public class Includeallpaths {

   // first trying with just modifying the code for including both directions where we took right and down only
    // adding the remaining 2 edges cases where we will figure left and up

    // what the issue we are getting now and how to solve it?
    public static void main(String[] args){

        boolean[][] board = {
                {true, true , true},
                {true, true, true},
                {true, true , true}
        };

        path("", board, 0, 0);

    }

    static void path(String p, boolean[][] maze, int r, int c){
        // this is for last call (2 , 2) check notes tree graph drawn
        if( r == maze.length - 1 && c == maze[0].length - 1){
            System.out.println(p);
            return ;

        }

        if( maze[r][c] == false){
            return ;
        }

        // I am considering this block in my path
        maze[r][c] = false;


        // this is for moving down
        if ( r < maze.length - 1){
            path( p + 'D' , maze,r + 1, c);

        }
        // right side
        if ( c < maze[0].length - 1){
            path( p + 'R' , maze , r , c + 1);
        }

        if( r > 0){
            path( p + 'U' , maze, r - 1 , c);
        }


        if( c > 0){
            path( p + 'L', maze, r , c - 1);
        }
        // this is the line where the function will be over
        // So before the function gets removed also remove the changes that were made by that function
        maze[r][c] = true;
    }

}
