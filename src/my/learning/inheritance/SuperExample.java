package my.learning.inheritance;

public class SuperExample {

	public static void main(String[] args) {
		Parent parent1 = new Child();
		Child child2 = new Child(5);
		
		parent1.staticMethod();
		child2.staticMethod();
		

		parent1.printNum();
		
		child2.printParentNum();		
		
	}
}
