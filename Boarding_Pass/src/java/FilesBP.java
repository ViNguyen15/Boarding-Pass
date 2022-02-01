import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FilesBP {
    static Charset utf8 = StandardCharsets.UTF_8;
    static Path path = Paths.get("src/resources/boarding_pass_data");

    public void createAFile() throws IOException {
        if( !Files.exists(path) )
            Files.createFile(path);
    }

    public void writeToFile(BoardingPass pass) throws IOException {
        createAFile();
        try {
            Files.write(
                    path,
                    Arrays.asList(pass.toString()),
                    utf8,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e){
            System.out.println("Error: writeToFile failed");
            e.printStackTrace();
        }
    }


    public void readFromFile() {
        try {
            Files.readAllLines(
                    path
            );
        } catch (IOException e){
            System.out.println("Error: readFromFile failed");
        }

    }

}
