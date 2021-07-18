package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CalculatorTest {

    private Calculator calculator;

    @Mock
    private IUser user;

    @Captor
    private ArgumentCaptor<Number> argCaptor;

    @BeforeEach
    void setUp() {
        calculator = new Calculator( user );
    }

    @ParameterizedTest(name = "Given {0} and {1} WhenAdd ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 90",
            "-1, -2, -3",
            "0, 3, 3",
            Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ", -2",
            Integer.MAX_VALUE + ", 1, " + Integer.MIN_VALUE,
    })
    void addTest(int first, int second, int expectedResult) {
        calculator.add(first, second);

        Mockito.verify( user ).getValue( argCaptor.capture() );
        assertEquals( expectedResult, argCaptor.getValue(),first + " + " + second + " should equal " + expectedResult  );
    }

    @ParameterizedTest(name = "Given {0} and {1} WhenSubtract ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 10",
            "-1, -2, 1",
            "0, 3, -3",
            Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ", 0",
            Integer.MIN_VALUE + ", 1, " + Integer.MAX_VALUE,
    })
    void subtractTest(int first, int second, int expectedResult) {
        calculator.subtract(first, second);

        Mockito.verify( user ).getValue( argCaptor.capture() );
        assertEquals(expectedResult, argCaptor.getValue(), first + " - " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "Given {0} and {1} WhenMultiply ThenShouldReturn {2}")
    @CsvSource({
            "50, 40, 2000",
            "-1, -2, 2",
            "0, 3, 0",
            Integer.MAX_VALUE + ", 2, -2",
    })
    void multiplyTest(int first, int second, int expectedResult) {
        calculator.multiply(first, second);

        Mockito.verify( user ).getValue( argCaptor.capture() );
        assertEquals(expectedResult, argCaptor.getValue(), first + " - " + second + " should equal " + expectedResult);
    }

    @ParameterizedTest(name = "Given {0} and {1} WhenDivide ThenShouldReturn {2}")
    @CsvSource({
            "5, 2, 2.5",
            "-6, -3, 2",
            "10, 0, " + Double.POSITIVE_INFINITY,
            "-3, 0, " + Double.NEGATIVE_INFINITY,
    })
    void divideTest(int first, int second, double expectedResult) {
        calculator.divide(first, second);

        Mockito.verify( user ).getValue( argCaptor.capture() );
        assertEquals(expectedResult, argCaptor.getValue(), first + " / " + second + " should return " + expectedResult);
    }
}




















