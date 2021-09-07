package my.learning.test;

public class StringLiteralAndObjectCompare {

	public static void main(String[] args) {
		String literal1 = "Ambadas"; // Stores in string constant pool
		String literal2 = "Ambadas"; // points to same literal1 by sharing in string constant pool
		
		String obj1 = new String("Ambadas"); // Creates one object in heap memory
		String obj2 = new String("Ambadas"); // Creates another object in heap memory
		
		if(literal1 == literal2) {
			System.out.println("Literals are equal by equal operator");
		}
		
		if(obj1 == obj2) {
			System.out.println("String objects are equal by equal operator");
		}
		
		if(literal1.equals(literal2)) {
			System.out.println("Literals are equal by equal method");
		}
		
		if(obj1.equals(obj2)) {
			System.out.println("String objects are equal by equal method");
		}

	}

}
