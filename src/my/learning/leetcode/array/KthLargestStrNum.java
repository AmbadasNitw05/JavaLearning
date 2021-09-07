package my.learning.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

public class KthLargestStrNum {

	public String kthLargestNumber(String[] nums, int k) {
		Arrays.sort(nums, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return sort(o2, o1);
			}
		});
		
		return nums[k-1];
    }
	
	private int sort(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();
		
		if(len1 > len2) return 1;
		else if(len1 < len2) return -1;
		else return s1.compareTo(s2);
	}

	public static void main(String[] args) {
		System.out.println(new KthLargestStrNum().kthLargestNumber(new String[] {"623986800","3","887298","695","794","6888794705","269409","59930972","723091307","726368","8028385786","378585"}, 11));

	}

}
