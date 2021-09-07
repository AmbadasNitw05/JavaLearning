package my.learning.inheritance;

public class Child extends Parent{

	private int num = 2;
	
	public static void staticMethod() {
		System.out.println("Child staticMethod is called");
	}
	
	public Child() {
		super();
		System.out.println("Child empty constructor is called");
	}
	
	public Child(int num) {
		super(num);
		System.out.println("Child parameterized constructor is called");
	}
	
	public void printParentNum() {
		super.printNum();
	}
	
	private void foo() {
		System.out.println("Child private method");
	}
	
	@Override
	public void printNum() {
		System.out.println("Child num = " + this.num);
	}
}
