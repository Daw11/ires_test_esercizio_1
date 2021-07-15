package it.euris.ires;

import java.util.Arrays;
import java.util.List;

public class Calculator {

	public int add(int a, int b) {
		return a + b;
	}
	public int subtract(int a, int b){ return a - b; }
	public int multiply(int a, int b){ return a * b; }
	public double divide(int a, int b){ return (double) a/ (double) b; }
}

class CalculatorTest {
	private static Calculator calculator;

	public static void main(String[] args) throws Exception {
		calculator = new Calculator();

		List<Integer> a = Arrays.asList(1, 2, 3, -1, -2, -3);
		List<Integer> b = Arrays.asList(100, 3, -50, -10, 6, -2);
		if( a.size() != b.size() )
			throw new Exception("Array a and array b aren't the same size.");

		for( int i = 0; i < a.size(); i++ )
			test( a.get(i), b.get(i), a.get(i) + b.get(i) );

		test(999999999, 999999999, 999999999 + 999999999);
		test(-999999999, -999999999, -999999999 - 999999999);

		System.out.println("Test completed without errors.");
	}

	private static void test( int a, int b, int c ) throws Exception {
		if(calculator.add(a, b) != c )
			throw new Exception("Test failure");
	}
}
