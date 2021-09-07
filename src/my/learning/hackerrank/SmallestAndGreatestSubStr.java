package my.learning.hackerrank;

public class SmallestAndGreatestSubStr {

	public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        int len = s.length();
        if(len >= k){
            int start = 0, end = len-k;
            while(start <= end && start+k <= len){
                String left = s.substring(start, start + k);
                String right = s.substring(end, end+k);
                if(left.compareTo(right) < 0) {
                	if(largest == "" || largest.compareTo(right) < 0) largest = right;
                	if(smallest == "" || smallest.compareTo(left) > 0) smallest = left;
                }else {
                	if(largest == "" || largest.compareTo(left) < 0) largest = left;
                	if(smallest == "" || smallest.compareTo(right) > 0) smallest = right;
                }
                start++;
                end--;
            }
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }
	
	public static void main(String[] args) {
		System.out.println(SmallestAndGreatestSubStr.getSmallestAndLargest("welcometojava", 3));

	}

}
