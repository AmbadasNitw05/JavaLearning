package my.learning.number;

public class ArmstrongNumber {
	
	public boolean isArmstrongNumber(int num) {
		int len = (int)Math.log10(num)+1;
		int tempNum = num;
		int sum = 0;
		while(num > 0) {
			sum += Math.pow(num % 10, len);
			num = num / 10;
		}
		return sum == tempNum;
	}

	public static void main(String[] args) {
		ArmstrongNumber an = new ArmstrongNumber();
		System.out.println(an.isArmstrongNumber(1634));
	}

}
