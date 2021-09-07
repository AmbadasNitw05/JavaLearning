package my.learning.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RenamePhotos2 {

	public String solution(String S) {
		
		Map<String, List<String>> citiesMap = new HashMap<String, List<String>>();
		String[] lines = S.split(System.lineSeparator());
		
		String city = "";
		for(String line: lines) {
			 city = line.split(", ")[1];
			if(!citiesMap.containsKey(city)) {
				citiesMap.put(city, new ArrayList<String>());
			}
			citiesMap.get(city).add(line);
		}
		
		Map<String, String> fNames = new HashMap<String, String>();
		List<String> lList = null;
		String fName = null;
		String extn = null;
		int size = 0;
		for(Entry<String, List<String>> entry: citiesMap.entrySet()) {
			city = entry.getKey();
			lList = entry.getValue();
			
			// sort lList by last field date 
			Collections.sort(lList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					return o1.split(", ")[2].compareTo(o2.split(", ")[2]);
				}
				
			});
			
			size = lList.size();
			for(int i=0; i<size; i++) {
				extn = lList.get(i).split(", ")[0].split("\\.")[1];
				fName = city + getStrNumLeadingZeroes(i+1, size) + "." + extn;
				fNames.put(lList.get(i), fName);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(String line: lines) {
			sb.append(fNames.get(line)).append(System.lineSeparator());
		}
		
		return sb.toString();
	}
	
	private String getStrNumLeadingZeroes(int num, int total) {
		 int len = String.valueOf(total).length();		 
		 return String.format("%0"+len+"d", num);		 
	 }
	
	public static void main(String[] args) {
		String str = "photo.jpg, Warsaw, 2013-09-05 14:08:15\r\n" + 
				"john.png, London, 2015-06-20 15:13:22\r\n" + 
				"myFriends.png, Warsaw, 2013-09-05 14:07:13\r\n" + 
				"Eiffel.jpg, Paris, 2015-07-23 08:03:02\r\n" + 
				"pisatower.jpg, Paris, 2015-07-22 23:59:59\r\n" + 
				"BOB.jpg, London, 2015-08-05 00:02:03\r\n" + 
				"notredame.png, Paris, 2015-09-01 12:00:00\r\n" + 
				"me.jpg, Warsaw, 2013-09-06 15:40:22\r\n" + 
				"a.png, Warsaw, 2016-02-13 13:33:50\r\n" + 
				"b.jpg, Warsaw, 2016-01-02 15:12:22\r\n" + 
				"c.jpg, Warsaw, 2016-01-02 14:34:30\r\n" + 
				"d.jpg, Warsaw, 2016-01-02 15:15:01\r\n" + 
				"e.png, Warsaw, 2016-01-02 09:49:09\r\n" + 
				"f.png, Warsaw, 2016-01-02 10:55:32\r\n" + 
				"g.jpg, Warsaw, 2016-02-29 22:13:11";
		
		RenamePhotos2 obj = new RenamePhotos2();
		System.out.println(obj.solution(str));
		

	}

}
