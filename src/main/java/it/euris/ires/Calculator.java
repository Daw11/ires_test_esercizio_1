package it.euris.ires;

public class Calculator {
	private IUser user;

	public Calculator(IUser user) {
		this.user = user;
	}

	public void add(int a, int b) {
		user.getValue( a + b );
	}

	public void subtract(int a, int b){
		user.getValue( a - b );
	}

	public void multiply(int a, int b) {
		user.getValue(a * b);
	}

	public void divide(int a, int b){
		user.getValue ( (double) a / b );
	}
}

interface IUser {
	void getValue( Number value );
}

class User implements IUser {
	private double _result = 0;

	public void printResult(){
		System.out.println( _result );
	}

	@Override
	public void getValue(Number value) {
		_result = value.doubleValue();
	}
}
