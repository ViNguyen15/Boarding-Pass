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

public class FilesBP {
    static Charset utf8 = StandardCharsets.UTF_8;
    static Path path = Paths.get("src/resources/boarding_pass_data");


    public void createAFile() throws IOException {
        if( !Files.exists(path) )
            Files.createFile(path);
    }

    public void writeToFile(BoardingPass pass) {

        try {
            createAFile();
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


    public List<String> readFromFile() {
        try {
            return Files.readAllLines(
                    path
            );
        } catch (IOException e){
            System.out.println("Error: readFromFile failed");
            return new ArrayList<>();
        }

    }

    public static void main(String[] args) {
        FilesBP bp = new FilesBP();


        int count = 0;
        for(String x : bp.readFromFile().get(0).split("'") ) {
            if(count % 2 == 1)
                System.out.println(x);
            count++;
        }

    }

}
