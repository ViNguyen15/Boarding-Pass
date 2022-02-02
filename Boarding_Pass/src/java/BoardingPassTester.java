import java.io.IOException;

public class BoardingPassTester {

    public static void main(String[] args) {



        BoardingPass pass1 = new BoardingPass("Jimmy",
                "Fluffy@gmail.com", "404", "m", 21,
                "now", "there", "now");

        System.out.println(
                pass1.toString()
        );

        System.out.println(
                pass1.generateETA(25, "125")
        );

        System.out.println("ETA: " + pass1.generateETA( 25, "1235")+"mins. ");
        
    }


}
