import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Used to read and write to text file that is located in the resource folder
 *
 * @author Vi Nguyen
 *
 */
public class FilesBP {
    static Charset utf8 = StandardCharsets.UTF_8;
    static Path path = Paths.get("src/resources/boarding_pass_data.txt");
    static ArrayList<Integer> bpID = new ArrayList<>();

    // needs all id first
    public FilesBP() {
        allID();
    }

    // find the id within the list
    public static void allID(){
        for(String boardingPass : readFromFile() ) {
            bpID.add( Integer.parseInt( boardingPass.split("'")[17] ) );
        }
    }

    // if file doesnt exist make one
    public void createAFile() throws IOException {
        if( !Files.exists(path) )
            Files.createFile(path);
    }

    // takes the boarding pass object and write it onto a file
    public void writeToFile(BoardingPass pass) {
        try {
            createAFile();
            Files.write(
                    path, Arrays.asList( pass.toString() ),
                    utf8, StandardOpenOption.APPEND
            );
        } catch (IOException e){
            System.out.println("Error: writeToFile failed");
            e.printStackTrace();
        }
    }

    // reads from file
    static public List<String> readFromFile() {
        try {
            return Files.readAllLines( path );
        } catch (IOException e){
            System.out.println("Error: readFromFile failed");
            return new ArrayList<>();
        }

    }

}
