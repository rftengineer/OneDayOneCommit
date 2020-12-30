import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

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

    @ParameterizedTest
    @CsvSource({"1,eabcd"
            , "-1,bcdea"
            , "0,abcde"
    })
    @DisplayName("Rotate 예제, 양수,0,음수에 대한 케이스 모두 입력해서 확인")
    void apache_StringUtils_Method11_Rotate(int index, String value) {
        String a1 = "abcde";
        assertThat(StringUtils.rotate(a1, index)).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void apache_StringUtils_Method12_IsWhiteSpace(String value) {
        assertThat(StringUtils.isWhitespace(value)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"abc,def,abcdef", "abc,d ef,abcd ef"})
    void apache_StringUtils_Method13_join(String value1, String value2, String expected) {
        assertThat(StringUtils.join(value1, value2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"abc,def,abc||def", "abc,d ef,abc||d ef"})
    @DisplayName("Joining Test With Delimiter")
    void apache_StringUtils_Method14_join(String value1, String value2, String expected) {
        assertThat(StringUtils.join(Arrays.asList(value1, value2), "||")).isEqualTo(expected);
    }

    @Test
    void apache_StringUtils_Method15_swapCase() {
        String testCase = "aBcDeF";
        assertThat(StringUtils.swapCase(testCase)).isEqualTo("AbCdEf");
    }

    @Test
    void apache_StringUtils_Method16_upperCase() {
        String testCase = "aBcDeF";
        assertThat(StringUtils.upperCase(testCase)).isEqualTo("ABCDEF");
    }

    @Test
    void apache_StringUtils_Method17_lowerCase() {
        String testCase = "aBcDeF";
        assertThat(StringUtils.lowerCase(testCase)).isEqualTo("abcdef");
    }

    @ParameterizedTest
    @CsvSource({"Cat, cat", "DOG, dOG", "A, a"})
    void apache_StringUtils_Method18_uncapitalize(String value, String expected) {
        assertThat(StringUtils.uncapitalize(value)).isEqualTo(expected);
    }

    @Test
    @DisplayName("truncate test, from idx 0 to maxWidth - 1")
    void apache_StringUtils_Method19_truncate() {
        String testCase = "abcdefghijklmnopqrstu";
        assertThat(StringUtils.truncate(testCase,10)).isEqualTo("abcdefghij");
    }

    @Test
    @DisplayName("truncate test, from idx 5 to maxWidth + 5 - 1")
    void apache_StringUtils_Method20_truncate() {
        String testCase = "abcdefghijklmnopqrstu";
        assertThat(StringUtils.truncate(testCase,5,10)).isEqualTo("fghijklmno");
    }

    @Test
    void apache_StringUtils_Method21_trimToEmpty() {
        String testCase = "  ";
        assertThat(StringUtils.trimToEmpty(testCase)).isEmpty();
    }
}
