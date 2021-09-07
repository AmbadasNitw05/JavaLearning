package my.learning.leetcode.bits;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

	public List<String> readBinaryWatch(int t) {
        List<Integer>[] al=new ArrayList[6];
        for(int i=0;i<6;i++){
            al[i]= new ArrayList<>();
        }
        
        for(int i=0;i<60;i++){
            int c=countone(i);
           
            al[c].add(i);
        }
        List<String> ans=new ArrayList();
        for(int j=0;j<=t;j++){
            int h=j;
            int m=t-j;
            if(h<4 && m<6){
            for(int hr:al[h]){
                if(hr<=11 ){
                    StringBuffer sb=new StringBuffer();
                    
                    for(int min:al[m]){
                        if(min<=9){
                            sb.append(hr);
                           sb.append(":0");
                            sb.append(min);
                        }else{
                            sb.append(hr);
                          sb.append(":");
                            sb.append(min);  
                        }
                        ans.add(sb.toString());
                        sb=new StringBuffer();
                    }
                }
            }}
            
        }
        return ans;
    }
    public int countone(int a){
        int count=0;
        for(int i=0;i<7;i++){
          count+=  a&1;
            a>>=1;
        }
        return count;
    }
    
	public static void main(String[] args) {
		BinaryWatch obj = new BinaryWatch();
		System.out.println(obj.countone(0));

	}

}
