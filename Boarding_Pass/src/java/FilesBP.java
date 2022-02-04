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
import java.util.stream.Collectors;

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
    static ArrayList<BoardingPass> allBP = new ArrayList<>();

    // needs all id first
    public FilesBP() {
        allID();
        allBPsetup();
    }

    public static void allBPsetup(){
        readFromFile()
                .stream()
                .map( e -> Arrays.stream(e.split(","))
                        .map(str -> str.split("'")[1])
                        .collect( Collectors.toList() ) )
                .forEach(bp -> {
                    allBP.add( new BoardingPass(
                            bp.get(0), bp.get(1), bp.get(2), bp.get(3),
                            Integer.parseInt(bp.get(4)), bp.get(5), bp.get(6), bp.get(7),
                            Integer.parseInt(bp.get(8)), bp.get(9), bp.get(10), bp.get(11) )
                    );
                });
    }

    // find the id within the list
    public static void allID(){
        if(readFromFile().isEmpty()) {
            bpID.add(0);
            return;
        }
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

    // use to update existing textfile
    public void reWriteFile(){
        try {
            Files.write(
                    path, Arrays.asList( allBP.get(0).toString() ),
                    utf8, StandardOpenOption.TRUNCATE_EXISTING
            );
        } catch (IOException e){
            System.out.println("Error: writeToFile failed");
            e.printStackTrace();
        }

        for (int i = 1; i < allBP.size(); i++){
            try {
                Files.write(
                        path, Arrays.asList( allBP.get(i).toString() ),
                        utf8, StandardOpenOption.APPEND
                );
            } catch (IOException e){
                System.out.println("Error: writeToFile failed");
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        FilesBP file = new FilesBP();

        //allBP.stream().forEach(a -> System.out.println(a.getEmail()));
        //file.reWriteFile();

    }



}
