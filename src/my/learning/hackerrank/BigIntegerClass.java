package my.learning.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerClass {

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		Scanner scanner = new Scanner(System.in);
		
		BigInteger bi1 = scanner.nextBigInteger();
		BigInteger bi2 = scanner.nextBigInteger();
		
		scanner.close();
		
		System.out.println(bi1.add(bi2));
		System.out.println(bi1.multiply(bi2));

	}

}
