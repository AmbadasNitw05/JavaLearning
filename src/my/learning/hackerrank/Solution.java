package my.learning.hackerrank;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		
		/*
		 * Scanner scan = new Scanner(System.in); int i = scan.nextInt(); double d =
		 * scan.nextDouble(); scan.nextLine(); String s = scan.nextLine();
		 * 
		 * scan.close();
		 * 
		 * // Write your code here.
		 * 
		 * System.out.println("String: " + s); System.out.println("Double: " + d);
		 * System.out.println("Int: " + i);
		 * 
		 * System.out.printf("%-15s %03d%n","Java", 62);
		 */
		
		/*
		 * Currency cur = Currency.getInstance(Locale.CHINA); Locale india = new
		 * Locale("en", "IN");
		 * 
		 * System.out.println("hello");
		 * 
		 * System.out.println(NumberFormat.getCurrencyInstance(india).format(2456.35));
		 */
		
		Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        System.out.println(B.compareTo(A) > 0 ? "Yes" : "No");
        System.out.println(A.substring(0,1).toUpperCase() + A.substring(1) + " "
        	+ B.substring(0,1).toUpperCase() + B.substring(1));
       
	}
}
