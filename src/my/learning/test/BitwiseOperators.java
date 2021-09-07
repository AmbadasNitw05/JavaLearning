package my.learning.test;

public class BitwiseOperators {

	public static void main(String[] args) {
		// Initial values
        int a = 5;
        int b = 7;
 
        // bitwise and
        // 0101 & 0111=0101 = 5
        System.out.println("a&b = " + (a & b));
 
        // bitwise or
        // 0101 | 0111=0111 = 7
        System.out.println("a|b = " + (a | b));
 
        // bitwise xor
        // 0101 ^ 0111=0010 = 2
        System.out.println("a^b = " + (a ^ b));
 
        // bitwise not
        // ~0101=1010
        // will give 2's complement of 1010 = -6
        System.out.println("~a = " + ~a);
        
        // left shift = number mulitplied by 2
        // << - signed left shift operator, >> - signed right shift operator
        // <<< - unsigned left shift operator, >>> - unsigned right shift operator
        a = -4;
        a = a << 1;
        System.out.println("a<<2: " + a);
 
        // can also be combined with
        // assignment operator to provide shorthand
        // assignment
        // a=a&b
        a &= b;
        System.out.println("a= " + a);

	}

}
