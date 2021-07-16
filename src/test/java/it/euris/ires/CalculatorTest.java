package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    private static Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("1 + 2 = 3")
    void addsTwoNumbers() {
        // arrange
        int numberA = 1;
        int numberB = 2;
        int expectedResult = 3;
        // act
        int result = calculator.add(numberA, numberB);
        // assert
        assertEquals( expectedResult, result, "1 + 2 should equal 3" );
    }

    @Test
    @DisplayName("3 - 1 = 2")
    void subtractTwoNumbers(){
        // arrange
        int numberA = 3;
        int numberB = 1;
        int expectedResult = 2;
        // act
        int result = calculator.subtract(numberA, numberB);
        // assert
        assertEquals( expectedResult, result, "3 - 1 should equal 2" );
    }

    @Test
    void given2And3WhenMultiplyThenReturn6() {
        // arrange
        int numberA = 2;
        int numberB = 3;
        int expectedResult = 6;
        // act
        int result = calculator.multiply(numberA, numberB);
        // assert
        assertEquals( expectedResult, result, "2 * 3 should equal 6" );
    }

    @ParameterizedTest(name ="given {0} and {1} WhenDivide ThenReturn {2}")
    @CsvSource({
            "5, 2, 2.5",
            "-6, -3, 2",
            "10, 0, " + Double.POSITIVE_INFINITY,
            "-3, 0, " + Double.NEGATIVE_INFINITY
    })
    void divideWithBvaValues( int a, int b, double expectedResult ) {
        // act
        double result = calculator.divide(a, b);
        // assert
        assertEquals( expectedResult, result, a + " / " + b + " should return " + expectedResult );
    }

    @ParameterizedTest(name = "GivenFirstArgument {0} AndSecondArgument {1} WhenAddThenShouldReturn {2}")
    @CsvSource({
            "0, 1, 1",
            "0, -1, -1",
            "-50, 50, 0",
            Integer.MAX_VALUE + ", " + Integer.MAX_VALUE + ", -2"
    })
    void addWithBvaValues(int first, int second, int expectedResult){
        assertEquals(expectedResult, calculator.add(first,second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }
}




















