package my.learning.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
	public enum Priority {LOW, MEDIUM, HIGH};
	String author() default "Ambadas";
	Priority priority() default Priority.MEDIUM;
	int sequenceNumber();
	String[] supporters();
	Class allowedType() default String.class;
}
