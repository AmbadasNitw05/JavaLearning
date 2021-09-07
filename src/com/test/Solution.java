package com.test;

import java.util.Stack;

public class Solution {
	
	public void rpnCalculator(String str) {
				
		String[] elements = str.split(" ");
		
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		for(String element: elements) {
			if(element.equals("*") || element.equals("+")) {
				if(!stack.isEmpty()) {
					int element1 = stack.pop();
					int element2 = stack.pop();
					
					if(element.equals("*")) {
						result = element1 * element2;
					}else {
						result = element1 + element2;
					}
				}
				
				stack.push(result);
			}else {
				stack.push(Integer.parseInt(element));
			}
		}
		
		System.out.println(stack.peek());
	}

	public static void main(String[] args) {
		new Solution().rpnCalculator("1 2 3 * +"); // should return 7

		new Solution().rpnCalculator("1 2 3 * +"); // 7
		new Solution().rpnCalculator("1156 12 11 * +"); // 1288
		new Solution().rpnCalculator("5 2 + 3 *"); // 21
		new Solution().rpnCalculator("5 2 * 2 * 4 +"); // 24
		new Solution().rpnCalculator("5 2 + 2 + 4 +"); // 13
		new Solution().rpnCalculator("3 2 + 2 4 + *"); // 30
		new Solution().rpnCalculator("3 2 2 4 + + *"); // 24
		new Solution().rpnCalculator("5"); // 5
		new Solution().rpnCalculator("0 1 *"); // 0
		new Solution().rpnCalculator("5 5 + 6 6 + 1 1 + * +"); // "10 12 2 * +" => 34

	}

}
