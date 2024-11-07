package recur;

public class Dice {
    public static void main(String[] args){
        dice("", 3);
    }

    static void dice(String p, int target){

        if(target ==  0){
            System.out.println(p);
            return;
        }

        for( int i = 1; i<= target && i <=target ; i++){
            dice( p + i , target - i); // here observe carefully as args p is string type it will be convert to string add i value which is a integre so ouput will be like string addition only
        }
    }
}
