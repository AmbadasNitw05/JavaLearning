package my.learning.exception;

public class FinallyExample {

	public int someMethod() {
		try {
			return 1;
		}catch(Exception e) {
			return 999;
		}finally {
			System.out.println("In finally block");
		}
		
	}
	public static void main(String[] args) {
		FinallyExample obj = new FinallyExample();
		System.out.println(obj.someMethod());
	}
}
