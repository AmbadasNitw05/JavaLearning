package my.learning.test;

public class GcFinalizeExample {

	public static void main(String[] args) {
		GcFinalizeExample example = new GcFinalizeExample();
		System.out.println(example.hashCode());
		example = null;
		System.gc();
		System.out.println("end of garbage collection");
	}
	
	@Override
	protected void finalize() {
		System.out.println("finalize method is called");
	}
}
