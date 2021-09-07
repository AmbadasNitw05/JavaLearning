package my.learning.test;

public class Solution2 {

	// Time complexity average: 0(ab+ac) worst: 0(n*n)  - space complexity: 0(1)
	public int solution(String S, int[] C) {
		if(S.length() == 1) {
			return 0;
		}
		int i=0;
		int cost = 0;
		while(i<S.length()-1) {
			if(S.charAt(i) == S.charAt(i+1)) {
				int j = i;
				int maxCostIndex = j;
				while(j<C.length-1 && S.charAt(j) == S.charAt(j+1)) {
					if(C[maxCostIndex] < C[j+1]) {
						maxCostIndex = j+1;
					}
					j++;
				}
				for(int k=i;k<j;k++) {
					if(k != maxCostIndex) {
						cost+=C[k];
					}
					i++;
				}
				
			}else {
				i++;
			}
			
		}
		return cost;
    }
	
	public static void main(String[] args) {
		System.out.println(new Solution2().solution("a",new int[] {3}));
		System.out.println(new Solution2().solution("aa",new int[] {1,3}));
		System.out.println(new Solution2().solution("aaaaa",new int[] {1,2,3,4,5}));
		System.out.println(new Solution2().solution("aabbcc",new int[] {1,3,1,3,1,3}));
		System.out.println(new Solution2().solution("ababab",new int[] {1,3,1,3,1,3}));
	}
}
