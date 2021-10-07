package my.learning.test.basics;

import my.learning.test.pojos.Employee;

public class ObjectComparable {

	// Can we compare two different objects with equals method directly
	// if not why
	public static void compareObjects() {
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		
		// if equals method is overridden, the below equals method works as per logic 
		// if not, it will check against the references
		System.out.println(e1.equals(e2));
		
		
	}
	public static void main(String[] args) {
		ObjectComparable.compareObjects();

	}

}
