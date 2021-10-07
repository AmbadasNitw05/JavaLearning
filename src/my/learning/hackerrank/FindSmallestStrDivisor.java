package my.learning.hackerrank;

public class FindSmallestStrDivisor {

	/*
     * Complete the 'findSmallestDivisor' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */
	
	public static int findSmallestDivisor(String s, String t) {
		
		String clearedFromSubstrs = s.replaceAll(t, "");
		if(clearedFromSubstrs.length() == 0) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<(t.length()/2); i++) {
				sb.append(t.charAt(i));
				
				clearedFromSubstrs = t.replaceAll(sb.toString(), "");
				if(clearedFromSubstrs.length() == 0) {
					return sb.length();
				}
			}
			return t.length();
		}
		
		return -1;
	}
	
	public static int findSmallestDivisor1(String s, String t) {
		int len2 = t.length();
        if(isDivisible1(s, t)) {
        	for(int i=1; i<=(len2/2); i++) {
        		if(isDivisible1(t, t.substring(0, i))) {
        			return i;
        		}
        	}
        	return len2;
        }
        return -1;
	}
	
	private static boolean isDivisible1(String s, String t) {
		int len1 = s.length(), len2 = t.length();
        if(len1 % len2 != 0) return false;
		StringBuilder sb = new StringBuilder();
		int times = len1 / len2;
		for(int i=0; i<times; i++) {
			sb.append(t);
			
		}
		return s.equals(sb.toString());
	}
	
	
	public static int findSmallestDivisor2(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 % len2 != 0) return -1;
        
        if(isDivisible(s, "", t)) {
            for(int i=1; i<=(len2/2); i++) {
                if(isDivisible(t, "", t.substring(0, i))) {
                    return i;
                }
            }
            return len2;
        }
        
        return -1;

    }
    
    private static boolean isDivisible(String s, String cur, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len2 != 0 && len1 % len2 != 0) return false;
        if(cur.length() > len1) return false;
        if(s.equals(cur)) return true; 
        return isDivisible(s, cur.concat(t), t);
    }
    
	public static void main(String[] args) {
		String s = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<4000; i++) {
			sb.append(s);
		}
		
		System.out.println(findSmallestDivisor(sb.toString(), s));

	}

}
