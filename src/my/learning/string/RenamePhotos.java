package my.learning.string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class RenamePhotos {
	
	class Photo{
		int seq;		
		String name;
		String extn;
		String number;
		String city;
		Date date;
		
		public Photo(int seq, String name, String extn, String number, String city, Date date) {
			this.seq = seq;
			this.name = name;
			this.extn = extn;
			this.number = number;
			this.city = city;
			this.date = date;
		}	
		
		public String getFileName() {
			return city+number+"."+extn;
		}
		
	}
	
	 public String solution(String S) {
		 
		 Map<String, List<Photo>> map = new HashMap<String, List<Photo>>();
		 
		 String[] data = S.split(System.lineSeparator());
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 
		 
		 
		 int i=1;
		 for(String line: data) {
			 String[] record = line.split(", ");
			 String[] nameExtn = record[0].split("\\.");
			 String city = record[1];
			 
			 Calendar cal = Calendar.getInstance();
			 try {
				cal.setTime(sdf.parse(record[2]));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			 
			 Photo photo = new Photo(i, nameExtn[0], nameExtn[1], "", city, cal.getTime());
			 			 
			 if(!map.containsKey(city)) {
				 map.put(city, new ArrayList<RenamePhotos.Photo>());				 
			 }
			 map.get(city).add(photo);
			 
			 i++;
			 
		 }
		 
		 List<Photo> list = new ArrayList<>();
		 for(Entry<String, List<Photo>> entry: map.entrySet()) {
			 List<Photo> cityPhotos = entry.getValue();
			 Collections.sort(cityPhotos, new Comparator<Photo>() {

				@Override
				public int compare(Photo o1, Photo o2) {
					return o1.date.compareTo(o2.date);
				}
				 
			});
			 
			 int size = cityPhotos.size();
			 for(int j=0;j<size;j++) {
				 cityPhotos.get(j).number = getStrNumLeadingZeroes(j+1, size);
			 }
			 
			 list.addAll(cityPhotos);
		 }
		 
		 
		 Collections.sort(list, new Comparator<Photo>() {

			@Override
			public int compare(Photo o1, Photo o2) {
				return o1.seq - o2.seq;
			}
		});
		 
		 StringBuilder sb = new StringBuilder();
		 for(Photo p: list) {
			 sb.append(p.getFileName()).append(System.lineSeparator());
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
		
		RenamePhotos obj = new RenamePhotos();
		System.out.println(obj.solution(str));
		

	}

}
