package my.learning.array;

public class BooleanArrayToDecimal {
	
	public static int getDecimalFromBooleanArray(boolean[] booleanArr) {
		int decimalNum = 0;
		int len = booleanArr.length;
		
		for(int i=0;i<len;i++) {
			if(booleanArr[i]) {
				decimalNum += Math.pow(2,len-1-i);
			}
		}
		
		return decimalNum;
		
	}

	public static void main(String[] args) {
		System.out.println(BooleanArrayToDecimal.getDecimalFromBooleanArray(new boolean[] {true, true, true, true}));
	}

}
