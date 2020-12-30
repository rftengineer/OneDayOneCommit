import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class PathsAndFilesTest {

    @Test
    void java7_Paths_Test() throws IOException {
        Path path = Paths.get("src/test/resources/sample1.txt");
        BufferedReader br = Files.newBufferedReader(path);

        assertThat(br.readLine()).isEqualTo("Hello World!");
    }

    @Test
    void java7_createDirectory_Test() throws IOException {
        String prefix = "nio_Test_";
        Path path = Paths.get("src/test/resources/");
        Path path2 = Files.createTempDirectory(path, prefix);
        assertThat(path2).isEmptyDirectory();
        //System.out.println(path2.toString());
        Files.deleteIfExists(path2);
    }

    @Test
    void java7_createDirectory_Test2() throws IOException {
        String prefix = "nio_Test_";
        Path path = Paths.get("src/test/resources/",prefix);
        Path path2 = Files.createDirectory(path);
        assertThat(path2).isEmptyDirectory();
        Files.deleteIfExists(path2);
    }
}
