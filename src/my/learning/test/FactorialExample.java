package my.learning.test;

public class FactorialExample {

	public static void main(String[] args) {
		int num = 4;
		long factorialNumber = 1l;
		for(int i=1;i<=num;i++) {
			factorialNumber*=i;
		}
		System.out.println("Factorial number of " + num + " is " + factorialNumber);
	}
}
