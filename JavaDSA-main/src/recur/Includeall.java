package recur;

public class Includeall {


    public static void main(String[] args){

        boolean[][] board = {
                {true, true , true},
                {true, false, true},
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

        // this is for moving down
        if ( r < maze.length - 1){
            path( p + 'D' , maze,r + 1, c);

        }
        // right side
        if ( c < maze[0].length - 1){
            path( p + 'R' , maze , r , c + 1);
        }
    }

}
