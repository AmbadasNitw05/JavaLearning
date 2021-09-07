package my.learning.test;

public class MagicNumberExample {

	// Step 1: 163 => 1+6+3 = 10
	// Step 2: 10 => 1+0 = 1 => Hence 163 is a magic number
	public static void main(String[] args) {
		int num = 163;
		
		// First logic 
		System.out.println(MagicNumberExample.getSumOfDigits(num));
		System.out.println(MagicNumberExample.isMagicNumber(num));
		
		// Second logic
		int sumOfDigits = 0;
		
		while(num > 0 || sumOfDigits > 9) {
			if(num == 0) {
				num = sumOfDigits;
				sumOfDigits = 0;
			}
			sumOfDigits+= num%10;
			num/= 10;
		}
		
		if(sumOfDigits == 1) {
			System.out.println("Magic Number");
		}else {
			System.out.println("Not a Magic Number");
		}
	}
	
	public static boolean isMagicNumber(int num) {
		
		while(num>=10) {
			num = getSumOfDigits(num); 
		}
		if(num == 1) return true;
		return false;
	}
	
	public static int getSumOfDigits(int num) {
		if(num<10)
			return num;
		
		int sumOfDigits = 0;
		
		do {
			sumOfDigits+= num % 10;
			num = num / 10;
		}while(num>=10);
		
		return sumOfDigits+num;
	}

}
