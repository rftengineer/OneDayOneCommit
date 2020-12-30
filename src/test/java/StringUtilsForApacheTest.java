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

    @Test
    void apache_StringUtils_TestMethod4() {
        String value = "";
        assertThat(StringUtils.stripToNull(value)).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", " "})
    @DisplayName("StripToNull의 용례 체크")
    void apache_StringUtils_TestMethod5(String value) {
        assertThat(StringUtils.stripToNull(value)).isNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"xyzstryzx", "xystrz", "strzxyxzz"})
    @DisplayName("stripChars 지정할 경우 작동하는 원리 파악")
    void apache_StringUtils_TestMethod6(String value) {
        assertThat(StringUtils.strip(value, "xyz")).isEqualTo("str");
    }

    @ParameterizedTest
    @ValueSource(strings = {"xyzstr", "yzstr", "zxstr"})
    void apache_StringUtils_Method7(String value) {
        assertThat(StringUtils.stripStart(value, "xyz")).isEqualTo("str");
    }

    @ParameterizedTest
    @ValueSource(strings = {"strxyz", "strzy", "strzx"})
    void apache_StringUtils_Method8(String value) {
        assertThat(StringUtils.stripEnd(value, "xyz")).isEqualTo("str");
    }

    @Test
    void apache_StringUtils_Method9() {
        String a1 = "sqrt";
        String a2 = "sqrt";
        assertThat(StringUtils.equals(a1, a2)).isTrue();
    }

    @Test
    @DisplayName("null도 equals시 비교하는지 확인")
    void apache_StringUtils_Method10() {
        String a1 = null;
        String a2 = null;
        assertThat(StringUtils.equals(a1, a2)).isTrue();
    }


}
