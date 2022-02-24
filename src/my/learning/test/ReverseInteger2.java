package my.learning.test;

public class ReverseInteger2 {

	public int reverse(int n) {
		int reverse = 0;
		while(n > 0) {
			reverse = reverse * 10 + n%10;
			n = n/10;
		}
		
		return reverse;
	}
	public static void main(String[] args) {
		ReverseInteger2 ri2 = new ReverseInteger2();
		System.out.println(ri2.reverse(1234));
	}

}
