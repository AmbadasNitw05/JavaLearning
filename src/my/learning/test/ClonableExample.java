package my.learning.test;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public @Data class ClonableExample implements Cloneable{

	private String name;
	private int age;
	
	
	/*
	 * public ClonableExample clone() throws CloneNotSupportedException { return
	 * (ClonableExample) super.clone(); }
	 */
	 
	
	public static void main(String[] args) {
		ClonableExample obj = new ClonableExample("Ambadas", 36);
		System.out.println(obj);
		try {
			ClonableExample obj2 = (ClonableExample) obj.clone();
			obj2.setAge(37);
			System.out.println(obj2);
			System.out.println(obj.hashCode());
			System.out.println(obj2.hashCode());
			System.out.println(obj2.equals(obj));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
