package my.learning.string;

import java.util.Arrays;

public class LargetNoOfWords {

	public int solution(String S) {
        
		String[] sents = S.split("\\?|\\.|\\!");
		
		int maxWords = 0;
		for(String sent: sents) {
			String[] words = sent.trim().split(" +");
			if(words.length > maxWords) {
				maxWords = words.length;
			}
			
		}
		
		return maxWords;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new LargetNoOfWords().solution("Forget?? ? .    !  CVs..Save nice time! . x x"));

	}

}
