import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Car;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JacksonDatabindTest {

    @Test
    void jackson_databind_test1() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("red","BMW");

        Path path = Paths.get("src/test/resources/result1.json");
        System.out.println(car.getColor());
        objectMapper.writeValue(path.toFile(),car);

    }
}
