package my.learning.inheritance;

public class Parent {

	private int num = 1;
	
	public static void staticMethod() {
		System.out.println("Parent staticMethod is called");
	}
	
	public Parent(){
		System.out.println("Parent empty constructor is called");
	}
	
	public Parent(int num) {
		System.out.println("Parent parameterized constructor is called");
	}
	
	private void foo() {
		System.out.println("Parent private method");
	}
	
	public void printNum() {
		System.out.println("Parent num = " + this.num);
	}
}
