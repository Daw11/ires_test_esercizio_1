package it.euris.ires;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void givenMultiplyWhenAIs2AndBIs3ThenReturn6() {
        // arrange
        int numberA = 2;
        int numberB = 3;
        int expectedResult = 6;

        // act
        int result = calculator.multiply(numberA, numberB);

        // assert
        assertEquals( expectedResult, result, "2 * 3 should equal 6" );
    }

    @Test
    void givenDivideWhenAIs5AndBIs2ThenReturn2_5() {
        // arrange
        int numberA = 5;
        int numberB = 2;
        double expectedResult = 2.5;

        // act
        double result = calculator.divide(numberA, numberB);

        // assert
        assertNotEquals( 0, numberB, "B shouldn't be 0" );
        assertEquals( expectedResult, result, "5 / 2 should equal 2.5" );
    }
}
