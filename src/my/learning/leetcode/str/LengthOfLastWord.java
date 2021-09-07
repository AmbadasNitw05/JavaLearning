package my.learning.leetcode.str;

public class LengthOfLastWord {

	// time efficient
	public int lengthOfLastWord(String s) {
		int count = 0;
		for(int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i); 
			if(count == 0 && c != ' ') {
				count = 1;
			}else if(count != 0 && c != ' ') count++;
            else if(count != 0 && c == ' ') break;
					
		}
		
		return count;
	}
	
	// simple solution but time inefficient because of split method
	public int lengthOfLastWord1(String s) {
        String[] words = s.split(" +");
        
        return words[words.length-1].length();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	// another simple solution and time efficient too
	public int lengthOfLastWord2(String s) {
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
    }

}
