package my.learning.hackerrank;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class BigDecimalExample {

	public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

      	String[] s2 = Arrays.copyOfRange(s, 0, n);
        Arrays.sort(s2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				BigDecimal bd1 = new BigDecimal(o1);
				BigDecimal bd2 = new BigDecimal(o2);
				
				return bd2.compareTo(bd1);
			}
		});
        s = s2;

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
