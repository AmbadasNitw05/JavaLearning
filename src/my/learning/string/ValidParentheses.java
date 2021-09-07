package my.learning.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public boolean isValid(String s) {
		if(s.length() % 2 == 1) return false;
		
		Stack<Character> stack = new Stack<Character>();
		for(char c: s.toCharArray()) {
			if(c == '(')
				stack.push(')');
			else if(c == '[')
				stack.push(']');
			else if(c == '{')
				stack.push('}');
			else if(stack.isEmpty() || c != stack.pop())
				return false;
		}
		
		return stack.isEmpty();
	}
	public boolean isValid2(String s) {
		int len = s.length();
        if(len % 2 == 1) return false;
        
        Map<Character, Character> cMap = new HashMap<Character, Character>();
        cMap.put('(',')');
        cMap.put('{','}');
        cMap.put('[',']');
        
        Stack<Character> stack = new Stack<Character>();
        
        Character c = null;
        Character popC = null;
        for(int i=0; i<len; i++) {
        	c=s.charAt(i);
        	if(cMap.containsKey(c))
        		stack.push(cMap.get(c));
        	else {
        		if(stack.isEmpty()) return false;
        		popC = stack.pop();
        		if(!c.equals(popC)) {
        			return false;
        		}
        	}
        }
        
        return stack.isEmpty() ? true : false;
        
    }

	public static void main(String[] args) {
		System.out.println(new ValidParentheses().isValid("{()}[]"));
	}

}
