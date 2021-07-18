package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("Given {0} and {1} WhenAdd ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 90",
            "-1, -2, -3",
            "0, 3, 3",
            Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ", -2",
            Integer.MAX_VALUE + ", 1, " + Integer.MIN_VALUE,
    })
    void addTest(int first, int second, int expectedResult) {
        int result = calculator.add(first, second);

        assertEquals(expectedResult, result, first + " + " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest
    @DisplayName("Given {0} and {1} WhenSubtract ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 10",
            "-1, -2, 1",
            "0, 3, -3",
            Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ", 0",
            Integer.MIN_VALUE + ", 1, " + Integer.MAX_VALUE,
    })
    void subtractTest(int first, int second, int expectedResult) {
        int result = calculator.subtract(first, second);

        assertEquals(expectedResult, result, first + " - " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest
    @DisplayName("Given {0} and {1} WhenMultiply ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 2000",
            "-1, -2, 2",
            "0, 3, 0",
            Integer.MAX_VALUE + ", 2, -2",
    })
    void multiplyTest(int first, int second, int expectedResult) {
        int result = calculator.multiply(first, second);

        assertEquals(expectedResult, result, first + " - " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "Given {0} and {1} WhenDivide ThenShouldReturn {2}")
    @CsvSource({
            "5, 2, 2.5",
            "-6, -3, 2",
            "10, 0, " + Double.POSITIVE_INFINITY,
            "-3, 0, " + Double.NEGATIVE_INFINITY,
    })
    void divideTest(int first, int second, double expectedResult) {
        double result = calculator.divide(first, second);

        assertEquals(expectedResult, result, first + " / " + second + " should return " + expectedResult);
    }
}




















