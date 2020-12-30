import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilsForApacheTest {

    @Test
    void apache_StringUtils_TestMethod1() {
        String value = "Str1  ";
        assertThat(StringUtils.strip(value)).isEqualTo("Str1");
    }

    @ParameterizedTest
    @ValueSource(strings = {" Str1", " Str1 ", "Str1", "Str1     "})
    @DisplayName("StringUtils의 공백 제거의 경우, 어떻게 제거하는지 참고하기 위한 테스트")
    void apache_StringUtils_TestMethod2(String value) {
        assertThat(StringUtils.strip(value)).isEqualTo("Str1");
    }

    @ParameterizedTest
    @ValueSource(strings = {"S tr1  ", "S tr1", " S tr1 "})
    @DisplayName("중간의 공백의 경우는 무시하는지에 대한 테스트")
    void apache_StringUtils_TestMethod3(String value) {
        assertThat(StringUtils.strip(value)).isEqualTo("S tr1");
    }
}
