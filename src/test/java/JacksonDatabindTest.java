import com.fasterxml.jackson.databind.ObjectMapper;
import dao.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonDatabindTest {

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    void jackson_databind_test1() throws IOException {
        //objectMapper = new ObjectMapper();
        Car car = new Car("red", "Hyundai");

        Path path = Paths.get("src/test/resources/result1.json");
        System.out.println(car.getColor());
        objectMapper.writeValue(path.toFile(), car);

    }

    @Test
    @DisplayName("Car 객체 안에 생성자, super() 사용 확인")
    void jackson_databind_test2() throws IOException {
        String jsonData = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car = objectMapper.readValue(jsonData, Car.class);
        assertThat(car.getColor()).isEqualTo("Black");
    }
}
