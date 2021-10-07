package my.learning.leetcode.str;

import java.math.BigInteger;

public class AddBinary {

	public String addBinary(String a, String b) {  
		int i=a.length()-1, j=b.length()-1, carry=0;
		StringBuilder sb = new StringBuilder();
		while(i>=0 || j>=0) {
			int sum = carry;
			if(i>=0) sum += a.charAt(i--) - '0'; // subtracts '0' to avoid ASCII value
			if(j>=0) sum += b.charAt(j--) - '0'; // Character.getNumericValue(a.charAt(j--)); -- alternative
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0) sb.append(carry);
		return sb.reverse().toString();		
    }
	
	// Accepted but slow in performance
	public String addBinary1(String a, String b) {  
		BigInteger bi1 = new BigInteger(a, 2);
		BigInteger bi2 = new BigInteger(b, 2);
		
		BigInteger sum = bi1.add(bi2);
		
		return sum.toString(2);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
