package my.learning.leetcode;

public class NumberOfStrings {

	public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(String pattern: patterns){
            if(word.indexOf(pattern) >= 0){
                count++;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
