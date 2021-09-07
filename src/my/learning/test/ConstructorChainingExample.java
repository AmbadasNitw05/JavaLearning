package my.learning.test;

public class ConstructorChainingExample {
	
	public ConstructorChainingExample() {
		this("Calling parameterized constructor from empty constructor");
	}
	
	public ConstructorChainingExample(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		ConstructorChainingExample obj = new ConstructorChainingExample();

	}

}
