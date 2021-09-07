package my.learning.test;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs) {
        
		String prevCommPrefix = strs[0];
		if(prevCommPrefix.length() == 0) return "";
		
		for(int i=1;i<strs.length;i++) {
			prevCommPrefix = getCommonPrefix(strs[i], prevCommPrefix);			
			if(prevCommPrefix.length() == 0) return "";
		}
		
		return prevCommPrefix;
    }
	
	private String getCommonPrefix(String str1, String str2) {
		int len = str1.length() > str2.length() ? str2.length() : str1.length();
		int i=0;
		while(i<len) {
			if(str1.charAt(i) != str2.charAt(i)) break;
			i++;
		}
		if(i==0) return "";
		else return str1.substring(0, i);
		
	}
	
	public static void main(String args[]) {
		System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[] {"flower","flow","flight"}));
	}
}
