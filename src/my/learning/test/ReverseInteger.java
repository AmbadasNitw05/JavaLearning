package my.learning.test;

public class ReverseInteger {
	
	// Best solution
	public static int reverse(int x) {
		if(x == 0) return 0;
		
		long reverse = 0;
		
		while(x != 0) {
			reverse = reverse * 10 + x % 10;
			x = x / 10;
		}
		
		if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) {
			return 0;
		}
		
		return (int)reverse;
	}

	// Worst solution
	public static int reverse2(int x) {
		
		String strNum = Integer.toString(x);
        StringBuilder sbRevStrNum = new StringBuilder();
        char sign = '+';
        for(int i=strNum.length()-1;i>=0;i--) {
        	if(i == 0 && strNum.charAt(i) == '-') {
        		sign = '-';
        	}else {
        		sbRevStrNum.append(strNum.charAt(i));
        	}        	
        }
        
        if(sign == '-') {
        	sbRevStrNum.insert(0, '-');
        }
        System.out.println("rev str: " + sbRevStrNum.toString());
        
        try {
        	return Integer.parseInt(sbRevStrNum.toString());
        }catch(Exception e) {
        	return 0;
        }
        
        
    }
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println(ReverseInteger.reverse(-2147483648));
	}

}
