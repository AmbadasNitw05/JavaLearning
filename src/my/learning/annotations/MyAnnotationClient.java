package my.learning.annotations;

public class MyAnnotationClient {

	@MyAnnotation(sequenceNumber=1, supporters={"alok", "akarsh"})
	public void method1(){
		// TBD
	}
	
	@MyAnnotation(sequenceNumber = 2, supporters = { "alok", "akarsh" }, author = "axkota", 
			priority = MyAnnotation.Priority.HIGH, allowedType = Integer.class)
	public void method2() {
		// TBD
	}
}
