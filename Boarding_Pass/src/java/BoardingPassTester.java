import java.io.IOException;

public class BoardingPassTester {

    public static void main(String[] args) {



        BoardingPass pass1 = new BoardingPass("Jimmy",
                "Fluffy@gmail.com", "404", "m", 21,
                "now", "there", "now");

        System.out.println(
                pass1.toString()
        );


        FilesBP file = new FilesBP();
        try {
            file.writeToFile(pass1);
        } catch (IOException e){
            System.out.println("Error");
        }


    }


}
