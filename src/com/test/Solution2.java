package com.test;

public class Solution2 {

	public static void possibleBalance(String str, int target) {
		int len = str.length();
		
		int plusCnt = 0;
		int minusCnt = 0;	
		
		
		for(int i=0; i<len; i++) {
			if(str.charAt(i) == '+')
				plusCnt++;
			else
				minusCnt++;			
		}
		
		int balance = plusCnt - minusCnt;
		int result = 0;
		if(balance >= target) {
			System.out.println(result);
			return;
		}else {
			for(int i = len-1; i>=0; i--) {
				if(str.charAt(i) == '+') {
					plusCnt--;
				}else
					minusCnt--;
				result++;
				balance = plusCnt - minusCnt;
				if(balance >= target) {
					System.out.println(result);
					return;
				}
				
			}
		}
		
		System.out.println(-1);
		
	}
	
	public static void main(String[] args) {
		Solution2.possibleBalance("++-", 2); // should return 1

		Solution2.possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 12); // 1
		Solution2.possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 13); // 2
		Solution2.possibleBalance("+++-++-++--+-++++-+--++-++-+-++++-+++--", 14); // -1
		Solution2.possibleBalance("+++---", 3); // 3
		Solution2.possibleBalance("+++-+---", 3); // 3
		Solution2.possibleBalance("----+-", -2); // 4

	}

}
