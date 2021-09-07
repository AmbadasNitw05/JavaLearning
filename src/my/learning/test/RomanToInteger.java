package my.learning.test;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	
	// Optimized solution
	public static int romanToInt(String s) {
		
		int len = s.length();
		int prev = Integer.MAX_VALUE;
		int val = 0;
		int result = 0;
		for(int i=0; i<len; i++) {
			val = getValue(s.charAt(i));
			if(val > prev) {
				result = result - (prev << 1);
			}
			result = result + val;
			prev = val;
		}
		
		return result;
	}

	// Ordinary solution
	public static int romanToInt2(String s) {
		Map<Character, Integer> romanValues = new HashMap<Character, Integer>();
		romanValues.put('I', 1);
		romanValues.put('V', 5);
		romanValues.put('X', 10);
		romanValues.put('L', 50);
		romanValues.put('C', 100);
		romanValues.put('D', 500);
		romanValues.put('M', 1000);
		
		System.out.println(100 << 1);
		
		int i=0;
		int num = 0;
		while(i<s.length()) {
			if(i<(s.length()-1) && (romanValues.get(s.charAt(i)) < romanValues.get(s.charAt(i+1)))){
				num = num - romanValues.get(s.charAt(i));
			}else {
				num = num + romanValues.get(s.charAt(i));
			}
			i++;
		}
		
		return num;
	}
	
	private static int getValue(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }
	
	public static void main(String[] args) {
		System.out.println(RomanToInteger.romanToInt("III"));
	}
}
