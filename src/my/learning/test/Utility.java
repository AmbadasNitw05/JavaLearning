package my.learning.test;

public class Utility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("is 7 even: " + isEvenUsingBitwiseOperator(7));
	}

	public static boolean isEvenUsingBitwiseOperator(int number) {
		return (number & 1) == 0;
	}
}
