package my.learning.leetcode.str;

import java.util.HashMap;
import java.util.Map;

public class HTMLEntityParser {

	// Copied solution - simple - 40ms 40.4 MB
	public String entityParser(String text) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("&quot;","\"");
		// map.put("&amp;","&"); // do it at last
		map.put("&apos;","'");
		map.put("&gt;",">");
		map.put("&lt;","<");
		map.put("&frasl;","/");
		
		for(String key: map.keySet()) {
			text = text.replaceAll(key, map.get(key));
		}
		
		return text.replaceAll("&amp;", "&");
	}
	// Worst own solution 77ms 76.6 MB 
	public String entityParser2(String text) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("&quot;","\"");
		map.put("&amp;","&");
		map.put("&apos;","'");
		map.put("&gt;",">");
		map.put("&lt;","<");
		map.put("&frasl;","/");
		
		StringBuilder sb = new StringBuilder();
		int i = 0, len = text.length();
        while(i<len) {
        	char ch = text.charAt(i);
        	if(ch != '&') {
        		sb.append(ch); i++; continue;
        	}
        	
        	StringBuilder entity = new StringBuilder(Character.toString(ch));
        	do {      
        		i++; 
        		if(i>=len) break;
        		ch = text.charAt(i);
        		if(ch == '&') {
        			sb.append(entity.toString());
        			entity = new StringBuilder(Character.toString(ch));
        			i++; 
            		if(i>=len) break;
        			ch = text.charAt(i);
        		}
        		entity.append(ch);
        	}while(ch != ';' && i < len);
        	
        	i++;
        	if(map.containsKey(entity.toString()))
        		sb.append(map.get(entity.toString()));
        	else
        		sb.append(entity.toString());
        	
        	
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		System.out.println(new HTMLEntityParser().entityParser("&&gt;"));

	}

}
