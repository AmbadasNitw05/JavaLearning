package my.learning.array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AccountBalance {

	public int solution(int[] A, String[] D)  {
        int balance = 0;
        Map<Integer, Integer> mntNoCardPmts = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mntCardPmts = new HashMap<Integer, Integer>();
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        for(int i=0; i<A.length; i++) {
        	balance += A[i];
        	try {
				cal.setTime(sdf.parse(D[i]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
        	int month = cal.get(Calendar.MONTH);
        	if(A[i] < 0) {
        		if(mntNoCardPmts.containsKey(month)) {
            		mntNoCardPmts.put(month, mntNoCardPmts.get(month)+1);
            		mntCardPmts.put(month, mntCardPmts.get(month) + A[i]);
            	}else {
            		mntNoCardPmts.put(month, 1);
            		mntCardPmts.put(month, A[i]);
            	} 
        	}
        	       	
        }
        
        balance = balance - (5*12);
        for(Entry<Integer, Integer> entry: mntNoCardPmts.entrySet()) {
        	if(entry.getValue() >= 3 && mntCardPmts.get(entry.getKey()) <= -100) {
        		balance = balance + 5;
        	}
        }
		
        return balance;
    }
	
	
	public static void main(String[] args) {
		System.out.println(new AccountBalance().solution(new int[] {100, 100, -10, -20, -30}, 
				new String[] {"2020-12-23","2020-4-23","2020-4-23","2020-4-23", "2020-4-23"}));

	}

}
