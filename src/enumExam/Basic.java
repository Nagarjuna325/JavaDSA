package enumExam;

public class Basic {

    enum Week {

         Monday , tuesday , Wednesday , Thursday, Friday , Saturday , Sunday

        // these are enum constants
        // public, static , and final
        // since it final u cannot create an objects
        // type is Week
       // we can access it since they are static


    }


    public static void main( String[] args){

        Week week;
        week = Week.Monday;

        for( Week day : Week.values()){

            System.out.println(day);
        }
    }
}
